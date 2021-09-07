package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Binary operator expression node.
 */
public class ElBinaryOperator extends ElOperator {

    //***** ElBinaryOperator *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Left operand node.
     * cardinality: 1..1
     */
    private ElSimple leftOperand;

    /**
     * Right operand node.
     * cardinality: 1..1
     */
    private ElTerminal rightOperand;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Left operand node.
     * cardinality: 1..1
     */
    public ElSimple getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(ElSimple value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:leftOperand failed, it has cardinality NonNull, but is null");
        }
        this.leftOperand = leftOperand;
    }

    /**
     * Right operand node.
     * cardinality: 1..1
     */
    public ElTerminal getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(ElTerminal value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rightOperand failed, it has cardinality NonNull, but is null");
        }
        this.rightOperand = rightOperand;
    }

    //***** ElBinaryOperator *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElBinaryOperator() {
    }

    public ElBinaryOperator(
            ElSimple leftOperand,
            ElTerminal rightOperand,
            Boolean precedenceOverridden,
            String symbol,
            BmmFunction definition
    ) {
        super(
                precedenceOverridden,
                symbol,
                definition
        );
        if (leftOperand == null) {
            throw new NullPointerException("Property:leftOperand has cardinality NonNull, but is null");
        }
        if (rightOperand == null) {
            throw new NullPointerException("Property:rightOperand has cardinality NonNull, but is null");
        }
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    private ElBinaryOperator(Builder builder) {
        this.setLeftOperand(builder.leftOperand);
        this.setRightOperand(builder.rightOperand);
        this.setPrecedenceOverridden(builder.precedenceOverridden);
        this.setSymbol(builder.symbol);
        this.setDefinition(builder.definition);
    }

    public static class Builder {
        private final ElSimple leftOperand;  //required
        private final ElTerminal rightOperand;  //required
        private Boolean precedenceOverridden;
        private String symbol;
        private final BmmFunction definition;  //required

        public Builder(
                ElSimple leftOperand,
                ElTerminal rightOperand,
                BmmFunction definition
        ) {
            if (leftOperand == null) {
                throw new NullPointerException("Property:leftOperand has cardinality NonNull, but is null");
            }
            if (rightOperand == null) {
                throw new NullPointerException("Property:rightOperand has cardinality NonNull, but is null");
            }
            if (definition == null) {
                throw new NullPointerException("Property:definition has cardinality NonNull, but is null");
            }
            this.leftOperand = leftOperand;
            this.rightOperand = rightOperand;
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

        public ElBinaryOperator build() {
            return new ElBinaryOperator(this);
        }
    }


    //***** ElBinaryOperator *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElBinaryOperator that = (ElBinaryOperator) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElBinaryOperator.java
                Objects.equals(leftOperand, that.leftOperand) &&
                        Objects.equals(rightOperand, that.rightOperand);
=======
                java.util.Objects.equals(leftOperand, that.leftOperand) &&
                        java.util.Objects.equals(rightOperand, that.rightOperand);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElBinaryOperator.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                leftOperand,
                rightOperand
        );
    }

    @Override
    public String toString() {
        return
                "ElBinaryOperator {" +
                        "leftOperand='" + leftOperand + '\'' +
                        "rightOperand='" + rightOperand + '\'' +
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
