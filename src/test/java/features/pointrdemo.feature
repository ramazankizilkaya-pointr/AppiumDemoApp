@pointrdemo
Feature: Track Button

    Background: Finish Get Started Tutorial and open mapwidget
      Given I finish Get Started tutorial
      When I select a building and click on Start Button
      Then map widget should be displayed


  Scenario: Expand Search
    Then I set up a route via search and quick access



#    Scenario: Expand Search
#      When I click on Search
#      Then All button should be displayed
#
#    Scenario: Collapse Search
#      When I click on Search
#      Then All button should be displayed
#      When I click on collapse search icon
#      Then All button should not be displayed

