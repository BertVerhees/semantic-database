package nl.rosa.semanticdatabase.aom2.the_archetype_package;

import java.util.Objects;

import semanticdatabase.base.base_types.definitions_package.VersionStatus;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Human-readable structured identifier (HRID) for an archetype or template.
 */
public class ArchetypeHrid {

    //***** ArchetypeHrid *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reverse domain name namespace identifier.
     * cardinality: 0..1
     */
    private String namespace;

    /**
     * Name of the Reference Model publisher.
     * cardinality: 1..1
     */
    private String rmPublisher;

    /**
     * Name of the package in whose reachability graph the rm_class class is found (there can be more than one possibility in many reference models).
     * cardinality: 1..1
     */
    private String rmPackage;

    /**
     * Name of the root class of this archetype.
     * cardinality: 1..1
     */
    private String rmClass;

    /**
     * The short concept name of the archetype as used in the multi-axial archetype_hrid.
     * cardinality: 1..1
     */
    private String conceptId;

    /**
     * The full numeric version of this archetype consisting of 3 parts, e.g.
     * "1.8.2".
     * The archetype_hrid feature includes only the major version.
     * cardinality: 1..1
     */
    private String releaseVersion;

    /**
     * The status of the version, i.e.: released: (empty string) release_candidate: "rc" alpha: "alpha" beta: "beta"
     * cardinality: 1..1
     */
    private VersionStatus versionStatus;

