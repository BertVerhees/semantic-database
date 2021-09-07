package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Object representing a constraint on an atttribute tuple, i.e.
 * a group of attributes that are constrained together.
 * Typically used for representing co-varying constraints like {units, range} constraints.
 */
public class CAttributeTuple extends CSecondOrder<CAttribute> {

    //***** CAttributeTuple *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Tuple definitions.
     * cardinality: 0..1
     */
    private List<CPrimitiveTuple> tuples;

    /**
     * List of C_ATTRIBUTEs forming the definition of the tuple.
     * cardinality: 0..1 (redefined)
     */
    private List<CAttribute> members;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Tuple definitions.
     * cardinality: 0..1
     */

    public void addTuple(CPrimitiveTuple value) {
        if (tuples == null) {
            tuples = new ArrayList<>();
        }
        tuples.add(value);
    }

    public void removeTuple(CPrimitiveTuple item) {
        if (tuples != null) {
            tuples.remove(item);
        }
    }

    public List<CPrimitiveTuple> getTuples() {
        return this.tuples;
    }

    public CAttributeTuple setTuples(List<CPrimitiveTuple> tuples) {
        this.tuples = tuples;
        return this;
    }

    /**
     * List of C_ATTRIBUTEs forming the definition of the tuple.
     * cardinality: 0..1 (redefined)
     */

    public void addMember(CAttribute value) {
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(value);
    }

    public void removeFromMember(CAttribute item) {
        if (members != null) {
            members.remove(item);
        }
    }

    public List<CAttribute> getMembers() {
        return this.members;
    }

    public void setMembers(List<CAttribute> members) {
        this.members = members;
    }


    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
     * Typically used during validation of specialised archetype nodes.
     * Parameters rmcc RM conformance checker agent - a lambda (i.e.
     * function object) that can compute conformance of type-names within the Reference Model on which the current archetype is based.
     * The signature provides two arguments representing respectively, the rm_type_name of the current node and the rm_type_name of the node being redefined in a specialisation parent archetype.
     * cardinality: 1..1 (abstract)
     */
<<<<<<< HEAD
    public boolean cConformsTo(CSecondOrder other, BiFunction<String, String, Boolean> rmTypesConformant) {
=======
    public boolean cConformsTo(CSecondOrder other, BiFunction<String, String, java.lang.Boolean> rmTypesConformant) {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return allTuplesConform((CAttributeTuple) other, rmTypesConformant) || isSubset((CAttributeTuple) other);
    }

    /**
     * Return true if and only if the other tuple is a subset of the exact same tuples as this.
     *
     * @param other
     * @return
     */
    private boolean isSubset(CAttributeTuple other) {
        return getTuples().size() < other.getTuples().size() &&
                getTuples().stream().allMatch((primitiveTuple) ->
                        other.getTuples().stream().anyMatch((otherPrimitiveTuple) -> otherPrimitiveTuple.cCongruentTo(primitiveTuple)));
    }

    /**
     * Return true if all of the tuples of this object conform to the tuples of the other object
     *
     * @param other
     * @param rmTypesConformant function that returns whether to rm type names are conformant or not
     * @return
     */
<<<<<<< HEAD
    private boolean allTuplesConform(CAttributeTuple other, BiFunction<String, String, Boolean> rmTypesConformant) {
=======
    private boolean allTuplesConform(CAttributeTuple other, BiFunction<String, String, java.lang.Boolean> rmTypesConformant) {
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa
        return this.getTuples().stream().allMatch((primitiveTuple) ->
                other.getTuples().stream().anyMatch((otherPrimitiveTuple) -> otherPrimitiveTuple.cConformsTo(primitiveTuple, rmTypesConformant)));
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
        return true;
    }

    public List<String> getMemberNames() {
        return getMembers().stream().map((attr) -> attr.getRmAttributeName()).collect(Collectors.toList());
    }

    //***** CAttributeTuple *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected CAttributeTuple() {
    }

    public CAttributeTuple(
            List<CPrimitiveTuple> tuples,
            List<CAttribute> members
    ) {
        this.tuples = tuples;
        this.members = members;
    }

    private CAttributeTuple(Builder builder) {
        this(
                builder.tuples,
                builder.members
        );
    }

    public static class Builder {
        private List<CPrimitiveTuple> tuples;
        private List<CAttribute> members;

        public Builder(
        ) {
        }

        public Builder setTuples(List<CPrimitiveTuple> value) {
            this.tuples = tuples;
            return this;
        }

        public Builder setMembers(List<CAttribute> value) {
            this.members = members;
            return this;
        }

        public CAttributeTuple build() {
            return new CAttributeTuple(this);
        }
    }


    //***** CAttributeTuple *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CAttributeTuple that = (CAttributeTuple) object;
        return
                Objects.equals(tuples, that.tuples) &&
                        Objects.equals(members, that.members);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                tuples,
                members
        );
    }

    @Override
    public String toString() {
        return
                "CAttributeTuple {" +
                        "tuples='" + tuples + '\'' +
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
