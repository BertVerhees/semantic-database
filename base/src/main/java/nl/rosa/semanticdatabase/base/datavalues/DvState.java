package nl.rosa.semanticdatabase.base.datavalues;

import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

/**
 * For representing state values which obey a defined state machine, such as a variable representing the states of an instruction or care process.
 *
 * DV_STATE is expressed as a String but its values are driven by archetype-defined state machines.
 * This provides a powerful way of capturing stateful complex processes in simple data.
 */
public class DvState extends DataValue implements SingleValuedDataValue<DvCodedText> {

    /**
     * Indicates whether this state is a terminal state, such as "aborted", "completed" etc.
     * from which no further transitions are possible.
     */
    private boolean isTerminal;
    /**
     * The state name. State names are determined by a state/event table defined in archetypes, and coded using
     * openEHR Terminology or local archetype terms, as specified by the archetype.
     */
    private DvCodedText value;

    public DvState(DvCodedText value, boolean isTerminal) {
        this.isTerminal = isTerminal;
        this.value = value;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        this.isTerminal = terminal;
    }

    public DvCodedText getValue() {
        return value;
    }

    public void setValue(DvCodedText value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvState dvState = (DvState) o;
        return isTerminal == dvState.isTerminal &&
                Objects.equals(value, dvState.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTerminal, value);
    }
}
