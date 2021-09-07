package nl.rosa.semanticdatabase.base.datastructures;


import nl.rosa.semanticdatabase.base.archetyped.Archetyped;
import nl.rosa.semanticdatabase.base.archetyped.FeederAudit;
import nl.rosa.semanticdatabase.base.archetyped.Link;
import nl.rosa.semanticdatabase.base.archetyped.Pathable;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.identification.UidBasedId;

import java.util.*;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class ItemTable extends ItemStructure {

    private List<Cluster> rows = new ArrayList<>();
    List<DvText> names = new ArrayList<DvText>();


    public ItemTable(String archetypeNodeId, DvText name, List<Cluster> rows) {
        super(archetypeNodeId, name);
        setRows(rows);
    }

    public ItemTable(UidBasedId uid, String archetypeNodeId, DvText name, Archetyped archetypeDetails, FeederAudit feederAudit, Set<Link> links, Pathable parent, String parentAttributeName, List<Cluster> rows) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links, parent, parentAttributeName);
        setRows(rows);
    }

    public List<Cluster> getRows() {
        return rows;
    }

    public void setRows(List<Cluster> rows) {
        this.rows = rows;
        setThisAsParent(rows, "rows");
    }
    public int rowCount() {
        return rows == null ? 0: rows.size();
    }

    /**
     * Return the number of columns
     *
     * @return column count
     */
    public int columnCount() {
        if(rows == null) {
            return 0;
        }
        Cluster firstCol = getRows().get(0);
        return firstCol.getItems().size();
    }

    /**
     * Returns the row names
     *
     * @return list of names
     */
    public List<DvText> rowNames() {
        if(rows == null) {
            return Collections.EMPTY_LIST;
        }
        return fetchNames(rows);
    }

    private List<DvText> fetchNames(List<? extends Item> items) {
        for (Item item : items) {
            names.add(item.getName());
        }
        return names;
    }

    /**
     * Return the element at specified column and row
     *
     * @param column
     * @param row
     * @return Element found at (col, row)
     * @throws IllegalArgumentException if col <= 0 or col > columnCount
     *                                  or row <= 0 or row > rowCount
     */
    public Element elementAtCell(int column, int row) {
        if (row <= 0 || row > rowCount()) {
            throw new IllegalArgumentException("invalid row index: " + row);
        }
        Cluster targetRow = (Cluster) getRows().get(row - 1);
        if (column <= 0 || column > targetRow.getItems().size()) {
            throw new IllegalArgumentException("invalid column index: " + column);
        }
        return (Element) targetRow.getItems().get(column - 1);
    }

    /**
     * Retrieves a row by given name
     *
     * @param name
     * @return List of element
     * @throws IllegalArgumentException if name null or empty
     *                                  or no row found for given name
     */
    public Cluster namedRow(String name) {
        checkName(name);
        if(rows == null) {
            return null;
        }
        int index = indexOf(getRows(), name);
        if (index < 0) {
            throw new IllegalArgumentException("unknow row name: " + name);
        }
        return (Cluster)getRows().get(index);

    }

    /**
     * Retrieve the element at the row whose first column has the name
     * colKey and row has the name rowKey
     *
     * @param colKey
     * @param rowKey
     * @return Element found by keys
     * @throws IllegalArgumentException if either key null or empty
     *                                  or no row found for given keys
     */
    public Element elementAtNamedCell(String rowKey, String colKey) {
        if (colKey.isEmpty() ||
                rowKey.isEmpty()) {
            throw new IllegalArgumentException("invalid keys: "
                    + colKey + ", " + rowKey);
        }
        Cluster firstRow = namedRow(rowKey);
        int col = indexOf(firstRow.getItems(), colKey);
        if (col < 0 ) {
            throw new IllegalArgumentException(
                    "unknown keys: " + colKey + ", " + rowKey);
        }
        return (Element)firstRow.getItems().get(col);
    }

    /**
     * Boolean True if there is a column with given name
     *
     * @param name
     * @return true if has column with name
     * @throws IllegalArgumentException if name null or empty
     */
    public boolean hasColumnWithName(String name) {
        checkName(name);
        Cluster firstRow = (Cluster) getRows().get(0);
        if(rows == null) {
            return false;
        }
        return hasItemWithName(firstRow.getItems(), name);
    }

    /**
     * Returns the row at specified position
     *
     * @param index starts with 1
     * @return List of element
     * @throws IndexOutOfBoundsException
     */
    public Cluster ithRow(int index) {
        if (index <= 0 || index > rowCount()) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        return getRows().get(index - 1);
    }

    /**
     * Returns true if there is a row with given name
     *
     * @param name
     * @return ture if has row with name
     */
    public boolean hasRowWithName(String name) {
        checkName(name);
        if(rows == null) {
            return false;
        }
        return hasItemWithName(getRows(), name);
    }
    private boolean hasItemWithName(List items, String name) {
        return indexOf(items, name) >= 0;
    }

    // return index of element with given name
    private int indexOf(List items, String name) {
        for (int i = 0, j = items.size(); i < j; i++) {
            Item item = (Item) items.get(i);
            if (item.getName().getValue().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    private void checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("null or empty name");
        }
    }

    public void addItem(Cluster row) {
        this.rows.add(row);
        setThisAsParent(row, "rows");
    }

    /**
     * This is a bit of a strange one - returns all elements present in the table. Use getRows instead
     */
    @Override
    public List<Element> getItems() {
        if (rows == null) {
            return null;
        }
        List<Element> result = new ArrayList<>();
        for (Cluster row : rows) {
            for (Item element : row.getItems()) {
                result.add((Element) element);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemTable itemTable = (ItemTable) o;
        return Objects.equals(rows, itemTable.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rows);
    }
}
