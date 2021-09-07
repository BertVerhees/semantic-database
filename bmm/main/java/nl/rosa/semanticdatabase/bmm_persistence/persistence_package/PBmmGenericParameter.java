package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_GENERIC_PARAMETER.
 */
public class PBmmGenericParameter extends PBmmModelElement {

    //***** PBmmGenericParameter *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of the parameter, e.g.
     * 'T' etc.
     * Persisted attribute.
     * Name is limited to 1 character, upper case.
     * cardinality: 1..1
     */
    private String name;

    /**
     * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private String conformsToType;

    /**
     * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
     * cardinality: 0..1
     */
    private BmmParameterType bmmGenericParameter;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of the parameter, e.g.
     * 'T' etc.
     * Persisted attribute.
     * Name is limited to 1 character, upper case.
     * cardinality: 1..1
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    /**
     * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public String getConformsToType() {
        return conformsToType;
    }

    public void setConformsToType(String value) {
        this.conformsToType = conformsToType;
    }

    /**
     * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
     * cardinality: 0..1
     */
    public BmmParameterType getBmmGenericParameter() {
        return bmmGenericParameter;
    }

    public void setBmmGenericParameter(BmmParameterType value) {
        this.bmmGenericParameter = bmmGenericParameter;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Create bmm_generic_parameter.
     * cardinality: 0..1
     */
    public void createBmmGenericParameter(BmmModel a_bmm_schema) {
        if (a_bmm_schema == null) {
            throw new NullPointerException("Parameter a_bmm_schema has cardinality NonNull, but is null");
        }
    }

    //***** PBmmGenericParameter *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmGenericParameter() {
    }

    public PBmmGenericParameter(
            String name,
            String conformsToType,
            BmmParameterType bmmGenericParameter,
            String documentation
    ) {
        super(
                documentation
        );
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
        this.conformsToType = conformsToType;
        this.bmmGenericParameter = bmmGenericParameter;
    }

    private PBmmGenericParameter(Builder builder) {
        this.setName(builder.name);
        this.setConformsToType(builder.conformsToType);
        this.setBmmGenericParameter(builder.bmmGenericParameter);
        this.setDocumentation(builder.documentation);
    }

    public static class Builder {
        private final String name;  //required
        private String conformsToType;
        private BmmParameterType bmmGenericParameter;
        private String documentation;

        public Builder(
                String name
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            this.name = name;
        }

        public Builder setConformsToType(String value) {
            this.conformsToType = conformsToType;
            return this;
        }

        public Builder setBmmGenericParameter(BmmParameterType value) {
            this.bmmGenericParameter = bmmGenericParameter;
            return this;
        }

        public Builder setDocumentation(String value) {
            this.documentation = documentation;
            return this;
        }

        public PBmmGenericParameter build() {
            return new PBmmGenericParameter(this);
        }
    }


    //***** PBmmGenericParameter *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmGenericParameter that = (PBmmGenericParameter) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmGenericParameter.java
                Objects.equals(name, that.name) &&
                        Objects.equals(conformsToType, that.conformsToType) &&
                        Objects.equals(bmmGenericParameter, that.bmmGenericParameter);
=======
                java.util.Objects.equals(name, that.name) &&
                        java.util.Objects.equals(conformsToType, that.conformsToType) &&
                        java.util.Objects.equals(bmmGenericParameter, that.bmmGenericParameter);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmGenericParameter.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                conformsToType,
                bmmGenericParameter
        );
    }

    @Override
    public String toString() {
        return
                "PBmmGenericParameter {" +
                        "name='" + name + '\'' +
                        "conformsToType='" + conformsToType + '\'' +
                        "bmmGenericParameter='" + bmmGenericParameter + '\'' +
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
