package test.moxwave.com;
import test.moxwave.com.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class TransliterationMap{

@Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
public void TransliterateMapScript(String SourceLanguage, String TargetLanguage, String SourceText, String Expected_TargetText, String Expected_Algo)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("SourceText",SourceText)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);

        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
        JsonPath jsonPathEvaluator = response.jsonPath();

        String Actual_algo=jsonPathEvaluator.get("Algo");
       System.out.println(Actual_algo +"   "+Expected_Algo+"    "+SourceLanguage+"  "+TargetLanguage);
      // System.out.println(SourceLanguage +" "+ Actual_algo );
         Assert.assertEquals(Actual_algo, Expected_Algo);
       
        // String Api_TargetText=jsonPathEvaluator.get("TargetText");
        // Assert.assertEquals(Api_TargetText, Expected_TargetText);
        
}


}