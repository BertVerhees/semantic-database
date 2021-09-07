package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Complex expression structure representing a logical decision table.
 */
public abstract class ElDecisionTable extends ElExpression {

    //***** ElDecisionTable *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

/**
 *
 * Result expression of the chain if no member of items succeeds in evaluation.
 * cardinality: 1..1
 *
 */
    private ElExpression else;

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1
     */
    private List<ElDecisionBranch> items = new ArrayList<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Result expression of the chain if no member of items succeeds in evaluation.
     * cardinality: 1..1
     */
    public ElExpression getElse() {
        return else;
    }

    public void setElse(ElExpression value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:else failed, it has cardinality NonNull, but is null");
        }
        this.else = else;
    }

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1
     */

    public void addToItem(ElDecisionBranch value) {
        items.add(value);
    }

    public void addToItems(List<ElDecisionBranch> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(ElDecisionBranch item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<ElDecisionBranch> values) {
        values.forEach(this::removeFromItem);
    }

    List<ElDecisionBranch> getItems() {
        return this.items;
    }

    public ElDecisionTable setItems(List<ElDecisionBranch> items) {
        if (items == null) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }

    public List<ElDecisionBranch> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** ElDecisionTable *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElDecisionTable() {
    }

    protected ElDecisionTable(
            ElExpression else,
            List<elDecisionBranch> items
    ) {
        if ( else ==null ){
            throw new NullPointerException("Property:else has cardinality NonNull, but is null");
        }
        if (items == null) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        this.else = else;
        this.items = items;
    }


    //***** ElDecisionTable *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElDecisionTable that = (ElDecisionTable) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElDecisionTable.java
                Objects.equals(else,that.else) &&
        Objects.equals(items, that.items);
=======
                java.util.Objects.equals(else,that.else) &&
        java.util.Objects.equals(items, that.items);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElDecisionTable.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
            else,
        items
        );
    }

    @Override
    public String toString() {
        return
                "ElDecisionTable {" +
                        "else='" + else+'\'' +
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
