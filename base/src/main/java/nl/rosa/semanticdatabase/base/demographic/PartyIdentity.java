package nl.rosa.semanticdatabase.base.demographic;


import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.datastructures.ItemStructure;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class PartyIdentity extends Locatable {

    private ItemStructure details;

    public DvText getPurpose() {
        return getName();
    }

    public ItemStructure getDetails() {
        return details;
    }

    public void setDetails(ItemStructure details) {
        this.details = details;
        setThisAsParent(details, "details");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartyIdentity that = (PartyIdentity) o;
        return Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), details);
    }
}
