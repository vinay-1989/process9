package test.moxwave.com;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class MoxApiTests{

@Test
public void isValidGetAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.validatePrefixSuffix()),200);

}
@Test
public void isValidPostAPI() {

    Assert.assertEquals(validateApi.postRequestStatus(WebConfig.BASE_CONFIG.validatePrefixSuffix()),200);

}
@Test(dataProvider = "sentence_break_input", dataProviderClass = DataProviders.class)
public void sentenceBreak(String input, String an_engword , String           )
{

        String api_url=WebConfig.BASE_CONFIG.validatePrefixSuffix();
        Response response=  validateApi.postTextPayload(api_url, input);


    //    String Actual= response.asString();
    //     Actual = Actual.replaceAll("^\"+|\"+$", "");
    //   System.out.println(Actual +"\t"+Expected);
    // Assert.assertEquals(Actual, Expected);
    // System.out.print("");
    

 }
}