@CreateAppointment
Feature: Create or make an appointment

  Background:
    Given User is already logged in to the HerokuApp website

  @PositiveCase
  Scenario: verifying make an appointment feature with valid input

    When User input all fields with valid input
    And User click book appointment button
    Then Appointment is successfully created and show Appointment Confirmation message


  @NegativeCase
  Scenario: verifying make an appointment feature without input anything

    When User don't input anything
    And User click book appointment button
    Then Appointment is not created and show Date table that must input