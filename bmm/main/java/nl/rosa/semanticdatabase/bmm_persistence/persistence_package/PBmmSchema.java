package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.model_access_package.BmmSchema;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persisted form of BMM_SCHEMA.
 */
public class PBmmSchema extends BmmSchema implements PBmmPackageContainer {

    //***** PBmmSchema *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Primitive type definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private List<PBmmClass> primitiveTypes;

    /**
     * Class definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private List<PBmmClass> classDefinitions;

/**
 *
 * Implementation of validate()
 * cardinality: 0..1 (effected)
 *
 */
    private;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Primitive type definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */

    public void addToPrimitiveType(PBmmClass value) {
        if (primitiveTypes == null) {
            primitiveTypes = new ArrayList<>();
        }
        primitiveTypes.add(value);
    }

    public void addToPrimitiveTypes(List<PBmmClass> values) {
        values.forEach(value -> addToPrimitivetype(value));
    }

    public void removeFromPrimitiveType(PBmmClass item) {
        if (primitiveTypes != null) {
            primitiveTypes.remove(item);
        }
    }

    public void removeFromPrimitiveTypes(Collection<PBmmClass> values) {
        values.forEach(this::removeFromPrimitiveType);
    }

    List<PBmmClass> getPrimitiveTypes() {
        return this.primitiveTypes;
    }

    public PBmmSchema setPrimitiveTypes(List<PBmmClass> primitiveTypes) {
        this.primitiveTypes = primitiveTypes;
        return this;
    }

    public List<PBmmClass> primitiveTypes() {
        return Collections.unmodifiableList(this.primitiveTypes);
    }

    /**
     * Class definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */

    public void addToClassDefinition(PBmmClass value) {
        if (classDefinitions == null) {
            classDefinitions = new ArrayList<>();
        }
        classDefinitions.add(value);
    }

    public void addToClassDefinitions(List<PBmmClass> values) {
        values.forEach(value -> addToClassdefinition(value));
    }

    public void removeFromClassDefinition(PBmmClass item) {
        if (classDefinitions != null) {
            classDefinitions.remove(item);
        }
    }

    public void removeFromClassDefinitions(Collection<PBmmClass> values) {
        values.forEach(this::removeFromClassDefinition);
    }

    List<PBmmClass> getClassDefinitions() {
        return this.classDefinitions;
    }

    public PBmmSchema setClassDefinitions(List<PBmmClass> classDefinitions) {
        this.classDefinitions = classDefinitions;
        return this;
    }

    public List<PBmmClass> classDefinitions() {
        return Collections.unmodifiableList(this.classDefinitions);
    }

    /**
     * Implementation of validate()
     * cardinality: 0..1 (effected)
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
 *
 * Implementation of merge()
 * cardinality: 0..1 (effected)
 *
 */
    public includes_to_process.has(included_schema.schema_id)

    merge(PBmmSchema other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        includes_to_process.has(included_schema.schema_id) result = null;


        return result;
    }

    /**
     * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
     * cardinality: 1..1
     */
    public PBmmPackage canonicalPackages() {
        PBmmPackage result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Implementation of validate_created()
     */
    final state validateCreated
    preState =
    State_created Post_state:
    passed implies
    state =State_validated_created;

    /**
     * Implementation of load_finalise()
     */
    final state loadFinalise
    preState =
    State_validated_created Post_state:state =
    State_includes_processed or
    state =State_includes_pending;

    /**
     * Implementation of create_bmm_model()
     */
    final state createBmmModel
    preState =P_BMM_PACKAGE_STATE.State_includes_processed;

    //***** PBmmPackageContainer *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
     * cardinality: 1..1
     */
    private Map<String, P_BMM_PACKAGE> packages = new HashMap<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
     * cardinality: 1..1
     */

    public void putPackage(String key, PBmmPackage value) {
        packages.put(key, value);
    }

    public void putPackages(Map<String, P_BMM_PACKAGE> items) {
        items.keySet().forEach(key -> putPackage(key, items.get(key)));
    }

    public PBmmPackage getPackage(String key) {
        return packages.get(key);
    }

    public void removePackage(String key) {
        if (packages != null) {
            packages.remove(key);
        }
    }

    public void removePackages(Collection<String> keys) {
        keys.forEach(this::removePackage);
    }

    public Map<String, PBmmPackage> getPackages() {
        return this.packages;
    }

    public PBmmPackageContainer setPackages(Map<String, PBmmPackage> packages) {
        if (packages == null) {
            throw new NullPointerException(" packages has cardinality NonNull, but is null");
        }
        this.packages = packages;
        return this;
    }

    public Map<String, PBmmPackage> packages() {
        return Collections.unmodifiableMap(this.packages);
    }

    //***** PBmmSchema *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmSchema() {
    }

    public PBmmSchema(
            List<pBmmClass> primitiveTypes,
            List<pBmmClass> classDefinitions,
            Map<string, pBmmPackage> packages,
            String bmmVersion,
            Map<string, bmmIncludeSpec> includes,
            BmmModel bmmModel,
            BmmSchemaState state,
            String modelName,
            String schemaName,
            String schemaRevision,
            String schemaLifecycleState,
            String schemaAuthor,
            String schemaDescription,
            List<string> schemaContributors,
            String rmPublisher,
            String rmRelease
    ) {
        super(
                bmmVersion,
                includes,
                bmmModel,
                state,
                modelName,
                schemaName,
                schemaRevision,
                schemaLifecycleState,
                schemaAuthor,
                schemaDescription,
                schemaContributors,
                rmPublisher,
                rmRelease
        );
        if (packages == null) {
            throw new NullPointerException("Property:packages has cardinality NonNull, but is null");
        }
        this.primitiveTypes = primitiveTypes;
        this.classDefinitions = classDefinitions;
        this.packages = packages;
    }

