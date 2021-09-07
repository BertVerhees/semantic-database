package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.terminology.OpenEHRCodeSetIdentifiers;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

/**
 * Abstract class defining the concept of ordered values, which includes ordinals as well as true quantities.
 * It defines the functions < and is_strictly_comparable_to(), the latter of which must evaluate to True for instances
 * being compared with the < function, or used as limits in the DV_INTERVAL<T> class.
 *
 * Data value types which are to be used as limits in the DV_INTERVAL<T> class must inherit from this class,
 * and implement the function is_strictly_comparable_to() to ensure that instances compare meaningfully.
 * For example, instances of DV_QUANTITY can only be compared if they measure the same kind of physical quantity.
 *
 * Invariants
 *
 * Other_reference_ranges_validity: other_reference_ranges /= Void implies not other_reference_ranges.is_empty
 * Is_simple_validity: (normal_range = Void and other_reference_ranges = Void) implies is_simple
 * Normal_status_validity: normal_status /= Void implies code_set (Code_set_id_normal_statuses).has_code (normal_status)
 * Normal_range_and_status_consistency: (normal_range /= Void and normal_status /= Void) implies (normal_status.code_string.is_equal (“N”) xor not normal_range.has (self))
 * @param <T>
 */
public abstract class DvOrdered<T extends DvOrdered>
        extends DataValue
        implements Comparable<T> {

    private TerminologyService terminologyService;

    /**
     * Optional normal status indicator of value with respect to normal range for this value.
     * Often included by lab, even if the normal range itself is not included. Coded by ordinals in series HHH, HH, H,
     * (nothing), L, LL, LLL; see openEHR terminology group normal_status.
     */
    private CodePhrase normalStatus;
    /**
     * Optional normal range.
     */
    private DvInterval<T> normalRange;
    /**
     * Optional tagged other reference ranges for this value in its particular measurement context.
     */
    private List<ReferenceRange<T>> otherReferenceRanges;

    protected DvOrdered(){
        this(null, null);
    }

    protected DvOrdered(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange) {
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }

    protected DvOrdered(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService) {
        if (otherReferenceRanges != null && otherReferenceRanges.isEmpty()) {
            throw new IllegalArgumentException("otherReferenceRanges must be null or not empty");
        }
        if(normalStatus != null) {
            if(terminologyService == null) {
                throw new IllegalArgumentException("If normalStatus is not null, terminologyService must not be null");
            }
            //TODO replace OpenEhr terminology by generic terminology
            if (!terminologyService.codeSetForId(
                    OpenEHRCodeSetIdentifiers.NORMAL_STATUSES).hasCode(
                    normalStatus)) {
                throw new IllegalArgumentException(
                        "unknown normal status: " + normalStatus);
            }
        }
        if(normalRange != null && normalStatus != null) {
            if(!normalStatus.getCodeString().equals("N")){
                throw new IllegalArgumentException("normalStatus.codestring must be \"N\", when normalStatus and normalRange is not null");
            }
        }
        this.normalStatus = normalStatus;
        this.normalRange = normalRange;
        this.otherReferenceRanges = otherReferenceRanges;
    }


    public DvInterval<T> getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(DvInterval<T> normalRange) {
        this.normalRange = normalRange;
    }

    public List<ReferenceRange<T>> getOtherReferenceRanges() {
        return otherReferenceRanges;
    }

    public void setOtherReferenceRanges(List<ReferenceRange<T>> otherReferenceRanges) {
        this.otherReferenceRanges = otherReferenceRanges;
    }

    public void addOtherReferenceRange(ReferenceRange<T> range) {
        if(otherReferenceRanges==null){
            otherReferenceRanges = new ArrayList<>();
        }
        otherReferenceRanges.add(range);
    }

    public TerminologyService getTerminologyService() {
        return terminologyService;
    }

    public CodePhrase getNormalStatus() {
        return normalStatus;
    }

    public void setNormalStatus( CodePhrase normalStatus) {
        this.normalStatus = normalStatus;
    }
    /**
     * Value is in the normal range, determined by comparison of the value to normal_range if present,
     * or by the normal_status marker if present.
     * @return true if normal
     * @throws IllegalStateException if both normalRange and normalStatus null
     * Pre: normal_range /= Void or normal_status /= Void
     * Post_range: normal_range /= Void implies Result = normal_range.has (self)
     * Post_status: normal_status /= Void implies normal_status.code_string.is_equal (“N”)
     */
    public boolean isNormal() throws IllegalStateException {
        if(normalRange == null && normalStatus == null) {
            throw new IllegalStateException(
                    "Both normalRange and normalStatus must not be null");
        }
        if(normalRange != null) {
            return getNormalRange().has(this);
        } else {
            return normalStatus.getCodeString().equals("N");
        }
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     * @param other
     * @return
     */
    public abstract Boolean isStrictlyComparableTo(DvOrdered<T> other);

    /**
     * True if this quantity has no reference ranges.
     * @return
     */
    public Boolean isSimple(){
        return otherReferenceRanges == null && normalRange == null;
    }

    public abstract Boolean lessThan(DvOrdered<T> other);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvOrdered<?> dvOrdered = (DvOrdered<?>) o;
        return Objects.equals(normalStatus, dvOrdered.normalStatus) &&
                Objects.equals(normalRange, dvOrdered.normalRange) &&
                Objects.equals(otherReferenceRanges, dvOrdered.otherReferenceRanges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normalStatus, normalRange, otherReferenceRanges);
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