Feature: YourLogo sign in page test

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario Outline: test invalid value
    Given the '<field>' is filled with '<parameter>'
    When the Sign In button is clicked
    Then the Sign In '<msg>' error message is shown
    Examples:
      | field | parameter         | msg                        |
      | email |                   | An email address required. |
      | email | invalid.email.com | Invalid email address.     |
      | email | valid@email.com   | Password is required.      |
