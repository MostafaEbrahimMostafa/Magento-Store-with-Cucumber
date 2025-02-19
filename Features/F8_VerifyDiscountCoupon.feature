Feature: Verify That The Discount Coupon Works Correctly

  Scenario: User applies a discount coupon and verifies the discount
    Given the user is at the "Magento Store" homepage
    When the user go to "Mobile" category
    And the user adds "iPhone" to the cart
    And the user applies the coupon code "GURU50"
    Then the total price should be discounted by "5%" and updated to "$475.00"
