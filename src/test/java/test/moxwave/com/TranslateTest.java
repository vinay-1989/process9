package test.moxwave.com;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TranslateTest {
    @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class, threadPoolSize = 1)
    public void Translate_validate(String Key, String text, String from, String to, String transliterate) throws FileNotFoundException
    {
        JSONObject payload=new JSONObject();
        
        payload.put("Key", Key);
        payload.put("text", text);
        payload.put("from", from);
        payload.put("to", to);
        payload.put("transliterate", transliterate);

       String api_url= WebConfig.BASE_CONFIG.translate_Api();
      Response response= validateApi.postJsonPayload(api_url, payload);
     int status= response.getStatusCode();
     if(status!=200){
      System.out.println(response.getStatusCode()+" "+response.asString());
     }
     else{
      JsonPath jsonPathEvaluator = response.jsonPath();
     System.out.println(response.getStatusCode()+" "+jsonPathEvaluator.get("translation"));
     }
    }

}