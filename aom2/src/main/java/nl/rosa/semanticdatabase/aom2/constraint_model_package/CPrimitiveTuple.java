package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Class representing a single object tuple instance in a tuple constraint.
 * Each such instance is a vector of object constraints, where each member (each C_PRIMITIVE_OBJECT) corresponds to one of the C_ATTRIBUTEs referred to by the owning C_ATTRIBUTE_TUPLE.
 */
public class CPrimitiveTuple extends CSecondOrder<CPrimitiveObject> {

    //***** CPrimitiveTuple *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Object constraint members of this tuple group.
     * cardinality: 1..1 (redefined)
     */
    private List<CPrimitiveObject> members = new ArrayList<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Object constraint members of this tuple group.
     * cardinality: 1..1 (redefined)
     */

    public void addMember(CPrimitiveObject value) {
        members.add(value);
    }

    public void removeMember(CPrimitiveObject item) {
        if (members != null) {
            members.remove(item);
        }
    }

    public List<CPrimitiveObject> getMembers() {
        return this.members;
    }

    public void setMembers(List<CPrimitiveObject> members) {
        if (members == null) {
            throw new NullPointerException(" members has cardinality NonNull, but is null");
        }
        this.members = members;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of specialised archetype nodes.
     * Parameters rmcc RM conformance checker agent.
     * cardinality: 1..1 (effected)
     */
<<<<<<< HEAD
    public boolean cConformsTo(CSecondOrder other, BiFunction<String, String, Boolean> rmTypesConformant) {
=======
    public boolean cConformsTo(CSecondOrder other, BiFunction<String, String, java.lang.Boolean> rmTypesConformant) {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return this.getMembers().size() == other.getMembers().size() && allTupleMembersConform((CPrimitiveTuple) other, rmTypesConformant);
    }

<<<<<<< HEAD
    private boolean allTupleMembersConform(CPrimitiveTuple other, BiFunction<String, String, Boolean> rmTypesConformant) {
=======
    private boolean allTupleMembersConform(CPrimitiveTuple other, BiFunction<String, String, java.lang.Boolean> rmTypesConformant) {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        for (int i = 0; i < getMembers().size(); i++) {
            CPrimitiveObject member = getMember(i);
            CPrimitiveObject otherMember = other.getMember(i);
            if (!member.getClass().equals(otherMember.getClass()) || !member.cConformsTo(otherMember, rmTypesConformant)) {
                return false;
            }
        }
        return true;
    }

    /**
     * True if constraints represented by this node contain no further redefinitions with respect to the node other.
     * Typically used to test if an inherited node locally contains any constraints.
     * cardinality: 1..1 (effected)
     */
    public boolean cCongruentTo(CSecondOrder other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        boolean result = true;

        return result;
    }

    //***** CPrimitiveTuple *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected CPrimitiveTuple() {
    }

    public CPrimitiveTuple(
            List<CPrimitiveObject> members
    ) {
        if (members == null) {
            throw new NullPointerException("Property:members has cardinality NonNull, but is null");
        }
        this.members = members;
    }

    private CPrimitiveTuple(Builder builder) {
        this(builder.members);
    }

    public static class Builder {
        private final List<CPrimitiveObject> members;  //required

        public Builder(
                List<CPrimitiveObject> members
        ) {
            if (members == null) {
                throw new NullPointerException("Property:members has cardinality NonNull, but is null");
            }
            this.members = members;
        }

        public CPrimitiveTuple build() {
            return new CPrimitiveTuple(this);
        }
    }


    //***** CPrimitiveTuple *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CPrimitiveTuple that = (CPrimitiveTuple) object;
        return
                Objects.equals(members, that.members);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                members
        );
    }

    @Override
    public String toString() {
        return
                "CPrimitiveTuple {" +
                        "members='" + members + '\'' +
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
