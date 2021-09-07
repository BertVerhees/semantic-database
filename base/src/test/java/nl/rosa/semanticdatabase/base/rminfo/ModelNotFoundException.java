package nl.rosa.semanticdatabase.base.rminfo;

/**
 * Exception indicating that no model was found for the given archetype
 */
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message) {
        super(message);
    }
}
