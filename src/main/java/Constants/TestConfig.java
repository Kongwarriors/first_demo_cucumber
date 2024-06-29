package Constants;

import Helpers.Helper;
import Helpers.PropertiesHelper;

public class TestConfig {
    public static final String PROPERTY = Helper.getCurrentDir();
    public static String configFilePath = PROPERTY + "src/test/resources/configs/driver_config.properties";
    public static String downloadPath = PROPERTY + PropertiesHelper.getValue("DOWNLOAD_PATH", configFilePath);
    public static final String BROWSER_NAME = PropertiesHelper.getValue("BROWSER_NAME", configFilePath);
}
