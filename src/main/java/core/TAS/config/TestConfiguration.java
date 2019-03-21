package core.TAS.config;

//import com.peterservice.cci.ccisrv.regression.exceptions.ConfigException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import java.util.MissingResourceException;
//import java.util.ResourceBundle;

/**
 * Created by yauheniburau on 3/3/16.
 */

// TODO: remove later
//@Component
//@Configuration
//@PropertySources({
//        @PropertySource(value = "classpath:test-cci-srv-regression.properties"/*, ignoreResourceNotFound=true*/),
//        @PropertySource(value = "classpath:test-openapi-regression.properties"/*, ignoreResourceNotFound=true*/),
//        @PropertySource(value = "classpath:test-amqp-regression.properties"/*, ignoreResourceNotFound=true*/),
//        @PropertySource(value = "classpath:test-testrail-regression.properties"/*, ignoreResourceNotFound=true*/),
//        @PropertySource(value = "classpath:test-db-regression.properties"/*, ignoreResourceNotFound=true*/),
//        @PropertySource(value = "classpath:test-jira-regression.properties"/*, ignoreResourceNotFound=true*/)
//})
//@ComponentScan("com.peterservice.cci.ccisrv.regression")
//public class TestConfiguration {
//    public static final String CONFIG_FILE_NAME = "test-cci-srv-regression.properties," +
//            "test-openapi-regression.properties," + "test-amqp-regression.properties";
//
//    @Autowired
//    private Environment environment;
//
//
//    public final String getProperty(String key){
//        try{
//            return environment.getProperty(key);
//        }
//        catch(IllegalArgumentException e){
//            throw new ConfigException(e, "The property '" + key + "' isn't found in files: " + CONFIG_FILE_NAME + ".properties" );
//        }
//    }
//
//    public final int getIntProperty(String key){
//        try{
//            return Integer.parseInt(getProperty(key));
//        }catch(NumberFormatException e){
//            throw new ConfigException(e, "Can't get integer value from property '" + key + "' in files: "  + CONFIG_FILE_NAME + ".properties" );
//        }
//    }
//
//    public final long getLongProperty(String key){
//        try{
//            return Long.parseLong(getProperty(key));
//        }catch(NumberFormatException e){
//            throw new ConfigException(e, "Can't get long value from property '" + key + "' in files: "  + CONFIG_FILE_NAME + ".properties" );
//        }
//    }
//
//    public final boolean getBooleanProperty(String key){
//        try{
//            return Boolean.parseBoolean(getProperty(key));
//        }catch(NumberFormatException e){
//            throw new ConfigException(e, "Can't get boolean value from property '" + key + "' in files: "  + CONFIG_FILE_NAME + ".properties" );
//        }
//    }
//
//    public final String setProperty(String key, String value){
//        return System.setProperty(key, value);
//    }
//}
