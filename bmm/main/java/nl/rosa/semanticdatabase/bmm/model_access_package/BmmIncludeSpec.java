package nl.rosa.semanticdatabase.bmm.model_access_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Schema inclusion structure.
 */
public class BmmIncludeSpec {

    //***** BmmIncludeSpec *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Full identifier of the included schema, e.g.
     * "openehr_primitive_types_1.0.2".
     * cardinality: 1..1
     */
    private String id;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Full identifier of the included schema, e.g.
     * "openehr_primitive_types_1.0.2".
     * cardinality: 1..1
     */
    public String getId() {
        return id;
    }

    public void setId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:id failed, it has cardinality NonNull, but is null");
        }
        this.id = id;
    }

    //***** BmmIncludeSpec *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmIncludeSpec() {
    }

    public BmmIncludeSpec(
            String id
    ) {
        if (id == null) {
            throw new NullPointerException("Property:id has cardinality NonNull, but is null");
        }
        this.id = id;
    }

    private BmmIncludeSpec(Builder builder) {
        this.setId(builder.id);
    }

    public static class Builder {
        private final String id;  //required

        public Builder(
                String id
        ) {
            if (id == null) {
                throw new NullPointerException("Property:id has cardinality NonNull, but is null");
            }
            this.id = id;
        }

        public BmmIncludeSpec build() {
            return new BmmIncludeSpec(this);
        }
    }


    //***** BmmIncludeSpec *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmIncludeSpec that = (BmmIncludeSpec) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/model_access_package/BmmIncludeSpec.java
                Objects.equals(id, that.id);
=======
                java.util.Objects.equals(id, that.id);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/model_access_package/BmmIncludeSpec.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                id
        );
    }

    @Override
    public String toString() {
        return
                "BmmIncludeSpec {" +
                        "id='" + id + '\'' +
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
