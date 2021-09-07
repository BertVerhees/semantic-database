package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.aom2.constraint_model_package.CObject;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 */
public class ElCase extends ElDecisionBranch {

    //***** ElCase *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    private CObject valueConstraint;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    public CObject getValueConstraint() {
        return valueConstraint;
    }

    public void setValueConstraint(CObject value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:valueConstraint failed, it has cardinality NonNull, but is null");
        }
        this.valueConstraint = valueConstraint;
    }

    //***** ElCase *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElCase() {
    }

    public ElCase(
            CObject valueConstraint,
            ElExpression result
    ) {
        super(
                result
        );
        if (valueConstraint == null) {
            throw new NullPointerException("Property:valueConstraint has cardinality NonNull, but is null");
        }
        this.valueConstraint = valueConstraint;
    }

    private ElCase(Builder builder) {
        this.setValueConstraint(builder.valueConstraint);
        this.setResult(builder.result);
    }

    public static class Builder {
        private final CObject valueConstraint;  //required
        private final ElExpression result;  //required

        public Builder(
                CObject valueConstraint,
                ElExpression result
        ) {
            if (valueConstraint == null) {
                throw new NullPointerException("Property:valueConstraint has cardinality NonNull, but is null");
            }
            if (result == null) {
                throw new NullPointerException("Property:result has cardinality NonNull, but is null");
            }
            this.valueConstraint = valueConstraint;
            this.result = result;
        }

        public ElCase build() {
            return new ElCase(this);
        }
    }


    //***** ElCase *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElCase that = (ElCase) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElCase.java
                Objects.equals(valueConstraint, that.valueConstraint);
=======
                java.util.Objects.equals(valueConstraint, that.valueConstraint);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElCase.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                valueConstraint
        );
    }

    @Override
    public String toString() {
        return
                "ElCase {" +
                        "valueConstraint='" + valueConstraint + '\'' +
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
