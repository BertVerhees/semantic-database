package nl.rosa.semanticdatabase.base.generic;


import nl.rosa.semanticdatabase.base.identification.PartyRef;

/**
 * Originally: Created by pieter.bos on 01/03/16.
 */
public class PartySelf extends PartyProxy {

    public PartySelf() {
    }

    public PartySelf(PartyRef externalRef) {
        super(externalRef);
    }
}
