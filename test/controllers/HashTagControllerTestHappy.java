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
 * Tests the functionality of HashTagControllerHappy
 * @author Akshay Bansal
 * @version 1.0
 */
public class HashTagControllerTestHappy {
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
	 * Test creation of search tweets by HashTag for happy emotions
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws TwitterException
	 */

	@Test
	public void test() throws TwitterException, InterruptedException, ExecutionException {
		CompletionStage<Result> result = new HashTagController().searchTweetsByHashTag("");
		Result r = result.toCompletableFuture().get();
		assertNotNull(r);
	}

}
