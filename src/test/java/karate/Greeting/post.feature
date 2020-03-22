Feature: Create and Read persons ...

  Background:
    * def personBase = '/'
    Given url 'http://localhost:8080'

  Scenario: Create a Version

    Given path personBase
    And request { Version: 'v2.0'}
    And header Accept = 'application/json'
    When method post
    Then status 200

