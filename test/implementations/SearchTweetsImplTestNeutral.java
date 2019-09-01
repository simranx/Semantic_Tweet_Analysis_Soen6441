package implementations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import services.TwitterService;
/** 
 * SearchTweetsImplTestNeutral class contains the actions to test
 * neutral tweets emotion based on search.
 * @version 1.0
 * @author Akshay Bansal
 *
 */
public class SearchTweetsImplTestNeutral {
	/** 
	 * setUp() method runs before every test case.
	 * @version 1.0
	 * @author Akshay Bansal
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
	 * @author Akshay Bansal
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
	}
	/** 
	 * Test to check twitter search results.
	 * @version 1.0
	 * @author Akshay Bansal
	 *
	 */
    @Test
    public void getTweetsAsync() {
    	ArrayNode arrayNode = new SearchTweetsImpl().getTweetsAsync("", 10);
    	assertTrue(arrayNode.size()>0);
    }
}
