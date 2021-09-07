package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A formal element with signature of the form: name ({arg:TArg}*):TResult.
 * A function is a computed (rather than data) element, generally assumed to be non-state-changing.
 */
public class BmmFunction extends BmmRoutine implements BmmTypedFeature {

    //***** BmmFunction *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Optional details enabling a function to be represented as an operator in a syntactic representation.
     * cardinality: 0..1
     */
    private BmmOperator operatorDefinition;

    /**
     * Automatically created Result variable, usable in body and post-condition.
     * cardinality: 1..1
     */
    private BmmResult result;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Optional details enabling a function to be represented as an operator in a syntactic representation.
     * cardinality: 0..1
     */
    public BmmOperator getOperatorDefinition() {
        return operatorDefinition;
    }

    public void setOperatorDefinition(BmmOperator value) {
        this.operatorDefinition = operatorDefinition;
    }

    /**
     * Automatically created Result variable, usable in body and post-condition.
     * cardinality: 1..1
     */
    public BmmResult getResult() {
        return result;
    }

    public void setResult(BmmResult value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:result failed, it has cardinality NonNull, but is null");
        }
        this.result = result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * True if this element can be null (Void) at execution time.
     * May be interpreted as optionality in subtypes..
     */
    final Boolean {
        default
        isNullable = false
    }

    ;

    //***** BmmTyped *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1
     */
    private BmmType type;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Declared or inferred static type of the entity.
     * cardinality: 1..1
     */
    public BmmType getType() {
        return type;
    }

    public void setType(BmmType value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

/**
 *
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * cardinality: 1..1
 *
 */
    public Result =

    type().

    equal( {
        BMM_MODEL
    }.

    boolean_type_definition())

    isBoolean() {
        Result = type().equal({BMM_MODEL}.boolean_type_definition()) result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** BmmFunction *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmFunction() {
    }

    public BmmFunction(
            BmmOperator operatorDefinition,
            BmmResult result,
            BmmType type,
            List<bmmParameter> parameters,
            List<bmmLocal> locals,
            List<bmmAssertion> preConditions,
            List<bmmAssertion> postConditions,
            BmmRoutineBody body,
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                parameters,
                locals,
                preConditions,
                postConditions,
                body,
                visibility,
                featureExtensions,
                group,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
        if (result == null) {
            throw new NullPointerException("Property:result has cardinality NonNull, but is null");
        }
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.operatorDefinition = operatorDefinition;
        this.result = result;
        this.type = type;
    }

    private BmmFunction(Builder builder) {
        this.setOperatorDefinition(builder.operatorDefinition);
        this.setResult(builder.result);
        this.setType(builder.type);
        this.setParameters(builder.parameters);
        this.setLocals(builder.locals);
        this.setPreConditions(builder.preConditions);
        this.setPostConditions(builder.postConditions);
        this.setBody(builder.body);
        this.setVisibility(builder.visibility);
        this.setFeatureExtensions(builder.featureExtensions);
        this.setGroup(builder.group);
        this.setScope(builder.scope);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private BmmOperator operatorDefinition;
        private final BmmResult result;  //required
        private final BmmType type;  //required
        private List<bmmParameter> parameters;
        private List<bmmLocal> locals;
        private List<bmmAssertion> preConditions;
        private List<bmmAssertion> postConditions;
        private BmmRoutineBody body;
        private BmmVisibility visibility;
        private List<bmmFeatureExtension> featureExtensions;
        private final BmmFeatureGroup group;  //required
        private final BmmClass scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                BmmResult result,
                BmmType type,
                BmmFeatureGroup group,
                BmmClass scope,
                String name,
                BmmDeclaration scope
        ) {
            if (result == null) {
                throw new NullPointerException("Property:result has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (group == null) {
                throw new NullPointerException("Property:group has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.result = result;
            this.type = type;
            this.group = group;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setOperatorDefinition(BmmOperator value) {
            this.operatorDefinition = operatorDefinition;
            return this;
        }

        public Builder setParameters(List<bmmParameter> value) {
            this.parameters = parameters;
            return this;
        }

        public Builder setLocals(List<bmmLocal> value) {
            this.locals = locals;
            return this;
        }

        public Builder setPreConditions(List<bmmAssertion> value) {
            this.preConditions = preConditions;
            return this;
        }

        public Builder setPostConditions(List<bmmAssertion> value) {
            this.postConditions = postConditions;
            return this;
        }

        public Builder setBody(BmmRoutineBody value) {
            this.body = body;
            return this;
        }

        public Builder setVisibility(BmmVisibility value) {
            this.visibility = visibility;
            return this;
        }

        public Builder setFeatureExtensions(List<bmmFeatureExtension> value) {
            this.featureExtensions = featureExtensions;
            return this;
        }

        public Builder setDocumentation(Map<string, any> value) {
            this.documentation = documentation;
            return this;
        }

        public Builder setExtensions(Map<string, any> value) {
            this.extensions = extensions;
            return this;
        }

        public BmmFunction build() {
            return new BmmFunction(this);
        }
    }


    //***** BmmFunction *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmFunction that = (BmmFunction) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmFunction.java
                Objects.equals(operatorDefinition, that.operatorDefinition) &&
                        Objects.equals(result, that.result) &&
                        Objects.equals(type, that.type);
=======
                java.util.Objects.equals(operatorDefinition, that.operatorDefinition) &&
                        java.util.Objects.equals(result, that.result) &&
                        java.util.Objects.equals(type, that.type);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmFunction.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                operatorDefinition,
                result,
                type
        );
    }

    @Override
    public String toString() {
        return
                "BmmFunction {" +
                        "operatorDefinition='" + operatorDefinition + '\'' +
                        "result='" + result + '\'' +
                        "type='" + type + '\'' +
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
