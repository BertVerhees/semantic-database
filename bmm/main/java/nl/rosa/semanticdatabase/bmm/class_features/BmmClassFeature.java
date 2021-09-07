package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A class entity having a signature and a class as its scope.
 */
public abstract class BmmClassFeature extends BmmClassEntity {

    //***** BmmClassFeature *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Visibility of this item to client entities.
     * cardinality: 0..1
     */
    private BmmVisibility visibility;

    /**
     * Extensions to feature-level meta-types.
     * cardinality: 0..1
     */
    private List<BMM_FEATURE_EXTENSION> featureExtensions;

    /**
     * Group containing this feature.
     * cardinality: 1..1
     */
    private BmmFeatureGroup group;

    /**
     * Class within which a referenceable element is known.
     * cardinality: 1..1 (redefined)
     */
    private BmmClass scope;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Visibility of this item to client entities.
     * cardinality: 0..1
     */
    public BmmVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(BmmVisibility value) {
        this.visibility = visibility;
    }

    /**
     * Extensions to feature-level meta-types.
     * cardinality: 0..1
     */

    public void addToFeatureExtension(BMM_FEATURE_EXTENSION value) {
        if (featureExtensions == null) {
            featureExtensions = new ArrayList<>();
        }
        featureExtensions.add(value);
    }

    public void addToFeatureExtensions(List<BMM_FEATURE_EXTENSION> values) {
        values.forEach(value -> addToFeatureextension(value));
    }

    public void removeFromFeatureExtension(BMM_FEATURE_EXTENSION item) {
        if (featureExtensions != null) {
            featureExtensions.remove(item);
        }
    }

    public void removeFromFeatureExtensions(Collection<BMM_FEATURE_EXTENSION> values) {
        values.forEach(this::removeFromFeatureExtension);
    }

    List<BMM_FEATURE_EXTENSION> getFeatureExtensions() {
        return this.featureExtensions;
    }

    public BmmClassFeature setFeatureExtensions(List<BMM_FEATURE_EXTENSION> featureExtensions) {
        this.featureExtensions = featureExtensions;
        return this;
    }

    public List<BMM_FEATURE_EXTENSION> featureExtensions() {
        return Collections.unmodifiableList(this.featureExtensions);
    }

    /**
     * Group containing this feature.
     * cardinality: 1..1
     */
    public BmmFeatureGroup getGroup() {
        return group;
    }

    public void setGroup(BmmFeatureGroup value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:group failed, it has cardinality NonNull, but is null");
        }
        this.group = group;
    }

    /**
     * Class within which a referenceable element is known.
     * cardinality: 1..1 (redefined)
     */
    public BmmClass getScope() {
        return scope;
    }

    public void setScope(BmmClass value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    //***** BmmClassFeature *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmClassFeature() {
    }

    protected BmmClassFeature(
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                name,
                documentation
        );
        if (group == null) {
            throw new NullPointerException("Property:group has cardinality NonNull, but is null");
        }
        if (scope == null) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.visibility = visibility;
        this.featureExtensions = featureExtensions;
        this.group = group;
        this.scope = scope;
    }


    //***** BmmClassFeature *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmClassFeature that = (BmmClassFeature) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmClassFeature.java
                Objects.equals(visibility, that.visibility) &&
                        Objects.equals(featureExtensions, that.featureExtensions) &&
                        Objects.equals(group, that.group) &&
                        Objects.equals(scope, that.scope);
=======
                java.util.Objects.equals(visibility, that.visibility) &&
                        java.util.Objects.equals(featureExtensions, that.featureExtensions) &&
                        java.util.Objects.equals(group, that.group) &&
                        java.util.Objects.equals(scope, that.scope);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmClassFeature.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                visibility,
                featureExtensions,
                group,
                scope
        );
    }

    @Override
    public String toString() {
        return
                "BmmClassFeature {" +
                        "visibility='" + visibility + '\'' +
                        "featureExtensions='" + featureExtensions + '\'' +
                        "group='" + group + '\'' +
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
