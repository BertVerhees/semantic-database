package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAbsoluteQuantity;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 01/03/16.
 */
public abstract class DvTemporal<T extends DvTemporal>
        extends DvAbsoluteQuantity<DvDuration, T> {

    
    private DvDuration accuracy;

    protected DvTemporal(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            DvDuration accuracy,
            String magnitudeStatus
            ) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, accuracy, magnitudeStatus);
//        this.value = DateTimeParsers.parseDateTimeValue(value);
    }

    /**
     * Type of quantity which can be added or subtracted to this quantity.
     * Usually the same type, but may be different as in the case of dates and
     * times.
     *
     * @return diff type
     */
    public Class<DvDuration> getDiffType() {
        return DvDuration.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvTemporal<?> that = (DvTemporal<?>) o;

        return Objects.equals(accuracy, that.accuracy);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accuracy);
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