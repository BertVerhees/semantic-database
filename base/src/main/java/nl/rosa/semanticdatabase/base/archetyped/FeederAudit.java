package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.base.datavalues.DvIdentifier;
import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvEncapsulated;

import java.util.List;
import java.util.Objects;

public class FeederAudit {

    protected List<DvIdentifier> originatingSystemItemIds;
    protected List<DvIdentifier> feederSystemItemIds;
    protected DvEncapsulated originalContent;
    protected FeederAuditDetails originatingSystemAudit;
    protected FeederAuditDetails feederSystemAudit;

    public FeederAudit() {
    }

    public FeederAudit(
            FeederAuditDetails originatingSystemAudit,
            List<DvIdentifier> originatingSystemItemIds,
            FeederAuditDetails feederSystemAudit,
            List<DvIdentifier> feederSystemItemIds,
            DvEncapsulated originalContent) {
        if (originatingSystemAudit == null) {
            throw new NullPointerException("Property:originatingSystemAudit has cardinality NonNull, but is null");
        }
        this.originatingSystemItemIds = originatingSystemItemIds;
        this.feederSystemItemIds = feederSystemItemIds;
        this.originalContent = originalContent;
        this.originatingSystemAudit = originatingSystemAudit;
        this.feederSystemAudit = feederSystemAudit;
    }

    public List<DvIdentifier> getOriginatingSystemItemIds() {
        if (originatingSystemAudit == null) {
            throw new NullPointerException("Property:originatingSystemAudit has cardinality NonNull, but is null");
        }
        return originatingSystemItemIds;
    }

    public void setOriginatingSystemItemIds(List<DvIdentifier> originatingSystemItemIds) {
        this.originatingSystemItemIds = originatingSystemItemIds;
    }

    public List<DvIdentifier> getFeederSystemItemIds() {
        return feederSystemItemIds;
    }

    public void setFeederSystemItemIds(List<DvIdentifier> feederSystemItemIds) {
        this.feederSystemItemIds = feederSystemItemIds;
    }

    public DvEncapsulated getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(DvEncapsulated originalContent) {
        this.originalContent = originalContent;
    }

    public FeederAuditDetails getOriginatingSystemAudit() {
        return originatingSystemAudit;
    }

    public void setOriginatingSystemAudit(FeederAuditDetails originatingSystemAudit) {
        this.originatingSystemAudit = originatingSystemAudit;
    }

    public FeederAuditDetails getFeederSystemAudit() {
        return feederSystemAudit;
    }

    public void setFeederSystemAudit(FeederAuditDetails feederSystemAudit) {
        this.feederSystemAudit = feederSystemAudit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeederAudit that = (FeederAudit) o;

        return Objects.equals(originatingSystemItemIds, that.originatingSystemItemIds) &&
                Objects.equals(feederSystemItemIds, that.feederSystemItemIds) &&
                Objects.equals(originalContent, that.originalContent) &&
                Objects.equals(originatingSystemAudit, that.originatingSystemAudit) &&
                Objects.equals(feederSystemAudit, that.feederSystemAudit);

    }

    @Override
    public int hashCode() {
        return Objects.hash(originatingSystemItemIds, feederSystemItemIds, originalContent, originatingSystemAudit, feederSystemAudit);
    }
}
