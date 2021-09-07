package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmType;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_TYPE.
 */
public abstract class PBmmType {

    //***** PBmmType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1
     */
    private BmmType bmmType;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Result of create_bmm_type() call.
     * cardinality: 0..1
     */
    public BmmType getBmmType() {
        return bmmType;
    }

    public void setBmmType(BmmType value) {
        this.bmmType = bmmType;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Create appropriate BMM_XXX object; effected in descendants.
     * cardinality: 0..1 (abstract)
     */
    public abstract void createBmmType(BmmModel a_schema, BmmClass a_class_def);

    /**
     * Formal name of the type for display.
     * cardinality: 1..1 (abstract)
     */
    public abstract String asTypeString();

    //***** PBmmType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmType() {
    }

    protected PBmmType(
            BmmType bmmType
    ) {
        this.bmmType = bmmType;
    }


    //***** PBmmType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmType that = (PBmmType) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmType.java
                Objects.equals(bmmType, that.bmmType);
=======
                java.util.Objects.equals(bmmType, that.bmmType);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm_persistence/persistence_package/PBmmType.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                bmmType
        );
    }

    @Override
    public String toString() {
        return
                "PBmmType {" +
                        "bmmType='" + bmmType + '\'' +
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
