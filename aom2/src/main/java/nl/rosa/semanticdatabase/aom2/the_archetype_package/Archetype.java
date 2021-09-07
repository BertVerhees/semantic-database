package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.utils.aom2_interfaces.IArchetype;
import nl.rosa.semanticdatabase.aom2.constraint_model_package.CComplexObject;
import nl.rosa.semanticdatabase.aom2.terminology_package.ArchetypeTerminology;
import nl.rosa.semanticdatabase.bmm.statements.BmmAssertion;
import nl.rosa.semanticdatabase.aom2.the_rm_overlay_package.RmOverlay;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * The ARCHETYPE class defines the core formal model of the root object of any archetype or template.
 * It includes only basic identification information, and otherwise provides the structural connections from the Archetype to its constituent parts, i.e.
 * definition (a C_COMPLEX_OBJECT), terminology (ARCHEYTPE_TERMINOLOGY) and so on.
 * It is the parent class of all concrete types of archetype.
 */
public abstract class Archetype implements IArchetype {

    //***** Archetype *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Archetype reference of the specialisation par-ent of this archetype, if applicable.
     * May take the form of an archetype interface identifier, i.e.
     * the identifier up to the major version only, or can be deeper.
     * cardinality: 0..1
     */
    private String parentArchetypeId;

    /**
     * Identifier of this archetype.
     * cardinality: 1..1
     */
    private ArchetypeHrid archetypeId;

    /**
     * Flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     * cardinality: 1..1
     */
    private Boolean isDifferential;

    /**
     * Root node of the definition of this archetype.
     * cardinality: 1..1
     */
    private CComplexObject definition;

    /**
     * The terminology of the archetype.
     * cardinality: 1..1
     */
    private ArchetypeTerminology terminology;

    /**
     * Rules relating to this archetype.
     * Statements are expressed in first order predicate logic, and usually refer to at least two attributes.
     * cardinality: 0..1
     */
    private List<BmmAssertion> rules;

    /**
     * cardinality: 0..1
     */
    private RmOverlay rmOverlay;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Archetype reference of the specialisation par-ent of this archetype, if applicable.
     * May take the form of an archetype interface identifier, i.e.
     * the identifier up to the major version only, or can be deeper.
     * cardinality: 0..1
     */
    public String getParentArchetypeId() {
        return parentArchetypeId;
    }

    public void setParentArchetypeId(String value) {
        this.parentArchetypeId = parentArchetypeId;
    }

