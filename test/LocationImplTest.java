import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.ArrayNode;

import implementations.Location;
import play.libs.Json;
import services.TwitterService;
import twitter4j.TwitterFactory;
/**
 * This class is testing the tweet by location functionality.
 * @author Akshay Bansal
 * @version 1.0
 */
public class LocationImplTest {
	/**
	 * This is defining the class variables for testing. 
	 */
	
	public static double latitude;
	public static double longitude;
	public static int count;
	/**
	 * This method is testing tweet with values of latitude, longitude and count.
	 * @param latitude
	 * @param longitude
	 * @param count
	 */
	@BeforeClass
	public static void setUp() {
		TwitterService.isTesting = true;
		TwitterService.typeOfFake = "SAD";
		latitude= 45.5088400;
		longitude = -73.5878100;
		count = 10;
	}
	
	@AfterClass
	public static void tearDown() {
		TwitterService.isTesting = false;
		TwitterService.typeOfFake = "";
	}
	/**
	 * THis method is testing the fetching tweets functionality
	 * with the use of latitude, longitude and count.
	 * @param latitude
	 * @param longitude
	 * @param count
	 */
	@Test
	public void test() {
		ArrayNode arrayNode = Json.newArray();
		arrayNode = new Location().getTweetsByLocationAsync(latitude, longitude, count);
		assertTrue(arrayNode.size()>0);
	}

}
