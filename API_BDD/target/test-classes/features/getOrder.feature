Feature: Validate Get Order feature
  I want to get a PayPal order usering this feature

  Background:
    Given Setup the testdata

  Scenario Outline: TC_<TS_ID>
    Given I want to get access token from PayPal api
    When I get order from the paypal api
    And I verify the status code

    Examples:
      | TS_ID | statusCode |
      | 1     | 200        |
