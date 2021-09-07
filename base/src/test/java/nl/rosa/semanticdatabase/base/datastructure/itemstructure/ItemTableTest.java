/*
 * component:   "openEHR Reference Implementation"
 * description: "Class ItemTableTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/datastructure/itemstructure/ItemTableTest.java $"
 * revision:    "$LastChangedRevision: 50 $"
 * last_change: "$LastChangedDate: 2006-08-10 13:21:46 +0200 (Thu, 10 Aug 2006) $"
 */
/**
 * ItemTableTest
 *
 * @author Rong Chen
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.datastructure.itemstructure;

import nl.rosa.semanticdatabase.base.datastructure.DataStructureTestBase;
import nl.rosa.semanticdatabase.base.datastructures.Cluster;
import nl.rosa.semanticdatabase.base.datastructures.Element;
import nl.rosa.semanticdatabase.base.datastructures.Item;
import nl.rosa.semanticdatabase.base.datastructures.ItemTable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvProportion;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ProportionKind;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTableTest extends DataStructureTestBase {

    /**
     * The fixture set up called before every test method.
     */
    @BeforeEach
    protected void setUp() throws Exception {
    	createTable();       
    }

    private void createTable() throws Exception {
    	rows = new ArrayList<Cluster>();
    	
    	// 1st row
    	Element eyes = new Element("at0001", new DvText("eye(s)"),
    			new DvText("right"));
    	Element acuity = new Element("at0002", new DvText("visual acuity"),
    			new DvProportion(6, 6, ProportionKind.RATIO, 0L));
    	List<Item> items = new ArrayList<Item>();
    	items.add(eyes);
    	items.add(acuity);
    	rows.add(new Cluster("at0003", new DvText("1"), items));
    	
    	// 2nd row
    	eyes = new Element("at0004", new DvText("eye(s)"),
     			new DvText("left"));
     	acuity = new Element("at0005", new DvText("visual acuity"),
     			new DvProportion(6, 18, ProportionKind.RATIO, 0L));
     	items = new ArrayList<Item>();
     	items.add(eyes);
     	items.add(acuity);
     	rows.add(new Cluster("at0006", new DvText("2"), items));
    	
     	// 3rd row
     	eyes = new Element("at0007", new DvText("eye(s)"),
     			new DvText("both"));
     	acuity = new Element("at0008", new DvText("visual acuity"),
     			new DvProportion(6, 6, ProportionKind.RATIO, 0L));
     	items = new ArrayList<Item>();
     	items.add(eyes);
     	items.add(acuity);
     	rows.add(new Cluster("at0009", new DvText("3"), items));    	
    	
        itemTable = new ItemTable("at0010", new DvText("vision"), rows);
    }

    /**
     * The fixture clean up called after every test method.
     */
    @AfterEach
    protected void tearDown() throws Exception {
        itemTable = null;
    }

    @Test
    public void testColumnCount() {
        assertEquals(2, itemTable.columnCount());
    }

    @Test
    public void testRowCount() throws Exception {
        assertEquals( 3, itemTable.rowCount());
    }

    @Test
    public void testRowNames() throws Exception {
        List<DvText> names = new ArrayList<DvText>();
        names.add(new DvText("1"));
        names.add(new DvText("2"));
        names.add(new DvText("3"));
        assertEquals(names, itemTable.rowNames());
    }

    @Test
    public void testIthRow1() throws Exception {
        assertEquals(rows.get(0), itemTable.ithRow(1));
    }

    @Test
    public void testIthRow2() throws Exception {
        assertEquals(rows.get(1), itemTable.ithRow(2));
    }

    @Test
    public void testIthRow3() throws Exception {
        assertEquals(rows.get(2), itemTable.ithRow(3));
    }

    @Test
    public void testHasRowWithNameOne() throws Exception {
        assertTrue(itemTable.hasRowWithName("1"));        
    }

    @Test
    public void testHasRowWithNameTwo() throws Exception {
        assertTrue(itemTable.hasRowWithName("2"));        
    }

    @Test
    public void testHasRowWithNameThree() throws Exception {
        assertTrue(itemTable.hasRowWithName("3"));        
    }

    @Test
    public void testHasRowWithNameUnkown() throws Exception {
        assertFalse(itemTable.hasRowWithName("unknown"));        
    }

    @Test
    public void testHasColumnWithNameEyes() throws Exception {
        assertTrue(itemTable.hasColumnWithName("eye(s)"));
    }

    @Test
    public void testHasColumnWithNameAcuity() throws Exception {
        assertTrue(itemTable.hasColumnWithName("visual acuity"));
    }

    @Test
    public void testElementAtColumn1Row1() throws Exception {
    	Element element = itemTable.elementAtCell(1, 1);
    	assertEquals("at0001", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtColumn2Row1() throws Exception {
    	Element element = itemTable.elementAtCell(2, 1);
    	assertEquals("at0002", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtColumn1Row2() throws Exception {
    	Element element = itemTable.elementAtCell(1, 2);
    	assertEquals("at0004", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtColumn2Row2() throws Exception {
    	Element element = itemTable.elementAtCell(2, 2);
    	assertEquals("at0005", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtColumn1Row3() throws Exception {
    	Element element = itemTable.elementAtCell(1, 3);
    	assertEquals("at0007", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtColumn2Row3() throws Exception {
    	Element element = itemTable.elementAtCell(2, 3);
    	assertEquals("at0008", element.getArchetypeNodeId());
    }

    @Test
    public void testNamedRow1() throws Exception {
        assertEquals(rows.get(0), itemTable.namedRow("1"));
    }

    @Test
    public void testNamedRow2() throws Exception {
        assertEquals(rows.get(1), itemTable.namedRow("2"));
    }

    @Test
    public void testNamedRow3() throws Exception {
        assertEquals(rows.get(2), itemTable.namedRow("3"));
    }

    @Test
    public void testElementAtNamedCellOneEyes() throws Exception {
    	element = itemTable.elementAtNamedCell("1", "eye(s)");
        assertEquals("at0001", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtNamedCellOneAcuity() throws Exception {
    	element = itemTable.elementAtNamedCell("1", "visual acuity");
        assertEquals("at0002", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtNamedCellTwoEyes() throws Exception {
    	element = itemTable.elementAtNamedCell("2", "eye(s)");
        assertEquals("at0004", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtNamedCellTwoAcuity() throws Exception {
    	element = itemTable.elementAtNamedCell("2", "visual acuity");
        assertEquals("at0005", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtNamedCellThreeEyes() throws Exception {
    	element = itemTable.elementAtNamedCell("3", "eye(s)");
        assertEquals("at0007", element.getArchetypeNodeId());
    }

    @Test
    public void testElementAtNamedCellThreeAcuity() throws Exception {
    	element = itemTable.elementAtNamedCell("3", "visual acuity");
        assertEquals("at0008", element.getArchetypeNodeId());
    }

    @Test
    public void testItemAtPathWhole() throws Exception {
        assertEquals(itemTable, itemTable.itemAtPath("/"));
    }

    @Test
    public void testItemAtPathRow1() throws Exception {
        assertEquals(rows.get(0), itemTable.itemAtPath("/rows[at0003]"));
    }

    @Test
    public void testItemAtPathRow1Column1() throws Exception {
        assertEquals(rows.get(0).getItems().get(0), 
        		itemTable.itemAtPath("/rows[at0003]/items[at0001]"));
    }

    @Test
    public void testItemAtPathRow1Column2() throws Exception {
        assertEquals(rows.get(0).getItems().get(1), 
        		itemTable.itemAtPath("/rows[at0003]/items[at0002]"));
    }

    @Test
    public void testItemAtPathRow2() throws Exception {
        assertEquals(rows.get(1), 
        		itemTable.itemAtPath("/rows[at0006]"));
    }

    @Test
    public void testItemAtPathRow2Column1() throws Exception {
        assertEquals(rows.get(1).getItems().get(0), 
        		itemTable.itemAtPath("/rows[at0006]/items[at0004]"));
    }

    @Test
    public void testItemAtPathRow2Column2() throws Exception {
        assertEquals(rows.get(1).getItems().get(1), 
        		itemTable.itemAtPath("/rows[at0006]/items[at0005]"));
    }

    @Test
    public void testItemAtPathRow3() throws Exception {
        assertEquals(rows.get(2), 
        		itemTable.itemAtPath("/rows[at0009]"));
    }

    @Test
    public void testItemAtPathRow3Column1() throws Exception {
        assertEquals(rows.get(2).getItems().get(0), 
        		itemTable.itemAtPath("/rows[at0009]/items[at0007]"));
    }

    @Test
    public void testItemAtPathRow3Column2() throws Exception {
        assertEquals(rows.get(2).getItems().get(1), 
        		itemTable.itemAtPath("/rows[at0009]/items[at0008]"));
    }

    @Test
    public void testItemAtPathRow1Name() throws Exception {
        assertEquals(rows.get(0), itemTable.itemAtPath("/rows['1']"));
    }

    @Test
    public void testItemAtPathRow1Column1Name() throws Exception {
        assertEquals(rows.get(0).getItems().get(0), 
        		itemTable.itemAtPath("/rows['1']/items['eye(s)']"));
    }

    @Test
    public void testItemAtPathRow1Column2Name() throws Exception {
        assertEquals(rows.get(0).getItems().get(1), 
        		itemTable.itemAtPath("/rows['1']/items['visual acuity']"));
    }

    @Test
    public void testItemAtPathRow2Name() throws Exception {
        assertEquals(rows.get(1), 
        		itemTable.itemAtPath("/rows['2']"));
    }

    @Test
    public void testItemAtPathRow2Column1Name() throws Exception {
        assertEquals(rows.get(1).getItems().get(0), 
        		itemTable.itemAtPath("/rows['2']/items['eye(s)']"));
    }

    @Test
    public void testItemAtPathRow2Column2Name() throws Exception {
        assertEquals(rows.get(1).getItems().get(1), 
        		itemTable.itemAtPath("/rows['2']/items['visual acuity']"));
    }

    @Test
    public void testItemAtPathRow3Name() throws Exception {
        assertEquals(rows.get(2), 
        		itemTable.itemAtPath("/rows['3']"));
    }

    @Test
    public void testItemAtPathRow3Column1Name() throws Exception {
        assertEquals(rows.get(2).getItems().get(0), 
        		itemTable.itemAtPath("/rows['3']/items['eye(s)']"));
    }

    @Test
    public void testItemAtPathRow3Column2Name() throws Exception {
        assertEquals(rows.get(2).getItems().get(1), 
        		itemTable.itemAtPath("/rows['3']/items['visual acuity']"));
    }

    @Test
	public void testEquals() {
		List<Cluster> rows = new ArrayList<Cluster>();

		// 1st row
		Element eyes = new Element("at0001", new DvText("eye(s)"), new DvText(
				"right"));
		Element acuity = new Element("at0002", new DvText("visual acuity"),
				new DvProportion(6, 6, ProportionKind.RATIO, 0L));
		List<Item> itemsOne = new ArrayList<>();
		itemsOne.add(eyes);
		itemsOne.add(acuity);

		// 2nd row
		eyes = new Element("at0004", new DvText("eye(s)"), new DvText("left"));
		acuity = new Element("at0005", new DvText("visual acuity"),
				new DvProportion(6, 18, ProportionKind.RATIO, 0L));
		List<Item> itemsTwo = new ArrayList<>();
		itemsTwo.add(eyes);
		itemsTwo.add(acuity);

		rows.add(new Cluster("at0003", new DvText("1"), itemsOne));
		rows.add(new Cluster("at0006", new DvText("2"), itemsTwo));

		ItemTable itemTableOne = new ItemTable("at0010", new DvText("vision"),
				rows);
		ItemTable itemTableTwo = new ItemTable("at0010", new DvText("vision"),
				rows);

		assertTrue(itemTableOne.equals(itemTableTwo));
	}

    @Test
	public void testNotEqualsDifferentNodeId() {
		List<Cluster> rows = new ArrayList<Cluster>();

		// 1st row
		Element eyes = new Element("at0001", new DvText("eye(s)"), new DvText(
				"right"));
		Element acuity = new Element("at0002", new DvText("visual acuity"),
				new DvProportion(6, 6, ProportionKind.RATIO, 0L));
		List<Item> itemsOne = new ArrayList<Item>();
		itemsOne.add(eyes);
		itemsOne.add(acuity);

		// 2nd row
		eyes = new Element("at0004", new DvText("eye(s)"), new DvText("left"));
		acuity = new Element("at0005", new DvText("visual acuity"),
				new DvProportion(6, 18, ProportionKind.RATIO, 0L));
		List<Item> itemsTwo = new ArrayList<Item>();
		itemsTwo.add(eyes);
		itemsTwo.add(acuity);

		rows.add(new Cluster("at0003", new DvText("1"), itemsOne));
		rows.add(new Cluster("at0006", new DvText("2"), itemsTwo));

		ItemTable itemTableOne = new ItemTable("at0010", new DvText("vision"),
				rows);
		ItemTable itemTableTwo = new ItemTable("at0011", new DvText("vision"),
				rows);

		assertFalse(itemTableOne.equals(itemTableTwo));
	}
    
    /* field */
    private List<Cluster> rows;
    private ItemTable itemTable;
    private Element element;
}
/*
 *  ***** BEGIN LICENSE BLOCK *****
 *  Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 *  The contents of this file are subject to the Mozilla Public License Version
 *  1.1 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.mozilla.org/MPL/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  The Original Code is ItemTableTest.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2008
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s):
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */