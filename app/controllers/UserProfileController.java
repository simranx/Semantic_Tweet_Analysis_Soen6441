package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;
/**
 * This is controller for displaying user profile.
 * @author Anam Dang
 * @version 1.0
 * @see UserProfileController
 */
public class UserProfileController extends Controller{
	/**
	 * This method asynchronously fetches the user profile and displays
	 * their Username, location, picture and 10 latest tweet's.
	 * @author Anam Dang
	 * @param userName - A string
	 * @return Result
	 * @throws TwitterException
	 */
	public CompletionStage<Result> getUserProfile(String userName) throws TwitterException{
		System.out.println("reched here : " + userName);
		return TwitterService.getUserProfile(userName, 10).thenApplyAsync(tweets->ok(tweets));
	}

}
