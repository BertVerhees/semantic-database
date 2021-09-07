package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A reference that is scoped by a containing entity and requires a context qualifier if it is not the currently scoping entity.
 */
public abstract class ElScopedRef extends ElInstanceRef {

    //***** ElScopedRef *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to an owning object for this terminal element, if it is not the current scope.
     * cardinality: 0..1
     */
    private ElInstanceRef scope;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to an owning object for this terminal element, if it is not the current scope.
     * cardinality: 0..1
     */
    public ElInstanceRef getScope() {
        return scope;
    }

    public void setScope(ElInstanceRef value) {
        this.scope = scope;
    }

    //***** ElScopedRef *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElScopedRef() {
    }

    protected ElScopedRef(
            ElInstanceRef scope
    ) {
        this.scope = scope;
    }


    //***** ElScopedRef *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElScopedRef that = (ElScopedRef) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElScopedRef.java
                Objects.equals(scope, that.scope);
=======
                java.util.Objects.equals(scope, that.scope);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElScopedRef.java
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
                "ElScopedRef {" +
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
