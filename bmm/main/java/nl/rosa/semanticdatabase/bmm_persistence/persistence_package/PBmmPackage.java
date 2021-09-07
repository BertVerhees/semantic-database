package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmPackage;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persisted form of a package as a tree structure whose nodes can contain more packages and/or classes.
 */
public class PBmmPackage extends PBmmModelElement implements PBmmPackageContainer {

    //***** PBmmPackage *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
     * Persistent attribute.
     * cardinality: 1..1
     */
    private String name;

    /**
     * List of classes in this package.
     * Persistent attribute.
     * cardinality: 0..1
     */
    private List<String> classes;

    /**
     * BMM_PACKAGE created by create_bmm_package_definition.
     * cardinality: 0..1
     */
    private BmmPackage bmmPackageDefinition;

/**
 *
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * cardinality: 0..1
 *
 */
    private;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
     * Persistent attribute.
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
     * List of classes in this package.
     * Persistent attribute.
     * cardinality: 0..1
     */

    public void addToClasse(String value) {
        if (classes == null) {
            classes = new ArrayList<>();
        }
        classes.add(value);
    }

    public void addToClasses(List<String> values) {
        values.forEach(value -> addToClasse(value));
    }

    public void removeFromClasse(String item) {
        if (classes != null) {
            classes.remove(item);
        }
    }

    public void removeFromClasses(Collection<String> values) {
        values.forEach(this::removeFromClasse);
    }

    List<String> getClasses() {
        return this.classes;
    }

    public PBmmPackage setClasses(List<String> classes) {
        this.classes = classes;
        return this;
    }

    public List<String> classes() {
        return Collections.unmodifiableList(this.classes);
    }

    /**
     * BMM_PACKAGE created by create_bmm_package_definition.
     * cardinality: 0..1
     */
    public BmmPackage getBmmPackageDefinition() {
        return bmmPackageDefinition;
    }

    public void setBmmPackageDefinition(BmmPackage value) {
        this.bmmPackageDefinition = bmmPackageDefinition;
    }

    /**
     * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
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
     * Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.
     * cardinality: 0..1
     */
    public void merge(PBmmPackage other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null");
        }
    }

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

    //***** PBmmPackage *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmPackage() {
    }

    public PBmmPackage(
            String name,
            List<string> classes,
            BmmPackage bmmPackageDefinition,
            Map<string, pBmmPackage> packages,
            String documentation
    ) {
        super(
                documentation
        );
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (packages == null) {
            throw new NullPointerException("Property:packages has cardinality NonNull, but is null");
        }
        this.name = name;
        this.classes = classes;
        this.bmmPackageDefinition = bmmPackageDefinition;
        this.packages = packages;
    }

    private PBmmPackage(Builder builder) {
        this.setName(builder.name);
        this.setClasses(builder.classes);
        this.setBmmPackageDefinition(builder.bmmPackageDefinition);
        this.setPackages(builder.packages);
        this.setDocumentation(builder.documentation);
    }

    public static class Builder {
        private final String name;  //required
        private List<string> classes;
        private BmmPackage bmmPackageDefinition;
        private final Map<string, pBmmPackage> packages;  //required
        private String documentation;

        public Builder(
                String name,
                Map<string, pBmmPackage> packages
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (packages == null) {
                throw new NullPointerException("Property:packages has cardinality NonNull, but is null");
            }
            this.name = name;
            this.packages = packages;
        }

        public Builder setClasses(List<string> value) {
            this.classes = classes;
            return this;
        }

        public Builder setBmmPackageDefinition(BmmPackage value) {
            this.bmmPackageDefinition = bmmPackageDefinition;
            return this;
        }

        public Builder setDocumentation(String value) {
            this.documentation = documentation;
            return this;
        }

        public PBmmPackage build() {
            return new PBmmPackage(this);
        }
    }


    //***** PBmmPackage *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmPackage that = (PBmmPackage) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmPackage.java
                Objects.equals(name, that.name) &&
                        Objects.equals(classes, that.classes) &&
                        Objects.equals(bmmPackageDefinition, that.bmmPackageDefinition) &&
                        Objects.equals(packages, that.packages);
=======
                java.util.Objects.equals(name, that.name) &&
                        java.util.Objects.equals(classes, that.classes) &&
                        java.util.Objects.equals(bmmPackageDefinition, that.bmmPackageDefinition) &&
                        java.util.Objects.equals(packages, that.packages);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmPackage.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                classes,
                bmmPackageDefinition,
                packages
        );
    }

    @Override
    public String toString() {
        return
                "PBmmPackage {" +
                        "name='" + name + '\'' +
                        "classes='" + classes + '\'' +
                        "bmmPackageDefinition='" + bmmPackageDefinition + '\'' +
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
