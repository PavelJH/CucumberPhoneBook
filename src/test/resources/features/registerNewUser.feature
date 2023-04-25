
Feature: Register New User

  @validRegistration
  Scenario: Register New User With Valid Data
    Given Navigate to Login Page
    When Click on registration link
    And Fill registration form
    And Click on SignUp button
    Then Check displayed message noErrorMsg

