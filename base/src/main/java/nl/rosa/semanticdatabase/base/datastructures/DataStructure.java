package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.*;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public abstract class DataStructure extends Locatable {

    public DataStructure(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    /**
     * Construct a DataStructure
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     */
    protected DataStructure(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
    }

    public DataStructure(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            String parentAttributeName) {
        super(
                uid,
                archetypeNodeId,
                name,
                archetypeDetails,
                feederAudit,
                links,
                parent,
                parentAttributeName
        );
    }
}
