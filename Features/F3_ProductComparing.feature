Feature: Compare Products Functionality

  Scenario: User compares two mobile products
    Given the user is on the "Mobile" page
    When the user adds "IPhone" to the comparison list
    And the user adds "Sony Xperia" to the comparison list
    And the user clicks  "Compare" button
    Then a comparison pop-up should appear with the selected products
