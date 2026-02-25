@content @smoke @regression
Feature: Mastercard content checks

  @smoke
  Scenario: Homepage contains Mastercard text
    Given I open the Mastercard homepage
    Then the page source should contain "Mastercard"
    And the page title should contain "Mastercard"
    And the URL should contain "mastercard."

  @regression
  Scenario: Security page loads and has Mastercard text
    When I navigate to "https://www.mastercard.com/global/en.html"
    Then the page title should contain "Mastercard"
    And the URL should contain "/global/en"

  @regression
  Scenario: Intentional failure for LambdaTest status
    Given I open the Mastercard homepage
    Then the page title should contain "DefinitelyNotMastercard"
    And the URL should contain "mastercard."

  @regression
  Scenario: Global English page title check
    When I navigate to "https://www.mastercard.com/global/en.html"
    Then the page title should contain "Mastercard"
    And the URL should contain "/global/en"

  @smoke
  Scenario: Homepage URL check
    Given I open the Mastercard homepage
    Then the URL should contain "mastercard."
    And the page title should contain "Mastercard"

  @regression
  Scenario: Homepage source check
    Given I open the Mastercard homepage
    Then the page source should contain "Mastercard"
    And the URL should contain "mastercard."
