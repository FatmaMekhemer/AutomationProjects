Feature: User Registration
  I want to check that the user can register in our e-commerce website

  Scenario Outline: User registration
    Given user is in the home page
    When I click on the register Link
    And fill in the required data which are "<firstname>" and "<lastname>" and "<email>" and "<password>"
    Then The registration page is displayed successfully
    Examples:
    |firstname|lastname|email|password
    |Fatma    |Mekhemer|Fatma@testt.com|12345678
