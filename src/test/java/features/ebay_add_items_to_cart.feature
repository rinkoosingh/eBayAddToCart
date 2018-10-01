Feature: Add Item to cart in Ebay

  @Cart
  Scenario Outline: Test ebay Search and add 2 items to cart
    Given customer opens the ebay home page and search for <First Item To Search>
    And customer click on the 1 item of product in search page and add to cart
    And customer opens the ebay home page and search for <Second Item To Search>
    And customer click on the 2 item of product in search page and add to cart
   # When customer open the cart from any page
    Then Customer verify <Item Count> items adds to the cart

    Examples:

    |First Item To Search         |Second Item To Search|Item Count|
    |Dell Latitude                |Dell Inspiron        |2         |