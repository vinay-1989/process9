package test.moxwave.com;
import static io.restassured.RestAssured.given;
import java.util.List;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class CorpusApiTest {
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

    public static Response postJsonPayload(String rooturi,JSONObject json) {
        
        return
            given()
            .contentType(ContentType.JSON)
            .body(json.toString())
            .post(rooturi)
            .then()
            .statusCode(200)
            .extract()
            .response();
    }
    @Test
    public void isValidGetAPI() {
        //assertTrue(true);
        Assert.assertEquals(getRequestStatus(WebConfig.BASE_CONFIG.getTerminologyValidationApi()),200);
        //Assert.assertTrue(true);
    }
    @Test
    public void isValidPostAPI() {
        //assertTrue(true);
        Assert.assertEquals(postRequestStatus(WebConfig.BASE_CONFIG.getTerminologyValidationApi()),200);
        //Assert.assertTrue(true);
    }
    
    @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
    public void en_hi_validateTerminology(String Name, String SourceLanguage, String TargetLanguage, String SourceText, String TargetText, String expected)
    {
        JSONObject terminology_payload = new JSONObject()
                            .put("Name",Name)
                            .put("SourceLanguage",SourceLanguage)
                            .put("TargetLanguage", TargetLanguage)
                            .put("SourceText", SourceText)
                            .put("TargetText", TargetText);

                            

        Response response = postJsonPayload(WebConfig.BASE_CONFIG.getTerminologyValidationApi(),terminology_payload);

        List<String> terminology = response.jsonPath().getList("$");
        String termwords = String.join(",", terminology);
        Assert.assertEquals(termwords, expected);

     }
}
