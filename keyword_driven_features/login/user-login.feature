Feature: User Login

  As a registered user
  I want to be able to login
  In order to use site features

  Background:
    Given a user has opened the site
    And the user has clicked on "Login" menu

  @regression
  Scenario Outline: Successful login <username>
    When user types in "username" field "<username>"
    And user types in "userpass" field "<password>"
    And user clicks ok button "Login"
    Then the user should see "Logout" menu with href "index.php?page=logout"

    Examples:
      | username | password |
      | student1 | stpass1  |
      | student2 | stpass2  |
      | student3 | stpass3  |

  @regression
  Scenario Outline: Unsuccessful login <username>
    When user types in "username" field "<username>"
    And user types in "userpass" field "<password>"
    And user clicks ok button "Login"
    Then the user should still see the "Login" form with name "loginform"

    Examples:
      | username | password |
      | student1 |          |
      | student2 | stpass1  |
      | student  | stpass3  |