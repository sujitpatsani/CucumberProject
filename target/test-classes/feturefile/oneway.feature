Feature: Search for flight

@approve
  Scenario: One way flight booking
    Given user navigate to url"https://www.goibibo.com/"
      | From city         | To city      |
      | Bhubaneswar (BBI) | Mumbai (BOM) |
    And user has choosen one way
    And date is coosen by user
    When user search flight
    Then flight list should be displayed
