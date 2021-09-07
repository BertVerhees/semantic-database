package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.base.identification.ArchetypeId;

import java.util.Objects;

public class Archetyped {

    private ArchetypeId archetypeId;
    private TemplateId templateId;
    private String rmVersion;

    public Archetyped() {
    }

    public Archetyped(ArchetypeId archetypeId, String rmVersion) {
        this.archetypeId = archetypeId;
        this.rmVersion = rmVersion;
    }

    public Archetyped(ArchetypeId archetypeId, TemplateId templateId, String rmVersion) {
        if (archetypeId == null) {
            throw new NullPointerException("Property:archetypeId has cardinality NonNull, but is null");
        }
        if (rmVersion == null) {
            throw new NullPointerException("Property:rmVersion has cardinality NonNull, but is null");
        }
        this.archetypeId = archetypeId;
        this.templateId = templateId;
        this.rmVersion = rmVersion;
    }


    public ArchetypeId getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(ArchetypeId archetypeId) {
        if (archetypeId == null) {
            throw new NullPointerException("Property:archetypeId has cardinality NonNull, but is null");
        }
        this.archetypeId = archetypeId;
    }

    public TemplateId getTemplateId() {
        return templateId;
    }

    public void setTemplateId(TemplateId templateId) {
        this.templateId = templateId;
    }

    public String getRmVersion() {
        return rmVersion;
    }

    public void setRmVersion(String rmVersion) {
        if (rmVersion == null) {
            throw new NullPointerException("Property:rmVersion has cardinality NonNull, but is null");
        }
        this.rmVersion = rmVersion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Archetyped that = (Archetyped) o;

        return Objects.equals(archetypeId, that.archetypeId) &&
                Objects.equals(templateId, that.templateId) &&
                Objects.equals(rmVersion, that.rmVersion);

    }

    @Override
    public int hashCode() {
        return Objects.hash(archetypeId, templateId, rmVersion);
    }
}
