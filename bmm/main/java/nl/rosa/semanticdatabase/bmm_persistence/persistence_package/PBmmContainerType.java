package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmContainerType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_CONTAINER_TYPE.
 */
public class PBmmContainerType extends PBmmType {

    //***** PBmmContainerType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The type of the container.
     * This converts to the root_type in BMM_GENERIC_TYPE.
     * Persisted attribute.
     * cardinality: 1..1
     */
    private String containerType;

    /**
     * Type definition of type, if not a simple String type reference.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private PBmmBaseType typeDef;

    /**
     * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private String type;

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    private BmmContainerType bmmType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The type of the container.
     * This converts to the root_type in BMM_GENERIC_TYPE.
     * Persisted attribute.
     * cardinality: 1..1
     */
    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:containerType failed, it has cardinality NonNull, but is null");
        }
        this.containerType = containerType;
    }

    /**
     * Type definition of type, if not a simple String type reference.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public PBmmBaseType getTypeDef() {
        return typeDef;
    }

    public void setTypeDef(PBmmBaseType value) {
        this.typeDef = typeDef;
    }

    /**
     * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = type;
    }

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    public BmmContainerType getBmmType() {
        return bmmType;
    }

    public void setBmmType(BmmContainerType value) {
        this.bmmType = bmmType;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
     * Persisted attribute.
     * cardinality: 1..1
     */
    public PBmmBaseType typeRef() {
        PBmmBaseType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** PBmmContainerType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmContainerType() {
    }

    public PBmmContainerType(
            String containerType,
            PBmmBaseType typeDef,
            String type,
            BmmContainerType bmmType,
            BmmType bmmType
    ) {
        if (containerType == null) {
            throw new NullPointerException("Property:containerType has cardinality NonNull, but is null");
        }
        this.containerType = containerType;
        this.typeDef = typeDef;
        this.type = type;
        this.bmmType = bmmType;
    }

    private PBmmContainerType(Builder builder) {
        this.setContainerType(builder.containerType);
        this.setTypeDef(builder.typeDef);
        this.setType(builder.type);
        this.setBmmType(builder.bmmType);
        this.setBmmType(builder.bmmType);
    }

    public static class Builder {
        private final String containerType;  //required
        private PBmmBaseType typeDef;
        private String type;
        private BmmContainerType bmmType;
        private BmmType bmmType;

        public Builder(
                String containerType
        ) {
            if (containerType == null) {
                throw new NullPointerException("Property:containerType has cardinality NonNull, but is null");
            }
            this.containerType = containerType;
        }

        public Builder setTypeDef(PBmmBaseType value) {
            this.typeDef = typeDef;
            return this;
        }

        public Builder setType(String value) {
            this.type = type;
            return this;
        }

        public Builder setBmmType(BmmContainerType value) {
            this.bmmType = bmmType;
            return this;
        }

        public Builder setBmmType(BmmType value) {
            this.bmmType = bmmType;
            return this;
        }

        public PBmmContainerType build() {
            return new PBmmContainerType(this);
        }
    }


    //***** PBmmContainerType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmContainerType that = (PBmmContainerType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmContainerType.java
                Objects.equals(containerType, that.containerType) &&
                        Objects.equals(typeDef, that.typeDef) &&
                        Objects.equals(type, that.type) &&
                        Objects.equals(bmmType, that.bmmType);
=======
                java.util.Objects.equals(containerType, that.containerType) &&
                        java.util.Objects.equals(typeDef, that.typeDef) &&
                        java.util.Objects.equals(type, that.type) &&
                        java.util.Objects.equals(bmmType, that.bmmType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmContainerType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                containerType,
                typeDef,
                type,
                bmmType
        );
    }

    @Override
    public String toString() {
        return
                "PBmmContainerType {" +
                        "containerType='" + containerType + '\'' +
                        "typeDef='" + typeDef + '\'' +
                        "type='" + type + '\'' +
                        "bmmType='" + bmmType + '\'' +
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
