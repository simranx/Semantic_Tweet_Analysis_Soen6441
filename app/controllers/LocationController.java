package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;
/**
 * 
 * This controller is being used to find the location of the tweet.
 * @author Mohit Saini
 * @version 1.0
 * @see LocationController
 *
 */
public class LocationController extends Controller {
	/**
	 * This method asynchronously fetches the location of 10 latest tweets for search keyword.
	 * @author Mohit Saini
	 * @param latitude - A String value
	 * @param longitude - A String value
	 * @return Result
	 * @throws TwitterException
	 */
	public CompletionStage<Result> searchTweetsByLocation(String latitude, String longitude) throws TwitterException{
		System.out.println(latitude + " " + longitude);
		return TwitterService.getTweetsByLocation(Double.parseDouble(latitude), Double.parseDouble(longitude), 10).thenApplyAsync(tweets->ok(tweets));
	}
}
