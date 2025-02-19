Feature: Verify That You Can Export Orders To CSV And Send As Email Attachment

  Scenario: User exports orders to CSV and sends as an email attachment
    Given the user is on the Magento "Admin" login page
    When the user is logged with valid credentials
    And the user navigates to the Sales -> "Orders" menu
    And the user selects "CSV" in the "Export To" dropdown and clicks the export button
    Then the "exported file" should be downloaded successfully

