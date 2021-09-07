package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definition of a symbolic operator associated with a function.
 */
public class BmmOperator {

    //***** BmmOperator *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Position of operator in syntactic representation.
     * cardinality: 1..1
     */
    private BmmOperatorPosition position;

    /**
     * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
     * cardinality: 1..1
     */
    private List<String> symbols = new ArrayList<>();

    /**
     * Formal name of the operator, e.g.
     * 'minus' etc.
     * cardinality: 1..1
     */
    private String name;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Position of operator in syntactic representation.
     * cardinality: 1..1
     */
    public BmmOperatorPosition getPosition() {
        return position;
    }

    public void setPosition(BmmOperatorPosition value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:position failed, it has cardinality NonNull, but is null");
        }
        this.position = position;
    }

    /**
     * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
     * cardinality: 1..1
     */

    public void addToSymbol(String value) {
        symbols.add(value);
    }

    public void addToSymbols(List<String> values) {
        values.forEach(value -> addToSymbol(value));
    }

    public void removeFromSymbol(String item) {
        if (symbols != null) {
            symbols.remove(item);
        }
    }

    public void removeFromSymbols(Collection<String> values) {
        values.forEach(this::removeFromSymbol);
    }

    List<String> getSymbols() {
        return this.symbols;
    }

    public BmmOperator setSymbols(List<String> symbols) {
        if (symbols == null) {
            throw new NullPointerException(" symbols has cardinality NonNull, but is null");
        }
        this.symbols = symbols;
        return this;
    }

    public List<String> symbols() {
        return Collections.unmodifiableList(this.symbols);
    }

    /**
     * Formal name of the operator, e.g.
     * 'minus' etc.
     * cardinality: 1..1
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    //***** BmmOperator *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmOperator() {
    }

    public BmmOperator(
            BmmOperatorPosition position,
            List<string> symbols,
            String name
    ) {
        if (position == null) {
            throw new NullPointerException("Property:position has cardinality NonNull, but is null");
        }
        if (symbols == null) {
            throw new NullPointerException("Property:symbols has cardinality NonNull, but is null");
        }
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.position = position;
        this.symbols = symbols;
        this.name = name;
    }

    private BmmOperator(Builder builder) {
        this.setPosition(builder.position);
        this.setSymbols(builder.symbols);
        this.setName(builder.name);
    }

    public static class Builder {
        private final BmmOperatorPosition position;  //required
        private final List<string> symbols;  //required
        private final String name;  //required

        public Builder(
                BmmOperatorPosition position,
                List<string> symbols,
                String name
        ) {
            if (position == null) {
                throw new NullPointerException("Property:position has cardinality NonNull, but is null");
            }
            if (symbols == null) {
                throw new NullPointerException("Property:symbols has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            this.position = position;
            this.symbols = symbols;
            this.name = name;
        }

        public BmmOperator build() {
            return new BmmOperator(this);
        }
    }


    //***** BmmOperator *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmOperator that = (BmmOperator) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmOperator.java
                Objects.equals(position, that.position) &&
                        Objects.equals(symbols, that.symbols) &&
                        Objects.equals(name, that.name);
=======
                java.util.Objects.equals(position, that.position) &&
                        java.util.Objects.equals(symbols, that.symbols) &&
                        java.util.Objects.equals(name, that.name);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmOperator.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                position,
                symbols,
                name
        );
    }

    @Override
    public String toString() {
        return
                "BmmOperator {" +
                        "position='" + position + '\'' +
                        "symbols='" + symbols + '\'' +
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
