Feature: Search in Google

  @Google @SeleniumWebDriver @Test
  Scenario: Search in Google Selenium WebDriver
    Given David is researching things on the internet
    When he searches "Selenium WebDriver"
    Then he should see information about "Selenium WebDriver"
