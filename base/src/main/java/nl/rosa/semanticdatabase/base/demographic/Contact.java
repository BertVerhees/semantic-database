package nl.rosa.semanticdatabase.base.demographic;

import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class Contact extends Locatable {

    
    private List<Address> addresses = new ArrayList<>();

    
    private DvInterval<DvDate> timeValidity;

    public DvText getPurpose() {
        return getName();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        this.setThisAsParent(addresses, "addresses");
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        this.setThisAsParent(address, "addresses");
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
        Contact contact = (Contact) o;
        return Objects.equals(addresses, contact.addresses) &&
                Objects.equals(timeValidity, contact.timeValidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addresses, timeValidity);
    }
}
