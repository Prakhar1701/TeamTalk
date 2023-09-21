package utils;

import java.util.ResourceBundle;

public class ConfigReader {
    ConfigReader() {
    }

    private static ResourceBundle rb = ResourceBundle.getBundle("config");


    public static String getValues(String key) {
        return rb.getString(key);
    }
}
