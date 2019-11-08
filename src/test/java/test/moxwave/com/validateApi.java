package test.moxwave.com;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class validateApi {

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
        String api=WebConfig.BASE_CONFIG.getTaggingApi(); 
        int actual_status_code= getRequestStatus(api);
        System.out.println(actual_status_code);
        Assert.assertEquals(actual_status_code,200);
     

        //Assert.assertTrue(true);
    }
    @Test
    public void isValidPostAPI() {
        //assertTrue(true);
        Assert.assertEquals(postRequestStatus(WebConfig.BASE_CONFIG.getTerminologyValidationApi()),200);
        //Assert.assertTrue(true);
    }
}