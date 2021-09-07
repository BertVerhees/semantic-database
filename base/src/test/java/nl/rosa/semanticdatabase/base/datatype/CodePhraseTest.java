package nl.rosa.semanticdatabase.base.datatype;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CodePhraseTest {

    @Test
    public void testEquals() {
        CodePhrase codePhraseOne = new CodePhrase("hl7::gender");
        CodePhrase codePhraseTwo = new CodePhrase("hl7::gender");
        CodePhrase codePhraseThree = new CodePhrase("hl2::gender");
        CodePhrase codePhraseFour = new CodePhrase("hl7::color");
        assertAll(
                () -> assertEquals(codePhraseOne, codePhraseTwo),
                () -> assertNotEquals(codePhraseOne, codePhraseThree),
                () -> assertNotEquals(codePhraseOne, codePhraseFour),
                () -> assertEquals("gender",codePhraseOne.getCodeString()),
                () -> assertEquals("hl7",codePhraseOne.getTerminologyId())
        );
    }

    @Test
    public void testToString() {
        CodePhrase codePhraseOne = new CodePhrase();
        CodePhrase codePhraseTwo = new CodePhrase("hl7::gender");
        assertAll(
                () -> assertEquals("null::null", codePhraseOne.toString()),
                () -> assertEquals("hl7::gender", codePhraseTwo.toString())
         );
    }
}
