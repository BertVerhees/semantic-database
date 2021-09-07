package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmm.class_features.BmmOperator;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract parent of operator types.
 */
public abstract class ElOperator extends ElSimple {

    //***** ElOperator *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
     * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
     * cardinality: 0..1
     */
    private Boolean precedenceOverridden;

    /**
     * The symbol actually used in the expression, or intended to be used for serialisation.
     * Must be a member of OPERATOR_DEF.symbols.
     * cardinality: 0..1
     */
    private String symbol;

    /**
     * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
     * cardinality: 1..1
     */
    private BmmFunction definition;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
     * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
     * cardinality: 0..1
     */
    public Boolean getPrecedenceOverridden() {
        return precedenceOverridden;
    }

    public void setPrecedenceOverridden(Boolean value) {
        this.precedenceOverridden = precedenceOverridden;
    }

    /**
     * The symbol actually used in the expression, or intended to be used for serialisation.
     * Must be a member of OPERATOR_DEF.symbols.
     * cardinality: 0..1
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String value) {
        this.symbol = symbol;
    }

    /**
     * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
     * cardinality: 1..1
     */
    public BmmFunction getDefinition() {
        return definition;
    }

    public void setDefinition(BmmFunction value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:definition failed, it has cardinality NonNull, but is null");
        }
        this.definition = definition;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Operator definition derived from definition.operator_definition().
     * cardinality: 1..1
     */
    public BmmOperator operatorDefinition() {
        BmmOperator result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Function call equivalent to this operator.
     * cardinality: 1..1
     */
    public ElFunctionCall equivalentCall() {
        ElFunctionCall result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElOperator *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElOperator() {
    }

    protected ElOperator(
            Boolean precedenceOverridden,
            String symbol,
            BmmFunction definition
    ) {
        if (definition == null) {
            throw new NullPointerException("Property:definition has cardinality NonNull, but is null");
        }
        this.precedenceOverridden = precedenceOverridden;
        this.symbol = symbol;
        this.definition = definition;
    }


    //***** ElOperator *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElOperator that = (ElOperator) object;
        return
                java.util.Objects.equals(precedenceOverridden, that.precedenceOverridden) &&
                        java.util.Objects.equals(symbol, that.symbol) &&
                        java.util.Objects.equals(definition, that.definition);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                precedenceOverridden,
                symbol,
                definition
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "ElOperator {" +
                        "precedenceOverridden='" + precedenceOverridden + '\'' +
                        "symbol='" + symbol + '\'' +
                        "definition='" + definition + '\'' +
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
