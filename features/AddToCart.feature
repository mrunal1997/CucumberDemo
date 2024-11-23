Feature: Add to Cart

  Scenario: Add a product to cart
    Given User is logged in
    And User searches for a product "Apple MacBook Pro 13-inch"
    When User clicks on the Add to Cart button for the product
    Then The product should be added to the cart successfully
