package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

/**
 * Abstract class defining the concept of relative quantified 'amounts'. For relative quantities,
 * the + and - operators are defined (unlike descendants of DV_ABSOLUTE_QUANTITY, such as the date/time types).
 * @param <T>
 */
public abstract class DvAmount<T extends DvAmount>
        extends DvQuantified<T> {

    /**
     * Accuracy of measurement, expressed either as a half-range percent value (accuracy_is_percent = True)
     * or a half-range quantity. A value of 0 means that accuracy is 100%, i.e. no error.
     *
     * A value of unknown_accuracy_value means that accuracy was not recorded.
     */
    private Double accuracy = null;
    /**
     * If True, indicates that when this object was created, accuracy was recorded as a percent value;
     * if False, as an absolute quantity value.
     */
    private Boolean accuracyIsPercent = null;

    protected DvAmount(){
        this(
           null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    protected DvAmount(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, magnitudeStatus);
        this.accuracy = accuracy;
        this.accuracyIsPercent = accuracyIsPercent;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    public abstract DvQuantified<T> add(DvQuantified<T> s);

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    public abstract DvQuantified<T> subtract(DvQuantified<T> s);

    public Boolean getAccuracyIsPercent() {
        return accuracyIsPercent;
    }

    public void setAccuracyIsPercent( Boolean accuracyIsPercent) {
        this.accuracyIsPercent = accuracyIsPercent;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Accuracy of measurement instrument or method which applies
     * to this specific instance of Quantified, expressed either
     * as a half-range percent value (accuracy_is_percent = True)
     * or a half-range quantity.
     * <p/>
     * A value of 0 means that accuracy was not recorded.
     *
     * @return accuracy
     */
    public Boolean isAccuracyRecorded() {
        return accuracy != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvAmount<?> dvAmount = (DvAmount<?>) o;
        return Objects.equals(accuracy, dvAmount.accuracy) &&
                Objects.equals(accuracyIsPercent, dvAmount.accuracyIsPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accuracy, accuracyIsPercent);
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