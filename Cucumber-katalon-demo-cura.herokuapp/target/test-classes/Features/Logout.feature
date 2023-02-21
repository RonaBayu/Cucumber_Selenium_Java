@Log
Feature: Logout account of to HerokuApp

  @PositiveCase
  Scenario: verifying logout feature
    Given User is already logged in to the HerokuApp website
    When I click logout button
    Then I will be directed to HerokuApp home page