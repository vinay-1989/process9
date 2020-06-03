/**
 * The interface Web config.
 */
package test.moxwave.com;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
//import org.aeonbits.owner.Config.Key;
//@Config.Sources({ "classpath:${env}.properties" })
 @Config.Sources({ "classpath:qa.properties" })
//@Config.Sources({ "classpath:dev.properties" })

public interface WebConfig extends Config {
/**
     * Value BASE_CONFIG.
     */
   
    public static WebConfig BASE_CONFIG = ConfigFactory.create(WebConfig.class, System.getenv(), System.getProperties());
    
/**
     * Value web.url.
     *
     * @return url. url
     */
    @Key("wave.tagging.url")
    String getTaggingUrl();

    @Key("wave.tagging.url")
    String getTaggingApi();

    @Key("test.helloword")
    String getHellowword();

    @Key("data.tagging.excel")
    String getTaggingExcel();

    //corpus api

    @Key("corpus.terminology.api")
    String getTerminologyValidationApi();
    
    @Key("hi_indic_mapping_api")
    String getHindiIndicMappingApi();

    @Key("sentence_break.api")
    String validatePrefixSuffix();
    
    @Key("detect.sentence.api")
    String validateSentenceBreak();

    @Key("mox.wave.api")
    String getMoxWaveApi();

    @Key("flipcart.wrapper.api")
    String validateFlipcartApi();
    
    @Key("flipkart.live.api")
    String validateFlipkartNewApi();

    @Key("flipcart.lb.api")
    String validateflipcartLBApi();  
    
    @Key("clientcache.insert.api")
    String InsertClientCache();

    @Key("translate.api")
    String translate_Api();



}