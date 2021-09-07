package nl.rosa.semanticdatabase.bmm.classes;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of a simple class, i.e.
 * a class that has no generic parameters and is 1:1 with the type it generates.
 */
public class BmmSimpleClass extends BmmClass {

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Generate a type object that represents the type of this class.
     * Can only be an instance of BMM_SIMPLE_TYPE or a descendant.
     * cardinality: 1..1 (effected)
     */
    public BmmSimpleType type() {
        BmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmSimpleClass *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmSimpleClass() {
    }

    public BmmSimpleClass(
            Map<string, bmmModelType> ancestors,
            BmmPackage package,
            Map<string, bmmProperty> properties,
            String sourceSchemaId,
            List<bmmClass> immediateDescendants,
            Boolean isOverride,
            Map<string, bmmConstant> constants,
            Map<string, bmmFunction> functions,
            Map<string, bmmProcedure> procedures,
            List<bmmAssertion> invariants,
            Map<string, bmmProcedure> creators,
            Map<string, bmmProcedure> converters,
            List<bmmFeatureGroup> featureGroups,
            BmmModel scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                ancestors,
            package,
        properties,
                sourceSchemaId,
                immediateDescendants,
                isOverride,
                constants,
                functions,
                procedures,
                invariants,
                creators,
                converters,
                featureGroups,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
    }

    private BmmSimpleClass(Builder builder) {
        this.setAncestors(builder.ancestors);
        this.setPackage(builder.package );
        this.setProperties(builder.properties);
        this.setSourceSchemaId(builder.sourceSchemaId);
        this.setImmediateDescendants(builder.immediateDescendants);
        this.setIsOverride(builder.isOverride);
        this.setConstants(builder.constants);
        this.setFunctions(builder.functions);
        this.setProcedures(builder.procedures);
        this.setInvariants(builder.invariants);
        this.setCreators(builder.creators);
        this.setConverters(builder.converters);
        this.setFeatureGroups(builder.featureGroups);
        this.setScope(builder.scope);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private Map<string, bmmModelType> ancestors;
        private final BmmPackage package;  //required
        private Map<string, bmmProperty> properties;
        private final String sourceSchemaId;  //required
        private List<bmmClass> immediateDescendants;
        private final Boolean isOverride;  //required
        private Map<string, bmmConstant> constants;
        private Map<string, bmmFunction> functions;
        private Map<string, bmmProcedure> procedures;
        private List<bmmAssertion> invariants;
        private Map<string, bmmProcedure> creators;
        private Map<string, bmmProcedure> converters;
        private List<bmmFeatureGroup> featureGroups;
        private final BmmModel scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                BmmPackage package,
                String sourceSchemaId,
                Boolean isOverride,
                BmmModel scope,
                String name,
                BmmDeclaration scope
        ) {
            if ( package ==null ){
                throw new NullPointerException("Property:package has cardinality NonNull, but is null");
            }
            if (sourceSchemaId == null) {
                throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
            }
            if (isOverride == null) {
                throw new NullPointerException("Property:isOverride has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.package = package;
            this.sourceSchemaId = sourceSchemaId;
            this.isOverride = isOverride;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setAncestors(Map<string, bmmModelType> value) {
            this.ancestors = ancestors;
            return this;
        }

        public Builder setProperties(Map<string, bmmProperty> value) {
            this.properties = properties;
            return this;
        }

        public Builder setImmediateDescendants(List<bmmClass> value) {
            this.immediateDescendants = immediateDescendants;
            return this;
        }

        public Builder setConstants(Map<string, bmmConstant> value) {
            this.constants = constants;
            return this;
        }

        public Builder setFunctions(Map<string, bmmFunction> value) {
            this.functions = functions;
            return this;
        }

        public Builder setProcedures(Map<string, bmmProcedure> value) {
            this.procedures = procedures;
            return this;
        }

        public Builder setInvariants(List<bmmAssertion> value) {
            this.invariants = invariants;
            return this;
        }

        public Builder setCreators(Map<string, bmmProcedure> value) {
            this.creators = creators;
            return this;
        }

        public Builder setConverters(Map<string, bmmProcedure> value) {
            this.converters = converters;
            return this;
        }

        public Builder setFeatureGroups(List<bmmFeatureGroup> value) {
            this.featureGroups = featureGroups;
            return this;
        }

        public Builder setDocumentation(Map<string, any> value) {
            this.documentation = documentation;
            return this;
        }

        public Builder setExtensions(Map<string, any> value) {
            this.extensions = extensions;
            return this;
        }

        public BmmSimpleClass build() {
            return new BmmSimpleClass(this);
        }
    }


    //***** BmmSimpleClass *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "BmmSimpleClass {" +
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
