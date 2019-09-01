import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * This class is the implementation for running the tests
 * @author Akshay Bansal
 * @version 1.0
 *
 */
public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(EmotionsCountImplTest.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
} 
