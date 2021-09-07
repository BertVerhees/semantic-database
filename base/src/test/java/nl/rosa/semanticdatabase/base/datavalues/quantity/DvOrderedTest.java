/*
 * component:   "openEHR Reference Implementation"
 * description: "Class DvQuantityTest"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2007 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL$"
 * revision:    "$LastChangedRevision$"
 * last_change: "$LastChangedDate$"
 */
package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.terminology.TestTerminologyService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DvOrderedTest {
	@Test
	public void testIsNormalWithoutNormalStatusAndNormalRange() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = null;
		CodePhrase normalStatus = null;
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count = 
			new DvCount(
					referenceRanges,
					normalRange,
					normalStatus,
					null,
					accuracy,
					accuracyPercent,
					magnitudeStatus,
					magnitude);
		try {
			count.isNormal();
			fail("exception should be thrown");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
	}

	@Test
	public void testIsNormalWithNormalStatus() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = null;
		CodePhrase normalStatus = new CodePhrase("normal statuses", "N");
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertTrue(count.isNormal());
	}

	@Test
	public void testIsNormalWithAbnormalStatus() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = null;
		CodePhrase normalStatus = new CodePhrase("normal statuses", "L");
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertFalse(count.isNormal());
	}

	@Test
	public void testIsNormalWithNormalRange() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = new DvInterval<DvCount>(
				new DvCount(0L), new DvCount(2L));
		CodePhrase normalStatus = null;
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						null,
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertTrue(count.isNormal());
	}

	@Test
	public void testIsNormalWithNoneInclusiveNormalRange() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = new DvInterval<>(
				new DvCount(2L), new DvCount(4L));
		CodePhrase normalStatus = null;
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						null,
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertFalse(count.isNormal());
	}

	@Test
	public void testIsNormalWithNormalStatusAndNormalRange() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = new DvInterval<DvCount>(
				new DvCount(0L), new DvCount(2L));
		CodePhrase normalStatus = new CodePhrase("normal statuses", "N");
		double accuracy = 0;
		boolean accuracyPercent = false; 
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertTrue(count.isNormal());
	}

    @Test
    void isSimple() {
		List<ReferenceRange<DvCount>> referenceRanges = null;
		DvInterval<DvCount> normalRange = new DvInterval<DvCount>(
				new DvCount(0L), new DvCount(2L));
		CodePhrase normalStatus = new CodePhrase("normal statuses", "N");
		double accuracy = 0;
		boolean accuracyPercent = false;
		String magnitudeStatus = null;
		Long magnitude = 1L;
		DvCount count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);

		assertFalse(count.isSimple());

		referenceRanges = new ArrayList<>();
		ReferenceRange<DvCount> referenceRange = new ReferenceRange<>(null,new DvInterval<DvCount>(
				new DvCount(0L), new DvCount(2L)));
		referenceRanges.add(referenceRange);
		normalRange = null;
		normalStatus = null;
		accuracy = 0;
		accuracyPercent = false;
		magnitudeStatus = null;
		magnitude = 1L;
		count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);
		assertFalse(count.isSimple());

		referenceRanges = null;
		normalRange = null;
		normalStatus = null;
		accuracy = 0;
		accuracyPercent = false;
		magnitudeStatus = null;
		magnitude = 1L;
		count =
				new DvCount(
						referenceRanges,
						normalRange,
						normalStatus,
						new TestTerminologyService(),
						accuracy,
						accuracyPercent,
						magnitudeStatus,
						magnitude);

		assertTrue(count.isSimple());

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
 *  The Original Code is DvQuantityTest.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2007
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s): Sergio Miranda Freire
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */