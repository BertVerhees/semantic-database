package nl.rosa.semanticdatabase.base.datavalues.text;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class TermMapping {
    /**
     * This is an interesting one, that could be implemented with an enum
     * //TODO: look at it
     * <dl>
     *  <dt>&lt;</dt>
     *  <dd>narrower term</dd>
     *  <dt>=</dt> <dd>equals term</dd>
     *  <dt>&gt;</dt> <dd>broader term</dd>
     * <dt>?</dt> <dd>the kind of mapping is unknown</dd>
     * </dl>
     */
    private Character match = '?';
    
    private DvCodedText purpose;
    private CodePhrase target;

    public TermMapping() {
    }

    public TermMapping(CodePhrase target, Character match,  DvCodedText purpose) {
        this.match = match;
        this.purpose = purpose;
        this.target = target;
    }

    public char getMatch() {
        return match;
    }

    public void setMatch(char match) {
        this.match = match;
    }

    
    public DvCodedText getPurpose() {
        return purpose;
    }

    public void setPurpose( DvCodedText purpose) {
        this.purpose = purpose;
    }

    public CodePhrase getTarget() {
        return target;
    }

    public void setTarget(CodePhrase target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TermMapping that = (TermMapping) o;
        return Objects.equals(match, that.match) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, purpose, target);
    }
}
