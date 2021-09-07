package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on instances of String.
 */
public class CString extends CPrimitiveObject {

    //***** CString *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * String constraint - a list of literal strings and / or regular expression strings delimited by the ‘/’ character.
     * cardinality: 1..1 (redefined)
     */
    private List<String> constraint = new ArrayList<>();

    /**
     * Default String value.
     * cardinality: 0..1 (redefined)
     */
    private String defaultValue;

    /**
     * Assumed String value.
     * cardinality: 0..1 (redefined)
     */
    private String assumedValue;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * String constraint - a list of literal strings and / or regular expression strings delimited by the ‘/’ character.
     * cardinality: 1..1 (redefined)
     */

    public void addConstraint(String value) {
        constraint.add(value);
    }

    public void removeConstraint(String item) {
        if (constraint != null) {
            constraint.remove(item);
        }
    }

    public List<String> getConstraint() {
        return this.constraint;
    }

    public void setConstraint(List<String> constraint) {
        if (constraint == null) {
            throw new NullPointerException(" constraint has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
    }

    public List<String> constraint() {
        return Collections.unmodifiableList(this.constraint);
    }

    /**
     * Default String value.
     * cardinality: 0..1 (redefined)
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String value) {
        this.defaultValue = defaultValue;
    }

    /**
     * Assumed String value.
     * cardinality: 0..1 (redefined)
     */
    public String getAssumedValue() {
        return assumedValue;
    }

    public void setAssumedValue(String value) {
        this.assumedValue = assumedValue;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * cardinality: 1..1 (effected)
     */
    public String prototypeValue() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     * cardinality: 1..1 (effected)
     */
    public Boolean validValue(String a_value) {
        if (a_value == null) {
            throw new NullPointerException("Parameter a_value has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if any value (i.e.
     * instance) of the reference model type would be allowed.
     * Redefined in descendants.
     * cardinality: 1..1 (effected)
     */
    public Boolean anyAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     * cardinality: 1..1 (abstract)
     *
     * @param a_value
     */
    @Override
    public Boolean validValue(Object a_value) {
        return null;
    }

    /**
     * True if other.any_allowed or else every constraint in the constraint list exists in the other.constraint.
     * cardinality: 1..1 (effected)
     */
    @Override
    public boolean cValueConformsTo(CPrimitiveObject other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return other.anyAllowed() ||
                (constraint.size() < ((CString) other).constraint.size())
                        && (constraint.stream().anyMatch(c -> ((CString) other).constraint.contains(c)));
    }

    /**
     * True if the items in constraint are equal in number and identical pair-wise with those in other.constraint.
     * True if this node's value constraint is the same as that of `other'
     * cardinality: 1..1 (effected)
     */
    @Override
    public boolean cValueCongruentTo(CPrimitiveObject other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return (constraint.size() == ((CString) other).constraint.size())
                && constraint.equals(((CString) other).constraint);
    }

    @Override
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        if (!super.cConformsTo(other, rmTypesConformant)) {
            return false;
        }
        //now guaranteed to be the same class

        CString o = (CString) other;
        if (o.constraint.isEmpty()) {
            return true;
        }

        for (String constraint : constraint) {
            if (!hasMatchingConstraint(constraint, o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    @Override
    public boolean isLeaf() {
        return false;
    }

    private boolean hasMatchingConstraint(String constraint, CString otherString) {
        boolean isRegexp = CString.isRegexConstraint(constraint);

        for (String otherConstraint : otherString.constraint) {
            boolean otherIsRegexp = CString.isRegexConstraint(otherConstraint);
            if (otherIsRegexp && !isRegexp) {
                if (matchesRegexp(constraint, otherConstraint)) {
                    return true;
                }
            } else if (otherConstraint.equals(constraint)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRegexConstraint(String constraint) {
        return (constraint.startsWith("/") && constraint.endsWith("/")) ||
                (constraint.startsWith("^") && constraint.endsWith("^"));
    }

    private boolean matchesRegexp(String value, String constraint) {
        return value.matches(constraint.substring(1).substring(0, constraint.length() - 2));
    }


    //***** CString *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CString(
            //CPrimitiveObject
            String assumedValue,
            Boolean isEnumeratedTypeConstraint,
            List<String> constraint,
            //CDefinedObject
            String defaultValue,
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
        this.defaultValue = defaultValue;
    }

    private CString(Builder builder) {
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
        private final List<String> constraint;  //required
        private String defaultValue;
        private String assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                List<String> constraint,
                String rmTypeName,
                String nodeId
        ) {
            this.constraint = constraint;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setDefaultValue(String value) {
            this.defaultValue = value;
            return this;
        }

        public Builder setAssumedValue(String value) {
            this.assumedValue = value;
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

        public CString build() {
            return new CString(this);
        }
    }


    //***** CString *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CString that = (CString) object;
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
<<<<<<< HEAD
    public String toString() {
=======
    public java.lang.String toString() {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        return
                "CString {" +
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
