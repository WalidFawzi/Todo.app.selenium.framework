package utils;

import java.util.Properties;

public class ConfigUtils {
    private final Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils (){
        String env =System.getProperty("env","PRODUCTION");
        switch (env) {
            case "PRODUCTION" ->
                    properties = PropertiesUtil.loadProperties("src/test/java/config/production.properties");
            case "LOCAL" ->
                    properties = PropertiesUtil.loadProperties("src/test/java/config/local.properties");

            default -> throw new RuntimeException("Wrong Environment");
        }

    }
    public  static ConfigUtils getInstance (){
        if (configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public  String getBaseUrl (){
       String prop = properties.getProperty("baseUrl");
       if (prop != null) {
           return prop;
       }else
           throw new RuntimeException("There is no base url");
    }
    public  String getEmail(){
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("There is no email found");
    }
    public  String getPassword (){
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("There is no password found");
    }
}
