package nl.rosa.semanticdatabase.base.datavalues.text;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class DvCodedTextTest {

    @Test
    public void testEquals() {
        DvCodedText dvCodedTextOne = new DvCodedText("some text", new CodePhrase("icd10::123"));
        DvCodedText dvCodedTextTwo = new DvCodedText("some text", new CodePhrase("icd10::123"));
        DvCodedText dvCodedTextThree = new DvCodedText("some text", new CodePhrase("icd10::234"));

        assertAll(
                "testEquals",
                () -> assertEquals(dvCodedTextOne, dvCodedTextTwo),
                () -> assertNotEquals(dvCodedTextOne, dvCodedTextThree),
                () -> assertEquals("some text",dvCodedTextOne.getValue()),
                () -> assertEquals("icd10",dvCodedTextOne.getDefiningCode().getTerminologyId().getValue()),
                () -> assertEquals("123",dvCodedTextOne.getDefiningCode().getCodeString())
        );
    }

    @Test
    public void testToString() {
        DvCodedText dvCodedTextOne = new DvCodedText();
        DvCodedText dvCodedTextTwo = new DvCodedText("some text", new CodePhrase("icd10:123"));

        assertAll(
                "testToString",
                () -> assertEquals("DvCodedText{defining_code=null, value=null}", dvCodedTextOne.toString()),
                () -> assertEquals("DvCodedText{defining_code=UNKNOWN::icd10:123, value=some text}", dvCodedTextTwo.toString())
        );
    }
}
