package implementations;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import interfaces.SearchTweetsByLocation;
import play.libs.Json;
import services.TwitterService;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
/**
 * Implements functionality of fetching Tweet's by location
 * @author Mohit Saini
 * @version 1.0
 */
public class Location implements SearchTweetsByLocation{
	/**
	 * Get 10 latest tweet's from a location asynchronously,
	 *  wherever it is available through the location field
	 *  @author Mohit Saini
	 *  @param latitude Latitude of the geolocation
	 *  @param longitude Longitude of the geolocation
	 *  @param count 
	 *  @return Number of tweet's by location
	 */

	@Override
	public ArrayNode getTweetsByLocationAsync(double latitude, double longitude, int count) {
		GeoLocation geolocation = new GeoLocation(latitude, longitude);
		Twitter twitter = TwitterService.getTwitterInstance(TwitterService.getTwitterFactoryInstance());
		Query query = new Query();
		query.geoCode(geolocation, 1, "mi");
		query.count(count);
		List<Status> tweetsStatus = new ArrayList<Status>();
		try {
			QueryResult queryResult = twitter.search(query);
			tweetsStatus = queryResult.getTweets();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayNode tweets = Json.newArray();
		List<CompletableFuture<ObjectNode>> nodesFuture = tweetsStatus.stream()
										.map(status -> CompletableFuture.supplyAsync(
												()->new TweetToJsonImpl().convertTweetToJson(status)))
										.collect(toList());
		
		List<ObjectNode> nodes = nodesFuture.stream().map(CompletableFuture::join)
												.collect(toList());
		nodes.forEach(node->tweets.add(node));
		return tweets;
	}

}
