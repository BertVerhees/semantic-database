package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import semanticdatabase.base.foundation_types.primitive_types.Integer;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of persistent form of BMM_CLASS for serialisation to ODIN, JSON, XML etc.
 */
public class PBmmClass extends PBmmModelElement {

    //***** PBmmClass *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of the class.
     * Persisted attribute.
     * cardinality: 1..1
     */
    private String name;

    /**
     * List of immediate inheritance parents.
     * If there are generic ancestors, use ancestor_defs instead.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private List<String> ancestors;

    /**
     * List of attributes defined in this class.
     * Persistent attribute.
     * cardinality: 0..1
     */
    private Map<String, PBmmProperty> properties;

    /**
     * True if this is an abstract type.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private Boolean isAbstract;

    /**
     * True if this class definition overrides one found in an included schema.
     * cardinality: 0..1
     */
    private Boolean isOverride;

    /**
     * List of generic parameter definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private Map<String, PBmmGenericParameter> genericParameterDefs;

    /**
     * Reference to original source schema defining this class.
     * Set during BMM_SCHEMA materialise.
     * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
     * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
     * cardinality: 1..1
     */
    private String sourceSchemaId;

    /**
     * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
     * cardinality: 0..1
     */
    private BmmClass bmmClass;

    /**
     * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
     * Assigned in post-load processing.
     * cardinality: 1..1
     */
    private Integer uid;

    /**
     * List of structured inheritance ancestors, used only in the case of generic inheritance.
     * Persisted attribute.
     * cardinality: 0..1
     */
    private List<PBmmGenericType> ancestorDefs;

/**
 *
 * Create bmm_class_definition.
 * cardinality: 0..1
 *
 */
    private;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of the class.
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
     * List of immediate inheritance parents.
     * If there are generic ancestors, use ancestor_defs instead.
     * Persisted attribute.
     * cardinality: 0..1
     */

    public void addToAncestor(String value) {
        if (ancestors == null) {
            ancestors = new ArrayList<>();
        }
        ancestors.add(value);
    }

    public void addToAncestors(List<String> values) {
        values.forEach(value -> addToAncestor(value));
    }

    public void removeFromAncestor(String item) {
        if (ancestors != null) {
            ancestors.remove(item);
        }
    }

    public void removeFromAncestors(Collection<String> values) {
        values.forEach(this::removeFromAncestor);
    }

    List<String> getAncestors() {
        return this.ancestors;
    }

    public PBmmClass setAncestors(List<String> ancestors) {
        this.ancestors = ancestors;
        return this;
    }

    public List<String> ancestors() {
        return Collections.unmodifiableList(this.ancestors);
    }

    /**
     * List of attributes defined in this class.
     * Persistent attribute.
     * cardinality: 0..1
     */

    public void putProperty(String key, PBmmProperty value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }

    public void putProperties(Map<String, PBmmProperty> items) {
        items.keySet().forEach(key -> putProperty(key, items.get(key)));
    }

