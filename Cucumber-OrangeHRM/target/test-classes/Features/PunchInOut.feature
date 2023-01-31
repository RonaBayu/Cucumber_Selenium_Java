@Punch
Feature: Punch in and punch out feature

  @PositiveCase
  Scenario: Punch in and punch out
    Given I am already login with user that has been created
    When I click stopwatch icon or punch in button
    And I click in button on punch in page
    And I click out button on punch out page
    Then Punch feature is successfully saved and show success popup message