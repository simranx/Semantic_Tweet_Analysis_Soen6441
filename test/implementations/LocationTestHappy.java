package implementations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import services.TwitterService;
/** 
 * LocationTestHappy class contains the actions to test
 * happy tweets emotion based on location.
 * @version 1.0
 * @author Mohit Saini
 *
 */
public class LocationTestHappy {
	/** 
	 * setUp() method runs before every test case.
	 * @version 1.0
	 * @authorMohit Saini
	 *
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "HAPPY";
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
