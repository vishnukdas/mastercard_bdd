package com.mastercarddemo.steps;

import com.mastercarddemo.support.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebSteps {

  private RemoteWebDriver driver() {
    return DriverFactory.getDriver();
  }

  @Given("I open the Mastercard homepage")
  public void openHomepage() {
    String baseUrl = System.getenv().getOrDefault("BASE_URL", "https://www.mastercard.com");
    driver().get(baseUrl);
  }

  @When("I navigate to {string}")
  public void navigateTo(String url) {
    driver().get(url);
  }

  @Then("the page title should contain {string}")
  public void pageTitleShouldContain(String expected) {
    String title = driver().getTitle();
    Assertions.assertTrue(
        title != null && title.contains(expected),
        "Expected title to contain '" + expected + "' but was '" + title + "'");
  }

  @Then("the URL should contain {string}")
  public void urlShouldContain(String expected) {
    String url = driver().getCurrentUrl();
    Assertions.assertTrue(
        url != null && url.contains(expected),
        "Expected URL to contain '" + expected + "' but was '" + url + "'");
  }

  @Then("the page source should contain {string}")
  public void pageSourceShouldContain(String expected) {
    String source = driver().getPageSource();
    Assertions.assertTrue(
        source != null && source.contains(expected),
        "Expected page source to contain '" + expected + "'");
  }
}
