/*
 * ObjectVersionIDTest.java
 * JUnit based test
 *
 * Created on July 11, 2006, 3:05 PM
 */

package nl.rosa.semanticdatabase.base.identification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author yinsulim
 */
public class ObjectVersionIDTest {

    @Test
    public void testContructorTakeString() {
        String[][] ids = {
            {"1.4.4.5", "1.2.840.114.1.2.2::123", "1"},
            {"1.2.4.5", "7234-235-422-4-23::2", "2.0.0"},
            {"1.6.1.6", "openehr.org::0.99", "2.1.2"}
        };
        for(int i = 0; i < ids.length; i++) {
            ObjectVersionId ov = new ObjectVersionId(ids[i][0], ids[i][1], ids[i][2]);
            assertEquals((Uid)new IsoOID(ids[i][0]), ov.objectId());
            assertEquals(new HierObjectId(ids[i][1]), ov.creatingSystemId());
            assertEquals(new VersionTreeId(ids[i][2]), ov.versionTreeId());
        }
        String[][] ids2 = {
            {"1-4-4-5-12", "1.2.840.114.1.2.2", "1"},
            {"12-14-1-1-9", "7234-235-422-4-23::23", "2.0.0"},
            {"1123-1-4-5457-7", "openehr.org", "2.1.2"}
        };
        for(int i = 0; i < ids2.length; i++) {
            ObjectVersionId ov = new ObjectVersionId(ids2[i][0], ids2[i][1], ids2[i][2]);
            assertEquals((Uid)new UUid(ids2[i][0]), ov.objectId());
            assertEquals(new HierObjectId(ids2[i][1]), ov.creatingSystemId());
            assertEquals(new VersionTreeId(ids2[i][2]), ov.versionTreeId());
        }
        String[][] ids3 = {
            {"openehr", "1.2.840.114.1.2.2", "1"},
            {"openehrR1-0.org", "7234-235-422-4-23::23", "2.0.0"},
            //{"openehr.org.uk", "w123.55.155::ext1", "2.1.2"}
        };
        for(int i = 0; i < ids3.length; i++) {
            ObjectVersionId ov = new ObjectVersionId(ids3[i][0], ids3[i][1], ids3[i][2]);
            assertEquals((Uid)new InternetId(ids3[i][0]), ov.objectId());
            assertEquals(new HierObjectId(ids3[i][1]), ov.creatingSystemId());
            assertEquals(new VersionTreeId(ids3[i][2]), ov.versionTreeId());
        }
    }

    @Test
    public void testCreateWithValidUIDInHexFormat() {
    	String value = "939cec48-d629-4a3f-89f1-28c573387680::" +
    			"10aec661-5458-4ff6-8e63-c2265537196d::1";
    	try {
    		new ObjectVersionId(value);
    	} catch(Exception e) {
    		fail("exception raised by constructor: " + e.getMessage());
    	}
    }
    
}
