package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type of linear container type that indexes the contained items in the manner of a standard Hash table, map or dictionary.
 */
public class BmmIndexedContainerType extends BmmContainerType {

    //***** BmmIndexedContainerType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
     * cardinality: 1..1
     */
    private BmmSimpleType indexType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
     * cardinality: 1..1
     */
    public BmmSimpleType getIndexType() {
        return indexType;
    }

    public void setIndexType(BmmSimpleType value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:indexType failed, it has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return full type name, e.g.
     * HashMap<String, ELEMENT>.
     * cardinality: 1..1 (effected)
     */
    public String typeName() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmIndexedContainerType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmIndexedContainerType() {
    }

    public BmmIndexedContainerType(
            BmmSimpleType indexType,
            BmmGenericClass containerClass,
            BmmUnitaryType itemType
    ) {
        super(
                containerClass,
                itemType
        );
        if (indexType == null) {
            throw new NullPointerException("Property:indexType has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
    }

    private BmmIndexedContainerType(Builder builder) {
        this.setIndexType(builder.indexType);
        this.setContainerClass(builder.containerClass);
        this.setItemType(builder.itemType);
    }

    public static class Builder {
        private final BmmSimpleType indexType;  //required
        private final BmmGenericClass containerClass;  //required
        private final BmmUnitaryType itemType;  //required

        public Builder(
                BmmSimpleType indexType,
                BmmGenericClass containerClass,
                BmmUnitaryType itemType
        ) {
            if (indexType == null) {
                throw new NullPointerException("Property:indexType has cardinality NonNull, but is null");
            }
            if (containerClass == null) {
                throw new NullPointerException("Property:containerClass has cardinality NonNull, but is null");
            }
            if (itemType == null) {
                throw new NullPointerException("Property:itemType has cardinality NonNull, but is null");
            }
            this.indexType = indexType;
            this.containerClass = containerClass;
            this.itemType = itemType;
        }

        public BmmIndexedContainerType build() {
            return new BmmIndexedContainerType(this);
        }
    }


    //***** BmmIndexedContainerType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmIndexedContainerType that = (BmmIndexedContainerType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/types/BmmIndexedContainerType.java
                Objects.equals(indexType, that.indexType);
=======
                java.util.Objects.equals(indexType, that.indexType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/types/BmmIndexedContainerType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                indexType
        );
    }

    @Override
    public String toString() {
        return
                "BmmIndexedContainerType {" +
                        "indexType='" + indexType + '\'' +
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
