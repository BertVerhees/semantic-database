package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A single tuple item, with an optional name.
 */
public class ElTupleItem {

    //***** ElTupleItem *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to value entity.
     * If Void, this indicates that the item in this position is Void, e.g.
     * within a routine call parameter list.
     * cardinality: 0..1
     */
    private ElExpression item;

    /**
     * Optional name of tuple item.
     * cardinality: 0..1
     */
    private String name;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to value entity.
     * If Void, this indicates that the item in this position is Void, e.g.
     * within a routine call parameter list.
     * cardinality: 0..1
     */
    public ElExpression getItem() {
        return item;
    }

    public void setItem(ElExpression value) {
        this.item = item;
    }

    /**
     * Optional name of tuple item.
     * cardinality: 0..1
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = name;
    }

    //***** ElTupleItem *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElTupleItem() {
    }

    public ElTupleItem(
            ElExpression item,
            String name
    ) {
        this.item = item;
        this.name = name;
    }

    private ElTupleItem(Builder builder) {
        this.setItem(builder.item);
        this.setName(builder.name);
    }

    public static class Builder {
        private ElExpression item;
        private String name;

        public Builder(
        ) {
        }

        public Builder setItem(ElExpression value) {
            this.item = item;
            return this;
        }

        public Builder setName(String value) {
            this.name = name;
            return this;
        }

        public ElTupleItem build() {
            return new ElTupleItem(this);
        }
    }


    //***** ElTupleItem *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElTupleItem that = (ElTupleItem) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElTupleItem.java
                Objects.equals(item, that.item) &&
                        Objects.equals(name, that.name);
=======
                java.util.Objects.equals(item, that.item) &&
                        java.util.Objects.equals(name, that.name);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElTupleItem.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                item,
                name
        );
    }

    @Override
    public String toString() {
        return
                "ElTupleItem {" +
                        "item='" + item + '\'' +
                        "name='" + name + '\'' +
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
