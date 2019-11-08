package test.moxwave.com;

//import org.junit.Test;

//import static org.junit.Assert.*;
import org.testng.annotations.*;
import org.testng.Assert;
//import test.moxwave.com.WebConfig;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        //assertTrue(true);
        Assert.assertEquals("Hellow world",WebConfig.BASE_CONFIG.getHellowword());
        Assert.assertTrue(true);
    }
}
