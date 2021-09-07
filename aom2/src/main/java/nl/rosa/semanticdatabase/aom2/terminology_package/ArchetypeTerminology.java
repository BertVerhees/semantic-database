package nl.rosa.semanticdatabase.aom2.terminology_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.aom2.the_archetype_package.Archetype;
import semanticdatabase.base.foundation_types.primitive_types.Integer;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Local terminology of an archetype.
 * This class defines the semantics of the terminology of an archetype.
 */
public class ArchetypeTerminology {

    //***** ArchetypeTerminology *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * True if this terminology only contains terms relating to a differential specialisation of the owning artefact, rather than a complete set.
     * cardinality: 1..1
     */
    private Boolean isDifferential;

    /**
     * Original language of the terminology, as set at artefact creation or parsing time; must be a code in the ISO 639-1 2 character language code-set.
     * cardinality: 1..1
     */
    private String originalLanguage;

    /**
     * Term code defining the meaning of the artefact as a whole, and always used as the id-code on the root node of the artefact.
     * Must be defined in the term_definitions property.
     * cardinality: 1..1
     */
    private String conceptCode;

    /**
     * Directory of term definitions as a two-level table.
     * The outer hash keys are language codes, e.g.
     * "en", "de", while the inner hash keys are term codes, e.g.
     * "id17", "at4".
     * cardinality: 1..1
     */
    private Map<String, Hash<>> termDefinitions = new HashMap<>();

    /**
     * Directory of bindings to external terminology codes and value sets, as a two-level table.
     * The outer hash keys are terminology ids, e.g.
     * "SNOMED_CT", and the inner hash keys are constraint codes, e.g.
     * "at4", "ac13" or paths.
     * The indexed Uri objects represent references to externally defined resources, either terms, ontology concepts, or terminology subsets / ref-sets.
     * cardinality: 0..1
     */
    private Map<String, Hash<>> termBindings;

    /**
     * Archetype that owns this terminology.
     * cardinality: 1..1
     */
    private Archetype ownerArchetype;

    /**
     * Archetype-local value sets, each keyed by value-set id, i.e.
     * an ac-code.
     * cardinality: 0..1
     */
    private Map<String, ValueSet> valueSets;

