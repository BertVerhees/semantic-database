package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.class_features.BmmContainerProperty;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_CONTAINER_PROPERTY.
 */
public class PBmmContainerProperty extends PBmmProperty {

    //***** PBmmContainerProperty *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Cardinality of this property in its class.
     * Persistent attribute.
     * cardinality: 0..1
     */
    private Interval<Integer> cardinality;

    /**
     * Type definition of this property, if not a simple String type reference.
     * Persistent attribute.
     * cardinality: 0..1 (redefined)
     */
    private PBmmContainerType typeDef;

    /**
     * BMM_PROPERTY created by create_bmm_property.
     * cardinality: 0..1 (redefined)
     */
    private BmmContainerProperty bmmProperty;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Cardinality of this property in its class.
     * Persistent attribute.
     * cardinality: 0..1
     */
    public Interval<Integer> getCardinality() {
        return cardinality;
    }

    public void setCardinality(Interval<Integer> value) {
        this.cardinality = cardinality;
    }

    /**
     * Type definition of this property, if not a simple String type reference.
     * Persistent attribute.
     * cardinality: 0..1 (redefined)
     */
    public PBmmContainerType getTypeDef() {
        return typeDef;
    }

    public void setTypeDef(PBmmContainerType value) {
        this.typeDef = typeDef;
    }

    /**
     * BMM_PROPERTY created by create_bmm_property.
     * cardinality: 0..1 (redefined)
     */
    public BmmContainerProperty getBmmProperty() {
        return bmmProperty;
    }

    public void setBmmProperty(BmmContainerProperty value) {
        this.bmmProperty = bmmProperty;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Create bmm_property_definition.
     * cardinality: 0..1 (redefined)
     */
    public void createBmmProperty(BmmModel a_bmm_schema, BmmClass a_class_def) {
        if (a_bmm_schema == null) {
            throw new NullPointerException("Parameter a_bmm_schema has cardinality NonNull, but is null");
        }
        if (a_class_def == null) {
            throw new NullPointerException("Parameter a_class_def has cardinality NonNull, but is null");
        }
    }

    //***** PBmmContainerProperty *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmContainerProperty() {
    }

    public PBmmContainerProperty(
            Interval<integer> cardinality,
            PBmmContainerType typeDef,
            BmmContainerProperty bmmProperty,
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
                documentation
        );
        this.cardinality = cardinality;
        this.typeDef = typeDef;
        this.bmmProperty = bmmProperty;
    }

    private PBmmContainerProperty(Builder builder) {
        this.setCardinality(builder.cardinality);
        this.setTypeDef(builder.typeDef);
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
        private Interval<integer> cardinality;
        private PBmmContainerType typeDef;
        private BmmContainerProperty bmmProperty;
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

        public Builder setCardinality(Interval<integer> value) {
            this.cardinality = cardinality;
            return this;
        }

        public Builder setTypeDef(PBmmContainerType value) {
            this.typeDef = typeDef;
            return this;
        }

        public Builder setBmmProperty(BmmContainerProperty value) {
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

        public PBmmContainerProperty build() {
            return new PBmmContainerProperty(this);
        }
    }


    //***** PBmmContainerProperty *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmContainerProperty that = (PBmmContainerProperty) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmContainerProperty.java
                Objects.equals(cardinality, that.cardinality) &&
                        Objects.equals(typeDef, that.typeDef) &&
                        Objects.equals(bmmProperty, that.bmmProperty);
=======
                java.util.Objects.equals(cardinality, that.cardinality) &&
                        java.util.Objects.equals(typeDef, that.typeDef) &&
                        java.util.Objects.equals(bmmProperty, that.bmmProperty);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmContainerProperty.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                cardinality,
                typeDef,
                bmmProperty
        );
    }

    @Override
    public String toString() {
        return
                "PBmmContainerProperty {" +
                        "cardinality='" + cardinality + '\'' +
                        "typeDef='" + typeDef + '\'' +
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
