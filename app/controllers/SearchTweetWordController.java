package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterService;
import twitter4j.TwitterException;
/**
 * 
 * This is controller for determining the count of all
 * the distinct words used in the 100 latest tweets.
 * @author Harmeet Singh
 * @version 1.0
 * @see SearchTweetWordController
 */
public class SearchTweetWordController extends Controller{
	/**
	 * This method asynchronously counts the distinct words
	 * in 100 latest tweets and displaying it.
	 * @author Harmeet Singh
	 * @param tweetWord - A string of keyword(s)
	 * @return Result
	 * @throws TwitterException
	 */
	public CompletionStage<Result> searchTweetDistinctWordCount(String tweetWord) throws TwitterException{
		return TwitterService.getTweetDistinctWordCount(tweetWord,100).thenApplyAsync(tweets->ok(tweets));
	}
}
