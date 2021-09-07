package nl.rosa.semanticdatabase.bmm.model_structure;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A BMM model component that contains packages and classes.
 */
public abstract class BmmPackageContainer extends BmmDeclaration {

    //***** BmmPackageContainer *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Child packages; keys all in upper case for guaranteed matching.
     * cardinality: 0..1
     */
    private Map<String, BmmPackage> packages;

    /**
     * Model element within which a referenceable element is known.
     * cardinality: 1..1 (redefined)
     */
    private BmmPackageContainer scope;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Child packages; keys all in upper case for guaranteed matching.
     * cardinality: 0..1
     */

    public void putPackage(String key, BmmPackage value) {
        if (packages == null) {
            packages = new HashMap<>();
        }
        packages.put(key, value);
    }

    public void putPackages(Map<String, BmmPackage> items) {
        items.keySet().forEach(key -> putPackage(key, items.get(key)));
    }

    public BmmPackage getPackage(String key) {
        if (packages == null) {
            return null;
        }
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

    public Map<String, BmmPackage> getPackages() {
        return this.packages;
    }

    public BmmPackageContainer setPackages(Map<String, BmmPackage> packages) {
        this.packages = packages;
        return this;
    }

    public Map<String, BmmPackage> packages() {
        return Collections.unmodifiableMap(this.packages);
    }

    /**
     * Model element within which a referenceable element is known.
     * cardinality: 1..1 (redefined)
     */
    public BmmPackageContainer getScope() {
        return scope;
    }

    public void setScope(BmmPackageContainer value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Package at the path a_path.
     * cardinality: 0..1
     */
    public BmmPackage packageAtPath(String a_path) {
        if (a_path == null) {
            throw new NullPointerException("Parameter a_path has cardinality NonNull, but is null.");
        }
        BmmPackage result = null;


        return result;
    }

    /**
     * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
     * cardinality: 0..1
     */
    public void doRecursivePackages(ElProcedureAgent action) {
        if (action == null) {
            throw new NullPointerException("Parameter action has cardinality NonNull, but is null");
        }
    }

    /**
     * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
     * cardinality: 1..1
     */
    public Boolean hasPackagePath(String a_path) {
        if (a_path == null) {
            throw new NullPointerException("Parameter a_path has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmPackageContainer *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmPackageContainer() {
    }

    protected BmmPackageContainer(
            Map<string, bmmPackage> packages,
            BmmPackageContainer scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                name,
                documentation,
                extensions
        );
        if (scope == null) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.packages = packages;
        this.scope = scope;
    }


    //***** BmmPackageContainer *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmPackageContainer that = (BmmPackageContainer) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmPackageContainer.java
                Objects.equals(packages, that.packages) &&
                        Objects.equals(scope, that.scope);
=======
                java.util.Objects.equals(packages, that.packages) &&
                        java.util.Objects.equals(scope, that.scope);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmPackageContainer.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                packages,
                scope
        );
    }

    @Override
    public String toString() {
        return
                "BmmPackageContainer {" +
                        "packages='" + packages + '\'' +
                        "scope='" + scope + '\'' +
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
