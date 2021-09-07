package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;
import nl.rosa.semanticdatabase.utils.paths.PathSegment;

import java.util.*;

public abstract class Locatable extends Pathable {

    private DvText name;
    private String archetypeNodeId;
    private UidBasedId uid;
    private Archetyped archetypeDetails;
    private FeederAudit feederAudit;
    private Set<Link> links = new HashSet<>();
    public static final String PATH_SEPARATOR = "/";
    public static final String ROOT = PATH_SEPARATOR;



    public Locatable() {
    }

    public Locatable(String archetypeNodeId, DvText name) {
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
    }

    /**
     * Constructs a Locatable
     *
     * @param uid              null if not specified
     * @param archetypeNodeId  not null
     * @param name             not null
     * @param archetypeDetails null if not specified
     * @param feederAudit      null if not specified
     * @param links            null if not specified
     * @param parent			 null if not specified
     * @throws IllegalArgumentException if name null or archetypeNodeId null
     *                                  or links not null and empty
     */
    protected Locatable(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent) {
        super(parent);

        if (archetypeNodeId == null) {
            throw new IllegalArgumentException("null archetypeNodeId");
        }
        if (name == null) {
            throw new IllegalArgumentException("null name");
        }
        if (links != null && links.isEmpty()) {
            throw new IllegalArgumentException("empty links");
        }
        this.uid = uid;
        this.archetypeNodeId = archetypeNodeId;
        this.name = name;
        this.archetypeDetails = archetypeDetails;
        this.feederAudit = feederAudit;
        this.links = links;
    }

    public Locatable(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            String parentAttributeName) {
        super(parent, parentAttributeName);
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.name = name;
        this.archetypeNodeId = archetypeNodeId;
        this.uid = uid;
        this.archetypeDetails = archetypeDetails;
        this.feederAudit = feederAudit;
        this.links = links;
    }

    public DvText getName() {
        return name;
    }

    public void setName(DvText name) {
        if (name == null) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
    }

    /**
     * convenience method
     */
    public void setNameAsString(String name) {
        this.name = new DvText(name);
    }


    public String getArchetypeNodeId() {
        return archetypeNodeId;
    }

    public void setArchetypeNodeId(String archetypeNodeId) {
        if (archetypeNodeId == null) {
            throw new NullPointerException("Property:archetypeNodeId has cardinality NonNull, but is null");
        }
        this.archetypeNodeId = archetypeNodeId;
    }

    public UidBasedId getUid() {
        return uid;
    }

    public void setUid(UidBasedId uid) {
        this.uid = uid;
    }

    public Archetyped getArchetypeDetails() {
        return archetypeDetails;
    }

    public void setArchetypeDetails(Archetyped archetypeDetails) {
        this.archetypeDetails = archetypeDetails;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> linked) {
        this.links = linked;
    }

    public void addLink(Link link) {
        this.links.add(link);
    }

    @Override
    public List<PathSegment> getPathSegments() {
        Pathable parent = getParent();
        if (parent == null) {
            return new ArrayList<>();
        }

        List<PathSegment> segments = parent.getPathSegments();
        segments.add(new PathSegment(getParentAttributeName(), archetypeNodeId));
        return segments;
    }

    public String getNameAsString() {
        return name == null ? null : name.getValue();
    }

    public FeederAudit getFeederAudit() {
        return feederAudit;
    }

    public void setFeederAudit(FeederAudit feederAudit) {
        this.feederAudit = feederAudit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locatable locatable = (Locatable) o;
        return Objects.equals(name, locatable.name) &&
                Objects.equals(archetypeNodeId, locatable.archetypeNodeId) &&
                Objects.equals(uid, locatable.uid) &&
                Objects.equals(archetypeDetails, locatable.archetypeDetails) &&
                Objects.equals(feederAudit, locatable.feederAudit) &&
                Objects.equals(links, locatable.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, archetypeNodeId, uid, archetypeDetails, feederAudit, links);
    }
}
