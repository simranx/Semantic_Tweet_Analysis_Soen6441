package services;

import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import implementations.Location;
import implementations.SearchTweetsImpl;
import implementations.TweetDistictWordImpl;
import implementations.TweetEmotionImpl;
import implementations.UserProfileImpl;
import modals.Twitter4jFakeHappy;
import modals.Twitter4jFakeNeutral;
import modals.Twitter4jFakeSad;
import play.libs.Json;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 * TwitterService class authenticates the connection with twitter through keys and tokens 
 * and establishes twitter service.
 * @version 1.0
 * @see TwitterService
 * @author Akshay Bansal 
 */
public class TwitterService {

	public static boolean isTesting = false;
	public static String typeOfFake = "";
	
	/**
	 * @author Akshay Bansal
	 * Returns an instance of TwitteFactory
	 * @return TwitterFactory
	 */
	public static TwitterFactory getTwitterFactoryInstance() {
		ConfigurationBuilder conf = new ConfigurationBuilder();
		conf.setDebugEnabled(true)
				.setOAuthConsumerKey("uvZYPifCuMDmDLhGzryVaH9sA")
				.setOAuthConsumerSecret("G01gHXhUerHAevCjhR0U1iOlm5VNmxC5cGRnldvHscVFcMfkvQ")
				.setOAuthAccessToken("969353476450017280-r7gPo5QAT8svSDiCBoB0jSKu1f3Oa8P")
				.setOAuthAccessTokenSecret("TmapsealCXor82pige4FwRZ16tqKollMbBb6AieVcKVrJ");
		return new TwitterFactory(conf.build());
	
	}
	
	/**
	 * Returns the Twitter object based on testing or production enviornment
	 * @author Akshay Bansal
	 * @return instance of Twitter
	 */
	
	public static Twitter getTwitterInstance(TwitterFactory factory) {
		if(!isTesting) {
			return factory.getInstance();
		}
		if(isTesting) {
			if("HAPPY".equalsIgnoreCase(typeOfFake)){
				return new Twitter4jFakeHappy();
			}
			if("SAD".equalsIgnoreCase(typeOfFake)){
				return new Twitter4jFakeSad();
			}
			if("NEUTRAL".equalsIgnoreCase(typeOfFake)){
				return new Twitter4jFakeNeutral();
			}
		}
		return factory.getInstance();
	}
	/**
	 * Fetches tweets based on search(key) asynchronously
	 * @author Akshay Bansal
	 * @param searchKey A variable of type string
	 * @param count A variable of type int
	 * @return tweets based on search(key)
	 * @throws TwitterException
	 */
	public static CompletableFuture<ArrayNode> getTweets(String searchKey,int count) throws TwitterException {
		return CompletableFuture.supplyAsync(()->new SearchTweetsImpl().getTweetsAsync(searchKey, count))
				.thenCombine(CompletableFuture.supplyAsync(()->new TweetEmotionImpl().getTweetEmotion(searchKey, count)), 
						(a, b)->{
							ObjectNode node = Json.newObject();
							node.put("tweetEmotion", b);
							a.add(node);
							return a;
						});
	}
	/**
	 * Fetches tweet's based on hash tags asynchronously
	 * @author Simranjeet Singh
	 * @param searchKey A variable of type String
	 * @param count A variable of type int
	 * @return user details
	 * @throws TwitterException
	 */
	public static CompletableFuture<ArrayNode> getHashTagTweets(String searchKey,int count) throws TwitterException {
		return CompletableFuture.supplyAsync(()->new SearchTweetsImpl().getTweetsAsync(searchKey, count));
	}
	
	/**
	 * Fetches tweets based on location asynchronously
	 * @author Mohit Saini
	 * @param latitude A variable of type double
	 * @param longitude A variable of type double
	 * @param count A variable of type int
	 * @return tweets based on location
	 * @throws TwitterException
	 */
	public static CompletableFuture<ArrayNode> getTweetsByLocation(double latitude, double longitude, int count) throws TwitterException {
		return CompletableFuture.supplyAsync(()->new Location().getTweetsByLocationAsync(latitude, longitude, count));
	}
	
	/**
	 * Fetches user profile asynchronously
	 * @author Anam Dang
	 * @param searchKey A variable of type String
	 * @param count A variable of type int
	 * @return user details
	 * @throws TwitterException
	 */
	public static CompletableFuture<ArrayNode> getUserProfile(String searchKey,int count) throws TwitterException {
		return CompletableFuture.supplyAsync(()->new UserProfileImpl().getUserProfile(searchKey, count));
	}
	/**
	 * Gets tweet count based on distinct words asynchronously.
	 * @author Harmeet Singh
	 * @param searchKey A variable of type String
	 * @param count A variable of type int
	 * @return distinct word count of tweets
	 * @throws TwitterException
	 */
	public static CompletableFuture<ArrayNode> getTweetDistinctWordCount(String searchKey,int count) throws TwitterException {
		return CompletableFuture.supplyAsync(()->new TweetDistictWordImpl().getTweetDistinctWordCount(searchKey, count));
	}
	
}







