package nl.rosa.semanticdatabase.base.identification;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class UUid extends Uid {

    /**
     * Simple UUID pattern
     */
    public static final String SIMPLE_UUID_PATTERN = "([0-9a-fA-F])+(-([0-9a-fA-F])+)*";

    public UUid() {
    }

    public UUid(String value) {
        super(value);
        // kind of validation
        java.util.UUID.fromString(value);
    }
}
