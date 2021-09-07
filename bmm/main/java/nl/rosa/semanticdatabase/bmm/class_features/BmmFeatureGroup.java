package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A logical group of features, with a name and set of properties that applies to the group.
 */
public class BmmFeatureGroup {

    //***** BmmFeatureGroup *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Set of properties of this group, represented as name/value pairs.
     * These are understood to apply logically to all of the features contained within the group.
     * cardinality: 1..1
     */
    private Map<String, String> properties = new HashMap<>();

    /**
     * Set of features in this group.
     * cardinality: 0..1
     */
    private List<BmmClassFeature> features;

    /**
     * Optional visibility to apply to all features in this group.
     * cardinality: 0..1
     */
    private BmmVisibility visibility;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Set of properties of this group, represented as name/value pairs.
     * These are understood to apply logically to all of the features contained within the group.
     * cardinality: 1..1
     */

    public void putProperty(String key, String value) {
        properties.put(key, value);
    }

    public void putProperties(Map<String, String> items) {
        items.keySet().forEach(key -> putProperty(key, items.get(key)));
    }

    public String getProperty(String key) {
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

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public BmmFeatureGroup setProperties(Map<String, String> properties) {
        if (properties == null) {
            throw new NullPointerException(" properties has cardinality NonNull, but is null");
        }
        this.properties = properties;
        return this;
    }

    public Map<String, String> properties() {
        return Collections.unmodifiableMap(this.properties);
    }

    /**
     * Set of features in this group.
     * cardinality: 0..1
     */

    public void addToFeature(BmmClassFeature value) {
        if (features == null) {
            features = new ArrayList<>();
        }
        features.add(value);
    }

    public void addToFeatures(List<BmmClassFeature> values) {
        values.forEach(value -> addToFeature(value));
    }

    public void removeFromFeature(BmmClassFeature item) {
        if (features != null) {
            features.remove(item);
        }
    }

    public void removeFromFeatures(Collection<BmmClassFeature> values) {
        values.forEach(this::removeFromFeature);
    }

    List<BmmClassFeature> getFeatures() {
        return this.features;
    }

    public BmmFeatureGroup setFeatures(List<BmmClassFeature> features) {
        this.features = features;
        return this;
    }

    public List<BmmClassFeature> features() {
        return Collections.unmodifiableList(this.features);
    }

    /**
     * Optional visibility to apply to all features in this group.
     * cardinality: 0..1
     */
    public BmmVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(BmmVisibility value) {
        this.visibility = visibility;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Name of this feature group; defaults to 'feature'.
     */
    final String {
        default
        name = "feature"
    }

    ;

    //***** BmmFeatureGroup *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmFeatureGroup() {
    }

    public BmmFeatureGroup(
            Map<string, string> properties,
            List<bmmClassFeature> features,
            BmmVisibility visibility
    ) {
        if (properties == null) {
            throw new NullPointerException("Property:properties has cardinality NonNull, but is null");
        }
        this.properties = properties;
        this.features = features;
        this.visibility = visibility;
    }

    private BmmFeatureGroup(Builder builder) {
        this.setProperties(builder.properties);
        this.setFeatures(builder.features);
        this.setVisibility(builder.visibility);
    }

    public static class Builder {
        private final Map<string, string> properties;  //required
        private List<bmmClassFeature> features;
        private BmmVisibility visibility;

        public Builder(
                Map<string, string> properties
        ) {
            if (properties == null) {
                throw new NullPointerException("Property:properties has cardinality NonNull, but is null");
            }
            this.properties = properties;
        }

        public Builder setFeatures(List<bmmClassFeature> value) {
            this.features = features;
            return this;
        }

        public Builder setVisibility(BmmVisibility value) {
            this.visibility = visibility;
            return this;
        }

        public BmmFeatureGroup build() {
            return new BmmFeatureGroup(this);
        }
    }


    //***** BmmFeatureGroup *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmFeatureGroup that = (BmmFeatureGroup) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmFeatureGroup.java
                Objects.equals(properties, that.properties) &&
                        Objects.equals(features, that.features) &&
                        Objects.equals(visibility, that.visibility);
=======
                java.util.Objects.equals(properties, that.properties) &&
                        java.util.Objects.equals(features, that.features) &&
                        java.util.Objects.equals(visibility, that.visibility);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmFeatureGroup.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                properties,
                features,
                visibility
        );
    }

    @Override
    public String toString() {
        return
                "BmmFeatureGroup {" +
                        "properties='" + properties + '\'' +
                        "features='" + features + '\'' +
                        "visibility='" + visibility + '\'' +
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