    public PBmmProperty getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }

    public void removeProperty(String key) {
        if (properties != null) {
            properties.remove(key);
        }
    }

    public void removeProperties(Collection<String> keys) {
        keys.forEach(this::removeProperty);
    }

    public Map<String, PBmmProperty> getProperties() {
        return this.properties;
    }

    public PBmmClass setProperties(Map<String, PBmmProperty> properties) {
        this.properties = properties;
        return this;
    }

    public Map<String, PBmmProperty> properties() {
        return Collections.unmodifiableMap(this.properties);
    }

    /**
     * True if this is an abstract type.
     * Persisted attribute.
     * cardinality: 0..1
     */
    public Boolean getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(Boolean value) {
        this.isAbstract = isAbstract;
    }

    /**
     * True if this class definition overrides one found in an included schema.
     * cardinality: 0..1
     */
    public Boolean getIsOverride() {
        return isOverride;
    }

    public void setIsOverride(Boolean value) {
        this.isOverride = isOverride;
    }

    /**
     * List of generic parameter definitions.
     * Persisted attribute.
     * cardinality: 0..1
     */

    public void putGenericParameterDef(String key, PBmmGenericParameter value) {
        if (genericParameterDefs == null) {
            genericParameterDefs = new HashMap<>();
        }
        genericParameterDefs.put(key, value);
    }

    public void putGenericParameterDefs(Map<String, PBmmGenericParameter> items) {
        items.keySet().forEach(key -> putGenericparameterdef(key, items.get(key)));
    }

    public PBmmGenericParameter getGenericParameterDef(String key) {
        if (genericParameterDefs == null) {
            return null;
        }
        return genericParameterDefs.get(key);
    }

    public void removeGenericParameterDef(String key) {
        if (genericParameterDefs != null) {
            genericParameterDefs.remove(key);
        }
    }

    public void removeGenericParameterDefs(Collection<String> keys) {
        keys.forEach(this::removeGenericParameterDef);
    }

    public Map<String, PBmmGenericParameter> getGenericParameterDefs() {
        return this.genericParameterDefs;
    }

    public PBmmClass setGenericParameterDefs(Map<String, PBmmGenericParameter> genericParameterDefs) {
        this.genericParameterDefs = genericParameterDefs;
        return this;
    }

    public Map<String, PBmmGenericParameter> genericParameterDefs() {
        return Collections.unmodifiableMap(this.genericParameterDefs);
    }

    /**
     * Reference to original source schema defining this class.
     * Set during BMM_SCHEMA materialise.
     * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
     * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
     * cardinality: 1..1
     */
    public String getSourceSchemaId() {
        return sourceSchemaId;
    }

    public void setSourceSchemaId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:sourceSchemaId failed, it has cardinality NonNull, but is null");
        }
        this.sourceSchemaId = sourceSchemaId;
    }

    /**
     * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
     * cardinality: 0..1
     */
    public BmmClass getBmmClass() {
        return bmmClass;
    }

    public void setBmmClass(BmmClass value) {
        this.bmmClass = bmmClass;
    }

    /**
     * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
     * Assigned in post-load processing.
     * cardinality: 1..1
     */
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:uid failed, it has cardinality NonNull, but is null");
        }
        this.uid = uid;
    }

    /**
     * List of structured inheritance ancestors, used only in the case of generic inheritance.
     * Persisted attribute.
     * cardinality: 0..1
     */

    public void addToAncestorDef(PBmmGenericType value) {
        if (ancestorDefs == null) {
            ancestorDefs = new ArrayList<>();
        }
        ancestorDefs.add(value);
    }

    public void addToAncestorDefs(List<PBmmGenericType> values) {
        values.forEach(value -> addToAncestordef(value));
    }

    public void removeFromAncestorDef(PBmmGenericType item) {
        if (ancestorDefs != null) {
            ancestorDefs.remove(item);
        }
    }

    public void removeFromAncestorDefs(Collection<PBmmGenericType> values) {
        values.forEach(this::removeFromAncestorDef);
    }

    List<PBmmGenericType> getAncestorDefs() {
        return this.ancestorDefs;
    }

    public PBmmClass setAncestorDefs(List<PBmmGenericType> ancestorDefs) {
        this.ancestorDefs = ancestorDefs;
        return this;
    }

    public List<PBmmGenericType> ancestorDefs() {
        return Collections.unmodifiableList(this.ancestorDefs);
    }

    /**
     * Create bmm_class_definition.
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
 *
 * True if this class is a generic class.
 * cardinality: 1..1
 *
 */
    public =generic_parameter_defs /=

    Void isGeneric() {
        =generic_parameter_defs /= Void result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Add remaining model elements from Current to bmm_class_definition.
     * cardinality: 0..1
     */
    public void populateBmmClass(BmmModel a_bmm_schema) {
        if (a_bmm_schema == null) {
            throw new NullPointerException("Parameter a_bmm_schema has cardinality NonNull, but is null");
        }
    }

    //***** PBmmClass *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmClass() {
    }

    public PBmmClass(
            String name,
            List<string> ancestors,
            Map<string, pBmmProperty> properties,
            Boolean isAbstract,
            Boolean isOverride,
            Map<string, pBmmGenericParameter> genericParameterDefs,
            String sourceSchemaId,
            BmmClass bmmClass,
            Integer uid,
            List<pBmmGenericType> ancestorDefs,
            String documentation
    ) {
        super(
                documentation
        );
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (sourceSchemaId == null) {
            throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
        }
        if (uid == null) {
            throw new NullPointerException("Property:uid has cardinality NonNull, but is null");
        }
        this.name = name;
        this.ancestors = ancestors;
        this.properties = properties;
        this.isAbstract = isAbstract;
        this.isOverride = isOverride;
        this.genericParameterDefs = genericParameterDefs;
        this.sourceSchemaId = sourceSchemaId;
        this.bmmClass = bmmClass;
        this.uid = uid;
        this.ancestorDefs = ancestorDefs;
    }

    private PBmmClass(Builder builder) {
        this.setName(builder.name);
        this.setAncestors(builder.ancestors);
        this.setProperties(builder.properties);
        this.setIsAbstract(builder.isAbstract);
        this.setIsOverride(builder.isOverride);
        this.setGenericParameterDefs(builder.genericParameterDefs);
        this.setSourceSchemaId(builder.sourceSchemaId);
        this.setBmmClass(builder.bmmClass);
        this.setUid(builder.uid);
        this.setAncestorDefs(builder.ancestorDefs);
        this.setDocumentation(builder.documentation);
    }

    public static class Builder {
        private final String name;  //required
        private List<string> ancestors;
        private Map<string, pBmmProperty> properties;
        private Boolean isAbstract;
        private Boolean isOverride;
        private Map<string, pBmmGenericParameter> genericParameterDefs;
        private final String sourceSchemaId;  //required
        private BmmClass bmmClass;
        private final Integer uid;  //required
        private List<pBmmGenericType> ancestorDefs;
        private String documentation;

        public Builder(
                String name,
                String sourceSchemaId,
                Integer uid
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (sourceSchemaId == null) {
                throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
            }
            if (uid == null) {
                throw new NullPointerException("Property:uid has cardinality NonNull, but is null");
            }
            this.name = name;
            this.sourceSchemaId = sourceSchemaId;
            this.uid = uid;
        }

        public Builder setAncestors(List<string> value) {
            this.ancestors = ancestors;
            return this;
        }

        public Builder setProperties(Map<string, pBmmProperty> value) {
            this.properties = properties;
            return this;
        }

        public Builder setIsAbstract(Boolean value) {
            this.isAbstract = isAbstract;
            return this;
        }

        public Builder setIsOverride(Boolean value) {
            this.isOverride = isOverride;
            return this;
        }

        public Builder setGenericParameterDefs(Map<string, pBmmGenericParameter> value) {
            this.genericParameterDefs = genericParameterDefs;
            return this;
        }

        public Builder setBmmClass(BmmClass value) {
            this.bmmClass = bmmClass;
            return this;
        }

        public Builder setAncestorDefs(List<pBmmGenericType> value) {
            this.ancestorDefs = ancestorDefs;
            return this;
        }

        public Builder setDocumentation(String value) {
            this.documentation = documentation;
            return this;
        }

        public PBmmClass build() {
            return new PBmmClass(this);
        }
    }


    //***** PBmmClass *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmClass that = (PBmmClass) object;
        return
                java.util.Objects.equals(name, that.name) &&
                        java.util.Objects.equals(ancestors, that.ancestors) &&
                        java.util.Objects.equals(properties, that.properties) &&
                        java.util.Objects.equals(isAbstract, that.isAbstract) &&
                        java.util.Objects.equals(isOverride, that.isOverride) &&
                        java.util.Objects.equals(genericParameterDefs, that.genericParameterDefs) &&
                        java.util.Objects.equals(sourceSchemaId, that.sourceSchemaId) &&
                        java.util.Objects.equals(bmmClass, that.bmmClass) &&
                        java.util.Objects.equals(uid, that.uid) &&
                        java.util.Objects.equals(ancestorDefs, that.ancestorDefs);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                ancestors,
                properties,
                isAbstract,
                isOverride,
                genericParameterDefs,
                sourceSchemaId,
                bmmClass,
                uid,
                ancestorDefs
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "PBmmClass {" +
                        "name='" + name + '\'' +
                        "ancestors='" + ancestors + '\'' +
                        "properties='" + properties + '\'' +
                        "isAbstract='" + isAbstract + '\'' +
                        "isOverride='" + isOverride + '\'' +
                        "genericParameterDefs='" + genericParameterDefs + '\'' +
                        "sourceSchemaId='" + sourceSchemaId + '\'' +
                        "bmmClass='" + bmmClass + '\'' +
                        "uid='" + uid + '\'' +
                        "ancestorDefs='" + ancestorDefs + '\'' +
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
