package nl.rosa.semanticdatabase.utils.model;

import java.util.Set;

/**
 * Default created on 12-12-2020
 */

public interface IRMTypeInfo {
    IRMAttributeInfo getAttribute(String attributeName);

    boolean isDescendantOrEqual(IRMTypeInfo other);

    Class getJavaClass();

    void addDirectParentClass(IRMTypeInfo parent);

    void addDirectDescendantClass(IRMTypeInfo parent);

    Set<IRMTypeInfo> getDirectDescendantClasses();

    Set<IRMTypeInfo> getDirectParentClasses();
}
