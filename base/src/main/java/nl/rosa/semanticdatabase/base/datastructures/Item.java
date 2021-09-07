package nl.rosa.semanticdatabase.base.datastructures;


import nl.rosa.semanticdatabase.base.archetyped.*;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Set;

public abstract class Item extends Locatable {

    public Item() {
    }

    public Item(String archetypeNodeId, DvText name) {
        super(archetypeNodeId, name);
    }

    public Item(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
    }
    /**
     * Constructs an Item
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @throws IllegalArgumentException if archetypeNodeId, name null
     */
    protected Item(UidBasedId uid, String archetypeNodeId, DvText name,
                   Archetyped archetypeDetails, FeederAudit feederAudit,
                   Set<Link> links, Pathable parent) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
    }

}
