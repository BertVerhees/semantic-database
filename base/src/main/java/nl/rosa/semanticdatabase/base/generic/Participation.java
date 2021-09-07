package nl.rosa.semanticdatabase.base.generic;

import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public class Participation {

    private DvText function;
    private DvCodedText mode;
    private DvInterval<DvDateTime> time;
    private PartyProxy performer;

    public Participation() {
    }

    public Participation(PartyProxy performer, DvText function,  DvCodedText mode,  DvInterval<DvDateTime> time) {
        this.function = function;
        this.mode = mode;
        this.time = time;
        this.performer = performer;
    }

    public DvText getFunction() {
        return function;
    }

    public void setFunction(DvText function) {
        this.function = function;
    }

    
    public DvCodedText getMode() {
        return mode;
    }

    public void setMode( DvCodedText mode) {
        this.mode = mode;
    }

    
    public DvInterval<DvDateTime> getTime() {
        return time;
    }

    public void setTime( DvInterval<DvDateTime> time) {
        this.time = time;
    }

    public PartyProxy getPerformer() {
        return performer;
    }

    public void setPerformer(PartyProxy performer) {
        this.performer = performer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participation that = (Participation) o;
        return Objects.equals(function, that.function) &&
                Objects.equals(mode, that.mode) &&
                Objects.equals(time, that.time) &&
                Objects.equals(performer, that.performer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(function, mode, time, performer);
    }
}
