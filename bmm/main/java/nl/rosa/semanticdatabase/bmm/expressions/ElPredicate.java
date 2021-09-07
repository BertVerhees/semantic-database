package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Parent type of predicate of any object reference.
 */
public abstract class ElPredicate extends ElTerminal {

    //***** ElPredicate *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The target instance of this predicate.
     * cardinality: 1..1
     */
    private ElInstanceRef operand;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The target instance of this predicate.
     * cardinality: 1..1
     */
    public ElInstanceRef getOperand() {
        return operand;
    }

    public void setOperand(ElInstanceRef value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:operand failed, it has cardinality NonNull, but is null");
        }
        this.operand = operand;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return {BMM_MODEL}.boolean_type_definition().
     * cardinality: 1..1 (effected)
     */
    public BmmSimpleType evalType() {
        BmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElPredicate *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElPredicate() {
    }

    protected ElPredicate(
            ElInstanceRef operand
    ) {
        if (operand == null) {
            throw new NullPointerException("Property:operand has cardinality NonNull, but is null");
        }
        this.operand = operand;
    }


    //***** ElPredicate *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElPredicate that = (ElPredicate) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElPredicate.java
                Objects.equals(operand, that.operand);
=======
                java.util.Objects.equals(operand, that.operand);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElPredicate.java
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
                "ElPredicate {" +
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
