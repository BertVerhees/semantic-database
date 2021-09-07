package nl.rosa.semanticdatabase.bmm.model_structure;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Meta-type defining a generalised module concept.
 * Descendants define actual structure and contents.
 */
public abstract class BmmModule extends BmmDeclaration {

    //***** BmmModule *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Model within which module is defined.
     * cardinality: 1..1 (redefined)
     */
    private BmmModel scope;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Model within which module is defined.
     * cardinality: 1..1 (redefined)
     */
    public BmmModel getScope() {
        return scope;
    }

    public void setScope(BmmModel value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    //***** BmmModule *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmModule() {
    }

    protected BmmModule(
            BmmModel scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                name,
                documentation,
                extensions
        );
        if (scope == null) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }


    //***** BmmModule *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmModule that = (BmmModule) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmModule.java
                Objects.equals(scope, that.scope);
=======
                java.util.Objects.equals(scope, that.scope);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/model_structure/BmmModule.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                scope
        );
    }

    @Override
    public String toString() {
        return
                "BmmModule {" +
                        "scope='" + scope + '\'' +
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
