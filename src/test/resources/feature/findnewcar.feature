Feature: Find new car
  In order to find a new car
  As a user
  I need to navigate to carwale website

  Scenario Outline: Finding a new Car
    Given When user navigates to carwale website
    When user mousehovers on new cars option
    Then user clicks on find new cars
    And user clicks on "<carBrand>"
    And user verifies the title as "<carTitle>"

    Examples: 
      | carBrand | carTitle     |
      | Toyota   | Toyota Cars  |
      | Kia      | Kia Carss     |
      | Hyundai  | Hyundai Cars |
      | BMW      | BMW Cars     |
