@home @smoke @regression
Feature: Mastercard homepage smoke checks

  @smoke
  Scenario: Homepage title contains Mastercard
    Given I open the Mastercard homepage
    Then the page title should contain "Mastercard"
    And the URL should contain "mastercard."
    And the page source should contain "Mastercard"

  @regression
  Scenario: Homepage URL includes mastercard domain
    Given I open the Mastercard homepage
    Then the URL should contain "mastercard."
    And the page title should contain "Mastercard"

  @regression
  Scenario: Homepage title and source checks
    Given I open the Mastercard homepage
    Then the page title should contain "Mastercard"
    And the page source should contain "Mastercard"

  @smoke
  Scenario: Homepage URL and title checks
    Given I open the Mastercard homepage
    Then the URL should contain "mastercard."
    And the page title should contain "Mastercard"

  @regression
  Scenario: Homepage source and URL checks
    Given I open the Mastercard homepage
    Then the page source should contain "Mastercard"
    And the URL should contain "mastercard."
