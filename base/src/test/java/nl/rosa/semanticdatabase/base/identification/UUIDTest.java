/*
 * UUIDTest.java
 * JUnit based test
 *
 * Created on July 10, 2006, 4:27 PM
 */

package nl.rosa.semanticdatabase.base.identification;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yinsulim
 */
public class UUIDTest {
    @Test
    public void testConstructorTakeString() {
        assertNotNull(new UUid("128-1-1-12-15"));
    }

    @Test
    public void testConstructorTakeStringTooLarge() {
        try {
            UUid uuid = new UUid("128-1-1-12-15128-1-1-12-15128-1-1-12-15");
            fail();
        }catch(Exception ignored) {

        }
    }
}
