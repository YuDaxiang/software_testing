Feature: Testing Create Account page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario Outline:
    Given the '<field>' is filled with '<parameter>'
    When the Sign In button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | field | parameter         | msg                        |
      | email_create |                   | Invalid email address.    |
      | email_create | invalid.email.com | Invalid email address.     |
      | email_create | valid@email.com   | An account using this email address has already been registered. Please enter a valid password or request a new one.      |

