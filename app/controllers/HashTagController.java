package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;


/**
 * Date July 27,2018
 * This is controller for fetching tweet's by hashtag's
 * @author Simrenjeet Singh
 * @version 1.0
 *
 */
public class HashTagController extends Controller{
	
	
	/**
	 * This method asynchronously fetches tweet's by hashtag's
	 * @author Simrenjeet Singh
	 * @param searchKey
	 * @return Result
	 * @throws TwitterException
	 */
	public CompletionStage<Result> searchTweetsByHashTag(String searchKey) throws TwitterException{
		return TwitterService.getHashTagTweets("#"+searchKey,10).thenApplyAsync(tweets->ok(tweets));
	}

}
