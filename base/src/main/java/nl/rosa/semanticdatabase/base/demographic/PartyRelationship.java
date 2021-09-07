package nl.rosa.semanticdatabase.base.demographic;

import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.datastructures.ItemStructure;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;
import nl.rosa.semanticdatabase.base.identification.PartyRef;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class PartyRelationship extends Locatable {

    
    private ItemStructure details;
    
    private DvInterval<DvDate> timeValidity;

    private PartyRef source;
    private PartyRef target;

    
    public ItemStructure getDetails() {
        return details;
    }

    public void setDetails( ItemStructure details) {
        this.details = details;
        setThisAsParent(details, "details");
    }

    
    public DvInterval<DvDate> getTimeValidity() {
        return timeValidity;
    }

    public void setTimeValidity( DvInterval<DvDate> timeValidity) {
        this.timeValidity = timeValidity;
    }

    public PartyRef getSource() {
        return source;
    }

    public void setSource(PartyRef source) {
        this.source = source;
    }

    public PartyRef getTarget() {
        return target;
    }

    public void setTarget(PartyRef target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartyRelationship that = (PartyRelationship) o;
        return Objects.equals(details, that.details) &&
                Objects.equals(timeValidity, that.timeValidity) &&
                Objects.equals(source, that.source) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), details, timeValidity, source, target);
    }
}
