package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract parent of primitive constrainer classes based on Ordered base types, i.e.
 * types like Integer, Real, and the Date/Time types.
 * The model constraint is a List of Intervals, which may include point Intervals, and acts as a efficient and formally tractable representation of any number of point values and/or contiguous intervals of an ordered value domain.
 * In its simplest form, the constraint accessor returns just a single point Interval<T> object, representing a single value.
 * The next simplest form is a single proper Interval <T> (i.e.
 * normal two-sided or half-open interval).
 * The most complex form is a list of any combination of point and proper intervals.
 */
public abstract class COrdered<T> extends CPrimitiveObject<Interval<T>, T> {

/*
    //***** COrdered<t> *****

    */
    /*=========================================================*//*

     */
    /* * FIELDS * *//*

     */
    /*=========================================================*//*


     */
/**
 * Constraint in the form of a List of Intervals of the parameter type T.
 * Concrete types generated in descendants via template binding.
 * cardinality: 0..1 (redefined)
 *//*

    private List<Interval<T>> constraint;

    */
/**
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 *//*

    private T defaultValue;

    */
/**
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 *//*

    private T assumedValue;

    */
    /*=========================================================*//*

     */
    /* * POJOS * *//*

     */
    /*=========================================================*//*


     */
/**
 * Constraint in the form of a List of Intervals of the parameter type T.
 * Concrete types generated in descendants via template binding.
 * cardinality: 0..1 (redefined)
 *//*


    public void addToConstraint(Interval<T> value) {
        if (constraint == null) {
            constraint = new ArrayList<>();
        }
        constraint.add(value);
    }

    public void removeFromConstraint(Interval<T> item) {
        if (constraint != null) {
            constraint.remove(item);
        }
    }

    */
/**
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 *//*

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object value) {
        this.defaultValue = defaultValue;
    }

    */
/**
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 *//*

    public T getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(Object value) {
        this.assumedValue = assumedValue;
    }

*/
    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if any value (i.e.
     * instance) of the reference model type would be allowed.
     * Redefined in descendants.
     * cardinality: 1..1 (effected)
     */
/*
    public Boolean anyAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }
*/

    /**
     * True if other.any_allowed or else for every constraint in the constraint list there is a constraint in other.constraint that contains it.
     * cardinality: 1..1 (effected)
     */
    public Boolean cValueConformsTo(COrdered other) {
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
     * True if the items in constraint are equal in number and identical pair-wise with those in other.constraint.
     * cardinality: 1..1 (effected)
     */
    public Boolean cValueCongruentTo(COrdered other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    @Override
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }

        if (!super.cConformsTo(other, rmTypesConformant)) {
            return false;
        }
        //now guaranteed to be the same class

        COrdered<?> o = (COrdered) other;
        if (o.getConstraint().isEmpty()) {
            return true;
        }


        for (Interval<T> constraint : getConstraint()) {
            boolean found = false;
            for (Interval otherConstraint : o.getConstraint()) {
                if (otherConstraint.contains(constraint)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /*=========================================================*/
    /* * CONSTRUCTOR * */
    /*=========================================================*/

    protected COrdered(
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
                socParent);
    }

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        COrdered that = (COrdered) object;
        return
                Objects.equals(constraint, that.constraint) &&
                        Objects.equals(defaultValue, that.defaultValue) &&
                        Objects.equals(assumedValue, that.assumedValue);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                constraint,
                defaultValue,
                assumedValue
        );
    }

    @Override
    public String toString() {
        return
                "COrdered<t> {" +
                        "constraint='" + constraint + '\'' +
                        "defaultValue='" + defaultValue + '\'' +
                        "assumedValue='" + assumedValue + '\'' +
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
