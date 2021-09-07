package nl.rosa.semanticdatabase.base.datastructures;


import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class PointEvent<Type extends ItemStructure> extends Event<Type> {

    public PointEvent() {
    }

    public PointEvent(String archetypeNodeId, DvText name, DvDateTime time, Type data) {
        super(archetypeNodeId, name, time, data);
    }

    public PointEvent(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, DvDateTime time, Type data, Type state) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName, time, data, state);
    }

    /**
     * Construct a PointEvent
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param time
     * @param data
     * @param state
     */
    public PointEvent(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            History<Type> parent,
            String parentAttributeName,
            DvDateTime time,
            Type data,
            Type state) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links,
                parent, time, data, state);
    }
}
