package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Multi-branch conditional statement structure
 */
public class BmmActionTable extends BmmStatement {

    //***** BmmActionTable *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Decision branches.
     * cardinality: 1..1
     */
    private List<BmmConditionalAction> items = new ArrayList<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Decision branches.
     * cardinality: 1..1
     */

    public void addToItem(BmmConditionalAction value) {
        items.add(value);
    }

    public void addToItems(List<BmmConditionalAction> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(BmmConditionalAction item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<BmmConditionalAction> values) {
        values.forEach(this::removeFromItem);
    }

    List<BmmConditionalAction> getItems() {
        return this.items;
    }

    public BmmActionTable setItems(List<BmmConditionalAction> items) {
        if (items == null) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }

    public List<BmmConditionalAction> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** BmmActionTable *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmActionTable() {
    }

    public BmmActionTable(
            List<bmmConditionalAction> items
    ) {
        if (items == null) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        this.items = items;
    }

    private BmmActionTable(Builder builder) {
        this.setItems(builder.items);
    }

    public static class Builder {
        private final List<bmmConditionalAction> items;  //required

        public Builder(
                List<bmmConditionalAction> items
        ) {
            if (items == null) {
                throw new NullPointerException("Property:items has cardinality NonNull, but is null");
            }
            this.items = items;
        }

        public BmmActionTable build() {
            return new BmmActionTable(this);
        }
    }


    //***** BmmActionTable *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmActionTable that = (BmmActionTable) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmActionTable.java
                Objects.equals(items, that.items);
=======
                java.util.Objects.equals(items, that.items);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmActionTable.java
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
                "BmmActionTable {" +
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
