@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I Landed on Eccommerce page

  @Regression
  Scenario Outline: Positive test of the submitting order
    Given Login with username <name> and password <password>  
    When 	Add product <product> to cart
    And Checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  												 | password 			| product  					|
      | Karthikai@gmail.com 					 | Dec2024@379  	| QWERTY	 					|
      | karthikaidurgaprasad@gmail.com | Karthikai@123	| IPHONE 13 PRO     |
