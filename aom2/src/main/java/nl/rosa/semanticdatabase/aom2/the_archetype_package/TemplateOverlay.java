package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A concrete form of the bare ARCHETYPE class, used to represent overlays in a source template.
 * Overlays have no meta-data of their own, and are instead documented by their owning template.
 */
public class TemplateOverlay extends Archetype {

    //***** TemplateOverlay *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected TemplateOverlay() {
    }

    public TemplateOverlay(
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
    }

    private TemplateOverlay(Builder builder) {
        this.setParentArchetypeId(builder.parentArchetypeId);
        this.setArchetypeId(builder.archetypeId);
        this.setIsDifferential(builder.isDifferential);
        this.setDefinition(builder.definition);
        this.setTerminology(builder.terminology);
        this.setRules(builder.rules);
        this.setRmOverlay(builder.rmOverlay);
    }

    public static class Builder {
        private String parentArchetypeId;
        private final ArchetypeHrid archetypeId;  //required
        private final Boolean isDifferential;  //required
        private final CComplexObject definition;  //required
        private final ArchetypeTerminology terminology;  //required
        private List<bmmAssertion> rules;
        private RmOverlay rmOverlay;

        public Builder(
                ArchetypeHrid archetypeId,
                Boolean isDifferential,
                CComplexObject definition,
                ArchetypeTerminology terminology
        ) {
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
            this.archetypeId = archetypeId;
            this.isDifferential = isDifferential;
            this.definition = definition;
            this.terminology = terminology;
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

        public TemplateOverlay build() {
            return new TemplateOverlay(this);
        }
    }


    //***** TemplateOverlay *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "TemplateOverlay {" +
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
