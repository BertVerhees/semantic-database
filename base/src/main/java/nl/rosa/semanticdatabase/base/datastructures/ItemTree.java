package nl.rosa.semanticdatabase.base.datastructures;


import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class ItemTree extends ItemStructure {
    
    private List<Item> items = new ArrayList<>();

    public ItemTree(String archetypeNodeId, DvText name, List<Item> items) {
        super(archetypeNodeId, name);
        setItems(items);
    }

    public ItemTree(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, List<Item> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setItems(items);
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        setThisAsParent(items, "items");
    }

    public void addItem(Item item) {
        this.items.add(item);
        setThisAsParent(item, "items");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemTree itemTree = (ItemTree) o;
        return Objects.equals(items, itemTree.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }
}
