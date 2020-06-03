package test.moxwave.com;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class SendToEditTool{

    @Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
    
    public void SendtoTool(String input, String ql, String op, String language, String key){
           
        JSONObject payload = new JSONObject();
        JSONObject data_obj = new JSONObject();
                 payload.put("Key", key);
                 payload.put("QAmode", true);
                 payload.put("categories", "");
                 payload.put("lang", new String[] {language});
                 data_obj.put("text", input);
                 data_obj.put("qual", ql);
                 data_obj.put("op", op);
                 data_obj.put("inln", "english");
                 payload.put("data", new JSONArray().put(data_obj));
                 
              String api= WebConfig.BASE_CONFIG.getMoxWaveApi();
              Response response=  validateApi.postJsonPayload(api, payload);
              JsonPath jsonPathEvaluator= response.jsonPath();
              String value=jsonPathEvaluator.get("data[0].text");
             System.out.println(value);
            
        }

}