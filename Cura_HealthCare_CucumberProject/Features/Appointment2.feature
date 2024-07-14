Feature: Apointment2

  @regression
  Scenario: Appointment2
    Given The user is on login page username "John Doe" and password "ThisIsNotAPassword"
    When The user fills all the fields
    And The user clicks on bookappointment link
    Then I validate the outcomes
