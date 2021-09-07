package nl.rosa.semanticdatabase.resource_package;

import semanticdatabase.base.foundation_types.identification_package.Uuid;
import semanticdatabase.base.foundation_types.terminology_package.TerminologyCode;
import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract idea of an online resource created by a human author.
 */
public interface AuthoredResource {

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Unique identifier of the family of archetypes having the same interface identifier (same major version).
     * cardinality: 0..1
     */
    Uuid getUid();

    void setUid(Uuid value);

    /**
     * Language in which this resource was initially authored.
     * Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality.
     * Language is relevant in both the description and ontology sections.
     * cardinality: 1..1
     */
    TerminologyCode getOriginalLanguage();

    void setOriginalLanguage(TerminologyCode value);

    /**
     * Description and lifecycle information of the resource.
     * cardinality: 0..1
     */
    ResourceDescription getDescription();

    void setDescription(ResourceDescription value);

    /**
     * True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     * cardinality: 0..1
     */
    Boolean getIsControlled();

    void setIsControlled(Boolean value);

    /**
     * Annotations on individual items within the resource, keyed by path.
     * The inner table takes the form of a Hash table of String values keyed by String tags.
     * cardinality: 0..1
     */
    RESOURCE_ANNOTATIONS getAnnotations();

    void setAnnotations(RESOURCE_ANNOTATIONS value);

    /**
     * List of details for each natural translation made of this resource, keyed by language code.
     * For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource.
     * The original_language does not appear in this list.
     * cardinality: 0..1
     */

    void putTranslation(String key, TranslationDetails value);

    void putTranslations(Map<String, TranslationDetails> items);

    TranslationDetails getTranslation(String key);

    void removeTranslation(String key);

    void removeTranslations(Collection<String> keys);

    Map<String, TranslationDetails> getTranslations();

    void setTranslations(Map<String, TranslationDetails> translations);

    Map<String, TranslationDetails> translations();

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

    revision_history.most_recent_version currentRevision();

    /**
     * Total list of languages available in this resource, derived from original_language and translations.
     * cardinality: 1..1
     */
    public List<String> languagesAvailable();

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
