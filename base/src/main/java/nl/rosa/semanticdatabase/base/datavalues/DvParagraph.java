package nl.rosa.semanticdatabase.base.datavalues;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */


import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DvParagraph extends DataValue {

    private List<DvText> items = new ArrayList<>();

    public List<DvText> getItems() {
        return items;
    }

    public void setItems(List<DvText> items) {
        this.items = items;
    }

    public void addItem(DvText item) {
        this.items.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvParagraph that = (DvParagraph) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
