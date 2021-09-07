package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

import java.util.List;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Purpose Abstract parent of C_ORDERED types whose base type is an ISO date/time type.
 */
public abstract class CTemporal<T> extends COrdered<T> {

    //***** CTemporal<t> *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Optional alternative constraint in the form of a pattern based on ISO8601.
     * See descendants for details.
     * cardinality: 0..1
     */
    private String patternConstraint;



    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Optional alternative constraint in the form of a pattern based on ISO8601.
     * See descendants for details.
     * cardinality: 0..1
     */
    public String getPatternConstraint() {
        return patternConstraint;
    }

    public void setPatternConstraint(String value) {
        this.patternConstraint = patternConstraint;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if a_pattern is a valid constraint.
     * Define in concrete descendants.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean validPatternConstraint(String a_pattern);

    /**
     * Return True if a_pattern can be replaced by an_other_pattern in a specialised constraint.
     * Define in concrete subtypes.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean validPatternConstraintReplacement(String a_pattern, String an_other_pattern);

    /**
     * True if any value (i.e.
     * instance) of the reference model type would be allowed.
     * Redefined in descendants.
     * cardinality: 1..1 (effected)
     */
    public Boolean anyAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if precursor() or else other.pattern_constraint is empty, or else pattern_constraint is a valid (narrower) replacement for other.pattern_constraint.
     * cardinality: 1..1 (effected)
     */
    public Boolean cValueConformsTo(CTemporal other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if precursor (other) and pattern_constraint ~ other.pattern_constraint, i.e.
     * either both Void or else both non-Void and identical.
     * cardinality: 1..1 (effected)
     */
    public Boolean cValueCongruentTo(CTemporal other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** CTemporal<t> *****

    /*=========================================================*/
    /* * CONSTRUCTOR * */
    /*=========================================================*/

    protected CTemporal(
            String patternConstraint,
            //CDefinedObject
            //CPrimitiveObject
            T assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<Interval<T>> constraint,
            //CDefinedObject
            T defaultValue,
            //CObject
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            //ArchetypeConstraint
            ArchetypeConstraint parent,
            CSecondOrder socParent
    ) {
        super(
                assumedValue,
                isEnumeratedTypeConstraint,
                constraint,
                defaultValue,
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent
        );
        this.patternConstraint = patternConstraint;
    }
    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CTemporal that = (CTemporal) object;
        return
                Objects.equals(patternConstraint, that.patternConstraint);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                patternConstraint
        );
    }

    @Override
    public String toString() {
        return
                "CTemporal<t> {" +
                        "patternConstraint='" + patternConstraint + '\'' +
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
