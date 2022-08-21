Feature:End to End Tests for PetStore API
  Description: The purpose of these tests are to cover End to End happy flows for customer.
  Pet Store Swagger URL : https://petstore.swagger.io
  Background: User place an order for a pet

  Scenario: User can successfully order an animal.
    When I give an order for a pet
    Then Pet is ordered
    And Status is 200 OK.
    When I give invalid order
    Then Pet is not ordered
    And Status is 400.


  Scenario: User can successfully listing the order.
    When I list my order
    Then Order is listed
    And Status is 200 OK.
    When I use invalid ID
    Then Order is not listed
    And Status is 400.
    When Order not found
    Then  Order is not listed
    And Status is 404.

  Scenario: User can successfully delete the order.
    When I delete my order
    Then Order is deleted
    And Status is 200 OK.
    When I use invalid ID
    Then Order is not deleted
    And Status is 400.
    When Order not found
    Then  Order is not deleted
    And Status is 404.


  Scenario: User can successfully get inventory.
    When I list inventory
    Then Inventory is listed
    And Status is 200 OK.


