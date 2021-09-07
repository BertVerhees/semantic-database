package nl.rosa.semanticdatabase.base.datatype;

import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.identification.TerminologyId;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: reuse archetype model TerminologyCode? Thing is, that doesn't constrain as nicely with the archetype model...
 * Created by pieter.bos on 04/11/15.
 */
public class CodePhrase extends DataValue {

    private TerminologyId terminologyId;
    private String codeString;
    
    private String preferredTerm;

    public CodePhrase() {

    }
    public CodePhrase(String terminologyId, String codeString) {
        this(new TerminologyId(terminologyId), codeString, null);
    }


    public CodePhrase(TerminologyId terminologyId, String codeString) {
        this(terminologyId, codeString, null);
    }

    public CodePhrase(String terminologyId, String codeString, String preferredTerm) {
        this.terminologyId = new TerminologyId(terminologyId);
        this.codeString = codeString;
        this.preferredTerm = preferredTerm;
    }

    public CodePhrase(TerminologyId terminologyId, String codeString, String preferredTerm) {
        this.terminologyId = terminologyId;
        this.codeString = codeString;
        this.preferredTerm = preferredTerm;
    }

    /**
     * Construct a code phrase in the form:
     * <br>
     * [terminologyId::codeString]
     * <br>
     * or
     * <br>
     * terminologyId::codeString
     * <p>
     * terminologyId can be just a a string, or contain a version as in  terminologyId(version)
     *
     * @param phrase
     */
    public CodePhrase(String phrase) {
        if(phrase == null) {
            throw new IllegalArgumentException("null value");
        }
        int i = phrase.indexOf("::");
        if(i <= 0 || i >= phrase.length() -1) {
            throw new IllegalArgumentException("wrong format of code phrase");
        }
        String t = phrase.substring(0, i);
        String c = phrase.substring(i + 2);
        this.terminologyId = new TerminologyId(t);
        this.codeString = c;
    }

//    public CodePhrase parse(String value) {
//        if(value == null) {
//            throw new IllegalArgumentException("null value");
//        }
//        int i = value.indexOf("::");
//        if(i <= 0 || i >= value.length() -1) {
//            throw new IllegalArgumentException("wrong format of code phrase");
//        }
//        String t = value.substring(0, i);
//        String c = value.substring(i + 2);
//        this.terminologyId = new TerminologyId(t);
//        this.codeString = c;
//    }

    public TerminologyId getTerminologyId() {
        return terminologyId;
    }

    public void setTerminologyId(TerminologyId terminologyId) {
        this.terminologyId = terminologyId;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public String getPreferredTerm() {
        return preferredTerm;
    }

    public void setPreferredTerm(String preferredTerm) {
        this.preferredTerm = preferredTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodePhrase that = (CodePhrase) o;
        return Objects.equals(terminologyId, that.terminologyId) &&
                Objects.equals(codeString, that.codeString) &&
                Objects.equals(preferredTerm, that.preferredTerm);

    }

    @Override
    public int hashCode() {
        return Objects.hash(terminologyId, codeString, preferredTerm);
    }

    public String toString() {
        return terminologyId + "::" + codeString;//TODO: preferredTerm?
    }
}