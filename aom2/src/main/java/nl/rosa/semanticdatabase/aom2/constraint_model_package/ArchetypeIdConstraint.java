package nl.rosa.semanticdatabase.aom2.constraint_model_package;

/**
 * Default created on 27-11-2020
 * Constraint expression representing a regex constraint on an archetype identifier.
 */

public class ArchetypeIdConstraint {
    /**
     * Right hand side of the constraint expression, in the form of a C_STRING, i.e. string value constrainer.
     * Cardinality 1..1
     */
    private CString constraint;

    public CString getConstraint() {
        return constraint;
    }

    public void setConstraint(CString value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:archetypeRef failed, it has cardinality NonNull, but is null");
        }
        this.constraint = value;
    }

    public ArchetypeIdConstraint(CString constraint) {
        this.constraint = constraint;
    }
}
