package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

import nl.rosa.semanticdatabase.bmm.expressions.ElInstanceRef;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * An immutable, static value-returning element scoped to a class.
 * The value is the result of the evaluation of the generator, which may be as simple as a literal value, or may be any expression, including a function call.
 */
public class BmmConstant extends BmmClassFeature implements BmmInstantiable {

    //***** BmmConstant *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Generator expression for the constant value.
     * In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.
     * cardinality: 1..1
     */
    private ElInstanceRef generator;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Generator expression for the constant value.
     * In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.
     * cardinality: 1..1
     */
    public ElInstanceRef getGenerator() {
        return generator;
    }

    public void setGenerator(ElInstanceRef value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:generator failed, it has cardinality NonNull, but is null");
        }
        this.generator = generator;
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

    //***** BmmConstant *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmConstant() {
    }

    public BmmConstant(
            ElInstanceRef generator,
            BmmType type,
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
                visibility,
                featureExtensions,
                group,
                scope,
                name,
                documentation,
                scope,
                extensions
        );
        if (generator == null) {
            throw new NullPointerException("Property:generator has cardinality NonNull, but is null");
        }
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.generator = generator;
        this.type = type;
    }

    private BmmConstant(Builder builder) {
        this.setGenerator(builder.generator);
        this.setType(builder.type);
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
        private final ElInstanceRef generator;  //required
        private final BmmType type;  //required
        private BmmVisibility visibility;
        private List<bmmFeatureExtension> featureExtensions;
        private final BmmFeatureGroup group;  //required
        private final BmmClass scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                ElInstanceRef generator,
                BmmType type,
                BmmFeatureGroup group,
                BmmClass scope,
                String name,
                BmmDeclaration scope
        ) {
            if (generator == null) {
                throw new NullPointerException("Property:generator has cardinality NonNull, but is null");
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
            this.generator = generator;
            this.type = type;
            this.group = group;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
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

        public BmmConstant build() {
            return new BmmConstant(this);
        }
    }


    //***** BmmConstant *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmConstant that = (BmmConstant) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmConstant.java
                Objects.equals(generator, that.generator) &&
                        Objects.equals(type, that.type);
=======
                java.util.Objects.equals(generator, that.generator) &&
                        java.util.Objects.equals(type, that.type);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmConstant.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                generator,
                type
        );
    }

    @Override
    public String toString() {
        return
                "BmmConstant {" +
                        "generator='" + generator + '\'' +
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
