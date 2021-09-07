package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * A routine parameter variable.
 */
public class BmmParameter extends BmmVariable {

    //***** BmmParameter *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Optional read/write direction of the parameter.
     * If none-supplied, the parameter is treated as in, i.e.
     * readable.
     * cardinality: 0..1
     */
    private BmmParameterDirection direction;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Optional read/write direction of the parameter.
     * If none-supplied, the parameter is treated as in, i.e.
     * readable.
     * cardinality: 0..1
     */
    public BmmParameterDirection getDirection() {
        return direction;
    }

    public void setDirection(BmmParameterDirection value) {
        this.direction = direction;
    }

    //***** BmmParameter *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmParameter() {
    }

    public BmmParameter(
            BmmParameterDirection direction,
            BmmRoutine scope,
            BmmType type,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
    ) {
        super(
                scope,
                type,
                name,
                documentation,
                scope,
                extensions
        );
        this.direction = direction;
    }

    private BmmParameter(Builder builder) {
        this.setDirection(builder.direction);
        this.setScope(builder.scope);
        this.setType(builder.type);
        this.setName(builder.name);
        this.setDocumentation(builder.documentation);
        this.setScope(builder.scope);
        this.setExtensions(builder.extensions);
    }

    public static class Builder {
        private BmmParameterDirection direction;
        private final BmmRoutine scope;  //required
        private final BmmType type;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder(
                BmmRoutine scope,
                BmmType type,
                String name,
                BmmDeclaration scope
        ) {
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (name == null) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if (scope == null) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.scope = scope;
            this.type = type;
            this.name = name;
            this.scope = scope;
        }

        public Builder setDirection(BmmParameterDirection value) {
            this.direction = direction;
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

        public BmmParameter build() {
            return new BmmParameter(this);
        }
    }


    //***** BmmParameter *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmParameter that = (BmmParameter) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmParameter.java
                Objects.equals(direction, that.direction);
=======
                java.util.Objects.equals(direction, that.direction);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmParameter.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                direction
        );
    }

    @Override
    public String toString() {
        return
                "BmmParameter {" +
                        "direction='" + direction + '\'' +
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
