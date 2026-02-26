@api @api-posts @smoke
Feature: JSONPlaceholder posts API

  @smoke
  Scenario: Get post by id
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts/1"
    Then the response status should be 200
    And the response json path "id" should not be empty
    And the response body should contain "userId"

  Scenario: Get posts list
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts"
    Then the response status should be 200
    And the response body should contain "title"

  Scenario: Get comments for a post
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts/1/comments"
    Then the response status should be 200
    And the response body should contain "email"

  Scenario: Get posts for a user
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users/1/posts"
    Then the response status should be 200
    And the response body should contain "userId"
