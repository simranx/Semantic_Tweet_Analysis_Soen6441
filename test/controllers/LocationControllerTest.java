package controllers;

import org.junit.Test;

import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;

import static org.junit.Assert.*;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
/**
 * Tests the functionality of LocationController
 * @author Mohit Saini
 * @version 1.0
 */
public class LocationControllerTest {
	/**
	 * Initializes objects needed for tests before each unit test 
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "SAD";
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
	 * Test creation of search tweets by location for sad emotions
	 * @throws TwitterException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
    @Test
    public void searchTweetsByLocation() throws TwitterException, InterruptedException, ExecutionException {
    	CompletionStage<Result> result = new LocationController().searchTweetsByLocation("45.5088400", "-73.5878100");
    	Result r = result.toCompletableFuture().get();
    	assertNotNull(r);
    }
}