package ru.tsum.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyManager
 *
 * Work with property files
 *
 * @author Alexander_Suvorov
 */
public class PropertyManager {
    private String configPropertyPath = "src/test/resources/config.properties";
    private Properties configProperty;

    public PropertyManager() {
        try {
            this.configProperty = readProperty(configPropertyPath);
        } catch (IOException e) {
        }
    }

    /**
     * Read property file
     */
    private Properties readProperty(String path) throws IOException {
        Properties configProperty = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            configProperty.load(fis);
            fis.close();
            return configProperty;
        } catch (IOException ex) {
            CustomLogger.getLogger().error(String.format("'Config.property' file was not read \n%s", ex.getMessage()));
            throw ex;
        }
    }

    /**
     * Get properties from file
     * @return
     */
    public Properties getProperty() {
        return configProperty;
    }
}
