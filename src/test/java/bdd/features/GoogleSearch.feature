@google
Feature: Google Search
  Website of TMA Solutions should be the first result on google

Scenario: Search TMA in Google
  Given I navigate to page at "https://www.google.com/" address
  When I enter "tma solutions" text into search field
  And click on search button
  When I select the first result
  Then I should go to "http://www.tmasolutions.com/"
  
  
Scenario: Search Wiki in Google
  Given I navigate to page at "https://www.google.com/" address
  When I enter "wiki" text into search field
  And click on search button
  When I select the first result
  Then I should go to "https://www.wikipedia.org/"