package nl.rosa.semanticdatabase.base.datastructures;

import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public abstract class ItemStructure extends DataStructure {

    public ItemStructure(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    /**
     * Constructs a ItemStructure
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param parent
     */
    protected ItemStructure(
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

    public ItemStructure(
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
                parentAttributeName);
    }

    /**
     * In the default model it's in the subclasses, but defined here as well because it has a lot of uses
     */
    public abstract List<? extends Item> getItems();
}
