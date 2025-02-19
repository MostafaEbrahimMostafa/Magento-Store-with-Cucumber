Feature: Verify That You Are Able To Change Or Reorder A Previously Added Product

  Scenario: User reorders a previously added product and verifies order details
    Given the user is logged into "Magento Store"
    When the user clicking on the "Reorder" button
    And the user changes the quantity to "10" and updates the cart
    Then the grand total should be updated to "$6,150.00"
    When the user clicking on "checkout"
    And the user enters new "billing" and "shipping" information
    And the user place this "order"
    Then the order confirmation message should be "ORDER SUCCESS"
    And the order number should be generated
