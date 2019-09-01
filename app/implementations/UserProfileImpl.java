package implementations;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import interfaces.UserProfile;
import play.libs.Json;
import services.TwitterService;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 * Displays the profile information of the User and latest 10 tweet's of the user
 * @author Anam Dang
 * @version 1.0
 */
public class UserProfileImpl implements UserProfile {
	/**
	 * Fetches all the profile information of a user
	 * @author Anam Dang
	 * @param searchKey Search keyword 
	 * @param count Number of Tweet's 
	 * @return userProfile Returns associated list of tweet's for this user profile
	 */

	@Override
	public ArrayNode getUserProfile(String searchKey, int count) {
		Twitter twitter = TwitterService.getTwitterInstance(TwitterService.getTwitterFactoryInstance());
		List<Status> timelineTweets = new ArrayList<Status>();
		ArrayNode userProfile = Json.newArray();
		try {
			User user = twitter.showUser(searchKey);
			Paging paging = new Paging();
			paging.setCount(count);
			timelineTweets = twitter.getUserTimeline(user.getId(),paging);
			StringBuilder stringBuilder = new StringBuilder();
			timelineTweets.forEach(t->{
				System.out.println(t.getText());
				stringBuilder.append(t.getText() + "<br>");
			});
			String timeLineTweetsString = stringBuilder.toString();
			ArrayNode timeLineNode = Json.newArray();
			ObjectNode node = Json.newObject();
			node.put("userName", user.getName());
			node.put("userId", user.getId());
			node.put("userScreenName",user.getScreenName());
			node.put("userLocation",user.getLocation());
			node.put("userDescription", user.getDescription());
			node.put("userFollowerCount", user.getFollowersCount());
			node.put("userProfileURL", user.getURL());
			node.put("userImageURL", user.getBiggerProfileImageURLHttps());
			node.put("userIsProtected", user.isProtected());
			node.put("userTimeLineTweets", timeLineTweetsString);
			userProfile.add(node);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userProfile;
	}

}
