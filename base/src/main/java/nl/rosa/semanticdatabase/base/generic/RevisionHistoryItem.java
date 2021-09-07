package nl.rosa.semanticdatabase.base.generic;

import nl.rosa.semanticdatabase.base.identification.ObjectVersionId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class RevisionHistoryItem {

    private ObjectVersionId versionId;
    private List<AuditDetails> audits = new ArrayList<>();

    public RevisionHistoryItem() {
    }

    public RevisionHistoryItem(ObjectVersionId versionId, List<AuditDetails> audits) {
        this.versionId = versionId;
        this.audits = audits;
    }

    public ObjectVersionId getVersionId() {
        return versionId;
    }

    public void setVersionId(ObjectVersionId versionId) {
        this.versionId = versionId;
    }

    public List<AuditDetails> getAudits() {
        return audits;
    }

    public void setAudits(List<AuditDetails> audits) {
        this.audits = audits;
    }

    public void addAudit(AuditDetails audit) {
        this.audits.add(audit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevisionHistoryItem that = (RevisionHistoryItem) o;
        return Objects.equals(versionId, that.versionId) &&
                Objects.equals(audits, that.audits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionId, audits);
    }
}
