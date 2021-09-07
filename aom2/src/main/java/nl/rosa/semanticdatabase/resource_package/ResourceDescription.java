package nl.rosa.semanticdatabase.resource_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.terminology_package.TerminologyCode;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Defines the descriptive meta-data of a resource.
 */
public class ResourceDescription {

    //***** ResourceDescription *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Original author of this resource, with all relevant details, including organisation.
     * cardinality: 1..1
     */
    private Map<String, String> originalAuthor = new HashMap<>();

    /**
     * Namespace of original author’s organisation, in reverse internet form, if applicable.
     * cardinality: 0..1
     */
    private String originalNamespace;

    /**
     * Plain text name of organisation that originally published this artefact, if any.
     * cardinality: 0..1
     */
    private String originalPublisher;

    /**
     * Other contributors to the resource, each listed in "name <email>" form.
     * cardinality: 0..1
     */
    private List<String> otherContributors;

    /**
     * Lifecycle state of the resource, typically including states such as: initial, in_development, in_review, published, superseded, obsolete.
     * cardinality: 1..1
     */
    private TerminologyCode lifecycleState;

    /**
     * Namespace in reverse internet id form, of current custodian organisation.
     * cardinality: 0..1
     */
    private String custodianNamespace;

    /**
     * Plain text name of current custodian organisation.
     * cardinality: 0..1
     */
    private String custodianOrganisation;

    /**
     * Optional copyright statement for the resource as a knowledge resource.
     * cardinality: 0..1
     */
    private String copyright;

    /**
     * Licence of current artefact, in format "short licence name <URL of licence>", e.g.
     * "Apache 2.0 License <http://www.apache.org/licenses/LICENSE-2.0.html>"
     * cardinality: 0..1
     */
    private String licence;

    /**
     * List of acknowledgements of other IP directly referenced in this archetype, typically terminology codes, ontology ids etc.
     * Recommended keys are the widely known name or namespace for the IP source, as shown in the following example: ip_acknowledgements = < ["loinc"] = <"This content from LOINC® is copyright © 1995 Regenstrief Institute, Inc.
     * and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use"> ["snomedct"] = <"Content from SNOMED CT® is copyright © 2007 IHTSDO <ihtsdo.org>"> >
     * cardinality: 0..1
     */
    private Map<String, String> ipAcknowledgements;

    /**
     * List of references of material on which this artefact is based, as a keyed list of strings.
     * The keys should be in a standard citation format.
     * cardinality: 0..1
     */
    private Map<String, String> references;

    /**
     * URI of package to which this resource belongs.
     * cardinality: 0..1
     */
    private String resourcePackageUri;

    /**
     * Details related to conversion process that generated this model from an original, if relevant, as a list of name/value pairs.
     * Typical example with recommended tags: conversion_details = < ["source_model"] = <"CEM model xyz <http://location.in.clinicalelementmodels.com>"> ["tool"] = <"cem2adl v6.3.0"> ["time"] = <"2014-11-03T09:05:00"> >
     * cardinality: 0..1
     */
    private Map<String, String> conversionDetails;

    /**
     * Additional non-language-sensitive resource meta-data, as a list of name/value pairs.
     * cardinality: 0..1
     */
    private Map<String, String> otherDetails;

    /**
     * Details of all parts of resource description that are natural language-dependent, keyed by language code.
     * cardinality: 0..1
     */
    private Map<String, ResourceDescriptionItem> details;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Original author of this resource, with all relevant details, including organisation.
     * cardinality: 1..1
     */

    public void putOriginalAuthor(String key, String value) {
        originalAuthor.put(key, value);
    }

    public void putOriginalAuthor(Map<String, String> items) {
        items.keySet().forEach(key -> putOriginalautho(key, items.get(key)));
    }

    public String getOriginalAuthor(String key) {
        return originalAuthor.get(key);
    }

    public void removeOriginalAuthor(String key) {
        if (originalAuthor != null) {
            originalAuthor.remove(key);
        }
    }

    public void removeOriginalAuthor(Collection<String> keys) {
        keys.forEach(this::removeOriginalAuthor);
    }

