package nl.rosa.semanticdatabase.utils.paths;

import nl.rosa.semanticdatabase.utils.definitions.BMMCodeDefinitions;

import java.util.List;

/**
 * Created by:
 * User: BV, Date: 21-4-2020, Time: 15:46
 */
public class PathUtil {
    public static String getPath(List<PathSegment> pathSegments) {
        StringBuilder result = new StringBuilder();

        if (pathSegments.isEmpty()) {
            return "/";
        }
        for (PathSegment segment : pathSegments) {
            result.append("/");
            result.append(segment.getNodeName());
            if (segment.getNodeId() != null && !segment.getNodeId().equals(BMMCodeDefinitions.PRIMITIVE_NODE_ID)) {
                result.append("[");
                result.append(segment.getNodeId());
                if (segment.hasNumberIndex()) {
                    result.append(",");
                    result.append(segment.getIndex().toString());
                }
                result.append("]");
            }
        }
        return result.toString();
    }
}
