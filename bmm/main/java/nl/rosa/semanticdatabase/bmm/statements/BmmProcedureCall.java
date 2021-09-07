package nl.rosa.semanticdatabase.bmm.statements;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElAgentCall;
import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A call made on a closed procedure agent.
 */
public class BmmProcedureCall extends BmmStatement implements ElAgentCall {

    //***** BmmProcedureCall *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The procedure agent being called.
     * cardinality: 1..1 (redefined)
     */
    private ElProcedureAgent agent;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The procedure agent being called.
     * cardinality: 1..1 (redefined)
     */
    public ElProcedureAgent getAgent() {
        return agent;
    }

    public void setAgent(ElProcedureAgent value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
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

    //***** BmmProcedureCall *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmProcedureCall() {
    }

    public BmmProcedureCall(
            ElProcedureAgent agent,
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

    private BmmProcedureCall(Builder builder) {
        this.setAgent(builder.agent);
        this.setAgent(builder.agent);
    }

    public static class Builder {
        private final ElProcedureAgent agent;  //required
        private final ElAgent agent;  //required

        public Builder(
                ElProcedureAgent agent,
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

        public BmmProcedureCall build() {
            return new BmmProcedureCall(this);
        }
    }


    //***** BmmProcedureCall *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmProcedureCall that = (BmmProcedureCall) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmProcedureCall.java
                Objects.equals(agent, that.agent) &&
                        Objects.equals(agent, that.agent);
=======
                java.util.Objects.equals(agent, that.agent) &&
                        java.util.Objects.equals(agent, that.agent);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/statements/BmmProcedureCall.java
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
                "BmmProcedureCall {" +
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
