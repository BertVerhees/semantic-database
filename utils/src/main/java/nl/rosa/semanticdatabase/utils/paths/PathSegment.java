package nl.rosa.semanticdatabase.utils.paths;

import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;

/**
 * An object which joins pieces of text (specified as an array, {@link Iterable}, varargs or even a
 * {@link Map}) with a separator. It either appends the results to an {@link Appendable} or returns
 * them as a {@link String}. Example:
 *
 * <pre>{@code
 * Joiner joiner = Joiner.on("; ").skipNulls();
 *  . . .
 * return joiner.join("Harry", null, "Ron", "Hermione");
 * }</pre>
 *
 * <p>This returns the string {@code "Harry; Ron; Hermione"}. Note that all input elements are
 * converted to strings using {@link Object#toString()} before being appended.
 *
 * <p>If neither {@link #skipNulls()} nor {@link #useForNull(String)} is specified, the joining
 * methods will throw {@link NullPointerException} if any given element is null.
 *
 * <p><b>Warning: joiner instances are always immutable</b>; a configuration method such as {@code
 * useForNull} has no effect on the instance it is invoked on! You must store and use the new joiner
 * instance returned by the method. This makes joiners thread-safe, and safe to store as {@code
 * static final} constants.
 *
 * <pre>{@code
 * // Bad! Do not do this!
 * Joiner joiner = Joiner.on(',');
 * joiner.skipNulls(); // does nothing!
 * return joiner.join("wrong", null, "wrong");
 * }</pre>
 *
 * <p>See the Guava User Guide article on <a
 * href="https://github.com/google/guava/wiki/StringsExplained#joiner">{@code Joiner}</a>.
 *
 * @author Kevin Bourrillion
 * @since 2.0
 */
public class PathSegment{
    private final static Joiner expressionJoiner = Joiner.on(",").skipNulls();

    private static final Pattern archetypeRefPattern = Pattern.compile("(.*::)?.*-.*-.*\\..*\\.v.*");
    private static final Pattern nodeIdPattern = Pattern.compile("id(\\.?\\d)+|at(\\.?\\d)+");

    private String nodeName;
    private String nodeId;
    // An explicit archetype ref from a C_ARCHETYPE_ROOT (use archetype...). null otherwise
    private String archetypeRef = null;
    private Integer index;

    public PathSegment(String nodeName, Integer index) {
        this(nodeName, null, index);
    }

    public PathSegment(String nodeName, String nodeId) {
        this(nodeName, nodeId, null);
    }

    public PathSegment(String nodeName) {
        this(nodeName, null, null);
    }

    public PathSegment(String nodeName, String nodeId, Integer index) {
        this.nodeName = nodeName;
        this.nodeId = nodeId;
        this.index = index;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getArchetypeRef() {
        return archetypeRef;
    }

    public void setArchetypeRef(String archetypeRef) {
        this.archetypeRef = archetypeRef;
    }

    public boolean hasIdCode() {
        return nodeId != null && nodeIdPattern.matcher(nodeId).matches();
    }

    public boolean hasNumberIndex() {
        return index != null;
    }

    public boolean hasArchetypeRef() {
        return nodeId != null && archetypeRefPattern.matcher(nodeId).matches();
    }

    @Override
    public String toString() {
        if (hasExpressions()) {
            return "/" + nodeName + "[" + expressionJoiner.join(nodeId, index) + "]";
        } else {
            return "/" + nodeName;
        }
    }

    public boolean hasExpressions() {
        return nodeId != null || index != null;
    }
}