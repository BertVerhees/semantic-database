package nl.rosa.semanticdatabase.aom2.the_rm_overlay_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Container object for archetype statements relating to RM attributes, which may be directly on objects constrained within the archetype, or at deeper non-constrained RM paths from an object or the root.
 */
public class RmOverlay {

    //***** RmOverlay *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Optional structure in which visibility and aliasing of reference model elements can be specified.
     * Key is path to an RM attribute, which is typically formed from a path to an archetyped node concatenated with a further pure RM attribute path; may also refer to a non-archetyped attribute.
     * cardinality: 0..1
     */
    private Map<String, RmAttributeVisibility> rmVisibility;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Optional structure in which visibility and aliasing of reference model elements can be specified.
     * Key is path to an RM attribute, which is typically formed from a path to an archetyped node concatenated with a further pure RM attribute path; may also refer to a non-archetyped attribute.
     * cardinality: 0..1
     */

    public void putRmVisibility(String key, RmAttributeVisibility value) {
        if (rmVisibility == null) {
            rmVisibility = new HashMap<>();
        }
        rmVisibility.put(key, value);
    }

    public void putRmVisibility(Map<String, RmAttributeVisibility> items) {
        items.keySet().forEach(key -> putRmvisibilit(key, items.get(key)));
    }

    public RmAttributeVisibility getRmVisibility(String key) {
        if (rmVisibility == null) {
            return null;
        }
        return rmVisibility.get(key);
    }

    public void removeRmVisibility(String key) {
        if (rmVisibility != null) {
            rmVisibility.remove(key);
        }
    }

    public void removeRmVisibility(Collection<String> keys) {
        keys.forEach(this::removeRmVisibility);
    }

    public Map<String, RmAttributeVisibility> getRmVisibility() {
        return this.rmVisibility;
    }

    public RmOverlay setRmVisibility(Map<String, RmAttributeVisibility> rmVisibility) {
        this.rmVisibility = rmVisibility;
        return this;
    }

    public Map<String, RmAttributeVisibility> rmVisibility() {
        return Collections.unmodifiableMap(this.rmVisibility);
    }

    //***** RmOverlay *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected RmOverlay() {
    }

    public RmOverlay(
            Map<string, rmAttributeVisibility> rmVisibility
    ) {
        this.rmVisibility = rmVisibility;
    }

    private RmOverlay(Builder builder) {
        this.setRmVisibility(builder.rmVisibility);
    }

    public static class Builder {
        private Map<string, rmAttributeVisibility> rmVisibility;

        public Builder(
        ) {
        }

        public Builder setRmVisibility(Map<string, rmAttributeVisibility> value) {
            this.rmVisibility = rmVisibility;
            return this;
        }

        public RmOverlay build() {
            return new RmOverlay(this);
        }
    }


    //***** RmOverlay *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RmOverlay that = (RmOverlay) object;
        return
                Objects.equals(rmVisibility, that.rmVisibility);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                rmVisibility
        );
    }

    @Override
    public String toString() {
        return
                "RmOverlay {" +
                        "rmVisibility='" + rmVisibility + '\'' +
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
