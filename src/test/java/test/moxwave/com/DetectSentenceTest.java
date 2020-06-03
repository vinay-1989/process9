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

import io.restassured.response.Response;

public class DetectSentenceTest {

    

  @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
    public void SentenceBreakTest(String engword, String breaking_count) throws FileNotFoundException

    {
        //System.gc();
        String api_url = WebConfig.BASE_CONFIG.validateSentenceBreak();
        Response response = validateApi.postTextPayload(api_url, engword);
        // JsonPath jsonPathEvaluator = response.jsonPath();
        String res = response.asString();
        
        JSONObject jo = new JSONObject(res);
        JSONArray ja = jo.optJSONArray("SentenceList");
        // System.out.println(ja.getJSONObject(0).getJSONObject("Sentences").getString("1"));
        JSONObject jo1 = ja.getJSONObject(0).getJSONObject("Sentences");
         int actual_breaking_sentence_count= jo1.length();
         int Expected_break_sen=Integer.parseInt(breaking_count); //convert string to int
    
         //System.out.println(engword+"@t"+Expected_break_sen+"@t"+ actual_breaking_sentence_count);
         System.out.println(engword+"\t"+Expected_break_sen+"\t"+ actual_breaking_sentence_count);
       
        // Assert.assertEquals(actual_breaking_sentence_count, Expected_break_sen);
    
        
    }
}