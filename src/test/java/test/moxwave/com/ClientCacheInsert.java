package test.moxwave.com;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClientCacheInsert {
    @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class, threadPoolSize = 1)
    public void insertclient_cache(String AuthKey, String Language, String Source_text, String Target_text, String Classification, String SubClassification, String TransFlag, String Quality) throws FileNotFoundException
   

    {
        JSONObject payload=new JSONObject();
        JSONObject data=new JSONObject();
        payload.put("AuthKey", AuthKey);
        payload.put("Language", Language);
        data.put("Source_text", Source_text);
        data.put("Target_text", Target_text);
        data.put("Classification", Classification);
        data.put("SubClassification", SubClassification);
        data.put("TransFlag", TransFlag);
        data.put("Quality", Quality);
        payload.put("data", data);

       String apiurl= WebConfig.BASE_CONFIG.InsertClientCache();
       Response response= validateApi.postJsonPayload(apiurl, payload);
       System.out.println(response.asString());
}
}