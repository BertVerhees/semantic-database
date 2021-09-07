package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.class_features.BmmRoutine;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13", today="2019-06-03") but also partially open calls such as format_structure (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e.
 * type of runtime evaluated form) is BMM_SIGNATURE.
 */
public abstract class ElAgent extends ElScopedRef {

    //***** ElAgent *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of the routine being called.
     * cardinality: 1..1
     */
    private String name;

    /**
     * Closed arguments of a routine call as a tuple of objects.
     * cardinality: 0..1
     */
    private ElTuple closedArgs;

    /**
     * Optional list of names of open arguments of the call.
     * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
     * cardinality: 0..1
     */
    private List<String> openArgs;

    /**
     * Reference to definition of a routine for which this is an agent, if one exists.
     * cardinality: 0..1
     */
    private BmmRoutine definition;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of the routine being called.
     * cardinality: 1..1
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    /**
     * Closed arguments of a routine call as a tuple of objects.
     * cardinality: 0..1
     */
    public ElTuple getClosedArgs() {
        return closedArgs;
    }

    public void setClosedArgs(ElTuple value) {
        this.closedArgs = closedArgs;
    }

    /**
     * Optional list of names of open arguments of the call.
     * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
     * cardinality: 0..1
     */

    public void addToOpenArg(String value) {
        if (openArgs == null) {
            openArgs = new ArrayList<>();
        }
        openArgs.add(value);
    }

    public void addToOpenArgs(List<String> values) {
        values.forEach(value -> addToOpenarg(value));
    }

    public void removeFromOpenArg(String item) {
        if (openArgs != null) {
            openArgs.remove(item);
        }
    }

    public void removeFromOpenArgs(Collection<String> values) {
        values.forEach(this::removeFromOpenArg);
    }

    List<String> getOpenArgs() {
        return this.openArgs;
    }

    public ElAgent setOpenArgs(List<String> openArgs) {
        this.openArgs = openArgs;
        return this;
    }

    public List<String> openArgs() {
        return Collections.unmodifiableList(this.openArgs);
    }

    /**
     * Reference to definition of a routine for which this is an agent, if one exists.
     * cardinality: 0..1
     */
    public BmmRoutine getDefinition() {
        return definition;
    }

    public void setDefinition(BmmRoutine value) {
        this.definition = definition;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * Eval type is the signature corresponding to the (remaining) open arguments and return type, if any.
 * cardinality: 1..1 (effected)
 *
 */
    public Result =

    definition.signature evalType() {
        Result = definition.signature result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

/**
 *
 * True if there are no open arguments.
 * cardinality: 1..1
 *
 */
    public Result =open_arguments =

    Void isCallable() {
        Result = open_arguments = Void result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** ElAgent *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ElAgent() {
    }

    protected ElAgent(
            String name,
            ElTuple closedArgs,
            List<string> openArgs,
            BmmRoutine definition,
            ElInstanceRef scope
    ) {
        super(
                scope
        );
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
        this.closedArgs = closedArgs;
        this.openArgs = openArgs;
        this.definition = definition;
    }


    //***** ElAgent *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElAgent that = (ElAgent) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElAgent.java
                Objects.equals(name, that.name) &&
                        Objects.equals(closedArgs, that.closedArgs) &&
                        Objects.equals(openArgs, that.openArgs) &&
                        Objects.equals(definition, that.definition);
=======
                java.util.Objects.equals(name, that.name) &&
                        java.util.Objects.equals(closedArgs, that.closedArgs) &&
                        java.util.Objects.equals(openArgs, that.openArgs) &&
                        java.util.Objects.equals(definition, that.definition);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/expressions/ElAgent.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                name,
                closedArgs,
                openArgs,
                definition
        );
    }

    @Override
    public String toString() {
        return
                "ElAgent {" +
                        "name='" + name + '\'' +
                        "closedArgs='" + closedArgs + '\'' +
                        "openArgs='" + openArgs + '\'' +
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
