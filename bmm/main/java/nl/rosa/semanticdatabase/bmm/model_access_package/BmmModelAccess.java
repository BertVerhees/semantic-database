package nl.rosa.semanticdatabase.bmm.model_access_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 */
public class BmmModelAccess {

    //***** BmmModelAccess *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * List of directories where all the schemas loaded here are found.
     * cardinality: 0..1
     */
    private List<String> schemaDirectories;

    /**
     * All schemas found and loaded from schema_directory.
     * Keyed by schema_id.
     * cardinality: 0..1
     */
    private Map<String, BmmSchemaDescriptor> allSchemas;

    /**
     * Top-level (root) models in use, keyed by model_id.
     * cardinality: 0..1
     */
    private Map<String, BmmModel> bmmModels;

    /**
     * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
     * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
     * cardinality: 0..1
     */
    private Map<String, BmmModel> matchingBmmModels;

/**
 *
 * Reload BMM schemas.
 * cardinality: 0..1
 *
 */
    private;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * List of directories where all the schemas loaded here are found.
     * cardinality: 0..1
     */

    public void addToSchemaDirectory(String value) {
        if (schemaDirectories == null) {
            schemaDirectories = new ArrayList<>();
        }
        schemaDirectories.add(value);
    }

    public void addToSchemaDirectories(List<String> values) {
        values.forEach(value -> addToSchemadirectory(value));
    }

    public void removeFromSchemaDirectory(String item) {
        if (schemaDirectories != null) {
            schemaDirectories.remove(item);
        }
    }

    public void removeFromSchemaDirectories(Collection<String> values) {
        values.forEach(this::removeFromSchemaDirectory);
    }

    List<String> getSchemaDirectories() {
        return this.schemaDirectories;
    }

    public BmmModelAccess setSchemaDirectories(List<String> schemaDirectories) {
        this.schemaDirectories = schemaDirectories;
        return this;
    }

    public List<String> schemaDirectories() {
        return Collections.unmodifiableList(this.schemaDirectories);
    }

    /**
     * All schemas found and loaded from schema_directory.
     * Keyed by schema_id.
     * cardinality: 0..1
     */

    public void putAllSchema(String key, BmmSchemaDescriptor value) {
        if (allSchemas == null) {
            allSchemas = new HashMap<>();
        }
        allSchemas.put(key, value);
    }

    public void putAllSchemas(Map<String, BmmSchemaDescriptor> items) {
        items.keySet().forEach(key -> putAllschema(key, items.get(key)));
    }

    public BmmSchemaDescriptor getAllSchema(String key) {
        if (allSchemas == null) {
            return null;
        }
        return allSchemas.get(key);
    }

    public void removeAllSchema(String key) {
        if (allSchemas != null) {
            allSchemas.remove(key);
        }
    }

    public void removeAllSchemas(Collection<String> keys) {
        keys.forEach(this::removeAllSchema);
    }

    public Map<String, BmmSchemaDescriptor> getAllSchemas() {
        return this.allSchemas;
    }

    public BmmModelAccess setAllSchemas(Map<String, BmmSchemaDescriptor> allSchemas) {
        this.allSchemas = allSchemas;
        return this;
    }

    public Map<String, BmmSchemaDescriptor> allSchemas() {
        return Collections.unmodifiableMap(this.allSchemas);
    }

    /**
     * Top-level (root) models in use, keyed by model_id.
     * cardinality: 0..1
     */

    public void putBmmModel(String key, BmmModel value) {
        if (bmmModels == null) {
            bmmModels = new HashMap<>();
        }
        bmmModels.put(key, value);
    }

    public void putBmmModels(Map<String, BmmModel> items) {
        items.keySet().forEach(key -> putBmmmodel(key, items.get(key)));
    }

    public BmmModel getBmmModel(String key) {
        if (bmmModels == null) {
            return null;
        }
        return bmmModels.get(key);
    }

    public void removeBmmModel(String key) {
        if (bmmModels != null) {
            bmmModels.remove(key);
        }
    }

    public void removeBmmModels(Collection<String> keys) {
        keys.forEach(this::removeBmmModel);
    }

    public Map<String, BmmModel> getBmmModels() {
        return this.bmmModels;
    }

    public BmmModelAccess setBmmModels(Map<String, BmmModel> bmmModels) {
        this.bmmModels = bmmModels;
        return this;
    }

    public Map<String, BmmModel> bmmModels() {
        return Collections.unmodifiableMap(this.bmmModels);
    }

    /**
     * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
     * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
     * cardinality: 0..1
     */

    public void putMatchingBmmModel(String key, BmmModel value) {
        if (matchingBmmModels == null) {
            matchingBmmModels = new HashMap<>();
        }
        matchingBmmModels.put(key, value);
    }

    public void putMatchingBmmModels(Map<String, BmmModel> items) {
        items.keySet().forEach(key -> putMatchingbmmmodel(key, items.get(key)));
    }

