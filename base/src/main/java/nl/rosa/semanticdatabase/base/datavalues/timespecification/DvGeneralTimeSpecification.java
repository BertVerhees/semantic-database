package nl.rosa.semanticdatabase.base.datavalues.timespecification;


import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvParsable;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class DvGeneralTimeSpecification extends DvTimeSpecification {
    public DvGeneralTimeSpecification(DvParsable value) {

        super(value);

        if (!value.getFormalism().equals("HL7:GTS")) {
            throw new IllegalArgumentException("Unknown formalism while creating DvGeneralTimeSpecification: "
                    + value.getFormalism() + ", must be: HL7:GTS");
        }
    }
}
