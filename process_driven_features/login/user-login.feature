Feature: User Login

  As a registered user
  I want to be able to login
  In order to use site features

  Background:
    Given "Login" page is opened

  @regression
  Scenario Outline: Successful login <username>
    When a user logs in:
      | username   | password   |
      | <username> | <password> |
    Then the user is successfully logged in

    Examples:
      | username | password |
      | student1 | stpass1  |
      | student2 | stpass2  |
      | student3 | stpass3  |

  @regression
  Scenario Outline: Unsuccessful login <username>
    When a user logs in:
      | username   | password   |
      | <username> | <password> |
    Then the user is not logged in

    Examples:
      | username | password |
      | student1 |          |
      | student2 | stpass1  |
      | student  | stpass3  |