*** Settings ***
Documentation    Concept proof to develop a RobotFramework Pipeline
Library    SeleniumLibrary


*** Test Cases ***
The user makes a search in browser
    [Documentation]    Open browser and search
    Set Selenium Speed    0.5
    Open Browser    https://www.google.com/    gc
    Maximize Browser Window
    Input Text    //*[@id="APjFqb"]    lmao
    Click Element    //input[contains(@class,"gNO89b")]
    Capture Page Screenshot
