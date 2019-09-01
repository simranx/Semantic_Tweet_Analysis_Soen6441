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
 * Tests the functionality of HomeControllerNeutral
 * @author Akshay Bansal
 * @version 1.0
 */
public class HomeControllerTestNeutral {
	/**
	 * Initializes objects needed for tests before each unit test 
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "NEUTRAL";
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
	 * Test creation of welcome screen
	 */
	@Test
	public void welcomeScreenTest() {
		Result result = new HomeController().welcomeScreen();
		assertNotNull(result);
	}
	/**
	 * Test creation of tweet search for neutral emotions
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws TwitterException
	 */
	@Test
    public void searchTweets() throws InterruptedException, ExecutionException, TwitterException{
        CompletionStage<Result> result = new HomeController().searchTweets("");
        Result r = result.toCompletableFuture().get();
        assertNotNull(r);
    }

}
