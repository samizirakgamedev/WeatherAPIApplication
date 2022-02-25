Feature: APIKeyFileReader
  Reads data provided by the API file using the API Key

  @ReadValidAPIFile
  Scenario: Reads a valid API file and returns it if API file is not null
    Given I have a file path of type "apikey.txt"
    When I call readAPIKeyFile method in APIKeyFileReader
    Then readAPIKeyFile return the API Key as a String type value