package nl.rosa.semanticdatabase.base.datavalues.encapsulated;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DvURI;
import nl.rosa.semanticdatabase.base.identification.TerminologyId;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.base.terminology.TestTerminologyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DvMultimediaTest {
	@Test
	public void testCreateSimpleDvMultimedia() throws Exception {
		CodePhrase charset = new CodePhrase(new TerminologyId("IANA_character-sets"), "UTF-8");
		CodePhrase language = new CodePhrase(new TerminologyId("ISO_3166-1"),"eN");
		String alternateText = "alternative text";
        CodePhrase mediaType = new CodePhrase(new TerminologyId("IANA_media-types"), "text/plain");
        CodePhrase compressionAlgorithm = new CodePhrase(new TerminologyId("openehr_compression_algorithms"), "others");
        byte[] integrityCheck = new byte[0];
        CodePhrase integrityCheckAlgorithm = new CodePhrase(new TerminologyId("openehr_integrity_check_algorithms"), "SHA-1");
        DvMultimedia thumbnail = null;
		DvURI uri = new DvURI("www.iana.org");
        byte[] data = new byte[0];
        TerminologyService terminologyService = new TestTerminologyService();
		DvMultimedia dm = new DvMultimedia(charset, language, alternateText,
				mediaType, compressionAlgorithm, integrityCheck, 
				integrityCheckAlgorithm, thumbnail, uri, data, terminologyService);
		
		assertNotNull(dm);		
	}
}
