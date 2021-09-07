package nl.rosa.semanticdatabase.base.interval;

import nl.rosa.semanticdatabase.utils.interval.Interval;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Type representing an Interval that happens to be a point value.
 * Provides an efficient representation that is substitutable for Interval<T> where needed.
 */
public class PointInterval<T> extends Interval {

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Lower boundary open (i.e.
     * = -infinity).
     */
    private boolean lowerUnbounded = false;

    ;

    /**
     * Upper boundary open (i.e.
     * = +infinity).
     */
    private boolean upperUnbounded = false;

    ;

    /**
     * Lower boundary value included in range if not lower_unbounded.
     */
    private boolean lowerIncluded = true;

    /**
     * Upper boundary value included in range if not upper_unbounded.
     */
    private boolean upperIncluded = true;

    //***** PointInterval<t> *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/

    public PointInterval(boolean lowerUnbounded, boolean upperUnbounded, boolean lowerIncluded, boolean upperIncluded) {
        this.lowerUnbounded = lowerUnbounded;
        this.upperUnbounded = upperUnbounded;
        this.lowerIncluded = lowerIncluded;
        this.upperIncluded = upperIncluded;
    }

    public PointInterval(T value, boolean lowerUnbounded, boolean upperUnbounded, boolean lowerIncluded, boolean upperIncluded) {
        super(value);
        this.lowerUnbounded = lowerUnbounded;
        this.upperUnbounded = upperUnbounded;
        this.lowerIncluded = lowerIncluded;
        this.upperIncluded = upperIncluded;
    }

    public PointInterval(T lower, T upper, boolean lowerUnbounded, boolean upperUnbounded, boolean lowerIncluded, boolean upperIncluded) {
        super(lower, upper);
        this.lowerUnbounded = lowerUnbounded;
        this.upperUnbounded = upperUnbounded;
        this.lowerIncluded = lowerIncluded;
        this.upperIncluded = upperIncluded;
    }

    public PointInterval(T lower, T upper, boolean lowerIncluded, boolean upperIncluded, boolean lowerUnbounded, boolean upperUnbounded, boolean lowerIncluded1, boolean upperIncluded1) {
        super(lower, upper, lowerIncluded, upperIncluded);
        this.lowerUnbounded = lowerUnbounded;
        this.upperUnbounded = upperUnbounded;
        this.lowerIncluded = lowerIncluded1;
        this.upperIncluded = upperIncluded1;
    }

    //***** PointInterval<t> *****

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
                "PointInterval<t> {" +
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
