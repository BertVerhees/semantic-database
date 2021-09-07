package nl.rosa.semanticdatabase.bmm.classes;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of a range-constrained class whose value range is defined by reference to a 'value set' within an external resource, e.g.
 * a reference data service.
 */
public class BmmValueSetSpec {

    //***** BmmValueSetSpec *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
     * This is typically a URI but need not be.
     * cardinality: 1..1
     */
    private String resourceId;

    /**
     * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
     * This might be a URI, but need not be.
     * cardinality: 1..1
     */
    private String valueSetId;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
     * This is typically a URI but need not be.
     * cardinality: 1..1
     */
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:resourceId failed, it has cardinality NonNull, but is null");
        }
        this.resourceId = resourceId;
    }

    /**
     * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
     * This might be a URI, but need not be.
     * cardinality: 1..1
     */
    public String getValueSetId() {
        return valueSetId;
    }

    public void setValueSetId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:valueSetId failed, it has cardinality NonNull, but is null");
        }
        this.valueSetId = valueSetId;
    }

    //***** BmmValueSetSpec *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmValueSetSpec() {
    }

    public BmmValueSetSpec(
            String resourceId,
            String valueSetId
    ) {
        if (resourceId == null) {
            throw new NullPointerException("Property:resourceId has cardinality NonNull, but is null");
        }
        if (valueSetId == null) {
            throw new NullPointerException("Property:valueSetId has cardinality NonNull, but is null");
        }
        this.resourceId = resourceId;
        this.valueSetId = valueSetId;
    }

    private BmmValueSetSpec(Builder builder) {
        this.setResourceId(builder.resourceId);
        this.setValueSetId(builder.valueSetId);
    }

    public static class Builder {
        private final String resourceId;  //required
        private final String valueSetId;  //required

        public Builder(
                String resourceId,
                String valueSetId
        ) {
            if (resourceId == null) {
                throw new NullPointerException("Property:resourceId has cardinality NonNull, but is null");
            }
            if (valueSetId == null) {
                throw new NullPointerException("Property:valueSetId has cardinality NonNull, but is null");
            }
            this.resourceId = resourceId;
            this.valueSetId = valueSetId;
        }

        public BmmValueSetSpec build() {
            return new BmmValueSetSpec(this);
        }
    }


    //***** BmmValueSetSpec *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmValueSetSpec that = (BmmValueSetSpec) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmValueSetSpec.java
                Objects.equals(resourceId, that.resourceId) &&
                        Objects.equals(valueSetId, that.valueSetId);
=======
                java.util.Objects.equals(resourceId, that.resourceId) &&
                        java.util.Objects.equals(valueSetId, that.valueSetId);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/classes/BmmValueSetSpec.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                resourceId,
                valueSetId
        );
    }

    @Override
    public String toString() {
        return
                "BmmValueSetSpec {" +
                        "resourceId='" + resourceId + '\'' +
                        "valueSetId='" + valueSetId + '\'' +
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
