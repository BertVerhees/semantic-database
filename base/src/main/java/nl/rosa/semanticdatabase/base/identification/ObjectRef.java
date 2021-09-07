package nl.rosa.semanticdatabase.base.identification;


import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class ObjectRef<Idtype extends ObjectId> {

    private String namespace;
    private String type;
    private Idtype id;

    public ObjectRef() {
    }

    public ObjectRef(Idtype id, String namespace, String type) {
        if (id == null) {
            throw new IllegalArgumentException("ObjectRef cannot be created with null id");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("ObjectRef cannot be created with null namespace");
        }
        if (type == null) {
            throw new IllegalArgumentException("ObjectRef cannot be created with null type");
        }
        this.namespace = namespace;
        this.type = type;
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Idtype getId() {
        return id;
    }

    public void setId(Idtype id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectRef<?> objectRef = (ObjectRef<?>) o;
        return Objects.equals(namespace, objectRef.namespace) &&
                Objects.equals(type, objectRef.type) &&
                Objects.equals(id, objectRef.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, type, id);
    }
}
