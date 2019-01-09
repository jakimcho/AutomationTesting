Feature: User Profile

  As a registered user
  I want to view and edit my profile
  In order to update when ever I want


  Background:
    Given "Login" page is opened
    And a user is logged in:
      | username | password |
      | student1 | stpass1  |
    And the user is on "Edit Profile" page

  @debug
  Scenario: User updated his/her profile
    When user types in "cEmail" field "dasd"
    And user types in "cName" field "asdasd"
    And user types in "cPhone" field "asddas"
    And user types in "cAddress" field "asdasd"
    And user clicks ok button "Submit"
    Then the user should see "Your profile was updated successfully!" message
