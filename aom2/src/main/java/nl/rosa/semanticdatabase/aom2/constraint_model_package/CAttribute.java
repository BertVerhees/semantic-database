package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.*;
import java.util.function.BiFunction;

import nl.rosa.semanticdatabase.aom2.utils.AOMUtils;
import nl.rosa.semanticdatabase.base.interval.Cardinality;
import nl.rosa.semanticdatabase.utils.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.utils.paths.queries.APathQuery;
import nl.rosa.semanticdatabase.utils.paths.PathSegment;


/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract model of constraint on any kind of attribute in a class model.
 */
public class CAttribute extends ArchetypeConstraint {

    //***** CAttribute *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference model attribute within the enclosing type represented by a C_OBJECT.
     * cardinality: 1..1
     */
    private String rmAttributeName;

    /**
     * Constraint settable on every attribute, regardless of whether it is singular or of a container type, which indicates whether its target object exists or not (i.e.
     * is mandatory or not).
     * Only set if it overrides the underlying reference model or parent archetype in the case of specialised archetypes.
     * cardinality: 0..1
     */
    private MultiplicityInterval existence;

    /**
     * Child C_OBJECT nodes.
     * Each such node represents a constraint on the type of this attribute in its reference model.
     * Multiples occur both for multiple items in the case of container attributes, and alternatives in the case of singular attributes.
     * cardinality: 0..1
     */
    private List<CObject> children;

    /**
     * Path to the parent object of this attribute (i.e.
     * doesn’t include the name of this attribute).
     * Used only for attributes in differential form, specialised archetypes.
     * Enables only the re-defined parts of a specialised archetype to be expressed, at the path where they occur.
     * cardinality: 0..1
     */
    private String differentialPath;

    /**
     * Cardinality constraint of attribute, if a container attribute.
     * cardinality: 0..1
     */
    private Cardinality cardinality;

    /**
     * Flag indicating whether this attribute constraint is on a container (i.e.
     * multiply-valued) attribute.
     * cardinality: 1..1
     */
    private Boolean isMultiple;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference model attribute within the enclosing type represented by a C_OBJECT.
     * cardinality: 1..1
     */
    public String getRmAttributeName() {
        return rmAttributeName;
    }

