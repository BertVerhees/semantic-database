package nl.rosa.semanticdatabase.bmm.model_structure;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.model_access_package.BmmModelMetadata;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.bmm.classes.BmmEnumeration;
import nl.rosa.semanticdatabase.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of the root of a BMM model (along with what is inherited from BMM_SCHEMA_CORE).
 */
public class BmmModel extends BmmPackageContainer implements BmmModelMetadata {

    //***** BmmModel *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * All classes in this model, keyed by type name.
     * cardinality: 0..1
     */
    private Map<String, BmmClass> classDefinitions;

    /**
     * List of other models 'used' (i.e.
     * 'imported' by this model).
     * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
     * cardinality: 0..1
     */
    private List<BmmModel> usedModels;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * All classes in this model, keyed by type name.
     * cardinality: 0..1
     */

    public void putClassDefinition(String key, BmmClass value) {
        if (classDefinitions == null) {
            classDefinitions = new HashMap<>();
        }
        classDefinitions.put(key, value);
    }

    public void putClassDefinitions(Map<String, BmmClass> items) {
        items.keySet().forEach(key -> putClassdefinition(key, items.get(key)));
    }

    public BmmClass getClassDefinition(String key) {
        if (classDefinitions == null) {
            return null;
        }
        return classDefinitions.get(key);
    }

    public void removeClassDefinition(String key) {
        if (classDefinitions != null) {
            classDefinitions.remove(key);
        }
    }

    public void removeClassDefinitions(Collection<String> keys) {
        keys.forEach(this::removeClassDefinition);
    }

    public Map<String, BmmClass> getClassDefinitions() {
        return this.classDefinitions;
    }

    public BmmModel setClassDefinitions(Map<String, BmmClass> classDefinitions) {
        this.classDefinitions = classDefinitions;
        return this;
    }

    public Map<String, BmmClass> classDefinitions() {
        return Collections.unmodifiableMap(this.classDefinitions);
    }

    /**
     * List of other models 'used' (i.e.
     * 'imported' by this model).
     * Classes in the current model may refer to classes in a used model by specifying the other class’s scope meta-attribute.
     * cardinality: 0..1
     */

    public void addToUsedModel(BmmModel value) {
        if (usedModels == null) {
            usedModels = new ArrayList<>();
        }
        usedModels.add(value);
    }

    public void addToUsedModels(List<BmmModel> values) {
        values.forEach(value -> addToUsedmodel(value));
    }

    public void removeFromUsedModel(BmmModel item) {
        if (usedModels != null) {
            usedModels.remove(item);
        }
    }

    public void removeFromUsedModels(Collection<BmmModel> values) {
        values.forEach(this::removeFromUsedModel);
    }

    List<BmmModel> getUsedModels() {
        return this.usedModels;
    }

    public BmmModel setUsedModels(List<BmmModel> usedModels) {
        this.usedModels = usedModels;
        return this;
    }

