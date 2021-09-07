package nl.rosa.semanticdatabase.base.terminology;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class TerminologyCode {

    private String terminologyId;
    private String terminologyVersion;
    private String codeString;

    private URI uri;

    public static TerminologyCode createFromString(String terminologyString) {
        if (terminologyString.isEmpty()) {
            return null;
        }
        //'[' NAME_CHAR+ ( '(' NAME_CHAR+ ')' )? '::' NAME_CHAR+ ']' ;
        Pattern pattern = Pattern.compile("\\[(?<terminologyId>[^\\(\\)]+)(\\((?<terminologyVersion>.+)\\))?::(?<codeString>.+)\\]");
        Matcher matcher = pattern.matcher(terminologyString);
        TerminologyCode result = new TerminologyCode();
        if (matcher.matches()) {
            result.setTerminologyId(matcher.group("terminologyId"));
            result.setCodeString(matcher.group("codeString"));
            result.setTerminologyVersion(matcher.group("terminologyVersion"));

        } else {
            result.setCodeString(terminologyString);
        }
        return result;
    }

    @JsonCreator
    public static TerminologyCode createFromString(@JsonProperty("terminology_id") String terminologyId,
                                                   @JsonProperty("terminology_version") String terminologyVersion,
                                                   @JsonProperty("code_string") String codeString) {
        TerminologyCode result = new TerminologyCode();
        result.terminologyId = terminologyId;
        result.terminologyVersion = terminologyVersion;
        result.codeString = codeString;
        return result;
    }

}