    private PBmmSchema(Builder builder) {
        this.setPrimitiveTypes(builder.primitiveTypes);
        this.setClassDefinitions(builder.classDefinitions);
        this.setPackages(builder.packages);
        this.setBmmVersion(builder.bmmVersion);
        this.setIncludes(builder.includes);
        this.setBmmModel(builder.bmmModel);
        this.setState(builder.state);
        this.setModelName(builder.modelName);
        this.setSchemaName(builder.schemaName);
        this.setSchemaRevision(builder.schemaRevision);
        this.setSchemaLifecycleState(builder.schemaLifecycleState);
        this.setSchemaAuthor(builder.schemaAuthor);
        this.setSchemaDescription(builder.schemaDescription);
        this.setSchemaContributors(builder.schemaContributors);
        this.setRmPublisher(builder.rmPublisher);
        this.setRmRelease(builder.rmRelease);
    }

    public static class Builder {
        private List<pBmmClass> primitiveTypes;
        private List<pBmmClass> classDefinitions;
        private final Map<string, pBmmPackage> packages;  //required
        private final String bmmVersion;  //required
        private Map<string, bmmIncludeSpec> includes;
        private BmmModel bmmModel;
        private final BmmSchemaState state;  //required
        private String modelName;
        private final String schemaName;  //required
        private final String schemaRevision;  //required
        private final String schemaLifecycleState;  //required
        private final String schemaAuthor;  //required
        private final String schemaDescription;  //required
        private List<string> schemaContributors;
        private final String rmPublisher;  //required
        private final String rmRelease;  //required

        public Builder(
                Map<string, pBmmPackage> packages,
                String bmmVersion,
                BmmSchemaState state,
                String schemaName,
                String schemaRevision,
                String schemaLifecycleState,
                String schemaAuthor,
                String schemaDescription,
                String rmPublisher,
                String rmRelease
        ) {
            if (packages == null) {
                throw new NullPointerException("Property:packages has cardinality NonNull, but is null");
            }
            if (bmmVersion == null) {
                throw new NullPointerException("Property:bmmVersion has cardinality NonNull, but is null");
            }
            if (state == null) {
                throw new NullPointerException("Property:state has cardinality NonNull, but is null");
            }
            if (schemaName == null) {
                throw new NullPointerException("Property:schemaName has cardinality NonNull, but is null");
            }
            if (schemaRevision == null) {
                throw new NullPointerException("Property:schemaRevision has cardinality NonNull, but is null");
            }
            if (schemaLifecycleState == null) {
                throw new NullPointerException("Property:schemaLifecycleState has cardinality NonNull, but is null");
            }
            if (schemaAuthor == null) {
                throw new NullPointerException("Property:schemaAuthor has cardinality NonNull, but is null");
            }
            if (schemaDescription == null) {
                throw new NullPointerException("Property:schemaDescription has cardinality NonNull, but is null");
            }
            if (rmPublisher == null) {
                throw new NullPointerException("Property:rmPublisher has cardinality NonNull, but is null");
            }
            if (rmRelease == null) {
                throw new NullPointerException("Property:rmRelease has cardinality NonNull, but is null");
            }
            this.packages = packages;
            this.bmmVersion = bmmVersion;
            this.state = state;
            this.schemaName = schemaName;
            this.schemaRevision = schemaRevision;
            this.schemaLifecycleState = schemaLifecycleState;
            this.schemaAuthor = schemaAuthor;
            this.schemaDescription = schemaDescription;
            this.rmPublisher = rmPublisher;
            this.rmRelease = rmRelease;
        }

        public Builder setPrimitiveTypes(List<pBmmClass> value) {
            this.primitiveTypes = primitiveTypes;
            return this;
        }

        public Builder setClassDefinitions(List<pBmmClass> value) {
            this.classDefinitions = classDefinitions;
            return this;
        }

        public Builder setIncludes(Map<string, bmmIncludeSpec> value) {
            this.includes = includes;
            return this;
        }

        public Builder setBmmModel(BmmModel value) {
            this.bmmModel = bmmModel;
            return this;
        }

        public Builder setModelName(String value) {
            this.modelName = modelName;
            return this;
        }

        public Builder setSchemaContributors(List<string> value) {
            this.schemaContributors = schemaContributors;
            return this;
        }

        public PBmmSchema build() {
            return new PBmmSchema(this);
        }
    }


    //***** PBmmSchema *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmSchema that = (PBmmSchema) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSchema.java
                Objects.equals(primitiveTypes, that.primitiveTypes) &&
                        Objects.equals(classDefinitions, that.classDefinitions) &&
                        Objects.equals(packages, that.packages);
=======
                java.util.Objects.equals(primitiveTypes, that.primitiveTypes) &&
                        java.util.Objects.equals(classDefinitions, that.classDefinitions) &&
                        java.util.Objects.equals(packages, that.packages);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmSchema.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                primitiveTypes,
                classDefinitions,
                packages
        );
    }

    @Override
    public String toString() {
        return
                "PBmmSchema {" +
                        "primitiveTypes='" + primitiveTypes + '\'' +
                        "classDefinitions='" + classDefinitions + '\'' +
                        "packages='" + packages + '\'' +
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
