@login
Feature: This feature file consists of API Login test scenarios for Patient Portal

  Scenario Outline: Login with valid credentials using API requests
    Given user performs "<request_type>" request with the endpoint "<endpoint>"
    And using query params "<query_params>"
    When user submits the request with username "<username>" and password "<pwd>"
    Then verifies the response code 200

    Examples:
      | request_type | endpoint    | query_params                 | username             | pwd            | resp_code |
      | POST         | /auth/login | Client-key:lgpdev#isOH:False | roopaworld@yahoo.com | Meddbaselogin1 | 200       |