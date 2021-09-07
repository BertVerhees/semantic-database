package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A formal element with signature of the form: name ({arg:TArg}*).
 * A procedure is a computed (rather than data) element, generally assumed to be state-changing.
 */
public class BmmProcedure extends BmmRoutine {

    //***** BmmProcedure *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmProcedure() {
    }

    public BmmProcedure(
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
    }

    private BmmProcedure(Builder builder) {
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
                BmmFeatureGroup group,
                BmmClass scope,
                String name,
                BmmDeclaration scope
        ) {
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
            this.group = group;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
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

        public BmmProcedure build() {
            return new BmmProcedure(this);
        }
    }


    //***** BmmProcedure *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "BmmProcedure {" +
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
