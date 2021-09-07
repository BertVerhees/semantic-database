package nl.rosa.semanticdatabase.bmm.model_structure;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type of BMM declared model elements.
 * A declaration is a an element of a model specified by an author within a model definition within a context, which defines the scope of the element.
 * Thus, a class definition and its property and routine definitions are model elements, but Types are not, since they are derived from model elements.
 */
public abstract class BmmDeclaration {

    //***** BmmDeclaration *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of this model element.
     * cardinality: 1..1
     */
    private String name;

    /**
     * Optional documentation of this element, as a keyed list.
     * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
     * cardinality: 0..1
     */
    private Map<String, Any> documentation;

    /**
     * Model element within which an element is declared.
     * cardinality: 1..1
     */
    private BmmDeclaration scope;

    /**
     * Optional meta-data of this element, as a keyed list.
     * May be used to extend the meta-model.
     * cardinality: 0..1
     */
    private Map<String, Any> extensions;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of this model element.
     * cardinality: 1..1
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    /**
     * Optional documentation of this element, as a keyed list.
     * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
     * cardinality: 0..1
     */

    public void putDocumentation(String key, Any value) {
        if (documentation == null) {
            documentation = new HashMap<>();
        }
        documentation.put(key, value);
    }

    public void putDocumentation(Map<String, Any> items) {
        items.keySet().forEach(key -> putDocumentatio(key, items.get(key)));
    }

    public Any getDocumentation(String key) {
        if (documentation == null) {
            return null;
        }
        return documentation.get(key);
    }

    public void removeDocumentation(String key) {
        if (documentation != null) {
            documentation.remove(key);
        }
    }

    public void removeDocumentation(Collection<String> keys) {
        keys.forEach(this::removeDocumentation);
    }

    public Map<String, Any> getDocumentation() {
        return this.documentation;
    }

    public BmmDeclaration setDocumentation(Map<String, Any> documentation) {
        this.documentation = documentation;
        return this;
    }

    public Map<String, Any> documentation() {
        return Collections.unmodifiableMap(this.documentation);
    }

    /**
     * Model element within which an element is declared.
     * cardinality: 1..1
     */
    public BmmDeclaration getScope() {
        return scope;
    }

    public void setScope(BmmDeclaration value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    /**
     * Optional meta-data of this element, as a keyed list.
     * May be used to extend the meta-model.
     * cardinality: 0..1
     */

    public void putExtension(String key, Any value) {
        if (extensions == null) {
            extensions = new HashMap<>();
        }
        extensions.put(key, value);
    }

    public void putExtensions(Map<String, Any> items) {
        items.keySet().forEach(key -> putExtension(key, items.get(key)));
    }

    public Any getExtension(String key) {
        if (extensions == null) {
            return null;
        }
        return extensions.get(key);
    }

    public void removeExtension(String key) {
        if (extensions != null) {
            extensions.remove(key);
        }
    }

    public void removeExtensions(Collection<String> keys) {
        keys.forEach(this::removeExtension);
    }

    public Map<String, Any> getExtensions() {
        return this.extensions;
    }

    public BmmDeclaration setExtensions(Map<String, Any> extensions) {
        this.extensions = extensions;
        return this;
    }

    public Map<String, Any> extensions() {
        return Collections.unmodifiableMap(this.extensions);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * True if this declaration entity is the root of the declaration hierarchy.
 * cardinality: 1..1
 *
 */
    public Result =(scope =self)

    isRootScope() {
        Result = (scope = self) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmDeclaration *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmDeclaration() {
    }

    protected BmmDeclaration(
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (scope == null) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
    }


    //***** BmmDeclaration *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmDeclaration that = (BmmDeclaration) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmDeclaration.java
                Objects.equals(name, that.name) &&
                        Objects.equals(documentation, that.documentation) &&
                        Objects.equals(scope, that.scope) &&
                        Objects.equals(extensions, that.extensions);
=======
                java.util.Objects.equals(name, that.name) &&
                        java.util.Objects.equals(documentation, that.documentation) &&
                        java.util.Objects.equals(scope, that.scope) &&
                        java.util.Objects.equals(extensions, that.extensions);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmDeclaration.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                documentation,
                scope,
                extensions
        );
    }

    @Override
    public String toString() {
        return
                "BmmDeclaration {" +
                        "name='" + name + '\'' +
                        "documentation='" + documentation + '\'' +
                        "scope='" + scope + '\'' +
                        "extensions='" + extensions + '\'' +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */
