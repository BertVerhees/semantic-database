package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.base.datavalues.DvEHRURI;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.Objects;

public class Link {

    private DvText meaning;
    private DvText type;
    private DvEHRURI target;

    public Link() {
    }

    public Link(DvText meaning, DvText type, DvEHRURI target) {
        if (meaning == null) {
            throw new NullPointerException("Property:meaning has cardinality NonNull, but is null");
        }
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if (target == null) {
            throw new NullPointerException("Property:target has cardinality NonNull, but is null");
        }
        this.meaning = meaning;
        this.type = type;
        this.target = target;
    }

    public DvText getMeaning() {
        return meaning;
    }

    public void setMeaning(DvText meaning) {
        if (meaning == null) {
            throw new NullPointerException("Property:meaning has cardinality NonNull, but is null");
        }
        this.meaning = meaning;
    }

    public DvText getType() {
        return type;
    }

    public void setType(DvText type) {
        if (type == null) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    public DvEHRURI getTarget() {
        return target;
    }

    public void setTarget(DvEHRURI target) {
        if (target == null) {
            throw new NullPointerException("Property:target has cardinality NonNull, but is null");
        }
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return Objects.equals(meaning, link.meaning) &&
                Objects.equals(type, link.type) &&
                Objects.equals(target, link.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meaning, type, target);
    }
}
