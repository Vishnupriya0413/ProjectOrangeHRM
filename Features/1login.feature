Feature: login to the application
Scenario: User logs in with correct credentials 
Given open the application
When the user wants to login
Then user can login to the application

Scenario: user logs in with invalid credentials
Given open application
When user enters invalid credentials
Then the system throws an error message

Scenario: user logs in with empty cells
Given open application
When user didnot enter any credentials
Then the system to throw an error message