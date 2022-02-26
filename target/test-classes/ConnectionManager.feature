Feature: ConnectionManager
  Handles the requests and responses in a server with an API key

  @GetConnection
  Scenario: Returns a valid response from the server
    Given I have a "https://api.openweathermap.org/data/2.5/weather?q=", a "London" and a api Key
    When I call getConnection
    Then the result should be "https://api.openweathermap.org/data/2.5/weather?q=London&appid=111111111dddddddd"

  @HTTPRequest
  Scenario: Sends a HTTP request to the server
    Given I have a valid connection
    When I call makeHttpRequest()
    Then I received a valid request status

  @HTTPResponse
  Scenario: Receives a HTTP response from the server
    Given I have a valid HTTP request
    When I call getHttpResponse()
    Then I received a response