    public Map<String, String> getOriginalAuthor() {
        return this.originalAuthor;
    }

    public ResourceDescription setOriginalAuthor(Map<String, String> originalAuthor) {
        if (originalAuthor == null) {
            throw new NullPointerException(" originalAuthor has cardinality NonNull, but is null");
        }
        this.originalAuthor = originalAuthor;
        return this;
    }

    public Map<String, String> originalAuthor() {
        return Collections.unmodifiableMap(this.originalAuthor);
    }

    /**
     * Namespace of original author’s organisation, in reverse internet form, if applicable.
     * cardinality: 0..1
     */
    public String getOriginalNamespace() {
        return originalNamespace;
    }

    public void setOriginalNamespace(String value) {
        this.originalNamespace = originalNamespace;
    }

    /**
     * Plain text name of organisation that originally published this artefact, if any.
     * cardinality: 0..1
     */
    public String getOriginalPublisher() {
        return originalPublisher;
    }

    public void setOriginalPublisher(String value) {
        this.originalPublisher = originalPublisher;
    }

    /**
     * Other contributors to the resource, each listed in "name <email>" form.
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

    public ResourceDescription setOtherContributors(List<String> otherContributors) {
        this.otherContributors = otherContributors;
        return this;
    }

    public List<String> otherContributors() {
        return Collections.unmodifiableList(this.otherContributors);
    }

    /**
     * Lifecycle state of the resource, typically including states such as: initial, in_development, in_review, published, superseded, obsolete.
     * cardinality: 1..1
     */
    public TerminologyCode getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(TerminologyCode value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:lifecycleState failed, it has cardinality NonNull, but is null");
        }
        this.lifecycleState = lifecycleState;
    }

    /**
     * Namespace in reverse internet id form, of current custodian organisation.
     * cardinality: 0..1
     */
    public String getCustodianNamespace() {
        return custodianNamespace;
    }

    public void setCustodianNamespace(String value) {
        this.custodianNamespace = custodianNamespace;
    }

    /**
     * Plain text name of current custodian organisation.
     * cardinality: 0..1
     */
    public String getCustodianOrganisation() {
        return custodianOrganisation;
    }

    public void setCustodianOrganisation(String value) {
        this.custodianOrganisation = custodianOrganisation;
    }

    /**
     * Optional copyright statement for the resource as a knowledge resource.
     * cardinality: 0..1
     */
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String value) {
        this.copyright = copyright;
    }

    /**
     * Licence of current artefact, in format "short licence name <URL of licence>", e.g.
     * "Apache 2.0 License <http://www.apache.org/licenses/LICENSE-2.0.html>"
     * cardinality: 0..1
     */
    public String getLicence() {
        return licence;
    }

    public void setLicence(String value) {
        this.licence = licence;
    }

    /**
     * List of acknowledgements of other IP directly referenced in this archetype, typically terminology codes, ontology ids etc.
     * Recommended keys are the widely known name or namespace for the IP source, as shown in the following example: ip_acknowledgements = < ["loinc"] = <"This content from LOINC® is copyright © 1995 Regenstrief Institute, Inc.
     * and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use"> ["snomedct"] = <"Content from SNOMED CT® is copyright © 2007 IHTSDO <ihtsdo.org>"> >
     * cardinality: 0..1
     */

    public void putIpAcknowledgement(String key, String value) {
        if (ipAcknowledgements == null) {
            ipAcknowledgements = new HashMap<>();
        }
        ipAcknowledgements.put(key, value);
    }

    public void putIpAcknowledgements(Map<String, String> items) {
        items.keySet().forEach(key -> putIpacknowledgement(key, items.get(key)));
    }

    public String getIpAcknowledgement(String key) {
        if (ipAcknowledgements == null) {
            return null;
        }
        return ipAcknowledgements.get(key);
    }

    public void removeIpAcknowledgement(String key) {
        if (ipAcknowledgements != null) {
            ipAcknowledgements.remove(key);
        }
    }

    public void removeIpAcknowledgements(Collection<String> keys) {
        keys.forEach(this::removeIpAcknowledgement);
    }

    public Map<String, String> getIpAcknowledgements() {
        return this.ipAcknowledgements;
    }

    public ResourceDescription setIpAcknowledgements(Map<String, String> ipAcknowledgements) {
        this.ipAcknowledgements = ipAcknowledgements;
        return this;
    }

    public Map<String, String> ipAcknowledgements() {
        return Collections.unmodifiableMap(this.ipAcknowledgements);
    }

    /**
     * List of references of material on which this artefact is based, as a keyed list of strings.
     * The keys should be in a standard citation format.
     * cardinality: 0..1
     */

    public void putReference(String key, String value) {
        if (references == null) {
            references = new HashMap<>();
        }
        references.put(key, value);
    }

    public void putReferences(Map<String, String> items) {
        items.keySet().forEach(key -> putReference(key, items.get(key)));
    }

    public String getReference(String key) {
        if (references == null) {
            return null;
        }
        return references.get(key);
    }

    public void removeReference(String key) {
        if (references != null) {
            references.remove(key);
        }
    }

    public void removeReferences(Collection<String> keys) {
        keys.forEach(this::removeReference);
    }

    public Map<String, String> getReferences() {
        return this.references;
    }

    public ResourceDescription setReferences(Map<String, String> references) {
        this.references = references;
        return this;
    }

    public Map<String, String> references() {
        return Collections.unmodifiableMap(this.references);
    }

    /**
     * URI of package to which this resource belongs.
     * cardinality: 0..1
     */
    public String getResourcePackageUri() {
        return resourcePackageUri;
    }

    public void setResourcePackageUri(String value) {
        this.resourcePackageUri = resourcePackageUri;
    }

    /**
     * Details related to conversion process that generated this model from an original, if relevant, as a list of name/value pairs.
     * Typical example with recommended tags: conversion_details = < ["source_model"] = <"CEM model xyz <http://location.in.clinicalelementmodels.com>"> ["tool"] = <"cem2adl v6.3.0"> ["time"] = <"2014-11-03T09:05:00"> >
     * cardinality: 0..1
     */

    public void putConversionDetail(String key, String value) {
        if (conversionDetails == null) {
            conversionDetails = new HashMap<>();
        }
        conversionDetails.put(key, value);
    }

    public void putConversionDetails(Map<String, String> items) {
        items.keySet().forEach(key -> putConversiondetail(key, items.get(key)));
    }

    public String getConversionDetail(String key) {
        if (conversionDetails == null) {
            return null;
        }
        return conversionDetails.get(key);
    }

    public void removeConversionDetail(String key) {
        if (conversionDetails != null) {
            conversionDetails.remove(key);
        }
    }

    public void removeConversionDetails(Collection<String> keys) {
        keys.forEach(this::removeConversionDetail);
    }

    public Map<String, String> getConversionDetails() {
        return this.conversionDetails;
    }

    public ResourceDescription setConversionDetails(Map<String, String> conversionDetails) {
        this.conversionDetails = conversionDetails;
        return this;
    }

    public Map<String, String> conversionDetails() {
        return Collections.unmodifiableMap(this.conversionDetails);
    }

    /**
     * Additional non-language-sensitive resource meta-data, as a list of name/value pairs.
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

    public ResourceDescription setOtherDetails(Map<String, String> otherDetails) {
        this.otherDetails = otherDetails;
        return this;
    }

    public Map<String, String> otherDetails() {
        return Collections.unmodifiableMap(this.otherDetails);
    }

    /**
     * Details of all parts of resource description that are natural language-dependent, keyed by language code.
     * cardinality: 0..1
     */

    public void putDetail(String key, ResourceDescriptionItem value) {
        if (details == null) {
            details = new HashMap<>();
        }
        details.put(key, value);
    }

    public void putDetails(Map<String, ResourceDescriptionItem> items) {
        items.keySet().forEach(key -> putDetail(key, items.get(key)));
    }

    public ResourceDescriptionItem getDetail(String key) {
        if (details == null) {
            return null;
        }
        return details.get(key);
    }

    public void removeDetail(String key) {
        if (details != null) {
            details.remove(key);
        }
    }

    public void removeDetails(Collection<String> keys) {
        keys.forEach(this::removeDetail);
    }

    public Map<String, ResourceDescriptionItem> getDetails() {
        return this.details;
    }

    public ResourceDescription setDetails(Map<String, ResourceDescriptionItem> details) {
        this.details = details;
        return this;
    }

    public Map<String, ResourceDescriptionItem> details() {
        return Collections.unmodifiableMap(this.details);
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Reference to owning resource.
     */
    final AUTHORED_RESOURCE {
        default
        parentResource =
    }

    ;

    //***** ResourceDescription *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ResourceDescription() {
    }

    public ResourceDescription(
            Map<string, string> originalAuthor,
            String originalNamespace,
            String originalPublisher,
            List<string> otherContributors,
            TerminologyCode lifecycleState,
            String custodianNamespace,
            String custodianOrganisation,
            String copyright,
            String licence,
            Map<string, string> ipAcknowledgements,
            Map<string, string> references,
            String resourcePackageUri,
            Map<string, string> conversionDetails,
            Map<string, string> otherDetails,
            Map<string, resourceDescriptionItem> details
    ) {
        if (originalAuthor == null) {
            throw new NullPointerException("Property:originalAuthor has cardinality NonNull, but is null");
        }
        if (lifecycleState == null) {
            throw new NullPointerException("Property:lifecycleState has cardinality NonNull, but is null");
        }
        this.originalAuthor = originalAuthor;
        this.originalNamespace = originalNamespace;
        this.originalPublisher = originalPublisher;
        this.otherContributors = otherContributors;
        this.lifecycleState = lifecycleState;
        this.custodianNamespace = custodianNamespace;
        this.custodianOrganisation = custodianOrganisation;
        this.copyright = copyright;
        this.licence = licence;
        this.ipAcknowledgements = ipAcknowledgements;
        this.references = references;
        this.resourcePackageUri = resourcePackageUri;
        this.conversionDetails = conversionDetails;
        this.otherDetails = otherDetails;
        this.details = details;
    }

    private ResourceDescription(Builder builder) {
        this.setOriginalAuthor(builder.originalAuthor);
        this.setOriginalNamespace(builder.originalNamespace);
        this.setOriginalPublisher(builder.originalPublisher);
        this.setOtherContributors(builder.otherContributors);
        this.setLifecycleState(builder.lifecycleState);
        this.setCustodianNamespace(builder.custodianNamespace);
        this.setCustodianOrganisation(builder.custodianOrganisation);
        this.setCopyright(builder.copyright);
        this.setLicence(builder.licence);
        this.setIpAcknowledgements(builder.ipAcknowledgements);
        this.setReferences(builder.references);
        this.setResourcePackageUri(builder.resourcePackageUri);
        this.setConversionDetails(builder.conversionDetails);
        this.setOtherDetails(builder.otherDetails);
        this.setDetails(builder.details);
    }

    public static class Builder {
        private final Map<string, string> originalAuthor;  //required
        private String originalNamespace;
        private String originalPublisher;
        private List<string> otherContributors;
        private final TerminologyCode lifecycleState;  //required
        private String custodianNamespace;
        private String custodianOrganisation;
        private String copyright;
        private String licence;
        private Map<string, string> ipAcknowledgements;
        private Map<string, string> references;
        private String resourcePackageUri;
        private Map<string, string> conversionDetails;
        private Map<string, string> otherDetails;
        private Map<string, resourceDescriptionItem> details;

        public Builder(
                Map<string, string> originalAuthor,
                TerminologyCode lifecycleState
        ) {
            if (originalAuthor == null) {
                throw new NullPointerException("Property:originalAuthor has cardinality NonNull, but is null");
            }
            if (lifecycleState == null) {
                throw new NullPointerException("Property:lifecycleState has cardinality NonNull, but is null");
            }
            this.originalAuthor = originalAuthor;
            this.lifecycleState = lifecycleState;
        }

        public Builder setOriginalNamespace(String value) {
            this.originalNamespace = originalNamespace;
            return this;
        }

        public Builder setOriginalPublisher(String value) {
            this.originalPublisher = originalPublisher;
            return this;
        }

        public Builder setOtherContributors(List<string> value) {
            this.otherContributors = otherContributors;
            return this;
        }

        public Builder setCustodianNamespace(String value) {
            this.custodianNamespace = custodianNamespace;
            return this;
        }

        public Builder setCustodianOrganisation(String value) {
            this.custodianOrganisation = custodianOrganisation;
            return this;
        }

        public Builder setCopyright(String value) {
            this.copyright = copyright;
            return this;
        }

        public Builder setLicence(String value) {
            this.licence = licence;
            return this;
        }

        public Builder setIpAcknowledgements(Map<string, string> value) {
            this.ipAcknowledgements = ipAcknowledgements;
            return this;
        }

        public Builder setReferences(Map<string, string> value) {
            this.references = references;
            return this;
        }

        public Builder setResourcePackageUri(String value) {
            this.resourcePackageUri = resourcePackageUri;
            return this;
        }

        public Builder setConversionDetails(Map<string, string> value) {
            this.conversionDetails = conversionDetails;
            return this;
        }

        public Builder setOtherDetails(Map<string, string> value) {
            this.otherDetails = otherDetails;
            return this;
        }

        public Builder setDetails(Map<string, resourceDescriptionItem> value) {
            this.details = details;
            return this;
        }

        public ResourceDescription build() {
            return new ResourceDescription(this);
        }
    }


    //***** ResourceDescription *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ResourceDescription that = (ResourceDescription) object;
        return
                Objects.equals(originalAuthor, that.originalAuthor) &&
                        Objects.equals(originalNamespace, that.originalNamespace) &&
                        Objects.equals(originalPublisher, that.originalPublisher) &&
                        Objects.equals(otherContributors, that.otherContributors) &&
                        Objects.equals(lifecycleState, that.lifecycleState) &&
                        Objects.equals(custodianNamespace, that.custodianNamespace) &&
                        Objects.equals(custodianOrganisation, that.custodianOrganisation) &&
                        Objects.equals(copyright, that.copyright) &&
                        Objects.equals(licence, that.licence) &&
                        Objects.equals(ipAcknowledgements, that.ipAcknowledgements) &&
                        Objects.equals(references, that.references) &&
                        Objects.equals(resourcePackageUri, that.resourcePackageUri) &&
                        Objects.equals(conversionDetails, that.conversionDetails) &&
                        Objects.equals(otherDetails, that.otherDetails) &&
                        Objects.equals(details, that.details);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                originalAuthor,
                originalNamespace,
                originalPublisher,
                otherContributors,
                lifecycleState,
                custodianNamespace,
                custodianOrganisation,
                copyright,
                licence,
                ipAcknowledgements,
                references,
                resourcePackageUri,
                conversionDetails,
                otherDetails,
                details
        );
    }

    @Override
    public String toString() {
        return
                "ResourceDescription {" +
                        "originalAuthor='" + originalAuthor + '\'' +
                        "originalNamespace='" + originalNamespace + '\'' +
                        "originalPublisher='" + originalPublisher + '\'' +
                        "otherContributors='" + otherContributors + '\'' +
                        "lifecycleState='" + lifecycleState + '\'' +
                        "custodianNamespace='" + custodianNamespace + '\'' +
                        "custodianOrganisation='" + custodianOrganisation + '\'' +
                        "copyright='" + copyright + '\'' +
                        "licence='" + licence + '\'' +
                        "ipAcknowledgements='" + ipAcknowledgements + '\'' +
                        "references='" + references + '\'' +
                        "resourcePackageUri='" + resourcePackageUri + '\'' +
                        "conversionDetails='" + conversionDetails + '\'' +
                        "otherDetails='" + otherDetails + '\'' +
                        "details='" + details + '\'' +
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
