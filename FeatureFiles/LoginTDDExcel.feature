Feature: Login with Data Driven Excel

  Scenario Outline: Login Data Driven Excel
    Given User navigates to OrangeHRM Login Page
    Then User should be redirected to Home Page by passing username and password with excel row "<row_index>"
    Examples: 
      | row_index  |
      |         1  |
   
