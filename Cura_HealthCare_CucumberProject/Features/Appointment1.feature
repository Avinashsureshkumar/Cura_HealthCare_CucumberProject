Feature: Appointment1

  @sanity @regression
  Scenario: Checking Appointment Status
    Given The user is successfully logged in with username "John Doe" and password "ThisIsNotAPassword"
    When The user fills all the required fields and checkboxes and clicks on Book Appointment link
    Then The user should be redirected to Confirmation page
