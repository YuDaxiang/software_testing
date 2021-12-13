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

#      Given the Subject Heading is selected with "<template>"
      Given the email address is filled with "<email>"
      And the order reference is filled with "<string>"
      And the message is filled with "<context>"
      When the Send button is clicked
      Then a "<msg>" error message is shown

#    Your message has been successfully sent to our team.
      Examples:
#      |     template    |     email         |     string        |     context     |         msg       |
#      |                 |123@gmail.cm       | 485216            | good job        |   Please select a subject from the list provided.|
#      |Webmaster        |yudaxiang@gmail.com| 233333            | hi bro          |   An error occurred while sending the message.|
#      |Customer service |987654@gmail.com   | 485216            | nice cloth      |   Your message has been successfully sent to our team.|
#      |Webmaster        |abcdefg@gmail.com  | 233333            | new cloth       |   An error occurred while sending the message.|
#      |Customer service |321@gmail.com      | 485216            | cloth discount  |   Your message has been successfully sent to our team.|
      |     email         |     string        |     context     |         msg       |
      |123@gmail.cm       | 485216            | good job        |   Please select a subject from the list provided.|
      |yudaxiang@gmail.com| 233333            | hi bro          |   Please select a subject from the list provided.|
      |987654@gmail.com   | 485216            | nice cloth      |   Please select a subject from the list provided.|
      |abcdefg@gmail.com  | 233333            | new cloth       |   Please select a subject from the list provided.|
      |321@gmail.com      | 485216            | cloth discount  |   Please select a subject from the list provided.|
