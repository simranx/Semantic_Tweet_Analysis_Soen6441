package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;

import views.html.*;
/**
 * This is controller for searching Twitter to fetch tweets
 * for given keywords.
 * @author Akshay Bansal
 * @version 1.0
 * @see HomeController
 * 
 */
public class HomeController extends Controller {
	/**
	 * @author Akshay Bansal
	 * @return
	 */
	
	public Result welcomeScreen() {
		return ok(homePage.render());
	}
	/**
	 * This method asynchronously fetches latest 10 tweets for search 
	 * keyword.
	 * @author Akshay Bansal
	 * @param searchKey - A string for keyword(s)
	 * @return Result
	 * @throws TwitterException
	 */	
	public CompletionStage<Result> searchTweets(String searchKey) throws TwitterException{
		return TwitterService.getTweets(searchKey,10).thenApplyAsync(tweets->ok(tweets));
	}
}
