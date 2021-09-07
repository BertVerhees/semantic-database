package nl.rosa.semanticdatabase.base.datavalues.quantity;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public abstract class DvQuantified<T extends DvQuantified>
        extends DvOrdered<T> {

    /**
     * Optional status of magnitude with values:
     * "=" : magnitude is a point value
     * "<" : value is < magnitude
     * ">" : value is > magnitude
     * "<=" : value is <= magnitude
     * ">=" : value is >= magnitude
     * "~" : value is approximately magnitude
     * If not present, assumed meaning is "=" .
     */
    private String magnitudeStatus = "=";

    protected DvQuantified(){
        this(null, null, null, null, null);
    }

    protected DvQuantified(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService);
        this.magnitudeStatus = magnitudeStatus;
    }

    public String getMagnitudeStatus() {
        return magnitudeStatus;
    }

    public void setMagnitudeStatus( String magnitudeStatus) {
        this.magnitudeStatus = magnitudeStatus;
    }

    public Boolean validMagnitudeStatus() {
        String[] resultTest = {"=", "<", ">", "<=", ">=", "~"};
        if(magnitudeStatus!=null && !Arrays.asList(resultTest).contains(magnitudeStatus)){
            return false;
        }
        return true;
    }

    public abstract Number getMagnitude();

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return Post_result: Result = magnitude < other.magnitude
     */
    public Boolean lessThan(DvQuantified<T> other){
        Integer i = 0;
        BigDecimal b1 = BigDecimal.valueOf(getMagnitude().doubleValue());
        BigDecimal b2 = BigDecimal.valueOf(other.getMagnitude().doubleValue());
        return b1.compareTo(b2)<0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvQuantified<?> that = (DvQuantified<?>) o;
        return Objects.equals(magnitudeStatus, that.magnitudeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitudeStatus);
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