package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Compound expression consisting of a list of value-range / expression pairs, and an else member that as a whole, represents a case statement flavour of decision table.
 * Evaluated by iterating through items and for each one, comparing input to the item value_range.
 * If the input is in the range, the evaluation result of the table is that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 */
public class ElCaseTable extends ElDecisionTable {

    //***** ElCaseTable *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Input value that is compared against each items[i].value_range to determine the overall result.
     * cardinality: 1..1
     */
    private ElSimple input;

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1 (redefined)
     */
    private List<ElCase> items = new ArrayList<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Input value that is compared against each items[i].value_range to determine the overall result.
     * cardinality: 1..1
     */
    public ElSimple getInput() {
        return input;
    }

    public void setInput(ElSimple value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:input failed, it has cardinality NonNull, but is null");
        }
        this.input = input;
    }

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1 (redefined)
     */

    public void addToItem(ElCase value) {
        items.add(value);
    }

    public void addToItems(List<ElCase> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(ElCase item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<ElCase> values) {
        values.forEach(this::removeFromItem);
    }

    List<ElCase> getItems() {
        return this.items;
    }

    public ElCaseTable setItems(List<ElCase> items) {
        if (items == null) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }

    public List<ElCase> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** ElCaseTable *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElCaseTable() {
    }

    public ElCaseTable(
            ElSimple input,
            List<elCase> items,
            ElExpression else,
            List<elDecisionBranch> items
    ) {
        super( 
            else
        );
        if (input == null) {
            throw new NullPointerException("Property:input has cardinality NonNull, but is null");
        }
        if (items == null) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        this.input = input;
        this.items = items;
    }

    private ElCaseTable(Builder builder) {
        this.setInput(builder.input);
        this.setItems(builder.items);
        this.setElse(builder.else );
        this.setItems(builder.items);
    }

    public static class Builder {
        private final ElSimple input;  //required
        private final List<elCase> items;  //required
        private final ElExpression else;  //required
        private final List<elDecisionBranch> items;  //required

        public Builder(
                ElSimple input,
                List<elCase> items,
                ElExpression else,
                List<elDecisionBranch> items
        ) {
            if (input == null) {
                throw new NullPointerException("Property:input has cardinality NonNull, but is null");
            }
            if (items == null) {
                throw new NullPointerException("Property:items has cardinality NonNull, but is null");
            }
            if ( else ==null ){
                throw new NullPointerException("Property:else has cardinality NonNull, but is null");
            }
            if (items == null) {
                throw new NullPointerException("Property:items has cardinality NonNull, but is null");
            }
            this.input = input;
            this.items = items;
            this.else = else;
            this.items = items;
        }

        public ElCaseTable build() {
            return new ElCaseTable(this);
        }
    }


    //***** ElCaseTable *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElCaseTable that = (ElCaseTable) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElCaseTable.java
                Objects.equals(input, that.input) &&
                        Objects.equals(items, that.items);
=======
                java.util.Objects.equals(input, that.input) &&
                        java.util.Objects.equals(items, that.items);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElCaseTable.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                input,
                items
        );
    }

    @Override
    public String toString() {
        return
                "ElCaseTable {" +
                        "input='" + input + '\'' +
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
