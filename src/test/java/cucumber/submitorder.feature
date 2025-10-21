Feature: purchase the order

Background:
Given I landed on application landing page

@submit

Scenario Outline:
Given I enter <name> and <password> in landing page
When I select a product with name <product>
And Click on submit
Then I should get confirmation message
Examples:
|name         |password |product    |
|bsj@gmail.com|Password1|ZARA COAT 3|
|bsj@gmail.com|Password1|ZARA COAT 3|