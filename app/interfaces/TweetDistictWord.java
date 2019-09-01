package interfaces;

import com.fasterxml.jackson.databind.node.ArrayNode;


/**
 * Interface to fetch distic words and their count
 * @author Harmeet
 *
 */
@FunctionalInterface
public interface TweetDistictWord {
	/**
	 * @param searchKey
	 * @param count
	 * @return ArrayNode
	 */
	ArrayNode getTweetDistinctWordCount(String searchKey,int count);
}
