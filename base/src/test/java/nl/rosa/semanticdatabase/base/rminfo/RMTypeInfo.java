package nl.rosa.semanticdatabase.base.rminfo;

import nl.rosa.semanticdatabase.utils.model.IRMTypeInfo;

import java.util.*;

/**
 * Originally: Created by pieter.bos on 25/03/16.
 */
public class RMTypeInfo implements IRMTypeInfo {

    private final String rmName;
    private final Class javaClass;
    //only direct parent classes here
    private final Set<IRMTypeInfo> parentClasses = new LinkedHashSet<>();
    //only direct descendant classes here
    private final Set<IRMTypeInfo> descendantClasses = new LinkedHashSet<>();
    private Map<String, RMAttributeInfo> attributes = new HashMap<>();

    public RMTypeInfo(Class clazz, String rmName) {
        this.javaClass = clazz;
        this.rmName = rmName;
    }

    public String getRmName() {
        return rmName;
    }

    public Class getJavaClass() {
        return javaClass;
    }

    public Map<String, RMAttributeInfo> getAttributes() {
        return attributes;
    }

    public void addAttribute(RMAttributeInfo attribute) {
        attributes.put(attribute.getRmName(), attribute);
    }

    public RMAttributeInfo getAttribute(String attributeName) {
        return attributes.get(attributeName);
    }

    public void addDirectParentClass(IRMTypeInfo parent) {
        parentClasses.add(parent);
    }

    public Set<IRMTypeInfo> getDirectParentClasses() {
        return parentClasses;
    }

    public void addDirectDescendantClass(IRMTypeInfo parent) {
        descendantClasses.add(parent);
    }

    public Set<IRMTypeInfo> getDirectDescendantClasses() {
        return descendantClasses;
    }

    public Set<IRMTypeInfo> getAllDescendantClasses() {
        Stack<IRMTypeInfo> workList = new Stack<>();
        Set<IRMTypeInfo> result = new LinkedHashSet<>();

        workList.addAll(descendantClasses);
        while (!workList.isEmpty()) {
            IRMTypeInfo descendant = workList.pop();
            workList.addAll(descendant.getDirectDescendantClasses());
            result.add(descendant);
        }
        return result;
    }

    public Set<IRMTypeInfo> getAllParentClasses() {
        Stack<IRMTypeInfo> workList = new Stack<>();
        Set<IRMTypeInfo> result = new LinkedHashSet<>();

        workList.addAll(parentClasses);
        while (!workList.isEmpty()) {
            IRMTypeInfo parent = workList.pop();
            workList.addAll(parent.getDirectParentClasses());
            result.add(parent);
        }
        return result;
    }

    public boolean isParentOf(RMTypeInfo other) {
        return getAllDescendantClasses().contains(other);
    }

    public boolean isDescendantOf(RMTypeInfo other) {
        return getAllParentClasses().contains(other);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RMTypeInfo that = (RMTypeInfo) o;
        return Objects.equals(rmName, that.rmName) &&
                Objects.equals(javaClass, that.javaClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmName, javaClass);
    }

    @Override
    public String toString() {
        return rmName;
    }

    public boolean isDescendantOrEqual(IRMTypeInfo other) {
        return other.equals(this) || getAllParentClasses().contains(other);
    }
}
