package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.List;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAbsoluteQuantity<A extends DvAmount, T extends DvAbsoluteQuantity>
        extends DvQuantified<T> {

    protected DvAbsoluteQuantity(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            A accuracy,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, magnitudeStatus);
        this.accuracy = accuracy;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    public abstract T add(A s);

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    public abstract T subtract(A s);

    /**
     * Difference of two quantities.
     *
     * @return diff type
     */
    public abstract DvAmount diff(T other);

    /**
     * Accuracy of measurement, expressed as a half-range value
     * of the diff type for this quantity (i.e. an accuracy of
     * x means +/−x).
     *
     * @return accuracy
     */
    public A getAccuracy() {
        return accuracy;
    }


    /* fields */
    private final A accuracy;


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