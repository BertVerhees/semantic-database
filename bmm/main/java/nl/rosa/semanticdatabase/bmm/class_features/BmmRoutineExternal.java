package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * External routine placeholder, containing sufficient meta-data to enable a routine in an external library to be called.
 */
public class BmmRoutineExternal extends BmmRoutineBody {

    //***** BmmRoutineExternal *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * External call general meta-data, including target routine name, type mapping etc.
     * cardinality: 1..1
     */
    private Map<String, String> metaData = new HashMap<>();

    /**
     * Optional argument-mapping meta-data.
     * cardinality: 0..1
     */
    private Map<String, String> argumentMapping;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * External call general meta-data, including target routine name, type mapping etc.
     * cardinality: 1..1
     */

    public void putMetaData(String key, String value) {
        metaData.put(key, value);
    }

    public void putMetaData(Map<String, String> items) {
        items.keySet().forEach(key -> putMetadat(key, items.get(key)));
    }

    public String getMetaData(String key) {
        return metaData.get(key);
    }

    public void removeMetaData(String key) {
        if (metaData != null) {
            metaData.remove(key);
        }
    }

    public void removeMetaData(Collection<String> keys) {
        keys.forEach(this::removeMetaData);
    }

    public Map<String, String> getMetaData() {
        return this.metaData;
    }

    public BmmRoutineExternal setMetaData(Map<String, String> metaData) {
        if (metaData == null) {
            throw new NullPointerException(" metaData has cardinality NonNull, but is null");
        }
        this.metaData = metaData;
        return this;
    }

    public Map<String, String> metaData() {
        return Collections.unmodifiableMap(this.metaData);
    }

    /**
     * Optional argument-mapping meta-data.
     * cardinality: 0..1
     */

    public void putArgumentMapping(String key, String value) {
        if (argumentMapping == null) {
            argumentMapping = new HashMap<>();
        }
        argumentMapping.put(key, value);
    }

    public void putArgumentMapping(Map<String, String> items) {
        items.keySet().forEach(key -> putArgumentmappin(key, items.get(key)));
    }

    public String getArgumentMapping(String key) {
        if (argumentMapping == null) {
            return null;
        }
        return argumentMapping.get(key);
    }

    public void removeArgumentMapping(String key) {
        if (argumentMapping != null) {
            argumentMapping.remove(key);
        }
    }

    public void removeArgumentMapping(Collection<String> keys) {
        keys.forEach(this::removeArgumentMapping);
    }

    public Map<String, String> getArgumentMapping() {
        return this.argumentMapping;
    }

    public BmmRoutineExternal setArgumentMapping(Map<String, String> argumentMapping) {
        this.argumentMapping = argumentMapping;
        return this;
    }

    public Map<String, String> argumentMapping() {
        return Collections.unmodifiableMap(this.argumentMapping);
    }

    //***** BmmRoutineExternal *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmRoutineExternal() {
    }

    public BmmRoutineExternal(
            Map<string, string> metaData,
            Map<string, string> argumentMapping
    ) {
        if (metaData == null) {
            throw new NullPointerException("Property:metaData has cardinality NonNull, but is null");
        }
        this.metaData = metaData;
        this.argumentMapping = argumentMapping;
    }

    private BmmRoutineExternal(Builder builder) {
        this.setMetaData(builder.metaData);
        this.setArgumentMapping(builder.argumentMapping);
    }

    public static class Builder {
        private final Map<string, string> metaData;  //required
        private Map<string, string> argumentMapping;

        public Builder(
                Map<string, string> metaData
        ) {
            if (metaData == null) {
                throw new NullPointerException("Property:metaData has cardinality NonNull, but is null");
            }
            this.metaData = metaData;
        }

        public Builder setArgumentMapping(Map<string, string> value) {
            this.argumentMapping = argumentMapping;
            return this;
        }

        public BmmRoutineExternal build() {
            return new BmmRoutineExternal(this);
        }
    }


    //***** BmmRoutineExternal *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmRoutineExternal that = (BmmRoutineExternal) object;
        return
<<<<<<< HEAD:bmm/src/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmRoutineExternal.java
                Objects.equals(metaData, that.metaData) &&
                        Objects.equals(argumentMapping, that.argumentMapping);
=======
                java.util.Objects.equals(metaData, that.metaData) &&
                        java.util.Objects.equals(argumentMapping, that.argumentMapping);
>>>>>>> 555568c612c426eda0c539017b7a13c84fabaefa:bmm/main/java/nl/rosa/semanticdatabase/bmm/class_features/BmmRoutineExternal.java
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                metaData,
                argumentMapping
        );
    }

    @Override
    public String toString() {
        return
                "BmmRoutineExternal {" +
                        "metaData='" + metaData + '\'' +
                        "argumentMapping='" + argumentMapping + '\'' +
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
