@api @api-comments @smoke
Feature: JSONPlaceholder comments API

  Scenario: Get comment by id
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/comments/1"
    Then the response status should be 200
    And the response json path "id" should not be empty
    And the response body should contain "email"

  Scenario: Get comments list
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/comments"
    Then the response status should be 200
    And the response body should contain "postId"

  Scenario: Get comments for post
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/comments?postId=1"
    Then the response status should be 200
    And the response body should contain "postId"

  Scenario: Get comments for another post
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/comments?postId=2"
    Then the response status should be 200
    And the response body should contain "postId"
