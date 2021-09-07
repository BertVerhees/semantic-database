package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */

/**
 * Countable quantities. Used for countable types such as pregnancies and steps (taken by a physiotherapy patient),
 * number of cigarettes smoked in a day.
 *
 * Misuse: Not to be used for amounts of physical entities (which all have units).
 */
public class DvCount extends DvAmount<DvCount> {

    private Long magnitude;

    public DvCount(Long magnitude) {
        this(null,
                null,
                null,
                null,
                null,
                null,
                null,
                magnitude);
    }

    public DvCount(
            List<ReferenceRange<DvCount>> otherReferenceRanges,
            DvInterval<DvCount> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus,
            Long magnitude) {
        super(
                otherReferenceRanges,
                normalRange,
                normalStatus,
                terminologyService,
                accuracy,
                accuracyIsPercent,
                magnitudeStatus);
        this.magnitude = magnitude;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param q
     * @return product of addition
     */
    @Override
    public DvQuantified<DvCount> add(DvQuantified q) {
        final DvCount c = (DvCount) q;
        return new DvCount(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getAccuracyIsPercent(),
                getMagnitudeStatus(),
                magnitude + c.magnitude);
    }

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param q
     * @return product of substration
     */
    @Override
    public DvQuantified<DvCount> subtract(DvQuantified q) {
        final DvCount c = (DvCount) q;
        return new DvCount(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getAccuracyIsPercent(),
                getMagnitudeStatus(),
                magnitude - c.magnitude);
    }

    /**
     * Product of this DV_COUNT and factor.
     * @param q
     * @return
     */
    public DvQuantified<DvCount> multiply(DvQuantified q) {
        final DvCount c = (DvCount) q;
        return new DvCount(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getAccuracyIsPercent(),
                getMagnitudeStatus(),
                magnitude * c.magnitude);
    }


    @Override
    public Long getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Long magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvCount> other) {
        return true;
    }

    @Override
    public Boolean lessThan(DvOrdered<DvCount> other) {
        DvCount o = (DvCount)other;
        return magnitude.compareTo(o.magnitude)<0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvCount dvCount = (DvCount) o;
        return Objects.equals(magnitude, dvCount.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(DvCount o) {
        return magnitude.compareTo(o.magnitude);
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