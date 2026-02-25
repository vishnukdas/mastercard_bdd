package com.mastercarddemo.steps;

import com.mastercarddemo.support.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks {
  private static final String BUILD_ID = createBuildId();

  @Before
  public void setUp(Scenario scenario) throws MalformedURLException {
    if (scenario.getSourceTagNames().contains("@api")) {
      return;
    }
    String username = getRequiredEnv("LT_USERNAME");
    String accessKey = getRequiredEnv("LT_ACCESS_KEY");
    String gridUrl =
        System.getenv().getOrDefault(
            "LT_GRID_URL", "https://%s:%s@hub.lambdatest.com/wd/hub");

    ChromeOptions options = new ChromeOptions();
    options.setBrowserVersion(System.getenv().getOrDefault("LT_BROWSER_VERSION", "latest"));

    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("user", username);
    ltOptions.put("accessKey", accessKey);
    ltOptions.put("build", BUILD_ID);
    ltOptions.put("name", scenario.getName());
    ltOptions.put("platformName", System.getenv().getOrDefault("LT_PLATFORM", "Windows 11"));
    ltOptions.put("network", true);
    ltOptions.put("visual", true);
    options.setCapability("LT:Options", ltOptions);

    RemoteWebDriver driver =
        new RemoteWebDriver(new URL(String.format(gridUrl, username, accessKey)), options);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    DriverFactory.setDriver(driver);
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.getSourceTagNames().contains("@api")) {
      return;
    }
    RemoteWebDriver driver = DriverFactory.getDriver();
    if (driver != null) {
      String status = scenario.isFailed() ? "failed" : "passed";
      ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
    }
    DriverFactory.quitDriver();
  }

  private String getRequiredEnv(String name) {
    String value = System.getenv(name);
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalStateException("Missing required environment variable: " + name);
    }
    return value;
  }

  private static String createBuildId() {
    String buildName = "mastercard-demo";
    String jobNumber = System.getenv("HYE_JOB_NUMBER");
    if (jobNumber != null && !jobNumber.trim().isEmpty()) {
      return buildName + "-" + jobNumber.trim();
    }
    return buildName + "-" + UUID.randomUUID().toString();
  }
}