    public List<BmmModel> usedModels() {
        return Collections.unmodifiableList(this.usedModels);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Identifier of this model, lower-case, formed from: <rm_publisher>_<model_name>_<rm_release> E.g.
     * "openehr_ehr_1.0.4".
     * cardinality: 1..1
     */
    public String modelId() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Retrieve the class definition corresponding to a_type_name (which may contain a generic part).
     * cardinality: 1..1
     */
    public BmmClass classDefinition(String a_name) {
        if (a_name == null) {
            throw new NullPointerException("Parameter a_name has cardinality NonNull, but is null.");
        }
        BmmClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Retrieve the class definition corresponding to a_type_name.
     * If it contains a generic part, this will be removed if it is a fully open generic name, otherwise it will remain intact, i.e.
     * if it is an effective generic name that identifies a BMM_GENERIC_CLASS_EFFECTIVE.
     * cardinality: 1..1
     */
    public BmmClass typeDefinition() {
        BmmClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a_class_name has a class definition in the model.
     * cardinality: 1..1
     */
    public Boolean hasClassDefinition(String a_class_name) {
        if (a_class_name == null) {
            throw new NullPointerException("Parameter a_class_name has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a_type_name is already concretely known in the system, including if it is generic, which may be open, partially open or closed.
     * cardinality: 1..1
     */
    public Boolean hasTypeDefinition(String a_type_name) {
        if (a_type_name == null) {
            throw new NullPointerException("Parameter a_type_name has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Retrieve the enumeration definition corresponding to a_type_name.
     * cardinality: 1..1
     */
    public BmmEnumeration enumerationDefinition(String a_name) {
        if (a_name == null) {
            throw new NullPointerException("Parameter a_name has cardinality NonNull, but is null.");
        }
        BmmEnumeration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * List of keys in class_definitions of items marked as primitive types.
     * cardinality: 0..1
     */
    public List<String> primitiveTypes() {
        List<String> result = null;


        return result;
    }

    /**
     * List of keys in class_definitions of items that are enumeration types.
     * cardinality: 0..1
     */
    public List<String> enumerationTypes() {
        List<String> result = null;


        return result;
    }

    /**
     * Retrieve the property definition for a_prop_name in flattened class corresponding to a_type_name.
     * cardinality: 1..1
     */
    public BmmProperty propertyDefinition() {
        BmmProperty result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a_ms_property_type is a valid 'MS' dynamic type for a_property in BMM type a_bmm_type_name.
     * 'MS' conformance means 'model-semantic' conformance, which abstracts away container types like List<>, Set<> etc and compares the dynamic type with the relation target type in the UML sense, i.e.
     * regardless of whether there is single or multiple containment.
     * cardinality: 1..1
     */
    public Boolean msConformantPropertyType(String a_bmm_type_name, String a_bmm_property_name, String a_ms_property_name) {
        if (a_bmm_type_name == null) {
            throw new NullPointerException("Parameter a_bmm_type_name has cardinality NonNull, but is null.");
        }
        if (a_bmm_property_name == null) {
            throw new NullPointerException("Parameter a_bmm_property_name has cardinality NonNull, but is null.");
        }
        if (a_ms_property_name == null) {
            throw new NullPointerException("Parameter a_ms_property_name has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Retrieve the property definition for a_property_path in flattened class corresponding to a_type_name.
     * cardinality: 1..1
     */
    public BmmProperty propertyDefinitionAtPath() {
        BmmProperty result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Retrieve the class definition for the class that owns the terminal attribute in a_prop_path in flattened class corresponding to a_type_name.
     * cardinality: 1..1
     */
    public BmmClass classDefinitionAtPath(String a_type_name, String a_prop_path) {
        if (a_type_name == null) {
            throw new NullPointerException("Parameter a_type_name has cardinality NonNull, but is null.");
        }
        if (a_prop_path == null) {
            throw new NullPointerException("Parameter a_prop_path has cardinality NonNull, but is null.");
        }
        BmmClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return all ancestor types of a_class_name up to root class (usually Any, Object or something similar).
     * Does not include current class.
     * Returns empty list if none.
     * cardinality: 0..1
     */
    public List<String> allAncestorClasses(String a_class) {
        if (a_class == null) {
            throw new NullPointerException("Parameter a_class has cardinality NonNull, but is null.");
        }
        List<String> result = null;


        return result;
    }

    /**
     * True if a_class_name is a descendant in the model of a_parent_class_name.
     * cardinality: 1..1
     */
    public Boolean isDescendantOf(String a_class_name, String a_parent_class_name) {
        if (a_class_name == null) {
            throw new NullPointerException("Parameter a_class_name has cardinality NonNull, but is null.");
        }
        if (a_parent_class_name == null) {
            throw new NullPointerException("Parameter a_parent_class_name has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Check conformance of a_desc_type to an_anc_type; the types may be generic, and may contain open generic parameters like 'T' etc.
     * These are replaced with their appropriate constrainer types, or Any during the conformance testing process.
     * Conformance is found if: [base class test] types are non-generic, and either type names are identical, or else a_desc_type has an_anc_type in its ancestors; both types are generic and pass base class test; number of generic params matches, and each generic parameter type, after 'open parameter' substitution, recursively passes; type_name_conforms_to test descendant type is generic and ancestor type is not, and they pass base classes test.
     * cardinality: 1..1
     */
    public Boolean typeConformsTo(String a_desc_type, String an_anc_type) {
        if (a_desc_type == null) {
            throw new NullPointerException("Parameter a_desc_type has cardinality NonNull, but is null.");
        }
        if (an_anc_type == null) {
            throw new NullPointerException("Parameter an_anc_type has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Generate type substitutions for the supplied type, which may be simple, generic (closed, open or partially open), or a container type.
     * In the generic and container cases, the result is the permutation of the base class type and type substitutions of all generic parameters.
     * Parameters a_type Name of a type.
     * cardinality: 1..1
     */
    public List<String> subtypes(String a_type) {
        if (a_type == null) {
            throw new NullPointerException("Parameter a_type has cardinality NonNull, but is null.");
        }
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * BMM_SIMPLE_CLASS instance for the Any class.
     * This may be defined in the BMM schema, but if not, use BMM_DEFINITIONS.any_class.
     * cardinality: 1..1
     */
    public BmmSimpleClass anyClassDefinition() {
        BmmSimpleClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * BMM_SIMPLE_TYPE instance for the Any type.
     * cardinality: 1..1
     */
    public BmmSimpleType anyTypeDefinition() {
        BmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * BMM_SIMPLE_TYPE instance for the Boolean type.
     * cardinality: 1..1
     */
    public BmmSimpleType booleanTypeDefinition() {
        BmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmModelMetadata *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Publisher of model expressed in the schema.
     * cardinality: 1..1
     */
    private String rmPublisher;

    /**
     * Release of model expressed in the schema as a 3-part numeric, e.g.
     * "3.1.0" .
     * cardinality: 1..1
     */
    private String rmRelease;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Publisher of model expressed in the schema.
     * cardinality: 1..1
     */
    public String getRmPublisher() {
        return rmPublisher;
    }

    public void setRmPublisher(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmPublisher failed, it has cardinality NonNull, but is null");
        }
        this.rmPublisher = rmPublisher;
    }

    /**
     * Release of model expressed in the schema as a 3-part numeric, e.g.
     * "3.1.0" .
     * cardinality: 1..1
     */
    public String getRmRelease() {
        return rmRelease;
    }

    public void setRmRelease(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmRelease failed, it has cardinality NonNull, but is null");
        }
        this.rmRelease = rmRelease;
    }

    //***** BmmModel *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmModel() {
    }

    public BmmModel(
            Map<string, bmmClass> classDefinitions,
            List<bmmModel> usedModels,
            String rmPublisher,
            String rmRelease,
            Map<string, bmmPackage> packages,
            BmmPackageContainer scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                packages,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
        if (rmPublisher == null) {
            throw new NullPointerException("Property:rmPublisher has cardinality NonNull, but is null");
        }
        if (rmRelease == null) {
            throw new NullPointerException("Property:rmRelease has cardinality NonNull, but is null");
        }
        this.classDefinitions = classDefinitions;
        this.usedModels = usedModels;
        this.rmPublisher = rmPublisher;
        this.rmRelease = rmRelease;
    }

    private BmmModel(Builder builder) {
        this.setClassDefinitions(builder.classDefinitions);
        this.setUsedModels(builder.usedModels);
        this.setRmPublisher(builder.rmPublisher);
        this.setRmRelease(builder.rmRelease);
        this.setPackages(builder.packages);
        this.setScope(builder.scope);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private Map<string, bmmClass> classDefinitions;
        private List<bmmModel> usedModels;
        private final String rmPublisher;  //required
        private final String rmRelease;  //required
        private Map<string, bmmPackage> packages;
        private final BmmPackageContainer scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                String rmPublisher,
                String rmRelease,
                BmmPackageContainer scope,
                String name,
                BmmDeclaration scope
        ) {
            if (rmPublisher == null) {
                throw new NullPointerException("Property:rmPublisher has cardinality NonNull, but is null");
            }
            if (rmRelease == null) {
                throw new NullPointerException("Property:rmRelease has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.rmPublisher = rmPublisher;
            this.rmRelease = rmRelease;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setClassDefinitions(Map<string, bmmClass> value) {
            this.classDefinitions = classDefinitions;
            return this;
        }

        public Builder setUsedModels(List<bmmModel> value) {
            this.usedModels = usedModels;
            return this;
        }

        public Builder setPackages(Map<string, bmmPackage> value) {
            this.packages = packages;
            return this;
        }

        public Builder setDocumentation(Map<string, any> value) {
            this.documentation = documentation;
            return this;
        }

        public Builder setExtensions(Map<string, any> value) {
            this.extensions = extensions;
            return this;
        }

        public BmmModel build() {
            return new BmmModel(this);
        }
    }


    //***** BmmModel *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmModel that = (BmmModel) object;
        return
                java.util.Objects.equals(classDefinitions, that.classDefinitions) &&
                        java.util.Objects.equals(usedModels, that.usedModels) &&
                        java.util.Objects.equals(rmPublisher, that.rmPublisher) &&
                        java.util.Objects.equals(rmRelease, that.rmRelease);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                classDefinitions,
                usedModels,
                rmPublisher,
                rmRelease
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
                "BmmModel {" +
                        "classDefinitions='" + classDefinitions + '\'' +
                        "usedModels='" + usedModels + '\'' +
                        "rmPublisher='" + rmPublisher + '\'' +
                        "rmRelease='" + rmRelease + '\'' +
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
