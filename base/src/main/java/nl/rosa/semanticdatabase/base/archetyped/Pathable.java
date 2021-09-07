package nl.rosa.semanticdatabase.base.archetyped;

import nl.rosa.semanticdatabase.utils.paths.PathSegment;
import nl.rosa.semanticdatabase.utils.paths.PathUtil;
import nl.rosa.semanticdatabase.utils.paths.queries.RMObjectWithPath;
import nl.rosa.semanticdatabase.utils.paths.queries.RMPathQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pathable {
    private Pathable parent;
    private String parentAttributeName;

    public Pathable() {
    }

    /**
     * Creates a Pathable
     *
     * @param parent null if not present
     */
    public Pathable(Pathable parent) {
        this.parent = parent;
    }

    public Pathable(Pathable parent, String parentAttributeName) {
        this.parent = parent;
        this.parentAttributeName = parentAttributeName;
    }

    public Object itemAtPath(String s) {
//        return new RMPathQuery(s).find( this);
        return null;
    }

    public List<Object> itemsAtPath(String s) {
//        List<RMObjectWithPath> objects = new RMPathQuery(s).findList( this);
//        List<Object> result = new ArrayList<>();
//        for (RMObjectWithPath object : objects) {
//            result.add(object.getObject());
//        }
//        return result;
        return null;
    }

    public Pathable getParent() {
        return parent;
    }

    private void setParent(Pathable parent) {
        this.parent = parent;
    }

    private void setParentAttributeName(String parentAttributeName) {
        this.parentAttributeName = parentAttributeName;
    }

    /**
     * Utility method to set this object as the parent of the given child,
     * if the child is not null
     */
    protected void setThisAsParent(Pathable child, String attributeName) {
        if (child != null) {
            child.setParent(this);
            child.setParentAttributeName(attributeName);
        }
    }

    /**
     * Utility method to set this object as the parent of the given child,
     * if the child is not null
     */
    protected void setThisAsParent(Collection<? extends Pathable> children, String attributeName) {
        if (children != null) {
            for (Pathable child : children) {
                this.setThisAsParent(child, attributeName);
            }
        }
    }

    protected String getParentAttributeName() {
        return parentAttributeName;
    }

    public List<PathSegment> getPathSegments() {
        Pathable parent = getParent();
        if (parent == null) {
            return new ArrayList<>();
        }

        List<PathSegment> segments = parent.getPathSegments();
        segments.add(new PathSegment(parentAttributeName));
        return segments;
    }

    /**
     * Path from the toplevel-RM object. Not sure if this should be here, because the EHR and Folder objects are also in
     * the RM. But for now, it works because the most toplevel element is a Composition
     * <p>
     * API subject to change in the future!
     *
     * @return
     */
    public final String getPath() {
        return PathUtil.getPath(getPathSegments());
    }

}
