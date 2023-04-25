#  //like class(Ficha)
Feature: Login

  @validLogin
  #  //like method
  Scenario: Login with valid data
#    Write first action
    Given Navigate to Login Page
#    what we be doing(условия)
    When Fill fields valid data
#    продолжение When
    And Click on Login button
#    End Etap
  Then Check displayed Contact page
