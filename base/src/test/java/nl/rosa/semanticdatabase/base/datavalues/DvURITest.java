package nl.rosa.semanticdatabase.base.datavalues;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DvURITest {

    @Test
    public void testEquals() {
        DvURI dvURIOne = new DvURI("http://specifications.openehr.org/");
        DvURI dvURITwo = new DvURI("http://specifications.openehr.org/");
        DvURI dvURIThree = new DvURI("http://specifications.openehr.de/");

        assertAll(
                () -> assertEquals(dvURIOne, dvURITwo),
                () -> assertNotEquals(dvURIOne, dvURIThree)
         );
    }
}