package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Terminal item corresponding to a reference to a directly instantiable entity, i.e.
 * a variable, constant, or property.
 */
public class ElInstantiableRef<t> extends ElScopedRef {

    //***** ElInstantiableRef<t> *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
     * cardinality: 0..1
     */
    private T definition;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
     * cardinality: 0..1
     */
    public T getDefinition() {
        return definition;
    }

    public void setDefinition(T value) {
        this.definition = definition;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Type definition (i.e.
     * BMM meta-type definition object) of the constant, property or variable, inferred by inspection of the current scoping instance.
     * Return definition.type.
     * cardinality: 1..1 (effected)
     */
    public BmmType evalType() {
        BmmType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElInstantiableRef<t> *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElInstantiableRef<t>()

    {
    }

    public ElInstantiableRef<t>(
    T definition,
    ElInstanceRef scope
        )

    {
        super(
                scope
        );
        this.definition = definition;
    }

    private ElInstantiableRef<t>(
    Builder builder)

    {
        this.setDefinition(builder.definition);
        this.setScope(builder.scope);
    }

    public static class Builder {
        private T definition;
        private ElInstanceRef scope;

        public Builder(
        ) {
        }

        public Builder setDefinition(T value) {
            this.definition = definition;
            return this;
        }

        public Builder setScope(ElInstanceRef value) {
            this.scope = scope;
            return this;
        }

        public ElInstantiableRef<t> build() {
            return new ElInstantiableRef<t>(this);
        }
    }


    //***** ElInstantiableRef<t> *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElInstantiableRef<t> that = (ElInstantiableRef<t>) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElInstantiableRef.java
                Objects.equals(definition, that.definition);
=======
                java.util.Objects.equals(definition, that.definition);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElInstantiableRef.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                definition
        );
    }

    @Override
    public String toString() {
        return
                "ElInstantiableRef<t> {" +
                        "definition='" + definition + '\'' +
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
