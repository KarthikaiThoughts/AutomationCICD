@tag
Feature: Error validations
  I want to use this template for my feature file

  @ErrorValidationTests
  Scenario Outline: Error Validation Negative Tests
     Given I Landed on Eccommerce page
		 When Login with username <name> and password <password>  
     Then "Incorrect email or password." message is displayed

    Examples: 
      | name  												 | password 			|
      | Karthikai@gmail.com 					 | Dec2024@37			|
      | karthikaidurgaprasad@gmail.com | Karthikai@12		|
