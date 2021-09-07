package nl.rosa.semanticdatabase.base.datastructures;

import com.google.common.collect.Lists;
import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * added constraint is that this contains only one item
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class ItemSingle extends ItemStructure {

    private Element item;


    public ItemSingle(String archetypeNodeId, DvText name, Element item) {
        super(archetypeNodeId, name);
        this.item = item;
    }

    /**
     * Construct a ItemSingle
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param item not null
     * @throws IllegalArgumentException if item null
     */
    public ItemSingle(UidBasedId uid,
                      String archetypeNodeId,
                      DvText name,
                      Archetyped archetypeDetails,
                      FeederAudit feederAudit,
                      Set<Link> links,
                      Pathable parent,
                      Element item) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
        if(item == null) {
            throw new IllegalArgumentException("item null");
        }
        this.item = item;
    }

    public ItemSingle(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, Element item) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        this.item = item;
    }

    public Element getItem() {
        return item;
    }

    public void setItem(Element item) {
        this.item = item;
    }

    @Override
    public List<Element> getItems() {
        return Lists.newArrayList(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemSingle that = (ItemSingle) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), item);
    }
}
