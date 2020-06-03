package test.moxwave.com;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.poi.util.StringUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class SentenceBreakTest{

@Test(dataProvider = "exceldatareader", dataProviderClass = ExcelDataProviders.class)
public void Abbreviations_Test(String engword , String ex_an_enword)

{
           JSONObject sentence_break_payload=new JSONObject()
            .put("key", "BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72")
             .put("inputtext",engword);
          
        String api_url=WebConfig.BASE_CONFIG.validatePrefixSuffix();

        Response response=  validateApi.postJsonPayload(api_url, sentence_break_payload);
        String res = response.asString();
        
        JSONObject jo = new JSONObject(res);
        JSONArray ja=  jo.optJSONArray("SentenceList");
        System.out.println(ja.length());
        
        
       
       
       
        //Response response=  validateApi.postTextPayload(api_url, engword);
       
      /*  JsonPath jsonPathEvaluator = response.jsonPath();
        //Get the size of array from the Response body
        Integer api_sentence_count= jsonPathEvaluator.getList("SentenceList").size();
         //Get expected column data from Excel after split as a List  
          // if(engword.contains("|")){
          //         //Get expected column data from Excel after split as a List 
          //       List<String> ex_sentences = Arrays.asList(ex_an_enword.toLowerCase().split(Pattern.quote("|")));
          //       String expected_sentences = String.join("|", ex_sentences);
          //       System.out.println(expected_sentences);
          //       String final_expected_sen=expected_sentences.replace("$rep", "|");
          //       System.out.println("final_expected_sen="+final_expected_sen);
          //       List<String> api_sentences = jsonPathEvaluator.getList("SentenceList.an_engword");
          //       api_sentences.replaceAll(String::toLowerCase);
          //       String actual_sentences = String.join("|", api_sentences);
          //       ex_sentences.replaceAll(String::trim);
          //       Assert.assertEquals(actual_sentences,final_expected_sen);
          // }
        List<String> ex_sentences = Arrays.asList(ex_an_enword.toLowerCase().split("\\|"));
        //get size of List of Expected data
        Integer ex_sentence_count=ex_sentences.size();
        // compare both the size
        Assert.assertTrue(api_sentence_count==ex_sentence_count);

        //Get the an_engword value from response body as a list
        List<String> api_sentences = jsonPathEvaluator.getList("SentenceList.an_engword");
        api_sentences.replaceAll(String::toLowerCase);
        String actual_sentences = String.join("\\|", api_sentences);

        ex_sentences.replaceAll(String::trim);
        String expected_sentences = String.join("\\|", ex_sentences);
        Assert.assertEquals(actual_sentences,expected_sentences);  */

 }
}