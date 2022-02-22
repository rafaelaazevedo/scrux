    Scenario: Search on google
        Given I am on Google page
        When I search for "dog"
        Then I should load the results page