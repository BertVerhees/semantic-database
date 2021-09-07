package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Non-entity meta-type that expresses the type structure of any referenceable element of a model.
 * Consists of potential arguments and result, with constraints in descendants determining the exact form.
 */
public class BmmSignature extends BmmEffectiveType {

    //***** BmmSignature *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
     * cardinality: 0..1
     */
    private BmmTupleType argumentTypes;

    /**
     * Result type of signature, if any.
     * cardinality: 0..1
     */
    private BmmType resultType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
     * cardinality: 0..1
     */
    public BmmTupleType getArgumentTypes() {
        return argumentTypes;
    }

    public void setArgumentTypes(BmmTupleType value) {
        this.argumentTypes = argumentTypes;
    }

    /**
     * Result type of signature, if any.
     * cardinality: 0..1
     */
    public BmmType getResultType() {
        return resultType;
    }

    public void setResultType(BmmType value) {
        this.resultType = resultType;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * Return base_name.
 * cardinality: 1..1 (effected)
 *
 */
    public Result.is_equal(

    base_name())

    typeBaseName() {
        Result.is_equal(base_name()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Result = False.
     * cardinality: 1..1 (effected)
     */
    public Boolean isAbstract() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Result = True.
     * cardinality: 1..1 (effected)
     */
    public Boolean isPrimitive() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

/**
 *
 * Return base_name
 * cardinality: 1..1 (effected)
 *
 */
    public Result.is_equal(

    base_name())

    typeName() {
        Result.is_equal(base_name()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return the logical set (i.e.
     * unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
     * cardinality: 1..1 (effected)
     */
    public List<String> flattenedTypeList() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Base name (built-in).
     */
    final String baseName = "Signature";

    //***** BmmSignature *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmSignature() {
    }

    public BmmSignature(
            BmmTupleType argumentTypes,
            BmmType resultType
    ) {
        this.argumentTypes = argumentTypes;
        this.resultType = resultType;
    }

    private BmmSignature(Builder builder) {
        this.setArgumentTypes(builder.argumentTypes);
        this.setResultType(builder.resultType);
    }

    public static class Builder {
        private BmmTupleType argumentTypes;
        private BmmType resultType;

        public Builder(
        ) {
        }

        public Builder setArgumentTypes(BmmTupleType value) {
            this.argumentTypes = argumentTypes;
            return this;
        }

        public Builder setResultType(BmmType value) {
            this.resultType = resultType;
            return this;
        }

        public BmmSignature build() {
            return new BmmSignature(this);
        }
    }


    //***** BmmSignature *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmSignature that = (BmmSignature) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/types/BmmSignature.java
                Objects.equals(argumentTypes, that.argumentTypes) &&
                        Objects.equals(resultType, that.resultType);
=======
                java.util.Objects.equals(argumentTypes, that.argumentTypes) &&
                        java.util.Objects.equals(resultType, that.resultType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/types/BmmSignature.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                argumentTypes,
                resultType
        );
    }

    @Override
    public String toString() {
        return
                "BmmSignature {" +
                        "argumentTypes='" + argumentTypes + '\'' +
                        "resultType='" + resultType + '\'' +
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
