package nl.rosa.semanticdatabase.aom2.reference_model_adaptation;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Data object expressing a mapping between two types.
 */
public class AomTypeMapping {

    //***** AomTypeMapping *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of the AOM type being mapped to an RM type.
     * cardinality: 1..1
     */
    private String sourceClassName;

    /**
     * Name of the RM type in the mapping.
     * cardinality: 1..1
     */
    private String targetClassName;

    /**
     * List of mappings of properties of this type to another type.
     * cardinality: 0..1
     */
    private Map<String, AomPropertyMapping> propertyMappings;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of the AOM type being mapped to an RM type.
     * cardinality: 1..1
     */
    public String getSourceClassName() {
        return sourceClassName;
    }

    public void setSourceClassName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:sourceClassName failed, it has cardinality NonNull, but is null");
        }
        this.sourceClassName = sourceClassName;
    }

    /**
     * Name of the RM type in the mapping.
     * cardinality: 1..1
     */
    public String getTargetClassName() {
        return targetClassName;
    }

    public void setTargetClassName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:targetClassName failed, it has cardinality NonNull, but is null");
        }
        this.targetClassName = targetClassName;
    }

    /**
     * List of mappings of properties of this type to another type.
     * cardinality: 0..1
     */

    public void putPropertyMapping(String key, AomPropertyMapping value) {
        if (propertyMappings == null) {
            propertyMappings = new HashMap<>();
        }
        propertyMappings.put(key, value);
    }

    public void putPropertyMappings(Map<String, AomPropertyMapping> items) {
        items.keySet().forEach(key -> putPropertymapping(key, items.get(key)));
    }

    public AomPropertyMapping getPropertyMapping(String key) {
        if (propertyMappings == null) {
            return null;
        }
        return propertyMappings.get(key);
    }

    public void removePropertyMapping(String key) {
        if (propertyMappings != null) {
            propertyMappings.remove(key);
        }
    }

    public void removePropertyMappings(Collection<String> keys) {
        keys.forEach(this::removePropertyMapping);
    }

    public Map<String, AomPropertyMapping> getPropertyMappings() {
        return this.propertyMappings;
    }

    public AomTypeMapping setPropertyMappings(Map<String, AomPropertyMapping> propertyMappings) {
        this.propertyMappings = propertyMappings;
        return this;
    }

    public Map<String, AomPropertyMapping> propertyMappings() {
        return Collections.unmodifiableMap(this.propertyMappings);
    }

    //***** AomTypeMapping *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected AomTypeMapping() {
    }

    public AomTypeMapping(
            String sourceClassName,
            String targetClassName,
            Map<string, aomPropertyMapping> propertyMappings
    ) {
        if (sourceClassName == null) {
            throw new NullPointerException("Property:sourceClassName has cardinality NonNull, but is null");
        }
        if (targetClassName == null) {
            throw new NullPointerException("Property:targetClassName has cardinality NonNull, but is null");
        }
        this.sourceClassName = sourceClassName;
        this.targetClassName = targetClassName;
        this.propertyMappings = propertyMappings;
    }

    private AomTypeMapping(Builder builder) {
        this.setSourceClassName(builder.sourceClassName);
        this.setTargetClassName(builder.targetClassName);
        this.setPropertyMappings(builder.propertyMappings);
    }

    public static class Builder {
        private final String sourceClassName;  //required
        private final String targetClassName;  //required
        private Map<string, aomPropertyMapping> propertyMappings;

        public Builder(
                String sourceClassName,
                String targetClassName
        ) {
            if (sourceClassName == null) {
                throw new NullPointerException("Property:sourceClassName has cardinality NonNull, but is null");
            }
            if (targetClassName == null) {
                throw new NullPointerException("Property:targetClassName has cardinality NonNull, but is null");
            }
            this.sourceClassName = sourceClassName;
            this.targetClassName = targetClassName;
        }

        public Builder setPropertyMappings(Map<string, aomPropertyMapping> value) {
            this.propertyMappings = propertyMappings;
            return this;
        }

        public AomTypeMapping build() {
            return new AomTypeMapping(this);
        }
    }


    //***** AomTypeMapping *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AomTypeMapping that = (AomTypeMapping) object;
        return
                Objects.equals(sourceClassName, that.sourceClassName) &&
                        Objects.equals(targetClassName, that.targetClassName) &&
                        Objects.equals(propertyMappings, that.propertyMappings);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                sourceClassName,
                targetClassName,
                propertyMappings
        );
    }

    @Override
    public String toString() {
        return
                "AomTypeMapping {" +
                        "sourceClassName='" + sourceClassName + '\'' +
                        "targetClassName='" + targetClassName + '\'' +
                        "propertyMappings='" + propertyMappings + '\'' +
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
