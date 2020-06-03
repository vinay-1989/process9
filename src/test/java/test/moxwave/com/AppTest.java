package test.moxwave.com;

import com.beust.jcommander.Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import test.moxwave.com.WebConfig;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test(threadPoolSize = 2, invocationCount = 3)
    @Parameters()
    public void testApp() {
         
      System.out.printf("%n[START] Thread Id : %s is started!",Thread.currentThread().getId());
     System.out.println("my na");
      for(int j=1;j<5;j++){
     System.out.println(Thread.currentThread());
      }
     
	System.out.printf("%n[END] Thread Id : %s",Thread.currentThread().getId());
    
    }
   // @Test(threadPoolSize = 2, invocationCount = 3)
    public void testApp1() {

    
        System.out.println(Thread.currentThread().getId());
    
    }
}
