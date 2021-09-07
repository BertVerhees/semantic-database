package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;
import semanticdatabase.base.foundation_types.time_types.Iso8601Date;
import semanticdatabase.base.base_types.definitions_package.ValidityKind;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances representing dates in the form either of a set of validity values, or else date ranges based on the C_ORDERED list constraint.
 * There is no validity flag for year, since it must always be by definition mandatory in order to have a sensible date at all.
 * Syntax expressions of instances of this class include "YYYY-??-??" (date with optional month and day).
 */
public class CDate extends CTemporal<TemporalAccessor> {

    //***** CDate *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Formal constraint on the assumed primitive Iso8601_date type, in the form of List of Interval<Iso8601_date>, i.e.
     * one or more intervals of Iso8601_date.
     * cardinality: 0..1 (redefined)
     */
    private List<Interval<TemporalAccessor>> constraint;

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
     * Formal constraint on the assumed primitive Iso8601_date type, in the form of List of Interval<Iso8601_date>, i.e.
     * one or more intervals of Iso8601_date.
     * cardinality: 0..1 (redefined)
     */
    public List<Interval<TemporalAccessor>> getConstraint() {
        return constraint;
    }

    @Override
    public void setConstraint(List<Interval<TemporalAccessor>> value) {
        if (constraint == null) {
            throw new NullPointerException(" Setting property:constraint failed, it has cardinality NonNull, but is null");
        }
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

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     * cardinality: 1..1 (abstract)
     *
     * @param a_value
     */
    @Override
    public Boolean validValue(Temporal a_value) {
        return null;
    }

    /**
     * Generate a prototype value from this constraint object.
     * cardinality: 1..1 (abstract)
     */
    @Override
    public Temporal prototypeValue() {
        return null;
    }

    public void setDefaultValue(Iso8601Date value) {
        this.defaultValue = defaultValue;
    }

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    public Iso8601Date getAssumedValue() {
        return assumedValue;
    }

    @Override
    public void setConstraint(List<Interval<Temporal>> constraint) {

    }

    /**
     * True if this node expresses a value constraint that conforms to that of other.
     * Effected in descendants.
     * cardinality: 1..1 (abstract)
     *
     * @param other
     */
    @Override
    public Boolean cValueConformsTo(CObject other) {
        return null;
    }

    /**
     * True if this node expresses the same value constraint as other.
     * Effected in descendants.
     * cardinality: 1..1 (abstract)
     *
     * @param other
     */
    @Override
    public Boolean cValueCongruentTo(CObject other) {
        return null;
    }

    public void setAssumedValue(Iso8601Date value) {
        this.assumedValue = assumedValue;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Validity of month in constrained date.
     * cardinality: 1..1
     */
    public ValidityKind monthValidity() {
        ValidityKind result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Validity of day in constrained date.
     * cardinality: 1..1
     */
    public ValidityKind dayValidity() {
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

    //***** CDate *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CDate(
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

    private CDate(Builder builder) {
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

        public CDate build() {
            return new CDate(this);
        }
    }


    //***** CDate *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    /**
     * True if a_pattern is a valid constraint.
     * Define in concrete descendants.
     * cardinality: 1..1 (abstract)
     *
     * @param a_pattern
     */
    @Override
    public Boolean validPatternConstraint(String a_pattern) {
        return null;
    }

    /**
     * Return True if a_pattern can be replaced by an_other_pattern in a specialised constraint.
     * Define in concrete subtypes.
     * cardinality: 1..1 (abstract)
     *
     * @param a_pattern
     * @param an_other_pattern
     */
    @Override
    public Boolean validPatternConstraintReplacement(String a_pattern, String an_other_pattern) {
        return null;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * Parameters rmcc RM conformance checker - a lambda (i.e.
     * function object) that can compute conformance of type-names within the Reference Model on which the current archetype is based.
     * The signature provides two arguments representing respectively, the rm_type_name of the current node and the rm_type_name of the node being redefined in a specialisation parent archetype.
     * cardinality: 1..1 (abstract)
     *
     * @param other
     * @param rmcc
     */
    @Override
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        return null;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (abstract)
     *
     * @param other
     */
    @Override
    public boolean cCongruentTo(ArchetypeConstraint other) {
        return null;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CDate that = (CDate) object;
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
                "CDate {" +
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
