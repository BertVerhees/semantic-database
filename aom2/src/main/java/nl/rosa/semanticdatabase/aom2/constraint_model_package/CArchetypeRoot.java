package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

import java.util.List;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A specialisation of C_COMPLEX_OBJECT whose node_id attribute is an archetype identifier rather than the normal internal node code (i.e.
 * id-code).
 * Used in two situations.
 * The first is to represent an 'external reference' to an archetype from within another archetype or template.
 * This supports re-use.
 * The second use is within a template, where it is used as a slot-filler.
 * For a new external reference, the node_id is set in the normal way, i.e.
 * with a new code at the specialisation level of the archetype.
 * For a slot-filler or a redefined external reference, the node_id is set to a specialised version of the node_id of the node being specialised, allowing matching to occur during flattening.
 * In all uses within source archetypes and templates, the children attribute is Void.
 * In an operational template, the node_id is converted to the archetype_ref, and the structure contains the result of flattening any template overlay structure and the underlying flat archetype.
 */
public class CArchetypeRoot extends CComplexObject {

    //***** CArchetypeRoot *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to archetype is being used to fill a slot or redefine an external reference.
     * Typically an 'interface' archetype id, i.e.
     * identifier with partial version information.
     * cardinality: 1..1
     */
    private String archetypeRef;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to archetype is being used to fill a slot or redefine an external reference.
     * Typically an 'interface' archetype id, i.e.
     * identifier with partial version information.
     * cardinality: 1..1
     */
    public String getArchetypeRef() {
        return archetypeRef;
    }

    public void setArchetypeRef(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:archetypeRef failed, it has cardinality NonNull, but is null");
        }
        this.archetypeRef = archetypeRef;
    }

    //***** CArchetypeRoot *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CArchetypeRoot(
            String archetypeRef,
            //CComplexObject
            List<CAttribute> attributes,
            List<CAttributeTuple> attributeTuples,
            //CDefinedObject
            Object defaultValue,
            //CObject
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            //ArchetypeConstraint
            ArchetypeConstraint parent,
            CSecondOrder socParent

    ) {
        super(
                attributes,
                attributeTuples,
                defaultValue,
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent
        );
        if (archetypeRef == null) {
            throw new NullPointerException("Property:archetypeRef has cardinality NonNull, but is null");
        }
        this.archetypeRef = archetypeRef;
    }

    private CArchetypeRoot(Builder builder) {
        this(
                builder.archetypeRef,
                builder.attributes,
                builder.attributeTuples,
                builder.defaultValue,
                builder.rmTypeName,
                builder.occurrences,
                builder.nodeId,
                builder.isDeprecated,
                builder.siblingOrder,
                builder.parent,
                builder.socParent
        );
    }

    public static class Builder {
        private final String archetypeRef;  //required
        private List<CAttribute> attributes;
        private List<CAttributeTuple> attributeTuples;
        private Object defaultValue;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                String archetypeRef,
                String rmTypeName,
                String nodeId
        ) {
            if (archetypeRef == null) {
                throw new NullPointerException("Property:archetypeRef has cardinality NonNull, but is null");
            }
            if (rmTypeName == null) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if (nodeId == null) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.archetypeRef = archetypeRef;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setAttributes(List<CAttribute> value) {
            this.attributes = value;
            return this;
        }

        public Builder setAttributeTuples(List<CAttributeTuple> value) {
            this.attributeTuples = value;
            return this;
        }

        public Builder setDefaultValue(Object value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setOccurrences(MultiplicityInterval value) {
            this.occurrences = value;
            return this;
        }

        public Builder setIsDeprecated(Boolean value) {
            this.isDeprecated = value;
            return this;
        }

        public Builder setSiblingOrder(SiblingOrder value) {
            this.siblingOrder = value;
            return this;
        }

        public Builder setParent(ArchetypeConstraint value) {
            this.parent = value;
            return this;
        }

        public Builder setSocParent(CSecondOrder value) {
            this.socParent = value;
            return this;
        }

        public CArchetypeRoot build() {
            return new CArchetypeRoot(this);
        }
    }


    //***** CArchetypeRoot *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CArchetypeRoot that = (CArchetypeRoot) object;
        return
                Objects.equals(archetypeRef, that.archetypeRef);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                archetypeRef
        );
    }

    @Override
    public String toString() {
        return
                "CArchetypeRoot {" +
                        "archetypeRef='" + archetypeRef + '\'' +
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
