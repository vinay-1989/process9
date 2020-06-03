package test.moxwave.com;
import org.testng.annotations.*;
import org.testng.Assert;

//import com.google.gson.JsonObject;

//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
//import io.restassured.specification.RequestSpecification;
//import com.jayway.restassured.path.json.JsonPath;
import io.restassured.path.json.JsonPath;


/**
 * Unit test for simple App.
 */
public class WaveTaggingTest {
    /**
     * Rigorous Test.
     */

    public static int getRequestStatus(String rooturi) {
        return
            given()
            .get(rooturi)
            .getStatusCode();
    }

    public static int postRequestStatus(String rooturi) {
        return
            given()
            .post(rooturi)
            .getStatusCode();
    }


    public static Response postTextPayload(String rooturi,String bodytext) {
        
        return
            given()
            .contentType(ContentType.TEXT)
            .body(bodytext)
            .post(rooturi)
            .then()
            .statusCode(200)
            .extract()
            .response();
    }
    @Test
    public void isValidGetAPI() {
        //assertTrue(true);
        Assert.assertEquals(getRequestStatus(WebConfig.BASE_CONFIG.getTaggingUrl()),200);
        //Assert.assertTrue(true);
    }
    @Test
    public void isValidPostAPI() {
        //assertTrue(true);
        Assert.assertEquals(postRequestStatus(WebConfig.BASE_CONFIG.getTaggingUrl()),200);
        //Assert.assertTrue(true);
    }
    
    @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
    public void testTaggingResult(String apiinput, String apiexpected)
    {
        Response response = postTextPayload(WebConfig.BASE_CONFIG.getTaggingApi(),apiinput);
	    // First get the JsonPath object instance from the Response interface
	    JsonPath jsonPathEvaluator = response.jsonPath();
        String taggedSentence = jsonPathEvaluator.get("TagSentence");
        System.out.println(apiexpected+"    "+taggedSentence);
	    Assert.assertEquals(taggedSentence, apiexpected);
    }
}
