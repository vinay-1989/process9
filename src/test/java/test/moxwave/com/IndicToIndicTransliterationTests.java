package test.moxwave.com;
import test.moxwave.com.*;
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
public void HindiToGujaratiTest(String Langword, String TargetLanguage, String SourceLanguage , String Algo, String Expected)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("Langword",Langword)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);


        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();

       
        String Actual_algo=jsonPathEvaluator.get("Algo");
        Assert.assertEquals(Actual_algo, Algo);

        String TT=jsonPathEvaluator.get("TargetText");
        Assert.assertEquals(TT, Expected);
 }

 @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
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
        System.out.println(Actual_algo +" "+Expected_Algo+"  "+SourceLanguage+"  "+TargetLanguage);
        Assert.assertEquals(Actual_algo, Expected_Algo);
       
         String Api_TargetText=jsonPathEvaluator.get("TargetText");
        //Assert.assertEquals(Api_TargetText, Expected_TargetText);


       
}
}

