/*
 * component:   "openEHR Reference Implementation"
 * description: "Class VersionTreeID"
 * keywords:    "unit test"
 *
 * author:      "Yin Su Lim <y.lim@chime.ucl.ac.uk>"
 * support:     "CHIME, UCL"
 * copyright:   "Copyright (c) 2006 UCL, UK"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/RM-1.0-update/libraries/src/test/org/openehr/rm/suppport/identification/VersionTreeID.java $"
 * revision:    "$LastChangedRevision: 50 $"
 * last_change: "$LastChangedDate: 2006-08-10 12:21:46 +0100 (Thu, 10 Aug 2006) $"
 */

/**
 * VersionTreeID
 *
 * @author Yin Su Lim
 * @version 1.0 
 */
package nl.rosa.semanticdatabase.base.identification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VersionTreeIDTest {

    @Test
    public void testConstructors() throws Exception {
        String[] values = {
            "1.1.2", "2", "1.3.24", "10", "3.0.0"
        };
        int[][] intS = {
            {1, 1, 2},
            {2, 0, 0},
            {1, 3, 24},
            {10, 0, 0},
            {3, 0, 0}
        };
        boolean[] isB = {
            true, false, true, false, false
        };
                
        for(int i = 0 ; i < values.length; i++) {
            VersionTreeId v1 = toVersionTreeID(values[i]);
            VersionTreeId v2 = toVersionTreeID(intS[i][0], intS[i][1], intS[i][2]);
            assertEquals(v1, v2);
            String bN = intS[i][1] == 0 ? null: Integer.toString(intS[i][1]);
            String bV = intS[i][2] == 0 ? null: Integer.toString(intS[i][2]);
            assertEquals( Integer.toString(intS[i][0]), v2.trunkVersion());
            assertEquals( bN, v2.branchNumber());
            assertEquals( bV, v2.branchVersion());
            assertEquals( isB[i], v2.isBranch());
        }
        
    }

    @Test
    public void testConstructorsFail() throws Exception {
        String[] values = {
            "1.0.2", "0", "0.3.24", "1.1.0", "0.0.0", "1.1"
        };
        int[][] intS = {
            {0, 1, 2},
            {0, 0, 0},
            {1, 3, 0},
            {10, 0, 1}, 
            {-1, 3, 2}, 
            {1, -2, 2}
        };
        for(int i = 0; i < values.length; i++) {
            assertNull(toVersionTreeID(values[i]));
        }
        for(int i = 0; i < intS.length; i++) {
            assertNull(toVersionTreeID(intS[i][0], intS[i][1], intS[i][2]));
        }
    }
    
    private VersionTreeId toVersionTreeID(String value) {
        VersionTreeId v = null;
        try {
            v = new VersionTreeId(value);
        } catch (IllegalArgumentException iae) {            
        }
        return v;
    }
    
    private VersionTreeId toVersionTreeID(int t, int bN, int bV) {
        VersionTreeId v = null;
        try {
            v = new VersionTreeId(t, bN, bV);
        } catch (IllegalArgumentException iae) {
        }
        return v;
    }

    @Test
    public void testIsFirst() {
        
        String[] values = {"1", "1.0.0", "1.1.1", "2"};
        boolean[] iF = {true, true, false, false};
        for(int i  = 0; i < values.length; i++) {
            assertEquals(iF[i], new VersionTreeId(values[i]).isFirst());
        }
         
    }

    @Test
    public void testNext() {
        String[] values = {"1", "1.0.0", "1.1.1", "2"};
        String[] nextV = {"2", "2", "1.1.2", "3"};
        for(int i  = 0; i < values.length; i++) {
            assertEquals(new VersionTreeId(nextV[i]), new VersionTreeId(values[i]).next());
        }
    }

    @Test
    public void testToString() {
        int[][] intS = {
            {1, 2, 3},
            {1, 0, 0},
            {1, 3, 1},
        };
        String[] values = {
            "1.2.3", "1", "1.3.1"
        };
        for(int i  = 0; i < values.length; i++) {
            assertEquals(values[i], toVersionTreeID(intS[i][0], intS[i][1], intS[i][2]).toString());
        }
        String[] tValues = {
            "1.4.2", "1", "1.0.0", "2.0.0"
        };
        String[] eValues = {
            "1.4.2", "1", "1", "2"
        };
        for(int i  = 0; i < values.length; i++) {
            assertEquals(eValues[i], toVersionTreeID(tValues[i]).toString());
        }
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
 *  The Original Code is VersionTreeID.java
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