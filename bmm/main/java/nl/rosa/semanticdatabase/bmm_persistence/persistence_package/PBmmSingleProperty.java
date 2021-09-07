package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.class_features.BmmUnitaryProperty;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_SINGLE_PROPERTY.
 */
public class PBmmSingleProperty extends PBmmProperty {

    //***** PBmmSingleProperty *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * If the type is a simple type, then this attribute will hold the type name.
     * If the type is a container or generic, then type_ref will hold the type definition.
     * The resulting type is generated in type_def.
     * cardinality: 0..1
     */
    private String type;

    /**
     * Type definition of this property computed from type for later use in bmm_property.
     * cardinality: 0..1
     */
    private PBmmSimpleType typeRef;

    /**
     * BMM_PROPERTY created by create_bmm_property_definition.
     * cardinality: 0..1 (redefined)
     */
    private BmmUnitaryProperty bmmProperty;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * If the type is a simple type, then this attribute will hold the type name.
     * If the type is a container or generic, then type_ref will hold the type definition.
     * The resulting type is generated in type_def.
     * cardinality: 0..1
     */
    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = type;
    }

    /**
     * Type definition of this property computed from type for later use in bmm_property.
     * cardinality: 0..1
     */
    public PBmmSimpleType getTypeRef() {
        return typeRef;
    }

    public void setTypeRef(PBmmSimpleType value) {
        this.typeRef = typeRef;
    }

    /**
     * BMM_PROPERTY created by create_bmm_property_definition.
     * cardinality: 0..1 (redefined)
     */
    public BmmUnitaryProperty getBmmProperty() {
        return bmmProperty;
    }

    public void setBmmProperty(BmmUnitaryProperty value) {
        this.bmmProperty = bmmProperty;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Generate type_ref from type and save.
     * cardinality: 1..1
     */
    public PBmmSimpleType typeDef() {
        PBmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** PBmmSingleProperty *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmSingleProperty() {
    }

    public PBmmSingleProperty(
            String type,
            PBmmSimpleType typeRef,
            BmmUnitaryProperty bmmProperty,
            String name,
            Boolean isMandatory,
            Boolean isComputed,
            Boolean isImInfrastructure,
            Boolean isImRuntime,
            PBmmType typeDef,
            BmmProperty bmmProperty,
            String documentation
    ) {
        super(
                name,
                isMandatory,
                isComputed,
                isImInfrastructure,
                isImRuntime,
                typeDef,
                documentation
        );
        this.type = type;
        this.typeRef = typeRef;
        this.bmmProperty = bmmProperty;
    }

    private PBmmSingleProperty(Builder builder) {
        this.setType(builder.type);
        this.setTypeRef(builder.typeRef);
        this.setBmmProperty(builder.bmmProperty);
        this.setName(builder.name);
        this.setIsMandatory(builder.isMandatory);
        this.setIsComputed(builder.isComputed);
        this.setIsImInfrastructure(builder.isImInfrastructure);
        this.setIsImRuntime(builder.isImRuntime);
        this.setTypeDef(builder.typeDef);
        this.setBmmProperty(builder.bmmProperty);
        this.setDocumentation(builder.documentation);
    }

    public static class Builder {
        private String type;
        private PBmmSimpleType typeRef;
        private BmmUnitaryProperty bmmProperty;
        private final String name;  //required
        private Boolean isMandatory;
        private Boolean isComputed;
        private Boolean isImInfrastructure;
        private Boolean isImRuntime;
        private PBmmType typeDef;
        private BmmProperty bmmProperty;
        private String documentation;

        public Builder(
                String name
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            this.name = name;
        }

        public Builder setType(String value) {
            this.type = type;
            return this;
        }

        public Builder setTypeRef(PBmmSimpleType value) {
            this.typeRef = typeRef;
            return this;
        }

        public Builder setBmmProperty(BmmUnitaryProperty value) {
            this.bmmProperty = bmmProperty;
            return this;
        }

        public Builder setIsMandatory(Boolean value) {
            this.isMandatory = isMandatory;
            return this;
        }

        public Builder setIsComputed(Boolean value) {
            this.isComputed = isComputed;
            return this;
        }

        public Builder setIsImInfrastructure(Boolean value) {
            this.isImInfrastructure = isImInfrastructure;
            return this;
        }

        public Builder setIsImRuntime(Boolean value) {
            this.isImRuntime = isImRuntime;
            return this;
        }

        public Builder setTypeDef(PBmmType value) {
            this.typeDef = typeDef;
            return this;
        }

        public Builder setBmmProperty(BmmProperty value) {
            this.bmmProperty = bmmProperty;
            return this;
        }

        public Builder setDocumentation(String value) {
            this.documentation = documentation;
            return this;
        }

        public PBmmSingleProperty build() {
            return new PBmmSingleProperty(this);
        }
    }


    //***** PBmmSingleProperty *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmSingleProperty that = (PBmmSingleProperty) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSingleProperty.java
                Objects.equals(type, that.type) &&
                        Objects.equals(typeRef, that.typeRef) &&
                        Objects.equals(bmmProperty, that.bmmProperty);
=======
                java.util.Objects.equals(type, that.type) &&
                        java.util.Objects.equals(typeRef, that.typeRef) &&
                        java.util.Objects.equals(bmmProperty, that.bmmProperty);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSingleProperty.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                type,
                typeRef,
                bmmProperty
        );
    }

    @Override
    public String toString() {
        return
                "PBmmSingleProperty {" +
                        "type='" + type + '\'' +
                        "typeRef='" + typeRef + '\'' +
                        "bmmProperty='" + bmmProperty + '\'' +
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
