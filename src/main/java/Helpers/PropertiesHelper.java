package Helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesHelper {
    private static final Logger logger = LogManager.getLogger(PropertiesHelper.class);
    private static final HashMap<String, Properties> propertiesMap = new HashMap<>();
    public static String getValue(String key, String filePath){
        try {
            if(!propertiesMap.containsKey(filePath)){
                Properties properties = new Properties();
                try (FileInputStream fis = new FileInputStream(filePath)) {
                    properties.load(fis);
                }
                propertiesMap.put(filePath, properties);
            }
            String keyValue = propertiesMap.get(filePath).getProperty(key);
            return new String(keyValue.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            logger.error("File '{}' not found", filePath);
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("Error reading file '{}'", filePath);
            return null;
        }
    }
}
