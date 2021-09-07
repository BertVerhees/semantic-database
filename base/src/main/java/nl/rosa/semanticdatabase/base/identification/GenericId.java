package nl.rosa.semanticdatabase.base.identification;


import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class GenericId extends ObjectId {

    private String scheme;

    public GenericId() {
    }

    public GenericId(String value, String scheme) {
        super(value);
        this.scheme = scheme;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GenericId genericId = (GenericId) o;
        return Objects.equals(scheme, genericId.scheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scheme);
    }
}
