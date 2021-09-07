package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Compound expression consisting of a chain of condition-gated expressions, and an ungated else member that as a whole, represents an if/then/elseif/else chains.
 * Evaluated by iterating through items and for each one, evaluating its condition, which if True, causes the evaluation result of the chain to be that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 */
public class ElConditionChain extends ElDecisionTable {

    //***** ElConditionChain *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1 (redefined)
     */
    private List<ElConditionalExpression> items = new ArrayList<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
     * cardinality: 1..1 (redefined)
     */

    public void addToItem(ElConditionalExpression value) {
        items.add(value);
    }

    public void addToItems(List<ElConditionalExpression> values) {
        values.forEach(value -> addToItem(value));
    }

    public void removeFromItem(ElConditionalExpression item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void removeFromItems(Collection<ElConditionalExpression> values) {
        values.forEach(this::removeFromItem);
    }

    List<ElConditionalExpression> getItems() {
        return this.items;
    }

    public ElConditionChain setItems(List<ElConditionalExpression> items) {
        if (items == null) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }

    public List<ElConditionalExpression> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** ElConditionChain *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElConditionChain() {
    }

    public ElConditionChain(
            List<elConditionalExpression> items,
            ElExpression else,
            List<elDecisionBranch> items
    ) {
        super( 
            else
        );
        if (items == null) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        this.items = items;
    }

    private ElConditionChain(Builder builder) {
        this.setItems(builder.items);
        this.setElse(builder.else );
        this.setItems(builder.items);
    }

    public static class Builder {
        private final List<elConditionalExpression> items;  //required
        private final ElExpression else;  //required
        private final List<elDecisionBranch> items;  //required

        public Builder(
                List<elConditionalExpression> items,
                ElExpression else,
                List<elDecisionBranch> items
        ) {
            if (items == null) {
                throw new NullPointerException("Property:items has cardinality NonNull, but is null");
            }
            if ( else ==null ){
                throw new NullPointerException("Property:else has cardinality NonNull, but is null");
            }
            if (items == null) {
                throw new NullPointerException("Property:items has cardinality NonNull, but is null");
            }
            this.items = items;
            this.else = else;
            this.items = items;
        }

        public ElConditionChain build() {
            return new ElConditionChain(this);
        }
    }


    //***** ElConditionChain *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElConditionChain that = (ElConditionChain) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConditionChain.java
                Objects.equals(items, that.items);
=======
                java.util.Objects.equals(items, that.items);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElConditionChain.java
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
                "ElConditionChain {" +
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
