package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmm.types.BmmContainerType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type of for properties of linear container type, such as List<T> etc.
 */
public class BmmContainerProperty extends BmmProperty {

    //***** BmmContainerProperty *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Cardinality of this container.
     * cardinality: 0..1
     */
    private MultiplicityInterval cardinality;

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1 (redefined)
     */
    private BmmContainerType type;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Cardinality of this container.
     * cardinality: 0..1
     */
    public MultiplicityInterval getCardinality() {
        return cardinality;
    }

    public void setCardinality(MultiplicityInterval value) {
        this.cardinality = cardinality;
    }

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1 (redefined)
     */
    public BmmContainerType getType() {
        return type;
    }

    public void setType(BmmContainerType value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Name of this property in form name: ContainerTypeName<>.
     * cardinality: 1..1 (redefined)
     */
    public String displayName() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmContainerProperty *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmContainerProperty() {
    }

    public BmmContainerProperty(
            MultiplicityInterval cardinality,
            BmmContainerType type,
            BmmType type,
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                visibility,
                featureExtensions,
                group,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.cardinality = cardinality;
        this.type = type;
    }

    private BmmContainerProperty(Builder builder) {
        this.setCardinality(builder.cardinality);
        this.setType(builder.type);
        this.setType(builder.type);
        this.setVisibility(builder.visibility);
        this.setFeatureExtensions(builder.featureExtensions);
        this.setGroup(builder.group);
        this.setScope(builder.scope);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private MultiplicityInterval cardinality;
        private final BmmContainerType type;  //required
        private final BmmType type;  //required
        private BmmVisibility visibility;
        private List<bmmFeatureExtension> featureExtensions;
        private final BmmFeatureGroup group;  //required
        private final BmmClass scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                BmmContainerType type,
                BmmType type,
                BmmFeatureGroup group,
                BmmClass scope,
                String name,
                BmmDeclaration scope
        ) {
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (group == null) {
                throw new NullPointerException("Property:group has cardinality NonNull, but is null");
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
            this.type = type;
            this.type = type;
            this.group = group;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setCardinality(MultiplicityInterval value) {
            this.cardinality = cardinality;
            return this;
        }

        public Builder setVisibility(BmmVisibility value) {
            this.visibility = visibility;
            return this;
        }

        public Builder setFeatureExtensions(List<bmmFeatureExtension> value) {
            this.featureExtensions = featureExtensions;
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

        public BmmContainerProperty build() {
            return new BmmContainerProperty(this);
        }
    }


    //***** BmmContainerProperty *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmContainerProperty that = (BmmContainerProperty) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmContainerProperty.java
                Objects.equals(cardinality, that.cardinality) &&
                        Objects.equals(type, that.type);
=======
                java.util.Objects.equals(cardinality, that.cardinality) &&
                        java.util.Objects.equals(type, that.type);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmContainerProperty.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                cardinality,
                type
        );
    }

    @Override
    public String toString() {
        return
                "BmmContainerProperty {" +
                        "cardinality='" + cardinality + '\'' +
                        "type='" + type + '\'' +
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
