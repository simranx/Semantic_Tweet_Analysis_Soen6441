package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.fasterxml.jackson.databind.node.ArrayNode;

import interfaces.TweetEmotion;
import play.libs.Json;
import services.TwitterService;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
/**
 * This class is implementing the functionality of determining
 * semantics of the tweets.
 * @author Akshay Bansal
 * @version 1.0
 */
public class TweetEmotionImpl implements TweetEmotion {
	/**
	 * This method is scanning the tweet's for emoticon's.
	 * If 70% of tweet's have happy emoticon's, return happy emoticon.
	 * If 70% of tweet's have happy emoticon's, return sad emoticon.
	 * Else, we return a neutral emoticon.
	 * @author Akshay Bansal
	 * @param searchKey - A string of keyword(s), count - An int of number of emoticon's.
	 * @return String
	 * @throws TwitterException, InterruptedException, ExecutionException
	 * @see interfaces.HappyEmotionsCount#getHappyEmotionsCount(java.util.List)
	 */

	@Override
	public String getTweetEmotion(String searchKey, int count) {
		Twitter twitter = TwitterService.getTwitterInstance(TwitterService.getTwitterFactoryInstance());
		Query query = new Query(searchKey);
		query.count(count);
		//ArrayNode tweets = Json.newArray();
		String emotion="";
		try {
			QueryResult queryResult = twitter.search(query);
			List<Status> tweetsStatus = queryResult.getTweets();
			long total = tweetsStatus.size();
			CompletableFuture<String> emotionFuture = CompletableFuture.supplyAsync(
							()->new EmotionsCountImpl().getHappyEmotionsCount(tweetsStatus))
							.thenCombine(CompletableFuture.supplyAsync(
							()->new EmotionsCountImpl().getSadEmotionsCount(tweetsStatus)), 
							(a,b)->{
								System.out.println(a + " " + b);
								double happyPercent = ((double)a/(double)total)*(double)100;
								double sadPercent = ((double)b/(double)total)*(double)100;
								if(happyPercent>=70)
									return "😊";
								else if(sadPercent>=70)
									return "🙁";
								else
									return "😐";
							});
			emotion = emotionFuture.get();
			//tweets.add(emotion);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return emotion;
	}

}
