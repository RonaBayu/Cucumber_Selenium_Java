@Login
Feature: Login feature of OrangeHRM website

  Background:
    Given I am on OrangeHRM landing page

  @PositiveCase
  Scenario: Login with valid input
    When I input valid Username And Password
    And I click login button on login page
    Then I will be directed to logged in dashboard page

  @NegativeCase
  Scenario Outline: Login with various invalid input
    When I input invalid <username> And invalid <password>
    And I click login button on login page
    Then I could not login and show "Invalid credentials" message

    Examples:
      |username|     |password|
      |admin   |     |password|

  @NegativeCase
  Scenario Outline: Login with various invalid input and empty field
    When I input invalid <username> And invalid <password>
    And I click login button on login page
    Then I cannot login and show "required" message

    Examples:
      |username|     |password|
      |Admin   |     |        |
      |        |     |password|
      |        |     |        |