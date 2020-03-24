Feature: Version Greeting Controller

  Background:
    Given url 'http://localhost:8080'

  Scenario: Get Application Version

    Given path '/'
    When method GET
    Then status 200
    And match $ == "v1.0"

  Scenario: Get Application Version with only one header

    * configure headers = { apiVersion: '1.0' }
    Given path '/withHeaders'
    When method GET
    Then status 200
    And match $ == "v1.0"

  Scenario: Get Application Version with Headers

    * configure headers = { apiVersion: '1.0', device: 'Browser' }
    Given path '/withHeaders'
    When method GET
    Then status 200
    And match $ == "Headersv1.0"

  Scenario: Get application welcome message when param name passed

    Given path '/greeting'
    Given param name = 'smit'
    When method GET
    Then status 200
    And match $ == "Welcome to KarateFramework, Smit"

  Scenario: Get application welcome message when a path extends name

    Given path '/greeting/' + 'smit'
    When method GET
    Then status 200
    And match $ == "Welcome to KarateFramework, Smit"