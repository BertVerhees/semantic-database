package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;


/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Defines the order indicator that can be used on a C_OBJECT within a container attribute in a specialised archetype to indicate its order with respect to a sibling defined in a higher specialisation level.
 * Misuse: This type cannot be used on a C_OBJECT other than one within a container attribute in a specialised archetype.
 */
public class SiblingOrder {

    //***** SiblingOrder *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * True if the order relationship is ‘before’, if False, it is ‘after’.
     * cardinality: 1..1
     */
    private Boolean isBefore;

    /**
     * Node identifier of sibling before or after which this node should come.
     * cardinality: 1..1
     */
    private String siblingNodeId;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * True if the order relationship is ‘before’, if False, it is ‘after’.
     * cardinality: 1..1
     */

    public Boolean isBefore() {
        return isBefore;
    }

    public void setBefore(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isBefore failed, it has cardinality NonNull, but is null");
        }
        this.isBefore = isBefore;
    }

    /**
     * Node identifier of sibling before or after which this node should come.
     * cardinality: 1..1
     */
    public String getSiblingNodeId() {
        return siblingNodeId;
    }

    public void setSiblingNodeId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:siblingNodeId failed, it has cardinality NonNull, but is null");
        }
        this.siblingNodeId = siblingNodeId;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if the order relationship is after, computed as the negation of is_before.
     * cardinality: 1..1
     */
    public Boolean isAfter() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** SiblingOrder *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected SiblingOrder() {
    }

    public SiblingOrder(
            Boolean isBefore,
            String siblingNodeId
    ) {
        if (isBefore == null) {
            throw new NullPointerException("Property:isBefore has cardinality NonNull, but is null");
        }
        if (siblingNodeId == null) {
            throw new NullPointerException("Property:siblingNodeId has cardinality NonNull, but is null");
        }
        this.isBefore = isBefore;
        this.siblingNodeId = siblingNodeId;
    }

    private SiblingOrder(Builder builder) {
        this.setBefore(builder.isBefore);
        this.setSiblingNodeId(builder.siblingNodeId);
    }

    public static class Builder {
        private final Boolean isBefore;  //required
        private final String siblingNodeId;  //required

        public Builder(
                Boolean isBefore,
                String siblingNodeId
        ) {
            if (isBefore == null) {
                throw new NullPointerException("Property:isBefore has cardinality NonNull, but is null");
            }
            if (siblingNodeId == null) {
                throw new NullPointerException("Property:siblingNodeId has cardinality NonNull, but is null");
            }
            this.isBefore = isBefore;
            this.siblingNodeId = siblingNodeId;
        }

        public SiblingOrder build() {
            return new SiblingOrder(this);
        }
    }


    //***** SiblingOrder *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SiblingOrder that = (SiblingOrder) object;
        return
                Objects.equals(isBefore, that.isBefore) &&
                        Objects.equals(siblingNodeId, that.siblingNodeId);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                isBefore,
                siblingNodeId
        );
    }

    @Override
    public String toString() {
        return
                "SiblingOrder {" +
                        "isBefore='" + isBefore + '\'' +
                        "siblingNodeId='" + siblingNodeId + '\'' +
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
