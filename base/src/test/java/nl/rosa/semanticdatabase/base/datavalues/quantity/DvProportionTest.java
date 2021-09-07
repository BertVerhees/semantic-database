/*
 * component:   "openEHR Reference Implementation"
 * description: "Class DvProportionTest"
 * keywords:    "datatypes"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * copyright:   "Copyright (c) 2007 Cambio Healthcare Systems, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL$"
 * revision:    "$LastChangedRevision$"
 * last_change: "$LastChangedDate$"
 */
package nl.rosa.semanticdatabase.base.datavalues.quantity;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class DvProportionTest extends TestCase {

	@Test
	public void testIsIntegeralWithFraction() {
		DvProportion p = new DvProportion(1, 2, ProportionKind.FRACTION, 0L);
		assertTrue(p.isIntegral());
	}

	@Test
	public void testIsIntegeralWithPercent() {
		DvProportion p = new DvProportion(1.2, 100, ProportionKind.PERCENT, 1L);
		assertFalse(p.isIntegral());
	}

	@Test
	public void testCreateFractionProportionWithNonZeroPrecision() {
		try {
			new DvProportion(1, 10, ProportionKind.FRACTION, 1L);
			fail("Should fail to create integral fraction with non-zero precision");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreateProportionWithZeroPrecisionAndNonIntegral() {
		try {
			new DvProportion(1.3, 10, ProportionKind.RATIO, 0L);
			fail("Should fail to create non-integral with zero precision");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreateIntegralProportionWithNonIntegralNumer() {
		try {
			new DvProportion(1.3, 10, ProportionKind.FRACTION, 0L);
			fail("should fail to create integral with non-integral num");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}		
	}

	@Test
	public void testCreateUnitaryProportionWithBadDenominator() {
		try {
			new DvProportion(1.3, 2, ProportionKind.UNITARY, 1L);
			fail("should fail to create unitary with bad denominator");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreateUnitaryProportionWithRightDenominator() {
		new DvProportion(1.3, 1, ProportionKind.UNITARY, 1L);
	}

	@Test
	public void testCreateIngegerProportionWithoutPricision() {
		try {
			new DvProportion(1.0, 1.0, ProportionKind.RATIO, null);
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreateDoubleProportionWithoutPricision() {
		try {
			new DvProportion(0.5, 1.0, ProportionKind.RATIO, null);
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreatePercentProportionWithBadDenominator() {
		try {
			new DvProportion(1.25, 10, ProportionKind.PERCENT, 2L);
			fail("should fail to create percent with bad denominator");
		} catch(Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCreatePercentProportionWithRightDenominator() {
		new DvProportion(1.25, 100, ProportionKind.PERCENT, 2L);
	}

	@Test
	public void testCreateUnitaryProportionUsingFactoryMethod() {
		DvProportion dp = DvProportion.createUnitaryProportion(1.2, 1L);
		assertEquals(1.2, dp.getNumerator(), 0);
	}

    @Test
    void isStrictlyComparableTo() {
    }

    @Test
    void lessThan() {
    }

    @Test
    void add() {
    }

    @Test
    void subtract() {
    }

    @Test
    void createUnitaryProportion() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void compareTo() {
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
 *  The Original Code is DvProportionTest.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2007
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
