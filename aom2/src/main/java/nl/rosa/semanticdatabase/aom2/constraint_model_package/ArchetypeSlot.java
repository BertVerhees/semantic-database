package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import nl.rosa.semanticdatabase.utils.interval.MultiplicityInterval;

import java.util.*;
import java.util.function.BiFunction;


/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Constraint describing a slot' where another archetype can occur.
 */
public class ArchetypeSlot extends CObject {

    //***** ArchetypeSlot *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * List of constraints defining other archetypes that could be included at this point.
     * cardinality: 0..1
     */
    private List<ArchetypeIdConstraint> includes;

    /**
     * List of constraints defining other archetypes that cannot be included at this point.
     * cardinality: 0..1
     */
    private List<ArchetypeIdConstraint> excludes;

    /**
     * True if this slot specification in this artefact is closed to further filling either in further specialisations or at runtime.
     * Default value False, i.e.
     * unless explicitly set, a slot remains open.
     * cardinality: 1..1
     */
    private Boolean isClosed;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * List of constraints defining other archetypes that could be included at this point.
     * cardinality: 0..1
     */

    public void addToInclude(ArchetypeIdConstraint value) {
        if (includes == null) {
            includes = new ArrayList<>();
        }
        includes.add(value);
    }

    public void addToIncludes(List<ArchetypeIdConstraint> values) {
        values.forEach(value -> addToInclude(value));
    }

    public void removeFromInclude(ArchetypeIdConstraint item) {
        if (includes != null) {
            includes.remove(item);
        }
    }

    public void removeFromIncludes(Collection<ArchetypeIdConstraint> values) {
        values.forEach(this::removeFromInclude);
    }

    List<ArchetypeIdConstraint> getIncludes() {
        return this.includes;
    }

    public ArchetypeSlot setIncludes(List<ArchetypeIdConstraint> includes) {
        this.includes = includes;
        return this;
    }

    public List<ArchetypeIdConstraint> includes() {
        return Collections.unmodifiableList(this.includes);
    }

    /**
     * List of constraints defining other archetypes that cannot be included at this point.
     * cardinality: 0..1
     */

    public void addToExclude(ArchetypeIdConstraint value) {
        if (excludes == null) {
            excludes = new ArrayList<>();
        }
        excludes.add(value);
    }

    public void addToExcludes(List<ArchetypeIdConstraint> values) {
        values.forEach(value -> addToExclude(value));
    }

    public void removeFromExclude(ArchetypeIdConstraint item) {
        if (excludes != null) {
            excludes.remove(item);
        }
    }

    public void removeFromExcludes(Collection<ArchetypeIdConstraint> values) {
        values.forEach(this::removeFromExclude);
    }

    List<ArchetypeIdConstraint> getExcludes() {
        return this.excludes;
    }

    public ArchetypeSlot setExcludes(List<ArchetypeIdConstraint> excludes) {
        this.excludes = excludes;
        return this;
    }

    public List<ArchetypeIdConstraint> excludes() {
        return Collections.unmodifiableList(this.excludes);
    }

    /**
     * True if this slot specification in this artefact is closed to further filling either in further specialisations or at runtime.
     * Default value False, i.e.
     * unless explicitly set, a slot remains open.
     * cardinality: 1..1
     */
    public Boolean isClosed() {
        return isClosed;
    }

    public void setClosed(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isClosed failed, it has cardinality NonNull, but is null");
        }
        this.isClosed = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if no constraints stated, and slot is not closed.
     * cardinality: 1..1
     */
    public Boolean anyAllowed() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
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
        return super.cConformsTo(other, rmTypesConformant);
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
        return super.cCongruentTo((CObject) other);
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    @Override
    public boolean isLeaf() {
        return true;
    }


    //***** ArchetypeSlot *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/

    public ArchetypeSlot(
            List<ArchetypeIdConstraint> includes,
            List<ArchetypeIdConstraint> excludes,
            Boolean isClosed,
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
                rmTypeName,
                occurrences,
                nodeId,
                isDeprecated,
                siblingOrder,
                parent,
                socParent
        );
        if (isClosed == null) {
            throw new NullPointerException("Property:isClosed has cardinality NonNull, but is null");
        }
        this.includes = includes;
        this.excludes = excludes;
        this.isClosed = isClosed;
    }

    private ArchetypeSlot(Builder builder) {
        this(
                builder.includes,
                builder.excludes,
                builder.isClosed,
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
        private List<ArchetypeIdConstraint> includes;
        private List<ArchetypeIdConstraint> excludes;
        private final Boolean isClosed;  //required
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                Boolean isClosed,
                String rmTypeName,
                String nodeId
        ) {
            this.isClosed = isClosed;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setIncludes(List<ArchetypeIdConstraint> value) {
            this.includes = value;
            return this;
        }

        public Builder setExcludes(List<ArchetypeIdConstraint> value) {
            this.excludes = value;
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

        public ArchetypeSlot build() {
            return new ArchetypeSlot(this);
        }
    }


    //***** ArchetypeSlot *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeSlot that = (ArchetypeSlot) object;
        return
                Objects.equals(includes, that.includes) &&
                        Objects.equals(excludes, that.excludes) &&
                        Objects.equals(isClosed, that.isClosed);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                includes,
                excludes,
                isClosed
        );
    }

    @Override
    public java.lang.String toString() {
        return
                "ArchetypeSlot {" +
                        "includes='" + includes + '\'' +
                        "excludes='" + excludes + '\'' +
                        "isClosed='" + isClosed + '\'' +
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
