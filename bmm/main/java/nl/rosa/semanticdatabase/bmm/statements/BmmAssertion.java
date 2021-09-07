package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A statement that asserts the truth of its expression.
 * If not, generates an exception (depending on run-time settings).
 * May be rendered in syntax as assert condition or similar.
 */
public class BmmAssertion extends BmmStatement {

    //***** BmmAssertion *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    private ElBooleanExpression expression;

    /**
     * Optional tag, typically used to designate design intention of the assertion, e.g.
     * "Inv_all_members_valid".
     * cardinality: 0..1
     */
    private String tag;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    public ElBooleanExpression getExpression() {
        return expression;
    }

    public void setExpression(ElBooleanExpression value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:expression failed, it has cardinality NonNull, but is null");
        }
        this.expression = expression;
    }

    /**
     * Optional tag, typically used to designate design intention of the assertion, e.g.
     * "Inv_all_members_valid".
     * cardinality: 0..1
     */
    public String getTag() {
        return tag;
    }

    public void setTag(String value) {
        this.tag = tag;
    }

    //***** BmmAssertion *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmAssertion() {
    }

    public BmmAssertion(
            ElBooleanExpression expression,
            String tag
    ) {
        if (expression == null) {
            throw new NullPointerException("Property:expression has cardinality NonNull, but is null");
        }
        this.expression = expression;
        this.tag = tag;
    }

    private BmmAssertion(Builder builder) {
        this.setExpression(builder.expression);
        this.setTag(builder.tag);
    }

    public static class Builder {
        private final ElBooleanExpression expression;  //required
        private String tag;

        public Builder(
                ElBooleanExpression expression
        ) {
            if (expression == null) {
                throw new NullPointerException("Property:expression has cardinality NonNull, but is null");
            }
            this.expression = expression;
        }

        public Builder setTag(String value) {
            this.tag = tag;
            return this;
        }

        public BmmAssertion build() {
            return new BmmAssertion(this);
        }
    }


    //***** BmmAssertion *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmAssertion that = (BmmAssertion) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmAssertion.java
                Objects.equals(expression, that.expression) &&
                        Objects.equals(tag, that.tag);
=======
                java.util.Objects.equals(expression, that.expression) &&
                        java.util.Objects.equals(tag, that.tag);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmAssertion.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                expression,
                tag
        );
    }

    @Override
    public String toString() {
        return
                "BmmAssertion {" +
                        "expression='" + expression + '\'' +
                        "tag='" + tag + '\'' +
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
