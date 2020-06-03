package test.moxwave.com;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jayway.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
           .contentType("text/plain; charset=utf-8") 
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
            
            .extract()
            .response();
    }

    public static Response postJsonPayloadFlipcart(String rooturi,JSONObject json, String content_type, String api_key) {
        String[] c_type=null;
        String[] key=null;
        Header h1=null;
        Header h2=null;
          c_type=content_type.split(",");
            key=api_key.split(",");
           
        // cases for header's content-type and X-api-key
        if(content_type=="" && api_key=="")
        {
            
            return given().header("","").header("", ""). body(json.toString()).when().post(rooturi).thenReturn();
        }
        else if(content_type!="" && api_key=="")
        {
            h1=new Header(c_type[0], c_type[1]);
            
            return given().header(h1).header("X-API-Key", ""). body(json.toString()).when().post(rooturi).thenReturn();
        }
        else if(content_type=="" && api_key!="")
        {
            h2=new Header(key[0], key[1]);
            return given().header("Content-Type", "text/plain").header(h2). body(json.toString()).when().post(rooturi).thenReturn();
        }
        else{
            h1=new Header(c_type[0], c_type[1]);
            h2=new Header(key[0], key[1]);
           
           return given().header(h1).header(h2). body(json.toString()).when().post(rooturi).thenReturn();
        }
         

       
        
            //Header h1=new Header("Content-Type", "application/json");
        // Header h2=new Header("X-API-Key", "69EF-9809-1E0B-47FA-8608-B4CB-E3B8-5E00");

    }


    @Test
    public void isValidGetAPI() {
        //assertTrue(true);
        String api=WebConfig.BASE_CONFIG.getTaggingApi(); 
        System.out.println(api);
        int actual_status_code= getRequestStatus(api);
        
        Assert.assertEquals(actual_status_code,200);
     

        //Assert.assertTrue(true);
    }
    @Test
    public void isValidPostAPI() {
        //assertTrue(true);
        Assert.assertEquals(postRequestStatus(WebConfig.BASE_CONFIG.getTerminologyValidationApi()),200);
        //Assert.assertTrue(true);
    }

	public static Response FlipKartNew(String api_url, JSONObject payload) {
        Header h1=new Header("Content-Type", "application/json");
        Header h2=new Header("X-API-Key", " 4692-0538-FC67-46DC-B2C7-DA60-3F05-578F");
		return given().header(h1).header(h2). body(payload.toString()).when().post(api_url).thenReturn();
	}

   
}