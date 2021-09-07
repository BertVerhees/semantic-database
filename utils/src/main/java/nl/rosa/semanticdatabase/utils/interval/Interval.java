package nl.rosa.semanticdatabase.utils.interval;

import java.time.temporal.TemporalAmount;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Interval abstraction, featuring upper and lower limits that may be open or closed, included or not included.
 * Interval of ordered items.
 */
public class Interval<T> {

    //***** Interval<t> *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Lower bound.
     * lower bound.
     * cardinality: 0..1
     */
    private T lower;

    /**
     * Upper bound.
     * Upper bound.
     * cardinality: 0..1
     */
    private T upper;

    /**
     * lower boundary open (i.e.
     * = -infinity).
     * lower boundary open (i.e.
     * = -infinity)
     * cardinality: 1..1
     */
    private boolean lowerUnbounded = false;

    /**
     * upper boundary open (i.e.
     * = +infinity).
     * upper boundary open (i.e.
     * = +infinity)
     * cardinality: 1..1
     */
    private boolean upperUnbounded = false;

    /**
     * lower boundary value included in range if not lower_unbounded.
     * lower boundary value included in range if not lower_unbounded.
     * cardinality: 1..1
     */
    private boolean lowerIncluded = true;

    /**
     * upper boundary value included in range if not upper_unbounded.
     * upper boundary value included in range if not upper_unbounded.
     * cardinality: 1..1
     */
    private boolean upperIncluded = true;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Lower bound.
     * lower bound.
     * cardinality: 0..1
     * <p>
     * Limits_consistent: (not upper_unbounded and not lower_unbounded) implies lower <= upper
     */
    public T getLower() {
        return lower;
    }

    public void setLower(T value) {
        this.lower = lower;
    }

    /**
     * Upper bound.
     * Upper bound.
     * cardinality: 0..1
     * <p>
     * Limits_consistent: (not upper_unbounded and not lower_unbounded) implies lower <= upper
     */
    public T getUpper() {
        return upper;
    }

    public void setUpper(T value) {
        this.upper = upper;
    }

    /**
     * lower boundary open (i.e.
     * = -infinity).
     * lower boundary open (i.e.
     * = -infinity)
     * cardinality: 1..1
     */
    public Boolean isLowerUnbounded() {
        return lowerUnbounded;
    }

    public void setLowerUnbounded(Boolean value) {
        this.lowerUnbounded = lowerUnbounded;
    }

    /**
     * upper boundary open (i.e.
     * = +infinity).
     * upper boundary open (i.e.
     * = +infinity)
     * cardinality: 1..1
     */
    public boolean isUpperUnbounded() {
        return upperUnbounded;
    }

    public void setUpperUnbounded(boolean value) {
        this.upperUnbounded = value;
    }

    /**
     * lower boundary value included in range if not lower_unbounded.
     * lower boundary value included in range if not lower_unbounded.
     * cardinality: 1..1
     * <p>
     * Lower_included_valid: lower_unbounded implies not lower_included
     */
    public boolean isLowerIncluded() {
        return lowerIncluded;
    }

    public void setLowerIncluded(boolean value) {
        this.lowerIncluded = value;
    }

    /**
     * upper boundary value included in range if not upper_unbounded.
     * upper boundary value included in range if not upper_unbounded.
     * cardinality: 1..1
     * <p>
     * Upper_included_valid: upper_unbounded implies not upper_included
     */
    public Boolean isUpperIncluded() {
        return upperIncluded;
    }

    public void setUpperIncluded(Boolean value) {
        this.upperIncluded = upperIncluded;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    public static <T> Interval<T> lowerUnbounded(T upper, boolean upperIncluded) {
        Interval<T> result = new Interval<>(null, upper, false, upperIncluded);
        result.setLowerUnbounded(true);
        return result;
    }

    public static <T> Interval<T> upperUnbounded(T lower, boolean lowerIncluded) {
        Interval<T> result = new Interval<>(lower, null, lowerIncluded, false);
        result.setUpperUnbounded(true);
        return result;
    }

    /**
     * True if the value e is properly contained in this Interval.
     * True if (lower_unbounded or lower_included and v >= lower) or v > lower and (upper_unbounded or upper_included and v <= upper or v < upper)
     * cardinality: 1..1 (abstract)
     * <p>
     * Post_result: Result = (lower_unbounded or lower_included and v >= lower) or v > lower and (upper_unbounded or upper_included and v <= upper or v < upper)
     */
    public boolean has(T value) {
        if (lowerUnbounded && upperUnbounded) {
            return true;
        }
        //since TemporalAmount does not implement Comparable we have to do some magic here
        Comparable comparableValue;
        Comparable comparableLower;
        Comparable comparableUpper;
        if (value instanceof TemporalAmount && lower instanceof TemporalAmount && upper instanceof TemporalAmount) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            comparableValue = toComparable(value);
            comparableLower = toComparable(lower);
            comparableUpper = toComparable(upper);
        } else if (!(isComparable(lower) && isComparable(upper) && isComparable(value))) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            comparableValue = (Comparable) value;
            comparableLower = (Comparable) lower;
            comparableUpper = (Comparable) upper;
        }

        if (value == null) {
            //interval values are not concerned with cardinality, so return true if not set
            return true;
        }

