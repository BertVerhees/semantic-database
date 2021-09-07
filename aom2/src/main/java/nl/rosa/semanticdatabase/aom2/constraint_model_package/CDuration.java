package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Objects;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances representing duration, which is assumed to have the same parts as the ISO 8601 duration string.
 * Thus, constraints are of the form "PWD" (weeks and/or days), "PDTHMS" (days, hours, minutes, seconds) and so on.
 * Both range and the constraint pattern can be set at the same time, corresponding to the ADL constraint "PWD/|P0W..P50W|".
 * As for all of openEHR, two ISO 8601 exceptions are allowed: the ‘W’ (week) designator can be mixed in - the allowed patterns are: P[Y|y][M|m][D|d][T[H|h][M|m][S|s]] and P[W|w]; the values used in an interval constraint may be negated, i.e.
 * a leading minus ('-') sign may be used.
 */
public class CDuration extends CTemporal<TemporalAmount> {

    //***** CDuration *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Formal constraint on the assumed primitive Iso8601_duration type, in the form of List of Interval<Iso8601_duration>, i.e.
     * one or more intervals of Iso8601_duration.
     * cardinality: 0..1 (redefined)
     */
    private Interval<TemporalAmount> constraint;

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1 (redefined)
     */
    private TemporalAmount defaultValue;

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    private TemporalAmount assumedValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Formal constraint on the assumed primitive Iso8601_duration type, in the form of List of Interval<Iso8601_duration>, i.e.
     * one or more intervals of Iso8601_duration.
     * cardinality: 0..1 (redefined)
     */
    public Interval<TemporalAmount> getConstraint() {
        return constraint;
    }

    public void setConstraint(Interval<TemporalAmount> value) {
        this.constraint = constraint;
    }

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1 (redefined)
     */
    public TemporalAmount getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(TemporalAmount value) {
        this.defaultValue = defaultValue;
    }

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    public TemporalAmount getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(TemporalAmount value) {
        this.assumedValue = assumedValue;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if years are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean yearsAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if months are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean monthsAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if weeks are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean weeksAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if days are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean daysAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if hours are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean hoursAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if minutes are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean minutesAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if seconds are allowed in the constrained Duration.
     * cardinality: 1..1
     */
    public Boolean secondsAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** CDuration *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CDuration(
            //CTemporal
            String patternConstraint,
            //CDefinedObject
            //CPrimitiveObject
            TemporalAmount assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<Interval<TemporalAmount>> constraint,
            //CDefinedObject
            TemporalAmount defaultValue,
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

    private CDuration(Builder builder) {
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
        private final List<Interval<TemporalAmount>> constraint;  //required
        private String patternConstraint;
        private TemporalAmount defaultValue;
        private TemporalAmount assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private String rmTypeName;
        private MultiplicityInterval occurrences;
        private String nodeId;
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;


        public Builder(
                List<Interval<TemporalAmount>> constraint
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

        public Builder setDefaultValue(TemporalAmount value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setAssumedValue(TemporalAmount value) {
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

        public Builder setSocParent(CSecondOrder value) {
            this.socParent = value;
            return this;
        }

        public Builder setParent(ArchetypeConstraint value) {
            this.parent = value;
            return this;
        }

        public CDuration build() {
            return new CDuration(this);
        }
    }


    //***** CDuration *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CDuration that = (CDuration) object;
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
                "CDuration {" +
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
