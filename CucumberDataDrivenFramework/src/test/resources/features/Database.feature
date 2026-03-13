Feature: Login using database credentials

  Scenario: Login with valid users from database
    Given Launch the browser
    When I open the login page
    And I login using database credentials
    Then User should be logged in successfully