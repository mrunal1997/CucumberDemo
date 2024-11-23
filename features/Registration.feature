Feature: User Registration

  Scenario: Successful Registration with valid details
    Given User is on Registration page
    When User enters first name, last name, email, password and confirms password
    And User selects newsletter checkbox
    And User clicks on Register button
    Then User should be registered successfully and see a confirmation message
