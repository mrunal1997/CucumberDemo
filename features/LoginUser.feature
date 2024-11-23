Feature: User Login

  Scenario: Successful Login with valid credentials
    Given User is on Login page
    When User enters valid email and password
    And User clicks on Login button
    Then User should be logged in successfully and see the My Account page
