package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A statement 'block' corresponding to the programming language concept of the same name.
 * May be used to establish scope in specific languages.
 */
public class BmmStatementBlock extends BmmStatementItem {

    //***** BmmStatementBlock *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Child blocks of the current block.
     * cardinality: 0..1
     */
    private List<BmmStatementItem> items;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Child blocks of the current block.
     * cardinality: 0..1
     */

    public void addToItem(BmmStatementItem value) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(value);
    }

    public void addToItems(List<BmmStatementItem> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(BmmStatementItem item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<BmmStatementItem> values) {
        values.forEach(this::removeFromItem);
    }

    List<BmmStatementItem> getItems() {
        return this.items;
    }

    public BmmStatementBlock setItems(List<BmmStatementItem> items) {
        this.items = items;
        return this;
    }

    public List<BmmStatementItem> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** BmmStatementBlock *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmStatementBlock() {
    }

    public BmmStatementBlock(
            List<bmmStatementItem> items
    ) {
        this.items = items;
    }

    private BmmStatementBlock(Builder builder) {
        this.setItems(builder.items);
    }

    public static class Builder {
        private List<bmmStatementItem> items;

        public Builder(
        ) {
        }

        public Builder setItems(List<bmmStatementItem> value) {
            this.items = items;
            return this;
        }

        public BmmStatementBlock build() {
            return new BmmStatementBlock(this);
        }
    }


    //***** BmmStatementBlock *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmStatementBlock that = (BmmStatementBlock) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmStatementBlock.java
                Objects.equals(items, that.items);
=======
                java.util.Objects.equals(items, that.items);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmStatementBlock.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                items
        );
    }

    @Override
    public String toString() {
        return
                "BmmStatementBlock {" +
                        "items='" + items + '\'' +
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
