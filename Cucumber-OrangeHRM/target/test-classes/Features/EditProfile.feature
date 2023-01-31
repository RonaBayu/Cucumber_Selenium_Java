@EditProfile
Feature: Edit profile feature of OrangeHRM website

   @PositiveCase
  Scenario: Edit nationality, marital status and gender on my info side menu
    Given I am already login with user that has been created
    When I click my info side menu
    And I choose Nationality, marital status and gender option
    And I click save button on my info page
    Then profile is successfully updated and show success popup messages