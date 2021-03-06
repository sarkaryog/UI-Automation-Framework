package com.qdpm.operations.utility;

import org.apache.commons.lang.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is useful for reading data from properties file
 */
public class ApplicationConfiguration {

    private static Properties properties;

    private static String propertyFilePath = System.getProperty("user.dir") +
            "\\src\\application.properties";

    public static String get(String key) throws Exception {
        // 1. Load data from properties file

        properties = new Properties();
        FileInputStream fis = new FileInputStream(propertyFilePath);
        properties.load(fis);

        //2. Read configuration.properties file

        String value = properties.getProperty(key).toString();
        if (StringUtils.isEmpty(value)){
            throw new Exception("Value is not specified for "+key+ " in properties file");
        }
        return value;
    }

}
