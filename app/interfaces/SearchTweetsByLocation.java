package interfaces;

import com.fasterxml.jackson.databind.node.ArrayNode;


/**
 * Interface to fetch tweetss by location
 * @author mohit saini
 *
 */
@FunctionalInterface
public interface SearchTweetsByLocation {
	/**
	 * @param latitude
	 * @param longitude
	 * @param count
	 * @return ArrayNode
	 */
	ArrayNode getTweetsByLocationAsync(double latitude, double longitude, int count);
}
