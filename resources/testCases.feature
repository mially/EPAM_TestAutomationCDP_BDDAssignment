Feature: First test case

  @High
  Scenario Outline: Should be able to login to Gmail with correct user credentials
    Given I navigate to Gmail
    When I enter username "<username>" and password "<password>" and log in
    Then Gmail inbox page should be loaded for "<username>"

    Examples:
      | username    | password          |
      | gmbdaily001 | gmbdaily001mially |
      | gmbdaily002 | gmbdaily002mially |
      | gmbdaily003 | gmbdaily003mially |