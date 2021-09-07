package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.*;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.utils.datetime.CombinedPeriodDuration;

import java.time.Duration;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

/**
 * TODO: magnitude of duration is not defined properly
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDuration
        extends DvAmount<DvDuration>{

    private CombinedPeriodDuration value;

    public DvDuration() {
        this(null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * Constructs a DvDuration form an Iso8601 Duration
     *
     * @param iso8601Duration
     */
    public DvDuration(String iso8601Duration) {

        this(null,
                null,
                null,
                null,
                null,
                null,
                null,
        parseDurationValue(iso8601Duration));
    }

    public static DvDuration getInstance(String iso8601Duration){
        return new DvDuration(iso8601Duration);
    }

    public DvDuration(CombinedPeriodDuration value) {

        this(null,
                null,
                null,
                null,
                null,
                null,
                null,
                value);
    }

    public DvDuration(
            List<ReferenceRange<DvDuration>> otherReferenceRanges,
            DvInterval<DvDuration> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus,
            CombinedPeriodDuration value) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, accuracy, accuracyIsPercent, magnitudeStatus);
        this.value = value;
    }

    public CombinedPeriodDuration getValue() {
        return value;
    }

    public void setValue(CombinedPeriodDuration value) {
        this.value = value;
    }

    // convert dvduration to seconds
    private double toDouble() {
        return Math
                .abs(value.getPeriod().getDays()*86400 + value.getDuration().getSeconds());
    }

    //Returns number of seconds of DvDuration
    @Override
    public Long getMagnitude() {
        Double d = toDouble();
        return d.longValue();
    }

    /**
     * Create a Duration from two instances of DvWorldTime
     *
     * @param start
     * @param end
     */
    public static DvDuration getDifference(DvDateTime start, DvDateTime end) {
        CombinedPeriodDuration d = CombinedPeriodDuration.between(
                start.getValue(), end.getValue());
        return new DvDuration(null, null, null, null, 0.0, false, null, d);
    }
    /**
     * Addition of a Duration to this DvDuration.
     * @param q
     * @return product of addition
     */
    @Override
    public DvQuantified<DvDuration> add(DvQuantified q) {
        CombinedPeriodDuration duration = ((DvDuration)q).getValue();
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getTerminologyService(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.plus(duration));
    }

    /**
     * Subtract a DvDuration from this DvDuration.
     * @param q
     * @return product of substration
     */
    @Override
    public DvQuantified<DvDuration> subtract(DvQuantified q) {
        CombinedPeriodDuration duration = ((DvDuration)q).getValue();
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getTerminologyService(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.minus(duration));
    }

    /**
     * Product of this Duration and factor.
     * @param q
     * @return
     */
    public DvQuantified<DvDuration> multiply(int q) {
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getTerminologyService(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.multipliedBy(q));
    }


    /**
     * Negated version of current duration.
     *
     * Assuming the current duration is positive, the negated version represents a time prior to some
     * origin point, or a negative age (e.g. so-called 'adjusted age' of premature infant).
     * @return
     */
    public DvDuration negative(){
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getTerminologyService(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.negated());
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    @Override
    public Boolean lessThan(DvOrdered<DvDuration> other){
        DvDuration o = (DvDuration)other;
        return value.compareTo(o.value)<0;
    }
    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvDuration> other) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvDuration that = (DvDuration) o;

        return Objects.equals(value, that.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
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
    public int compareTo(DvDuration o) {
        return value.compareTo(o.value);
    }

    /**
     * number of years of nominal 365-day length
     *
     * @return years
     */
    public int getYears() {
        return value.getPeriod().getYears();
    }

    /**
     * number of months of nominal 30 day length
     *
     * @return months
     */
    public int getMonths() {
        return value.getPeriod().getMonths();
    }

    public int getWeeks() {
        return (Double.valueOf(Math.floor(value.getPeriod().getDays()/7))).intValue();
    }

    /**
     * number of 24 hour days
     *
     * @return days
     */
    public long getDays() {
        return (Double.valueOf(Math.floor(value.getDuration().getSeconds()/86400))).longValue() + value.getPeriod().getDays();
    }

    /**
     * number of 60 minute hours
     *
     * @return hours
     */
    public Long getHours() {
        Double d = Math.floor(getMinutes()/60);
        return d.longValue();
    }

    /**
     * number of 60 second minutes
     *
     * @return minutes
     */
    public Long getMinutes() {
        Double d = Math.floor(getSeconds()/60);
        return d.longValue();
    }

    /**
     * number of seconds
     *
     * @return seconds
     */
    public Long getSeconds() {
        return value.getDuration().getSeconds();
    }

    /**
     * fractional seconds
     *
     * @return fractional seconds
     */
    public double getFractionalSeconds() {
        return value.getDuration().getNano() / 10E9;
    }

    private static CombinedPeriodDuration parseDurationValue(String text) {
        try {
            if (text.startsWith("PT") || text.startsWith("-PT")) {
                Duration duration = Duration.parse(text);
            }else if (text.contains("T")) {
                return CombinedPeriodDuration.parse(text);
            } else {
                return Period.parse(text);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage() + ":" + text);
        }
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