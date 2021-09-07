package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_SIMPLE_TYPE.
 */
public class PBmmSimpleType extends PBmmBaseType {

    //***** PBmmSimpleType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of type - must be a simple class name.
     * cardinality: 1..1
     */
    private String type;

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    private BmmSimpleType bmmType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of type - must be a simple class name.
     * cardinality: 1..1
     */
    public String getType() {
        return type;
    }

    public void setType(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    public BmmSimpleType getBmmType() {
        return bmmType;
    }

    public void setBmmType(BmmSimpleType value) {
        this.bmmType = bmmType;
    }

    //***** PBmmSimpleType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmSimpleType() {
    }

    public PBmmSimpleType(
            String type,
            BmmSimpleType bmmType,
            String valueConstraint,
            BmmType bmmType
    ) {
        super(
                valueConstraint
        );
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
        this.bmmType = bmmType;
    }

    private PBmmSimpleType(Builder builder) {
        this.setType(builder.type);
        this.setBmmType(builder.bmmType);
        this.setValueConstraint(builder.valueConstraint);
        this.setBmmType(builder.bmmType);
    }

    public static class Builder {
        private final String type;  //required
        private BmmSimpleType bmmType;
        private String valueConstraint;
        private BmmType bmmType;

        public Builder(
                String type
        ) {
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            this.type = type;
        }

        public Builder setBmmType(BmmSimpleType value) {
            this.bmmType = bmmType;
            return this;
        }

        public Builder setValueConstraint(String value) {
            this.valueConstraint = valueConstraint;
            return this;
        }

        public Builder setBmmType(BmmType value) {
            this.bmmType = bmmType;
            return this;
        }

        public PBmmSimpleType build() {
            return new PBmmSimpleType(this);
        }
    }


    //***** PBmmSimpleType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmSimpleType that = (PBmmSimpleType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSimpleType.java
                Objects.equals(type, that.type) &&
                        Objects.equals(bmmType, that.bmmType);
=======
                java.util.Objects.equals(type, that.type) &&
                        java.util.Objects.equals(bmmType, that.bmmType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSimpleType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                type,
                bmmType
        );
    }

    @Override
    public String toString() {
        return
                "PBmmSimpleType {" +
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
