#  //like class(Ficha)
Feature: Login

  #  //like method
  Scenario: Login with valid data
#    Write first action
    Given Navigation to Login Page
#    what we be doing(условия)
    When Fill fields valid data
#    продолжение When
    And Click on Login button
#    End Etap
  Then Check displayed Contact page