    public void setRmAttributeName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:rmAttributeName failed, it has cardinality NonNull, but is null");
        }
        this.rmAttributeName = value;
    }

    /**
     * Constraint settable on every attribute, regardless of whether it is singular or of a container type, which indicates whether its target object exists or not (i.e.
     * is mandatory or not).
     * Only set if it overrides the underlying reference model or parent archetype in the case of specialised archetypes.
     * cardinality: 0..1
     */
    public MultiplicityInterval getExistence() {
        return existence;
    }

    public void setExistence(MultiplicityInterval value) {
        this.existence = value;
    }

    /**
     * Child C_OBJECT nodes.
     * Each such node represents a constraint on the type of this attribute in its reference model.
     * Multiples occur both for multiple items in the case of container attributes, and alternatives in the case of singular attributes.
     * cardinality: 0..1
     */

    public void addChild(CObject value, SiblingOrder order) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (order != null && order.getSiblingNodeId() != null) {
            //TODO: this can be a specialized sibling node id as well!
            CObject sibling = getChild(order.getSiblingNodeId());
            int siblingIndex = getChildren().indexOf(sibling);
            if (siblingIndex > -1) {
                if (!order.isBefore()) {
                    siblingIndex++;
                }
                children.add(siblingIndex, value);
            } else {
                children.add(value);
            }
        } else {
            children.add(value);
        }
        value.setParent(this);
    }

    public void addChild(CObject value) {
        if (children == null) {
            children = new ArrayList<>();
        }
        value.setParent(this);
        children.add(value);
    }

    //first don't look through CComplexObject proxies, then if no result, do lookup through the proxies
    public CObject getChild(String nodeId) {
        CObject result = getChild(nodeId, false);
        if (result == null) {
            result = getChild(nodeId, true);
        }
        return result;
    }

    private CObject getChild(String nodeId, boolean lookThroughProxies) {
        for (CObject child : children) {
            if (nodeId.equals(child.getNodeId())) {
                return child;
            } else if (child instanceof CArchetypeRoot) {
                if (((CArchetypeRoot) child).getArchetypeRef().equals(nodeId)) {
                    return child;
                }
            } else if (lookThroughProxies && child instanceof CComplexObjectProxy) {
                String targetPath = ((CComplexObjectProxy) child).getTargetPath();
                APathQuery aPathQuery = new APathQuery(targetPath);
                PathSegment lastPathSegment = aPathQuery.getPathSegments().get(aPathQuery.getPathSegments().size() - 1);
                if (lastPathSegment.hasIdCode() && lastPathSegment.getNodeId().equals(nodeId)) {
                    return child;
                }
            }
        }
        return null;
    }

    /**
     * Get the child cobject with the given nodeid. If it does not exist but a specialized version
     * does exist, returns that one.
     * If multiple specialized children exist, returns the first it can find. TODO: this should probably be better defined :)
     *
     * @param nodeId
     * @return
     */
    public CObject getPossiblySpecializedChild(String nodeId) {
        //if there's an exact node id match, return that first
        CObject result = getChild(nodeId, false);
        if (result != null) {
            return result;
        }
        for (CObject child : children) {
            if (nodeId.equals(child.getNodeId()) || AOMUtils.codesConformant(child.getNodeId(), nodeId)) {
                return child;
            } else if (child instanceof CArchetypeRoot) {
                //TODO: Should we look for specialized archetype roots as well? :)
                if (((CArchetypeRoot) child).getArchetypeRef().equals(nodeId)) {
                    return child;
                }
            }
        }
        return null;
    }

    /**
     * Removes the child with a node id exactly the same as the given node id. In case multiple children match, removes
     * only the first child
     *
     * @param nodeId
     */
    public void removeChild(String nodeId) {
        int index = getIndexOfChildWithNodeId(nodeId);
        if (index > -1) {
            children.remove(index);
        }
    }

    public void removeChild(CObject item) {
        if (children != null) {
            children.remove(item);
        }
    }


    public List<CObject> getChildren() {
        return this.children;
    }

    public void setChildren(List<CObject> children) {
        if (children == null) {
            this.children = new ArrayList<>();
        } else {
            this.children = children;

            for (CObject child : children) {
                child.setParent(this);
            }
        }
    }

    public void replaceChild(String nodeId, CObject constraint) {
        int index = getIndexOfChildWithNodeId(nodeId);
        if (index > -1) {
            children.set(index, constraint);
            constraint.setParent(this);
        } else {
            addChild(constraint);
        }
    }

    /**
     * Replace the child at node nodeId with all the objects from the parameter newChildren.
     * If keepOriginal is true, it will not replace the original, but keep it in place
     * and add the new elements directly after it
     * Useful operation for flattening
     */
    public void replaceChildren(String nodeId, List<CObject> newChildren, boolean keepOriginal) {
        int index = getIndexOfChildWithNodeId(nodeId);
        if (index > -1) {
            List<CObject> childrenBefore = children.subList(0, index + 1);
            if (!keepOriginal) {
                childrenBefore.remove(index);
            }
            childrenBefore.addAll(newChildren);
            for (CObject constraint : newChildren) {
                constraint.setParent(this);
            }
        } else {
            for (CObject constraint : newChildren) {
                addChild(constraint);
            }
        }
    }

    public int getIndexOfMatchingCObjectChild(CObject child) {
        if (child instanceof CPrimitiveObject) {
            return getIndexOfChildWithMatchingRmTypeName(child.getRmTypeName());
        } else {
            return getIndexOfChildWithNodeId(child.getNodeId());
        }
    }

    public int getIndexOfChildWithMatchingRmTypeName(String rmTypeName) {
        for (int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if (rmTypeName.equals(child.getRmTypeName())) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexOfChildWithNodeId(String nodeId) {
        for (int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if (nodeId.equals(child.getNodeId())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Return all children that have the exact same type name as input.
     *
     * @param rmTypeName
     * @return
     */
    public List<CObject> getChildrenByRmTypeName(String rmTypeName) {
        List<CObject> result = new ArrayList<>();

        for (int i = 0; i < children.size(); i++) {
            CObject child = children.get(i);
            if (rmTypeName.equals(child.getRmTypeName())) {
                result.add(child);
            }
        }
        return result;
    }


    /**
     * Get the sum of all occurrences of all direct children of this c_attribute
     * calculates sum of all occurrences lower bounds; where no occurrences are stated, 0 is assumed
     *
     * @return
     */
    public int getAggregateOccurrencesLowerSum() {
        int sum = 0;
        for (CObject cObject : getChildren()) {
            if (cObject.getOccurrences() != null) {
                sum += cObject.getOccurrences().getLower();
            }
        }
        return sum;
    }

    /**
     * calculate minimum number of child objects that must occur in data; count 1 for every mandatory
     * object, and 1 for all optional objects
     *
     * @return
     */
    public int getMinimumChildCount() {
        int result = 0;
        boolean foundOptional = false;
        for (CObject cObject : getChildren()) {
            if (cObject.isRequired()) {
                result++;
            } else if (cObject.isAllowed()) {
                foundOptional = true;
            }
        }
        if (foundOptional) {
            result++;
        }
        return result;
    }

    /**
     * Path to the parent object of this attribute (i.e.
     * doesn’t include the name of this attribute).
     * Used only for attributes in differential form, specialised archetypes.
     * Enables only the re-defined parts of a specialised archetype to be expressed, at the path where they occur.
     * cardinality: 0..1
     */
    public String getDifferentialPath() {
        return differentialPath;
    }

    public void setDifferentialPath(String value) {
        this.differentialPath = value;
    }

    /**
     * Cardinality constraint of attribute, if a container attribute.
     * cardinality: 0..1
     */
    public Cardinality getCardinality() {
        return cardinality;
    }

    public void setCardinality(Cardinality value) {
        this.cardinality = value;
    }

    /**
     * Flag indicating whether this attribute constraint is on a container (i.e.
     * multiply-valued) attribute.
     * cardinality: 1..1
     */
    public Boolean isMultiple() {
        return isMultiple;
    }

    public void setMultiple(Boolean value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:isMultiple failed, it has cardinality NonNull, but is null");
        }
        this.isMultiple = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if there is no effective constraint on the children of the RM attribute to which this C_ATTRIBUTE refers.
     * cardinality: 1..1
     * <p>
     * Post: Result := children.is_empty and not is_prohibited
     */
    public boolean anyAllowed() {
        return children.isEmpty() && !isProhibited();
    }


    /**
     * True if this C_ATTRIBUTE has an existence constraint of 1..1, i..e.
     * mandation.
     * cardinality: 1..1
     * <p>
     * Post: Result = existence /= Void and then existence.is_mandatory
     */
    public boolean isMandatory() {
        if (existence != null) {
            return existence.isMandatory();
        }
        return false;
    }


    /**
     * Path of this attribute with respect to owning C_OBJECT, including differential path where applicable.
     * cardinality: 1..1
     */
    public String rmAttributePath() {
        String result = null;
        //TODO

        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this node logically represents a single-valued attribute.
     * Evaluated as not is_multiple.
     * cardinality: 1..1
     */
    public boolean isSingle() {
        return !isMultiple;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (effected)
     * <p>
     * Post: Result = existence = Void and is_single and other.is_single) or (is_multiple and other.is_multiple and cardinality = Void
     */
    public boolean cCongruentTo(ArchetypeConstraint other) {
        if (other == null) {
            throw new NullPointerException(" Parameter:other failed, it has cardinality NonNull, but is null");
        }
        return existence == null
                && ((isSingle()
                && ((CAttribute) other).isSingle())
                || (isMultiple()
                && ((CAttribute) other).isMultiple()
                && cardinality == null)
        );
    }

    public boolean cConformsTo(CAttribute other) {
        //True if this node on its own (ignoring any subparts) expresses the same or narrower constraints as `other'.
        // Returns False if any of the following is incompatible:
        //	 * cardinality
        //   * existence
        if (other == null) {
            return false;
        }

        return existenceConformsTo(other) && ((isSingle() && other.isSingle()) || (isMultiple() && cardinalityConformsTo(other)));
    }


    public Boolean existenceConformsTo(CAttribute other) {
        //True if the existence of this node conforms to other.existence
        if (other == null) {
            return false;
        }
        if (existence != null && other.existence != null) {
            return other.existence.contains(existence);
        } else {
            return true;
        }
    }

    public Boolean cardinalityConformsTo(CAttribute other) {
        //True if the cardinality of this node conforms to other.cardinality, if it exists
        if (other == null) {
            return false;
        }
        if (cardinality != null && other.cardinality != null) {
            return other.cardinality.getInterval().contains(cardinality.getInterval());
        } else {
            return true;
        }
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    @Override
    public boolean isLeaf() {
        return children == null || children.size() == 0;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * cardinality: 1..1 (effected)
     * <p>
     * Post: Result = existence_conforms_to (other) and is_single and other.is_single) or else (is_multiple and cardinality_conforms_to (other)
     */
    public boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return cConformsTo((CAttribute) other);
    }

    /**
     * True if this C_ATTRIBUTE has an existence constraint of 0..0, i.e.
     * prohibition.
     * cardinality: 1..1 (effected)
     * <p>
     * Post: Result = existence /= Void and then existence.is_prohibited
     */
    @Override
    public boolean isProhibited() {
        if (existence != null) {
            return existence.isProhibited();
        }
        return false;
    }

    @Override
    public List<PathSegment> getPathSegments() {
        CObject parent = getParent();
        if (parent == null) {
            return new ArrayList<>();
        }
        List<PathSegment> segments = parent.getPathSegments();
        if (differentialPath == null) {
            segments.add(new PathSegment(getRmAttributeName()));
        } else {
            segments.addAll(new APathQuery(differentialPath).getPathSegments());
        }
        return segments;
    }

    @Override
    public CObject getParent() {
        return (CObject) super.getParent();
    }

    //***** CAttribute *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/

    public CAttribute(
            String rmAttributeName,
            MultiplicityInterval existence,
            List<CObject> children,
            String differentialPath,
            Cardinality cardinality,
            Boolean isMultiple,
            //ArchetypeConstraint
            ArchetypeConstraint parent,
            CSecondOrder socParent
    ) {
        super(
                parent,
                socParent
        );
        if (rmAttributeName == null) {
            throw new NullPointerException("Property:rmAttributeName has cardinality NonNull, but is null");
        }
        if (isMultiple == null) {
            throw new NullPointerException("Property:isMultiple has cardinality NonNull, but is null");
        }
        this.rmAttributeName = rmAttributeName;
        this.existence = existence;
        this.children = children;
        this.differentialPath = differentialPath;
        this.cardinality = cardinality;
        this.isMultiple = isMultiple;
    }

    private CAttribute(Builder builder) {
        this(
                builder.rmAttributeName,
                builder.existence,
                builder.children,
                builder.differentialPath,
                builder.cardinality,
                builder.isMultiple,
                builder.parent,
                builder.socParent);
    }

    public static class Builder {
        private final String rmAttributeName;  //required
        private MultiplicityInterval existence;
        private List<CObject> children;
        private String differentialPath;
        private Cardinality cardinality;
        private final Boolean isMultiple;  //required
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder(
                String rmAttributeName,
                Boolean isMultiple
        ) {
            this.rmAttributeName = rmAttributeName;
            this.isMultiple = isMultiple;
        }

        public Builder setExistence(MultiplicityInterval value) {
            this.existence = value;
            return this;
        }

        public Builder setChildren(List<CObject> value) {
            this.children = value;
            return this;
        }

        public Builder setDifferentialPath(String value) {
            this.differentialPath = value;
            return this;
        }

        public Builder setCardinality(Cardinality value) {
            this.cardinality = value;
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

        public CAttribute build() {
            return new CAttribute(this);
        }
    }


    //***** CAttribute *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CAttribute that = (CAttribute) object;
        return
                Objects.equals(rmAttributeName, that.rmAttributeName) &&
                        Objects.equals(existence, that.existence) &&
                        Objects.equals(children, that.children) &&
                        Objects.equals(differentialPath, that.differentialPath) &&
                        Objects.equals(cardinality, that.cardinality) &&
                        Objects.equals(isMultiple, that.isMultiple);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                rmAttributeName,
                existence,
                children,
                differentialPath,
                cardinality,
                isMultiple
        );
    }

    @Override
    public String toString() {
        return
                "CAttribute {" +
                        "rmAttributeName='" + rmAttributeName + '\'' +
                        "existence='" + existence + '\'' +
                        "children='" + children + '\'' +
                        "differentialPath='" + differentialPath + '\'' +
                        "cardinality='" + cardinality + '\'' +
                        "isMultiple='" + isMultiple + '\'' +
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
