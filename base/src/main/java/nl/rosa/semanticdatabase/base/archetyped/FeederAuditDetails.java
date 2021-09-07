package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.base.datastructures.ItemStructure;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.generic.PartyIdentified;
import nl.rosa.semanticdatabase.base.generic.PartyProxy;

import java.util.Objects;

public class FeederAuditDetails {

    protected String systemId;
    protected PartyIdentified location;
    protected PartyIdentified provider;
    protected PartyProxy subject;
    protected DvDateTime time;
    protected String versionId;
    private ItemStructure otherDetails;

    public FeederAuditDetails() {
    }

    public FeederAuditDetails(
            String systemId,
            PartyIdentified provider,
            PartyIdentified location,
            DvDateTime time,
            PartyProxy subject,
            String versionId,
            ItemStructure otherDetails) {
        if (systemId == null) {
            throw new NullPointerException("Property:systemId has cardinality NonNull, but is null");
        }
        if (otherDetails == null) {
            throw new NullPointerException("Property:otherDetails has cardinality NonNull, but is null");
        }
        this.systemId = systemId;
        this.location = location;
        this.provider = provider;
        this.subject = subject;
        this.time = time;
        this.versionId = versionId;
        this.otherDetails = otherDetails;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        if (systemId == null) {
            throw new NullPointerException("Property:systemId has cardinality NonNull, but is null");
        }
        this.systemId = systemId;
    }

    public PartyIdentified getLocation() {
        return location;
    }

    public void setLocation(PartyIdentified location) {
        this.location = location;
    }

    public PartyIdentified getProvider() {
        return provider;
    }

    public void setProvider(PartyIdentified provider) {
        this.provider = provider;
    }

    public PartyProxy getSubject() {
        return subject;
    }

    public void setSubject(PartyProxy subject) {
        this.subject = subject;
    }

    public DvDateTime getTime() {
        return time;
    }

    public void setTime(DvDateTime time) {
        this.time = time;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public ItemStructure getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(ItemStructure otherDetails) {
        if (otherDetails == null) {
            throw new NullPointerException("Property:otherDetails has cardinality NonNull, but is null");
        }
        this.otherDetails = otherDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeederAuditDetails that = (FeederAuditDetails) o;
        return Objects.equals(systemId, that.systemId) &&
                Objects.equals(location, that.location) &&
                Objects.equals(provider, that.provider) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(time, that.time) &&
                Objects.equals(versionId, that.versionId) &&
                Objects.equals(otherDetails, that.otherDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, location, provider, subject, time, versionId, otherDetails);
    }
}