    /**
     * Identifier of this archetype.
     * cardinality: 1..1
     */
    public ArchetypeHrid getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(ArchetypeHrid value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:archetypeId failed, it has cardinality NonNull, but is null");
        }
        this.archetypeId = archetypeId;
    }

    /**
     * Flag indicating whether this archetype is differential or flat in its contents.
     * Top-level source archetypes have this flag set to True.
     * cardinality: 1..1
     */
    public Boolean getIsDifferential() {
        return isDifferential;
    }

    public void setIsDifferential(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isDifferential failed, it has cardinality NonNull, but is null");
        }
        this.isDifferential = isDifferential;
    }

    /**
     * Root node of the definition of this archetype.
     * cardinality: 1..1
     */
    public CComplexObject getDefinition() {
        return definition;
    }

    public void setDefinition(CComplexObject value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:definition failed, it has cardinality NonNull, but is null");
        }
        this.definition = definition;
    }

    /**
     * The terminology of the archetype.
     * cardinality: 1..1
     */
    public ArchetypeTerminology getTerminology() {
        return terminology;
    }

    public void setTerminology(ArchetypeTerminology value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:terminology failed, it has cardinality NonNull, but is null");
        }
        this.terminology = terminology;
    }

    /**
     * Rules relating to this archetype.
     * Statements are expressed in first order predicate logic, and usually refer to at least two attributes.
     * cardinality: 0..1
     */

    public void addToRule(BmmAssertion value) {
        if (rules == null) {
            rules = new ArrayList<>();
        }
        rules.add(value);
    }

    public void addToRules(List<BmmAssertion> values) {
        values.forEach(value -> addToRule(value));
    }

    public void removeFromRule(BmmAssertion item) {
        if (rules != null) {
            rules.remove(item);
        }
    }

    public void removeFromRules(Collection<BmmAssertion> values) {
        values.forEach(this::removeFromRule);
    }

    List<BmmAssertion> getRules() {
        return this.rules;
    }

    public Archetype setRules(List<BmmAssertion> rules) {
        this.rules = rules;
        return this;
    }

    public List<BmmAssertion> rules() {
        return Collections.unmodifiableList(this.rules);
    }

    /**
     * cardinality: 0..1
     */
    public RmOverlay getRmOverlay() {
        return rmOverlay;
    }

    public void setRmOverlay(RmOverlay value) {
        this.rmOverlay = rmOverlay;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * The concept code of the root object of the archetype, also standing for the concept of the archetype as a whole.
 * cardinality: 1..1
 *
 */
    public Result.is_equal(definition.node_id)

    conceptCode() {
        Result.is_equal(definition.node_id) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Set of language-independent paths extracted from archetype.
     * Paths obey Xpath-like syntax and are formed from alternations of C_OBJECT.node_id and C_ATTRIBUTE.rm_attribute_name values.
     * cardinality: 1..1
     */
    public List<String> physicalPaths() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Set of language-dependent paths extracted from archetype.
     * Paths obey the same syntax as physical_paths, but with node_ids replaced by their meanings from the terminology.
     * cardinality: 1..1
     */
    public List<String> logicalPaths(String lang) {
        if (lang == null) {
            throw new NullPointerException("Parameter lang has cardinality NonNull, but is null.");
        }
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

/**
 *
 * Specialisation depth of this archetype; larger than 0 if this archetype has a parent.
 * Derived from terminology.specialisation_depth.
 * cardinality: 1..1
 *
 */
    public Result =

    terminology.specialisation_depth specialisationDepth() {
        Result = terminology.specialisation_depth result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this archetype is a specialisation of another.
     * cardinality: 1..1
     */
    public Result implies
    parent_archetype_hrid /=

    Void isSpecialised() {
        Result implies parent_archetype_hrid /= Void result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Archetype *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Archetype() {
    }

    protected Archetype(
            String parentArchetypeId,
            ArchetypeHrid archetypeId,
            Boolean isDifferential,
            CComplexObject definition,
            ArchetypeTerminology terminology,
            List<bmmAssertion> rules,
            RmOverlay rmOverlay
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
        this.parentArchetypeId = parentArchetypeId;
        this.archetypeId = archetypeId;
        this.isDifferential = isDifferential;
        this.definition = definition;
        this.terminology = terminology;
        this.rules = rules;
        this.rmOverlay = rmOverlay;
    }


    //***** Archetype *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Archetype that = (Archetype) object;
        return
                Objects.equals(parentArchetypeId, that.parentArchetypeId) &&
                        Objects.equals(archetypeId, that.archetypeId) &&
                        Objects.equals(isDifferential, that.isDifferential) &&
                        Objects.equals(definition, that.definition) &&
                        Objects.equals(terminology, that.terminology) &&
                        Objects.equals(rules, that.rules) &&
                        Objects.equals(rmOverlay, that.rmOverlay);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                parentArchetypeId,
                archetypeId,
                isDifferential,
                definition,
                terminology,
                rules,
                rmOverlay
        );
    }

    @Override
    public String toString() {
        return
                "Archetype {" +
                        "parentArchetypeId='" + parentArchetypeId + '\'' +
                        "archetypeId='" + archetypeId + '\'' +
                        "isDifferential='" + isDifferential + '\'' +
                        "definition='" + definition + '\'' +
                        "terminology='" + terminology + '\'' +
                        "rules='" + rules + '\'' +
                        "rmOverlay='" + rmOverlay + '\'' +
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
