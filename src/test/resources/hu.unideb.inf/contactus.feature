Feature: Testing the ContactUs page

  Background:
    Given the home page is opened
    And the Contact Us link is clicked

#  Scenario:
#    Given the email address is filled with "yudaxiang@email.com"
#    And the order reference is filled with "123456"
#    And the message is filled with "Hello"
#    When the Send button is clicked
#    Then a "Please select a subject from the list provided." error message is shown

    Scenario Outline:
      Given the email address is filled with "<email>"
      And the order reference is filled with "<string>"
      And the message is filled with "<context>"
      When the Send button is clicked
      Then a "<msg>" error message is shown

      Examples:
      |     email     |     string        |     context     |         msg       |
      |123@gmail.cm   | 485216            | good job        |   Please select a subject from the list provided.|

