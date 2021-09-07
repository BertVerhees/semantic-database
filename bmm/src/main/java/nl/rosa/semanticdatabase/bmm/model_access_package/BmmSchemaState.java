package nl.rosa.semanticdatabase.bmm.model_access_package.;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * <p>
 * Enumeration of processing states of a BMM_SCHEMA used by creation and validation routines in BMM_SCHEMA.
 */
public enum BmmSchemaState {

    /**
     * Initial state directly after instantiation of schema.
     */
    stateCreated,

    /**
     * Initial validation pass after instantiation.
     */
    stateValidatedCreated,

    /**
     * State of schema processing if there are still included schemas to process.
     */
    stateIncludesPending,

    /**
     * State when all included schemas have been processed.
     */
    stateIncludesProcessed

}
