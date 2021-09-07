package nl.rosa.semanticdatabase.utils.interval;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * An Interval of Integer, used to represent multiplicity, cardinality and optionality in models.
 */
public class MultiplicityInterval extends Interval<Integer> {

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/
    public static MultiplicityInterval createFromString(String interval) {
        Pattern pattern = Pattern.compile("(?<lower>[0-9]+)\\.\\.(?<upper>[0-9]+|\\*)");
        Matcher matcher = pattern.matcher(interval);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Cannot parse interval " + interval);
        }
        String lower = matcher.group("lower");
        String upper = matcher.group("upper");
        MultiplicityInterval result = new MultiplicityInterval();
        if (upper.equalsIgnoreCase("*")) {
            result.setUpperUnbounded(true);
        } else {
            result.setUpper(Integer.parseInt(upper));
        }
        result.setLower(Integer.parseInt(lower));
        return result;
    }

    /**
     * Equal to '0..*' or '*'
     *
     * @return a new unbounded multiplicity interval
     */
    public static MultiplicityInterval unbounded() {
        MultiplicityInterval result = new MultiplicityInterval();
        result.setLower(0);
        result.setUpperUnbounded(true);
        return result;
    }

    /**
     * Creates interval of type [0,inf)
     *
     * @return the created interval
     */
    public static MultiplicityInterval createOpen() {
        return new MultiplicityInterval(0, true, false, null, true, true);
    }

    /**
     * Creates interval of type [0,1]
     *
     * @return the created interval
     */
    public static MultiplicityInterval createOptional() {
        return new MultiplicityInterval(0, true, false, 1, true, false);
    }

    /**
     * Creates interval of type [1,1]
     *
     * @return the created interval
     */
    public static MultiplicityInterval createMandatory() {
        return new MultiplicityInterval(1, true, false, 1, true, false);
    }

    /**
     * Creates interval of type [0,1]
     *
     * @return the created interval
     */
    public static MultiplicityInterval createProhibited() {
        return new MultiplicityInterval(0, true, false, 0, true, false);
    }

    public static MultiplicityInterval createUpperUnbounded(Integer lower) {
        return new MultiplicityInterval(lower, true, false, null, true, true);
    }

    public static MultiplicityInterval createBounded(int lower, int upper) {
        return new MultiplicityInterval(lower, true, false, upper, true, false);
    }


    /**
     * True if this interval imposes no constraints, i.e.
     * is set to 0..*.
     * cardinality: 1..1
     */
    public boolean getOpen() {
        boolean result = Integer.valueOf(0).equals(getLower()) && isUpperUnbounded() && isLowerIncluded();
        return result;
    }

    public static MultiplicityInterval open() {
        return new MultiplicityInterval(0, true, false, null, true, true);
    }

    /**
     * True if this interval expresses optionality, i.e.
     * 0..1.
     * cardinality: 1..1
     */
    public boolean getOptional() {
        boolean result = Integer.valueOf(0).equals(getLower()) && Integer.valueOf(1).equals(getUpper()) && !isUpperUnbounded() && isLowerIncluded() && isUpperIncluded();
        return result;
    }

    public static MultiplicityInterval optional() {
        return new MultiplicityInterval(0, true, false, 1, true, false);
    }

    /**
     * True if this interval expresses mandation, i.e.
     * 1..1.
     * cardinality: 1..1
     */
    public boolean isMandatory() {
        boolean result = !isLowerUnbounded() && getLower() >= 1;
        return result;
    }

    public static MultiplicityInterval mandatory() {
        return new MultiplicityInterval(1, true, false, 1, true, false);
    }

    /**
     * True if this interval is set to 0..0.
     * cardinality: 1..1
     */
    public boolean isProhibited() {
        boolean result = Integer.valueOf(0).equals(getLower()) && Integer.valueOf(0).equals(getUpper()) && !isUpperUnbounded();
        return result;
    }

    public static MultiplicityInterval prohibited() {
        return new MultiplicityInterval(0, true, false, 0, true, false);
    }

    public static MultiplicityInterval upperUnbounded(Integer lower) {
        return new MultiplicityInterval(lower, true, false, null, true, true);
    }

    public static MultiplicityInterval bounded(int lower, int upper) {
        return new MultiplicityInterval(lower, true, false, upper, true, false);
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Marker to use in string form of interval between limits.
     */
    public static final String MULTIPLICITY_RANGE_MARKER = "..";
    /**
     * Symbol to use to indicate upper limit unbounded.
     */
    public static final Character MULTIPLICITY_UNBOUNDED_MARKER = '*';

    //***** MultiplicityInterval *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public MultiplicityInterval() {
        super();
    }

    public MultiplicityInterval(int lower, int upper) {
        super(lower, upper);
    }

    public MultiplicityInterval(Interval<Integer> interval) {
        this(interval.getLower(), interval.isLowerIncluded(), interval.isLowerUnbounded(), interval.getUpper(), interval.isUpperIncluded(), interval.isUpperUnbounded());
    }

    public MultiplicityInterval(Integer lower, boolean lowerIncluded, boolean lowerUnbounded, Integer upper, boolean upperIncluded, boolean upperUnbounded) {
        setLower(lower);
        setLowerIncluded(lowerIncluded);
        setLowerUnbounded(lowerUnbounded);
        setUpper(upper);
        setUpperIncluded(upperIncluded);
        setUpperUnbounded(upperUnbounded);
    }
    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "MultiplicityInterval {" +
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
