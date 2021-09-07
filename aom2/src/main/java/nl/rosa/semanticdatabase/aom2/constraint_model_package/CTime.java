package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;
import semanticdatabase.base.base_types.definitions_package.ValidityKind;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances representing times in the form either of a set of validity values, or else time ranges based on the C_ORDERED list constraint.
 * There is no validity flag for hour, since it must always be by definition mandatory in order to have a sensible time at all.
 * Syntax expressions of instances of this class include "HH:??:xx" (time with optional minutes and seconds not allowed).
 */
public class CTime extends CTemporal<TemporalAccessor> {

    //***** CTime *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Formal constraint on the assumed primitive Iso8601_time type, in the form of List of Interval<Iso8601_time>, i.e.
     * one or more intervals of Iso8601_time.
     * cardinality: 0..1 (redefined)
     */
    private Interval<TemporalAccessor> constraint;

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1 (redefined)
     */
    private TemporalAccessor defaultValue;

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    private TemporalAccessor assumedValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Formal constraint on the assumed primitive Iso8601_time type, in the form of List of Interval<Iso8601_time>, i.e.
     * one or more intervals of Iso8601_time.
     * cardinality: 0..1 (redefined)
     */
    public Interval<TemporalAccessor> getConstraint() {
        return constraint;
    }

    public void setConstraint(Interval<TemporalAccessor> value) {
        this.constraint = constraint;
    }

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1 (redefined)
     */
    public TemporalAccessor getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(TemporalAccessor value) {
        this.defaultValue = defaultValue;
    }

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    public TemporalAccessor getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(TemporalAccessor value) {
        this.assumedValue = assumedValue;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Validity of minute in constrained time.
     * cardinality: 1..1
     */
    public ValidityKind minuteValidity() {
        ValidityKind result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Validity of second in constrained time.
     * cardinality: 1..1
     */
    public ValidityKind secondValidity() {
        ValidityKind result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Validity of millisecond in constrained time.
     * cardinality: 1..1
     */
    public ValidityKind millisecondValidity() {
        ValidityKind result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Validity of timezone in constrained date.
     * cardinality: 1..1
     */
    public ValidityKind timezoneValidity() {
        ValidityKind result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** CTime *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CTime(
            //CTemporal
            String patternConstraint,
            //CDefinedObject
            //CPrimitiveObject
            TemporalAccessor assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<Interval<TemporalAccessor>> constraint,
            //CDefinedObject
            TemporalAccessor defaultValue,
            //CObject
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            //ArchetypeConstraint
            ArchetypeConstraint parent,
            CSecondOrder socParent
    ) {
        super(
                patternConstraint,
                assumedValue,
                isEnumeratedTypeConstraint,
                constraint,
                defaultValue,
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent
        );
    }

    private CTime(Builder builder) {
        this(
                builder.patternConstraint,
                builder.assumedValue,
                builder.isEnumeratedTypeConstraint,
                builder.constraint,
                builder.defaultValue,
                builder.rmTypeName,
                builder.occurrences,
                builder.nodeId,
                builder.isDeprecated,
                builder.siblingOrder,
                builder.parent,
                builder.socParent
        );
    }

    public static class Builder {
        private final List<Interval<TemporalAccessor>> constraint;  //required
        private String patternConstraint;
        private TemporalAccessor defaultValue;
        private TemporalAccessor assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private String rmTypeName;
        private MultiplicityInterval occurrences;
        private String nodeId;
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;


        public Builder(
                List<Interval<TemporalAccessor>> constraint
        ) {
            if (constraint == null) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
            this.constraint = constraint;
        }

        public Builder setPatternConstraint(String value) {
            this.patternConstraint = value;
            return this;
        }

        public Builder setDefaultValue(TemporalAccessor value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setAssumedValue(TemporalAccessor value) {
            this.assumedValue = value;
            return this;
        }

        public Builder setEnumeratedTypeConstraint(Boolean value) {
            this.isEnumeratedTypeConstraint = value;
            return this;
        }

        public Builder setRmTypeName(String value) {
            this.rmTypeName = value;
            return this;
        }

        public Builder setOccurrences(MultiplicityInterval value) {
            this.occurrences = value;
            return this;
        }

        public Builder setNodeId(String value) {
            this.nodeId = value;
            return this;
        }

        public Builder setDeprecated(Boolean value) {
            isDeprecated = value;
            return this;
        }

        public Builder setSiblingOrder(SiblingOrder value) {
            this.siblingOrder = value;
            return this;
        }

        public Builder setParent(ArchetypeConstraint value) {
            this.parent = value;
            return this;
        }

        public Builder setSocParent(CSecondOrder value) {
            this.socParent = value;
            return this;
        }

        public CTime build() {
            return new CTime(this);
        }
    }


    //***** CTime *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CTime that = (CTime) object;
        return
                Objects.equals(constraint, that.constraint) &&
                        Objects.equals(defaultValue, that.defaultValue) &&
                        Objects.equals(assumedValue, that.assumedValue);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                constraint,
                defaultValue,
                assumedValue
        );
    }

    @Override
    public String toString() {
        return
                "CTime {" +
                        "constraint='" + constraint + '\'' +
                        "defaultValue='" + defaultValue + '\'' +
                        "assumedValue='" + assumedValue + '\'' +
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
