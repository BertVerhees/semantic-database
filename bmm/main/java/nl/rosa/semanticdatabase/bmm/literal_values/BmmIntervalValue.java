package nl.rosa.semanticdatabase.bmm.literal_values;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type for literal intervals of type Interval<Ordered>.
 */
public class BmmIntervalValue extends BmmLiteralValue {

    //***** BmmIntervalValue *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmIntervalValue() {
    }

    public BmmIntervalValue(
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
    ) {
        super(
                valueLiteral,
                value,
                syntax,
                type
        );
    }

    private BmmIntervalValue(Builder builder) {
        this.setValueLiteral(builder.valueLiteral);
        this.setValue(builder.value);
        this.setSyntax(builder.syntax);
        this.setType(builder.type);
    }

    public static class Builder {
        private final String valueLiteral;  //required
        private Any value;
        private String syntax;
        private final BmmType type;  //required

        public Builder(
                String valueLiteral,
                BmmType type
        ) {
            if (valueLiteral == null) {
                throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
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

        public BmmIntervalValue build() {
            return new BmmIntervalValue(this);
        }
    }


    //***** BmmIntervalValue *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "BmmIntervalValue {" +
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
