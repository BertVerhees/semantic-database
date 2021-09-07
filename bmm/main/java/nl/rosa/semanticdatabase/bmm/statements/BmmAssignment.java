package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElExpression;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 */
public class BmmAssignment extends BmmStatement {

    //***** BmmAssignment *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The target variable on the notional left-hand side of this assignment.
     * cardinality: 1..1
     */
    private EL_INSTANTIABLE_REF target;

    /**
     * Source right hand side) of the assignment.
     * cardinality: 1..1
     */
    private ElExpression source;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The target variable on the notional left-hand side of this assignment.
     * cardinality: 1..1
     */
    public EL_INSTANTIABLE_REF getTarget() {
        return target;
    }

    public void setTarget(EL_INSTANTIABLE_REF value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:target failed, it has cardinality NonNull, but is null");
        }
        this.target = target;
    }

    /**
     * Source right hand side) of the assignment.
     * cardinality: 1..1
     */
    public ElExpression getSource() {
        return source;
    }

    public void setSource(ElExpression value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:source failed, it has cardinality NonNull, but is null");
        }
        this.source = source;
    }

    //***** BmmAssignment *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmAssignment() {
    }

    public BmmAssignment(
            ElInstantiableRef target,
            ElExpression source
    ) {
        if (target == null) {
            throw new NullPointerException("Property:target has cardinality NonNull, but is null");
        }
        if (source == null) {
            throw new NullPointerException("Property:source has cardinality NonNull, but is null");
        }
        this.target = target;
        this.source = source;
    }

    private BmmAssignment(Builder builder) {
        this.setTarget(builder.target);
        this.setSource(builder.source);
    }

    public static class Builder {
        private final ElInstantiableRef target;  //required
        private final ElExpression source;  //required

        public Builder(
                ElInstantiableRef target,
                ElExpression source
        ) {
            if (target == null) {
                throw new NullPointerException("Property:target has cardinality NonNull, but is null");
            }
            if (source == null) {
                throw new NullPointerException("Property:source has cardinality NonNull, but is null");
            }
            this.target = target;
            this.source = source;
        }

        public BmmAssignment build() {
            return new BmmAssignment(this);
        }
    }


    //***** BmmAssignment *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmAssignment that = (BmmAssignment) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmAssignment.java
                Objects.equals(target, that.target) &&
                        Objects.equals(source, that.source);
=======
                java.util.Objects.equals(target, that.target) &&
                        java.util.Objects.equals(source, that.source);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmAssignment.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                target,
                source
        );
    }

    @Override
    public String toString() {
        return
                "BmmAssignment {" +
                        "target='" + target + '\'' +
                        "source='" + source + '\'' +
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
