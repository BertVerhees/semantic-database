package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import java.util.function.BiFunction;

import semanticdatabase.base.foundation_types.interval.MultiplicityInterval;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A constraint defined by proxy, using a reference to an object constraint defined elsewhere in the same archetype.
 * Note that since this object refers to another node, there are two objects with available occurrences values.
 * The local occurrences value on a COMPLEX_OBJECT_PROXY should always be used; when setting this from a serialised form, if no occurrences is mentioned, the target occurrences should be used (not the standard default of {1..1}); otherwise the locally specified occurrences should be used as normal.
 * When serialising out, if the occurrences is the same as that of the target, it can be left out.
 */
public class CComplexObjectProxy extends CObject {

    //***** CComplexObjectProxy *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to an object node using archetype path notation.
     * cardinality: 1..1
     */
    private String targetPath;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to an object node using archetype path notation.
     * cardinality: 1..1
     */
    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:targetPath failed, it has cardinality NonNull, but is null");
        }
        this.targetPath = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

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
     * <p>
     * Cannot be abstract when class is not abstract.
     *
     * @param other
     */
    @Override
    public boolean cCongruentTo(ArchetypeConstraint other) {
        return false;
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    @Override
    public Boolean isLeaf() {
        return true;
    }


    /**
     * True if target occurrences are to be used as the value of occurrences in this object; by the time of runtime use, the target occurrences value has to be set into this object.
     * cardinality: 1..1
     * <p>
     * Post: Result = (occurrences = Void)
     */
    public Boolean useTargetOccurrences() {
        return getOccurrences() == null;
    }

    /**
     * True if this node occurrences conforms to other.occurrences; other is assumed to be in a flat archetype.
     * If other is a C_COMPLEX_OBJECT, then always True, since if occurrences defined on proxy node, it is an override of the occurrences on the target, and it doesn’t have to conform to anything except the containing attribute’s cardinality.
     * However, if other is also a C_COMPLEX_OBJECT then the override is of another use_node, and normal occurrences apply
     * <p>
     * Parameters other C_OBJECT from a flat parent archetype.
     * <p>
     * cardinality: 1..1 (redefined)
     */
    public boolean occurrencesConformsTo(CObject other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        //TODO Get Target
//        if (target instanceof CComplexObject){
//            return true;
//        }else {
//            return getOccurrences() == other.getOccurrences();
//        }
        return true;
    }

    //***** CComplexObjectProxy *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public CComplexObjectProxy(
            String targetPath,
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
        if (targetPath == null) {
            throw new NullPointerException("Property:targetPath has cardinality NonNull, but is null");
        }
        this.targetPath = targetPath;
    }

    private CComplexObjectProxy(Builder builder) {
        this(
                builder.targetPath,
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
        private final String targetPath;  //required
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                String targetPath,
                String rmTypeName,
                String nodeId
        ) {
            this.targetPath = targetPath;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
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

        public CComplexObjectProxy build() {
            return new CComplexObjectProxy(this);
        }
    }


    //***** CComplexObjectProxy *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CComplexObjectProxy that = (CComplexObjectProxy) object;
        return
                Objects.equals(targetPath, that.targetPath);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                targetPath
        );
    }

    @Override
<<<<<<< HEAD
    public String toString() {
=======
    public java.lang.String toString() {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        return
                "CComplexObjectProxy {" +
                        "targetPath='" + targetPath + '\'' +
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
