package nl.rosa.semanticdatabase.base.identification;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Ancestor class of identifiers of informational objects.
 * Ids may be completely meaningless, in which case their only job is to refer to something, or may carry some information to do with the identified object.
 * Object ids are used inside an object to identify that object.
 * To identify another object in another service, use an OBJECT_REF, or else use a UID for local objects identified by UID.
 * If none of the subtypes is suitable, direct instances of this class may be used.
 */
public abstract class ObjectId {

    //***** ObjectId *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The value of the id in the form defined below.
     * cardinality: 1..1
     */
    private String value;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The value of the id in the form defined below.
     * cardinality: 1..1
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:value failed, it has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    //***** ObjectId *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ObjectId() {
    }

    protected ObjectId(
            String value
    ) {
        if (value == null) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        this.value = value;
    }


    //***** ObjectId *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ObjectId that = (ObjectId) object;
        return
                Objects.equals(value, that.value);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                value
        );
    }

    @Override
    public String toString() {
        return value;
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
