package nl.rosa.semanticdatabase.base.datavalues;


import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvIdentifier extends DataValue {

    
    private String issuer;
    
    private String assigner;
    private String id;
    
    private String type;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvIdentifier that = (DvIdentifier) o;
        return Objects.equals(issuer, that.issuer) &&
                Objects.equals(assigner, that.assigner) &&
                Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuer, assigner, id, type);
    }
}
