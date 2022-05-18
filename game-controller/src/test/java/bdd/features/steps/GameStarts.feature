
Feature: Game Starts
  Scenario: Show ships and total numbers
    Given I have 3 ships and computer has 2 ships
    When the game starts
    Then my ships available=3, sank= 0 and enemy ships available=2
