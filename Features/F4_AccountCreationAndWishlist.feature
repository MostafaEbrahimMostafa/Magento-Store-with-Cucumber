Feature: Account Creation and Wishlist Sharing

  Scenario: Verify that a user can create an account and share a wishlist on the e-commerce site

    Given the user open the url "http://live.techpanda.org/"
    When the user clicks on the "My Account" link
    And the user clicks on the "Create Account" link and fills in new user information except for the email ID
    And the user clicks on the "Register" button
    Then the registration should be successful with a confirmation message
    When the user navigates to the "TV" menu
    And the user adds a product to the wishlist
    Then the product should be successfully added to the wishlist
    When the user click on the "Share Wishlist" button
    And the user enters the recipient's email "mostafakady@gmail.com" and a message and click on the "Share Wishlist" button
    Then the wishlist should be shared successfully


