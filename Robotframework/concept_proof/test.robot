*** Settings ***
Library    SeleniumLibrary


*** Test Cases ***
The user enter their credentials
    Open Browser    https://www.google.com/    gc
    Maximize Browser Window
    Input Text    //*[@id="APjFqb"]    lmao
    Sleep    2
    Click Element    //input[contains(@class,"gNO89b")]
    Capture Page Screenshot
