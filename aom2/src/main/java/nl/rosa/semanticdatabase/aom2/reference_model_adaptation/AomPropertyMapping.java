package nl.rosa.semanticdatabase.aom2.reference_model_adaptation;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Data object expressing a mapping between two class properties.
 */
public class AomPropertyMapping {

    //***** AomPropertyMapping *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Name of property in source class.
     * cardinality: 1..1
     */
    private String sourcePropertyName;

    /**
     * Name of property in target class.
     * cardinality: 1..1
     */
    private String targetPropertyName;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Name of property in source class.
     * cardinality: 1..1
     */
    public String getSourcePropertyName() {
        return sourcePropertyName;
    }

    public void setSourcePropertyName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:sourcePropertyName failed, it has cardinality NonNull, but is null");
        }
        this.sourcePropertyName = sourcePropertyName;
    }

    /**
     * Name of property in target class.
     * cardinality: 1..1
     */
    public String getTargetPropertyName() {
        return targetPropertyName;
    }

    public void setTargetPropertyName(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:targetPropertyName failed, it has cardinality NonNull, but is null");
        }
        this.targetPropertyName = targetPropertyName;
    }

    //***** AomPropertyMapping *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected AomPropertyMapping() {
    }

    public AomPropertyMapping(
            String sourcePropertyName,
            String targetPropertyName
    ) {
        if (sourcePropertyName == null) {
            throw new NullPointerException("Property:sourcePropertyName has cardinality NonNull, but is null");
        }
        if (targetPropertyName == null) {
            throw new NullPointerException("Property:targetPropertyName has cardinality NonNull, but is null");
        }
        this.sourcePropertyName = sourcePropertyName;
        this.targetPropertyName = targetPropertyName;
    }

    private AomPropertyMapping(Builder builder) {
        this.setSourcePropertyName(builder.sourcePropertyName);
        this.setTargetPropertyName(builder.targetPropertyName);
    }

    public static class Builder {
        private final String sourcePropertyName;  //required
        private final String targetPropertyName;  //required

        public Builder(
                String sourcePropertyName,
                String targetPropertyName
        ) {
            if (sourcePropertyName == null) {
                throw new NullPointerException("Property:sourcePropertyName has cardinality NonNull, but is null");
            }
            if (targetPropertyName == null) {
                throw new NullPointerException("Property:targetPropertyName has cardinality NonNull, but is null");
            }
            this.sourcePropertyName = sourcePropertyName;
            this.targetPropertyName = targetPropertyName;
        }

        public AomPropertyMapping build() {
            return new AomPropertyMapping(this);
        }
    }


    //***** AomPropertyMapping *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        AomPropertyMapping that = (AomPropertyMapping) object;
        return
                Objects.equals(sourcePropertyName, that.sourcePropertyName) &&
                        Objects.equals(targetPropertyName, that.targetPropertyName);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                sourcePropertyName,
                targetPropertyName
        );
    }

    @Override
    public String toString() {
        return
                "AomPropertyMapping {" +
                        "sourcePropertyName='" + sourcePropertyName + '\'' +
                        "targetPropertyName='" + targetPropertyName + '\'' +
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
