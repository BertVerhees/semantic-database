package nl.rosa.semanticdatabase.bmm.literal_values;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmContainerType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type for literals whose concrete type is a linear container type, i.e.
 * array, list or set.
 */
public class BmmContainerValue extends BmmLiteralValue {

    //***** BmmContainerValue *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1 (redefined)
     */
    private BmmContainerType type;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

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

    //***** BmmContainerValue *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmContainerValue() {
    }

    public BmmContainerValue(
            BmmContainerType type,
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
    ) {
        super(
                valueLiteral,
                value,
                syntax
        );
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    private BmmContainerValue(Builder builder) {
        this.setType(builder.type);
        this.setValueLiteral(builder.valueLiteral);
        this.setValue(builder.value);
        this.setSyntax(builder.syntax);
        this.setType(builder.type);
    }

    public static class Builder {
        private final BmmContainerType type;  //required
        private final String valueLiteral;  //required
        private Any value;
        private String syntax;
        private final BmmType type;  //required

        public Builder(
                BmmContainerType type,
                String valueLiteral,
                BmmType type
        ) {
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (valueLiteral == null) {
                throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            this.type = type;
            this.valueLiteral = valueLiteral;
            this.type = type;
        }

        public Builder setValue(Any value) {
            this.value = value;
            return this;
        }

        public Builder setSyntax(String value) {
            this.syntax = syntax;
            return this;
        }

        public BmmContainerValue build() {
            return new BmmContainerValue(this);
        }
    }


    //***** BmmContainerValue *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmContainerValue that = (BmmContainerValue) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/literal_values/BmmContainerValue.java
                Objects.equals(type, that.type);
=======
                java.util.Objects.equals(type, that.type);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/literal_values/BmmContainerValue.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                type
        );
    }

    @Override
    public String toString() {
        return
                "BmmContainerValue {" +
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
