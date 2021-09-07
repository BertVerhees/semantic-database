package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvOrdered;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.utils.datetime.CombinedPeriodDuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers.*;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvDate
        extends DvTemporal<DvDate> {

    private LocalDate value;

    public DvDate(LocalDate value) {
        super(null,
                null,
                null,
                null,
                null,
                null);
        setValue(value);
    }

    /**
     * Constructs a DvDate from an ISO 8601 Date String
     *
     * @param iso8601Date
     */
    public DvDate(String iso8601Date) {
        super(null,
                null,
                null,
                null,
                null,
                null);
        setValue(parseDateValue(iso8601Date));
    }

    public DvDate(
            List<ReferenceRange<DvDate>> otherReferenceRanges,
            DvInterval<DvDate> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalDate value) {
        super(otherReferenceRanges, 
                normalRange, 
                normalStatus, 
                terminologyService,
                accuracy, 
                magnitudeStatus);
        this.value = value;
    }


    /**
     * Addition of a Duration to this DvDate.
     * @param q
     * @return product of addition
     */
    @Override
    public DvDate add(DvDuration q) {
        LocalDate date = getValue();
        CombinedPeriodDuration duration = q.getValue();
        return new DvDate(getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getMagnitudeStatus(),
                date.plus(duration));
    }

    /**
     * Subtract a Duration from this DvDateDate.
     * @param q
     * @return product of substration
     */
    @Override
    public DvDate subtract(DvDuration q) {
        LocalDate date = getValue();
        CombinedPeriodDuration duration = q.getValue();
        return new DvDate(getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getMagnitudeStatus(),
                date.minus(duration));
    }

    /**
     * Difference between this DvDate and other.
     *
     * @param other
     * @return diff type
     */
    @Override
    public DvDuration diff(DvDate other) {
        LocalDate date = getValue();
        CombinedPeriodDuration duration =
                CombinedPeriodDuration.between(date, other.getValue());
        return new DvDuration(duration);
    }
    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(LocalDate other){
        return value.compareTo(value.from(other))<0;
    }

    public LocalDate getValue() {
        return value;
    }

    public void setValue(LocalDate value) {
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        return value.toEpochDay();
    }

    public void setMagnitude(Long magnitude) {
        value = LocalDate.ofEpochDay(magnitude);
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvDate> other) {
        return other instanceof DvDate;
    }

    @Override
    public Boolean lessThan(DvOrdered<DvDate> other) {
            DvDate o = (DvDate) other;
            return value.compareTo(value.from(o.value))<0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvDate dvDate = (DvDate) o;
        return Objects.equals(getValue(), dvDate.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValue());
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
    public int compareTo(DvDate o) {
        return value.compareTo(value.from(o.value));
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