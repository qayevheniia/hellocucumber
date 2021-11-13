Feature: Add new item to the basket?
  Verify quantity and id items in basket

#  Scenario: Sunday isn't Friday
#    Given Open google page
#    When Click link with image
#    Then Title contain  "car"


  Scenario: Verify quantity item which we added to basket
    When Sent payload with purchase with quantity = 200, id prod = 296932928
    Then Verify quantity 200

  Scenario: Verify id item which we added to basket
    When Sent payload with purchase with quantity = 2, id prod = 296932928
    Then Verify id items 296932928

    Scenario: Remove from basket
      Then  Sent payload with purchase with quantity = 2, id prod = 296932928
      When Remove from basket quantity 2
      Then Verify that basket is empty quantity 0


