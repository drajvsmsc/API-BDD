Feature: Validate Create Order feature
  I want to create a PayPal order using this feature
  Background:
    Given Setup the testdata

  Scenario Outline: TC_<TS_ID>
    Given I want to get access token from PayPal api
    When I set currency code as currencyCode and value as currencyValue>
    And I verify the status as CREATED
    When I get order from the paypal api
    And I verify the status code

    Examples:
      | TS_ID |
      | 1     |
      | 2     |
      | 3     |
      | 4     |
      | 5     |
      | 6     |
      | 7     |

