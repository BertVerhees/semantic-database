package nl.rosa.semanticdatabase.aom2.constraint_model_package.;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * <p>
 * Status of constraint, with values allowing for 'soft' constraints, which are effectively different kinds of suggestions.
 */
public enum ConstraintStatus {

    /**
     * Data item is required to formally satisfy constraint.
     * Enumeration value = 0.
     */
    required,

    /**
     * Data item value should satisfy constraint, i.e.
     * a term in constraint is to be used if it covers the data item meaning (including more generally); if not, another code may be used, including from another terminology.
     * Enumeration value = 1.
     */
    extensible,

    /**
     * Data item value is by preference one of the codes defined by constraint, but for local reasons may be another code, including from another terminology.
     * Enumeration value = 2.
     */
    preferred,

    /**
     * The constraint code or value-set is considered purely as an example, and the data item may have any value.
     */
    example

}
