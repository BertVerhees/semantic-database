package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_GENERIC_TYPE.
 */
public class PBmmGenericType extends PBmmBaseType {

    //***** PBmmGenericType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Root type of this generic type, e.g.
     * Interval in Interval<Integer>.
     * cardinality: 1..1
     */
    private String rootType;

    /**
     * Generic parameters of the root_type in this type specifier if non-simple types.
     * The order must match the order of the owning class’s formal generic parameter declarations.
     * Persistent attribute.
     * cardinality: 1..1
     */
    private List<PBmmType> genericParameterDefs = new ArrayList<>();

    /**
     * Generic parameters of the root_type in this type specifier, if simple types.
     * The order must match the order of the owning class’s formal generic parameter declarations.
     * Persistent attribute.
     * cardinality: 0..1
     */
    private List<String> genericParameters;

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    private BmmGenericType bmmType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Root type of this generic type, e.g.
     * Interval in Interval<Integer>.
     * cardinality: 1..1
     */
    public String getRootType() {
        return rootType;
    }

    public void setRootType(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rootType failed, it has cardinality NonNull, but is null");
        }
        this.rootType = rootType;
    }

    /**
     * Generic parameters of the root_type in this type specifier if non-simple types.
     * The order must match the order of the owning class’s formal generic parameter declarations.
     * Persistent attribute.
     * cardinality: 1..1
     */

    public void addToGenericParameterDef(PBmmType value) {
        genericParameterDefs.add(value);
    }

    public void addToGenericParameterDefs(List<PBmmType> values) {
        values.forEach(value -> addToGenericparameterdef(value));
    }

    public void removeFromGenericParameterDef(PBmmType item) {
        if (genericParameterDefs != null) {
            genericParameterDefs.remove(item);
        }
    }

    public void removeFromGenericParameterDefs(Collection<PBmmType> values) {
        values.forEach(this::removeFromGenericParameterDef);
    }

    List<PBmmType> getGenericParameterDefs() {
        return this.genericParameterDefs;
    }

    public PBmmGenericType setGenericParameterDefs(List<PBmmType> genericParameterDefs) {
        if (genericParameterDefs == null) {
            throw new NullPointerException(" genericParameterDefs has cardinality NonNull, but is null");
        }
        this.genericParameterDefs = genericParameterDefs;
        return this;
    }

    public List<PBmmType> genericParameterDefs() {
        return Collections.unmodifiableList(this.genericParameterDefs);
    }

    /**
     * Generic parameters of the root_type in this type specifier, if simple types.
     * The order must match the order of the owning class’s formal generic parameter declarations.
     * Persistent attribute.
     * cardinality: 0..1
     */

    public void addToGenericParameter(String value) {
        if (genericParameters == null) {
            genericParameters = new ArrayList<>();
        }
        genericParameters.add(value);
    }

    public void addToGenericParameters(List<String> values) {
        values.forEach(value -> addToGenericparameter(value));
    }

    public void removeFromGenericParameter(String item) {
        if (genericParameters != null) {
            genericParameters.remove(item);
        }
    }

    public void removeFromGenericParameters(Collection<String> values) {
        values.forEach(this::removeFromGenericParameter);
    }

    List<String> getGenericParameters() {
        return this.genericParameters;
    }

    public PBmmGenericType setGenericParameters(List<String> genericParameters) {
        this.genericParameters = genericParameters;
        return this;
    }

    public List<String> genericParameters() {
        return Collections.unmodifiableList(this.genericParameters);
    }

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1 (redefined)
     */
    public BmmGenericType getBmmType() {
        return bmmType;
    }

    public void setBmmType(BmmGenericType value) {
        this.bmmType = bmmType;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Generic parameters of the root_type in this type specifier.
     * The order must match the order of the owning class’s formal generic parameter declarations
     * cardinality: 0..1
     */
    public List<PBmmType> genericParameterRefs() {
        List<PBmmType> result = null;


        return result;
    }

    //***** PBmmGenericType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmGenericType() {
    }

    public PBmmGenericType(
            String rootType,
            List<pBmmType> genericParameterDefs,
            List<string> genericParameters,
            BmmGenericType bmmType,
            String valueConstraint,
            BmmType bmmType
    ) {
        super(
                valueConstraint
        );
        if (rootType == null) {
            throw new NullPointerException("Property:rootType has cardinality NonNull, but is null");
        }
        if (genericParameterDefs == null) {
            throw new NullPointerException("Property:genericParameterDefs has cardinality NonNull, but is null");
        }
        this.rootType = rootType;
        this.genericParameterDefs = genericParameterDefs;
        this.genericParameters = genericParameters;
        this.bmmType = bmmType;
    }

    private PBmmGenericType(Builder builder) {
        this.setRootType(builder.rootType);
        this.setGenericParameterDefs(builder.genericParameterDefs);
        this.setGenericParameters(builder.genericParameters);
        this.setBmmType(builder.bmmType);
        this.setValueConstraint(builder.valueConstraint);
        this.setBmmType(builder.bmmType);
    }

    public static class Builder {
        private final String rootType;  //required
        private final List<pBmmType> genericParameterDefs;  //required
        private List<string> genericParameters;
        private BmmGenericType bmmType;
        private String valueConstraint;
        private BmmType bmmType;

        public Builder(
                String rootType,
                List<pBmmType> genericParameterDefs
        ) {
            if (rootType == null) {
                throw new NullPointerException("Property:rootType has cardinality NonNull, but is null");
            }
            if (genericParameterDefs == null) {
                throw new NullPointerException("Property:genericParameterDefs has cardinality NonNull, but is null");
            }
            this.rootType = rootType;
            this.genericParameterDefs = genericParameterDefs;
        }

        public Builder setGenericParameters(List<string> value) {
            this.genericParameters = genericParameters;
            return this;
        }

        public Builder setBmmType(BmmGenericType value) {
            this.bmmType = bmmType;
            return this;
        }

        public Builder setValueConstraint(String value) {
            this.valueConstraint = valueConstraint;
            return this;
        }

        public Builder setBmmType(BmmType value) {
            this.bmmType = bmmType;
            return this;
        }

        public PBmmGenericType build() {
            return new PBmmGenericType(this);
        }
    }


    //***** PBmmGenericType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmGenericType that = (PBmmGenericType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmGenericType.java
                Objects.equals(rootType, that.rootType) &&
                        Objects.equals(genericParameterDefs, that.genericParameterDefs) &&
                        Objects.equals(genericParameters, that.genericParameters) &&
                        Objects.equals(bmmType, that.bmmType);
=======
                java.util.Objects.equals(rootType, that.rootType) &&
                        java.util.Objects.equals(genericParameterDefs, that.genericParameterDefs) &&
                        java.util.Objects.equals(genericParameters, that.genericParameters) &&
                        java.util.Objects.equals(bmmType, that.bmmType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmGenericType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                rootType,
                genericParameterDefs,
                genericParameters,
                bmmType
        );
    }

    @Override
    public String toString() {
        return
                "PBmmGenericType {" +
                        "rootType='" + rootType + '\'' +
                        "genericParameterDefs='" + genericParameterDefs + '\'' +
                        "genericParameters='" + genericParameters + '\'' +
                        "bmmType='" + bmmType + '\'' +
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
