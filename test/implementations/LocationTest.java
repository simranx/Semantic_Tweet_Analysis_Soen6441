package implementations;

import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import services.TwitterService;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
/** 
 * LocationTest class contains the actions to test
 * tweets search based on locations.
 * @version 1.0
 * @author Mohit Saini
 */
public class LocationTest {
	/** 
	 * setUp() method runs before every test case.
	 * @version 1.0
	 * @author Mohit Saini
	 *
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "SAD";
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