package nl.rosa.semanticdatabase.aom2.terminology_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Representation of any coded entity (term or constraint) in the archetype ontology.
 */
public class ArchetypeTerm {

    //***** ArchetypeTerm *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Code of this term.
     * cardinality: 1..1
     */
    private String code;

    /**
     * Short term text, typically for display.
     * cardinality: 1..1
     */
    private String text;

    /**
     * Full description text.
     * cardinality: 1..1
     */
    private String description;

    /**
     * Hash of keys and corresponding values for other items in a term, e.g.
     * provenance.
     * Hash of keys ("text", "description" etc) and corresponding values.
     * cardinality: 0..1
     */
    private Map<String, String> otherItems;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Code of this term.
     * cardinality: 1..1
     */
    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:code failed, it has cardinality NonNull, but is null");
        }
        this.code = code;
    }

    /**
     * Short term text, typically for display.
     * cardinality: 1..1
     */
    public String getText() {
        return text;
    }

    public void setText(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:text failed, it has cardinality NonNull, but is null");
        }
        this.text = text;
    }

    /**
     * Full description text.
     * cardinality: 1..1
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:description failed, it has cardinality NonNull, but is null");
        }
        this.description = description;
    }

    /**
     * Hash of keys and corresponding values for other items in a term, e.g.
     * provenance.
     * Hash of keys ("text", "description" etc) and corresponding values.
     * cardinality: 0..1
     */

    public void putOtherItem(String key, String value) {
        if (otherItems == null) {
            otherItems = new HashMap<>();
        }
        otherItems.put(key, value);
    }

    public void putOtherItems(Map<String, String> items) {
        items.keySet().forEach(key -> putOtheritem(key, items.get(key)));
    }

    public String getOtherItem(String key) {
        if (otherItems == null) {
            return null;
        }
        return otherItems.get(key);
    }

    public void removeOtherItem(String key) {
        if (otherItems != null) {
            otherItems.remove(key);
        }
    }

    public void removeOtherItems(Collection<String> keys) {
        keys.forEach(this::removeOtherItem);
    }

    public Map<String, String> getOtherItems() {
        return this.otherItems;
    }

    public ArchetypeTerm setOtherItems(Map<String, String> otherItems) {
        this.otherItems = otherItems;
        return this;
    }

    public Map<String, String> otherItems() {
        return Collections.unmodifiableMap(this.otherItems);
    }

    //***** ArchetypeTerm *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected ArchetypeTerm() {
    }

    public ArchetypeTerm(
            String code,
            String text,
            String description,
            Map<string, string> otherItems
    ) {
        if (code == null) {
            throw new NullPointerException("Property:code has cardinality NonNull, but is null");
        }
        if (text == null) {
            throw new NullPointerException("Property:text has cardinality NonNull, but is null");
        }
        if (description == null) {
            throw new NullPointerException("Property:description has cardinality NonNull, but is null");
        }
        this.code = code;
        this.text = text;
        this.description = description;
        this.otherItems = otherItems;
    }

    private ArchetypeTerm(Builder builder) {
        this.setCode(builder.code);
        this.setText(builder.text);
        this.setDescription(builder.description);
        this.setOtherItems(builder.otherItems);
    }

    public static class Builder {
        private final String code;  //required
        private final String text;  //required
        private final String description;  //required
        private Map<string, string> otherItems;

        public Builder(
                String code,
                String text,
                String description
        ) {
            if (code == null) {
                throw new NullPointerException("Property:code has cardinality NonNull, but is null");
            }
            if (text == null) {
                throw new NullPointerException("Property:text has cardinality NonNull, but is null");
            }
            if (description == null) {
                throw new NullPointerException("Property:description has cardinality NonNull, but is null");
            }
            this.code = code;
            this.text = text;
            this.description = description;
        }

        public Builder setOtherItems(Map<string, string> value) {
            this.otherItems = otherItems;
            return this;
        }

        public ArchetypeTerm build() {
            return new ArchetypeTerm(this);
        }
    }


    //***** ArchetypeTerm *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeTerm that = (ArchetypeTerm) object;
        return
                Objects.equals(code, that.code) &&
                        Objects.equals(text, that.text) &&
                        Objects.equals(description, that.description) &&
                        Objects.equals(otherItems, that.otherItems);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                code,
                text,
                description,
                otherItems
        );
    }

    @Override
    public String toString() {
        return
                "ArchetypeTerm {" +
                        "code='" + code + '\'' +
                        "text='" + text + '\'' +
                        "description='" + description + '\'' +
                        "otherItems='" + otherItems + '\'' +
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
