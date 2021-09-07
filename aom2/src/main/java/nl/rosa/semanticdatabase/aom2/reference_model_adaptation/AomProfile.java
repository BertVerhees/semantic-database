package nl.rosa.semanticdatabase.aom2.reference_model_adaptation;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Profile of common settings relating to use of reference model(s) and terminology for a given archetype developing organisation.
 */
public class AomProfile {

    //***** AomProfile *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Allowed type substitutions: Actual RM type names keyed by AOM built-in types which can subsitute for them in an archetype.
     * E.g.
     * <value = "String", key = "ISO8601_DATE"> means that if RM property TYPE.some_property is of type String, an ISO8601_DATE is allowed at that position in the archetype.
     * cardinality: 0..1
     */
    private Map<String, String> aomRmTypeSubstitutions;

    /**
     * List of mappings of lifecycle state names used in archetypes to AOM lifecycle state names.
     * value = AOM lifecycle state; key = source lifecycle state.
     * cardinality: 0..1
     */
    private Map<String, String> aomLifecycleMappings;

    /**
     * Name of this profile, usually based on the publisher it pertains to e.g.
     * "openEHR", "cdisc", etc.
     * cardinality: 1..1
     */
    private String profileName;

    /**
     * Mappings from AOM built-in types to actual types in RM: whenever the type name is encountered in an archetype, it is mapped to a specific RM type.
     * cardinality: 0..1
     */
    private Map<String, AomTypeMapping> aomRmTypeMappings;

    /**
     * Equivalences of RM primitive types to in-built set of primitive types.
     * Used to determine which AOM C_PRIMITIVE_OBJECT descendant is used for a primitive type.
     * Typical entries: value key "Real" "Double" "Integer" "Integer64"
     * cardinality: 0..1
     */
    private Map<String, String> rmPrimitiveTypeEquivalences;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Allowed type substitutions: Actual RM type names keyed by AOM built-in types which can subsitute for them in an archetype.
     * E.g.
     * <value = "String", key = "ISO8601_DATE"> means that if RM property TYPE.some_property is of type String, an ISO8601_DATE is allowed at that position in the archetype.
     * cardinality: 0..1
     */

    public void putAomRmTypeSubstitution(String key, String value) {
        if (aomRmTypeSubstitutions == null) {
            aomRmTypeSubstitutions = new HashMap<>();
        }
        aomRmTypeSubstitutions.put(key, value);
    }

    public void putAomRmTypeSubstitutions(Map<String, String> items) {
        items.keySet().forEach(key -> putAomrmtypesubstitution(key, items.get(key)));
    }

    public String getAomRmTypeSubstitution(String key) {
        if (aomRmTypeSubstitutions == null) {
            return null;
        }
        return aomRmTypeSubstitutions.get(key);
    }

    public void removeAomRmTypeSubstitution(String key) {
        if (aomRmTypeSubstitutions != null) {
            aomRmTypeSubstitutions.remove(key);
        }
    }

    public void removeAomRmTypeSubstitutions(Collection<String> keys) {
        keys.forEach(this::removeAomRmTypeSubstitution);
    }

    public Map<String, String> getAomRmTypeSubstitutions() {
        return this.aomRmTypeSubstitutions;
    }

    public AomProfile setAomRmTypeSubstitutions(Map<String, String> aomRmTypeSubstitutions) {
        this.aomRmTypeSubstitutions = aomRmTypeSubstitutions;
        return this;
    }

    public Map<String, String> aomRmTypeSubstitutions() {
        return Collections.unmodifiableMap(this.aomRmTypeSubstitutions);
    }

    /**
     * List of mappings of lifecycle state names used in archetypes to AOM lifecycle state names.
     * value = AOM lifecycle state; key = source lifecycle state.
     * cardinality: 0..1
     */

    public void putAomLifecycleMapping(String key, String value) {
        if (aomLifecycleMappings == null) {
            aomLifecycleMappings = new HashMap<>();
        }
        aomLifecycleMappings.put(key, value);
    }

    public void putAomLifecycleMappings(Map<String, String> items) {
        items.keySet().forEach(key -> putAomlifecyclemapping(key, items.get(key)));
    }

