Feature: Appointment3

  @regression
  Scenario: Appointment3 with different values
    Given The user is into login page username "John Doe" password "ThisIsNotAPassword"
    And Clicks on Bookapointment link
    And The user filled all the details and clicks confirmation
    Then validate the outcomes
