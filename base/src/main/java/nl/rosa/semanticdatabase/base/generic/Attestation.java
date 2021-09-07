package nl.rosa.semanticdatabase.base.generic;

import nl.rosa.semanticdatabase.base.datavalues.DvEHRURI;
import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvMultimedia;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class Attestation extends AuditDetails {

    private DvMultimedia attestedView;
    private String proof;
    private List<DvEHRURI> items = new ArrayList<>();
    private DvText reason;
    private boolean isPending;

    public Attestation() {
    }

    public Attestation(String systemId, PartyProxy committer, DvDateTime timeCommitted, DvCodedText changeType, DvText description, DvMultimedia attestedView, String proof, List<DvEHRURI> items, DvText reason, boolean isPending) {
        super(systemId, committer, timeCommitted, changeType, description);
        this.attestedView = attestedView;
        this.proof = proof;
        this.items = items;
        this.reason = reason;
        this.isPending = isPending;
    }

    
    public DvMultimedia getAttestedView() {
        return attestedView;
    }

    public void setAttestedView( DvMultimedia attestedView) {
        this.attestedView = attestedView;
    }

    
    public String getProof() {
        return proof;
    }

    public void setProof( String proof) {
        this.proof = proof;
    }

    
    public List<DvEHRURI> getItems() {
        return items;
    }

    public void setItems( List<DvEHRURI> items) {
        this.items = items;
    }

    public DvText getReason() {
        return reason;
    }

    public void setReason(DvText reason) {
        this.reason = reason;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attestation that = (Attestation) o;
        return isPending == that.isPending &&
                Objects.equals(attestedView, that.attestedView) &&
                Objects.equals(proof, that.proof) &&
                Objects.equals(items, that.items) &&
                Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attestedView, proof, items, reason, isPending);
    }
}
