package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.*;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;
import nl.rosa.semanticdatabase.utils.datetime.CombinedPeriodDuration;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 03/11/15.
 */
public abstract class Event<Type extends ItemStructure> extends Locatable {

    private DvDateTime time;
    private Type state;
    private Type data;


    public Event() {
    }

    public Event(String archetypeNodeId, DvText name, DvDateTime time, Type data) {
        super(archetypeNodeId, name);
        this.time = time;
        this.data = data;
    }

    /**
     * Constructs an Event
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param parent	null if unspecified
     * @param time		not null
     * @param data		not null
     * @param state
     * @throws IllegalArgumentException if time, data or parent null
     */
    public Event(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            History<Type> parent,
            DvDateTime time,
            Type data,
            Type state) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent);
        if (time == null) {
            throw new IllegalArgumentException("null time");
        }
        if (data == null) {
            throw new IllegalArgumentException("null data");
        }
        //this.parent = parent;
        this.time = time;
        this.data = data;
        this.state = state;
    }


    public Event(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            String parentAttributeName,
            DvDateTime time,
            Type data,
            Type state) {
        super(
                uid,
                archetypeNodeId,
                name,
                archetypeDetails,
                feederAudit,
                links,
                parent,
                parentAttributeName);
        this.time = time;
        this.state = state;
        this.data = data;
    }

    public DvDateTime getTime() {
        return time;
    }

    public void setTime(DvDateTime time) {
        this.time = time;
    }

    public Type getState() {
        return state;
    }

    public void setState(Type state) {
        this.state = state;
        setThisAsParent(state, "state");
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
        setThisAsParent(data, "data");
    }

    public DvDuration getOffset() {
        DvDuration result = new DvDuration();
        Duration duration = Duration.between(OffsetDateTime.from(((History) getParent()).getOrigin().getValue()), OffsetDateTime.from(time.getValue()));
        result.setValue(CombinedPeriodDuration.of(duration));
        //would be even better if we could set the accurary too. Let's not for now
        return result;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Event<?> event = (Event<?>) o;
        return Objects.equals(time, event.time) &&
                Objects.equals(state, event.state) &&
                Objects.equals(data, event.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time, state, data);
    }
}
