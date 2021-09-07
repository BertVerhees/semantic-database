package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

import semanticdatabase.base.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Special type representing the type of a tuple, i.e.
 * an array of any number of other types.
 * This includes both container and unitary types, since tuple instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any generic type, but open generic parameters are only valid within the scope of a generic class.
 */
public class BmmTupleType extends BmmEffectiveType {

    //***** BmmTupleType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * List of types of the items of the tuple, keyed by purpose in the tuple.
     * cardinality: 1..1
     */
    private Map<String, BmmType> itemTypes = new HashMap<>();

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * List of types of the items of the tuple, keyed by purpose in the tuple.
     * cardinality: 1..1
     */

    public void putItemType(String key, BmmType value) {
        itemTypes.put(key, value);
    }

    public void putItemTypes(Map<String, BmmType> items) {
        items.keySet().forEach(key -> putItemtype(key, items.get(key)));
    }

    public BmmType getItemType(String key) {
        return itemTypes.get(key);
    }

    public void removeItemType(String key) {
        if (itemTypes != null) {
            itemTypes.remove(key);
        }
    }

    public void removeItemTypes(Collection<String> keys) {
        keys.forEach(this::removeItemType);
    }

    public Map<String, BmmType> getItemTypes() {
        return this.itemTypes;
    }

    public BmmTupleType setItemTypes(Map<String, BmmType> itemTypes) {
        if (itemTypes == null) {
            throw new NullPointerException(" itemTypes has cardinality NonNull, but is null");
        }
        this.itemTypes = itemTypes;
        return this;
    }

    public Map<String, BmmType> itemTypes() {
        return Collections.unmodifiableMap(this.itemTypes);
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * Return base_name.
 * cardinality: 1..1 (effected)
 *
 */
    public Result.is_equal(

    base_name())

    typeBaseName() {
        Result.is_equal(base_name()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Result = True.
     * cardinality: 1..1 (effected)
     */
    public Boolean isPrimitive() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Result = False.
     * cardinality: 1..1 (effected)
     */
    public Boolean isAbstract() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

/**
 *
 * Return base_name.
 * cardinality: 1..1 (effected)
 *
 */
    public Result.is_equal(

    base_name())

    typeName() {
        Result.is_equal(base_name()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return the logical set (i.e.
     * unique types) from the merge of flattened_type_list() called on each member of item_types.
     * cardinality: 1..1 (effected)
     */
    public List<String> flattenedTypeList() {
        List<String> result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Base name (built-in).
     */
    final String baseName = "Tuple";

    //***** BmmTupleType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmTupleType() {
    }

    public BmmTupleType(
            Map<string, bmmType> itemTypes
    ) {
        if (itemTypes == null) {
            throw new NullPointerException("Property:itemTypes has cardinality NonNull, but is null");
        }
        this.itemTypes = itemTypes;
    }

    private BmmTupleType(Builder builder) {
        this.setItemTypes(builder.itemTypes);
    }

    public static class Builder {
        private final Map<string, bmmType> itemTypes;  //required

        public Builder(
                Map<string, bmmType> itemTypes
        ) {
            if (itemTypes == null) {
                throw new NullPointerException("Property:itemTypes has cardinality NonNull, but is null");
            }
            this.itemTypes = itemTypes;
        }

        public BmmTupleType build() {
            return new BmmTupleType(this);
        }
    }


    //***** BmmTupleType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmTupleType that = (BmmTupleType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/types/BmmTupleType.java
                Objects.equals(itemTypes, that.itemTypes);
=======
                java.util.Objects.equals(itemTypes, that.itemTypes);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/types/BmmTupleType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                itemTypes
        );
    }

    @Override
    public String toString() {
        return
                "BmmTupleType {" +
                        "itemTypes='" + itemTypes + '\'' +
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
