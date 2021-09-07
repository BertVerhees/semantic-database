package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.classes.BmmValueSetSpec;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A type that is defined by a class (or classes) in the model.
 */
public abstract class BmmModelType extends BmmEffectiveType {

    //***** BmmModelType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * cardinality: 0..1
     */
    private BmmValueSetSpec valueConstraint;

    /**
     * Base class of this type.
     * cardinality: 1..1
     */
    private BmmClass baseClass;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * cardinality: 0..1
     */
    public BmmValueSetSpec getValueConstraint() {
        return valueConstraint;
    }

    public void setValueConstraint(BmmValueSetSpec value) {
        this.valueConstraint = valueConstraint;
    }

    /**
     * Base class of this type.
     * cardinality: 1..1
     */
    public BmmClass getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(BmmClass value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:baseClass failed, it has cardinality NonNull, but is null");
        }
        this.baseClass = baseClass;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Result = base_class.name.
     * cardinality: 1..1 (effected)
     */
    public String typeBaseName() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Result = base_class.is_primitive.
     * cardinality: 1..1 (effected)
     */
    public Boolean isPrimitive() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmModelType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmModelType() {
    }

    protected BmmModelType(
            BmmValueSetSpec valueConstraint,
            BmmClass baseClass
    ) {
        if (baseClass == null) {
            throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
        }
        this.valueConstraint = valueConstraint;
        this.baseClass = baseClass;
    }


    //***** BmmModelType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmModelType that = (BmmModelType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/types/BmmModelType.java
                Objects.equals(valueConstraint, that.valueConstraint) &&
                        Objects.equals(baseClass, that.baseClass);
=======
                java.util.Objects.equals(valueConstraint, that.valueConstraint) &&
                        java.util.Objects.equals(baseClass, that.baseClass);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/types/BmmModelType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                valueConstraint,
                baseClass
        );
    }

    @Override
    public String toString() {
        return
                "BmmModelType {" +
                        "valueConstraint='" + valueConstraint + '\'' +
                        "baseClass='" + baseClass + '\'' +
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
