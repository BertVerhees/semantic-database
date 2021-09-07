package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.List;
import java.util.Objects;

/**
 * TODO: This does not implement PROPORTION KIND, because multiple inheritance - won't work.
 * It does have a type=proportion kind enum
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvProportion extends DvAmount<DvProportion> {

    private Double numerator;
    private Double denominator;
    private ProportionKind type;
    
    private Long precision;

    public DvProportion() {
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvProportion> other) {
        return type .equals (((DvProportion) other).type);
    }

    @Override
    public Boolean lessThan(DvOrdered<DvProportion> other) {
        return null;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    @Override
    public DvQuantified<DvProportion> add(DvQuantified s) {
        return null;
    }

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    @Override
    public DvQuantified<DvProportion> subtract(DvQuantified s) {
        return null;
    }

    public DvProportion(
            List<ReferenceRange<DvProportion>> otherReferenceRanges,
            DvInterval<DvProportion> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            Double accuracy,
            Boolean accuracyPercent,
            String magnitudeStatus,
            Double numerator,
            Double denominator,
            ProportionKind type,
            Long precision) {

        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, accuracy,
                accuracyPercent, magnitudeStatus);

        if(type == null) {
            throw new IllegalArgumentException("null type");
        } else if(type == ProportionKind.UNITARY) {
            if(denominator != 1) {
                throw new IllegalArgumentException(
                        "denominator for unitary proportion must be 1");
            }
        } else if(type == ProportionKind.PERCENT) {
            if(denominator != 100) {
                throw new IllegalArgumentException(
                        "denominator for unitary proportion must be 100");
            }
        } else if(type == ProportionKind.FRACTION ||
                type == ProportionKind.INTEGER_FRACTION) {

            if(! bothIntegral(numerator, denominator)) {
                throw new IllegalArgumentException(
                        "both numberator and denominator must be integral for " +
                                "fraction or integer fraction proportion");
            }
        }

        if(bothIntegral(numerator, denominator)
                && (precision != null && precision != 0)) {
            throw new IllegalArgumentException("precision must be 0 if both " +
                    "numerator and denominator are integral");
        }
        if( !bothIntegral(numerator, denominator)
                && (precision != null && precision == 0)) {
            throw new IllegalArgumentException("zero precision for " +
                    "non-integral numerator or denominator");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        this.type = type;
        this.precision = precision;
    }

    private boolean bothIntegral(double num1, double num2) {
        return (Math.floor(num1) == num1) && (Math.floor(num2) == num2);
    }


    /**
     * Creates a simple DvProportion
     */
    public DvProportion(double numerator, double denominator,
                        ProportionKind type, Long precision) {
        this(null,
                null,
                null,
                null,
                0.0,
                false,
                null,
                numerator,
                denominator,
                type,
                precision);
    }

    /**
     * Create a unitary proportion
     *
     * @param numerator
     * @param precision
     * @return
     */
    public static DvProportion createUnitaryProportion(double numerator,
                                                       Long precision) {
        return new DvProportion(numerator, 1.0, ProportionKind.UNITARY, precision);
    }


    public Double getNumerator() {
        return numerator;
    }

    public void setNumerator(Double numerator) {
        this.numerator = numerator;
    }


    public Double getDenominator() {
        return denominator;
    }

    public void setDenominator(Double denominator) {
        this.denominator = denominator;
    }

    public ProportionKind getType() {
        return type;
    }

    public void setType(ProportionKind type) {
        this.type = type;
    }

    
    public Long getPrecision() {
        return precision;
    }

    public void setPrecision( Long precision) {
        this.precision = precision;
    }

    public boolean isIntegral() {
        return precision != null && precision == 0;
    }

    @Override
    public Double getMagnitude() {
        if (numerator != null && denominator != null && denominator != 0.0d) {
            return numerator / denominator;
        } else if (numerator == null) {
            return 0.0;
        } else {
            return Double.MAX_VALUE;//TODO: actually: infinity. Max Double value?
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvProportion that = (DvProportion) o;
        return Objects.equals(numerator, that.numerator) &&
                Objects.equals(denominator, that.denominator) &&
                Objects.equals(type, that.type) &&
                Objects.equals(precision, that.precision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numerator, denominator, type, precision);
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
    public int compareTo(DvProportion p) {
        if (getDenominator()==0 || p.getDenominator()==0){
            throw new IllegalArgumentException("Cannot compare proportions with denominator==0");
        }
        Double result = (getNumerator()/getDenominator());
        Double resultB = (p.getNumerator()/p.getDenominator());
        return result.compareTo(resultB);
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