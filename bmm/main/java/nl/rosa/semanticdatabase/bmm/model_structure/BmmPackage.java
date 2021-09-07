package nl.rosa.semanticdatabase.bmm.model_structure;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstraction of a package as a tree structure whose nodes can contain other packages and classes.
 * The name may be qualified if it is a top-level package.
 */
public class BmmPackage extends BmmPackageContainer {

    //***** BmmPackage *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Classes listed as being in this package.
     * cardinality: 0..1
     */
    private List<BmmClass> classes;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Classes listed as being in this package.
     * cardinality: 0..1
     */

    public void addToClasse(BmmClass value) {
        if (classes == null) {
            classes = new ArrayList<>();
        }
        classes.add(value);
    }

    public void addToClasses(List<BmmClass> values) {
        values.forEach(value -> addToClasse(value));
    }

    public void removeFromClasse(BmmClass item) {
        if (classes != null) {
            classes.remove(item);
        }
    }

    public void removeFromClasses(Collection<BmmClass> values) {
        values.forEach(this::removeFromClasse);
    }

    List<BmmClass> getClasses() {
        return this.classes;
    }

    public BmmPackage setClasses(List<BmmClass> classes) {
        this.classes = classes;
        return this;
    }

    public List<BmmClass> classes() {
        return Collections.unmodifiableList(this.classes);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the structure until classes are obtained from child packages.
     * Recurse into each child only far enough to find the first level of classes.
     * cardinality: 0..1
     */
    public List<BmmClass> rootClasses() {
        List<BmmClass> result = null;


        return result;
    }

    /**
     * Full path of this package back to root package.
     * cardinality: 1..1
     */
    public String path() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmPackage *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmPackage() {
    }

    public BmmPackage(
            List<bmmClass> classes,
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
        this.classes = classes;
    }

    private BmmPackage(Builder builder) {
        this.setClasses(builder.classes);
        this.setPackages(builder.packages);
        this.setScope(builder.scope);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private List<bmmClass> classes;
        private Map<string, bmmPackage> packages;
        private final BmmPackageContainer scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                BmmPackageContainer scope,
                String name,
                BmmDeclaration scope
        ) {
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setClasses(List<bmmClass> value) {
            this.classes = classes;
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

        public BmmPackage build() {
            return new BmmPackage(this);
        }
    }


    //***** BmmPackage *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmPackage that = (BmmPackage) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmPackage.java
                Objects.equals(classes, that.classes);
=======
                java.util.Objects.equals(classes, that.classes);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmPackage.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                classes
        );
    }

    @Override
    public String toString() {
        return
                "BmmPackage {" +
                        "classes='" + classes + '\'' +
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
