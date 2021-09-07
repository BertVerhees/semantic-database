package nl.rosa.semanticdatabase.base.demographic;

import nl.rosa.semanticdatabase.base.archetyped.Locatable;
import nl.rosa.semanticdatabase.base.datastructures.ItemStructure;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.LocatableRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public abstract class Party extends Locatable {

    private List<PartyIdentity> identities = new ArrayList<>();
    
    private List<Contact> contacts = new ArrayList<>();
    
    private ItemStructure details;
    
    private List<LocatableRef> reverseRelationships = new ArrayList<>();
    
    private List<PartyRelationship> relationships = new ArrayList<>();

    //TODO: uid is redefined here as HIER_OBJECT_ID...


    public List<PartyIdentity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<PartyIdentity> identities) {
        this.identities = identities;
        setThisAsParent(identities, "identities");
    }

    
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts( List<Contact> contacts) {
        this.contacts = contacts;
        setThisAsParent(contacts, "contacts");
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
        this.setThisAsParent(contact, "contacts");

    }

    
    public ItemStructure getDetails() {
        return details;
    }

    public void setDetails( ItemStructure details) {
        this.details = details;
        setThisAsParent(details, "details");
    }

    
    public List<LocatableRef> getReverseRelationships() {
        return reverseRelationships;
    }

    public void setReverseRelationships( List<LocatableRef> reverseRelationships) {
        this.reverseRelationships = reverseRelationships;
    }

    public void addReverseRelationship(LocatableRef reverseRelationship) {
        this.reverseRelationships.add(reverseRelationship);
    }

    
    public List<PartyRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships( List<PartyRelationship> relationships) {
        this.relationships = relationships;
        setThisAsParent(relationships, "relationships");
    }

    public void addRelationship(PartyRelationship relationship) {
        this.relationships.add(relationship);
        this.setThisAsParent(relationship, "relationships");
    }

    /**
     * Type of party, such as PERSON, ORGANISATION, etc. Role name, e.g. general practitioner , nurse , private citizen . Taken from inherited name attribute.
     */
    public DvText getType() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Party party = (Party) o;
        return Objects.equals(identities, party.identities) &&
                Objects.equals(contacts, party.contacts) &&
                Objects.equals(details, party.details) &&
                Objects.equals(reverseRelationships, party.reverseRelationships) &&
                Objects.equals(relationships, party.relationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identities, contacts, details, reverseRelationships, relationships);
    }
}
