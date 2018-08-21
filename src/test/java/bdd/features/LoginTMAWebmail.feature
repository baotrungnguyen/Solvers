@webmail
Feature: Login Webmail
  Login TMA Webmail

Scenario: Valid Login
  Given I open browser to "https://webmail.tma.com.vn/"
  When login with user and password are "nbtrung" and "Tcvn1234@"
  Then I should login successfully
  