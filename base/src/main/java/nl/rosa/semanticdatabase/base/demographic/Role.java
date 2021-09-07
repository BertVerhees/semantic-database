package nl.rosa.semanticdatabase.base.demographic;

import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;
import nl.rosa.semanticdatabase.base.identification.PartyRef;

import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class Role extends Party {

    
    private DvInterval<DvDate> timeValidity;
    private PartyRef performer;
    
    private List<Capability> capabilities;

    
    public DvInterval<DvDate> getTimeValidity() {
        return timeValidity;
    }

    public void setTimeValidity( DvInterval<DvDate> timeValidity) {
        this.timeValidity = timeValidity;
    }

    public PartyRef getPerformer() {
        return performer;
    }

    public void setPerformer(PartyRef performer) {
        this.performer = performer;
    }

    
    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities( List<Capability> capabilities) {
        this.capabilities = capabilities;
        this.setThisAsParent(capabilities, "capabilities");
    }

    public void addCapability(Capability capability) {
        this.capabilities.add(capability);
        this.setThisAsParent(capability, "capabilities");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return Objects.equals(timeValidity, role.timeValidity) &&
                Objects.equals(performer, role.performer) &&
                Objects.equals(capabilities, role.capabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeValidity, performer, capabilities);
    }
}
