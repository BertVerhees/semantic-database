package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract idea of specifying a type in some context.
 * This is not the same as 'defining' a class.
 * A type specification is essentially a reference of some kind, that defines the type of an attribute, or function result or argument.
 * It may include generic parameters that might or might not be bound.
 * See subtypes.
 */
public abstract class BmmType {

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Formal string form of the type as per UML.
     * cardinality: 1..1 (abstract)
     */
    public abstract String typeName();

    /**
     * Signature form of the type name, which for generics includes generic parameter constrainer types E.g.
     * Interval<T:Ordered>.
     * Defaults to the value of type_name().
     * cardinality: 1..1
     */
    public String typeSignature() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * If true, indicates an abstract class in a BMM model, or a type based on an abstract class, i.e.
     * a type that cannot be directly instantiated.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean isAbstract();

    /**
     * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set, i.e.
     * be a primitive type, or be a definer of one.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean isPrimitive();

    /**
     * Type with any container abstracted away; may be a formal generic type.
     * cardinality: 1..1 (abstract)
     */
    public abstract BmmUnitaryType unitaryType();

    /**
     * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
     * cardinality: 1..1 (abstract)
     */
    public abstract BmmEffectiveType effectiveType();

    /**
     * Completely flattened list of type names, flattening out all generic parameters.
     * cardinality: 1..1 (abstract)
     */
    public abstract List<String> flattenedTypeList();

    //***** BmmType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmType() {
    }

    protected BmmType(

    ) {
    }


    //***** BmmType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "BmmType {" +
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
