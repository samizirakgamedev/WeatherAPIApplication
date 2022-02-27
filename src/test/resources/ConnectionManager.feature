Feature: ConnectionManager
  Handles the requests and responses in a server with an API key

  @GetConnection
  Scenario: Returns a valid response from the server
    Given I have a "https://api.openweathermap.org/data/2.5/weather?q=", a "London" and a api Key
    When I call getConnection
    Then the result should be "https://api.openweathermap.org/data/2.5/weather?q=London&appid=111111111dddddddd"

  @HTTPRequest
  Scenario: Sends a HTTP request to the server
    Given I have a "https://api.openweathermap.org/data/2.5/weather?q=", a "London" and a api Key
    When I call getConnection
    When I call makeStringHttpRequest
    Then I received a request status

  @HTTPResponse
  Scenario: Receives a HTTP response from the server
    Given I have a valid HTTP request
    When I call getStringHttpResponse
    Then I received a response

  @MultipleStatusCode
  Scenario Outline: Tests different HTTP status responses after making a HTTP request
    Given I have a <base URL>, a <city> and a <API key>
    When I call getConnection
    When I call makeHttpRequest
    When I call getHttpResponse
    Then I get <HTTP status response>

    Examples:
      |base URL|city|API key| HTTP status response |
      |"https://api.openweathermap.org/data/2.5/weather?q="|"London"          |"apikey.txt"       |200        |
      |"https://api.openweathermap.org/data/2.5/weather?q="|"San Francisco,us"|"apikey.txt"       |200        |
      |"https://api.openweathermap.org/data/2.5/weather?q="|""                |"apikey.txt"       |400        |
      |"https://api.openweathermap.org/data/2.5/weather?q="|"asdf"            |"apikey.txt"       |404        |
#      |"https://api.openweathermap.org/data/2.5/weather?q="|"Manila"          |"apikey.txt"       |429        | This test works but it had to be comment it out due to limit request calls
      |"https://api.openweathermap.org/data/2.5/weather?q="|"Madrid"          |"invalidapikey.txt"|401        |
      |"https://api.openweathermap.org/data/2.5/weather?q="|"asdf"            |"invalidapikey.txt"|401        |
      |"https://api.openweathermap.org/data/2.5/weather?q="|""                |"invalidapikey.txt"|401        |