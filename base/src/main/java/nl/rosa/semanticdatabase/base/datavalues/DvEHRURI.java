package nl.rosa.semanticdatabase.base.datavalues;

import java.net.URI;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvEHRURI extends DvURI {

    public DvEHRURI() {
    }

    public DvEHRURI(URI value) {
        super(value);
    }


    /**
     * Creates a DvEHRURI from a URI String representation
     *
     * @param uri
     */
    public DvEHRURI(String uri) {
        super(uri);
    }
}
