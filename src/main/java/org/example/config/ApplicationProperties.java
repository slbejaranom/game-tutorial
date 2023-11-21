package org.example.config;

import static java.lang.Integer.parseInt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import lombok.Getter;
import org.example.config.exception.IllegalPropertyException;

@Getter
public class ApplicationProperties {

  private static ApplicationProperties applicationProperties;
  private final Properties properties;
  private WindowConfig windowConfig;

  protected ApplicationProperties() {
    try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
      this.properties = new Properties();
      properties.load(input);
      checkWindowProperties(properties);
    } catch (IOException ex) {
      throw new IllegalPropertyException("Properties file is not found!");
    }
  }

  public static ApplicationProperties getApplicationProperties() {
    if (applicationProperties == null) {
      applicationProperties = new ApplicationProperties();
    }
    return applicationProperties;
  }

  void checkWindowProperties(Properties properties) {
    try {
      int height = parseInt((String) properties.get("window.height"));
      int width = parseInt((String) properties.get("window.width"));
      String gameTitle = Optional.ofNullable((String) properties.get("window.title")).orElse("DEFAULT");
      this.windowConfig = new WindowConfig(width, height, gameTitle);
    } catch (NumberFormatException ex) {
      throw new IllegalPropertyException("Window properties are not correctly set");
    }
  }
}
