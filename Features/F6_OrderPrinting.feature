Feature: Order Verification and Printing

  Scenario: User verifies and prints the order details
    Given the user is already on the "Home" page
    When the user press on the "Account" Menu
    And the user select "My Account"
    And the user login with valid credentials
    And the user navigates to the recent "orders page"
    And the user views the "order details"
    Then the "order details" should match the "expected information"
    When the user prints "the order"
    Then the order should be printed successfully

