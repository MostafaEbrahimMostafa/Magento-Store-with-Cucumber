Feature: Verify Product Cost Consistency Between List Page and Details Page

  Scenario: Validate That The Cost Of Product In List Page And Details Page Are Equal
    Given the user navigates "Mobile" Page
    And the user clicks on the "MOBILE" menu
    When the user reads the cost of "Sony Xperia" mobile from the list page
    And the user clicks on the "Sony Xperia" mobile
    Then the user should see that the product price on the details page matches the price from the list page