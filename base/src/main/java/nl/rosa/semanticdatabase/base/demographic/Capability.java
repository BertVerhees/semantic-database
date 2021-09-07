package nl.rosa.semanticdatabase.base.demographic;

import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.datastructures.ItemStructure;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class Capability extends Locatable {

    private ItemStructure credentials;
    private DvInterval<DvDate> timeValidity;

    public ItemStructure getCredentials() {
        return credentials;
    }

    public void setCredentials(ItemStructure credentials) {
        this.credentials = credentials;
        this.setThisAsParent(credentials, "credentials");
    }

    public DvInterval<DvDate> getTimeValidity() {
        return timeValidity;
    }

    public void setTimeValidity( DvInterval<DvDate> timeValidity) {
        this.timeValidity = timeValidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Capability that = (Capability) o;
        return Objects.equals(credentials, that.credentials) &&
                Objects.equals(timeValidity, that.timeValidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), credentials, timeValidity);
    }
}
