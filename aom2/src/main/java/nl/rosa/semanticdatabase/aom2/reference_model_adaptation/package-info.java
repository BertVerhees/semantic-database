package nl.rosa.semanticdatabase.aom2.reference_model_adaptation;
/**
 * 11.
 * Reference Model Adaptation
 * 11.1.
 * Overview
 * So far ADL has been presented as an abstract formal language that defines legal information structures based on a reference model (RM).
 * In real world applications, we need to consider where reference models come from, and the question of harmonising or otherwise integrating archetypes based on different but related RMs.One of the common problems in most domains is that competing reference models exist, typically defined by standards bodies such as ISO, CEN, ASTM, and/or other open standards bodies such as W3C and OASIS.
 * For a given topic, e.g.
 * 'cancer study trials' or 'Electronic Health Record' there can often be multiple information models that could be used as a basis for archetyping.
 * Due to political pressures, national requiremenents or preferences and variety of other non-technical factors, it is quite likely that archetypes will be authored within a domain based on multiple competing reference models that are reasonably similar without being easily machine inter-convertible.Since archetypes are generally authored by domain experts, the entities they represent tend to come from a homogeneous model space, with reference models being a technical detail that may not even be visible to the archetype author.
 * Nevertheless, due to the above-mentioned factors, authors in different localities or jurisdictions may have no choice but to model the same entity, for example 'complete blood count' based on two or more different reference models.This creates a potential problem of competing libraries of archetypes trying to model the same information entities in slightly different but incompatible ways.
 * This tends to needlessly split groups of domain modellers into disparate communities, when in fact they are modelling the same things.In order to alleviate some of the problems caused by this situation, some of the measures described below, which are outside the AOM proper, can be applied to enable archetypes and RMs treated to be treated more uniformly.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 11.2.
 * AOM Profile Configuration
 * These adaptations can be formalised in a configuration object that is an instance of the class AOM_PROFILE, shown below.
 * This is only one way such information can be represented, and alternatives could be used.
 * <p>
 * <p>
 * <p>
 * Figure 29.
 * aom2.profile Package
 * 11.2.1.
 * Class Definitions
 * <p>
 * 11.2.2.
 * AOM_PROFILE Class
 * <p>
 * 11.2.3.
 * AOM_TYPE_MAPPING Class
 * <p>
 * 11.2.4.
 * AOM_PROPERTY_MAPPING Class
 */
