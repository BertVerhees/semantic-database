package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A call made on a closed function agent, returning a result.
 * Equivalent to an 'application' of a function in Lambda calculus.
 */
public class ElFunctionCall extends ElScopedRef implements ElAgentCall {

    //***** ElFunctionCall *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The function agent being called.
     * cardinality: 1..1 (redefined)
     */
    private ElFunctionAgent agent;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The function agent being called.
     * cardinality: 1..1 (redefined)
     */
    public ElFunctionAgent getAgent() {
        return agent;
    }

    public void setAgent(ElFunctionAgent value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return agent.definition.type.
     * cardinality: 1..1 (effected)
     */
    public BmmType evalType() {
        BmmType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElAgentCall *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The agent being called.
     * cardinality: 1..1
     */
    private ElAgent agent;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The agent being called.
     * cardinality: 1..1
     */
    public ElAgent getAgent() {
        return agent;
    }

    public void setAgent(ElAgent value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
    }

    //***** ElFunctionCall *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElFunctionCall() {
    }

    public ElFunctionCall(
            ElFunctionAgent agent,
            ElAgent agent,
            ElInstanceRef scope
    ) {
        super(
                scope
        );
        if (agent == null) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        if (agent == null) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        this.agent = agent;
        this.agent = agent;
    }

    private ElFunctionCall(Builder builder) {
        this.setAgent(builder.agent);
        this.setAgent(builder.agent);
        this.setScope(builder.scope);
    }

    public static class Builder {
        private final ElFunctionAgent agent;  //required
        private final ElAgent agent;  //required
        private ElInstanceRef scope;

        public Builder(
                ElFunctionAgent agent,
                ElAgent agent
        ) {
            if (agent == null) {
                throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
            }
            if (agent == null) {
                throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
            }
            this.agent = agent;
            this.agent = agent;
        }

        public Builder setScope(ElInstanceRef value) {
            this.scope = scope;
            return this;
        }

        public ElFunctionCall build() {
            return new ElFunctionCall(this);
        }
    }


    //***** ElFunctionCall *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElFunctionCall that = (ElFunctionCall) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElFunctionCall.java
                Objects.equals(agent, that.agent) &&
                        Objects.equals(agent, that.agent);
=======
                java.util.Objects.equals(agent, that.agent) &&
                        java.util.Objects.equals(agent, that.agent);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElFunctionCall.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                agent,
                agent
        );
    }

    @Override
    public String toString() {
        return
                "ElFunctionCall {" +
                        "agent='" + agent + '\'' +
                        "agent='" + agent + '\'' +
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
