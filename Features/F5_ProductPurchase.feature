Feature: Verify that the user is able to purchase a product using a registered email ID

  Scenario: Successful product purchase with a registered email
    Given the user on the "Home" page
    When the user clicks on the "Account" Menu
    And the user selects "My Account"
    And the user "logs in" with valid credentials
    And the user navigates to the "wishlist"
    And the user "adds the product" to the cart and enters "shipping information"
    And the user press on "estimate"
    Then the system generates a flat rate shipping cost of $5
    And the user selects the "shipping cost" and "updates the total"
    Then the "shipping cost" is added to the "total product cost"
    When the user proceed to "checkout"
    And the user enters "billing information"
    And the user continues with the "shipping method"
    And the user selects "Check/Money Order" as the payment method
    And the user "places the order"
    Then the order should be generated successfully
    And the order number should be displayed
