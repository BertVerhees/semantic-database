package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Class representing source template, i.e.
 * a kind of archetype that may include template overlays, and may be restricted by tools to only defining mandations, prohibitions, and restrictions on elements already defined in the flat parent.
 */
public class Template extends AuthoredArchetype {

    //***** Template *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Overlay archetypes, i.e.
     * partial archetypes that include full definition and terminology, but logically derive all their meta-data from from the owning template.
     * cardinality: 0..1
     */
    private List<TemplateOverlay> overlays;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Overlay archetypes, i.e.
     * partial archetypes that include full definition and terminology, but logically derive all their meta-data from from the owning template.
     * cardinality: 0..1
     */

    public void addToOverlay(TemplateOverlay value) {
        if (overlays == null) {
            overlays = new ArrayList<>();
        }
        overlays.add(value);
    }

    public void addToOverlays(List<TemplateOverlay> values) {
        values.forEach(value -> addToOverlay(value));
    }

    public void removeFromOverlay(TemplateOverlay item) {
        if (overlays != null) {
            overlays.remove(item);
        }
    }

    public void removeFromOverlays(Collection<TemplateOverlay> values) {
        values.forEach(this::removeFromOverlay);
    }

    List<TemplateOverlay> getOverlays() {
        return this.overlays;
    }

    public Template setOverlays(List<TemplateOverlay> overlays) {
        this.overlays = overlays;
        return this;
    }

    public List<TemplateOverlay> overlays() {
        return Collections.unmodifiableList(this.overlays);
    }

    //***** Template *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Template() {
    }

    public Template(
            List<templateOverlay> overlays,
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
                terminology,
                rules,
                rmOverlay
        );
        this.overlays = overlays;
    }

    private Template(Builder builder) {
        this.setOverlays(builder.overlays);
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
        private List<templateOverlay> overlays;
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

        public Builder setOverlays(List<templateOverlay> value) {
            this.overlays = overlays;
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

        public Template build() {
            return new Template(this);
        }
    }


    //***** Template *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Template that = (Template) object;
        return
                Objects.equals(overlays, that.overlays);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                overlays
        );
    }

    @Override
    public String toString() {
        return
                "Template {" +
                        "overlays='" + overlays + '\'' +
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
