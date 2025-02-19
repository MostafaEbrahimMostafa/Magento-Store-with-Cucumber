Feature: Verify Item Sorting by Name on the Mobile Page

  Scenario: User sorts items by name in the mobile category
    Given the user navigates magentoStore "http://live.techpanda.org/"
    When the user clicks on the "Mobile" category
    And the user selects "Name" from the Sort By dropdown
    Then all products should be sorted alphabetically by name
