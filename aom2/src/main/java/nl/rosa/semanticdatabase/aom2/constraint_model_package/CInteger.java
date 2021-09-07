package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import semanticdatabase.base.foundation_types.interval.Interval;
import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

import java.util.List;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances of Integer.
 */
public class CInteger extends COrdered<Long> {

    //***** CInteger *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Formal constraint on Integer, in the form of List<Interval<Integer>>.
     * cardinality: 1..1 (redefined)
     */
    private Interval<Long> constraint;

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    private Long assumedValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Formal constraint on Integer, in the form of List<Interval<Integer>>.
     * cardinality: 1..1 (redefined)
     */
    public Interval<Long> getConstraint() {
        return constraint;
    }

    public void setConstraint(Interval<Integer> value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:constraint failed, it has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
    }

    /**
     * Default value set in a template, and present in an operational template.
     * Generally limited to leaf and near-leaf nodes.
     * cardinality: 0..1 (redefined)
     */
    public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer value) {
        this.defaultValue = defaultValue;
    }

    /**
     * Value to be assumed if none sent in data.
     * cardinality: 0..1 (redefined)
     */
    public Integer getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(Integer value) {
        this.assumedValue = assumedValue;
    }

    //***** CInteger *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CInteger(
            //CDefinedObject
            //CPrimitiveObject
            Long assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<Interval<Long>> constraint,
            //CDefinedObject
            Long defaultValue,
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

    private CInteger(Builder builder) {
        this(
                builder.assumedValue,
                builder.isEnumeratedTypeConstraint
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
        private final List<Interval<Double>> constraint;  //required
        private Double defaultValue;
        private Double assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private String rmTypeName;
        private MultiplicityInterval occurrences;
        private String nodeId;
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;


        public Builder(
                List<Interval<Double>> constraint
        ) {
            if (constraint == null) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
            this.constraint = constraint;
        }

        public Builder setDefaultValue(Double value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setAssumedValue(Double value) {
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

        public CInteger build() {
            return new CInteger(this);
        }
    }


    //***** CInteger *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CInteger that = (CInteger) object;
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
                "CInteger {" +
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