    public BmmModel getMatchingBmmModel(String key) {
        if (matchingBmmModels == null) {
            return null;
        }
        return matchingBmmModels.get(key);
    }

    public void removeMatchingBmmModel(String key) {
        if (matchingBmmModels != null) {
            matchingBmmModels.remove(key);
        }
    }

    public void removeMatchingBmmModels(Collection<String> keys) {
        keys.forEach(this::removeMatchingBmmModel);
    }

    public Map<String, BmmModel> getMatchingBmmModels() {
        return this.matchingBmmModels;
    }

    public BmmModelAccess setMatchingBmmModels(Map<String, BmmModel> matchingBmmModels) {
        this.matchingBmmModels = matchingBmmModels;
        return this;
    }

    public Map<String, BmmModel> matchingBmmModels() {
        return Collections.unmodifiableMap(this.matchingBmmModels);
    }

    /**
     * Reload BMM schemas.
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
     * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
     * cardinality: 0..1
     */
    public void initialiseWithLoadList(List<String> a_schema_dirs, List<String> a_schema_load_list) {
        if (a_schema_dirs == null) {
            throw new NullPointerException("Parameter a_schema_dirs has cardinality NonNull, but is null");
        }
    }

    /**
     * Load all schemas found in a specified directories a_schema_dirs.
     * cardinality: 0..1
     */
    public void initialiseAll(List<String> a_schema_dirs) {
        if (a_schema_dirs == null) {
            throw new NullPointerException("Parameter a_schema_dirs has cardinality NonNull, but is null");
        }
    }

    /**
     * Return model containing the model key which is a model_id or any shorter form e.g.
     * model id minus the version.
     * If a shorter key is used, the BMM_MODEL with the most recent version will be selected.
     * Uses matching_bmm_models table to find matches if partial version information is supplied in key.
     * cardinality: 1..1
     */
    public BmmModel bmmModel(String a_model_key) {
        if (a_model_key == null) {
            throw new NullPointerException("Parameter a_model_key has cardinality NonNull, but is null.");
        }
        BmmModel result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a model for a model_key is available.
     * A model key is a model_id or any shorter form e.g.
     * model id minus the version.
     * If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
     * cardinality: 1..1
     */
    public Boolean hasBmmModel(String a_model_key) {
        if (a_model_key == null) {
            throw new NullPointerException("Parameter a_model_key has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmModelAccess *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmModelAccess() {
    }

    public BmmModelAccess(
            List<string> schemaDirectories,
            Map<string, bmmSchemaDescriptor> allSchemas,
            Map<string, bmmModel> bmmModels,
            Map<string, bmmModel> matchingBmmModels
    ) {
        this.schemaDirectories = schemaDirectories;
        this.allSchemas = allSchemas;
        this.bmmModels = bmmModels;
        this.matchingBmmModels = matchingBmmModels;
    }

    private BmmModelAccess(Builder builder) {
        this.setSchemaDirectories(builder.schemaDirectories);
        this.setAllSchemas(builder.allSchemas);
        this.setBmmModels(builder.bmmModels);
        this.setMatchingBmmModels(builder.matchingBmmModels);
    }

    public static class Builder {
        private List<string> schemaDirectories;
        private Map<string, bmmSchemaDescriptor> allSchemas;
        private Map<string, bmmModel> bmmModels;
        private Map<string, bmmModel> matchingBmmModels;

        public Builder(
        ) {
        }

        public Builder setSchemaDirectories(List<string> value) {
            this.schemaDirectories = schemaDirectories;
            return this;
        }

        public Builder setAllSchemas(Map<string, bmmSchemaDescriptor> value) {
            this.allSchemas = allSchemas;
            return this;
        }

        public Builder setBmmModels(Map<string, bmmModel> value) {
            this.bmmModels = bmmModels;
            return this;
        }

        public Builder setMatchingBmmModels(Map<string, bmmModel> value) {
            this.matchingBmmModels = matchingBmmModels;
            return this;
        }

        public BmmModelAccess build() {
            return new BmmModelAccess(this);
        }
    }


    //***** BmmModelAccess *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmModelAccess that = (BmmModelAccess) object;
        return
                java.util.Objects.equals(schemaDirectories, that.schemaDirectories) &&
                        java.util.Objects.equals(allSchemas, that.allSchemas) &&
                        java.util.Objects.equals(bmmModels, that.bmmModels) &&
                        java.util.Objects.equals(matchingBmmModels, that.matchingBmmModels);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                schemaDirectories,
                allSchemas,
                bmmModels,
                matchingBmmModels
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "BmmModelAccess {" +
                        "schemaDirectories='" + schemaDirectories + '\'' +
                        "allSchemas='" + allSchemas + '\'' +
                        "bmmModels='" + bmmModels + '\'' +
                        "matchingBmmModels='" + matchingBmmModels + '\'' +
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
