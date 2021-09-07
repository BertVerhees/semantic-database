package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.classes.BmmEnumerationString;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_ENUMERATION_STRING.
 */
public class PBmmEnumerationString extends PBmmEnumeration {

    //***** PBmmEnumerationString *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
     * cardinality: 0..1 (redefined)
     */
    private BmmEnumerationString bmmClass;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
     * cardinality: 0..1 (redefined)
     */
    public BmmEnumerationString getBmmClass() {
        return bmmClass;
    }

    public void setBmmClass(BmmEnumerationString value) {
        this.bmmClass = bmmClass;
    }

    //***** PBmmEnumerationString *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmEnumerationString() {
    }

    public PBmmEnumerationString(
            BmmEnumerationString bmmClass,
            List<string> itemNames,
            List<any> itemValues,
            BmmEnumeration bmmClass,
            String name,
            List<string> ancestors,
            Map<string, pBmmProperty> properties,
            Boolean isAbstract,
            Boolean isOverride,
            Map<string, pBmmGenericParameter> genericParameterDefs,
            String sourceSchemaId,
            BmmClass bmmClass,
            Integer uid,
            List<pBmmGenericType> ancestorDefs,
            String documentation
    ) {
        super(
                itemNames,
                itemValues,
                name,
                ancestors,
                properties,
                isAbstract,
                isOverride,
                genericParameterDefs,
                sourceSchemaId,
                uid,
                ancestorDefs,
                documentation
        );
        this.bmmClass = bmmClass;
    }

    private PBmmEnumerationString(Builder builder) {
        this.setBmmClass(builder.bmmClass);
        this.setItemNames(builder.itemNames);
        this.setItemValues(builder.itemValues);
        this.setBmmClass(builder.bmmClass);
        this.setName(builder.name);
        this.setAncestors(builder.ancestors);
        this.setProperties(builder.properties);
        this.setIsAbstract(builder.isAbstract);
        this.setIsOverride(builder.isOverride);
        this.setGenericParameterDefs(builder.genericParameterDefs);
        this.setSourceSchemaId(builder.sourceSchemaId);
        this.setBmmClass(builder.bmmClass);
        this.setUid(builder.uid);
        this.setAncestorDefs(builder.ancestorDefs);
        this.setDocumentation(builder.documentation);
    }

    public static class Builder {
        private BmmEnumerationString bmmClass;
        private List<string> itemNames;
        private List<any> itemValues;
        private BmmEnumeration bmmClass;
        private final String name;  //required
        private List<string> ancestors;
        private Map<string, pBmmProperty> properties;
        private Boolean isAbstract;
        private Boolean isOverride;
        private Map<string, pBmmGenericParameter> genericParameterDefs;
        private final String sourceSchemaId;  //required
        private BmmClass bmmClass;
        private final Integer uid;  //required
        private List<pBmmGenericType> ancestorDefs;
        private String documentation;

        public Builder(
                String name,
                String sourceSchemaId,
                Integer uid
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (sourceSchemaId == null) {
                throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
            }
            if (uid == null) {
                throw new NullPointerException("Property:uid has cardinality NonNull, but is null");
            }
            this.name = name;
            this.sourceSchemaId = sourceSchemaId;
            this.uid = uid;
        }

        public Builder setBmmClass(BmmEnumerationString value) {
            this.bmmClass = bmmClass;
            return this;
        }

        public Builder setItemNames(List<string> value) {
            this.itemNames = itemNames;
            return this;
        }

        public Builder setItemValues(List<any> value) {
            this.itemValues = itemValues;
            return this;
        }

        public Builder setBmmClass(BmmEnumeration value) {
            this.bmmClass = bmmClass;
            return this;
        }

        public Builder setAncestors(List<string> value) {
            this.ancestors = ancestors;
            return this;
        }

        public Builder setProperties(Map<string, pBmmProperty> value) {
            this.properties = properties;
            return this;
        }

        public Builder setIsAbstract(Boolean value) {
            this.isAbstract = isAbstract;
            return this;
        }

        public Builder setIsOverride(Boolean value) {
            this.isOverride = isOverride;
            return this;
        }

        public Builder setGenericParameterDefs(Map<string, pBmmGenericParameter> value) {
            this.genericParameterDefs = genericParameterDefs;
            return this;
        }

        public Builder setBmmClass(BmmClass value) {
            this.bmmClass = bmmClass;
            return this;
        }

        public Builder setAncestorDefs(List<pBmmGenericType> value) {
            this.ancestorDefs = ancestorDefs;
            return this;
        }

        public Builder setDocumentation(String value) {
            this.documentation = documentation;
            return this;
        }

        public PBmmEnumerationString build() {
            return new PBmmEnumerationString(this);
        }
    }


    //***** PBmmEnumerationString *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmEnumerationString that = (PBmmEnumerationString) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmEnumerationString.java
                Objects.equals(bmmClass, that.bmmClass);
=======
                java.util.Objects.equals(bmmClass, that.bmmClass);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmEnumerationString.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                bmmClass
        );
    }

    @Override
    public String toString() {
        return
                "PBmmEnumerationString {" +
                        "bmmClass='" + bmmClass + '\'' +
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
