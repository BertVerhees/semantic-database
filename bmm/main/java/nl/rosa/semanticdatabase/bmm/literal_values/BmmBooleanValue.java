package nl.rosa.semanticdatabase.bmm.literal_values;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE representing Boolean and value is of type Boolean.
 */
public class BmmBooleanValue extends BmmPrimitiveValue {

    //***** BmmBooleanValue *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Native Boolean value.
     * cardinality: 1..1 (redefined)
     */
    private Boolean value;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Native Boolean value.
     * cardinality: 1..1 (redefined)
     */
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:value failed, it has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    //***** BmmBooleanValue *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmBooleanValue() {
    }

    public BmmBooleanValue(
            Boolean value,
            BmmSimpleType type,
            BmmUnitaryType type,
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
    ) {
        super(
                type,
                type,
                valueLiteral,
                syntax,
                type
        );
        if (value == null) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    private BmmBooleanValue(Builder builder) {
        this.setValue(builder.value);
        this.setType(builder.type);
        this.setType(builder.type);
        this.setValueLiteral(builder.valueLiteral);
        this.setValue(builder.value);
        this.setSyntax(builder.syntax);
        this.setType(builder.type);
    }

    public static class Builder {
        private final Boolean value;  //required
        private final BmmSimpleType type;  //required
        private final BmmUnitaryType type;  //required
        private final String valueLiteral;  //required
        private Any value;
        private String syntax;
        private final BmmType type;  //required

        public Builder(
                Boolean value,
                BmmSimpleType type,
                BmmUnitaryType type,
                String valueLiteral,
                BmmType type
        ) {
            if (value == null) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (valueLiteral == null) {
                throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            this.value = value;
            this.type = type;
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

        public BmmBooleanValue build() {
            return new BmmBooleanValue(this);
        }
    }


    //***** BmmBooleanValue *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmBooleanValue that = (BmmBooleanValue) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/literal_values/BmmBooleanValue.java
                Objects.equals(value, that.value);
=======
                java.util.Objects.equals(value, that.value);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/literal_values/BmmBooleanValue.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                value
        );
    }

    @Override
    public String toString() {
        return
                "BmmBooleanValue {" +
                        "value='" + value + '\'' +
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
