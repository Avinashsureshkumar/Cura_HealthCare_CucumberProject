Feature: DDT Login Test

  @resgession
  Scenario Outline: Login DataDriven
    Given the user navigates to home page and click on book appointment link
    Then the user should be redirected to the Appointment Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
      |         6 |
      |         7 |
      |         8 |
      |         9 |
      |        10 |
      |        11 |
      |        12 |
      |        13 |
      
