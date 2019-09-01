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
 * Tests the functionality of UserProfileController
 * @author Anam Dang
 * @version 1.0
 */
public class UserProfileControllerTest {
	/**
	 * Initializes objects needed for tests before each unit test 
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
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
	 * Test creation of user profile data
	 * @throws TwitterException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
    @Test
    public void getUserProfile() throws TwitterException, InterruptedException, ExecutionException {
    	CompletionStage<Result> result = new UserProfileController().getUserProfile("PranavB83923688");
	    Result r = result.toCompletableFuture().get();
	    assertNotNull(r);
    }

}