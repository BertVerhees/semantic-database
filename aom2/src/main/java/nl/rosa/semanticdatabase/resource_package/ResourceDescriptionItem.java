package nl.rosa.semanticdatabase.resource_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.terminology_package.TerminologyCode;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Language-specific detail of resource description.
 * When a resource is translated for use in another language environment, each RESOURCE_DESCRIPTION_ITEM needs to be copied and translated into the new language.
 */
public class ResourceDescriptionItem {

    //***** ResourceDescriptionItem *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The localised language in which the items in this description item are written.
     * Coded using ISO 639-1 (2 character) language codes.
     * cardinality: 1..1
     */
    private TerminologyCode language;

    /**
     * Purpose of the resource.
     * cardinality: 1..1
     */
    private String purpose;

    /**
     * Keywords which characterise this resource, used e.g.
     * for indexing and searching.
     * cardinality: 0..1
     */
    private List<String> keywords;

    /**
     * Description of the uses of the resource, i.e.
     * contexts in which it could be used.
     * cardinality: 0..1
     */
    private String use;

    /**
     * Description of any misuses of the resource, i.e.
     * contexts in which it should not be used.
     * cardinality: 0..1
     */
    private String misuse;

    /**
     * URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.
     * cardinality: 0..1
     */
    private Map<String, String> originalResourceUri;

    /**
     * Additional language-senstive resource metadata, as a list of name/value pairs.
     * cardinality: 0..1
     */
    private Map<String, String> otherDetails;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The localised language in which the items in this description item are written.
     * Coded using ISO 639-1 (2 character) language codes.
     * cardinality: 1..1
     */
    public TerminologyCode getLanguage() {
        return language;
    }

