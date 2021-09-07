package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import nl.rosa.semanticdatabase.base.BMMCodeDefinitions;
import nl.rosa.semanticdatabase.utils.paths.PathSegment;
import nl.rosa.semanticdatabase.utils.paths.PathUtil;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract parent of all constraint model types.
 * Defines conformance and congruence function signatures.
 */
public abstract class ArchetypeConstraint extends BMMCodeDefinitions {

    //***** ArchetypeConstraint *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Parent node, except in the case of the top of a tree, i.e.
     * root C_COMPLEX_OBJECT of an archetype definition.
     * cardinality: 0..1
     */
    private ArchetypeConstraint parent;

    /**
     * cardinality: 0..1
     */
    private CSecondOrder socParent;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Parent node, except in the case of the top of a tree, i.e.
     * root C_COMPLEX_OBJECT of an archetype definition.
     * cardinality: 0..1
     */
    public ArchetypeConstraint getParent() {
        return parent;
    }

    public void setParent(ArchetypeConstraint value) {
        this.parent = value;
    }

    /**
     * cardinality: 0..1
     */
    public CSecondOrder getSocParent() {
        return socParent;
    }

    public void setSocParent(CSecondOrder value) {
        this.socParent = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if this node is prohibited.
     * Implemented in subtypes.
     * cardinality: 1..1 (abstract)
     */
    // implemented in CObject
    public abstract boolean isProhibited();

    /**
     * True if the relative path a_path exists at this node.
     * cardinality: 1..1
     */
    public boolean hasPath(String a_path) {
        if (a_path == null) {
            throw new NullPointerException("Parameter a_path has cardinality NonNull, but is null.");
        }
        //TODO Check
        return getPath().endsWith(a_path);
    }

    private String getPath() {
        return PathUtil.getPath(getPathSegments());
    }

    private void setPath(String path) {
        //setter hack for jackson, unfortunately
    }

    public abstract List<PathSegment> getPathSegments();

    /**
     * Path of this node relative to root of archetype.
     * cardinality: 1..1
     */
    public String path() {
        return getPath();
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of special-ised archetype nodes.
     * Parameters rmcc RM conformance checker - a lambda (i.e.
     * function object) that can compute conformance of type-names within the Reference Model on which the current archetype is based.
     * The signature provides two arguments representing respectively, the rm_type_name of the current node and the rm_type_name of the node being redefined in a specialisation parent archetype.
     * cardinality: 1..1 (abstract)
     */
    public abstract boolean cConformsTo(ArchetypeConstraint other, BiFunction<String, String, Boolean> rmTypesConformant);

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (abstract)
     */
    public abstract boolean cCongruentTo(ArchetypeConstraint other);

    /**
     * True if there is a second order constraint such as a tuple constraint on this node.
     * cardinality: 1..1
     * Post: soc_parent /= Void or else (parent /= Void and then parent.is_second_order_constrained)
     */
    public boolean isSecondOrderConstrained() {
        return getSocParent() != null || (getParent() != null && getParent().getSocParent() != null);
    }

    /**
     * True if this node is the root of the tree.
     * cardinality: 1..1
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * True if this node is a terminal node in the tree structure, i.e.
     * having no child nodes.
     * cardinality: 1..1
     */
    public abstract boolean isLeaf();

    //***** ArchetypeConstraint *****

    /*=========================================================*/
    /* * CONSTRUCTOR * */
    /*=========================================================*/

    protected ArchetypeConstraint(ArchetypeConstraint parent, CSecondOrder socParent) {
        this.parent = parent;
        this.socParent = socParent;
    }



    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeConstraint that = (ArchetypeConstraint) object;
        return
                Objects.equals(parent, that.parent) &&
                        Objects.equals(socParent, that.socParent);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                parent,
                socParent
        );
    }

    @Override
    public java.lang.String toString() {
        return
                "ArchetypeConstraint {" +
                        "parent='" + parent + '\'' +
                        "socParent='" + socParent + '\'' +
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
