package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.class_features.BmmProcedure;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * An agent whose signature is of a procedure, i.e.
 * has no result type.
 */
public class ElProcedureAgent extends ElAgent {

    //***** ElProcedureAgent *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to definition of routine for which this is a call instance.
     * cardinality: 0..1 (redefined)
     */
    private BmmProcedure definition;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to definition of routine for which this is a call instance.
     * cardinality: 0..1 (redefined)
     */
    public BmmProcedure getDefinition() {
        return definition;
    }

    public void setDefinition(BmmProcedure value) {
        this.definition = definition;
    }

    //***** ElProcedureAgent *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElProcedureAgent() {
    }

    public ElProcedureAgent(
            BmmProcedure definition,
            String name,
            ElTuple closedArgs,
            List<string> openArgs,
            BmmRoutine definition,
            ElInstanceRef scope
    ) {
        super(
                name,
                closedArgs,
                openArgs,
                scope
        );
        this.definition = definition;
    }

    private ElProcedureAgent(Builder builder) {
        this.setDefinition(builder.definition);
        this.setName(builder.name);
        this.setClosedArgs(builder.closedArgs);
        this.setOpenArgs(builder.openArgs);
        this.setDefinition(builder.definition);
        this.setScope(builder.scope);
    }

    public static class Builder {
        private BmmProcedure definition;
        private final String name;  //required
        private ElTuple closedArgs;
        private List<string> openArgs;
        private BmmRoutine definition;
        private ElInstanceRef scope;

        public Builder(
                String name
        ) {
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            this.name = name;
        }

        public Builder setDefinition(BmmProcedure value) {
            this.definition = definition;
            return this;
        }

        public Builder setClosedArgs(ElTuple value) {
            this.closedArgs = closedArgs;
            return this;
        }

        public Builder setOpenArgs(List<string> value) {
            this.openArgs = openArgs;
            return this;
        }

        public Builder setDefinition(BmmRoutine value) {
            this.definition = definition;
            return this;
        }

        public Builder setScope(ElInstanceRef value) {
            this.scope = scope;
            return this;
        }

        public ElProcedureAgent build() {
            return new ElProcedureAgent(this);
        }
    }


    //***** ElProcedureAgent *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElProcedureAgent that = (ElProcedureAgent) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElProcedureAgent.java
                Objects.equals(definition, that.definition);
=======
                java.util.Objects.equals(definition, that.definition);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElProcedureAgent.java
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
                "ElProcedureAgent {" +
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
