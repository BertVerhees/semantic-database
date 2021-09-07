package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_PROPERTY.
 */
public abstract class PBmmProperty extends PBmmModelElement {

    //***** PBmmProperty *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of this property within its class.
     * Persisted attribute.
     * cardinality: 1..1
     */
    private String name;

    /**
     * True if this property is mandatory in its class.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private Boolean isMandatory;

    /**
     * True if this property is computed rather than stored in objects of this class.
     * Persisted Attribute.
     * cardinality: 0..1
     */
    private Boolean isComputed;

    /**
     * True if this property is info model 'infrastructure' rather than 'data'.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private Boolean isImInfrastructure;

    /**
     * True if this property is info model 'runtime' settable property.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private Boolean isImRuntime;

    /**
     * Type definition of this property, if not a simple String type reference.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private PBmmType typeDef;

    /**
     * BMM_PROPERTY created by create_bmm_property_definition.
     * cardinality: 0..1
     */
    private BmmProperty bmmProperty;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of this property within its class.
     * Persisted attribute.
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
     * True if this property is mandatory in its class.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public Boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Boolean value) {
        this.isMandatory = isMandatory;
    }

    /**
     * True if this property is computed rather than stored in objects of this class.
     * Persisted Attribute.
     * cardinality: 0..1
     */
    public Boolean getIsComputed() {
        return isComputed;
    }

    public void setIsComputed(Boolean value) {
        this.isComputed = isComputed;
    }

    /**
     * True if this property is info model 'infrastructure' rather than 'data'.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public Boolean getIsImInfrastructure() {
        return isImInfrastructure;
    }

    public void setIsImInfrastructure(Boolean value) {
        this.isImInfrastructure = isImInfrastructure;
    }

    /**
     * True if this property is info model 'runtime' settable property.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public Boolean getIsImRuntime() {
        return isImRuntime;
    }

    public void setIsImRuntime(Boolean value) {
        this.isImRuntime = isImRuntime;
    }

    /**
     * Type definition of this property, if not a simple String type reference.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public PBmmType getTypeDef() {
        return typeDef;
    }

    public void setTypeDef(PBmmType value) {
        this.typeDef = typeDef;
    }

    /**
     * BMM_PROPERTY created by create_bmm_property_definition.
     * cardinality: 0..1
     */
    public BmmProperty getBmmProperty() {
        return bmmProperty;
    }

    public void setBmmProperty(BmmProperty value) {
        this.bmmProperty = bmmProperty;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Create bmm_property_definition from P_BMM_XX parts.
     * cardinality: 0..1
     */
    public void createBmmProperty(BmmModel a_bmm_schema, BmmClass a_class_def) {
        if (a_bmm_schema == null) {
            throw new NullPointerException("Parameter a_bmm_schema has cardinality NonNull, but is null");
        }
        if (a_class_def == null) {
            throw new NullPointerException("Parameter a_class_def has cardinality NonNull, but is null");
        }
    }

    //***** PBmmProperty *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmProperty() {
    }

    protected PBmmProperty(
            String name,
            Boolean isMandatory,
            Boolean isComputed,
            Boolean isImInfrastructure,
            Boolean isImRuntime,
            PBmmType typeDef,
            BmmProperty bmmProperty,
            String documentation
    ) {
        super(
                documentation
        );
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
        this.isMandatory = isMandatory;
        this.isComputed = isComputed;
        this.isImInfrastructure = isImInfrastructure;
        this.isImRuntime = isImRuntime;
        this.typeDef = typeDef;
        this.bmmProperty = bmmProperty;
    }


    //***** PBmmProperty *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmProperty that = (PBmmProperty) object;
        return
                Objects.equals(name, that.name) &&
                        Objects.equals(isMandatory, that.isMandatory) &&
                        Objects.equals(isComputed, that.isComputed) &&
                        Objects.equals(isImInfrastructure, that.isImInfrastructure) &&
                        Objects.equals(isImRuntime, that.isImRuntime) &&
                        Objects.equals(typeDef, that.typeDef) &&
                        Objects.equals(bmmProperty, that.bmmProperty);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                isMandatory,
                isComputed,
                isImInfrastructure,
                isImRuntime,
                typeDef,
                bmmProperty
        );
    }

    @Override
    public String toString() {
        return
                "PBmmProperty {" +
                        "name='" + name + '\'' +
                        "isMandatory='" + isMandatory + '\'' +
                        "isComputed='" + isComputed + '\'' +
                        "isImInfrastructure='" + isImInfrastructure + '\'' +
                        "isImRuntime='" + isImRuntime + '\'' +
                        "typeDef='" + typeDef + '\'' +
                        "bmmProperty='" + bmmProperty + '\'' +
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
