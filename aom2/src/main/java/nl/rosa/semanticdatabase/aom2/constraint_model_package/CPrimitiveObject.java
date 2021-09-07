package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import nl.rosa.semanticdatabase.utils.aom2_interfaces.ICPrimitiveObject;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Parent of types representing constraints on primitive types.
 */
public abstract class CPrimitiveObject<C, T> extends CDefinedObject<T> implements ICPrimitiveObject<C, T> {

    public static final String PRIMITIVE_NODE_ID_VALUE = "id9999";


    //***** CPrimitiveObject *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1
     */
    private T assumedValue;

    /**
     * True if this object represents a constraint on an enumerated type from the reference model, where the latter is assumed to be based on a primitive type, generally Integer or String.
     * cardinality: 0..1
     */
    private Boolean isEnumeratedTypeConstraint;

    /**
     * Constraint represented by this object; redefine in descendants.
     * cardinality: 1..1
     */
    private List<C> constraint;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1
     */
    public T getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(T value) {
        this.assumedValue = assumedValue;
    }

    /**
     * True if this object represents a constraint on an enumerated type from the reference model, where the latter is assumed to be based on a primitive type, generally Integer or String.
     * cardinality: 0..1
     */
    public Boolean getIsEnumeratedTypeConstraint() {
        return isEnumeratedTypeConstraint;
    }

    public void setIsEnumeratedTypeConstraint(Boolean value) {
        this.isEnumeratedTypeConstraint = isEnumeratedTypeConstraint;
    }

    /**
     * Constraint represented by this object; redefine in descendants.
     * cardinality: 1..1
     */
    public void addConstraint(C value) {
        if (constraint == null) {
            constraint = new ArrayList<>();
        }
        constraint.add(value);
    }

    public void removeConstraint(C item) {
        if (constraint != null) {
            constraint.remove(item);
        }
    }

    public abstract void setConstraint(List<C> constraint);

    public List<C> getConstraint() {
        return Collections.unmodifiableList(this.constraint);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if there is an assumed value.
     * cardinality: 1..1
     */
    public Boolean hasAssumedValue() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Generate name of native type that is constrained by this C_XXX type.
     * For most types, it is the C_XXX typename without the C_, i.e.
     * XXX.
     * E.g.
     * C_INTEGER → Integer.
     * For the date/time types the mapping is different.
     * cardinality: 1..1
     */
    public String constrainedTypename() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * Parameters rmcc Reference Model conformance checker lambda.
     * cardinality: 1..1 (effected)
     */
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return rmTypesConformant.apply(getRmTypeName(), ((CPrimitiveObject) other).getRmTypeName()) && cValueConformsTo((CPrimitiveObject) other);
    }

    /**
     * True if this node expresses a value constraint that conforms to that of other.
     * Effected in descendants.
     * cardinality: 1..1 (abstract)
     */
    public abstract boolean cValueConformsTo(CPrimitiveObject other);

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (effected)
     */
    public boolean cCongruentTo(ArchetypeConstraint other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return getRmTypeName().equalsIgnoreCase(((CObject) other).getRmTypeName()) && cValueCongruentTo((CPrimitiveObject) other);
    }

    /**
     * True if this node expresses the same value constraint as other.
     * Effected in descendants.
     * cardinality: 1..1 (abstract)
     */
    public abstract boolean cValueCongruentTo(CPrimitiveObject other);


    //***** CPrimitiveObject *****

    /*=========================================================*/
    /* * CONSTRUCTOR * */
    /*=========================================================*/

    public CPrimitiveObject(
            T assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<C> constraint,
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
        super(defaultValue, rmTypeName, occurrences, nodeId, isDeprecated, siblingOrder, parent, socParent);
        if (constraint == null) {
            throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
        }
        this.assumedValue = assumedValue;
        this.isEnumeratedTypeConstraint = isEnumeratedTypeConstraint;
        this.constraint = constraint;
    }


    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CPrimitiveObject that = (CPrimitiveObject) object;
        return
                Objects.equals(assumedValue, that.assumedValue) &&
                        Objects.equals(isEnumeratedTypeConstraint, that.isEnumeratedTypeConstraint) &&
                        Objects.equals(constraint, that.constraint);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                assumedValue,
                isEnumeratedTypeConstraint,
                constraint
        );
    }

    @Override
<<<<<<< HEAD
    public String toString() {
=======
    public java.lang.String toString() {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        return
                "CPrimitiveObject {" +
                        "assumedValue='" + assumedValue + '\'' +
                        "isEnumeratedTypeConstraint='" + isEnumeratedTypeConstraint + '\'' +
                        "constraint='" + constraint + '\'' +
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
