package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.aom2.terminology_package.ArchetypeTerminology;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Root object of an operational template.
 * An operational template is derived from a TEMPLATE definition and the ARCHETYPEs and/or TEMPLATE_OVERLAYs mentioned by that template by a process of flattening, and potentially removal of unneeded languages and terminologies.
 * An operational template is used for generating and validating RM-canonical instance data, and also as a source artefact for generating other downstream technical artefacts, including XML schemas, APIs and UI form definitions.
 */
public class OperationalTemplate extends AuthoredArchetype {

    //***** OperationalTemplate *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Compendium of flattened terminologies of archetypes externally referenced from this archetype, keyed by archetype identifier.
     * This will almost always be present in a template.
     * cardinality: 0..1
     */
    private Map<String, ArchetypeTerminology> componentTerminologies;

    /**
     * Directory of term definitions as a two-level table.
     * The outer hash keys are term codes, e.g.
     * "at4", and the inner hash key are term attribute names, e.g.
     * "text", "description" etc.
     * cardinality: 0..1
     */
    private Map<String, ArchetypeTerminology> terminologyExtracts;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Compendium of flattened terminologies of archetypes externally referenced from this archetype, keyed by archetype identifier.
     * This will almost always be present in a template.
     * cardinality: 0..1
     */

    public void putComponentTerminology(String key, ArchetypeTerminology value) {
        if (componentTerminologies == null) {
            componentTerminologies = new HashMap<>();
        }
        componentTerminologies.put(key, value);
    }

    public void putComponentTerminologies(Map<String, ArchetypeTerminology> items) {
        items.keySet().forEach(key -> putComponentterminology(key, items.get(key)));
    }

    public ArchetypeTerminology getComponentTerminology(String key) {
        if (componentTerminologies == null) {
            return null;
        }
        return componentTerminologies.get(key);
    }

    public void removeComponentTerminology(String key) {
        if (componentTerminologies != null) {
            componentTerminologies.remove(key);
        }
    }

    public void removeComponentTerminologies(Collection<String> keys) {
        keys.forEach(this::removeComponentTerminology);
    }

    public Map<String, ArchetypeTerminology> getComponentTerminologies() {
        return this.componentTerminologies;
    }

    public OperationalTemplate setComponentTerminologies(Map<String, ArchetypeTerminology> componentTerminologies) {
        this.componentTerminologies = componentTerminologies;
        return this;
    }

    public Map<String, ArchetypeTerminology> componentTerminologies() {
        return Collections.unmodifiableMap(this.componentTerminologies);
    }

    /**
     * Directory of term definitions as a two-level table.
     * The outer hash keys are term codes, e.g.
     * "at4", and the inner hash key are term attribute names, e.g.
     * "text", "description" etc.
     * cardinality: 0..1
     */

    public void putTerminologyExtract(String key, ArchetypeTerminology value) {
        if (terminologyExtracts == null) {
            terminologyExtracts = new HashMap<>();
        }
        terminologyExtracts.put(key, value);
    }

    public void putTerminologyExtracts(Map<String, ArchetypeTerminology> items) {
        items.keySet().forEach(key -> putTerminologyextract(key, items.get(key)));
    }

    public ArchetypeTerminology getTerminologyExtract(String key) {
        if (terminologyExtracts == null) {
            return null;
        }
        return terminologyExtracts.get(key);
    }

    public void removeTerminologyExtract(String key) {
        if (terminologyExtracts != null) {
            terminologyExtracts.remove(key);
        }
    }

    public void removeTerminologyExtracts(Collection<String> keys) {
        keys.forEach(this::removeTerminologyExtract);
    }

    public Map<String, ArchetypeTerminology> getTerminologyExtracts() {
        return this.terminologyExtracts;
    }

    public OperationalTemplate setTerminologyExtracts(Map<String, ArchetypeTerminology> terminologyExtracts) {
        this.terminologyExtracts = terminologyExtracts;
        return this;
    }

    public Map<String, ArchetypeTerminology> terminologyExtracts() {
        return Collections.unmodifiableMap(this.terminologyExtracts);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1
     */
    public ArchetypeTerminology componentTerminology(String an_id) {
        if (an_id == null) {
            throw new NullPointerException("Parameter an_id has cardinality NonNull, but is null.");
        }
        ArchetypeTerminology result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** OperationalTemplate *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected OperationalTemplate() {
    }

    public OperationalTemplate(
            Map<string, archetypeTerminology> componentTerminologies,
            Map<string, archetypeTerminology> terminologyExtracts,
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
                translations,
                parentArchetypeId,
                archetypeId,
                isDifferential,
                definition,
                rules,
                rmOverlay
        );
        this.componentTerminologies = componentTerminologies;
        this.terminologyExtracts = terminologyExtracts;
    }

    private OperationalTemplate(Builder builder) {
        this.setComponentTerminologies(builder.componentTerminologies);
        this.setTerminologyExtracts(builder.terminologyExtracts);
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
        private Map<string, archetypeTerminology> componentTerminologies;
        private Map<string, archetypeTerminology> terminologyExtracts;
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

        public Builder setComponentTerminologies(Map<string, archetypeTerminology> value) {
            this.componentTerminologies = componentTerminologies;
            return this;
        }

        public Builder setTerminologyExtracts(Map<string, archetypeTerminology> value) {
            this.terminologyExtracts = terminologyExtracts;
            return this;
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

        public OperationalTemplate build() {
            return new OperationalTemplate(this);
        }
    }


    //***** OperationalTemplate *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        OperationalTemplate that = (OperationalTemplate) object;
        return
                Objects.equals(componentTerminologies, that.componentTerminologies) &&
                        Objects.equals(terminologyExtracts, that.terminologyExtracts);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                componentTerminologies,
                terminologyExtracts
        );
    }

    @Override
    public String toString() {
        return
                "OperationalTemplate {" +
                        "componentTerminologies='" + componentTerminologies + '\'' +
                        "terminologyExtracts='" + terminologyExtracts + '\'' +
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
