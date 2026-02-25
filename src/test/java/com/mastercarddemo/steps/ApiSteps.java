package com.mastercarddemo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ApiSteps {
  private final ThreadLocal<String> baseUrl = new ThreadLocal<>();
  private final ThreadLocal<Response> response = new ThreadLocal<>();

  @Given("the API base URL is {string}")
  public void setApiBaseUrl(String url) {
    baseUrl.set(url);
  }

  @When("I send a GET request to {string}")
  public void sendGetRequest(String path) {
    String url = baseUrl.get();
    if (url == null || url.isBlank()) {
      throw new IllegalStateException("API base URL is not set.");
    }
    Response result = RestAssured.given().baseUri(url).when().get(path);
    response.set(result);
  }

  @Then("the response status should be {int}")
  public void responseStatusShouldBe(int status) {
    Response result = requireResponse();
    Assertions.assertEquals(status, result.getStatusCode(), "Unexpected response status.");
  }

  @Then("the response body should contain {string}")
  public void responseBodyShouldContain(String expected) {
    Response result = requireResponse();
    Assertions.assertTrue(
        result.asString().contains(expected),
        "Response body did not contain expected text: " + expected);
  }

  @Then("the response json path {string} should not be empty")
  public void responseJsonPathShouldNotBeEmpty(String path) {
    Response result = requireResponse();
    String value = result.jsonPath().getString(path);
    Assertions.assertTrue(value != null && !value.isBlank(), "Expected json path to be non-empty.");
  }

  private Response requireResponse() {
    Response result = response.get();
    if (result == null) {
      throw new IllegalStateException("No API response available. Make sure a request was sent.");
    }
    return result;
  }
}
