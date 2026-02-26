@api @api-todos @smoke
Feature: JSONPlaceholder todos API

  Scenario: Get todo by id
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/todos/1"
    Then the response status should be 200
    And the response json path "id" should not be empty
    And the response body should contain "title"

  Scenario: Get todos list
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/todos"
    Then the response status should be 200
    And the response body should contain "completed"

  Scenario: Get todos for a user
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users/1/todos"
    Then the response status should be 200
    And the response body should contain "userId"
