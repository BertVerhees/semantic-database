package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances of Boolean.
 * Both attributes cannot be set to False, since this would mean that the Boolean value being constrained cannot be True or False.
 */
public class CBoolean extends CPrimitiveObject<Boolean, Boolean> {

    //***** CBoolean *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Boolean constraint - a list of Boolean values.
     * cardinality: 0..1 (redefined)
     */
    private List<Boolean> constraint;

    /**
     * Assumed Boolean value.
     * cardinality: 0..1 (redefined)
     */
    private Boolean assumedValue;

    /**
     * Default Boolean value.
     * cardinality: 0..1 (redefined)
     */
    private Boolean defaultValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Boolean constraint - a list of Boolean values.
     * cardinality: 0..1 (redefined)
     */

    public void addToConstraint(Boolean value) {
        if (constraint == null) {
            constraint = new ArrayList<>();
        }
        constraint.add(value);
    }

    public void addToConstraint(List<Boolean> values) {
        values.forEach(value -> addToConstraint(value));
    }

    public void removeFromConstraint(Boolean item) {
        if (constraint != null) {
            constraint.remove(item);
        }
    }

    public void removeFromConstraint(Collection<Boolean> values) {
        values.forEach(this::removeFromConstraint);
    }

    public List<Boolean> getConstraint() {
        return this.constraint;
    }

    public void setConstraint(List<Boolean> constraint) {
        this.constraint = constraint;
    }

    public List<Boolean> constraint() {
        return Collections.unmodifiableList(this.constraint);
    }

    /**
     * Assumed Boolean value.
     * cardinality: 0..1 (redefined)
     */
    public Boolean getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(Boolean value) {
        this.assumedValue = assumedValue;
    }

    /**
     * Default Boolean value.
     * cardinality: 0..1 (redefined)
     */
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean value) {
        this.defaultValue = defaultValue;
    }


    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     * cardinality: 1..1 (abstract)
     *
     * @param a_value
     */
    @Override
    public Boolean validValue(Boolean a_value) {
        return null;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if any value (i.e.
     * instance) of the reference model type would be allowed.
     * Redefined in descendants.
     * cardinality: 1..1 (abstract)
     */
    @Override
    public Boolean anyAllowed() {
        return null;
    }


    /**
     * Prototype Boolean value.
     * cardinality: 1..1 (effected)
     */
    public Boolean prototypeValue() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if other.any_allowed or else every constraint in the constraint list exists in the other.constraint.
     * cardinality: 1..1 (effected)
     */
    public boolean cValueConformsTo(CBoolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return other.anyAllowed() ||
                (constraint.size() < other.constraint.size()) && (constraint.stream().anyMatch(c -> other.constraint.contains(c)));
    }

    /**
     * True if the items in constraint are equal in number and identical pair-wise with those in other.constraint.
     * cardinality: 1..1 (effected)
     */
    public Boolean cValueCongruentTo(CBoolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return (constraint.size() == other.constraint.size()) && (constraint.stream().anyMatch(c -> other.constraint.contains(c)));
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
     * @param rmTypesConformant
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


    //***** CBoolean *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CBoolean(
            //CPrimitiveObject
            Boolean assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<Boolean> constraint,
            //CDefinedObject
            Boolean defaultValue,
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

    private CBoolean(Builder builder) {
        this(
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
        private List<Boolean> constraint;
        private Boolean assumedValue;
        private Boolean defaultValue;
        private Boolean isEnumeratedTypeConstraint;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                List<Boolean> constraint,
                String rmTypeName,
                String nodeId
        ) {
            this.constraint = constraint;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setConstraint(List<Boolean> value) {
            this.constraint = value;
            return this;
        }

        public Builder setAssumedValue(Boolean value) {
            this.assumedValue = value;
            return this;
        }

        public Builder setDefaultValue(Boolean value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setIsEnumeratedTypeConstraint(Boolean value) {
            this.isEnumeratedTypeConstraint = value;
            return this;
        }

        public Builder setOccurrences(MultiplicityInterval value) {
            this.occurrences = value;
            return this;
        }

        public Builder setIsDeprecated(Boolean value) {
            this.isDeprecated = value;
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

        public CBoolean build() {
            return new CBoolean(this);
        }
    }


    //***** CBoolean *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CBoolean that = (CBoolean) object;
        return
                Objects.equals(constraint, that.constraint) &&
                        Objects.equals(assumedValue, that.assumedValue) &&
                        Objects.equals(defaultValue, that.defaultValue);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                constraint,
                assumedValue,
                defaultValue
        );
    }

    @Override
    public String toString() {
        return
                "CBoolean {" +
                        "constraint='" + constraint + '\'' +
                        "assumedValue='" + assumedValue + '\'' +
                        "defaultValue='" + defaultValue + '\'' +
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
