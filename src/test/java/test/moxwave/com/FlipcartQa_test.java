package test.moxwave.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlipcartQa_test {
  long lStartTime;
  @BeforeClass
  public void starttime(){
    lStartTime = System.currentTimeMillis();
    System.out.println(lStartTime);
  }


   
  @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class, threadPoolSize = 1)
    public void FlipcartWrapper_Test(String requestid, String callbackUrl, String from, String to, String vertical, String attribute, String texts, String Content_type, String X_Api_key ) throws FileNotFoundException

    {
     // Thread t1=new Thread();
       //long starttime=System.currentTimeMillis();
      
      
        JSONObject payload = new JSONObject();
        JSONObject context = new JSONObject();
             payload.put("requestid", requestid);
             payload.put("callbackUrl", callbackUrl);
             payload.put("from", from);
             payload.put("to", to);
             context.put("vertical", vertical);
             context.put("attribute", attribute);
             payload.put("context", context);
             payload.put("texts", new String[] {texts});
             payload.put("profanityAction", "NoAction");
            // System.out.println(payload);
             
         String api_url = WebConfig.BASE_CONFIG.validateFlipcartApi();         
         Response response = validateApi.postJsonPayloadFlipcart(api_url, payload, Content_type, X_Api_key);
      //  System.out.println(response.asString());
        JsonPath jsonPathEvaluator= response.jsonPath();
       System.out.println(jsonPathEvaluator.getString("requestId")+"   "+  jsonPathEvaluator.getString("status")+"   "+ jsonPathEvaluator.getString("error")+"  "+response.statusCode() );
        // long endtime=System.currentTimeMillis();
        // System.out.println(starttime-endtime);
    
        
    }
    @AfterClass
public void getRunTime() {
    long lEndTime = System.currentTimeMillis();
     System.out.println(lEndTime);
     long result=lEndTime-lStartTime;

      System.out.println(result);
}
}