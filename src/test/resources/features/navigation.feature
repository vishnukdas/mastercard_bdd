@navigation @smoke @regression
Feature: Mastercard navigation pages

  @smoke
  Scenario: Global English page loads
    When I navigate to "https://www.mastercard.com/global/en.html"
    Then the page title should contain "Mastercard"
    And the URL should contain "mastercard.com"
    And the page source should contain "Mastercard"

  @regression
  Scenario: Newsroom page loads
    When I navigate to "https://www.mastercard.com/newsroom/en-us.html"
    Then the page title should contain "mastercard"
    And the URL should contain "newsroom"

  @regression
  Scenario: Global English page URL check
    When I navigate to "https://www.mastercard.com/global/en.html"
    Then the URL should contain "/global/en"
    And the page title should contain "Mastercard"

  @smoke
  Scenario: Global English page title check
    When I navigate to "https://www.mastercard.com/global/en.html"
    Then the page title should contain "Mastercard"
    And the URL should contain "mastercard.com"

  @regression
  Scenario: Newsroom page URL check
    When I navigate to "https://www.mastercard.com/newsroom/en-us.html"
    Then the URL should contain "newsroom"
    And the page title should contain "mastercard"
