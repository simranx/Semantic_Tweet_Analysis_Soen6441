package implementations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import services.TwitterService;
/** 
 * TweetDistictWordImplTestHappy class contains the actions to test
 * unique word for happy tweets.
 * @version 1.0
 * @author Harmeet Singh
 *
 */
public class TweetDistictWordImplTestHappy {
	/** 
	 * setUp() method runs before every test case.
	 * @version 1.0
	 * @author Harmeet Singh
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
	 * @author Harmeet Singh
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
	}
	/** 
	 * Test to check distinct word count.
	 * @version 1.0
	 * @author Harmeet Singh
	 *
	 */
    @Test
    public void getTweetDistinctWordCount() {
    	ArrayNode arrayNode = new TweetDistictWordImpl().getTweetDistinctWordCount("", 100);
    	assertTrue(arrayNode.size()>0);
    }
}