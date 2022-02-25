Feature: Injector
  The injector convert the HTTP response in a JSON object, then it assigns the inner json objects to the correspondent DTO classes.

  @GetJSONResponse
  Scenario: Returns a json Object from a valid HTTP response
    Given I have a valid HTTP response
    When I call getJSONResponse
    Then I get a valid json Object

  @InjectIntoDTO
  Scenario:
    Given I have valid injector
    And I have valid JSON response object
    And I have a new valid Clouds, Coord, Main, Sys, Weather, Win, Snow, Rain instances
    When I call injectIntoDTO
    Then All values from the JSON response object are assigned to their clases