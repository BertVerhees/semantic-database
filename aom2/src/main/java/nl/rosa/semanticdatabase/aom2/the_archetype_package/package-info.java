package nl.rosa.semanticdatabase.aom2.the_archetype_package;
/**
 * 3.
 * The Archetype Package
 * 3.1.
 * Overview
 * The top-level model of archetypes and templates (all variant forms) is illustrated in the Figure below.
 * The model defines a standard structural representation of an archetype.
 * Archetypes authored as independent entities are instances of the class AUTHORED_ARCHETYPE which is a descendant of AUTHORED_RESOURCE and ARCHETYPE.
 * The first of the two parent classes provides a standardised model of descriptive meta-data, language information, and annotations for any resource, and is documented in the openEHR Resource Model.
 * The resource classes are shown included in the diagram below.
 * The second parent class defines the core structure of any kind of archetype, including definition, terminology, optional rules part, along with a 'semantic identifier' (ARCHETYPE.archetype_id).The AUTHORED_ARCHETYPE class adds identifying attributes, flags and descriptive meta-data, and is the ancestor type for two further specialisations - TEMPLATE and OPERATIONAL_TEMPLATE .
 * The TEMPLATE class defines the notion of a 'templated' archetype, i.e.
 * an archetype containing fillers/references (ADL’s use_archetype statements), typically designed to represent a data set.
 * To enable this, it may contain 'overlays', private archetypes that specialise one or more of the referenced / filler archetypes it uses.
 * Overlays are instances of the TEMPLATE_OVERLAY class, have no meta-data of their own, but are otherwise computationally just like any other archetype.The OPERATIONAL_TEMPLATE class represents the fully flattened form of a template, i.e.
 * with all fillers and references substituted and overlays processed, to form what is in practical terms, a single custom-made 'operational' artefact, ready for transformation to downstream artefacts.
 * Because an operational template includes one or more other archetype structures inline, it also includes their terminologies, enabling it to be treated as a self-standing artefact.
 * <p>
 * <p>
 * <p>
 * Figure 6.
 * am.aom2.archetype Package
 * <p>
 * <p>
 * <p>
 * <p>
 * 3.2.
 * Archetype Identification
 * <p>
 * 3.2.1.
 * Human-Readable Identifier (HRID)
 * All archetype variants based on ARCHETYPE have a human-readable, structured identifier defined by the ARCHETYPE_HRID class.
 * This identifier places the artefact in a multi-dimensional space based on a namespace, its reference model class and its informational concept.
 * This class defines an atomised representation of the identifier, enabling variant forms to be used as needed.
 * Its various parts can be understood from the following diagram, which also shows the computed semantic_id and physical_id forms.
 * Figure 7.
 * Archetype HRID Structure For specialised archetypes, the parent_archetype_id is also required.
 * This is a string reference to an archetype, and is normally the 'interface' form of the id, i.e.
 * down to the major version only.
 * In some circumstances, it is useful to include the minor and patch version numbers as well.
 * An important aspect of identification relates to the rules governing when when the HRID namespace changes or is retained, with respect to when 'moves' or 'forks' occur.
 * Its value is always the same as one of the original_namespace and custodian_namespace properties inherited from AUTHORED_RESOURCE.description (or both, in the case where they are the same).
 * A full explanation of the identification system and rules is given in the openEHR Archetype Identification specification.
 * 3.2.2.
 * Machine Identifiers
 * Two machine identifiers are defined for archetypes.
 * The ARCHETYPE.uid attribute defines a machine identifier equivalent to the human readable ARCHETYPE.archetype_id.semantic_id , i.e.
 * ARCHETYPE_HRID up to its major version, and changes whenever the latter does.
 * It is defined as optional but to be practically useful would need to be mandatory for all archetypes within a custodian organisation where this identifier was in use.
 * It could in principle be synthesised at any time for a custodian that decided to implement it.
 * The ARCHETYPE.build_uid attribute is also optional, and if used, is intended to provide a unique identifier that corresponds to any change in version of the artefact.
 * At a minimum, this means generating a new UUID for each change to: ARCHETYPE.archetype_id.release_version; ARCHETYPE.archetype_id.build_count; ARCHETYPE.description.lifecycle_state.
 * For every change made to an archetype inside a controlled repository (for example, addition or update of meta-data fields), this field should be updated with a new UUID value, generated in the normal way.
 * 3.3.
 * Top-level Meta-data
 * The following items correspond to syntax elements that may appear in parentheses in the first line of an ADL archetype.
 * <p>
 * <p>
 * 3.3.1.
 * ADL Version
 * The ARCHETYPE.adl_version attribute in ADL 1.4 was used to indicate the ADL release used in the archetype source file from which the AOM structure was created (the version number comes from the amendment record of the ADL2 specification.
 * In the current and future AOM and ADL specifications, the meaning of this attribute is generalised to mean 'the version of the archetype formalism' in which the current archetype is expressed.
 * For reasons of convenience, the version number is still taken from the ADL specification, but now refers to all archetype-related specifications together, since they are always updated in a synchronised fashion.
 * 3.3.2.
 * Reference Model Release
 * The ARCHETYPE.rm_release attribute designates the release of the reference model on which the archetype is based, in the archetype’s current version.
 * This means rm_release can change with new versions of the archetype, where re-versioning includes upgrading the archetype to a later RM release.
 * However, such upgrading still has to obey the basic rule of archetype compatibility: later minor, patch versions and builds cannot create data that is not valid with respect to the prior version.
 * This should be in the same semver.org 3-part form as the ARCHETYPE_HRID.release_version property, e.g.
 * "1.0.2".
 * This property does not indicate conformance to any particular reference model version(s) other than the named one, since most archetypes can easily conform to more than one.
 * More minimal archetypes are likely to technically conform to more old and future releases than more complex archetypes.
 * 3.3.3.
 * Generated Flag
 * The ARCHETYPE.is_generated flag is used to indicate that an archetype has been machine-generated from another artefact, e.g.
 * an older ADL version (say 1.4), or a non-archetype artefact.
 * If true, it indicates to tools that the current archetype can potentially be overwritten, and that some other artefact is considered the primary source.
 * If manual authoring occurs, this attribute should be set to False.
 * 3.4.
 * Governance Meta-data
 * Various meta-data elements are inherited from the AUTHORED_RESOURCE class, and provide the natural language description of the archetype, authoring and translation details, use, misuse, keywords and so on.
 * There are three distinct parts of the meta-data: governance, authorship, and descriptive details.
 * <p>
 * <p>
 * 3.4.1.
 * Governance Meta-data Items
 * Governance meta-data is visible primarily in the RESOURCE_DESCRIPTION class, inherited via AUTHORED_RESOURCE, and consists of items relating to management and intellectual property status of the artefact.
 * A typical form of these is shown in the screenshot in Figure 8.
 * Figure 8.
 * Governance Meta-data 3.4.1.1.
 * Package The optional resource_package_uri property enables the recording of a reference to a package of archetypes or other resources, to which this archetype is considered to below.
 * Its value may be in the form of "text <URL>".
 * 3.4.1.2.
 * Lifecycle_state The description.lifecycle_state is an important property of an archetype, which is used to record its state in a defined lifecycle.
 * The lifecycle state machine and versioning rules are explained fully in the openEHR Archetype Identification specification.
 * Here we simply note that the value of the property is a coded term corresponding to one of the macro-state names on the diagram, i.e.
 * 'unmanaged', 'in_development', and so on.
 * 3.4.1.3.
 * Original_namespace and Original_publisher These two optional properties indicate the original publishing organisation, and its namespace, i.e.
 * the original publishing environment where the artefact was first imported or created.
 * The original_namespace property is normally the same value as archetype_id.namespace,unless the artefact has been forked into its current custodian, in which case archetype_id.namespace will be the same as custodian_namespace.
 * 3.4.1.4.
 * Custodian_namespace and Custodian_organisation These two optional properties state a formal namespace, and a human-readable organisation identifier corresponding to the current custodian, i.e.
 * maintainer and publisherof the artefact, if there is one.
 * 3.4.1.5.
 * Intellectual Property Items There are three properties in the class that RESOURCE_DESCRIPTION relate to intellectual property (IP).
 * Licence is a String field for recording of the licence (US: 'license') under which the artefact can be used.
 * The recommended format is as follows: licence name <reliable URL to licence statement> The copyright property records the copyright applying to the artefact, and is normally in the standard form '(c) name' or '(c) year name'.
 * The special character © may also be used (UTF-8 0xC2A9).
 * 3.4.2.
 * Authorship Meta-data
 * Authorship meta-data consists of items such as author name, contributors, and translator information, and is visualised in the figure below.
 * Figure 9.
 * Authoring Meta-data 3.4.2.1.
 * Original Author The RESOURCE_DESCRIPTION.original_author property defines a simple list of name/value pairs via which the original author can be documented.
 * Typical key values include "name", "organi[zs]ation", "email" and `"date"`".
 * 3.4.2.2.
 * Contributors The RESOURCE_DESCRIPTION.other_contributors property is a simple list of strings, one for each contributor.
 * The recommended format of the string is one of: first names last name, organisation first names last name, organisation <contributor email address> first names last name, organisation <organisation email address> 3.4.2.3.
 * Languages and Translation The AUTHORED_RESOURCE.original_language and TRANSLATION_DETAILS class enable the original language of authoring and information relating to subsequent translations to be expressed.
 * TRANSLATION_DETAILS.author allows each translator to be represented in the same way as the original_author , i.e.
 * a list of name/values.
 * 3.4.2.4.
 * Version_last_translated The version_last_translated property is used to record a copy of the archetype_id.physical_id for each language, when the translation was carried out.
 * This enables maintainers to know when new translations are needed for some or all languages.
 * This String property records the full version identifier (i.e.
 * ARCHETYPE.archetype_id.version_id) at the time of last translation, enabling tools to determine if and when translations may be out of date.
 * 3.4.3.
 * Descriptive Meta-data
 * Various descriptive meta-data may be provided for an archetype in multiple translations in the RESOURCE_DESCRIPTION_ITEM class, using one instance for each translation language, as shown in the figure below.
 * Figure 10.
 * Descriptive Meta-data 3.4.3.1.
 * Purpose The purpose item is a String property for recording the intended design concept of the artefact.
 * 3.4.3.2.
 * Use and Misuse The use and misuse properties enable specific uses and misuses to be documented.
 * The latter normally relate to common errors of use, or apparently reasonable but wrong assumptions about use.
 * 3.4.3.3.
 * Keywords The keywords property is a list of Strings designed to record search keywords for the artefact.
 * 3.4.3.4.
 * Resources The original_resource_uri property is used to record one or more references to resources in each particular language.
 * TBD: This property does not appear to have ever been used, and it may not be useful, since 'resources' are not typically available for each language.
 * 3.5.
 * Structural Definition
 * <p>
 * 3.5.1.
 * Common Structural Parts
 * The archetype definition is the main definitional part of an archetype and is an instance of a C_COMPLEX_OBJECT .
 * This means that the root of the constraint structure of an archetype always takes the form of a constraint on a non-primitive object type.
 * The terminology section of an archetype is represented by its own classes, and is what allows archetypes to be natural language- and terminology-neutral.
 * It is described in detail in Section 7.
 * An archetype may include one or more rules.
 * Rules are statements expressed in a subset of predicate logic, which can be used to state constraints on multiple parts of an object.
 * They are not needed to constrain single attributes or objects (since this can be done with an appopriate C_ATTRIBUTE or C_OBJECT ), but are necessary for constraints referring to more than one attribute, such as a constraint that 'systolic pressure should be >= diastolic pressure' in a blood pressure measurement archetype.
 * They can also be used to declare variables, including external data query results, and make other constraints dependent on a variable value, e.g.
 * the gender of the record subject.
 * Lastly, the annotations section, inherited from the AUTHORED_RESOURCE class, can be included as required.
 * This section is of particular relevance to archetypes and templates, and is used to document individual nodes within an archetype or template, and/or nodes in reference model data, that may not be constrained in the archetype, but whose specific use in the archetyped data needs to be documented.
 * In the former case, the annotations are keyed by an archetype path, while in the latter case, by a reference model path.
 * 3.5.2.
 * Structural Variants
 * The model in Figure 6 defines the structures of a number of variants of the 'archetype' idea.
 * All concrete instances are instances of one of the concrete descendants of ARCHETYPE.
 * Figure 11 illustrates the typical object structure of a source archetype - the form of archetype created by an authoring tool - represented by a DIFFERENTIAL_ARCHETYPE instance.
 * Mandatory parts are shown in bold.
 * Figure 11.
 * Source Archetype Structure Source archetypes can be specialised, in which case their definition structure is a partial overlay on the flat parent, or 'top-level', in which case the definition structure is complete.
 * C_ARCHETYPE_ROOT instances may only occur representing direct references to other archetypes - 'external references'.
 * A flat archetype is generated from one or more source archetypes via the flattening process described in the next chapter of this specification, (also in the ADL specification).
 * This generates a FLAT_ARCHETYPE from a DIFFERENTIAL_ARCHETYPE instance.
 * The main two changes that occur in this operation are a) specialised archetype overlays are applied to the flat parent structure, resulting in a full archetype structure, and b) internal references (use_nodes) are replaced by their expanded form, i.e.
 * a copy of the subtrees to which they point.
 * Figure 12.
 * Source Template Structure This form is used to represent the full 'operational' structure of a specialised archetype, and has two uses.
 * The first is to generate backwards compatible ADL 1.4 legacy archetypes (always in flat form); the second is during the template flattening process, when the flat forms of all referenced archetypes and templates are ultimately combined into a single operational template.
 * Figure 12 illustrates the structure of a source template, i.e instances of TEMPLATE.
 * A source template is an archetype containing C_ARCHETYPE_ROOT objects representing slot fillers - each referring to an external archetype or template, or potentially an overlay archetype.
 * Another archetype variant, also shown in Figure 12 is the template overlay, i.e.
 * an instance of TEMPLATE_OVERLAY.
 * These are purely local components of templates, and include only the definition and terminology.
 * The definition structure is always a specialised overlay on something else, and may not contain any slot fillers or external references, i.e.
 * no C_ARCHETYPE_ROOT objects.
 * No identifier, adl_version, languages or description are required, as they are considered to be propagated from the owning root template.
 * Accordingly, template overlays act like a simplified specialised archetype.
 * Template overlays can be thought of as being similar to 'anonymous' or 'inner' classes in some object-oriented programming languages.
 * Figure 13 illustrates the resulting operational template, or compiled form of a template.
 * This is created by building the composition of referenced archetypes and/or templates and/or template overlays, in their flattened form, to generate a single 'giant' archetype.
 * The root node of this archetype, along with every archetype/template root node within, is represented using a C_ARCHETYPE_ROOT object.
 * An operational template also has a component_terminologies property containing the ontologies from every constituent archetype, template and overlay.
 * Figure 13.
 * Operational Template Structure More details of template development, representation and semantics are described in the next section.
 * 3.6.
 * Class Descriptions
 * <p>
 * 3.6.1.
 * ARCHETYPE Class
 * <p>
 * 3.6.2.
 * AUTHORED_ARCHETYPE Class
 * <p>
 * 3.6.3.
 * ARCHETYPE_HRID Class
 * <p>
 * 3.6.4.
 * TEMPLATE Class
 * <p>
 * 3.6.5.
 * TEMPLATE_OVERLAY Class
 * <p>
 * 3.6.6.
 * OPERATIONAL_TEMPLATE Class
 * <p>
 * 3.7.
 * Validity Rules
 * The following validity rules apply to all varieties of ARCHETYPE object:VARAV: ADL version validity.
 * The adl_version top-level meta-data item must exist and consist of a valid 3-part version identifier.VARRV: RM release validity.
 * The rm_release top-level meta-data item must exist and consist of a valid 3-part version identifier.VARCN: archetype concept validity.
 * The node_id of the root object of the archetype must be of the form id1{.1}*, where the number of .1 components equals the specalisation depth, and must be defined in the terminology.VATDF: value code validity.
 * Each value code (at-code) used in a term constraint in the archetype definition must be defined in the term_definitions part of the terminology of the flattened form of the current archetype.VACDF: constraint code validity.
 * Each value set code (ac-code) used in a term constraint in the archetype definition must be defined in the term_definitions part of the terminology of the current archetype.VATDA: value set assumed value code validity.
 * Each value code (at-code) used as an assumed_value for a value set in a term constraint in the archetype definition must exist in the value set definition in the terminology for the identified value set.VETDF: external term validity.
 * Each external term used within the archetype definition must exist in the relevant terminology (subject to tool accesibility; codes for inaccessible terminologies should be flagged with a warning indicating that no verification was possible).VOTM: terminology translations validity.
 * Translations must exist for term_definitions and constraint_definitions sections for all languages defined in the description / translations sections.VOKU: object key unique.
 * Within any keyed list in an archetype, including the desription, terminology, and annotations sections, each item must have a unique key with respect to its siblings.VARDT: archetype definition typename validity.
 * The typename mentioned in the outer block of the archetype definition section must match the type mentioned in the first segment of the archetype id.VRANP: annotation path valid.
 * Each path mentioned in an annotation within the annotations section must either be a valid archetype path, or a 'reference model' path, i.e.
 * a path that is valid for the root class of the archetype.VRRLP: rule path valid.
 * Each path mentioned in a rule in the rules section must be found within the archetype, or be an RM-valid extension of a path found within the archetype.The following validity rules apply to instances of ARCHETYPE and subtypes other than TEMPLATE_OVERLAY:VARID: archetype identifier validity.
 * The archetype must have an identifier that conforms to the openEHR specification for archetype identifiers.VDEOL: original language specified.
 * An original_language section containing the meta-data of the original authoring language must exist.VARD: description specified.
 * A description section containing the main meta-data of the archetype must exist.The following rules apply to specialised archetypes, for which ARCHETYPE.is_specialised returns True.VASID: archetype specialisation parent identifier validity.
 * The archetype identifier stated in the specialise clause must be the identifier of the immediate specialisation parent archetype.VALC: archetype language conformance.
 * The languages defined in a specialised archetype must be the same as or a subset of those defined in the flat parent.VACSD: archetype concept specialisation depth.
 * The specialisation depth of the archetypes must be one greater than the specialisation depth of the parent archetype.VATCD: archetype code specialisation level validity.
 * Each archetype term ('at' code) and constraint code ('ac' code) used in the archetype definition section must have a specialisation level no greater than the specialisation level of the archetype.The following validity rules apply to instances of TEMPLATE:VTPL: template and filler language consistency.
 * All fillers of slots and external reference archetypes (i.e.
 * 'use_archetype' inclusions) must contain the original_language of the root template in their languages, in order for template flattening to be successful.
 */
