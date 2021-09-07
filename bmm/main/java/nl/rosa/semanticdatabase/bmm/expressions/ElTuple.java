package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmTupleType;
import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Defines an array of optionally named items each of any type.
 */
public class ElTuple extends ElInstanceRef {

    //***** ElTuple *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Items in the tuple, potentially with names.
     * Typical use is to represent an argument list to routine call.
     * cardinality: 0..1
     */
    private List<ElTupleItem> items;

    /**
     * Static type inferred from literal value.
     * cardinality: 1..1
     */
    private BmmTupleType type;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Items in the tuple, potentially with names.
     * Typical use is to represent an argument list to routine call.
     * cardinality: 0..1
     */

    public void addToItem(ElTupleItem value) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(value);
    }

    public void addToItems(List<ElTupleItem> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(ElTupleItem item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<ElTupleItem> values) {
        values.forEach(this::removeFromItem);
    }

    List<ElTupleItem> getItems() {
        return this.items;
    }

    public ElTuple setItems(List<ElTupleItem> items) {
        this.items = items;
        return this;
    }

    public List<ElTupleItem> items() {
        return Collections.unmodifiableList(this.items);
    }

    /**
     * Static type inferred from literal value.
     * cardinality: 1..1
     */
    public BmmTupleType getType() {
        return type;
    }

    public void setType(BmmTupleType value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return type.
     * cardinality: 1..1 (effected)
     */
    public BmmType evalType() {
        BmmType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElTuple *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElTuple() {
    }

    public ElTuple(
            List<elTupleItem> items,
            BmmTupleType type
    ) {
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.items = items;
        this.type = type;
    }

    private ElTuple(Builder builder) {
        this.setItems(builder.items);
        this.setType(builder.type);
    }

    public static class Builder {
        private List<elTupleItem> items;
        private final BmmTupleType type;  //required

        public Builder(
                BmmTupleType type
        ) {
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            this.type = type;
        }

        public Builder setItems(List<elTupleItem> value) {
            this.items = items;
            return this;
        }

        public ElTuple build() {
            return new ElTuple(this);
        }
    }


    //***** ElTuple *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElTuple that = (ElTuple) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElTuple.java
                Objects.equals(items, that.items) &&
                        Objects.equals(type, that.type);
=======
                java.util.Objects.equals(items, that.items) &&
                        java.util.Objects.equals(type, that.type);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElTuple.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                items,
                type
        );
    }

    @Override
    public String toString() {
        return
                "ElTuple {" +
                        "items='" + items + '\'' +
                        "type='" + type + '\'' +
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
