package implementations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import services.TwitterService;
/** 
 * LocationTestNeutral class contains the actions to test
 * neutral tweets emotion based on location.
 * @version 1.0
 * @author Mohit Saini
 *
 */
public class LocationTestNeutral {
	/** 
	 * setUp() method runs before every test case.
	 * @version 1.0
	 * @author Mohit Saini
	 *
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "NEUTRAL";
	}
	/** 
	 * tearDown() method runs at the end of the test case.
	 * @version 1.0
	 * @author Mohit Saini
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
	}
	/** 
	 * Test to check twitter search results based on location.
	 * @version 1.0
	 * @author Mohit Saini
	 *
	 */
    @Test
    public void getTweetsByLocationAsync() {
    	ArrayNode arrayNode = new Location().getTweetsByLocationAsync(45.5088400, -73.5878100, 10);
    	assertTrue(arrayNode.size()>0);
    }
}
