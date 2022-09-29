Feature: Login to site with DTWitHeaders

  @DataTableWithHeaders
  Scenario: Login with valid creds
    Given User is on HRMLogin page1
    When User enters valid credentials1
    | UserName | Password |
    | Admin | admin123 |
    Then User should be able to login successfully and new page open1
