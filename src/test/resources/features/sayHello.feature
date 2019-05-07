Feature: Say hello
  this feature files contains scenarios to say hello functionality.

  Scenario Outline: Say hello
    Given has helloPage running
    When sets "<name>" in the input field
    And clicks say hello button
    Then verifies that response is "Hello, <name>!"
    Examples:
      | name     |
      | marines  |
      | David Mc |
      | Carlos   |
      | C@rmen   |
