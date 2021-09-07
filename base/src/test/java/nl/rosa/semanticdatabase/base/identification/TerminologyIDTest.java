/*
 * component:   "openEHR Reference Implementation"
 * description: "Class TerminologyIDTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/support/identification/TerminologyIDTest.java $"
 * revision:    "$LastChangedRevision: 2 $"
 * last_change: "$LastChangedDate: 2005-10-12 23:20:08 +0200 (Wed, 12 Oct 2005) $"
 */
/**
 * TerminologyIDTest
 *
 * @author Rong Chen
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.identification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerminologyIDTest {

    @Test
    public void testConstructorTakesStringValue() throws Exception {
        for(int i = 0; i < STRING_VALUE.length; i++) {
            assertTID(new TerminologyId(STRING_VALUE[i]), i);
        }
    }

    @Test
    public void testConstructorTakesNameVersion() throws Exception {
        for(int i = 0; i < STRING_VALUE.length; i++) {
            assertTID(new TerminologyId(SECTIONS[i][0], SECTIONS[i][1]), i);
        }
    }

    @Test
    public void testEquals() {
    	TerminologyId id1 = new TerminologyId("ICD9", "1999");
    	TerminologyId id2 = new TerminologyId("ICD9", "1999");
    	assertTrue(id1.equals(id2));
    	assertTrue(id2.equals(id1));
    }

    private void assertTID(TerminologyId tid, int i) {
        assertEquals(STRING_VALUE[i], tid.getValue());
        assertEquals(SECTIONS[i][0], tid.name());
        assertEquals(SECTIONS[i][1], tid.versionID());
    }

    private static final String[] STRING_VALUE = {
        "snomed-ct",  "ICD9(1999)"
    };

    private static final String[][] SECTIONS = {
        {"snomed-ct", null},
        {"ICD9", "1999"}
    };

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
 *  The Original Code is TerminologyIDTest.java
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