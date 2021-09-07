package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract parent for second-order or constrained forms of first-order expression meta-types.
 */
public abstract class ElConstrained {

    //***** ElConstrained *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The base expression of this constrained form.
     * cardinality: 1..1
     */
    private ElExpression baseExpression;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The base expression of this constrained form.
     * cardinality: 1..1
     */
    public ElExpression getBaseExpression() {
        return baseExpression;
    }

    public void setBaseExpression(ElExpression value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:baseExpression failed, it has cardinality NonNull, but is null");
        }
        this.baseExpression = baseExpression;
    }

    //***** ElConstrained *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElConstrained() {
    }

    protected ElConstrained(
            ElExpression baseExpression
    ) {
        if (baseExpression == null) {
            throw new NullPointerException("Property:baseExpression has cardinality NonNull, but is null");
        }
        this.baseExpression = baseExpression;
    }


    //***** ElConstrained *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElConstrained that = (ElConstrained) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConstrained.java
                Objects.equals(baseExpression, that.baseExpression);
=======
                java.util.Objects.equals(baseExpression, that.baseExpression);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConstrained.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                baseExpression
        );
    }

    @Override
    public String toString() {
        return
                "ElConstrained {" +
                        "baseExpression='" + baseExpression + '\'' +
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
