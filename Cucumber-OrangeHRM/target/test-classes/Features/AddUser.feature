@AddUser
Feature: Add user (employee) feature of OrangeHRM website

  Background:
  Given I already login on OrangeHRM website
    When I click PIM button on side menu
    And I click add button

  @PositiveCase
  Scenario: Add user on PIM main menu with create login details
    And I input firstname and lastname field
    And I click Create Login Details switch button
    And I input username, password and confirm password
    And I click save button
    Then New employee list or user has been created


    @NegativeCase @FullName
  Scenario Outline: Add user on PIM main menu without complete input full name
    (user have to input firstname and last name)
    And I input <firstname>, <middlename> and <lastname> field
    And I click save button
    Then New user could not created and show "required name" message

    Examples:
      |firstname|     |middlename|   |lastname|
      |Kai      |     |          |   |        |
      |         |     |  Kai     |   |Havertz |
      |         |     |          |   |Havertz |
      |Kai      |     | Havertz  |   |        |
      |         |     |          |   |        |

  @NegativeCase @Username
  Scenario: Add user on PIM main menu with existed username data
    And I click Create Login Details switch button
    And I input existed username data
    And I click save button
    Then New user is not successfully created and show "Username already exists" message

  @NegativeCase @Username
  Scenario Outline: Add user on PIM main menu with create login details, but username is less than 5 characters
  (username should be at least 5 characters.)
    And I click Create Login Details switch button
    And I input <username>, <password> and <confirm password> on login details
    Then username field is error and shows "Should be at least 5 characters" message

    Examples:
      |username|
      |Kai|


  @NegativeCase @Password
  Scenario Outline: Add user on PIM main menu with create login details, but incorrect password and confirm password
  (password must contain a lower-case letter, an upper-case letter, a digit and a special character.)
    And I click Create Login Details switch button
    And I input <username>, <password> and <confirm password> on login details
    Then password field is error and shows "password must contain........" message

    Examples:
      |username|       |password|        |confirm password|
      |KaiHavertz|     |password  |        |password    |
      |KaiHavertz|     |Password  |        |Password    |
      |KaiHavertz|     |Password10|        |Password10  |
      |KaiHavertz|     |Password* |        |Password*   |


  @NegativeCase @Password
  Scenario Outline: Add user on PIM main menu with create login details, but password is less than 8 characters
  (password should have at least 8 characters.)
    And I click Create Login Details switch button
    And I input <username>, <password> and <confirm password> on login details
    Then password field shows "Should have at least 8 characters" message

    Examples:
      |password|
      |1234567|

  @NegativeCase @Password
  Scenario Outline: Add user on PIM main menu with create login details, but password is not match with confirmation password
    And I click Create Login Details switch button
    And I input <username>, <password> and <confirm password> on login details
    Then confirmation password field shows "Passwords do not match" message

    Examples:
      |password|       |confirm password|
      |12345671|        |12345678|


  @NegativeCase
  Scenario: Add user on PIM main menu with create login details, but without input anything
    And I click Create Login Details switch button
    And I click save button
    Then New user could not created and show "required name" message