package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class IntervalEvent<Type extends ItemStructure> extends Event<Type> {

    private DvDuration width;
    private Long sampleCount;
    private DvCodedText mathFunction;

    public IntervalEvent() {
    }

    public IntervalEvent(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, DvDateTime time, Type data, Type state, DvDuration width, DvCodedText mathFunction, Long sampleCount) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName, time, data, state);
        this.width = width;
        this.sampleCount = sampleCount;
        this.mathFunction = mathFunction;
    }

    public IntervalEvent(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            History<Type> parent,
            DvDateTime time,
            Type data,
            Type state,
            DvDuration width,
            DvCodedText mathFunction,
            Long sampleCount,
            TerminologyService terminologyService) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent,
                time, data, state);
        if (width == null) {
            throw new IllegalArgumentException("null width");
        }
        if (mathFunction == null) {
            throw new IllegalArgumentException("null mathFunction");
        }
        if (terminologyService == null) {
            throw new IllegalArgumentException("null terminologyService");
        }
        if (!terminologyService.terminology(TerminologyService.OPENEHR)
                .codesForGroupName("event math function", "en")
                .contains(mathFunction.getDefiningCode())) {
            throw new IllegalArgumentException(
                    "unknown mathFunction: " + mathFunction);
        }
        this.width = width;
        this.mathFunction = mathFunction;
        this.sampleCount = sampleCount;
    }
    /**
     * Start time of the interval of this event
     *
     *@return start time
     */
    public DvDateTime intervalStartTime() {
        return (DvDateTime) getTime().subtract(width);
    }


    public DvDuration getWidth() {
        return width;
    }

    public void setWidth(DvDuration width) {
        this.width = width;
    }

    public Long getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Long sampleCount) {
        this.sampleCount = sampleCount;
    }

    public DvCodedText getMathFunction() {
        return mathFunction;
    }

    public void setMathFunction(DvCodedText mathFunction) {
        this.mathFunction = mathFunction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntervalEvent<?> that = (IntervalEvent<?>) o;
        return Objects.equals(width, that.width) &&
                Objects.equals(sampleCount, that.sampleCount) &&
                Objects.equals(mathFunction, that.mathFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, sampleCount, mathFunction);
    }
}
