Feature: login feature

  @regression @sanity
  Scenario: Login with valid credentials
    Given the user navigates to login page
    When user enters email as "John Doe" and password as "ThisIsNotAPassword"
    When the user clicks on the Login button
    Then the user should be redirected to the Appointments Page
