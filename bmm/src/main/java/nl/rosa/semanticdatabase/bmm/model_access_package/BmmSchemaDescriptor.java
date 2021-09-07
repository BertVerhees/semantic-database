package nl.rosa.semanticdatabase.bmm.model_access_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Descriptor for a BMM schema.
 * Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 */
public abstract class BmmSchemaDescriptor {

    //***** BmmSchemaDescriptor *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Persistent form of model.
     * cardinality: 0..1
     */
    private BmmSchema bmmSchema;

    /**
     * Computable form of model.
     * cardinality: 0..1
     */
    private BmmModel bmmModel;

    /**
     * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
     * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
     * cardinality: 1..1
     */
    private String schemaId;

    /**
     * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
     * cardinality: 1..1
     */
    private Map<String, String> metaData = new HashMap<>();

    /**
     * Identifiers of schemas included by this schema.
     * cardinality: 0..1
     */
    private List<String> includes;

/**
 *
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * cardinality: 0..1
 *
 */
    private;

/**
 *
 * Validate loaded schema and report errors.
 * cardinality: 0..1
 *
 */
    private;

/**
 *
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
 * cardinality: 0..1
 *
 */
    private;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Persistent form of model.
     * cardinality: 0..1
     */
    public BmmSchema getBmmSchema() {
        return bmmSchema;
    }

    public void setBmmSchema(BmmSchema value) {
        this.bmmSchema = bmmSchema;
    }

    /**
     * Computable form of model.
     * cardinality: 0..1
     */
    public BmmModel getBmmModel() {
        return bmmModel;
    }

    public void setBmmModel(BmmModel value) {
        this.bmmModel = bmmModel;
    }

    /**
     * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
     * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
     * cardinality: 1..1
     */
    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:schemaId failed, it has cardinality NonNull, but is null");
        }
        this.schemaId = schemaId;
    }

    /**
     * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
     * cardinality: 1..1
     */

    public void putMetaData(String key, String value) {
        metaData.put(key, value);
    }

    public void putMetaData(Map<String, String> items) {
        items.keySet().forEach(key -> putMetadat(key, items.get(key)));
    }

    public String getMetaData(String key) {
        return metaData.get(key);
    }

    public void removeMetaData(String key) {
        if (metaData != null) {
            metaData.remove(key);
        }
    }

    public void removeMetaData(Collection<String> keys) {
        keys.forEach(this::removeMetaData);
    }

    public Map<String, String> getMetaData() {
        return this.metaData;
    }

    public BmmSchemaDescriptor setMetaData(Map<String, String> metaData) {
        if (metaData == null) {
            throw new NullPointerException(" metaData has cardinality NonNull, but is null");
        }
        this.metaData = metaData;
        return this;
    }

    public Map<String, String> metaData() {
        return Collections.unmodifiableMap(this.metaData);
    }

    /**
     * Identifiers of schemas included by this schema.
     * cardinality: 0..1
     */

    public void addToInclude(String value) {
        if (includes == null) {
            includes = new ArrayList<>();
        }
        includes.add(value);
    }

    public void addToIncludes(List<String> values) {
        values.forEach(value -> addToInclude(value));
    }

    public void removeFromInclude(String item) {
        if (includes != null) {
            includes.remove(item);
        }
    }

    public void removeFromIncludes(Collection<String> values) {
        values.forEach(this::removeFromInclude);
    }

    List<String> getIncludes() {
        return this.includes;
    }

    public BmmSchemaDescriptor setIncludes(List<String> includes) {
        this.includes = includes;
        return this;
    }

    public List<String> includes() {
        return Collections.unmodifiableList(this.includes);
    }

    /**
     * Load schema into in-memory form, i.e.
     * a P_BMM_SCHEMA instance, if structurally valid.
     * If successful, p_schema will be set.
     * cardinality: 0..1
     */
    public get() {
        return;
    }

    public void set(value) {
        this. =;
    }

    /**
     * Validate loaded schema and report errors.
     * cardinality: 0..1
     */
    public get() {
        return;
    }

    public void set(value) {
        this. =;
    }

    /**
     * Create schema, i.e.
     * the BMM_MODEL from one P_BMM_SCHEMA schema.
     * cardinality: 0..1
     */
    public get() {
        return;
    }

    public void set(value) {
        this. =;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if this is a top-level schema, i.e.
     * not included by some other schema.
     * cardinality: 1..1
     */
    public Boolean isTopLevel() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
     * cardinality: 1..1
     */
    public Boolean isBmmCompatible() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
     * cardinality: 0..1
     */
    public void validateIncludes(List<String> all_schemas_list) {
    }

    //***** BmmSchemaDescriptor *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmSchemaDescriptor() {
    }

    protected BmmSchemaDescriptor(
            BmmSchema bmmSchema,
            BmmModel bmmModel,
            String schemaId,
            Map<string, string> metaData,
            List<string> includes
    ) {
        if (schemaId == null) {
            throw new NullPointerException("Property:schemaId has cardinality NonNull, but is null");
        }
        if (metaData == null) {
            throw new NullPointerException("Property:metaData has cardinality NonNull, but is null");
        }
        this.bmmSchema = bmmSchema;
        this.bmmModel = bmmModel;
        this.schemaId = schemaId;
        this.metaData = metaData;
        this.includes = includes;
    }


    //***** BmmSchemaDescriptor *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmSchemaDescriptor that = (BmmSchemaDescriptor) object;
        return
                Objects.equals(bmmSchema, that.bmmSchema) &&
                        Objects.equals(bmmModel, that.bmmModel) &&
                        Objects.equals(schemaId, that.schemaId) &&
                        Objects.equals(metaData, that.metaData) &&
                        Objects.equals(includes, that.includes);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                bmmSchema,
                bmmModel,
                schemaId,
                metaData,
                includes
        );
    }

    @Override
    public String toString() {
        return
                "BmmSchemaDescriptor {" +
                        "bmmSchema='" + bmmSchema + '\'' +
                        "bmmModel='" + bmmModel + '\'' +
                        "schemaId='" + schemaId + '\'' +
                        "metaData='" + metaData + '\'' +
                        "includes='" + includes + '\'' +
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
