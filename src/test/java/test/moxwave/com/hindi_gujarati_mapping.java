package test.moxwave.com;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class hindi_gujarati_mapping{

@Test
public void isValidGetAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.getHindiIndicMappingApi()),200);

}
@Test
public void isValidPostAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.getHindiIndicMappingApi()),200);

}
@Test(dataProvider = "hi_gu_map", dataProviderClass = DataProviders.class)
public void hi_gu_mapping(String Langword, String TargetLanguage, String SourceLanguage , String Expected)
{
    JSONObject mapping_payload = new JSONObject()
                        .put("Langword",Langword)
                        .put("TargetLanguage", TargetLanguage)
                        .put("SourceLanguage",SourceLanguage);


        String api=WebConfig.BASE_CONFIG.getHindiIndicMappingApi();
        Response response=  validateApi.postJsonPayload(api, mapping_payload);
       String Actual= response.asString();
        Actual = Actual.replaceAll("^\"+|\"+$", "");
      System.out.println(Actual +"\t"+Expected);
    Assert.assertEquals(Actual, Expected);
    System.out.print("");
 }
}
