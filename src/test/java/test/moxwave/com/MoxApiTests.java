package test.moxwave.com;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class MoxApiTests{

@Test
public void isValidGetAPI() {

    Assert.assertEquals(validateApi.getRequestStatus(WebConfig.BASE_CONFIG.validatePrefixSuffix()),200);

}
@Test
public void isValidPostAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.validatePrefixSuffix()),200);

}

@Test
public void isValidResponsetype(){
    String api_url=WebConfig.BASE_CONFIG.validatePrefixSuffix();
    Response response=  validateApi.postTextPayload(api_url, "test");
    System.out.println(response.contentType());
    System.out.println(response.asString());
    Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
}

@Test(dataProvider = "prefix_suffix_input", dataProviderClass = DataProviders.class)
public void prefixSuffix(String engword , String ex_engword, String en_engword, String en_prefix, String en_suffix)
{

        String api_url=WebConfig.BASE_CONFIG.validatePrefixSuffix();
        Response response=  validateApi.postTextPayload(api_url, engword);
        JsonPath jsonPathEvaluator = response.jsonPath();
        // String api_an_engword = jsonPathEvaluator.get("SentenceList[0].an_engword");
        // Assert.assertEquals(api_an_engword, ex_engword);
        // String api_en_engword = jsonPathEvaluator.get("SentenceList[0].en_engword");
        // Assert.assertEquals(api_en_engword, en_engword);       
        String api_en_prefix = jsonPathEvaluator.get("SentenceList[0].en_prefix");
        Assert.assertEquals(api_en_prefix, en_prefix);     
        String api_en_suffix = jsonPathEvaluator.get("SentenceList[0].en_suffix");
       Assert.assertEquals(api_en_suffix, en_suffix);     

 }
}