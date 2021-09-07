package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.resource_package.AuthoredResource;
import semanticdatabase.base.foundation_types.identification_package.Uuid;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Root object of a standalone, authored archetype, including all meta-data, description, other identifiers and lifecycle.
 */
public class AuthoredArchetype extends Archetype implements AuthoredResource {

    //***** AuthoredArchetype *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * ADL version if archetype was read in from an ADL sharable archetype.
     * cardinality: 0..1
     */
    private String adlVersion;

    /**
     * Unique identifier of this archetype artefact instance.
     * A new identifier is assigned every time the content is changed by a tool.
     * Used by tools to distinguish different revisions and/or interim snapshots of the same artefact.
     * cardinality: 1..1
     */
    private Uuid buildUid;

    /**
     * Semver.org compatible release of the most recent reference model release on which the archetype in its current version is based.
     * This does not imply conformance only to this release, since an archetype may be valid with respect to multiple releases of a reference model.
     * cardinality: 1..1
     */
    private String rmRelease;

    /**
     * If True, indicates that this artefact was machine-generated from some other source, in which case, tools would expect to overwrite this artefact on a new generation.
     * Editing tools should set this value to False when a user starts to manually edit an archetype.
     * cardinality: 1..1
     */
    private Boolean isGenerated;

    /**
     * cardinality: 1..1
     */
    private Map<String, String> otherMetaData = new HashMap<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * ADL version if archetype was read in from an ADL sharable archetype.
     * cardinality: 0..1
     */
    public String getAdlVersion() {
        return adlVersion;
    }

    public void setAdlVersion(String value) {
        this.adlVersion = adlVersion;
    }

    /**
     * Unique identifier of this archetype artefact instance.
     * A new identifier is assigned every time the content is changed by a tool.
     * Used by tools to distinguish different revisions and/or interim snapshots of the same artefact.
     * cardinality: 1..1
     */
    public Uuid getBuildUid() {
        return buildUid;
    }

