package nl.rosa.semanticdatabase.resource_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.terminology_package.TerminologyCode;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Class providing details of a natural language translation.
 */
public class TranslationDetails {

    //***** TranslationDetails *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Language of the translation, coded using ISO 639-1 (2 character) language codes.
     * cardinality: 1..1
     */
    private TerminologyCode language;

    /**
     * Primary translator name and other demographic details.
     * cardinality: 1..1
     */
    private Map<String, String> author = new HashMap<>();

    /**
     * Accreditation of primary translator or group, usually a national translator’s registration or association membership id.
     * cardinality: 0..1
     */
    private String accreditation;

    /**
     * Any other meta-data.
     * cardinality: 0..1
     */
    private Map<String, String> otherDetails;

    /**
     * Version of this resource last time it was translated into the language represented by this TRANSLATION_DETAILS object.
     * cardinality: 0..1
     */
    private String versionLastTranslated;

    /**
     * Additional contributors to this translation, each listed in "name <email>" form.
     * cardinality: 0..1
     */
    private List<String> otherContributors;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Language of the translation, coded using ISO 639-1 (2 character) language codes.
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
     * Primary translator name and other demographic details.
     * cardinality: 1..1
     */

    public void putAuthor(String key, String value) {
        author.put(key, value);
    }

    public void putAuthor(Map<String, String> items) {
        items.keySet().forEach(key -> putAutho(key, items.get(key)));
    }

    public String getAuthor(String key) {
        return author.get(key);
    }

    public void removeAuthor(String key) {
        if (author != null) {
            author.remove(key);
        }
    }

    public void removeAuthor(Collection<String> keys) {
        keys.forEach(this::removeAuthor);
    }

    public Map<String, String> getAuthor() {
        return this.author;
    }

    public TranslationDetails setAuthor(Map<String, String> author) {
        if (author == null) {
            throw new NullPointerException(" author has cardinality NonNull, but is null");
        }
        this.author = author;
        return this;
    }

    public Map<String, String> author() {
        return Collections.unmodifiableMap(this.author);
    }

    /**
     * Accreditation of primary translator or group, usually a national translator’s registration or association membership id.
     * cardinality: 0..1
     */
    public String getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(String value) {
        this.accreditation = accreditation;
    }

    /**
     * Any other meta-data.
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

    public TranslationDetails setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
        return this;
    }

    public Map<String, String> otherDetails() {
        return Collections.unmodifiableMap(this.otherDetails);
    }

    /**
     * Version of this resource last time it was translated into the language represented by this TRANSLATION_DETAILS object.
     * cardinality: 0..1
     */
    public String getVersionLastTranslated() {
        return versionLastTranslated;
    }

    public void setVersionLastTranslated(String value) {
        this.versionLastTranslated = versionLastTranslated;
    }

    /**
     * Additional contributors to this translation, each listed in "name <email>" form.
     * cardinality: 0..1
     */

    public void addToOtherContributor(String value) {
        if (otherContributors == null) {
            otherContributors = new ArrayList<>();
        }
        otherContributors.add(value);
    }

    public void addToOtherContributors(List<String> values) {
        values.forEach(value -> addToOthercontributor(value));
    }

    public void removeFromOtherContributor(String item) {
        if (otherContributors != null) {
            otherContributors.remove(item);
        }
    }

    public void removeFromOtherContributors(Collection<String> values) {
        values.forEach(this::removeFromOtherContributor);
    }

    List<String> getOtherContributors() {
        return this.otherContributors;
    }

    public TranslationDetails setOtherContributors(List<String> otherContributors) {
        this.otherContributors = otherContributors;
        return this;
    }

    public List<String> otherContributors() {
        return Collections.unmodifiableList(this.otherContributors);
    }

    //***** TranslationDetails *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected TranslationDetails() {
    }

    public TranslationDetails(
            TerminologyCode language,
            Map<string, string> author,
            String accreditation,
            Map<string, string> otherDetails,
            String versionLastTranslated,
            List<string> otherContributors
    ) {
        if (language == null) {
            throw new NullPointerException("Property:language has cardinality NonNull, but is null");
        }
        if (author == null) {
            throw new NullPointerException("Property:author has cardinality NonNull, but is null");
        }
        this.language = language;
        this.author = author;
        this.accreditation = accreditation;
        this.otherDetails = otherDetails;
        this.versionLastTranslated = versionLastTranslated;
        this.otherContributors = otherContributors;
    }

    private TranslationDetails(Builder builder) {
        this.setLanguage(builder.language);
        this.setAuthor(builder.author);
        this.setAccreditation(builder.accreditation);
        this.setOtherDetails(builder.otherDetails);
        this.setVersionLastTranslated(builder.versionLastTranslated);
        this.setOtherContributors(builder.otherContributors);
    }

    public static class Builder {
        private final TerminologyCode language;  //required
        private final Map<string, string> author;  //required
        private String accreditation;
        private Map<string, string> otherDetails;
        private String versionLastTranslated;
        private List<string> otherContributors;

        public Builder(
                TerminologyCode language,
                Map<string, string> author
        ) {
            if (language == null) {
                throw new NullPointerException("Property:language has cardinality NonNull, but is null");
            }
            if (author == null) {
                throw new NullPointerException("Property:author has cardinality NonNull, but is null");
            }
            this.language = language;
            this.author = author;
        }

        public Builder setAccreditation(String value) {
            this.accreditation = accreditation;
            return this;
        }

        public Builder setOtherDetails(Map<string, string> value) {
            this.otherDetails = otherDetails;
            return this;
        }

        public Builder setVersionLastTranslated(String value) {
            this.versionLastTranslated = versionLastTranslated;
            return this;
        }

        public Builder setOtherContributors(List<string> value) {
            this.otherContributors = otherContributors;
            return this;
        }

        public TranslationDetails build() {
            return new TranslationDetails(this);
        }
    }


    //***** TranslationDetails *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        TranslationDetails that = (TranslationDetails) object;
        return
                Objects.equals(language, that.language) &&
                        Objects.equals(author, that.author) &&
                        Objects.equals(accreditation, that.accreditation) &&
                        Objects.equals(otherDetails, that.otherDetails) &&
                        Objects.equals(versionLastTranslated, that.versionLastTranslated) &&
                        Objects.equals(otherContributors, that.otherContributors);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                language,
                author,
                accreditation,
                otherDetails,
                versionLastTranslated,
                otherContributors
        );
    }

    @Override
    public String toString() {
        return
                "TranslationDetails {" +
                        "language='" + language + '\'' +
                        "author='" + author + '\'' +
                        "accreditation='" + accreditation + '\'' +
                        "otherDetails='" + otherDetails + '\'' +
                        "versionLastTranslated='" + versionLastTranslated + '\'' +
                        "otherContributors='" + otherContributors + '\'' +
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
