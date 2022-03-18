*** Keywords ***
Begin Web Test
    Open Browser  about:blank  ${BROWSER}

Go To Web Page
    Maximize Browser Window
    Go To  ${URL}
    Wait Until Page Contains  Infotiv Car Rental

Verify Page Contains
    Click Element   //*[@id="title"]
    Wait Until Page Contains   When do you want to make your trip?

Check Date On Page Start
    ${date} =    Get Current Date  result_format=%Y-%m-%d
    ${attr}=  Get Element Attribute  //*[@id="start"]  value
    ${infotiv_date} =  Convert Date  ${attr}  result_format=%Y-%m-%d
    Should Be Equal    ${date}    ${infotiv_date}

Check Date On Page End
    ${date} =    Get Current Date  result_format=%Y-%m-%d
    ${attr}=  Get Element Attribute  //*[@id="end"]  value
    ${infotiv_date} =  Convert Date  ${attr}  result_format=%Y-%m-%d
    Should Be Equal    ${date}    ${infotiv_date}

Go To Car List
    Click Element   //*[@id="continue"]
    Wait Until Page Contains   What would you like to drive?

Selecting Car Brand In List
    Wait Until Page Contains Element  //*[@id="ms-list-1"]/button
    Click Element   //*[@id="ms-list-1"]/button
    Click Element   //*[@id="ms-list-1"]/div/ul/li[3]/label
    Wait Until Page Contains  Roadster

End Web Test
    Close Browser

User Is Logged In
    Go To Web Page
    Input Text  //*[@id="email"]  stig.stigsson@hotmail.com
    Input Text  //*[@id="password"]  stig123
    Click Element  //*[@id="login"]
    Wait Until Page Contains  You are signed in as Stig

User Books Car
    Click Element  //*[@id="continue"]
    Wait Until Page Contains  What would you like to drive?
    Click Element  //*[@id="bookQ7pass7"]
    Wait Until Page Contains  Confirm booking of Audi Q7

User Pays With Creditcard
    Input Text  //*[@id="cardNum"]  1234567891011121
    Input Text  //*[@id="fullName"]  Stig Stigsson
    Input Text  //*[@id="cvc"]  123
    Click Element  //*[@id="confirm"]
    Wait Until Page Contains  You can view your booking on your page
    Click Element  //*[@id="mypage"]

Car Has Been Booked
    ${date} =  Get Current Date  result_format=%Y-%m-%d
    ${text}=   Get Text  //*[@id="endDate1"]
    ${infotiv_date} =  Convert Date  ${text}  result_format=%Y-%m-%d
    Should Be Equal    ${date}    ${infotiv_date}
    Click Element  id:unBook1
    Handle Alert
    Wait Until Page Contains  has been Returned

