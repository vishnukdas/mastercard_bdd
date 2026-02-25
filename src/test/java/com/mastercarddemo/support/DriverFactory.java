package com.mastercarddemo.support;

import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverFactory {
  private static final ThreadLocal<RemoteWebDriver> DRIVER = new ThreadLocal<>();

  private DriverFactory() {}

  public static RemoteWebDriver getDriver() {
    return DRIVER.get();
  }

  public static void setDriver(RemoteWebDriver driver) {
    DRIVER.set(driver);
  }

  public static void quitDriver() {
    RemoteWebDriver driver = DRIVER.get();
    if (driver != null) {
      driver.quit();
      DRIVER.remove();
    }
  }
}
