<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:xd="http://www.oxygenxml.com/ns/doc/xsl" xmlns:do="http://whatever"
                exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>
    <xsl:variable name="newline" select="'&#xA;'"/>
    <xsl:variable name="packageBase" select="'nl/rosa/semanticdatabase/'"/>
    <xsl:variable name="sourceBase" select="'generated_source/main/java/'"/>
    <xsl:variable name="fourSp" select="'    '"/>
    <xsl:variable name="implements" as="xs:string*"
                  select="
            'BMM_MODEL_METADATA',
            'BMM_INSTANTIABLE',
            'BMM_TYPED_FEATURE',
            'BMM_TYPED',
            'EL_AGENT_CALL',
            'P_BMM_PACKAGE_CONTAINER',
            'AUTHORED_RESOURCE',
            'TEST_INTERFACE_1',
            'TEST_ABSTRACT_CHAIN_INTERFACE_5',
            'TEST_ABSTRACT_CHAIN_INTERFACE_6',
            'TEST_CHAIN_INTERFACE_5',
            'TEST_CHAIN_INTERFACE_6'
            "/>
    <xsl:variable name="primitives" select="
            'String'
            "/>


    <xsl:function name="do:proceed">
        <xsl:param name="base" as="xs:string"/>
        <xsl:variable name="package">
            <xsl:element name="package">
                <xsl:element name="packageInfo">
                    <xsl:copy-of
                            select="do:basePackageInfo(document(concat($base, '.html')), concat($packageBase, $base))"/>
                </xsl:element>
                <xsl:element name="packageDirectory">
                    <xsl:value-of select="$base"/>
                </xsl:element>
            </xsl:element>
        </xsl:variable>
        <xsl:for-each select="document(concat($base, '.html'))/html/body[1]/div[2]/div">
            <xsl:call-template name="analyzeClassDocument">
                <xsl:with-param name="context" select="."/>
                <xsl:with-param name="baseDirectory" select="$base"/>
            </xsl:call-template>
        </xsl:for-each>
        <xsl:copy-of select="$package"/>
    </xsl:function>

    <!-- TODO -->
    <!-- constructor, builder -->

    <xsl:template match="/">
        <xsl:variable name="root">
            <xsl:element name="packages">
                <xsl:copy-of select="do:proceed('test')"/>
                <xsl:copy-of select="do:proceed('bmm')"/>
                <xsl:copy-of select="do:proceed('bmm_persistence')"/>
                <xsl:copy-of select="do:proceed('base_types')"/>
                <xsl:copy-of select="do:proceed('foundation_types')"/>
                <xsl:copy-of select="do:proceed('resource')"/>
                <xsl:copy-of select="do:proceed('aom_2')"/>
            </xsl:element>
        </xsl:variable>
        <xsl:variable name="allClasses" as="xs:string*">
            <xsl:for-each select="$root/packages/package">
                <xsl:for-each select="class">
                    <xsl:value-of select="classNameOrgAbstractStripped"/>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <xsl:for-each select="$root/packages/package">
            <xsl:variable name="pd" select="packageDirectory/text()"/>
            <xsl:variable name="package" select="."/>
            <xsl:if test="count(class) > 0">
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/package-info.java">
                    <xsl:copy-of select="packageInfo"/>
                </xsl:result-document>
            </xsl:if>
            <xsl:for-each select="class">
                <xsl:value-of select="do:message(concat('###', ./packageDirectory, '.', ./className))"/>
                <xsl:variable name="includeSequence" as="xs:string*"
                              select="do:getIncludes($root/packages, ., $allClasses)"/>
                <xsl:result-document href="{$sourceBase}{$packageBase}{$pd}/{classFileName}.java">
                    <xsl:choose>
                        <xsl:when test="enumeration = true()">
                            <xsl:value-of select="do:writeEnumeration($root/packages, .)"/>
                        </xsl:when>
                        <xsl:when test="do:is-value-in-sequence(classNameOrgAbstractStripped, $implements)">
                            <xsl:value-of select="do:writeInterface($root/packages, $package, ., $includeSequence)"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="do:writeClass($root/packages, $package, ., $includeSequence)"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:result-document>
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>

    <xsl:function name="do:findClass" as="node()?">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="classToFind" as="xs:string"/>
        <xsl:if test="not(contains($primitives, $classToFind))">
            <xsl:if test="not($packages/package/class[classNameOrgAbstractStripped = $classToFind])">
                <xsl:value-of select="do:message(concat('ERROR:', $classToFind))"/>
            </xsl:if>
            <xsl:copy-of select="$packages/package/class[classNameOrgAbstractStripped = $classToFind]"/>
        </xsl:if>
    </xsl:function>

    <xsl:function name="do:writeClassHeader">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of
                select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('import java.util.Objects;')"/>
        <xsl:if test="count(distinct-values($includeSequence)) > 0">
            <xsl:for-each select="distinct-values($includeSequence)">
                <xsl:variable name="found" select="do:findClass($packages, .)"/>
                <xsl:if test="$found">
                    <xsl:if test="not($found/packageDirectory = $package/packageDirectory)">
                        <xsl:value-of
                                select="do:output(concat('import ', replace($packageBase, '/', '.'), replace($found/packageDirectory, '/', '.'), '.', $found/className, ';'))"/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('#Copyright: Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('#License: See bottom of file')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:variable name="inherit">
            <xsl:choose>
                <xsl:when test="string-length(normalize-space(string-join($class/inherit, ','))) > 0">
                    <xsl:value-of select="concat(' extends ', normalize-space(string-join($class/inherit, ',')))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="''"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:variable name="implements">
            <xsl:choose>
                <xsl:when test="string-length(normalize-space(string-join($class/implement, ','))) > 0">
                    <xsl:value-of select="concat(' implements ', normalize-space(string-join($class/implement, ',')))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="''"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:choose>
            <xsl:when test="$class/abstract = true()">
                <xsl:value-of
                        select="do:output(concat('public abstract class ', $class/className, $inherit, $implements, ' {'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of
                        select="do:output(concat('public class ', $class/className, $inherit, $implements, ' {'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeInterfaceHeader">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of
                select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:if test="count(distinct-values($includeSequence)) > 0">
            <xsl:for-each select="distinct-values($includeSequence)">
                <xsl:variable name="found" select="do:findClass($packages, .)"/>
                <xsl:if test="$found">
                    <xsl:if test="not($found/packageDirectory = $package/packageDirectory)">
                        <xsl:value-of
                                select="do:output(concat('import ', replace($packageBase, '/', '.'), replace($found/packageDirectory, '/', '.'), '.', $found/className, ';'))"/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('#Copyright: Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('#License: See bottom of file')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:variable name="implements">
            <xsl:choose>
                <xsl:when test="string-length(normalize-space(string-join($class/implement, ','))) > 0">
                    <xsl:value-of select="concat(' extends ', normalize-space(string-join($class/implement, ',')))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="''"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="do:output(concat('public interface ', $class/className, $implements, ' {'))"/>
    </xsl:function>

    <xsl:function name="do:writeClassFooter">
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput('***** BEGIN LICENSE BLOCK ***** ')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('ISC License')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('Copyright (c) 2020, Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
                select="do:commentOutput('Permission to use, copy, modify, and/or distribute this software for any')"/>
        <xsl:value-of
                select="do:commentOutput('purpose with or without fee is hereby granted, provided that the above')"/>
        <xsl:value-of select="do:commentOutput('copyright notice and this permission notice appear in all copies.')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
                select="do:commentOutput('THE SOFTWARE IS PROVIDED &quot;AS IS&quot; AND THE AUTHOR DISCLAIMS ALL WARRANTIES')"/>
        <xsl:value-of select="do:commentOutput('WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF')"/>
        <xsl:value-of
                select="do:commentOutput('MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR')"/>
        <xsl:value-of
                select="do:commentOutput('ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES')"/>
        <xsl:value-of
                select="do:commentOutput('WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN')"/>
        <xsl:value-of
                select="do:commentOutput('ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF')"/>
        <xsl:value-of select="do:commentOutput('OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('***** END LICENSE BLOCK *****')"/>
        <xsl:value-of select="do:commentClose()"/>
    </xsl:function>

    <xsl:function name="do:writeInterfaceFooter">
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput('***** BEGIN LICENSE BLOCK ***** ')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('ISC License')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('Copyright (c) 2020, Bert Verhees')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
                select="do:commentOutput('Permission to use, copy, modify, and/or distribute this software for any')"/>
        <xsl:value-of
                select="do:commentOutput('purpose with or without fee is hereby granted, provided that the above')"/>
        <xsl:value-of select="do:commentOutput('copyright notice and this permission notice appear in all copies.')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
                select="do:commentOutput('THE SOFTWARE IS PROVIDED &quot;AS IS&quot; AND THE AUTHOR DISCLAIMS ALL WARRANTIES')"/>
        <xsl:value-of select="do:commentOutput('WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF')"/>
        <xsl:value-of
                select="do:commentOutput('MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR')"/>
        <xsl:value-of
                select="do:commentOutput('ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES')"/>
        <xsl:value-of
                select="do:commentOutput('WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN')"/>
        <xsl:value-of
                select="do:commentOutput('ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF')"/>
        <xsl:value-of select="do:commentOutput('OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('***** END LICENSE BLOCK *****')"/>
        <xsl:value-of select="do:commentClose()"/>
    </xsl:function>

    <xsl:function name="do:writeClassImplementationType">
        <xsl:param name="type" as="xs:string"/>
        <xsl:variable name="implementationType">
            <xsl:choose>
                <xsl:when test="starts-with(lower-case($type), 'list')">
                    <xsl:value-of select="'ArrayList'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'set')">
                    <xsl:value-of select="'HashSet'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'map')">
                    <xsl:value-of select="'HashMap'"/>
                </xsl:when>
                <xsl:when test="starts-with(lower-case($type), 'hash')">
                    <xsl:value-of select="'HashMap'"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$type"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$implementationType"/>
    </xsl:function>

    <xsl:function name="do:writeClassAttribute">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="type" as="xs:string"
                      select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1)"/>
        <xsl:choose>
            <xsl:when
                    test="$nameAndTypeAndKind/container = true() and starts-with($nameAndTypeAndKind/cardinality, '1')">
                <xsl:variable name="implementationType" select="do:writeClassImplementationType($type)"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, 'private ', do:processType($packages, $type), ' ', $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, 'private ', do:processType($packages, $type), ' ', $name, ';'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeComment">
        <xsl:param name="comment" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:if test="not(normalize-space($comment) = '') or not(normalize-space($cardinality) = '')">
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:if test="not(normalize-space($comment) = '')">
                <xsl:value-of select="do:commentOutput($comment)"/>
            </xsl:if>
            <xsl:if test="not(normalize-space($cardinality) = '')">
                <xsl:value-of select="do:commentOutput(concat('cardinality: ', $cardinality))"/>
            </xsl:if>
            <xsl:value-of select="do:commentClose()"/>
        </xsl:if>
    </xsl:function>

    <xsl:function name="do:writeClassConstants">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, '')"/>
        <xsl:variable name="type" as="xs:string"
                      select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'final ', $type, ' ', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ' = ', $nameAndTypeAndKind/value, ';'))"/>
    </xsl:function>

    <xsl:function name="do:writeInterfaceConstants">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, '')"/>
        <xsl:variable name="type" as="xs:string"
                      select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $type, ' ', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ' = ', $nameAndTypeAndKind/value, ';'))"/>
    </xsl:function>

    <xsl:function name="do:writeClassFunctions">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="parameters" as="xs:string*">
            <xsl:for-each select="$nameAndTypeAndKind/parameters/parameter">
                <xsl:variable name="par-type" as="xs:string"
                              select="string-join(do:processType($packages, type/type-name))"/>
                <xsl:value-of select="concat($par-type, ' ', name)"/>
            </xsl:for-each>
        </xsl:variable>
        <xsl:choose>
            <xsl:when test="$nameAndTypeAndKind/kind = 'void-function'">
                <xsl:choose>
                    <xsl:when test="$nameAndTypeAndKind/abstract/text() = 'true'">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, concat('public abstract void  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ');')))"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, concat('public void  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ') {')))"/>
                        <xsl:for-each select="$nameAndTypeAndKind/parameters/parameter">
                            <xsl:if test="starts-with(type/type-cardinality, '1')">
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', name, ' == null ) {'))"/>
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot;Parameter ', name, ' has cardinality NonNull, but is null&quot;);'))"/>
                                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                            </xsl:if>
                        </xsl:for-each>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:when>
            <xsl:otherwise>
                <xsl:variable name="type" as="xs:string"
                              select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
                <xsl:choose>
                    <xsl:when test="$nameAndTypeAndKind/abstract/text() = 'true'">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, 'public abstract ', $type, '  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ');'))"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, 'public ', $type, '  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ') {'))"/>
                        <xsl:for-each select="$nameAndTypeAndKind/parameters/parameter">
                            <xsl:if test="starts-with(type/type-cardinality, '1')">
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', name, ' == null ) {'))"/>
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot;Parameter ', name, ' has cardinality NonNull, but is null.&quot;);'))"/>
                                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                            </xsl:if>
                        </xsl:for-each>

                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $type, '  result = null;'))"/>
                        <xsl:value-of select="do:output('')"/>
                        <xsl:value-of select="do:output('')"/>
                        <xsl:if test="starts-with($nameAndTypeAndKind/cardinality, '1')">
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, 'if ( result  == null ) {'))"/>
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot;Return-value has cardinality NonNull, but is null.&quot;);'))"/>
                            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                        </xsl:if>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return  result', ';'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeInterfaceFunctions">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="parameters" as="xs:string*">
            <xsl:for-each select="$nameAndTypeAndKind/parameters/parameter">
                <xsl:variable name="par-type" as="xs:string"
                              select="string-join(do:processType($packages, type/type-name))"/>
                <xsl:value-of select="concat($par-type, ' ', name)"/>
            </xsl:for-each>
        </xsl:variable>
        <xsl:choose>
            <xsl:when test="$nameAndTypeAndKind/kind = 'void-function'">
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, concat('public void  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ');')))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:variable name="type" as="xs:string"
                              select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, 'public ', $type, '  ', $nameAndTypeAndKind/name, '(', string-join($parameters, ', '), ');'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeClassPojos">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:param name="class"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="type" as="xs:string"
                      select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:choose>
            <xsl:when test="starts-with($type, 'List') or starts-with($type, 'Set')">
                <xsl:value-of
                        select="do:writeClassListPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType, $class)"
                />
            </xsl:when>
            <xsl:when test="starts-with($type, 'Map')">
                <xsl:value-of
                        select="do:writeClassMapPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType, $class)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, concat('public ', $type, ' get', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '() {')))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, 'return ', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ';'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, concat('public void set', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '(', $type, ' value) {')))"/>
                <xsl:if test="starts-with($nameAndTypeAndKind/cardinality, '1')">
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if ( value == null ) {'))"/>
                    <xsl:value-of
                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; Setting property:', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ' failed, it has cardinality NonNull, but is null&quot;);'))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                </xsl:if>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), ' = value;'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeInterfacePojos">
        <xsl:param name="nameAndTypeAndKind" as="node()"/>
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:value-of select="do:writeComment($nameAndTypeAndKind/description, $nameAndTypeAndKind/cardinality)"/>
        <xsl:variable name="type" as="xs:string"
                      select="string-join(do:processType($packages, $nameAndTypeAndKind/type))"/>
        <xsl:choose>
            <xsl:when test="starts-with($type, 'List') or starts-with($type, 'Set')">
                <xsl:value-of
                        select="do:writeInterfaceListPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType)"/>
            </xsl:when>
            <xsl:when test="starts-with($type, 'Map')">
                <xsl:value-of
                        select="do:writeInterfaceMapPojo($packages, $type, do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 1), $nameAndTypeAndKind/cardinality, $implementationType)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, concat($type, ' get', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '();')))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, concat('void set', do:snakeUpperCaseToCamelCase($nameAndTypeAndKind/name, 0), '(', $type, ' value);')))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeClassMapPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:param name="class"/>
        <xsl:variable name="types" as="xs:string*"
                      select="tokenize(substring-before(substring-after($type, '&lt;'), '&gt;'), ',')"/>
        <xsl:variable name="keyType" as="xs:string" select="do:processType($packages, normalize-space($types[1]))"/>
        <xsl:variable name="valueType" as="xs:string" select="do:processType($packages, normalize-space($types[2]))"/>
        <xsl:variable name="processedType" as="xs:string"
                      select="concat(substring-before($type, '&lt;'), '&lt;', $keyType, ', ', $valueType, '&gt;')"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, -1)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string">
            <xsl:choose>
                <xsl:when test="ends-with($name, 's')">
                    <xsl:value-of
                            select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), -1)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(replace($name, 'ie', 'y'), -1)"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- PUT item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void put', $singleAttributeNameInFunction, '(', $keyType, ' key, ', $valueType, ' value ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of
                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $name, '.put( key, value);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- PUT items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void put', $attributeNameInFunction, '(', do:processType($packages, $type), ' items ) {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'items.keySet().forEach(key -&gt; put', do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0), '(key, items.get(key)));'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- GET item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public ', $valueType, ' get', $singleAttributeNameInFunction, '(', $keyType, ' key ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'return null;'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return ', $name, '.get( key);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- REMOVE item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void remove', $singleAttributeNameInFunction, '(', $keyType, ' key ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' != null ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, '.remove(key);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- REMOVE items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void remove', $attributeNameInFunction, '( Collection &lt;', $keyType, '&gt; keys ) {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'keys.forEach(this::remove', $singleAttributeNameInFunction, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public ', $processedType, ' get', $attributeNameInFunction, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this.', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public ', $class/className, ' set', $attributeNameInFunction, '(', $processedType, ' ', $name, ') {'))"/>
        <xsl:if test="starts-with($cardinality, '1')">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of
                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; ', $name, ' has cardinality NonNull, but is null&quot;);'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this;'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', $processedType, ' ', $name, '() {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'return Collections.unmodifiableMap(this.', $name, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
    </xsl:function>

    <xsl:function name="do:writeInterfaceMapPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:variable name="types" as="xs:string*"
                      select="tokenize(substring-before(substring-after($type, '&lt;'), '&gt;'), ',')"/>
        <xsl:variable name="processedType" as="xs:string" select="do:processType($packages, $type)"/>
        <xsl:variable name="keyType" as="xs:string" select="do:processType($packages, normalize-space($types[1]))"/>
        <xsl:variable name="valueType" as="xs:string" select="do:processType($packages, normalize-space($types[2]))"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, -1)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string">
            <xsl:choose>
                <xsl:when test="ends-with($name, 's')">
                    <xsl:value-of
                            select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), -1)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(replace($name, 'ie', 'y'), -1)"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- PUT item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void put', $singleAttributeNameInFunction, '(', $keyType, ' key, ', $valueType, ' value );'))"/>
        <!-- PUT items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void put', $attributeNameInFunction, '(', do:processType($packages, $type), ' items );'))"/>
        <!-- GET item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $valueType, ' get', $singleAttributeNameInFunction, '(', $keyType, ' key );'))"/>
        <!-- REMOVE item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void remove', $singleAttributeNameInFunction, '(', $keyType, ' key );'))"/>
        <!-- REMOVE items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void remove', $attributeNameInFunction, '( Collection &lt;', $keyType, '&gt; keys );'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $processedType, ' get', $attributeNameInFunction, '();'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void set', $attributeNameInFunction, '(', $processedType, ' ', $name, ');'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $processedType, ' ', $name, '();'))"/>
    </xsl:function>

    <xsl:function name="do:writeClassListPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:param name="class"/>
        <xsl:variable name="processedType" as="xs:string"
                      select="do:processType($packages, substring-before(substring-after($type, '&lt;'), '&gt;'))"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, -1)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string">
            <xsl:choose>
                <xsl:when test="ends-with($name, 's')">
                    <xsl:value-of
                            select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), -1)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(replace($name, 'ie', 'y'), -1)"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- ADD item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void addTo', $singleAttributeNameInFunction, '(', $processedType, ' value ) {'))"/>
        <xsl:if test="not(starts-with($cardinality, '1'))">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of
                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, ' = new ', $implementationType, '&lt;&gt; ();'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $name, '.add( value);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- ADD items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void addTo', $attributeNameInFunction, '(', do:processType($packages, $type), ' values ) {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'values.forEach(value -&gt; addTo', do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), 0), '(value));'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- REMOVE item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void removeFrom', $singleAttributeNameInFunction, '(', $processedType, ' item ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' != null ) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, '.remove(item);'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- REMOVE items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public void removeFrom', $attributeNameInFunction, '( Collection &lt;', $processedType, '&gt; values ) {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'values.forEach(this::removeFrom', $singleAttributeNameInFunction, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, do:processType($packages, $type), ' get', $attributeNameInFunction, '() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this.', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public ', $class/className, ' set', $attributeNameInFunction, '(', do:processType($packages, $type), ' ', $name, ') {'))"/>
        <xsl:if test="starts-with($cardinality, '1')">
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (', $name, ' == null ) {'))"/>
            <xsl:value-of
                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot; ', $name, ' has cardinality NonNull, but is null&quot;);'))"/>
            <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
        </xsl:if>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return this;'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'public ', do:processType($packages, $type), ' ', $name, '() {'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'return Collections.unmodifiable', substring-before(do:processType($packages, $type), '&lt;'), '(this.', $name, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
    </xsl:function>

    <xsl:function name="do:writeInterfaceListPojo">
        <xsl:param name="packages"/>
        <xsl:param name="type" as="xs:string"/>
        <xsl:param name="name" as="xs:string"/>
        <xsl:param name="cardinality" as="xs:string"/>
        <xsl:param name="implementationType" as="xs:string"/>
        <xsl:variable name="processedType" as="xs:string"
                      select="do:processType($packages, substring-before(substring-after($type, '&lt;'), '&gt;'))"/>
        <xsl:variable name="attributeNameInFunction" as="xs:string" select="do:snakeUpperCaseToCamelCase($name, -1)"/>
        <xsl:variable name="singleAttributeNameInFunction" as="xs:string">
            <xsl:choose>
                <xsl:when test="ends-with($name, 's')">
                    <xsl:value-of
                            select="do:snakeUpperCaseToCamelCase(replace(substring($name, 0, string-length($name)), 'ie', 'y'), -1)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(replace($name, 'ie', 'y'), -1)"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="do:output($fourSp)"/>
        <!-- ADD item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void addTo', $singleAttributeNameInFunction, '(', $processedType, ' value );'))"/>
        <!-- ADD items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void addTo', $attributeNameInFunction, '(', do:processType($packages, $type), ' values );'))"/>
        <!-- REMOVE item -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void removeFrom', $singleAttributeNameInFunction, '(', $processedType, ' item );'))"/>
        <!-- REMOVE items -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void removeFrom', $attributeNameInFunction, '( Collection &lt;', $processedType, '&gt; values );'))"/>
        <!-- GETTER/SETTER -->
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $processedType, ' get', $attributeNameInFunction, '();'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, 'void set', $attributeNameInFunction, '(', $processedType, ' ', $name, ');'))"/>
        <!-- GETTER unmodifiable -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, do:processType($packages, $type), ' ', $name, '();'))"/>
    </xsl:function>

    <xsl:function name="do:writeClassProperties">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <!-- If inherit do recursion -->
        <xsl:variable name="result">
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'attribute']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:outputSpaces(concat('    //***** ', $class/className, ' *****'))"/>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * FIELDS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'attribute'">
                        <xsl:value-of select="do:writeClassAttribute(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * POJOS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'attribute'">
                        <xsl:variable name="implementationType" select="do:writeClassImplementationType(type)"/>
                        <xsl:value-of select="do:writeClassPojos(., $packages, $implementationType, $class)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'void-function' or kind = 'value-function']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * FUNCTIONS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                        <xsl:value-of select="do:writeClassFunctions(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'constant']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * CONSTANTS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'constant'">
                        <xsl:value-of select="do:writeClassConstants(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
        </xsl:variable>
        <xsl:value-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:writeInterfaceProperties">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <!-- If inherit do recursion -->
        <xsl:variable name="result">
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'attribute']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * POJOS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'attribute'">
                        <xsl:variable name="implementationType" select="do:writeClassImplementationType(type)"/>
                        <xsl:value-of select="do:writeInterfacePojos(., $packages, $implementationType)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'void-function' or kind = 'value-function']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * FUNCTIONS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                        <xsl:value-of select="do:writeInterfaceFunctions(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
            <xsl:if test="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'constant']/*) > 0">
                <xsl:value-of select="do:output('')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:value-of select="do:output('/* * CONSTANTS * */')"/>
                <xsl:value-of select="do:output('/*=========================================================*/')"/>
                <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="kind = 'constant'">
                        <xsl:value-of select="do:writeInterfaceConstants(., $packages)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:if>
        </xsl:variable>
        <xsl:value-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:writeClass">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of select="do:writeClassHeader($packages, $package, $class, $includeSequence)"/>
        <xsl:variable name="classes" select="do:getClassesFromInterfaceChains($packages, $class)"/>
        <xsl:if test="count($classes) > 0">
            <xsl:for-each select="$classes">
                <xsl:value-of select="do:writeClassProperties($packages, .)"/>
            </xsl:for-each>
        </xsl:if>
        <xsl:value-of
                select="do:writeClassConstructorAndBuild($packages, do:getClassFieldsInheritedInterfaced($packages, $class), $class)"/>
        <xsl:value-of select="do:writeClassToStringAndHashCode($packages, $class)"/>
        <xsl:value-of select="do:writeClassFooter()"/>
    </xsl:function>

    <xsl:function name="do:getClassesFromInheritedChains" as="node()*">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:variable name="result" as="node()*">
            <xsl:copy-of select="$class"/>
            <xsl:for-each select="$class/inheritOrg">
                <xsl:if test="not(contains($primitives, .))">
                    <xsl:variable name="inheritedClass" as="node()" select="do:findClass($packages, .)"/>
                    <xsl:if test="$inheritedClass">
                        <xsl:copy-of select="do:getClassesFromInheritedChains($packages, $inheritedClass)"/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:copy-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:getClassesFromInterfaceInheritedChains" as="node()*">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:variable name="result" as="node()*">
            <xsl:copy-of select="$class"/>
            <xsl:variable name="interfacedClasses">
                <xsl:for-each select="$class/implementOrg">
                    <xsl:variable name="interfacedClasses" as="node()" select="do:findClass($packages, .)"/>
                    <xsl:if test="$interfacedClasses">
                        <xsl:copy-of select="do:getClassesFromInterfaceChains($packages, $interfacedClasses)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:variable>
            <xsl:copy-of select="$interfacedClasses"/>
            <xsl:for-each select="$class/inheritOrg">
                <xsl:message>
                    <xsl:value-of select="concat('--------------------------', .)"/>
                </xsl:message>
                <xsl:if test="not(contains($primitives, .))">
                    <xsl:variable name="inheritedClasses" as="node()" select="do:findClass($packages, .)"/>
                    <xsl:if test="$inheritedClasses">
                        <xsl:copy-of select="do:getClassesFromInheritedChains($packages, $inheritedClasses)"/>
                    </xsl:if>
                    <xsl:copy-of select="$inheritedClasses"/>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:copy-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:getClassesFromInterfaceChains" as="node()*">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:variable name="result" as="node()*">
            <xsl:copy-of select="$class"/>
            <xsl:for-each select="$class/implementOrg">
                <xsl:variable name="inheritedClass" as="node()" select="do:findClass($packages, .)"/>
                <xsl:if test="$inheritedClass">
                    <xsl:copy-of select="do:getClassesFromInterfaceChains($packages, $inheritedClass)"/>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:copy-of select="$result"/>
    </xsl:function>


    <!-- Call constructor -->
    <!-- Write constructor -->
    <xsl:function name="do:writeClassConstructorAndBuild">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="nameAndTypeAndKind" as="node()*"/>
        <xsl:param name="class" as="node()"/>
        <!-- LOCALFIELD only for this class and interfaces of this class (for constructor locals (except parent)) -->
        <xsl:variable name="localFields" as="node()*">
            <xsl:for-each select="do:getClassesFromInterfaceChains($packages, $class)">
                <xsl:for-each select="functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="not(name = '') and kind = 'attribute'">
                        <xsl:copy-of select="."/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <xsl:value-of
                select="do:message(concat('Class:', $class/className, ' LocalFields:', string-join($localFields/name, ', ')))"/>
        <!-- ALLFIELDS, with interfaces and inheritance and interfaces of inheritance (for constructor parameters) -->
        <xsl:variable name="allFields" as="node()*">
            <xsl:for-each select="do:getClassesFromInheritedChains($packages, $class)">
                <xsl:variable name="inherited">
                    <xsl:for-each select="functionsAndAttributesAndConstants/nameAndTypeAndKind">
                        <xsl:if test="not(name = '') and kind = 'attribute'">
                            <xsl:copy-of select="."/>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:variable>
                <xsl:copy-of select="$inherited"/>
                <xsl:for-each select="do:getClassesFromInterfaceChains($packages, .)">
                    <xsl:for-each select="functionsAndAttributesAndConstants/nameAndTypeAndKind">
                        <xsl:if test="not(name = '') and kind = 'attribute'">
                            <xsl:if test="not(contains(string-join($inherited/name), name))">
                                <xsl:copy-of select="."/>
                            </xsl:if>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <xsl:variable name="allFieldsName" as="xs:string*">
            <xsl:for-each select="$allFields">
                <xsl:if test="not(name = '') and kind = 'attribute'">
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:variable name="allFieldsNameAndType" as="xs:string*">
            <xsl:for-each select="$allFields">
                <xsl:if test="not(name = '') and kind = 'attribute'">
                    <xsl:value-of
                            select="concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1))"/>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:value-of
                select="do:message(concat('Class:', $class/className, ' AllFields:', string-join($allFields/name, ', ')))"/>
        <!-- INHERITEDFIELDS and interfaces (for parent-call) -->
        <xsl:variable name="inheritedFields" as="node()*">
            <xsl:for-each select="$allFields">
                <xsl:if test="not(name = '') and kind = 'attribute'">
                    <xsl:if test="not(contains(string-join($localFields/name), name))">
                        <xsl:copy-of select="."/>
                    </xsl:if>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:variable name="inheritedFieldsName" as="xs:string*">
            <xsl:for-each select="$inheritedFields">
                <xsl:if test="not(name = '') and kind = 'attribute'">
                    <xsl:value-of select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                </xsl:if>
            </xsl:for-each>
        </xsl:variable>
        <xsl:value-of
                select="do:message(concat('Class:', $class/className, ' InheritedFields:', string-join($inheritedFields/name, ', ')))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:outputSpaces(concat('    //***** ', $class/className, ' *****'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/*=========================================================*/')"/>
        <xsl:value-of select="do:output('/* * BUILD PATTERN AND CONSTRUCTOR * */')"/>
        <xsl:value-of select="do:output('/*=========================================================*/')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'protected ', $class/className, '() {}'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:choose>
            <xsl:when test="$class/abstract = true()">
                <!-- PROTECTED CONSTRUCTOR -->
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'protected ', $class/className, '('))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, string-join($allFieldsNameAndType, concat(',', $newline, $fourSp, $fourSp, $fourSp))))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '){'))"/>
                <xsl:if test="count($inheritedFieldsName) > 0">
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'super( '))"/>
                    <xsl:value-of
                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, string-join($inheritedFieldsName, concat(',', $newline, $fourSp, $fourSp, $fourSp))))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, ');'))"/>
                </xsl:if>
                <xsl:for-each select="$localFields">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:if test="not(name = '') and starts-with(cardinality, '1')">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, 'if ( ', $name, ' == null ) {'))"/>
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot;Property:', $name, ' has cardinality NonNull, but is null&quot;);'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:for-each select="$localFields">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:if test="not(name = '')">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of select="do:output('')"/>
            </xsl:when>
            <xsl:otherwise>
                <!-- PUBLIC CONSTRUCTOR -->
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public ', $class/className, '('))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, string-join($allFieldsNameAndType, concat(',', $newline, $fourSp, $fourSp, $fourSp))))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '){'))"/>
                <xsl:if test="count($inheritedFieldsName) > 0">
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'super( '))"/>
                    <xsl:value-of
                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, string-join($inheritedFieldsName, concat(',', $newline, $fourSp, $fourSp, $fourSp))))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, ');'))"/>
                </xsl:if>
                <xsl:for-each select="$localFields">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:if test="not(name = '') and starts-with(cardinality, '1')">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, 'if ( ', $name, ' == null ) {'))"/>
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'throw new NullPointerException(&quot;Property:', $name, ' has cardinality NonNull, but is null&quot;);'))"/>
                        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:for-each select="$localFields">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:if test="not(name = '')">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of select="do:output('')"/>
                <!-- PRIVATE CONSTRUCTOR -->
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, 'private ', $class/className, '(Builder builder) {'))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp,$fourSp, 'this('))"/>
                <xsl:variable name="numberOfRequired"
                              select="count($allFields[not(replace(do:snakeUpperCaseToCamelCase(name, 1), ' ', '') = '')])"/>
                <xsl:for-each select="$allFields[not(replace(do:snakeUpperCaseToCamelCase(name, 1), ' ', '') = '')]">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:choose>
                        <xsl:when test="position() &lt; $numberOfRequired">
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'builder.', $name, ','))"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'builder.', $name))"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp,$fourSp, ');'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of select="do:output('')"/>
                <!-- BUILDER CLASS -->
                <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public static class Builder {'))"/>
                <!-- BUILDER CLASS FIELDS -->
                <xsl:for-each select="$allFields">
                    <xsl:variable name="nameAndType"
                                  select="concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1))"/>
                    <xsl:if test="not(replace($nameAndType, ' ', '') = '')">
                        <xsl:choose>
                            <xsl:when test="starts-with(cardinality, '1')">
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, 'private final ', $nameAndType, ';  //required'))"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of
                                        select="do:outputSpaces(concat($fourSp, $fourSp, 'private ', $nameAndType, ';'))"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:output('')"/>
                <!-- BUILDER CLASS CONSTRUCTOR -->
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'public Builder ('))"/>
                <xsl:for-each
                        select="$allFields[starts-with(cardinality, '1') and not(replace(concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1)), ' ', '') = '')]">
                    <xsl:variable name="nameAndType"
                                  select="concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1))"/>
                    <xsl:variable name="numberOfRequired"
                                  select="count($allFields[starts-with(cardinality, '1') and not(replace($nameAndType, ' ', '') = '')])"/>
                    <xsl:if test="not(replace($nameAndType, ' ', '') = '')">
                        <xsl:if test="starts-with(cardinality, '1')">
                            <xsl:choose>
                                <xsl:when test="position() &lt; $numberOfRequired">
                                    <xsl:value-of
                                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $nameAndType, ','))"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:value-of
                                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $nameAndType))"/>
                                </xsl:otherwise>
                            </xsl:choose>
                        </xsl:if>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '){'))"/>
                <xsl:for-each
                        select="$allFields[starts-with(cardinality, '1') and not(replace(concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1)), ' ', '') = '')]">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:if test="not($name = '')">
                        <xsl:value-of
                                select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'this.', $name, ' = ', $name, ';'))"/>
                    </xsl:if>
                </xsl:for-each>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                <xsl:value-of select="do:output('')"/>
                <!-- BUILDER SETTERS -->
                <xsl:for-each
                        select="$allFields[not(starts-with(cardinality, '1')) and not(replace(concat(do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' ', do:snakeUpperCaseToCamelCase(name, 1)), ' ', '') = '')]">
                    <xsl:value-of
                            select="do:outputSpaces(concat($fourSp, $fourSp, concat('public Builder set', do:snakeUpperCaseToCamelCase(name, 0), '(', do:processType($packages, do:snakeUpperCaseToCamelCase(type, 0)), ' value) {')))"/>
                    <xsl:value-of
                            select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'this.', do:snakeUpperCaseToCamelCase(name, 1), ' = value;'))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'return this;'))"/>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                    <xsl:value-of select="do:output('')"/>
                </xsl:for-each>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, 'public ', $class/className, ' build(){'))"/>
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'return new ', $class/className, '( this );'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, '}'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
                <xsl:value-of select="do:output('')"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

    <xsl:function name="do:writeClassToStringAndHashCode">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:outputSpaces(concat('    //***** ', $class/className, ' *****'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('/*=========================================================*/')"/>
        <xsl:value-of select="do:output('/* * TOSTRING, EQUALS AND HASHCODE * */')"/>
        <xsl:value-of select="do:output('/*=========================================================*/')"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('')"/>
        <!-- LOCALFIELD only for this class and interfaces of this class (for constructor locals (except parent)) -->
        <xsl:variable name="localFields" as="node()*">
            <xsl:for-each select="do:getClassesFromInterfaceChains($packages, $class)">
                <xsl:for-each select="functionsAndAttributesAndConstants/nameAndTypeAndKind">
                    <xsl:if test="not(name = '') and kind = 'attribute'">
                        <xsl:copy-of select="."/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:for-each>
        </xsl:variable>
        <!-- EQUALS -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public boolean equals(Object object) {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (this == object) return true;'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, 'if (object == null || getClass() != object.getClass()) return false;'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'if (!super.equals(object)) return false;'))"/>
        <xsl:choose>
            <xsl:when test="count($localFields) > 0">
                <xsl:value-of
                        select="do:outputSpaces(concat($fourSp, $fourSp, $class/className, ' that = (', $class/className, ') object;'))"/>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return'))"/>
                <xsl:for-each select="$localFields">
                    <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
                    <xsl:choose>
                        <xsl:when test="position() &lt; count($localFields)">
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'java.util.Objects.equals(',$name,', that.',$name,') &amp;&amp;'))"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of
                                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'java.util.Objects.equals(', $name, ', that.', $name, ');'))"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return true;'))"/>
            </xsl:otherwise>
        </xsl:choose>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output('')"/>
        <!-- HASHCODE -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public int hashCode() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return Objects.hash('))"/>
        <xsl:choose>
            <xsl:when test="count($localFields) > 0">
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'super.hashCode(),'))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, 'super.hashCode()'))"/>
            </xsl:otherwise>
        </xsl:choose>

        <xsl:for-each select="$localFields">
            <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
            <xsl:choose>
                <xsl:when test="position() &lt; count($localFields)">
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name, ','))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $name))"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:for-each>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, ');'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
        <xsl:value-of select="do:output('')"/>
        <!-- TOSTRING -->
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '@java.lang.Override'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, 'public java.lang.String toString() {'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, 'return'))"/>
        <xsl:value-of
                select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, '&quot;', $class/className, ' {&quot; +'))"/>
        <xsl:variable name="apos">'</xsl:variable>
        <xsl:for-each select="$localFields">
            <xsl:variable name="name" select="do:snakeUpperCaseToCamelCase(name, 1)"/>
            <xsl:value-of
                    select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, '&quot;', $name, '=', $apos, '&quot; + ', $name, ' + ', $apos, '\', $apos, $apos, ' +'))"/>
        </xsl:for-each>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, $fourSp, $fourSp, $apos, '}', $apos, ';'))"/>
        <xsl:value-of select="do:outputSpaces(concat($fourSp, '}'))"/>
    </xsl:function>

    <xsl:function name="do:getClassFieldsInheritedInterfaced">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:variable name="fields" as="node()*">
            <xsl:variable name="classes" select="do:getClassesFromInheritedChains($packages, $class)"/>
            <xsl:if test="count($classes) > 0">
                <xsl:for-each select="$classes">
                    <xsl:variable name="interfaced" select="do:getClassesFromInterfaceInheritedChains($packages, .)"/>
                    <xsl:for-each select="$interfaced">
                        <xsl:if test="count(functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'attribute']) > 0">
                            <xsl:for-each
                                    select="./functionsAndAttributesAndConstants/nameAndTypeAndKind[kind = 'attribute']">
                                <xsl:copy-of select="."/>
                            </xsl:for-each>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:for-each>
            </xsl:if>
        </xsl:variable>
        <xsl:copy-of select="$fields"/>
    </xsl:function>

    <xsl:function name="do:writeInterface">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="includeSequence" as="xs:string*"/>
        <xsl:value-of select="do:writeInterfaceHeader($packages, $package, $class, $includeSequence)"/>
        <xsl:value-of select="do:writeInterfaceProperties($packages, $class)"/>
        <xsl:value-of select="do:writeInterfaceFooter()"/>
    </xsl:function>

    <xsl:function name="do:writeEnumeration">
        <xsl:param name="package" as="node()"/>
        <xsl:param name="class" as="node()"/>
        <xsl:value-of
                select="do:output(concat('package ', replace(concat($packageBase, $package/packageDirectory), '/', '.'), ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat('#Generated: ', current-dateTime()))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput($class/classComment)"/>
        <xsl:value-of select="do:commentClose()"/>
        <xsl:value-of select="do:output(concat('public enum ', $class/className, ' {'))"/>
        <xsl:variable name="count" select="count($class/functionsAndAttributesAndConstants/nameAndTypeAndKind)"/>
        <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
            <xsl:value-of select="do:output('')"/>
            <xsl:value-of select="do:commentOpen()"/>
            <xsl:value-of select="do:commentOutput(description)"/>
            <xsl:value-of select="do:commentClose()"/>
            <xsl:choose>
                <xsl:when test="position() &lt; $count">
                    <xsl:value-of select="do:outputSpaces(concat('    ', enumType, ','))"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="do:outputSpaces(concat('    ', enumType))"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:for-each>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:output('}')"/>
    </xsl:function>

    <xsl:function name="do:createFieldDeclaration">
        <xsl:param name="packages" as="node()"/>
        <xsl:param name="context" as="node()"/>
        <xsl:param name="incomingString"/>
        <xsl:value-of
                select="concat(do:processType($packages, $incomingString), ' ', do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString, ':')[1]), 1), '();')"/>
    </xsl:function>

    <xsl:function name="do:processType">
        <xsl:param name="packages"/>
        <xsl:param name="incomingString" as="xs:string"/>
        <xsl:variable name="result">
            <xsl:choose>
                <xsl:when test="$packages/package/class[classNameOrgAbstractStripped = $incomingString]/className">
                    <xsl:value-of
                            select="$packages/package/class[classNameOrgAbstractStripped = $incomingString]/className"/>
                </xsl:when>
                <xsl:when test="$incomingString = 'Any'">
                    <xsl:value-of select="'Object'"/>
                </xsl:when>
                <xsl:when test="contains($incomingString, '&lt;')">
                    <xsl:variable name="type">
                        <xsl:choose>
                            <xsl:when test="starts-with(lower-case($incomingString), 'hash')">
                                <xsl:value-of select="'Map'"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of select="substring-before($incomingString, '&lt;')"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:variable>
                    <xsl:variable name="types" as="xs:string*"
                                  select="tokenize(substring-before(substring-after($incomingString, '&lt;'), '&gt;'), ',')"/>
                    <xsl:variable name="newTypes">
                        <xsl:for-each select="$types">
                            <xsl:variable name="testType" select="."/>
                            <xsl:variable name="newType">
                                <xsl:value-of select="do:processType($packages, $testType)"/>
                            </xsl:variable>
                            <xsl:if test="position() > 1">
                                <xsl:value-of select="','"/>
                            </xsl:if>
                            <xsl:value-of select="$newType"/>
                        </xsl:for-each>
                    </xsl:variable>
                    <xsl:value-of select="concat($type, '&lt;', $newTypes, '&gt;')"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$incomingString"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:variable>
        <xsl:value-of select="$result"/>
    </xsl:function>

    <xsl:function name="do:enumItem">
        <xsl:param name="incomingString"/>
        <xsl:value-of select="do:snakeUpperCaseToCamelCase(normalize-space(tokenize($incomingString, ':')[1]), 1)"/>
    </xsl:function>

    <xsl:template name="analyzeClassDocument">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="baseDirectory"/>
        <xsl:variable name="tag" select="substring-after(string($context/h2[1]/a[1]/@href), '#_')"/>
        <xsl:variable name="packageName" select="$tag"/>
        <xsl:if test="not($packageName = '')">
            <xsl:variable name="package">
                <xsl:element name="package">
                    <xsl:variable name="packageDirectory" select="concat($baseDirectory, '/', $packageName)"/>
                    <xsl:element name="packageInfo">
                        <xsl:value-of
                                select="do:output(concat('package ', replace(concat($packageBase, $packageDirectory), '/', '.'), ';'))"/>
                        <xsl:value-of select="do:commentOpen()"/>
                        <xsl:value-of select="do:commentOutput('')"/>
                        <xsl:value-of select="do:commentOutput($context/h2[1])"/>
                        <xsl:for-each select="$context/div/div">
                            <xsl:value-of select="do:commentOutput(h3)"/>
                            <xsl:value-of select="do:commentOutput(./div/p)"/>
                            <xsl:for-each select="div/dl/*">
                                <xsl:value-of select="do:commentOutput(.)"/>
                            </xsl:for-each>
                            <xsl:for-each select="./div">
                                <xsl:value-of select="do:commentOutput(h4)"/>
                                <xsl:value-of select="do:commentOutput(./div)"/>
                            </xsl:for-each>
                        </xsl:for-each>
                        <xsl:value-of select="do:commentClose()"/>
                    </xsl:element>
                    <xsl:element name="packageDirectory">
                        <xsl:value-of select="$packageDirectory"/>
                    </xsl:element>
                    <xsl:for-each
                            select="$context/descendant-or-self::*/table[@class = 'tableblock frame-all grid-all stretch']">
                        <xsl:variable name="className"
                                      select="normalize-space(string-join(tbody/tr[1]/th[2]/p/strong))"/>
                        <xsl:if test="string-length($className) > 0">
                            <xsl:variable name="class">
                                <xsl:element name="class">
                                    <xsl:element name="packageDirectory">
                                        <xsl:value-of select="$packageDirectory"/>
                                    </xsl:element>
                                    <xsl:element name="includes"/>
                                    <xsl:value-of select="do:message($className)"/>
                                    <!-- Check abstract by scanning for word abstract -->
                                    <xsl:element name="abstract">
                                        <xsl:value-of
                                                select="do:message(concat('    abstr:', contains(tbody/tr[1]/th[2]/p/strong, '(abstract)')))"/>
                                        <xsl:value-of select="contains(tbody/tr[1]/th[2]/p/strong, '(abstract)')"/>
                                    </xsl:element>
                                    <!-- check enumaration for checking the word enumeration -->
                                    <xsl:element name="enumeration">
                                        <xsl:value-of
                                                select="do:message(concat('    enum:', normalize-space(tbody/tr[1]/th[1]/p/strong/text()[1]) = 'Enumeration'))"/>
                                        <xsl:value-of
                                                select="normalize-space(tbody/tr[1]/th[1]/p/strong/text()[1]) = 'Enumeration'"/>
                                    </xsl:element>
                                    <!-- NormalClassName -->
                                    <xsl:element name="className">
                                        <xsl:value-of
                                                select="tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1]"/>
                                    </xsl:element>
                                    <!-- NormalClassName with generic-parameters stripped -->
                                    <xsl:element name="classFileName">
                                        <xsl:value-of
                                                select="do:message(concat('    filename:', tokenize(tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1], '&lt;')[1]))"/>
                                        <xsl:value-of
                                                select="tokenize(tokenize(do:snakeUpperCaseToCamelCase($className, 0), ' ')[1], '&lt;')[1]"/>
                                    </xsl:element>
                                    <!-- UPPERCASE_UNDERSCORE_CLASSNAME (abstract) -->
                                    <xsl:element name="classNameOrg">
                                        <xsl:value-of select="do:message(concat('    classNameOrg:', $className))"/>
                                        <xsl:value-of select="$className"/>
                                    </xsl:element>
                                    <!-- UPPERCASE_UNDERSCORE_CLASSNAME -->
                                    <xsl:element name="classNameOrgAbstractStripped">
                                        <xsl:variable name="classNameOrgAbstractStripped" as="xs:string">
                                            <xsl:choose>
                                                <xsl:when test="contains($className, '(')">
                                                    <xsl:value-of
                                                            select="normalize-space(tokenize($className, '\(')[1])"/>
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    <xsl:value-of select="$className"/>
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </xsl:variable>
                                        <xsl:value-of
                                                select="do:message(concat('    classNameOrgAbstractStripped:', $classNameOrgAbstractStripped))"/>
                                        <xsl:value-of select="$classNameOrgAbstractStripped"/>
                                    </xsl:element>
                                    <!-- Class Comments -->
                                    <xsl:for-each select="tbody/tr[2]/td/div">
                                        <xsl:variable name="classComment" select="."/>
                                        <xsl:if test="string-length($classComment) > 0">
                                            <xsl:element name="classComment">
                                                <xsl:value-of
                                                        select="do:message(concat('    comm:', normalize-space($classComment)))"/>
                                                <xsl:value-of select="normalize-space($classComment)"/>
                                            </xsl:element>
                                        </xsl:if>
                                    </xsl:for-each>
                                    <xsl:for-each select="tbody/tr[3]/td/p/code">
                                        <xsl:choose>
                                            <xsl:when
                                                    test="not(do:is-value-in-sequence(normalize-space(.), $implements))">
                                                <!-- ClassNames from parents (evt more then one) -->
                                                <xsl:variable name="inherit" as="xs:string"
                                                              select="do:snakeUpperCaseToCamelCase(normalize-space(.), 0)"/>
                                                <xsl:value-of
                                                        select="do:message(concat('         inherit:', $inherit))"/>
                                                <xsl:element name="inherit">
                                                    <xsl:value-of select="$inherit"/>
                                                </xsl:element>
                                                <!-- CLASS_NAMES from parents (original) -->
                                                <xsl:variable name="inheritOrg" as="xs:string"
                                                              select="normalize-space(.)"/>
                                                <xsl:value-of
                                                        select="do:message(concat('INHERITANCE:    ', $inheritOrg))"/>
                                                <xsl:element name="inheritOrg">
                                                    <xsl:value-of select="normalize-space($inheritOrg)"/>
                                                </xsl:element>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <!-- ClassNames from parents (evt more then one) -->
                                                <xsl:variable name="implement" as="xs:string"
                                                              select="do:snakeUpperCaseToCamelCase(normalize-space(.), 0)"/>
                                                <xsl:value-of
                                                        select="do:message(concat('         implement:', $implement))"/>
                                                <xsl:element name="implement">
                                                    <xsl:value-of select="$implement"/>
                                                </xsl:element>
                                                <!-- CLASS_NAMES from parents (original) -->
                                                <xsl:variable name="implementOrg" as="xs:string"
                                                              select="normalize-space(.)"/>
                                                <xsl:value-of
                                                        select="do:message(concat('IMPLEMENT:    ', $implementOrg))"/>
                                                <xsl:element name="implementOrg">
                                                    <xsl:value-of select="normalize-space($implementOrg)"/>
                                                </xsl:element>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </xsl:for-each>
                                    <!-- Functions and Attributes and enum-values -->
                                    <xsl:element name="functionsAndAttributesAndConstants">
                                        <xsl:for-each select="tbody/tr">
                                            <xsl:variable name="cardinality"
                                                          select="string(normalize-space(string-join(th/p)))"/>
                                            <xsl:variable name="nameAndType"
                                                          select="string(normalize-space(string-join(td[1]/p)))"/>
                                            <xsl:variable name="description"
                                                          select="string(normalize-space(string-join(td[2])))"/>
                                            <xsl:if test="string-length(normalize-space($nameAndType)) > 0 and not($cardinality = 'Inherit')">
                                                <xsl:element name="nameAndTypeAndKind">
                                                    <xsl:choose>
                                                        <!-- enumeration -->
                                                        <xsl:when test="normalize-space($cardinality) = ''">
                                                            <xsl:variable name="enumType"
                                                                          select="do:snakeUpperCaseToCamelCase(normalize-space($nameAndType), 1)"/>
                                                            <xsl:variable name="kind" select="'enum-value'"/>
                                                            <xsl:element name="enumType">
                                                                <xsl:value-of select="$enumType"/>
                                                            </xsl:element>
                                                            <xsl:element name="kind">
                                                                <xsl:value-of select="$kind"/>
                                                            </xsl:element>
                                                            <xsl:value-of
                                                                    select="do:message(concat('            kind: ', $kind, ', name: ', $enumType))"/>
                                                        </xsl:when>
                                                        <!-- function or attribute -->
                                                        <xsl:otherwise>
                                                            <xsl:choose>
                                                                <!-- functions -->
                                                                <xsl:when test="contains($nameAndType, ')')">
                                                                    <xsl:variable name="name"
                                                                                  select="do:snakeUpperCaseToCamelCase(normalize-space(substring-before($nameAndType, '(')), 1)"/>
                                                                    <xsl:choose>
                                                                        <xsl:when
                                                                                test="contains($cardinality, '(abstract)')">
                                                                            <xsl:value-of
                                                                                    select="do:message(concat('    ABSTRACT        ---function:', $name))"/>
                                                                            <xsl:element name="abstract">true
                                                                            </xsl:element>
                                                                        </xsl:when>
                                                                        <xsl:otherwise>
                                                                            <xsl:value-of
                                                                                    select="do:message(concat('            ---function:', $name))"/>
                                                                            <xsl:element name="abstract">false
                                                                            </xsl:element>
                                                                        </xsl:otherwise>
                                                                    </xsl:choose>
                                                                    <xsl:if test="contains($cardinality, '(abstract)')"></xsl:if>
                                                                    <xsl:element name="name">
                                                                        <xsl:value-of select="$name"/>
                                                                    </xsl:element>
                                                                    <!-- kind of function -->
                                                                    <xsl:variable name="kind">
                                                                        <xsl:choose>
                                                                            <!-- value-function -->
                                                                            <xsl:when
                                                                                    test="contains(substring-after($nameAndType, ')'), ':')">
                                                                                <xsl:value-of
                                                                                        select="'value-function'"/>
                                                                            </xsl:when>
                                                                            <!-- void function -->
                                                                            <xsl:otherwise>
                                                                                <xsl:value-of select="'void-function'"/>
                                                                            </xsl:otherwise>
                                                                        </xsl:choose>
                                                                    </xsl:variable>
                                                                    <!-- function return-type -->
                                                                    <xsl:variable name="return-type">
                                                                        <xsl:choose>
                                                                            <!-- value-function -->
                                                                            <xsl:when
                                                                                    test="contains(substring-after($nameAndType, ')'), ':')">
                                                                                <xsl:value-of
                                                                                        select="normalize-space(do:substring-after-last($nameAndType, ':'))"/>
                                                                            </xsl:when>
                                                                            <!-- void function -->
                                                                            <xsl:otherwise>
                                                                                <xsl:value-of select="'void'"/>
                                                                            </xsl:otherwise>
                                                                        </xsl:choose>
                                                                    </xsl:variable>
                                                                    <xsl:variable name="container"
                                                                                  select="starts-with(lower-case($return-type), 'list') or starts-with(lower-case($return-type), 'set') or starts-with(lower-case($return-type), 'hash') or starts-with(lower-case($return-type), 'container')"/>
                                                                    <xsl:element name="container">
                                                                        <xsl:value-of select="$container"/>
                                                                    </xsl:element>
                                                                    <xsl:element name="type">
                                                                        <xsl:value-of select="$return-type"/>
                                                                    </xsl:element>
                                                                    <xsl:element name="kind">
                                                                        <xsl:value-of select="$kind"/>
                                                                    </xsl:element>
                                                                    <xsl:value-of
                                                                            select="do:message(concat('            kind:', $kind, ', name: ', $name, ', return-type: ', $return-type, ', cardinality:', $cardinality))"/>
                                                                    <!-- function parameters -->
                                                                    <xsl:element name="parameters">
                                                                        <xsl:variable name="parameterPart"
                                                                                      select="normalize-space(substring-after(substring-before($nameAndType, ')'), '('))"/>
                                                                        <xsl:value-of
                                                                                select="do:message(concat('            parameterPart:', $parameterPart))"/>
                                                                        <xsl:value-of select="$parameterPart"/>
                                                                        <xsl:for-each
                                                                                select="tokenize($parameterPart, ',')">
                                                                            <xsl:value-of
                                                                                    select="do:message(concat('                parameter:', normalize-space(.)))"/>
                                                                            <xsl:element name="parameter">
                                                                                <xsl:element name="name">
                                                                                    <xsl:variable name="name">
                                                                                        <xsl:choose>
                                                                                            <xsl:when
                                                                                                    test="contains(., ':')">
                                                                                                <xsl:value-of
                                                                                                        select="do:snakeUpperCaseToCamelCase(normalize-space(substring-before(., ':')), 1)"/>
                                                                                            </xsl:when>
                                                                                            <xsl:otherwise>
                                                                                                <xsl:value-of
                                                                                                        select="."/>
                                                                                            </xsl:otherwise>
                                                                                        </xsl:choose>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of
                                                                                            select="do:message(concat('                    name:', $name))"/>
                                                                                    <xsl:value-of
                                                                                            select="normalize-space(substring-before(., ':'))"/>
                                                                                </xsl:element>
                                                                                <xsl:element name="type">
                                                                                    <xsl:variable name="type">
                                                                                        <xsl:if test="contains(., ':')">
                                                                                            <xsl:value-of
                                                                                                    select="normalize-space(substring-after(., ':'))"/>
                                                                                        </xsl:if>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of
                                                                                            select="do:message(concat('                    type:', $type))"/>
                                                                                    <xsl:variable name="type-name">
                                                                                        <xsl:choose>
                                                                                            <xsl:when
                                                                                                    test="contains(normalize-space(substring-after(., ':')), '[')">
                                                                                                <xsl:value-of
                                                                                                        select="normalize-space(substring-before($type, '['))"/>
                                                                                            </xsl:when>
                                                                                            <xsl:otherwise>
                                                                                                <xsl:value-of
                                                                                                        select="normalize-space($type)"/>
                                                                                            </xsl:otherwise>
                                                                                        </xsl:choose>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of
                                                                                            select="do:message(concat('                    type-name:', $type-name))"/>
                                                                                    <xsl:variable
                                                                                            name="type-cardinality">
                                                                                        <xsl:if test="contains($type, '[')">
                                                                                            <xsl:value-of
                                                                                                    select="substring-after(normalize-space(substring-before($type, ']')), '[')"/>
                                                                                        </xsl:if>
                                                                                    </xsl:variable>
                                                                                    <xsl:value-of
                                                                                            select="do:message(concat('                    type-cardinality:', $type-cardinality))"/>
                                                                                    <xsl:variable name="container"
                                                                                                  select="starts-with(lower-case($type-name), 'list') or starts-with(lower-case($type-name), 'set') or starts-with(lower-case($type-name), 'hash') or starts-with(lower-case($type-name), 'container')"/>
                                                                                    <xsl:element name="container">
                                                                                        <xsl:value-of
                                                                                                select="$container"/>
                                                                                    </xsl:element>
                                                                                    <xsl:element name="type-name">
                                                                                        <xsl:value-of
                                                                                                select="$type-name"/>
                                                                                    </xsl:element>
                                                                                    <xsl:element
                                                                                            name="type-cardinality">
                                                                                        <xsl:value-of
                                                                                                select="$type-cardinality"/>
                                                                                    </xsl:element>
                                                                                </xsl:element>
                                                                            </xsl:element>
                                                                        </xsl:for-each>
                                                                    </xsl:element>
                                                                </xsl:when>
                                                                <xsl:otherwise>
                                                                    <xsl:choose>
                                                                        <xsl:when test="contains($nameAndType, '=')">
                                                                            <xsl:variable name="name"
                                                                                          select="normalize-space(substring-before($nameAndType, ':'))"/>
                                                                            <xsl:variable name="type"
                                                                                          select="replace(normalize-space(substring-before(normalize-space(substring-after($nameAndType, ':')), '=')), '&#160;', '')"/>
                                                                            <xsl:variable name="value"
                                                                                          select="replace(normalize-space(substring-after($nameAndType, '=')), '&#160;', '')"/>
                                                                            <xsl:variable name="kind"
                                                                                          select="'constant'"/>
                                                                            <xsl:element name="name">
                                                                                <xsl:value-of select="$name"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="type">
                                                                                <xsl:value-of select="$type"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="value">
                                                                                <xsl:value-of select="$value"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="kind">
                                                                                <xsl:value-of select="$kind"/>
                                                                            </xsl:element>
                                                                            <xsl:value-of
                                                                                    select="do:message(concat('            ', $kind, ', name: ', $name, ' type: ', $type, '  value:', $value, ', cardinality:', $cardinality))"
                                                                            />
                                                                        </xsl:when>
                                                                        <!-- attribute -->
                                                                        <xsl:otherwise>
                                                                            <xsl:variable name="name"
                                                                                          select="normalize-space(substring-before($nameAndType, ':'))"/>
                                                                            <xsl:variable name="type"
                                                                                          select="normalize-space(substring-after($nameAndType, ':'))"/>
                                                                            <xsl:variable name="container"
                                                                                          select="starts-with(lower-case($type), 'list') or starts-with(lower-case($type), 'set') or starts-with(lower-case($type), 'hash') or starts-with(lower-case($type), 'container')"/>
                                                                            <xsl:variable name="kind"
                                                                                          select="'attribute'"/>
                                                                            <xsl:element name="name">
                                                                                <xsl:value-of select="$name"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="type">
                                                                                <xsl:value-of select="$type"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="container">
                                                                                <xsl:value-of select="$container"/>
                                                                            </xsl:element>
                                                                            <xsl:element name="kind">
                                                                                <xsl:value-of select="$kind"/>
                                                                            </xsl:element>
                                                                            <xsl:value-of
                                                                                    select="do:message(concat('            ---', $kind, ', name: ', $name, ', type: ', $type, ', container:', $container, ', cardinality:', $cardinality))"
                                                                            />
                                                                        </xsl:otherwise>
                                                                    </xsl:choose>
                                                                </xsl:otherwise>
                                                            </xsl:choose>
                                                            <xsl:element name="cardinality">
                                                                <xsl:value-of select="$cardinality"/>
                                                            </xsl:element>
                                                        </xsl:otherwise>
                                                    </xsl:choose>
                                                    <xsl:element name="description">
                                                        <xsl:value-of select="normalize-space($description)"/>
                                                    </xsl:element>
                                                </xsl:element>
                                            </xsl:if>
                                        </xsl:for-each>
                                    </xsl:element>
                                </xsl:element>
                            </xsl:variable>
                            <xsl:copy-of select="$class"/>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:element>
            </xsl:variable>
            <xsl:copy-of select="$package"/>
        </xsl:if>
    </xsl:template>

    <xsl:function name="do:is-value-in-sequence" as="xs:boolean">
        <xsl:param name="value" as="xs:anyAtomicType?"/>
        <xsl:param name="seq" as="xs:anyAtomicType*"/>
        <xsl:sequence select="$value = $seq"/>
    </xsl:function>

    <xsl:function name="do:basePackageInfo">
        <xsl:param name="context" as="node()"/>
        <xsl:param name="directory"/>
        <xsl:value-of select="do:output(concat('package ', $directory, ';'))"/>
        <xsl:value-of select="do:output('')"/>
        <xsl:value-of select="do:commentOpen()"/>
        <xsl:value-of select="do:commentOutput(concat(' Title: ', $context/html/head[1]/title[1]))"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:commentOutput('Java generated from OpenEhr-html to Java by XSLT (Bert Verhees)')"/>
        <xsl:value-of select="do:commentOutput('From BMM-document:')"/>
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of
                select="
                do:commentOutput(concat(
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[1]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[3]),
                ':',
                normalize-space($context/html/body[1]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4])))"
        />
    </xsl:function>

    <xsl:function name="do:getIncludes">
        <xsl:param name="packages"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="allClasses" as="xs:string*"/>
        <xsl:sequence>
            <xsl:for-each select="$class/inheritOrg">
                <xsl:value-of select="./text()"/>
            </xsl:for-each>
            <xsl:for-each select="$class/implementOrg">
                <xsl:value-of select="./text()"/>
            </xsl:for-each>
            <xsl:for-each select="$class/functionsAndAttributesAndConstants/nameAndTypeAndKind">
                <xsl:if test="kind = 'attribute' or kind = 'void-function' or kind = 'value-function'">
                    <xsl:choose>
                        <xsl:when test="container = true()">
                            <xsl:variable name="types" as="xs:string*"
                                          select="tokenize(substring-before(substring-after(type, '&lt;'), '&gt;'), ',')"/>
                            <xsl:for-each select="$types">
                                <xsl:if test="do:is-value-in-sequence(., $allClasses)">
                                    <xsl:value-of select="."/>
                                </xsl:if>
                            </xsl:for-each>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:if test="do:is-value-in-sequence(type, $allClasses)">
                                <xsl:value-of select="type"/>
                            </xsl:if>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:if>
                <xsl:if test="kind = 'void-function' or kind = 'value-function'">
                    <xsl:for-each select="parameters/parameter">
                        <xsl:choose>
                            <xsl:when test="type/container = true()">
                                <xsl:variable name="types" as="xs:string*"
                                              select="tokenize(substring-before(substring-after(type/type-name, '&lt;'), '&gt;'), ',')"/>
                                <xsl:for-each select="$types">
                                    <xsl:if test="do:is-value-in-sequence(., $allClasses)">
                                        <xsl:value-of select="."/>
                                    </xsl:if>
                                </xsl:for-each>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:if test="do:is-value-in-sequence(type/type-name, $allClasses)">
                                    <xsl:value-of select="type/type-name"/>
                                </xsl:if>
                            </xsl:otherwise>
                        </xsl:choose>

                    </xsl:for-each>
                </xsl:if>
            </xsl:for-each>
        </xsl:sequence>
    </xsl:function>

    <xsl:function name="do:addToIncludes">
        <xsl:param name="packages"/>
        <xsl:param name="class" as="node()"/>
        <xsl:param name="classNameToAdd" as="xs:string"/>
        <xsl:variable name="classToAdd" select="do:findClass($packages, $classNameToAdd)"/>
        <xsl:variable name="includeToAdd" select="$classToAdd/packageDirectory"/>
        <xsl:if test="not($class[include/text() = $includeToAdd]) and not($class/../../packageDirectory = $includeToAdd)">
            <xsl:value-of select="$includeToAdd"/>
        </xsl:if>
    </xsl:function>

    <xsl:function name="do:snakeUpperCaseToCamelCase">
        <xsl:param name="className"/>
        <xsl:param name="lowerStart"/>
        <xsl:variable name="upper-case" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'"/>
        <xsl:variable name="lower-case" select="'abcdefghijklmnopqrstuvwxyz'"/>
        <xsl:variable name="new-name">
            <xsl:for-each select="tokenize($className, '_')">
                <xsl:choose>
                    <xsl:when test="position() = $lowerStart">
                        <xsl:value-of select="translate(., $upper-case, $lower-case)"/>
                    </xsl:when>
                    <xsl:when test="$lowerStart = -1">
                        <xsl:value-of select="translate(substring(., 1, 1), $lower-case, $upper-case)"/>
                        <xsl:value-of select="substring(., 2)"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="translate(substring(., 1, 1), $lower-case, $upper-case)"/>
                        <xsl:value-of select="translate(substring(., 2), $upper-case, $lower-case)"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:for-each>
        </xsl:variable>
        <xsl:value-of select="$new-name"/>
    </xsl:function>

    <xsl:function name="do:output">
        <xsl:param name="input" as="xs:string"/>
        <xsl:value-of select="concat(normalize-space(string-join($input)), $newline)"/>
    </xsl:function>

    <xsl:function name="do:outputSpaces">
        <xsl:param name="input" as="xs:string"/>
        <xsl:value-of select="concat(string-join($input), $newline)"/>
    </xsl:function>

    <xsl:function name="do:commentOutput">
        <xsl:param name="input" as="xs:string*"/>
        <xsl:value-of
                select="concat(' * ', replace(normalize-space(string-join($input)), '\. ', concat('.', $newline, ' * ')), $newline)"/>
    </xsl:function>

    <xsl:function name="do:commentOpen">
        <xsl:value-of select="do:output('/**')"/>
        <xsl:value-of select="do:commentOutput('')"/>
    </xsl:function>

    <xsl:function name="do:commentClose">
        <xsl:value-of select="do:commentOutput('')"/>
        <xsl:value-of select="do:output(' */')"/>
    </xsl:function>

    <xsl:function name="do:substring-after-last" as="xs:string">
        <xsl:param name="arg" as="xs:string?"/>
        <xsl:param name="delim" as="xs:string"/>
        <xsl:sequence select="
                replace($arg, concat('^.*', do:escape-for-regex($delim)), '')
                "/>
    </xsl:function>

    <xsl:function name="do:escape-for-regex" as="xs:string">
        <xsl:param name="arg" as="xs:string?"/>
        <xsl:sequence select="
                replace($arg,
                '(\.|\[|\]|\\|\||\-|\^|\$|\?|\*|\+|\{|\}|\(|\))', '\\$1')
                "/>
    </xsl:function>

    <xsl:function name="do:message">
        <xsl:param name="message"/>
        <xsl:message>
            <xsl:value-of select="$message"/>
        </xsl:message>
    </xsl:function>

</xsl:stylesheet>
