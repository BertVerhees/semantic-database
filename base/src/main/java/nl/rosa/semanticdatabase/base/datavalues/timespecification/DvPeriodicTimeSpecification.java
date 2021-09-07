package nl.rosa.semanticdatabase.base.datavalues.timespecification;


import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvParsable;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class DvPeriodicTimeSpecification extends DvTimeSpecification {
    public DvPeriodicTimeSpecification(DvParsable value) {

        super(value);

        if (!"HL7:PIVL".equals(value.getFormalism())
                && !"HL7:EIVL".equals(value.getFormalism())) {

            throw new IllegalArgumentException("Unknown formalism while creating DvPeriodicTimeSpecification: "
                    + value.getFormalism()+", must be: HL7:EIVL or HL7:PIVL");
        }
    }
}
