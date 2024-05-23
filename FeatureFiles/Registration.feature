Feature: Account Registration
 
  Scenario: Successful Account Registeration
    Given the user navigates to registration page
    When the user enters the details into below fields
      | firstname      | zzzzzz   |
      | lastname       | bbbbbb   |
      | username       | ccccc    |
      | password       | Ddd@1234 |
      | confpassword   | Ddd@1234 |
    And user selects the gender
    And user clicks on register button
    Then user gets registered 