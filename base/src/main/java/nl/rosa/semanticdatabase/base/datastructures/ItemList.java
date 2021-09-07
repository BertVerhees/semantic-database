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
public class ItemList extends ItemStructure {

    private List<Element> items = new ArrayList<>();

    public ItemList(String archetypeNodeId, DvText name, List<Element> items) {
        super(archetypeNodeId, name);
        setItems(items);
    }

    public ItemList(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, List<Element> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setItems(items);
    }

    /**
     * Constructs an ItemList with a list of items
     *
     * @param uid
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails
     * @param feederAudit
     * @param links
     * @param items	null if unspecified
     */
    public ItemList(
            UidBasedId uid,
            String archetypeNodeId,
            DvText name,
            Archetyped archetypeDetails,
            FeederAudit feederAudit,
            Set<Link> links,
            Pathable parent,
            List<Element> items) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit,
                links, parent);
        this.items = items;
    }

    @Override
    public List<Element> getItems() {
        return items;
    }

    public void setItems(List<Element> items) {
        this.items = items;
        setThisAsParent(items, "items");
    }

    public void addItem(Element item) {
        this.items.add(item);
        setThisAsParent(item, "items");
    }
    /**
     * Retrieves the item with given name
     *
     * @param name
     * @return null if item of given name not found
     * @throws IllegalArgumentException if name is null or empty
     */
    public Element namedItem(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        for (Element element : items) {
            if (name.equals(element.getName().getValue())) {
                return element;
            }
        }
        return null;
    }
    /**
     * Returns the count of all items
     *
     * @return item count
     */
    public int itemCount() {
        return items.size();
    }

    /**
     * Retrieve item at specified position
     *
     * @param index starts with 0
     * @return element at given position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= size()).
     */
    public Element ithItem(int index) {
        return getItems().get(index);
    }


    /**
     * Retrieves the names of all items as a list
     *
     * @return list of names
     */
    public List<DvText> names() {
        List<DvText> names = new ArrayList<DvText>();
        for (Element element : items) {
            names.add(element.getName());
        }
        return names;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemList itemList = (ItemList) o;
        return Objects.equals(items, itemList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }
}
