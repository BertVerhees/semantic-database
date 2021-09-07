package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.classes.BmmGenericClass;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type based on a non-container generic class, e.g.
 * Packet<Header>.
 */
public class BmmGenericType extends BmmModelType {

    //***** BmmGenericType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Generic parameters of the root_type in this type specifier.
     * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
     * cardinality: 1..1
     */
    private List<BmmUnitaryType> genericParameters = new ArrayList<>();

    /**
     * Defining generic class of this type.
     * cardinality: 1..1 (redefined)
     */
    private BmmGenericClass baseClass;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Generic parameters of the root_type in this type specifier.
     * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
     * cardinality: 1..1
     */

    public void addToGenericParameter(BmmUnitaryType value) {
        genericParameters.add(value);
    }

    public void addToGenericParameters(List<BmmUnitaryType> values) {
        values.forEach(value -> addToGenericparameter(value));
    }

    public void removeFromGenericParameter(BmmUnitaryType item) {
        if (genericParameters != null) {
            genericParameters.remove(item);
        }
    }

    public void removeFromGenericParameters(Collection<BmmUnitaryType> values) {
        values.forEach(this::removeFromGenericParameter);
    }

    List<BmmUnitaryType> getGenericParameters() {
        return this.genericParameters;
    }

    public BmmGenericType setGenericParameters(List<BmmUnitaryType> genericParameters) {
        if (genericParameters == null) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        return this;
    }

    public List<BmmUnitaryType> genericParameters() {
        return Collections.unmodifiableList(this.genericParameters);
    }

    /**
     * Defining generic class of this type.
     * cardinality: 1..1 (redefined)
     */
    public BmmGenericClass getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(BmmGenericClass value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:baseClass failed, it has cardinality NonNull, but is null");
        }
        this.baseClass = baseClass;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return the full name of the type including generic parameters, e.g.
     * DV_INTERVAL<T>, TABLE<List<THING>,String>.
     * cardinality: 1..1 (effected)
     */
    public String typeName() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Signature form of the type, which for generics includes generic parameter constrainer types E.g.
     * Interval<T:Ordered>.
     * cardinality: 1..1 (redefined)
     */
    public String typeSignature() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
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
     * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
     * cardinality: 1..1 (effected)
     */
    public List<String> flattenedTypeList() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Returns True if there is any substituted generic parameter.
     * cardinality: 1..1
     */
    public Boolean isPartiallyClosed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Effective underlying class for this type, abstracting away any container type.
     * cardinality: 1..1
     */
    public BmmGenericClass effectiveBaseClass() {
        BmmGenericClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if all generic parameters from ancestor generic types have been substituted in this type.
     * cardinality: 1..1
     */
    public Boolean isOpen() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmGenericType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmGenericType() {
    }

    public BmmGenericType(
            List<bmmUnitaryType> genericParameters,
            BmmGenericClass baseClass,
            BmmValueSetSpec valueConstraint,
            BmmClass baseClass
    ) {
        super(
                valueConstraint
        );
        if (genericParameters == null) {
            throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
        }
        if (baseClass == null) {
            throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        this.baseClass = baseClass;
    }

    private BmmGenericType(Builder builder) {
        this.setGenericParameters(builder.genericParameters);
        this.setBaseClass(builder.baseClass);
        this.setValueConstraint(builder.valueConstraint);
        this.setBaseClass(builder.baseClass);
    }

    public static class Builder {
        private final List<bmmUnitaryType> genericParameters;  //required
        private final BmmGenericClass baseClass;  //required
        private BmmValueSetSpec valueConstraint;
        private final BmmClass baseClass;  //required

        public Builder(
                List<bmmUnitaryType> genericParameters,
                BmmGenericClass baseClass,
                BmmClass baseClass
        ) {
            if (genericParameters == null) {
                throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
            }
            if (baseClass == null) {
                throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
            }
            if (baseClass == null) {
                throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
            }
            this.genericParameters = genericParameters;
            this.baseClass = baseClass;
            this.baseClass = baseClass;
        }

        public Builder setValueConstraint(BmmValueSetSpec value) {
            this.valueConstraint = valueConstraint;
            return this;
        }

        public BmmGenericType build() {
            return new BmmGenericType(this);
        }
    }


    //***** BmmGenericType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmGenericType that = (BmmGenericType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/types/BmmGenericType.java
                Objects.equals(genericParameters, that.genericParameters) &&
                        Objects.equals(baseClass, that.baseClass);
=======
                java.util.Objects.equals(genericParameters, that.genericParameters) &&
                        java.util.Objects.equals(baseClass, that.baseClass);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/types/BmmGenericType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                genericParameters,
                baseClass
        );
    }

    @Override
    public String toString() {
        return
                "BmmGenericType {" +
                        "genericParameters='" + genericParameters + '\'' +
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
