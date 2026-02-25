@api @api-users @smoke
Feature: JSONPlaceholder users API

  @smoke
  Scenario: Get user by id
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users/1"
    Then the response status should be 200
    And the response json path "username" should not be empty
    And the response body should contain "email"

  Scenario: Get users list
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users"
    Then the response status should be 200
    And the response body should contain "username"
