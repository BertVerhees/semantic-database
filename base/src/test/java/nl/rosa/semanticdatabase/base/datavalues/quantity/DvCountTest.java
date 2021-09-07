/*
 * component:   "openEHR Reference Implementation"
 * description: "Class DvCountTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/datatypes/quantity/DvCountTest.java $"
 * revision:    "$LastChangedRevision: 2 $"
 * last_change: "$LastChangedDate: 2005-10-12 23:20:08 +0200 (Wed, 12 Oct 2005) $"
 */
/**
 * CountTest
 *
 * @author Rong Chen
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DvCountTest{

    @Test
    public void testAdd() throws Exception {
        DvCount c1 = new DvCount(3L);
        DvCount c2 = new DvCount(5L);
        DvCount expected = new DvCount(8L);
        assertEquals(expected.getMagnitude(), c1.getMagnitude() + c2.getMagnitude());
    }

    @Test
    public void testSubtract() throws Exception {
        DvCount c1 = new DvCount(3L);
        DvCount c2 = new DvCount(5L);
        DvCount expected = new DvCount(2L);
        assertEquals(expected.getMagnitude(), c2.getMagnitude() - c1.getMagnitude());
    }

    @Test
    public void testCompareTo() throws Exception {
        DvCount c1 = new DvCount(3L);
        DvCount c2 = new DvCount(5L);
        DvCount c3 = new DvCount(3L);

        assertTrue(c1.getMagnitude() - c2.getMagnitude() < 0);
        assertTrue(c2.getMagnitude() - c1.getMagnitude() > 0);
        assertTrue(c3.getMagnitude() - c1.getMagnitude() == 0);
        assertTrue(c1.getMagnitude() - c3.getMagnitude() == 0);
    }

    @Test
    public void testGetOtherReferenceRanges() throws Exception {
    	Map<String, Object> values = new HashMap<String, Object>();
        DvText normal = new DvText("normal");
        DvCount lower = new DvCount(1L);
        DvCount upper = new DvCount(10L);
        ReferenceRange<DvCount> normalRange = new ReferenceRange<>(normal, new DvInterval<>(lower, upper));
        List<ReferenceRange<DvCount>> otherReferenceRanges = new ArrayList<>();
        otherReferenceRanges.add(normalRange);
        
        DvCount count = new DvCount(
                otherReferenceRanges,
                null,
                null,
                null,
                0.0,
        		false,
                null,
                5L);
        
        assertEquals(otherReferenceRanges, count.getOtherReferenceRanges());
    }
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
 *  The Original Code is DvCountTest.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2004
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