        if (!lowerUnbounded) {
            int comparedWithLower = comparableValue.compareTo(comparableLower);
            if (comparedWithLower < 0 || (!lowerIncluded && comparedWithLower == 0)) {
                return false;
            }
        }

        if (!upperUnbounded) {
            int comparedWithUpper = comparableValue.compareTo(comparableUpper);
            if (comparedWithUpper > 0 || (!upperIncluded && comparedWithUpper == 0)) {
                return false;
            }
        }
        return true;
    }

    private Comparable toComparable(T value) {
        if (value == null) {
            return null;
        }
        if (value instanceof TemporalAmount && !(value instanceof Comparable) && isNonComparableTemporalAmount(value)) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            return IntervalDurationConverter.from((TemporalAmount) value);

        } else if (!isComparable(value)) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            return (Comparable) value;
        }
    }

    private int compareTo(T intervalValue, T value) {
        Comparable comparableIntervalValue;
        Comparable comparableValue;
        if (value instanceof TemporalAmount && !(value instanceof Comparable) && isNonComparableTemporalAmount(intervalValue)) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            comparableValue = value == null ? null : IntervalDurationConverter.from((TemporalAmount) value);
            comparableIntervalValue = intervalValue == null ? null : IntervalDurationConverter.from((TemporalAmount) intervalValue);
        } else if (!(isComparable(intervalValue) && isComparable(value))) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            comparableValue = (Comparable) value;
            comparableIntervalValue = (Comparable) intervalValue;
        }
        return comparableValue.compareTo(comparableIntervalValue);
    }


    private boolean isComparable(T value) {
        return value == null || value instanceof Comparable;
    }

    private boolean isNonComparableTemporalAmount(T value) {
        return value == null || (!(value instanceof Comparable) && value instanceof TemporalAmount);
    }


    /**
     * True if there is any overlap between intervals represented by Current and other.
     * True if at least one limit of other is strictly inside the limits of this interval.
     * cardinality: 1..1 (abstract)
     */
    public Boolean intersects(Interval<T> other) {
        return (lowerUnbounded && other.lowerUnbounded) ||
                (upperUnbounded && other.upperUnbounded) ||
                (compareTo(lower, other.lower) < 0 && compareTo(upper, other.upper) < 0 && compareTo(other.lower, upper) < 0) ||
                (compareTo(other.lower, lower) < 0 && compareTo(other.upper, upper) < 0 && compareTo(lower, other.upper) < 0) ||
                other.contains(this) || this.contains(other);
    }

    /**
     * True if current interval properly contains other? True if all points of other are inside the current interval.
     * cardinality: 1..1 (abstract)
     */
    public Boolean contains(Interval<T> other) {
        boolean otherHasLower = false;
        boolean otherHasUpper = false;
        if (other.lowerUnbounded) {
            otherHasLower = this.lowerUnbounded;
        } else {
            otherHasLower = has(other.lower);
        }
        if (other.upperUnbounded) {
            otherHasUpper = this.upperUnbounded;
        } else {
            otherHasUpper = has(other.upper);
        }
        return otherHasLower && otherHasUpper;
    }

    public void fixUnboundedIncluded() {
        if (upperUnbounded) {
            this.upperIncluded = false;
        }
        if (lowerUnbounded) {
            this.lowerIncluded = false;
        }
    }

    /**
     * Returns true if both sets subsume each other.
     *
     * @param other
     * @return
     */
    public Boolean setsAreEqual(Interval<T> other) {
        return this.contains(other) && other.contains(this);
    }

    //***** Interval<t> *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/

    public Interval() {

    }

    public Interval(T value) {
        this(value, value);
    }

    public Interval(T lower, T upper) {
        this(lower, upper, true, true);
    }

    public Interval(T lower, T upper, boolean lowerIncluded, boolean upperIncluded) {
        this.lower = lower;
        this.upper = upper;
        this.lowerIncluded = lowerIncluded;
        this.upperIncluded = upperIncluded;

        if (upper == null) {
            this.upperUnbounded = true;
            this.upperIncluded = false;
        }
        if (lower == null) {
            this.lowerUnbounded = true;
            this.lowerIncluded = false;
        }

    }


    //***** Interval<t> *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Interval<?> that = (Interval<?>) object;
        return
                Objects.equals(lower, that.lower) &&
                        Objects.equals(upper, that.upper) &&
                        Objects.equals(lowerUnbounded, that.lowerUnbounded) &&
                        Objects.equals(upperUnbounded, that.upperUnbounded) &&
                        Objects.equals(lowerIncluded, that.lowerIncluded) &&
                        Objects.equals(upperIncluded, that.upperIncluded);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                lower,
                upper,
                lowerUnbounded,
                upperUnbounded,
                lowerIncluded,
                upperIncluded
        );
    }

    @Override
    public String toString() {
        return
                "Interval<T> {" +
                        "lower='" + lower + '\'' +
                        "upper='" + upper + '\'' +
                        "lowerUnbounded='" + lowerUnbounded + '\'' +
                        "upperUnbounded='" + upperUnbounded + '\'' +
                        "lowerIncluded='" + lowerIncluded + '\'' +
                        "upperIncluded='" + upperIncluded + '\'' +
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
