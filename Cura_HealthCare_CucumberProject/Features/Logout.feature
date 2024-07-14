Feature: Successfull Logout

  @regression
  Scenario: Successfull Logout
    Given The user is logged in username "John Doe" password "ThisIsNotAPassword"
    Then The user should Successfully Logout
