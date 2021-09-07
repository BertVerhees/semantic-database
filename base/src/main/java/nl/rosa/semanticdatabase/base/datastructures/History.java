package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public final class History<Type extends ItemStructure> extends DataStructure {

    private DvDateTime origin;
    private DvDuration period;
    private DvDuration duration;
    private Type summary;
    private List<Event<Type>> events = new ArrayList<>();


    public History(String archetypeNodeId, DvText name, DvDateTime origin, List<Event<Type>> events) {
        super(archetypeNodeId, name);
        this.origin = origin;
        this.events = events;
    }

    public History(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, DvDateTime origin, List<Event<Type>> events, DvDuration period, DvDuration duration, Type summary) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.origin = origin;
        this.period = period;
        this.duration = duration;
        this.summary = summary;
        this.events = events;
    }

    public History(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            DvDateTime origin,
            List<Event<Type>> events,
            DvDuration period,
            DvDuration duration,
            Type summary){
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
        if (origin == null) {
            throw new IllegalArgumentException("null origin");
        }
        if (events != null && events.size() == 0) {
            throw new IllegalArgumentException("empty events");
        }
        if (events == null && summary == null) {
            throw new IllegalArgumentException("null events and summary");
        }
        this.origin = origin;
        setEvents(events);
        this.period = period;
        this.duration = duration;
        this.summary = summary;
    }

    public DvDateTime getOrigin() {
        return origin;
    }

    public void setOrigin(DvDateTime origin) {
        this.origin = origin;
    }

    public DvDuration getPeriod() {
        return period;
    }

    public void setPeriod(DvDuration period) {
        this.period = period;
    }

    public DvDuration getDuration() {
        return duration;
    }

    public void setDuration(DvDuration duration) {
        this.duration = duration;
    }

    public List<Event<Type>> getEvents() {
        return events;
    }

    public void setEvents(List<Event<Type>> events) {
        this.events = events;
        setThisAsParent(events, "events");
    }

    public void addEvent(Event<Type> event) {
        events.add(event);
        setThisAsParent(event, "events");
    }

    public Type getSummary() {
        return summary;
    }

    public void setSummary(Type summary) {
        this.summary = summary;
        setThisAsParent(summary, "summary");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        History<?> history = (History<?>) o;
        return Objects.equals(origin, history.origin) &&
                Objects.equals(period, history.period) &&
                Objects.equals(duration, history.duration) &&
                Objects.equals(summary, history.summary) &&
                Objects.equals(events, history.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), origin, period, duration, summary, events);
    }
}
