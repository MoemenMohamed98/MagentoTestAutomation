package com.magento.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    // Load the properties file
    // This class is responsible for loading the properties file and providing access to its values
    // The properties file is located in the src/main/resources directory
    // The properties file is named WebConfigurations.properties
    // The properties file contains the following keys:
    // BrowserType
    // BaseURL

    public static final Properties WebConfig = loadProperties();

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (FileInputStream webConfigFile = new FileInputStream("src/main/resources/WebConfigurations.properties")) {
            props.load(webConfigFile);
        } catch (IOException e) {
            System.out.println("Failed to load WebConfigurations.properties: " + e.getMessage());
        }
        return props;
    }
    }