    /**
     * The build count since last increment of any version part.
     * cardinality: 1..1
     */
    private String buildCount;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reverse domain name namespace identifier.
     * cardinality: 0..1
     */
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String value) {
        this.namespace = namespace;
    }

    /**
     * Name of the Reference Model publisher.
     * cardinality: 1..1
     */
    public String getRmPublisher() {
        return rmPublisher;
    }

    public void setRmPublisher(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmPublisher failed, it has cardinality NonNull, but is null");
        }
        this.rmPublisher = rmPublisher;
    }

    /**
     * Name of the package in whose reachability graph the rm_class class is found (there can be more than one possibility in many reference models).
     * cardinality: 1..1
     */
    public String getRmPackage() {
        return rmPackage;
    }

    public void setRmPackage(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmPackage failed, it has cardinality NonNull, but is null");
        }
        this.rmPackage = rmPackage;
    }

    /**
     * Name of the root class of this archetype.
     * cardinality: 1..1
     */
    public String getRmClass() {
        return rmClass;
    }

    public void setRmClass(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmClass failed, it has cardinality NonNull, but is null");
        }
        this.rmClass = rmClass;
    }

    /**
     * The short concept name of the archetype as used in the multi-axial archetype_hrid.
     * cardinality: 1..1
     */
    public String getConceptId() {
        return conceptId;
    }

    public void setConceptId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:conceptId failed, it has cardinality NonNull, but is null");
        }
        this.conceptId = conceptId;
    }

    /**
     * The full numeric version of this archetype consisting of 3 parts, e.g.
     * "1.8.2".
     * The archetype_hrid feature includes only the major version.
     * cardinality: 1..1
     */
    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:releaseVersion failed, it has cardinality NonNull, but is null");
        }
        this.releaseVersion = releaseVersion;
    }

    /**
     * The status of the version, i.e.: released: (empty string) release_candidate: "rc" alpha: "alpha" beta: "beta"
     * cardinality: 1..1
     */
    public VersionStatus getVersionStatus() {
        return versionStatus;
    }

    public void setVersionStatus(VersionStatus value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:versionStatus failed, it has cardinality NonNull, but is null");
        }
        this.versionStatus = versionStatus;
    }

    /**
     * The build count since last increment of any version part.
     * cardinality: 1..1
     */
    public String getBuildCount() {
        return buildCount;
    }

    public void setBuildCount(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:buildCount failed, it has cardinality NonNull, but is null");
        }
        this.buildCount = buildCount;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * The 'interface' form of the HRID, i.e.
     * down to the major version.
     * cardinality: 1..1
     */
    public String semanticId() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * The 'physical' form of the HRID, i.e.
     * with complete version information specified by version_id().
     * cardinality: 1..1
     */
    public String physicalId() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Full version identifier string, based on release_version, version_status, and build_count e.g.
     * "1.8.2-rc.4".
     * cardinality: 1..1
     */
    public String versionId() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Major version of this archetype, extracted from release_version.
     * cardinality: 1..1
     */
    public String majorVersion() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Minor version of this archetype, extracted from release_version.
     * cardinality: 1..1
     */
    public String minorVersion() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Patch version of this archetype, extracted from release_version.
     * Equivalent to patch version in patch version in semver.org sytem.
     * cardinality: 1..1
     */
    public String patchVersion() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ArchetypeHrid *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ArchetypeHrid() {
    }

    public ArchetypeHrid(
            String namespace,
            String rmPublisher,
            String rmPackage,
            String rmClass,
            String conceptId,
            String releaseVersion,
            VersionStatus versionStatus,
            String buildCount
    ) {
        if (rmPublisher == null) {
            throw new NullPointerException("Property:rmPublisher has cardinality NonNull, but is null");
        }
        if (rmPackage == null) {
            throw new NullPointerException("Property:rmPackage has cardinality NonNull, but is null");
        }
        if (rmClass == null) {
            throw new NullPointerException("Property:rmClass has cardinality NonNull, but is null");
        }
        if (conceptId == null) {
            throw new NullPointerException("Property:conceptId has cardinality NonNull, but is null");
        }
        if (releaseVersion == null) {
            throw new NullPointerException("Property:releaseVersion has cardinality NonNull, but is null");
        }
        if (versionStatus == null) {
            throw new NullPointerException("Property:versionStatus has cardinality NonNull, but is null");
        }
        if (buildCount == null) {
            throw new NullPointerException("Property:buildCount has cardinality NonNull, but is null");
        }
        this.namespace = namespace;
        this.rmPublisher = rmPublisher;
        this.rmPackage = rmPackage;
        this.rmClass = rmClass;
        this.conceptId = conceptId;
        this.releaseVersion = releaseVersion;
        this.versionStatus = versionStatus;
        this.buildCount = buildCount;
    }

    private ArchetypeHrid(Builder builder) {
        this.setNamespace(builder.namespace);
        this.setRmPublisher(builder.rmPublisher);
        this.setRmPackage(builder.rmPackage);
        this.setRmClass(builder.rmClass);
        this.setConceptId(builder.conceptId);
        this.setReleaseVersion(builder.releaseVersion);
        this.setVersionStatus(builder.versionStatus);
        this.setBuildCount(builder.buildCount);
    }

    public static class Builder {
        private String namespace;
        private final String rmPublisher;  //required
        private final String rmPackage;  //required
        private final String rmClass;  //required
        private final String conceptId;  //required
        private final String releaseVersion;  //required
        private final VersionStatus versionStatus;  //required
        private final String buildCount;  //required

        public Builder(
                String rmPublisher,
                String rmPackage,
                String rmClass,
                String conceptId,
                String releaseVersion,
                VersionStatus versionStatus,
                String buildCount
        ) {
            if (rmPublisher == null) {
                throw new NullPointerException("Property:rmPublisher has cardinality NonNull, but is null");
            }
            if (rmPackage == null) {
                throw new NullPointerException("Property:rmPackage has cardinality NonNull, but is null");
            }
            if (rmClass == null) {
                throw new NullPointerException("Property:rmClass has cardinality NonNull, but is null");
            }
            if (conceptId == null) {
                throw new NullPointerException("Property:conceptId has cardinality NonNull, but is null");
            }
            if (releaseVersion == null) {
                throw new NullPointerException("Property:releaseVersion has cardinality NonNull, but is null");
            }
            if (versionStatus == null) {
                throw new NullPointerException("Property:versionStatus has cardinality NonNull, but is null");
            }
            if (buildCount == null) {
                throw new NullPointerException("Property:buildCount has cardinality NonNull, but is null");
            }
            this.rmPublisher = rmPublisher;
            this.rmPackage = rmPackage;
            this.rmClass = rmClass;
            this.conceptId = conceptId;
            this.releaseVersion = releaseVersion;
            this.versionStatus = versionStatus;
            this.buildCount = buildCount;
        }

        public Builder setNamespace(String value) {
            this.namespace = namespace;
            return this;
        }

        public ArchetypeHrid build() {
            return new ArchetypeHrid(this);
        }
    }


    //***** ArchetypeHrid *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeHrid that = (ArchetypeHrid) object;
        return
                Objects.equals(namespace, that.namespace) &&
                        Objects.equals(rmPublisher, that.rmPublisher) &&
                        Objects.equals(rmPackage, that.rmPackage) &&
                        Objects.equals(rmClass, that.rmClass) &&
                        Objects.equals(conceptId, that.conceptId) &&
                        Objects.equals(releaseVersion, that.releaseVersion) &&
                        Objects.equals(versionStatus, that.versionStatus) &&
                        Objects.equals(buildCount, that.buildCount);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                namespace,
                rmPublisher,
                rmPackage,
                rmClass,
                conceptId,
                releaseVersion,
                versionStatus,
                buildCount
        );
    }

    @Override
    public String toString() {
        return
                "ArchetypeHrid {" +
                        "namespace='" + namespace + '\'' +
                        "rmPublisher='" + rmPublisher + '\'' +
                        "rmPackage='" + rmPackage + '\'' +
                        "rmClass='" + rmClass + '\'' +
                        "conceptId='" + conceptId + '\'' +
                        "releaseVersion='" + releaseVersion + '\'' +
                        "versionStatus='" + versionStatus + '\'' +
                        "buildCount='" + buildCount + '\'' +
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
