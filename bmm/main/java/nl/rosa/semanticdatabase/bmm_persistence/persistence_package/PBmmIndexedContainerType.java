package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmIndexedContainerType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 */
public class PBmmIndexedContainerType extends PBmmContainerType {

    //***** PBmmIndexedContainerType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    private String indexType;

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    private BmmIndexedContainerType bmmType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:indexType failed, it has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
    }

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    public BmmIndexedContainerType getBmmType() {
        return bmmType;
    }

    public void setBmmType(BmmIndexedContainerType value) {
        this.bmmType = bmmType;
    }

    //***** PBmmIndexedContainerType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmIndexedContainerType() {
    }

    public PBmmIndexedContainerType(
            String indexType,
            BmmIndexedContainerType bmmType,
            String containerType,
            PBmmBaseType typeDef,
            String type,
            BmmContainerType bmmType,
            BmmType bmmType
    ) {
        super(
                containerType,
                typeDef
        );
        if (indexType == null) {
            throw new NullPointerException("Property:indexType has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
        this.bmmType = bmmType;
    }

    private PBmmIndexedContainerType(Builder builder) {
        this.setIndexType(builder.indexType);
        this.setBmmType(builder.bmmType);
        this.setContainerType(builder.containerType);
        this.setTypeDef(builder.typeDef);
        this.setType(builder.type);
        this.setBmmType(builder.bmmType);
        this.setBmmType(builder.bmmType);
    }

    public static class Builder {
        private final String indexType;  //required
        private BmmIndexedContainerType bmmType;
        private final String containerType;  //required
        private PBmmBaseType typeDef;
        private String type;
        private BmmContainerType bmmType;
        private BmmType bmmType;

        public Builder(
                String indexType,
                String containerType
        ) {
            if (indexType == null) {
                throw new NullPointerException("Property:indexType has cardinality NonNull, but is null");
            }
            if (containerType == null) {
                throw new NullPointerException("Property:containerType has cardinality NonNull, but is null");
            }
            this.indexType = indexType;
            this.containerType = containerType;
        }

        public Builder setBmmType(BmmIndexedContainerType value) {
            this.bmmType = bmmType;
            return this;
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

        public PBmmIndexedContainerType build() {
            return new PBmmIndexedContainerType(this);
        }
    }


    //***** PBmmIndexedContainerType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmIndexedContainerType that = (PBmmIndexedContainerType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmIndexedContainerType.java
                Objects.equals(indexType, that.indexType) &&
                        Objects.equals(bmmType, that.bmmType);
=======
                java.util.Objects.equals(indexType, that.indexType) &&
                        java.util.Objects.equals(bmmType, that.bmmType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmIndexedContainerType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                indexType,
                bmmType
        );
    }

    @Override
    public String toString() {
        return
                "PBmmIndexedContainerType {" +
                        "indexType='" + indexType + '\'' +
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
