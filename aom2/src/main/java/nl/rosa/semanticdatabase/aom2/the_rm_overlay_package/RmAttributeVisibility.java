package nl.rosa.semanticdatabase.aom2.the_rm_overlay_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.terminology_package.TerminologyCode;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of visibility of an RM attribute within a larger archetype structure.
 */
public class RmAttributeVisibility {

    //***** RmAttributeVisibility *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Visibility setting of a non-archetyped RM attribute (RM attributes that are constrained or within the archetyped structure are visible by default).
     * cardinality: 0..1
     */
    private VisibilityType visibility;

    /**
     * Optional alias for the attribute referenced by the path.
     * cardinality: 0..1
     */
    private TerminologyCode alias;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Visibility setting of a non-archetyped RM attribute (RM attributes that are constrained or within the archetyped structure are visible by default).
     * cardinality: 0..1
     */
    public VisibilityType getVisibility() {
        return visibility;
    }

    public void setVisibility(VisibilityType value) {
        this.visibility = visibility;
    }

    /**
     * Optional alias for the attribute referenced by the path.
     * cardinality: 0..1
     */
    public TerminologyCode getAlias() {
        return alias;
    }

    public void setAlias(TerminologyCode value) {
        this.alias = alias;
    }

    //***** RmAttributeVisibility *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected RmAttributeVisibility() {
    }

    public RmAttributeVisibility(
            VisibilityType visibility,
            TerminologyCode alias
    ) {
        this.visibility = visibility;
        this.alias = alias;
    }

    private RmAttributeVisibility(Builder builder) {
        this.setVisibility(builder.visibility);
        this.setAlias(builder.alias);
    }

    public static class Builder {
        private VisibilityType visibility;
        private TerminologyCode alias;

        public Builder(
        ) {
        }

        public Builder setVisibility(VisibilityType value) {
            this.visibility = visibility;
            return this;
        }

        public Builder setAlias(TerminologyCode value) {
            this.alias = alias;
            return this;
        }

        public RmAttributeVisibility build() {
            return new RmAttributeVisibility(this);
        }
    }


    //***** RmAttributeVisibility *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RmAttributeVisibility that = (RmAttributeVisibility) object;
        return
                Objects.equals(visibility, that.visibility) &&
                        Objects.equals(alias, that.alias);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                visibility,
                alias
        );
    }

    @Override
    public String toString() {
        return
                "RmAttributeVisibility {" +
                        "visibility='" + visibility + '\'' +
                        "alias='" + alias + '\'' +
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
