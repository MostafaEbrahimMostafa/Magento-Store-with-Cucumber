Feature: Validate that a user cannot add more products to the cart than available in stock

  Scenario: Verify that the system prevents adding an excessive quantity of a product
    Given the user go to "Mobile" page
    When the user clicks "Add to Cart" for the "Sony Xperia" mobile
    And the user updates the quantity to "1000" and clicks "Update"
    Then the user should see an error message: "* The maximum quantity allowed for purchase is 500."
    And the user should see  anther error message: "Some of the products cannot be ordered in requested quantity."
    When the user clicks on "Empty Cart"
    Then the user should see a confirmation message: "SHOPPING CART IS EMPTY"