    public void setBuildUid(Uuid value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:buildUid failed, it has cardinality NonNull, but is null");
        }
        this.buildUid = buildUid;
    }

    /**
     * Semver.org compatible release of the most recent reference model release on which the archetype in its current version is based.
     * This does not imply conformance only to this release, since an archetype may be valid with respect to multiple releases of a reference model.
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

    /**
     * If True, indicates that this artefact was machine-generated from some other source, in which case, tools would expect to overwrite this artefact on a new generation.
     * Editing tools should set this value to False when a user starts to manually edit an archetype.
     * cardinality: 1..1
     */
    public Boolean getIsGenerated() {
        return isGenerated;
    }

    public void setIsGenerated(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isGenerated failed, it has cardinality NonNull, but is null");
        }
        this.isGenerated = isGenerated;
    }

    /**
     * cardinality: 1..1
     */

    public void putOtherMetaData(String key, String value) {
        otherMetaData.put(key, value);
    }

    public void putOtherMetaData(Map<String, String> items) {
        items.keySet().forEach(key -> putOthermetadat(key, items.get(key)));
    }

    public String getOtherMetaData(String key) {
        return otherMetaData.get(key);
    }

    public void removeOtherMetaData(String key) {
        if (otherMetaData != null) {
            otherMetaData.remove(key);
        }
    }

    public void removeOtherMetaData(Collection<String> keys) {
        keys.forEach(this::removeOtherMetaData);
    }

    public Map<String, String> getOtherMetaData() {
        return this.otherMetaData;
    }

    public AuthoredArchetype setOtherMetaData(Map<String, String> otherMetaData) {
        if (otherMetaData == null) {
            throw new NullPointerException(" otherMetaData has cardinality NonNull, but is null");
        }
        this.otherMetaData = otherMetaData;
        return this;
    }

    public Map<String, String> otherMetaData() {
        return Collections.unmodifiableMap(this.otherMetaData);
    }

    //***** AuthoredResource *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Unique identifier of the family of archetypes having the same interface identifier (same major version).
     * cardinality: 0..1
     */
    private Uuid uid;

    /**
     * Language in which this resource was initially authored.
     * Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality.
     * Language is relevant in both the description and ontology sections.
     * cardinality: 1..1
     */
    private TerminologyCode originalLanguage;

    /**
     * Description and lifecycle information of the resource.
     * cardinality: 0..1
     */
    private ResourceDescription description;

    /**
     * True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     * cardinality: 0..1
     */
    private Boolean isControlled;

    /**
     * Annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     * cardinality: 0..1
     */
    private RESOURCE_ANNOTATIONS annotations;

    /**
     * List of details for each natural translation made of this resource, keyed by language code.
     * For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     * cardinality: 0..1
     */
    private Map<String, TranslationDetails> translations;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Unique identifier of the family of archetypes having the same interface identifier (same major version).
     * cardinality: 0..1
     */
    public Uuid getUid() {
        return uid;
    }

    public void setUid(Uuid value) {
        this.uid = uid;
    }

    /**
     * Language in which this resource was initially authored.
     * Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality.
     * Language is relevant in both the description and ontology sections.
     * cardinality: 1..1
     */
    public TerminologyCode getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(TerminologyCode value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:originalLanguage failed, it has cardinality NonNull, but is null");
        }
        this.originalLanguage = originalLanguage;
    }

    /**
     * Description and lifecycle information of the resource.
     * cardinality: 0..1
     */
    public ResourceDescription getDescription() {
        return description;
    }

    public void setDescription(ResourceDescription value) {
        this.description = description;
    }

    /**
     * True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     * cardinality: 0..1
     */
    public Boolean getIsControlled() {
        return isControlled;
    }

    public void setIsControlled(Boolean value) {
        this.isControlled = isControlled;
    }

    /**
     * Annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     * cardinality: 0..1
     */
    public RESOURCE_ANNOTATIONS getAnnotations() {
        return annotations;
    }

    public void setAnnotations(RESOURCE_ANNOTATIONS value) {
        this.annotations = annotations;
    }

    /**
     * List of details for each natural translation made of this resource, keyed by language code.
     * For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     * cardinality: 0..1
     */

    public void putTranslation(String key, TranslationDetails value) {
        if (translations == null) {
            translations = new HashMap<>();
        }
        translations.put(key, value);
    }

    public void putTranslations(Map<String, TranslationDetails> items) {
        items.keySet().forEach(key -> putTranslation(key, items.get(key)));
    }

    public TranslationDetails getTranslation(String key) {
        if (translations == null) {
            return null;
        }
        return translations.get(key);
    }

    public void removeTranslation(String key) {
        if (translations != null) {
            translations.remove(key);
        }
    }

    public void removeTranslations(Collection<String> keys) {
        keys.forEach(this::removeTranslation);
    }

    public Map<String, TranslationDetails> getTranslations() {
        return this.translations;
    }

    public AuthoredResource setTranslations(Map<String, TranslationDetails> translations) {
        this.translations = translations;
        return this;
    }

    public Map<String, TranslationDetails> translations() {
        return Collections.unmodifiableMap(this.translations);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * Most recent revision in revision_history if is_controlled else (uncontrolled) .
 * cardinality: 1..1
 *
 */
    public Result =

    revision_history.most_recent_version currentRevision() {
        Result = revision_history.most_recent_version result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Total list of languages available in this resource, derived from original_language and translations.
     * cardinality: 1..1
     */
    public List<String> languagesAvailable() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** AuthoredArchetype *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected AuthoredArchetype() {
    }

    public AuthoredArchetype(
            String adlVersion,
            Uuid buildUid,
            String rmRelease,
            Boolean isGenerated,
            Map<string, string> otherMetaData,
            Uuid uid,
            TerminologyCode originalLanguage,
            ResourceDescription description,
            Boolean isControlled,
            ResourceAnnotations annotations,
            Map<string, translationDetails> translations,
            String parentArchetypeId,
            ArchetypeHrid archetypeId,
            Boolean isDifferential,
            CComplexObject definition,
            ArchetypeTerminology terminology,
            List<bmmAssertion> rules,
            RmOverlay rmOverlay
    ) {
        super(
                parentArchetypeId,
                archetypeId,
                isDifferential,
                definition,
                terminology,
                rules,
                rmOverlay
        );
        if (buildUid == null) {
            throw new NullPointerException("Property:buildUid has cardinality NonNull, but is null");
        }
        if (rmRelease == null) {
            throw new NullPointerException("Property:rmRelease has cardinality NonNull, but is null");
        }
        if (isGenerated == null) {
            throw new NullPointerException("Property:isGenerated has cardinality NonNull, but is null");
        }
        if (otherMetaData == null) {
            throw new NullPointerException("Property:otherMetaData has cardinality NonNull, but is null");
        }
        if (originalLanguage == null) {
            throw new NullPointerException("Property:originalLanguage has cardinality NonNull, but is null");
        }
        this.adlVersion = adlVersion;
        this.buildUid = buildUid;
        this.rmRelease = rmRelease;
        this.isGenerated = isGenerated;
        this.otherMetaData = otherMetaData;
        this.uid = uid;
        this.originalLanguage = originalLanguage;
        this.description = description;
        this.isControlled = isControlled;
        this.annotations = annotations;
        this.translations = translations;
    }

    private AuthoredArchetype(Builder builder) {
        this.setAdlVersion(builder.adlVersion);
        this.setBuildUid(builder.buildUid);
        this.setRmRelease(builder.rmRelease);
        this.setIsGenerated(builder.isGenerated);
        this.setOtherMetaData(builder.otherMetaData);
        this.setUid(builder.uid);
        this.setOriginalLanguage(builder.originalLanguage);
        this.setDescription(builder.description);
        this.setIsControlled(builder.isControlled);
        this.setAnnotations(builder.annotations);
        this.setTranslations(builder.translations);
        this.setParentArchetypeId(builder.parentArchetypeId);
        this.setArchetypeId(builder.archetypeId);
        this.setIsDifferential(builder.isDifferential);
        this.setDefinition(builder.definition);
        this.setTerminology(builder.terminology);
        this.setRules(builder.rules);
        this.setRmOverlay(builder.rmOverlay);
    }

    public static class Builder {
        private String adlVersion;
        private final Uuid buildUid;  //required
        private final String rmRelease;  //required
        private final Boolean isGenerated;  //required
        private final Map<string, string> otherMetaData;  //required
        private Uuid uid;
        private final TerminologyCode originalLanguage;  //required
        private ResourceDescription description;
        private Boolean isControlled;
        private ResourceAnnotations annotations;
        private Map<string, translationDetails> translations;
        private String parentArchetypeId;
        private final ArchetypeHrid archetypeId;  //required
        private final Boolean isDifferential;  //required
        private final CComplexObject definition;  //required
        private final ArchetypeTerminology terminology;  //required
        private List<bmmAssertion> rules;
        private RmOverlay rmOverlay;

        public Builder(
                Uuid buildUid,
                String rmRelease,
                Boolean isGenerated,
                Map<string, string> otherMetaData,
                TerminologyCode originalLanguage,
                ArchetypeHrid archetypeId,
                Boolean isDifferential,
                CComplexObject definition,
                ArchetypeTerminology terminology
        ) {
            if (buildUid == null) {
                throw new NullPointerException("Property:buildUid has cardinality NonNull, but is null");
            }
            if (rmRelease == null) {
                throw new NullPointerException("Property:rmRelease has cardinality NonNull, but is null");
            }
            if (isGenerated == null) {
                throw new NullPointerException("Property:isGenerated has cardinality NonNull, but is null");
            }
            if (otherMetaData == null) {
                throw new NullPointerException("Property:otherMetaData has cardinality NonNull, but is null");
            }
            if (originalLanguage == null) {
                throw new NullPointerException("Property:originalLanguage has cardinality NonNull, but is null");
            }
            if (archetypeId == null) {
                throw new NullPointerException("Property:archetypeId has cardinality NonNull, but is null");
            }
            if (isDifferential == null) {
                throw new NullPointerException("Property:isDifferential has cardinality NonNull, but is null");
            }
            if (definition == null) {
                throw new NullPointerException("Property:definition has cardinality NonNull, but is null");
            }
            if (terminology == null) {
                throw new NullPointerException("Property:terminology has cardinality NonNull, but is null");
            }
            this.buildUid = buildUid;
            this.rmRelease = rmRelease;
            this.isGenerated = isGenerated;
            this.otherMetaData = otherMetaData;
            this.originalLanguage = originalLanguage;
            this.archetypeId = archetypeId;
            this.isDifferential = isDifferential;
            this.definition = definition;
            this.terminology = terminology;
        }

        public Builder setAdlVersion(String value) {
            this.adlVersion = adlVersion;
            return this;
        }

        public Builder setUid(Uuid value) {
            this.uid = uid;
            return this;
        }

        public Builder setDescription(ResourceDescription value) {
            this.description = description;
            return this;
        }

        public Builder setIsControlled(Boolean value) {
            this.isControlled = isControlled;
            return this;
        }

        public Builder setAnnotations(ResourceAnnotations value) {
            this.annotations = annotations;
            return this;
        }

        public Builder setTranslations(Map<string, translationDetails> value) {
            this.translations = translations;
            return this;
        }

        public Builder setParentArchetypeId(String value) {
            this.parentArchetypeId = parentArchetypeId;
            return this;
        }

        public Builder setRules(List<bmmAssertion> value) {
            this.rules = rules;
            return this;
        }

        public Builder setRmOverlay(RmOverlay value) {
            this.rmOverlay = rmOverlay;
            return this;
        }

        public AuthoredArchetype build() {
            return new AuthoredArchetype(this);
        }
    }


    //***** AuthoredArchetype *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AuthoredArchetype that = (AuthoredArchetype) object;
        return
                Objects.equals(adlVersion, that.adlVersion) &&
                        Objects.equals(buildUid, that.buildUid) &&
                        Objects.equals(rmRelease, that.rmRelease) &&
                        Objects.equals(isGenerated, that.isGenerated) &&
                        Objects.equals(otherMetaData, that.otherMetaData) &&
                        Objects.equals(uid, that.uid) &&
                        Objects.equals(originalLanguage, that.originalLanguage) &&
                        Objects.equals(description, that.description) &&
                        Objects.equals(isControlled, that.isControlled) &&
                        Objects.equals(annotations, that.annotations) &&
                        Objects.equals(translations, that.translations);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                adlVersion,
                buildUid,
                rmRelease,
                isGenerated,
                otherMetaData,
                uid,
                originalLanguage,
                description,
                isControlled,
                annotations,
                translations
        );
    }

    @Override
    public String toString() {
        return
                "AuthoredArchetype {" +
                        "adlVersion='" + adlVersion + '\'' +
                        "buildUid='" + buildUid + '\'' +
                        "rmRelease='" + rmRelease + '\'' +
                        "isGenerated='" + isGenerated + '\'' +
                        "otherMetaData='" + otherMetaData + '\'' +
                        "uid='" + uid + '\'' +
                        "originalLanguage='" + originalLanguage + '\'' +
                        "description='" + description + '\'' +
                        "isControlled='" + isControlled + '\'' +
                        "annotations='" + annotations + '\'' +
                        "translations='" + translations + '\'' +
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
