package nl.rosa.semanticdatabase.bmm.model_access_package;


/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Core properties of BMM_MODEL, may be used in a serial representation as well, such as P_BMM_SCHEMA.
 */
public interface BmmModelMetadata {

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Publisher of model expressed in the schema.
     * cardinality: 1..1
     */
    String getRmPublisher();

    void setRmPublisher(String value);

    /**
     * Release of model expressed in the schema as a 3-part numeric, e.g.
     * "3.1.0" .
     * cardinality: 1..1
     */
    String getRmRelease();

    void setRmRelease(String value);

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
