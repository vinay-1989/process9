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
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FlipkartNewLiveTest {

 
   
  @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
    public void Flipkartnew_Test(String requestid, String callbackUrl, String from, String to, String vertical, String attribute, String texts ) throws FileNotFoundException

    {
        
      
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
             
         String api_url = WebConfig.BASE_CONFIG.validateflipcartLBApi(); 
         System.out.println(api_url);        
         Response response = validateApi.FlipKartNew(api_url, payload);
      //  System.out.println(response.asString());
        JsonPath jsonPathEvaluator= response.jsonPath();
        System.out.println(jsonPathEvaluator.getString("requestId")+"   "+  jsonPathEvaluator.getString("status")+"   "+ jsonPathEvaluator.getString("error") );

    
        
    }
}