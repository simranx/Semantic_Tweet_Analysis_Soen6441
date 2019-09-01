package implementations;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import services.TwitterService;
/** 
 * TweetEmotionImplTestNeutral class contains the actions to test
 * for neutral tweets.
 * @version 1.0
 * @author Akshay Bansal
 *
 */
public class TweetEmotionImplTestNeutral {
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
	 * Test to check if emotion in tweet is neutral.
	 * @version 1.0
	 * @author Akshay Bansal
	 *
	 */

    @Test
    public void getTweetEmotion() {
    	String s = new TweetEmotionImpl().getTweetEmotion("", 100);
    	assertEquals("😐", s);
    }
}
