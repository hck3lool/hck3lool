Feature: Checkout at SauceDemo Store

@SauceDemo @Checkout
Scenario: Successful Checkout with Multiple Items in SauceDemo Store
    Given Carlota navigates to the SauceDemo store
    And she successfully logs in
    When she adds 5 products to her shopping cart
    And she proceeds to create a new Checkout
    Then she will see the Checkout process should be generated accurately
