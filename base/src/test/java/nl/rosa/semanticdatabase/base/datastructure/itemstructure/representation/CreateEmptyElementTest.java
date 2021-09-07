package nl.rosa.semanticdatabase.base.datastructure.itemstructure.representation;

import junit.framework.TestCase;
import nl.rosa.semanticdatabase.base.datastructures.Element;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.base.terminology.TestCodeSetAccess;
import nl.rosa.semanticdatabase.base.terminology.TestTerminologyService;

public class CreateEmptyElementTest extends TestCase {

	public void testCreateElement() {
		TerminologyService ts = TestTerminologyService.getInstance();
		DvCodedText nullFlavor = new DvCodedText("no information",
				TestCodeSetAccess.NULL_FLAVOUR);
		
		new Element(null, "at0001", new DvText("name"), null, null, null, null,
				null, nullFlavor, ts);
    }	
}
