package nl.rosa.semanticdatabase.bmm.classes;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of a generic class in an object model.
 */
public class BmmGenericClass extends BmmClass {

    //***** BmmGenericClass *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * List of formal generic parameters, keyed by name.
     * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
     * cardinality: 1..1
     */
    private Map<String, BmmParameterType> genericParameters = new HashMap<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * List of formal generic parameters, keyed by name.
     * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
     * cardinality: 1..1
     */

    public void putGenericParameter(String key, BmmParameterType value) {
        genericParameters.put(key, value);
    }

    public void putGenericParameters(Map<String, BmmParameterType> items) {
        items.keySet().forEach(key -> putGenericparameter(key, items.get(key)));
    }

    public BmmParameterType getGenericParameter(String key) {
        return genericParameters.get(key);
    }

    public void removeGenericParameter(String key) {
        if (genericParameters != null) {
            genericParameters.remove(key);
        }
    }

    public void removeGenericParameters(Collection<String> keys) {
        keys.forEach(this::removeGenericParameter);
    }

    public Map<String, BmmParameterType> getGenericParameters() {
        return this.genericParameters;
    }

    public BmmGenericClass setGenericParameters(Map<String, BmmParameterType> genericParameters) {
        if (genericParameters == null) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        return this;
    }

    public Map<String, BmmParameterType> genericParameters() {
        return Collections.unmodifiableMap(this.genericParameters);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Add suppliers from generic parameters.
     * cardinality: 0..1 (redefined)
     */
    public List<String> suppliers() {
        List<String> result = null;


        return result;
    }

    /**
     * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition
     * cardinality: 1..1 (effected)
     */
    public BmmGenericType type() {
        BmmGenericType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * For a generic class, type to which generic parameter a_name conforms e.g.
     * if this class is Interval <T:Comparable> then the Result will be the single type Comparable.
     * For an unconstrained type T, the Result will be Any.
     * cardinality: 1..1
     */
    public String genericParameterConformanceType(String a_name) {
        if (a_name == null) {
            throw new NullPointerException("Parameter a_name has cardinality NonNull, but is null.");
        }
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmGenericClass *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmGenericClass() {
    }

    public BmmGenericClass(
            Map<string, bmmParameterType> genericParameters,
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
        if (genericParameters == null) {
            throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
    }

    private BmmGenericClass(Builder builder) {
        this.setGenericParameters(builder.genericParameters);
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
        private final Map<string, bmmParameterType> genericParameters;  //required
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
                Map<string, bmmParameterType> genericParameters,
                BmmPackage package,
                String sourceSchemaId,
                Boolean isOverride,
                BmmModel scope,
                String name,
                BmmDeclaration scope
        ) {
            if (genericParameters == null) {
                throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
            }
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
            this.genericParameters = genericParameters;
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

        public BmmGenericClass build() {
            return new BmmGenericClass(this);
        }
    }


    //***** BmmGenericClass *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmGenericClass that = (BmmGenericClass) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmGenericClass.java
                Objects.equals(genericParameters, that.genericParameters);
=======
                java.util.Objects.equals(genericParameters, that.genericParameters);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmGenericClass.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                genericParameters
        );
    }

    @Override
    public String toString() {
        return
                "BmmGenericClass {" +
                        "genericParameters='" + genericParameters + '\'' +
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
