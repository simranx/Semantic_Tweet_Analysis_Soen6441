package controllers;

import static org.junit.Assert.*;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;
/**
 * Tests the functionality of SearchTweetWordControllerHappy
 * @author Anam Dang
 * @version 1.0
 */
public class SearchTweetWordControllerTestHappy {
	/**
	 * Initializes objects needed for tests before each unit test 
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "HAPPY";
	}
	/**
	 * Tear down system after all tests
	 */
	@AfterClass
	public static void tearDown() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
	}
	/**
	 * Test creation of tweet search by distinct word count for happy emotions
	 * @throws TwitterException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
    @Test
    public void searchTweetDistinctWordCount() throws TwitterException, InterruptedException, ExecutionException {
	   CompletionStage<Result> result = new SearchTweetWordController().searchTweetDistinctWordCount("");
	    Result r = result.toCompletableFuture().get();
	    assertNotNull(r);
    }

}
