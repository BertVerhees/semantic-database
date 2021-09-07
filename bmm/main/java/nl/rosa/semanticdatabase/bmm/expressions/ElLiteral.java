package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Literal value of any type known in the model, including primitive types.
 * Defined via a BMM_LITERAL_VALUE.
 */
public class ElLiteral extends ElInstanceRef {

    //***** ElLiteral *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The reference item from which the value of this node can be computed.
     * cardinality: 1..1
     */
    private BmmLiteralValue value;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The reference item from which the value of this node can be computed.
     * cardinality: 1..1
     */
    public BmmLiteralValue getValue() {
        return value;
    }

    public void setValue(BmmLiteralValue value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:value failed, it has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return value.type.
     * cardinality: 1..1 (effected)
     */
    public BmmType evalType() {
        BmmType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElLiteral *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElLiteral() {
    }

    public ElLiteral(
            BmmLiteralValue value
    ) {
        if (value == null) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    private ElLiteral(Builder builder) {
        this.setValue(builder.value);
    }

    public static class Builder {
        private final BmmLiteralValue value;  //required

        public Builder(
                BmmLiteralValue value
        ) {
            if (value == null) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            this.value = value;
        }

        public ElLiteral build() {
            return new ElLiteral(this);
        }
    }


    //***** ElLiteral *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElLiteral that = (ElLiteral) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElLiteral.java
                Objects.equals(value, that.value);
=======
                java.util.Objects.equals(value, that.value);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElLiteral.java
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
                "ElLiteral {" +
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