    public void setLanguage(TerminologyCode value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:language failed, it has cardinality NonNull, but is null");
        }
        this.language = language;
    }

    /**
     * Purpose of the resource.
     * cardinality: 1..1
     */
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:purpose failed, it has cardinality NonNull, but is null");
        }
        this.purpose = purpose;
    }

    /**
     * Keywords which characterise this resource, used e.g.
     * for indexing and searching.
     * cardinality: 0..1
     */

    public void addToKeyword(String value) {
        if (keywords == null) {
            keywords = new ArrayList<>();
        }
        keywords.add(value);
    }

    public void addToKeywords(List<String> values) {
        values.forEach(value -> addToKeyword(value));
    }

    public void removeFromKeyword(String item) {
        if (keywords != null) {
            keywords.remove(item);
        }
    }

    public void removeFromKeywords(Collection<String> values) {
        values.forEach(this::removeFromKeyword);
    }

    List<String> getKeywords() {
        return this.keywords;
    }

    public ResourceDescriptionItem setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public List<String> keywords() {
        return Collections.unmodifiableList(this.keywords);
    }

    /**
     * Description of the uses of the resource, i.e.
     * contexts in which it could be used.
     * cardinality: 0..1
     */
    public String getUse() {
        return use;
    }

    public void setUse(String value) {
        this.use = use;
    }

    /**
     * Description of any misuses of the resource, i.e.
     * contexts in which it should not be used.
     * cardinality: 0..1
     */
    public String getMisuse() {
        return misuse;
    }

    public void setMisuse(String value) {
        this.misuse = misuse;
    }

    /**
     * URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.
     * cardinality: 0..1
     */

    public void putOriginalResourceUri(String key, String value) {
        if (originalResourceUri == null) {
            originalResourceUri = new HashMap<>();
        }
        originalResourceUri.put(key, value);
    }

    public void putOriginalResourceUri(Map<String, String> items) {
        items.keySet().forEach(key -> putOriginalresourceur(key, items.get(key)));
    }

    public String getOriginalResourceUri(String key) {
        if (originalResourceUri == null) {
            return null;
        }
        return originalResourceUri.get(key);
    }

    public void removeOriginalResourceUri(String key) {
        if (originalResourceUri != null) {
            originalResourceUri.remove(key);
        }
    }

    public void removeOriginalResourceUri(Collection<String> keys) {
        keys.forEach(this::removeOriginalResourceUri);
    }

    public Map<String, String> getOriginalResourceUri() {
        return this.originalResourceUri;
    }

    public ResourceDescriptionItem setOriginalResourceUri(Map<String, String> originalResourceUri) {
        this.originalResourceUri = originalResourceUri;
        return this;
    }

    public Map<String, String> originalResourceUri() {
        return Collections.unmodifiableMap(this.originalResourceUri);
    }

    /**
     * Additional language-senstive resource metadata, as a list of name/value pairs.
     * cardinality: 0..1
     */

    public void putOtherDetail(String key, String value) {
        if (otherDetails == null) {
            otherDetails = new HashMap<>();
        }
        otherDetails.put(key, value);
    }

    public void putOtherDetails(Map<String, String> items) {
        items.keySet().forEach(key -> putOtherdetail(key, items.get(key)));
    }

    public String getOtherDetail(String key) {
        if (otherDetails == null) {
            return null;
        }
        return otherDetails.get(key);
    }

    public void removeOtherDetail(String key) {
        if (otherDetails != null) {
            otherDetails.remove(key);
        }
    }

    public void removeOtherDetails(Collection<String> keys) {
        keys.forEach(this::removeOtherDetail);
    }

    public Map<String, String> getOtherDetails() {
        return this.otherDetails;
    }

    public ResourceDescriptionItem setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
        return this;
    }

    public Map<String, String> otherDetails() {
        return Collections.unmodifiableMap(this.otherDetails);
    }

    //***** ResourceDescriptionItem *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ResourceDescriptionItem() {
    }

    public ResourceDescriptionItem(
            TerminologyCode language,
            String purpose,
            List<string> keywords,
            String use,
            String misuse,
            Map<string, string> originalResourceUri,
            Map<string, string> otherDetails
    ) {
        if (language == null) {
            throw new NullPointerException("Property:language has cardinality NonNull, but is null");
        }
        if (purpose == null) {
            throw new NullPointerException("Property:purpose has cardinality NonNull, but is null");
        }
        this.language = language;
        this.purpose = purpose;
        this.keywords = keywords;
        this.use = use;
        this.misuse = misuse;
        this.originalResourceUri = originalResourceUri;
        this.otherDetails = otherDetails;
    }

    private ResourceDescriptionItem(Builder builder) {
        this.setLanguage(builder.language);
        this.setPurpose(builder.purpose);
        this.setKeywords(builder.keywords);
        this.setUse(builder.use);
        this.setMisuse(builder.misuse);
        this.setOriginalResourceUri(builder.originalResourceUri);
        this.setOtherDetails(builder.otherDetails);
    }

    public static class Builder {
        private final TerminologyCode language;  //required
        private final String purpose;  //required
        private List<string> keywords;
        private String use;
        private String misuse;
        private Map<string, string> originalResourceUri;
        private Map<string, string> otherDetails;

        public Builder(
                TerminologyCode language,
                String purpose
        ) {
            if (language == null) {
                throw new NullPointerException("Property:language has cardinality NonNull, but is null");
            }
            if (purpose == null) {
                throw new NullPointerException("Property:purpose has cardinality NonNull, but is null");
            }
            this.language = language;
            this.purpose = purpose;
        }

        public Builder setKeywords(List<string> value) {
            this.keywords = keywords;
            return this;
        }

        public Builder setUse(String value) {
            this.use = use;
            return this;
        }

        public Builder setMisuse(String value) {
            this.misuse = misuse;
            return this;
        }

        public Builder setOriginalResourceUri(Map<string, string> value) {
            this.originalResourceUri = originalResourceUri;
            return this;
        }

        public Builder setOtherDetails(Map<string, string> value) {
            this.otherDetails = otherDetails;
            return this;
        }

        public ResourceDescriptionItem build() {
            return new ResourceDescriptionItem(this);
        }
    }


    //***** ResourceDescriptionItem *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ResourceDescriptionItem that = (ResourceDescriptionItem) object;
        return
                Objects.equals(language, that.language) &&
                        Objects.equals(purpose, that.purpose) &&
                        Objects.equals(keywords, that.keywords) &&
                        Objects.equals(use, that.use) &&
                        Objects.equals(misuse, that.misuse) &&
                        Objects.equals(originalResourceUri, that.originalResourceUri) &&
                        Objects.equals(otherDetails, that.otherDetails);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                language,
                purpose,
                keywords,
                use,
                misuse,
                originalResourceUri,
                otherDetails
        );
    }

    @Override
    public String toString() {
        return
                "ResourceDescriptionItem {" +
                        "language='" + language + '\'' +
                        "purpose='" + purpose + '\'' +
                        "keywords='" + keywords + '\'' +
                        "use='" + use + '\'' +
                        "misuse='" + misuse + '\'' +
                        "originalResourceUri='" + originalResourceUri + '\'' +
                        "otherDetails='" + otherDetails + '\'' +
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
