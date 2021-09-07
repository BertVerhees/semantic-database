package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Conditional, or 'gated' statement, consisting of a Boolean-returning condition and the target statement.
 */
public class BmmConditionalAction {

    //***** BmmConditionalAction *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The gate condition for the target statement.
     * cardinality: 1..1
     */
    private ElBooleanExpression condition;

    /**
     * Target statement.
     * cardinality: 1..1
     */
    private BmmStatementItem statement;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The gate condition for the target statement.
     * cardinality: 1..1
     */
    public ElBooleanExpression getCondition() {
        return condition;
    }

    public void setCondition(ElBooleanExpression value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:condition failed, it has cardinality NonNull, but is null");
        }
        this.condition = condition;
    }

    /**
     * Target statement.
     * cardinality: 1..1
     */
    public BmmStatementItem getStatement() {
        return statement;
    }

    public void setStatement(BmmStatementItem value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:statement failed, it has cardinality NonNull, but is null");
        }
        this.statement = statement;
    }

    //***** BmmConditionalAction *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmConditionalAction() {
    }

    public BmmConditionalAction(
            ElBooleanExpression condition,
            BmmStatementItem statement
    ) {
        if (condition == null) {
            throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
        }
        if (statement == null) {
            throw new NullPointerException("Property:statement has cardinality NonNull, but is null");
        }
        this.condition = condition;
        this.statement = statement;
    }

    private BmmConditionalAction(Builder builder) {
        this.setCondition(builder.condition);
        this.setStatement(builder.statement);
    }

    public static class Builder {
        private final ElBooleanExpression condition;  //required
        private final BmmStatementItem statement;  //required

        public Builder(
                ElBooleanExpression condition,
                BmmStatementItem statement
        ) {
            if (condition == null) {
                throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
            }
            if (statement == null) {
                throw new NullPointerException("Property:statement has cardinality NonNull, but is null");
            }
            this.condition = condition;
            this.statement = statement;
        }

        public BmmConditionalAction build() {
            return new BmmConditionalAction(this);
        }
    }


    //***** BmmConditionalAction *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmConditionalAction that = (BmmConditionalAction) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmConditionalAction.java
                Objects.equals(condition, that.condition) &&
                        Objects.equals(statement, that.statement);
=======
                java.util.Objects.equals(condition, that.condition) &&
                        java.util.Objects.equals(statement, that.statement);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmConditionalAction.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                condition,
                statement
        );
    }

    @Override
    public String toString() {
        return
                "BmmConditionalAction {" +
                        "condition='" + condition + '\'' +
                        "statement='" + statement + '\'' +
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