    public String getAomLifecycleMapping(String key) {
        if (aomLifecycleMappings == null) {
            return null;
        }
        return aomLifecycleMappings.get(key);
    }

    public void removeAomLifecycleMapping(String key) {
        if (aomLifecycleMappings != null) {
            aomLifecycleMappings.remove(key);
        }
    }

    public void removeAomLifecycleMappings(Collection<String> keys) {
        keys.forEach(this::removeAomLifecycleMapping);
    }

    public Map<String, String> getAomLifecycleMappings() {
        return this.aomLifecycleMappings;
    }

    public AomProfile setAomLifecycleMappings(Map<String, String> aomLifecycleMappings) {
        this.aomLifecycleMappings = aomLifecycleMappings;
        return this;
    }

    public Map<String, String> aomLifecycleMappings() {
        return Collections.unmodifiableMap(this.aomLifecycleMappings);
    }

    /**
     * Name of this profile, usually based on the publisher it pertains to e.g.
     * "openEHR", "cdisc", etc.
     * cardinality: 1..1
     */
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:profileName failed, it has cardinality NonNull, but is null");
        }
        this.profileName = profileName;
    }

    /**
     * Mappings from AOM built-in types to actual types in RM: whenever the type name is encountered in an archetype, it is mapped to a specific RM type.
     * cardinality: 0..1
     */

    public void putAomRmTypeMapping(String key, AomTypeMapping value) {
        if (aomRmTypeMappings == null) {
            aomRmTypeMappings = new HashMap<>();
        }
        aomRmTypeMappings.put(key, value);
    }

    public void putAomRmTypeMappings(Map<String, AomTypeMapping> items) {
        items.keySet().forEach(key -> putAomrmtypemapping(key, items.get(key)));
    }

    public AomTypeMapping getAomRmTypeMapping(String key) {
        if (aomRmTypeMappings == null) {
            return null;
        }
        return aomRmTypeMappings.get(key);
    }

    public void removeAomRmTypeMapping(String key) {
        if (aomRmTypeMappings != null) {
            aomRmTypeMappings.remove(key);
        }
    }

    public void removeAomRmTypeMappings(Collection<String> keys) {
        keys.forEach(this::removeAomRmTypeMapping);
    }

    public Map<String, AomTypeMapping> getAomRmTypeMappings() {
        return this.aomRmTypeMappings;
    }

    public AomProfile setAomRmTypeMappings(Map<String, AomTypeMapping> aomRmTypeMappings) {
        this.aomRmTypeMappings = aomRmTypeMappings;
        return this;
    }

    public Map<String, AomTypeMapping> aomRmTypeMappings() {
        return Collections.unmodifiableMap(this.aomRmTypeMappings);
    }

    /**
     * Equivalences of RM primitive types to in-built set of primitive types.
     * Used to determine which AOM C_PRIMITIVE_OBJECT descendant is used for a primitive type.
     * Typical entries: value key "Real" "Double" "Integer" "Integer64"
     * cardinality: 0..1
     */

    public void putRmPrimitiveTypeEquivalence(String key, String value) {
        if (rmPrimitiveTypeEquivalences == null) {
            rmPrimitiveTypeEquivalences = new HashMap<>();
        }
        rmPrimitiveTypeEquivalences.put(key, value);
    }

    public void putRmPrimitiveTypeEquivalences(Map<String, String> items) {
        items.keySet().forEach(key -> putRmprimitivetypeequivalence(key, items.get(key)));
    }

    public String getRmPrimitiveTypeEquivalence(String key) {
        if (rmPrimitiveTypeEquivalences == null) {
            return null;
        }
        return rmPrimitiveTypeEquivalences.get(key);
    }

    public void removeRmPrimitiveTypeEquivalence(String key) {
        if (rmPrimitiveTypeEquivalences != null) {
            rmPrimitiveTypeEquivalences.remove(key);
        }
    }

    public void removeRmPrimitiveTypeEquivalences(Collection<String> keys) {
        keys.forEach(this::removeRmPrimitiveTypeEquivalence);
    }

    public Map<String, String> getRmPrimitiveTypeEquivalences() {
        return this.rmPrimitiveTypeEquivalences;
    }

    public AomProfile setRmPrimitiveTypeEquivalences(Map<String, String> rmPrimitiveTypeEquivalences) {
        this.rmPrimitiveTypeEquivalences = rmPrimitiveTypeEquivalences;
        return this;
    }

    public Map<String, String> rmPrimitiveTypeEquivalences() {
        return Collections.unmodifiableMap(this.rmPrimitiveTypeEquivalences);
    }

    //***** AomProfile *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected AomProfile() {
    }

    public AomProfile(
            Map<string, string> aomRmTypeSubstitutions,
            Map<string, string> aomLifecycleMappings,
            String profileName,
            Map<string, aomTypeMapping> aomRmTypeMappings,
            Map<string, string> rmPrimitiveTypeEquivalences
    ) {
        if (profileName == null) {
            throw new NullPointerException("Property:profileName has cardinality NonNull, but is null");
        }
        this.aomRmTypeSubstitutions = aomRmTypeSubstitutions;
        this.aomLifecycleMappings = aomLifecycleMappings;
        this.profileName = profileName;
        this.aomRmTypeMappings = aomRmTypeMappings;
        this.rmPrimitiveTypeEquivalences = rmPrimitiveTypeEquivalences;
    }

    private AomProfile(Builder builder) {
        this.setAomRmTypeSubstitutions(builder.aomRmTypeSubstitutions);
        this.setAomLifecycleMappings(builder.aomLifecycleMappings);
        this.setProfileName(builder.profileName);
        this.setAomRmTypeMappings(builder.aomRmTypeMappings);
        this.setRmPrimitiveTypeEquivalences(builder.rmPrimitiveTypeEquivalences);
    }

    public static class Builder {
        private Map<string, string> aomRmTypeSubstitutions;
        private Map<string, string> aomLifecycleMappings;
        private final String profileName;  //required
        private Map<string, aomTypeMapping> aomRmTypeMappings;
        private Map<string, string> rmPrimitiveTypeEquivalences;

        public Builder(
                String profileName
        ) {
            if (profileName == null) {
                throw new NullPointerException("Property:profileName has cardinality NonNull, but is null");
            }
            this.profileName = profileName;
        }

        public Builder setAomRmTypeSubstitutions(Map<string, string> value) {
            this.aomRmTypeSubstitutions = aomRmTypeSubstitutions;
            return this;
        }

        public Builder setAomLifecycleMappings(Map<string, string> value) {
            this.aomLifecycleMappings = aomLifecycleMappings;
            return this;
        }

        public Builder setAomRmTypeMappings(Map<string, aomTypeMapping> value) {
            this.aomRmTypeMappings = aomRmTypeMappings;
            return this;
        }

        public Builder setRmPrimitiveTypeEquivalences(Map<string, string> value) {
            this.rmPrimitiveTypeEquivalences = rmPrimitiveTypeEquivalences;
            return this;
        }

        public AomProfile build() {
            return new AomProfile(this);
        }
    }


    //***** AomProfile *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AomProfile that = (AomProfile) object;
        return
                Objects.equals(aomRmTypeSubstitutions, that.aomRmTypeSubstitutions) &&
                        Objects.equals(aomLifecycleMappings, that.aomLifecycleMappings) &&
                        Objects.equals(profileName, that.profileName) &&
                        Objects.equals(aomRmTypeMappings, that.aomRmTypeMappings) &&
                        Objects.equals(rmPrimitiveTypeEquivalences, that.rmPrimitiveTypeEquivalences);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                aomRmTypeSubstitutions,
                aomLifecycleMappings,
                profileName,
                aomRmTypeMappings,
                rmPrimitiveTypeEquivalences
        );
    }

    @Override
    public String toString() {
        return
                "AomProfile {" +
                        "aomRmTypeSubstitutions='" + aomRmTypeSubstitutions + '\'' +
                        "aomLifecycleMappings='" + aomLifecycleMappings + '\'' +
                        "profileName='" + profileName + '\'' +
                        "aomRmTypeMappings='" + aomRmTypeMappings + '\'' +
                        "rmPrimitiveTypeEquivalences='" + rmPrimitiveTypeEquivalences + '\'' +
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
