package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Conditional structure used in condition chain expressions.
 * Evaluated by evaluating its condition, which is a Boolean-returning expression, and if this returns True, the result is the evaluation result of expression.
 */
public class ElConditionalExpression extends ElDecisionBranch {

    //***** ElConditionalExpression *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Gate expression that acts as the condition under which the target expression is returned.
     * cardinality: 1..1
     */
    private ElSimple condition;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Gate expression that acts as the condition under which the target expression is returned.
     * cardinality: 1..1
     */
    public ElSimple getCondition() {
        return condition;
    }

    public void setCondition(ElSimple value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:condition failed, it has cardinality NonNull, but is null");
        }
        this.condition = condition;
    }

    //***** ElConditionalExpression *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElConditionalExpression() {
    }

    public ElConditionalExpression(
            ElSimple condition,
            ElExpression result
    ) {
        super(
                result
        );
        if (condition == null) {
            throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
        }
        this.condition = condition;
    }

    private ElConditionalExpression(Builder builder) {
        this.setCondition(builder.condition);
        this.setResult(builder.result);
    }

    public static class Builder {
        private final ElSimple condition;  //required
        private final ElExpression result;  //required

        public Builder(
                ElSimple condition,
                ElExpression result
        ) {
            if (condition == null) {
                throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
            }
            if (result == null) {
                throw new NullPointerException("Property:result has cardinality NonNull, but is null");
            }
            this.condition = condition;
            this.result = result;
        }

        public ElConditionalExpression build() {
            return new ElConditionalExpression(this);
        }
    }


    //***** ElConditionalExpression *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElConditionalExpression that = (ElConditionalExpression) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConditionalExpression.java
                Objects.equals(condition, that.condition);
=======
                java.util.Objects.equals(condition, that.condition);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConditionalExpression.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                condition
        );
    }

    @Override
    public String toString() {
        return
                "ElConditionalExpression {" +
                        "condition='" + condition + '\'' +
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
