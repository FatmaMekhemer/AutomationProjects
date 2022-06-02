Feature: User Registration
  I want to check that the user can register in our e-commerce website

  Scenario: User registration
    Given user is in the home page
    When I click on the register Link
    And fill in the required data
    Then The registration page is displayed successfully
