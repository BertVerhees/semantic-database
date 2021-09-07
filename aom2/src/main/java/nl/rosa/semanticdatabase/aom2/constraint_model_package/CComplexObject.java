package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint on complex objects, i.e.
 * any object that consists of other object constraints.
 */
public class CComplexObject extends CDefinedObject {

    //***** CComplexObject *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * List of constraints on attributes of the reference model type represented by this object.
     * cardinality: 0..1
     */
    private List<CAttribute> attributes;

    /**
     * List of attribute tuple constraints under this object constraint, if any.
     * cardinality: 0..1
     */
    private List<CAttributeTuple> attributeTuples;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * List of constraints on attributes of the reference model type represented by this object.
     * cardinality: 0..1
     */

    public void addAttribute(CAttribute value) {
        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        attributes.add(value);
    }

    public void addToAttributes(List<CAttribute> values) {
        values.forEach(value -> addAttribute(value));
    }

    public void removeAttribute(CAttribute item) {
        if (attributes != null) {
            attributes.remove(item);
        }
    }

    public void removeFromAttributes(Collection<CAttribute> values) {
        values.forEach(this::removeAttribute);
    }

    public List<CAttribute> getAttributes() {
        return this.attributes;
    }

    public CComplexObject setAttributes(List<CAttribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    public List<CAttribute> attributes() {
        return Collections.unmodifiableList(this.attributes);
    }

    /**
     * List of attribute tuple constraints under this object constraint, if any.
     * cardinality: 0..1
     */

    public void addAttributeTuple(CAttributeTuple value) {
        if (attributeTuples == null) {
            attributeTuples = new ArrayList<>();
        }
        attributeTuples.add(value);
    }

    public void addToAttributeTuples(List<CAttributeTuple> values) {
        values.forEach(value -> addAttributeTuple(value));
    }

    public void removeAttributeTuple(CAttributeTuple item) {
        if (attributeTuples != null) {
            attributeTuples.remove(item);
        }
    }

    public void removeFromAttributeTuples(Collection<CAttributeTuple> values) {
        values.forEach(this::removeAttributeTuple);
    }

    List<CAttributeTuple> getAttributeTuples() {
        return this.attributeTuples;
    }

    public CComplexObject setAttributeTuples(List<CAttributeTuple> attributeTuples) {
        this.attributeTuples = attributeTuples;
        return this;
    }

    public List<CAttributeTuple> attributeTuples() {
        return Collections.unmodifiableList(this.attributeTuples);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if there is an assumed value.
     * cardinality: 1..1 (effected)
     */

    public Boolean hasDefaultValue() {
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
     * <p>
     * Post: Result = attributes.is_empty and not is_prohibited
     */

    public Boolean anyAllowed() {
        return attributes == null || attributes.isEmpty();
    }

    /**
     * True if aValue is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param aValue
     * @return
     */
    @Override
    public Boolean validValue(Object aValue) {
        if (aValue == null) {
            throw new NullPointerException("Parameter: aValue has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public Object prototypeValue() {
        Object result = null;

        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * Parameters rmcc Reference Model conformance checker agent (lambda).
     * cardinality: 1..1 (effected)
     */
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (effected)
     */
    public boolean cCongruentTo(ArchetypeConstraint other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    @Override
    public boolean isLeaf() {
        return (attributes == null || attributes.isEmpty()) && (attributeTuples == null || attributeTuples.isEmpty());
    }


    //***** CComplexObject *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CComplexObject(
            List<CAttribute> attributes,
            List<CAttributeTuple> attributeTuples,
            //CDefinedObject
            Object defaultValue,
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
                defaultValue,
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent
        );
        this.attributes = attributes;
        this.attributeTuples = attributeTuples;
    }

    private CComplexObject(Builder builder) {
        this(
                builder.attributes,
                builder.attributeTuples,
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
        private List<CAttribute> attributes;
        private List<CAttributeTuple> attributeTuples;
        private Object defaultValue;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                String rmTypeName,
                String nodeId
        ) {
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setAttributes(List<CAttribute> value) {
            this.attributes = value;
            return this;
        }

        public Builder setAttributeTuples(List<CAttributeTuple> value) {
            this.attributeTuples = value;
            return this;
        }

        public Builder setDefaultValue(Object value) {
            this.defaultValue = value;
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

        public CComplexObject build() {
            return new CComplexObject(this);
        }
    }


    //***** CComplexObject *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CComplexObject that = (CComplexObject) object;
        return
                Objects.equals(attributes, that.attributes) &&
                        Objects.equals(attributeTuples, that.attributeTuples);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                attributes,
                attributeTuples
        );
    }

    @Override
    public String toString() {
        return
                "CComplexObject {" +
                        "attributes='" + attributes + '\'' +
                        "attributeTuples='" + attributeTuples + '\'' +
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
