package nl.rosa.semanticdatabase.base.generic;

import com.fasterxml.jackson.annotation.JsonAlias;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class AuditDetails {

    private String systemId;
    private DvDateTime timeCommitted;
    private DvCodedText changeType;
    private DvText description;
    private PartyProxy committer;

    public AuditDetails() {
    }


    public AuditDetails(String systemId, PartyProxy committer, DvDateTime timeCommitted, DvCodedText changeType, DvText description) {
        this.systemId = systemId;
        this.timeCommitted = timeCommitted;
        this.changeType = changeType;
        this.description = description;
        this.committer = committer;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public DvDateTime getTimeCommitted() {
        return timeCommitted;
    }

    @JsonAlias({"time_commited"})
    public void setTimeCommitted(DvDateTime timeCommitted) {
        this.timeCommitted = timeCommitted;
    }

    public DvCodedText getChangeType() {
        return changeType;
    }

    public void setChangeType(DvCodedText changeType) {
        this.changeType = changeType;
    }

    
    public DvText getDescription() {
        return description;
    }

    public void setDescription( DvText description) {
        this.description = description;
    }

    public PartyProxy getCommitter() {
        return committer;
    }

    public void setCommitter(PartyProxy committer) {
        this.committer = committer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditDetails that = (AuditDetails) o;
        return Objects.equals(systemId, that.systemId) &&
                Objects.equals(timeCommitted, that.timeCommitted) &&
                Objects.equals(changeType, that.changeType) &&
                Objects.equals(description, that.description) &&
                Objects.equals(committer, that.committer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, timeCommitted, changeType, description, committer);
    }
}
