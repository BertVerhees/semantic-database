package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
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
public class Element extends Item implements SingleValuedDataValue<DataValue> {

    private DataValue value;

    private DvCodedText nullFlavour;

    private DvText nullReason;

    public Element() {
    }

    public Element(String archetypeNodeId, DvText name, DataValue value) {
        super(archetypeNodeId, name);
        this.value = value;
    }

    public Element(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails,
                   FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName,
                   DataValue value, DvCodedText nullFlavour, DvText nullReason) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.value = value;
        this.nullFlavour = nullFlavour;
        this.nullReason = nullReason;
    }

    /**
     * Construct an Element
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param value
     * @param nullFlavour       required if value is null
     * @throws IllegalArgumentException if both value and nullFlavour
     *                                  are null
     */
    public Element(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            DataValue value,
            DvCodedText nullFlavour,
            TerminologyService terminologyService) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
        if (( value == null && nullFlavour == null )
                || ( value != null && nullFlavour != null )) {
            throw new IllegalArgumentException(
                    "null or unnecessary nullFlavour");
        }
        if (value == null) {
            if (terminologyService == null) {
                throw new IllegalArgumentException("null terminologyService");
            }
            if (!terminologyService.terminology(TerminologyService.OPENEHR)
                    .codesForGroupName(TerminologyService.NULL_FLAVOURS, "en")
                    .contains(nullFlavour.getDefiningCode())) {
                throw new IllegalArgumentException(
                        "unknown nullFlavour: " + nullFlavour);
            }
        }
        this.value = value;
        this.nullFlavour = nullFlavour;
    }

    public DvCodedText getNullFlavour() {
        return nullFlavour;
    }

    public void setNullFlavour(DvCodedText nullFlavour) {
        this.nullFlavour = nullFlavour;
    }

    @Override
    public DataValue getValue() {
        return value;
    }

    @Override
    public void setValue(DataValue value) {
        this.value = value;
    }

    public DvText getNullReason() {
        return nullReason;
    }

    public void setNullReason(DvText nullReason) {
        this.nullReason = nullReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Element element = (Element) o;
        return Objects.equals(value, element.value) &&
                Objects.equals(nullFlavour, element.nullFlavour) &&
                Objects.equals(nullReason, element.nullReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, nullFlavour, nullReason);
    }
}
