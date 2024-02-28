#Author: upendra
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: openmrs healthcare
  I want to use this template for my feature file

  @tag1
  Scenario: Testing the openmrs 
    Given I want to open the browser
    And I want to open the openmrs page
    When I give login credentials
    And I click on inpatient ward to access the location
		When I click on login
		Then It displays the home page and access capture vitals

  