package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A mutable entity whose scope is a routine.
 */
public abstract class BmmVariable extends BmmClassEntity implements BmmInstantiable {

    //***** BmmVariable *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Routine within which variable is defined.
     * cardinality: 1..1 (redefined)
     */
    private BmmRoutine scope;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Routine within which variable is defined.
     * cardinality: 1..1 (redefined)
     */
    public BmmRoutine getScope() {
        return scope;
    }

    public void setScope(BmmRoutine value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Formal signature of this element, in the form 'name [arg1_name: T_arg1, …​][:T_value]'.
     * cardinality: 1..1 (effected)
     */
    public void signature() {
    }

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

    //***** BmmVariable *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmVariable() {
    }

    protected BmmVariable(
            BmmRoutine scope,
            BmmType type,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                name,
                documentation,
                extensions
        );
        if (scope == null) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.scope = scope;
        this.type = type;
    }


    //***** BmmVariable *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmVariable that = (BmmVariable) object;
        return
                Objects.equals(scope, that.scope) &&
                        Objects.equals(type, that.type);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                scope,
                type
        );
    }

    @Override
    public String toString() {
        return
                "BmmVariable {" +
                        "scope='" + scope + '\'' +
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
