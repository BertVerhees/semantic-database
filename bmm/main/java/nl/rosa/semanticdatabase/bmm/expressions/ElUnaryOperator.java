package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Unary operator expression node.
 */
public class ElUnaryOperator extends ElOperator {

    //***** ElUnaryOperator *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Operand node.
     * cardinality: 1..1
     */
    private ElSimple operand;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Operand node.
     * cardinality: 1..1
     */
    public ElSimple getOperand() {
        return operand;
    }

    public void setOperand(ElSimple value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:operand failed, it has cardinality NonNull, but is null");
        }
        this.operand = operand;
    }

    //***** ElUnaryOperator *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElUnaryOperator() {
    }

    public ElUnaryOperator(
            ElSimple operand,
            Boolean precedenceOverridden,
            String symbol,
            BmmFunction definition
    ) {
        super(
                precedenceOverridden,
                symbol,
                definition
        );
        if (operand == null) {
            throw new NullPointerException("Property:operand has cardinality NonNull, but is null");
        }
        this.operand = operand;
    }

    private ElUnaryOperator(Builder builder) {
        this.setOperand(builder.operand);
        this.setPrecedenceOverridden(builder.precedenceOverridden);
        this.setSymbol(builder.symbol);
        this.setDefinition(builder.definition);
    }

    public static class Builder {
        private final ElSimple operand;  //required
        private Boolean precedenceOverridden;
        private String symbol;
        private final BmmFunction definition;  //required

        public Builder(
                ElSimple operand,
                BmmFunction definition
        ) {
            if (operand == null) {
                throw new NullPointerException("Property:operand has cardinality NonNull, but is null");
            }
            if (definition == null) {
                throw new NullPointerException("Property:definition has cardinality NonNull, but is null");
            }
            this.operand = operand;
            this.definition = definition;
        }

        public Builder setPrecedenceOverridden(Boolean value) {
            this.precedenceOverridden = precedenceOverridden;
            return this;
        }

        public Builder setSymbol(String value) {
            this.symbol = symbol;
            return this;
        }

        public ElUnaryOperator build() {
            return new ElUnaryOperator(this);
        }
    }


    //***** ElUnaryOperator *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElUnaryOperator that = (ElUnaryOperator) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElUnaryOperator.java
                Objects.equals(operand, that.operand);
=======
                java.util.Objects.equals(operand, that.operand);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElUnaryOperator.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                operand
        );
    }

    @Override
    public String toString() {
        return
                "ElUnaryOperator {" +
                        "operand='" + operand + '\'' +
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
