package nl.rosa.semanticdatabase.bmm.classes;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.literal_values.BmmStringValue;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * String-based enumeration meta-type.
 */
public class BmmEnumerationString extends BmmEnumeration {

    //***** BmmEnumerationString *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Optional list of specific values.
     * Must be 1:1 with item_names list.
     * cardinality: 0..1 (redefined)
     */
    private List<BmmStringValue> itemValues;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Optional list of specific values.
     * Must be 1:1 with item_names list.
     * cardinality: 0..1 (redefined)
     */

    public void addToItemValue(BmmStringValue value) {
        if (itemValues == null) {
            itemValues = new ArrayList<>();
        }
        itemValues.add(value);
    }

    public void addToItemValues(List<BmmStringValue> values) {
        values.forEach(value -> addToItemvalue(value));
    }

    public void removeFromItemValue(BmmStringValue item) {
        if (itemValues != null) {
            itemValues.remove(item);
        }
    }

    public void removeFromItemValues(Collection<BmmStringValue> values) {
        values.forEach(this::removeFromItemValue);
    }

    List<BmmStringValue> getItemValues() {
        return this.itemValues;
    }

    public BmmEnumerationString setItemValues(List<BmmStringValue> itemValues) {
        this.itemValues = itemValues;
        return this;
    }

    public List<BmmStringValue> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
    }

    //***** BmmEnumerationString *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmEnumerationString() {
    }

    public BmmEnumerationString(
            List<bmmStringValue> itemValues,
            List<string> itemNames,
            List<bmmPrimitiveValue> itemValues,
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
                itemNames,
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
        this.itemValues = itemValues;
    }

    private BmmEnumerationString(Builder builder) {
        this.setItemValues(builder.itemValues);
        this.setItemNames(builder.itemNames);
        this.setItemValues(builder.itemValues);
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
        private List<bmmStringValue> itemValues;
        private List<string> itemNames;
        private List<bmmPrimitiveValue> itemValues;
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

        public Builder setItemValues(List<bmmStringValue> value) {
            this.itemValues = itemValues;
            return this;
        }

        public Builder setItemNames(List<string> value) {
            this.itemNames = itemNames;
            return this;
        }

        public Builder setItemValues(List<bmmPrimitiveValue> value) {
            this.itemValues = itemValues;
            return this;
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

        public BmmEnumerationString build() {
            return new BmmEnumerationString(this);
        }
    }


    //***** BmmEnumerationString *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmEnumerationString that = (BmmEnumerationString) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmEnumerationString.java
                Objects.equals(itemValues, that.itemValues);
=======
                java.util.Objects.equals(itemValues, that.itemValues);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmEnumerationString.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                itemValues
        );
    }

    @Override
    public String toString() {
        return
                "BmmEnumerationString {" +
                        "itemValues='" + itemValues + '\'' +
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
