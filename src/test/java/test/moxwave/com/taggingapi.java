package test.moxwave.com;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class taggingapi extends validateApi {
    @Test
    public void isValidGetAPI() {
        //assertTrue(true);
        String getapi=WebConfig.BASE_CONFIG.getTaggingApi(); 
        int actual_status_code=getRequestStatus(getapi);
        System.out.println(actual_status_code);
        Assert.assertEquals(actual_status_code,200);
    }
    @Test
    public void isValidPostAPI() {
        String postapi=WebConfig.BASE_CONFIG.getTaggingApi();
        int actual_status_code=postRequestStatus(postapi);
        System.out.println(actual_status_code);
        Assert.assertEquals(actual_status_code,200);
    }
    @Test
    public void getresponse(){
        String api=WebConfig.BASE_CONFIG.getTaggingApi();
        Response res=postTextPayload(api, "jhs99sds");   
        System.out.println(  res.getBody().asString());
    }
}