Feature: ConnectionManager
  Handles the requests and responses in a server with an API key

  @GetConnection
  Scenario: Returns a valid response from the server
    Given I have a "https://api.openweathermap.org/data/2.5/weather?q=", a "London" and a "c9aac92dbdefed0aa8e5e6d7a8c852cd"
    When I call getConnection
    Then the result should be <result>