    /**
     * Directory of extracts of external terminologies, as a two-level table.
     * The outer hash keys are terminology ids, e.g.
     * "SNOMED_CT", while the inner hash keys are term codes or code-phrases from the relevant terminology, e.g.
     * "10094842".
     * cardinality: 0..1
     */
    private Map<String, Hash<>> terminologyExtracts;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * True if this terminology only contains terms relating to a differential specialisation of the owning artefact, rather than a complete set.
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
     * Original language of the terminology, as set at artefact creation or parsing time; must be a code in the ISO 639-1 2 character language code-set.
     * cardinality: 1..1
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:originalLanguage failed, it has cardinality NonNull, but is null");
        }
        this.originalLanguage = originalLanguage;
    }

    /**
     * Term code defining the meaning of the artefact as a whole, and always used as the id-code on the root node of the artefact.
     * Must be defined in the term_definitions property.
     * cardinality: 1..1
     */
    public String getConceptCode() {
        return conceptCode;
    }

    public void setConceptCode(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:conceptCode failed, it has cardinality NonNull, but is null");
        }
        this.conceptCode = conceptCode;
    }

    /**
     * Directory of term definitions as a two-level table.
     * The outer hash keys are language codes, e.g.
     * "en", "de", while the inner hash keys are term codes, e.g.
     * "id17", "at4".
     * cardinality: 1..1
     */

    public void putTermDefinition(String key, Map<> value) {
        termDefinitions.put(key, value);
    }

    public void putTermDefinitions(Map<String, Hash<>> items) {
        items.keySet().forEach(key -> putTermdefinition(key, items.get(key)));
    }

    public Map<> getTermDefinition(String key) {
        return termDefinitions.get(key);
    }

    public void removeTermDefinition(String key) {
        if (termDefinitions != null) {
            termDefinitions.remove(key);
        }
    }

    public void removeTermDefinitions(Collection<String> keys) {
        keys.forEach(this::removeTermDefinition);
    }

    public Map<String, Map<>> getTermDefinitions() {
        return this.termDefinitions;
    }

    public ArchetypeTerminology setTermDefinitions(Map<String, Map<>> termDefinitions) {
        if (termDefinitions == null) {
            throw new NullPointerException(" termDefinitions has cardinality NonNull, but is null");
        }
        this.termDefinitions = termDefinitions;
        return this;
    }

    public Map<String, Map<>> termDefinitions() {
        return Collections.unmodifiableMap(this.termDefinitions);
    }

    /**
     * Directory of bindings to external terminology codes and value sets, as a two-level table.
     * The outer hash keys are terminology ids, e.g.
     * "SNOMED_CT", and the inner hash keys are constraint codes, e.g.
     * "at4", "ac13" or paths.
     * The indexed Uri objects represent references to externally defined resources, either terms, ontology concepts, or terminology subsets / ref-sets.
     * cardinality: 0..1
     */

    public void putTermBinding(String key, Map<> value) {
        if (termBindings == null) {
            termBindings = new HashMap<>();
        }
        termBindings.put(key, value);
    }

    public void putTermBindings(Map<String, Hash<>> items) {
        items.keySet().forEach(key -> putTermbinding(key, items.get(key)));
    }

    public Map<> getTermBinding(String key) {
        if (termBindings == null) {
            return null;
        }
        return termBindings.get(key);
    }

    public void removeTermBinding(String key) {
        if (termBindings != null) {
            termBindings.remove(key);
        }
    }

    public void removeTermBindings(Collection<String> keys) {
        keys.forEach(this::removeTermBinding);
    }

    public Map<String, Map<>> getTermBindings() {
        return this.termBindings;
    }

    public ArchetypeTerminology setTermBindings(Map<String, Map<>> termBindings) {
        this.termBindings = termBindings;
        return this;
    }

    public Map<String, Map<>> termBindings() {
        return Collections.unmodifiableMap(this.termBindings);
    }

    /**
     * Archetype that owns this terminology.
     * cardinality: 1..1
     */
    public Archetype getOwnerArchetype() {
        return ownerArchetype;
    }

    public void setOwnerArchetype(Archetype value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:ownerArchetype failed, it has cardinality NonNull, but is null");
        }
        this.ownerArchetype = ownerArchetype;
    }

    /**
     * Archetype-local value sets, each keyed by value-set id, i.e.
     * an ac-code.
     * cardinality: 0..1
     */

    public void putValueSet(String key, ValueSet value) {
        if (valueSets == null) {
            valueSets = new HashMap<>();
        }
        valueSets.put(key, value);
    }

    public void putValueSets(Map<String, ValueSet> items) {
        items.keySet().forEach(key -> putValueset(key, items.get(key)));
    }

    public ValueSet getValueSet(String key) {
        if (valueSets == null) {
            return null;
        }
        return valueSets.get(key);
    }

    public void removeValueSet(String key) {
        if (valueSets != null) {
            valueSets.remove(key);
        }
    }

    public void removeValueSets(Collection<String> keys) {
        keys.forEach(this::removeValueSet);
    }

    public Map<String, ValueSet> getValueSets() {
        return this.valueSets;
    }

    public ArchetypeTerminology setValueSets(Map<String, ValueSet> valueSets) {
        this.valueSets = valueSets;
        return this;
    }

    public Map<String, ValueSet> valueSets() {
        return Collections.unmodifiableMap(this.valueSets);
    }

    /**
     * Directory of extracts of external terminologies, as a two-level table.
     * The outer hash keys are terminology ids, e.g.
     * "SNOMED_CT", while the inner hash keys are term codes or code-phrases from the relevant terminology, e.g.
     * "10094842".
     * cardinality: 0..1
     */

    public void putTerminologyExtract(String key, Map<> value) {
        if (terminologyExtracts == null) {
            terminologyExtracts = new HashMap<>();
        }
        terminologyExtracts.put(key, value);
    }

    public void putTerminologyExtracts(Map<String, Hash<>> items) {
        items.keySet().forEach(key -> putTerminologyextract(key, items.get(key)));
    }

    public Map<> getTerminologyExtract(String key) {
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

    public Map<String, Map<>> getTerminologyExtracts() {
        return this.terminologyExtracts;
    }

    public ArchetypeTerminology setTerminologyExtracts(Map<String, Map<>> terminologyExtracts) {
        this.terminologyExtracts = terminologyExtracts;
        return this;
    }

    public Map<String, Map<>> terminologyExtracts() {
        return Collections.unmodifiableMap(this.terminologyExtracts);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Specialisation depth of this artefact.
     * Unspecialised artefacts have depth 0, with each additional level of specialisation adding 1 to the specialisation_depth.
     * cardinality: 1..1
     */
    public Integer specialisationDepth() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * List of all id codes in the terminology., i.e.
     * the 'id' codes in an ADL archetype, which are the node_id values on C_OBJECT descendants.
     * cardinality: 1..1
     */
    public List<String> idCodes() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * List of all value term codes in the terminology, i.e.
     * the 'at' codes in an ADL archetype, which are used as possible values on terminological constrainer nodes.
     * cardinality: 0..1
     */
    public List<String> valueCodes() {
        List<String> result = null;


        return result;
    }

    /**
     * List of all value set codes in the terminology defining value sets.
     * These correspond to the 'ac' codes in an ADL archetype.
     * cardinality: 0..1
     */
    public List<String> valueSetCodes() {
        List<String> result = null;


        return result;
    }

    /**
     * True if language a_lang is present in archetype terminology.
     * cardinality: 1..1
     */
    public Boolean hasLanguage(String a_lang) {
        if (a_lang == null) {
            throw new NullPointerException("Parameter a_lang has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if there are bindings to terminology a_terminology_id present.
     * True if terminology `a_terminology' is present in archetype ontology.
     * cardinality: 1..1
     */
    public Boolean hasTerminology(String a_terminology_id) {
        if (a_terminology_id == null) {
            throw new NullPointerException("Parameter a_terminology_id has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if code a_code defined in this terminology.
     * cardinality: 1..1
     */
    public Boolean hasTermCode(String a_code) {
        if (a_code == null) {
            throw new NullPointerException("Parameter a_code has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

/**
 *
 * Term definition for a code, in a specified language.
 * cardinality: 1..1
 *
 */
    public has_term-

    definition(a_lang, a_code)  termDefinition(
    String a_lang, String
    a_code)

    {
        if (a_lang == null) {
            throw new NullPointerException("Parameter a_lang has cardinality NonNull, but is null.");
        }
        if (a_code == null) {
            throw new NullPointerException("Parameter a_code has cardinality NonNull, but is null.");
        }
        has_term - definition(a_lang, a_code) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Binding of constraint corresponding to a_code in target external terminology a_terminology_id, as a string, which is usually a formal query expression.
     * cardinality: 1..1
     */
    public has_term_binding(a_terminology_id, a_code)  termBinding(
    String a_terminology, String
    a_code)

    {
        if (a_terminology == null) {
            throw new NullPointerException("Parameter a_terminology has cardinality NonNull, but is null.");
        }
        if (a_code == null) {
            throw new NullPointerException("Parameter a_code has cardinality NonNull, but is null.");
        }
        has_term_binding(a_terminology_id, a_code) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * List of terminologies to which term or constraint bindings exist in this terminology, computed from bindings.
     * cardinality: 1..1
     */
    public List<String> terminologiesAvailable() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return an ARCHETYPE_TERM from specified terminology extract, for specified term code.
     * cardinality: 1..1
     */
    public has_terminology_extract(a_terminology_id) and has_terminology_extract_code (a_code)

    terminologyExtractTerm(String a_terminology_id, String a_code) {
        if (a_terminology_id == null) {
            throw new NullPointerException("Parameter a_terminology_id has cardinality NonNull, but is null.");
        }
        if (a_code == null) {
            throw new NullPointerException("Parameter a_code has cardinality NonNull, but is null.");
        }
        has_terminology_extract(a_terminology_id) and has_terminology_extract_code (a_code) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if there is a provided terminology extract present.
     * cardinality: 1..1
     */
    public Boolean hasTerminologyExtract(String a_terminology_id) {
        if (a_terminology_id == null) {
            throw new NullPointerException("Parameter a_terminology_id has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * List of languages in which terms in this terminology are available.
     * cardinality: 1..1
     */
    public List<String> languagesAvailable() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ArchetypeTerminology *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ArchetypeTerminology() {
    }

    public ArchetypeTerminology(
            Boolean isDifferential,
            String originalLanguage,
            String conceptCode,
            Map<string, hash<>, archetypeTerm> termDefinitions,
            Map<string, hash<>, uri> termBindings,
            Archetype ownerArchetype,
            Map<string, valueSet> valueSets,
            Map<string, hash<>, archetypeTerm> terminologyExtracts
    ) {
        if (isDifferential == null) {
            throw new NullPointerException("Property:isDifferential has cardinality NonNull, but is null");
        }
        if (originalLanguage == null) {
            throw new NullPointerException("Property:originalLanguage has cardinality NonNull, but is null");
        }
        if (conceptCode == null) {
            throw new NullPointerException("Property:conceptCode has cardinality NonNull, but is null");
        }
        if (termDefinitions == null) {
            throw new NullPointerException("Property:termDefinitions has cardinality NonNull, but is null");
        }
        if (ownerArchetype == null) {
            throw new NullPointerException("Property:ownerArchetype has cardinality NonNull, but is null");
        }
        this.isDifferential = isDifferential;
        this.originalLanguage = originalLanguage;
        this.conceptCode = conceptCode;
        this.termDefinitions = termDefinitions;
        this.termBindings = termBindings;
        this.ownerArchetype = ownerArchetype;
        this.valueSets = valueSets;
        this.terminologyExtracts = terminologyExtracts;
    }

    private ArchetypeTerminology(Builder builder) {
        this.setIsDifferential(builder.isDifferential);
        this.setOriginalLanguage(builder.originalLanguage);
        this.setConceptCode(builder.conceptCode);
        this.setTermDefinitions(builder.termDefinitions);
        this.setTermBindings(builder.termBindings);
        this.setOwnerArchetype(builder.ownerArchetype);
        this.setValueSets(builder.valueSets);
        this.setTerminologyExtracts(builder.terminologyExtracts);
    }

    public static class Builder {
        private final Boolean isDifferential;  //required
        private final String originalLanguage;  //required
        private final String conceptCode;  //required
        private final Map<string, hash<>, archetypeTerm> termDefinitions;  //required
        private Map<string, hash<>, uri> termBindings;
        private final Archetype ownerArchetype;  //required
        private Map<string, valueSet> valueSets;
        private Map<string, hash<>, archetypeTerm> terminologyExtracts;

        public Builder(
                Boolean isDifferential,
                String originalLanguage,
                String conceptCode,
                Map<string, hash<>, archetypeTerm> termDefinitions,
                Archetype ownerArchetype
        ) {
            if (isDifferential == null) {
                throw new NullPointerException("Property:isDifferential has cardinality NonNull, but is null");
            }
            if (originalLanguage == null) {
                throw new NullPointerException("Property:originalLanguage has cardinality NonNull, but is null");
            }
            if (conceptCode == null) {
                throw new NullPointerException("Property:conceptCode has cardinality NonNull, but is null");
            }
            if (termDefinitions == null) {
                throw new NullPointerException("Property:termDefinitions has cardinality NonNull, but is null");
            }
            if (ownerArchetype == null) {
                throw new NullPointerException("Property:ownerArchetype has cardinality NonNull, but is null");
            }
            this.isDifferential = isDifferential;
            this.originalLanguage = originalLanguage;
            this.conceptCode = conceptCode;
            this.termDefinitions = termDefinitions;
            this.ownerArchetype = ownerArchetype;
        }

        public Builder setTermBindings(Map<string, hash<>, uri> value) {
            this.termBindings = termBindings;
            return this;
        }

        public Builder setValueSets(Map<string, valueSet> value) {
            this.valueSets = valueSets;
            return this;
        }

        public Builder setTerminologyExtracts(Map<string, hash<>, archetypeTerm> value) {
            this.terminologyExtracts = terminologyExtracts;
            return this;
        }

        public ArchetypeTerminology build() {
            return new ArchetypeTerminology(this);
        }
    }


    //***** ArchetypeTerminology *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeTerminology that = (ArchetypeTerminology) object;
        return
                Objects.equals(isDifferential, that.isDifferential) &&
                        Objects.equals(originalLanguage, that.originalLanguage) &&
                        Objects.equals(conceptCode, that.conceptCode) &&
                        Objects.equals(termDefinitions, that.termDefinitions) &&
                        Objects.equals(termBindings, that.termBindings) &&
                        Objects.equals(ownerArchetype, that.ownerArchetype) &&
                        Objects.equals(valueSets, that.valueSets) &&
                        Objects.equals(terminologyExtracts, that.terminologyExtracts);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                isDifferential,
                originalLanguage,
                conceptCode,
                termDefinitions,
                termBindings,
                ownerArchetype,
                valueSets,
                terminologyExtracts
        );
    }

    @Override
    public java.lang.String toString() {
        return
                "ArchetypeTerminology {" +
                        "isDifferential='" + isDifferential + '\'' +
                        "originalLanguage='" + originalLanguage + '\'' +
                        "conceptCode='" + conceptCode + '\'' +
                        "termDefinitions='" + termDefinitions + '\'' +
                        "termBindings='" + termBindings + '\'' +
                        "ownerArchetype='" + ownerArchetype + '\'' +
                        "valueSets='" + valueSets + '\'' +
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
