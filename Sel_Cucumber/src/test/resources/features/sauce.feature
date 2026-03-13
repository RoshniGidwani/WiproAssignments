Feature: Login functionality

Scenario Outline: Successful login with multiple credentials
Given Launch the browser
When I open the login page
And I enter username "<username>" and password "<password>"
And I click on login button

Examples:
| username        | password      |
| standard_user   | secret_sauce  |
|   visual_user   | secret_sauce  |
| problem_user    | secret_sauce  |