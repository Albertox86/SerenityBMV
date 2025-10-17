Feature: Sorting in Equity

  Background:

    Scenario: uSER Is on Equity home Page

      Scenario: The user is Editor



  Scenario: Sorting for "<letter>"
    Given the user is on the Equity home page
    And the user is Editor
    When he clicks sort by "<letter>"
    Then on column issuer all issuers should start with "<letter>"
    Examples:
    |letter|
    |A|
    |B|
    |C|
    |D|


