package org.example.config;

import static java.lang.Integer.parseInt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.config.exception.IllegalPropertyException;

public class ApplicationProperties {

  private static final Logger logger = LogManager.getLogger(ApplicationProperties.class);
  private static ApplicationProperties applicationProperties;
  private Properties properties;
  private Display display;

  protected ApplicationProperties() {
    try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
      this.properties = new Properties();
      properties.load(input);
      checkWindowProperties(properties);
    } catch (IOException ex) {
      logger.error("Application properties file does not exist!");
    }
  }

  public static ApplicationProperties getApplicationProperties() {
    if (applicationProperties == null) {
      applicationProperties = new ApplicationProperties();
    }
    return applicationProperties;
  }

  public Properties getProperties() {
    return this.properties;
  }

  void checkWindowProperties(Properties properties) {
    try {
      int height = parseInt((String) properties.get("window.height"));
      int width = parseInt((String) properties.get("window.width"));
      this.display = new Display(width, height);
    } catch (NumberFormatException ex) {
      throw new IllegalPropertyException("Window properties are not correctly set");
    }
  }
}
