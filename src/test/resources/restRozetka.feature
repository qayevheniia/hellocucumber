Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given Open google page
    When Click link with image
    Then Title contain  "car"

    Scenario: My own scenario
      Given Open google page
      When Click link with image
      Then Title contain  "car"