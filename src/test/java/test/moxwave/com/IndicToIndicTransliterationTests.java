package test.moxwave.com;
import test.moxwave.com.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class IndicToIndicTransliterationTests {

@Test
public void isValidGetAPI() {

    Assert.assertEquals(validateApi.getRequestStatus(WebConfig.BASE_CONFIG.getHindiIndicMappingApi()),200);

}
@Test
public void isValidPostAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.getHindiIndicMappingApi()),200);
}

@Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
public void HindiToGujaratiTest(String SourceText, String SourceLanguage, String TargetLanguage, String Algo, String Expected_TargetText)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("SourceText",SourceText)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);


        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();

       
        String Actual_algo=jsonPathEvaluator.get("Algo");
        Assert.assertEquals(Actual_algo, Algo);

        String Actual_Target_text=jsonPathEvaluator.get("TargetText");
        Assert.assertEquals(Actual_Target_text, Expected_TargetText);
 }

 @Test(groups = { "SupportedLanguagesTest" }, dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
public void SupportedLanguagesTest(String SourceLanguage, String TargetLanguage, String SourceText, String Expected_TargetText, String Expected_Algo)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("SourceText",SourceText)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);

        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();

        String Actual_algo=jsonPathEvaluator.get("Algo");
        //System.out.println(Actual_algo +" "+Expected_Algo+"  "+SourceLanguage+"  "+TargetLanguage);
        Assert.assertEquals(Actual_algo, Expected_Algo);
       
        String Api_TargetText=jsonPathEvaluator.get("TargetText");
        Assert.assertEquals(Api_TargetText, Expected_TargetText); 
}


@Test 
public void HindiToGujaratiSupportTest(){

    JSONObject mapping_payload = new JSONObject()
    .put("SourceText","क")
    .put("TargetLanguage", "gujarati")
    .put("SourceLanguage","hindi");
        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String Actual_algo=jsonPathEvaluator.get("Algo");
        String Api_TargetText=jsonPathEvaluator.get("TargetText");
        if(Actual_algo.equals("Map") & Api_TargetText.equals("")){
        System.out.println("Rule file is missing");
        }
        else{
            System.out.println("Test cases passed");
        }
}

@Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
public void SourceLanguageNormalizationTest(String SourceLanguage, String TargetLanguage, String SourceText, String Expected_NormalizedText)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("SourceText",SourceText)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);

        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();
        String api_Normalize_Text=jsonPathEvaluator.get("NormalizeSourceText");
        Assert.assertEquals(api_Normalize_Text, Expected_NormalizedText);

}
}

