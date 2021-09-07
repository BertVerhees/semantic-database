package nl.rosa.semanticdatabase.base.interval;

import nl.rosa.semanticdatabase.utils.interval.MultiplicityInterval;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Express constraints on the cardinality of container objects which are the values of multiply-valued attributes, including uniqueness and ordering, providing the means to state that a container acts like a logical list, set or bag.
 */
public class Cardinality {

    //***** Cardinality *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The interval of this cardinality.
     * cardinality: 1..1
     */
    private MultiplicityInterval interval;

    /**
     * True if the members of the container attribute to which this cardinality refers are ordered.
     * cardinality: 1..1
     */
    private Boolean isOrdered;

    /**
     * True if the members of the container attribute to which this cardinality refers are unique.
     * cardinality: 1..1
     */
    private Boolean isUnique;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The interval of this cardinality.
     * cardinality: 1..1
     */
    public MultiplicityInterval getInterval() {
        return interval;
    }

    public void setInterval(MultiplicityInterval value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:interval failed, it has cardinality NonNull, but is null");
        }
        this.interval = interval;
    }

    /**
     * True if the members of the container attribute to which this cardinality refers are ordered.
     * cardinality: 1..1
     */
    public Boolean getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isOrdered failed, it has cardinality NonNull, but is null");
        }
        this.isOrdered = isOrdered;
    }

    /**
     * True if the members of the container attribute to which this cardinality refers are unique.
     * cardinality: 1..1
     */
    public Boolean getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isUnique failed, it has cardinality NonNull, but is null");
        }
        this.isUnique = isUnique;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if the semantics of this cardinality represent a bag, i.e.
     * unordered, non-unique membership.
     * cardinality: 1..1
     */
    public Boolean isBag() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if the semantics of this cardinality represent a list, i.e.
     * ordered, non-unique membership.
     * cardinality: 1..1
     */
    public Boolean isList() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if the semantics of this cardinality represent a set, i.e.
     * unordered, unique membership.
     * cardinality: 1..1
     */
    public Boolean isSet() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Cardinality *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Cardinality() {
    }

    public Cardinality(
            MultiplicityInterval interval,
            Boolean isOrdered,
            Boolean isUnique
    ) {
        if (interval == null) {
            throw new NullPointerException("Property:interval has cardinality NonNull, but is null");
        }
        if (isOrdered == null) {
            throw new NullPointerException("Property:isOrdered has cardinality NonNull, but is null");
        }
        if (isUnique == null) {
            throw new NullPointerException("Property:isUnique has cardinality NonNull, but is null");
        }
        this.interval = interval;
        this.isOrdered = isOrdered;
        this.isUnique = isUnique;
    }

    private Cardinality(Builder builder) {
        this.setInterval(builder.interval);
        this.setIsOrdered(builder.isOrdered);
        this.setIsUnique(builder.isUnique);
    }

    public static class Builder {
        private final MultiplicityInterval interval;  //required
        private final Boolean isOrdered;  //required
        private final Boolean isUnique;  //required

        public Builder(
                MultiplicityInterval interval,
                Boolean isOrdered,
                Boolean isUnique
        ) {
            if (interval == null) {
                throw new NullPointerException("Property:interval has cardinality NonNull, but is null");
            }
            if (isOrdered == null) {
                throw new NullPointerException("Property:isOrdered has cardinality NonNull, but is null");
            }
            if (isUnique == null) {
                throw new NullPointerException("Property:isUnique has cardinality NonNull, but is null");
            }
            this.interval = interval;
            this.isOrdered = isOrdered;
            this.isUnique = isUnique;
        }

        public Cardinality build() {
            return new Cardinality(this);
        }
    }


    //***** Cardinality *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Cardinality that = (Cardinality) object;
        return
                Objects.equals(interval, that.interval) &&
                        Objects.equals(isOrdered, that.isOrdered) &&
                        Objects.equals(isUnique, that.isUnique);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                interval,
                isOrdered,
                isUnique
        );
    }

    @Override
    public String toString() {
        return
                "Cardinality {" +
                        "interval='" + interval + '\'' +
                        "isOrdered='" + isOrdered + '\'' +
                        "isUnique='" + isUnique + '\'' +
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
