@Login
Feature: Login page of to HerokuApp

  Background:
    Given User on HerokuApp home page
    When User click make an appointment button

  @PositiveCase
  Scenario: Login with valid input
    And User input valid Username And Password
    And User click login button
    Then User will be directed to appointment page

  @NegativeCase
  Scenario: Login failed with invalid username and password
     And User input invalid Username And Password
     And User click login button
     Then login is failed and still in the same page

  @NegativeCase
  Scenario: Login failed with username and password field empty
    And User click login button
    Then login is failed and still in the same page