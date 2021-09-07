package nl.rosa.semanticdatabase.aom2.terminology_package;
/**
 * 7.
 * Terminology Package
 * 7.1.
 * Overview
 * All local terminology as well as terminological and terminology binding elements of an archetype are represented in the terminology section of an archetype, whose semantics are defined by the aom2.terminology package, shown below.An archetype terminology consists of the following elements.Depending on whether the archetype is in differential or flat form, an instance of the ARCHETYPE_TERMINOLOGY class contains terms, constraints, bindings and terminology extracts that were respectively either introduced in the owning archetype, or all codes and bindings obtained by compressing an archetype lineage through inheritance.
 * A typical instance structure of ARCHETYPE_TERMINOLOGY is illustrated in Figure 25.
 * <p>
 * <p>
 * <p>
 * Figure 24.
 * am.aom2.terminology Package
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 25.
 * Terminology Instance Structure
 * 7.2.
 * Semantics
 * <p>
 * 7.2.1.
 * Specialisation Depth
 * Any given archetype occurs at some point in a lineage of archetypes related by specialisation, where the depth is reflected by the specialisation_depth function.
 * An archetype which is not a specialisation of another has a specialisation_depth of 0.
 * Term and constraint codes introduced in the terminology of specialised archetypes (i.e.
 * which did not exist in the terminology of the parent archetype) are defined in a strict way, using '.' (period) markers.
 * For example, an archetype of specialisation depth 2 will use term definition codes like the following: id0.0.1 - a new term introduced in this archetype, which is not a specialisation of any previous term in any of the parent archetypes; id4.0.1 - a term which specialises the id4 term from the top parent.
 * An intervening .0 is required to show that the new term is at depth 2, not depth 1; id25.1.1 - a term which specialises the term id25.1 from the immediate parent, which itself specialises the term id25 from the top parent.
 * This systematic definition of codes enables software to use the structure of the codes to more quickly and accurately make inferences about term definitions up and down specialisation hierarchies.
 * Constraint codes on the other hand do not follow these rules, and exist in a flat code space instead.
 * 7.3.
 * Class Descriptions
 * <p>
 * 7.3.1.
 * ARCHETYPE_TERMINOLOGY Class
 * <p>
 * 7.3.2.
 * TERMINOLOGY_RELATION Class
 * <p>
 * 7.3.3.
 * VALUE_SET Class
 * <p>
 * 7.3.4.
 * ARCHETYPE_TERM Class
 * 7.3.4.1.
 * Validity Rules The following validity rules apply to instances of this class in an archetype: VTVSID: value-set id defined.
 * The identifying code of a value set must be defined in the term definitions of the terminology of the current archetype.
 * VTVSMD: value-set members defined.
 * The member codes of a value set must be defined in the term definitions of the terminology of the flattened form of the current archetype.
 * VTVSUQ: value-set members unique.
 * The member codes of a value set must be unique within the value set.
 * VTSD specialisation level of codes.
 * Term or constraint code defined in archetype terminology must be of the same specialisation level as the archetype (differential archetypes), or the same or a less specialised level (flat archetypes).
 * VTLC: language consistency.
 * Languages consistent: all term codes and constraint codes exist in all languages.
 * VTTBK: terminology term binding key valid.
 * Every term binding must be to either a defined archetype term ('at-code') or to a path that is valid in the flat archetype.
 * VTCBK: terminology constraint binding key valid.
 * Every constraint binding must be to a defined archetype constraint code ('ac-code').
 */
