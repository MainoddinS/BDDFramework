Feature: User Login

  Scenario: Successful Login
  Given User is on OrangeHRM Login Page
  When User enters valid credentials (Username : "Admin", Password : "admin123")
  And the user clicks on Login button
  Then User should redirect to Home Page