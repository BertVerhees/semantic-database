package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an association semantics with respect to the owning class.
 */
public abstract class BmmProperty extends BmmClassFeature implements BmmInstantiable {

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Interval form of 0..1, 1..1 etc, derived from is_nullable.
     * cardinality: 1..1
     */
    public MultiplicityInterval existence() {
        MultiplicityInterval result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Name of this property to display in UI.
     * cardinality: 1..1
     */
    public String displayName() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * True if this property is marked with info model im_runtime property.
     */
    final Boolean {
        default
        isImRuntime = false
    }

    ;

    /**
     * True if this property was marked with info model im_infrastructure flag.
     */
    final Boolean {
        default
        isImInfrastructure = false
    }

    ;

    /**
     * True if this property instance is a compositional sub-part of the owning class instance.
     * Equivalent to 'composition' in UML associations (but missing from UML properties without associations) and also 'cascade-delete' semantics in ER schemas.
     */
    final Boolean {
        default
        isComposition = false
    }

    ;

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * True if this element can be null (Void) at execution time.
     * May be interpreted as optionality in subtypes..
     */
    final Boolean {
        default
        isNullable = false
    }

    ;

    //***** BmmTyped *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1
     */
    private BmmType type;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1
     */
    public BmmType getType() {
        return type;
    }

    public void setType(BmmType value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * cardinality: 1..1
 *
 */
    public Result =

    type().

    equal( {
        BMM_MODEL
    }.

    boolean_type_definition())

    isBoolean() {
        Result = type().equal({BMM_MODEL}.boolean_type_definition()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmProperty *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmProperty() {
    }

    protected BmmProperty(
            BmmType type,
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                visibility,
                featureExtensions,
                group,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
    }


    //***** BmmProperty *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmProperty that = (BmmProperty) object;
        return
                java.util.Objects.equals(type, that.type);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                type
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "BmmProperty {" +
                        "type='" + type + '\'' +
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
