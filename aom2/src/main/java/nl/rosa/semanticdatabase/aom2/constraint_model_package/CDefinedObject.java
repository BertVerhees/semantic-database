package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract parent type of C_OBJECT subtypes that are defined by value, i.e.
 * whose definitions are actually in the archetype rather than being by reference.
 */
public abstract class CDefinedObject<T> extends CObject {

    //***** CDefinedObject *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1
     */
    private T defaultValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1
     */
    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T value) {
        this.defaultValue = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if any value (i.e.
     * instance) of the reference model type would be allowed.
     * Redefined in descendants.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean anyAllowed();

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean validValue(T a_value);

    /**
     * Generate a prototype value from this constraint object.
     * cardinality: 1..1 (abstract)
     */
    public abstract T prototypeValue();

    /**
     * True if there is an assumed value.
     * cardinality: 1..1
     */
    public Boolean hasDefaultValue() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** CDefinedObject *****
    /*=========================================================*/
    /* * CONSTRUCTOR * */
    /*=========================================================*/

    protected CDefinedObject(
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
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent);
        this.defaultValue = defaultValue;
    }


    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CDefinedObject that = (CDefinedObject) object;
        return
                Objects.equals(defaultValue, that.defaultValue);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                defaultValue
        );
    }

    @Override
<<<<<<< HEAD
    public String toString() {
=======
    public java.lang.String toString() {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        return
                "CDefinedObject {" +
                        "defaultValue='" + defaultValue + '\'' +
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
