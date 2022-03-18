*** Settings ***
Documentation  Testing the browser "INFOTIV CAR RENTAL" and it's services focused on Date&Time
...  and being able to see the car selection list.
Resource  ../Resources/keywords.robot
Library  SeleniumLibrary
Library  DateTime
Test Setup    Begin Web Test
Test Teardown  End Web Test

*** Variables ***
${BROWSER}  headlesschrome
${URL}  http://rental9.infotiv.net/
${date} =	Get Current Date
${element_text}  Get Text
${infotiv_date}  convert into date

*** Test Cases ***
User Can Access Website And See Current Date Start
    [Documentation]  Once accessing the website; being able to see the selection of dates
    [Tags]  Time
    Go To Web Page
    Verify Page Contains
    Check Date On Page Start

User Can Access Website And See Current Date End
    [Documentation]  Once accessing the website; being able to see the selection of dates
    [Tags]  Time
    Go To Web Page
    Verify Page Contains
    Check Date On Page End


User Can Get To Car Selection Page
    [Documentation]  Once accessing the Car selection page; getting to the car selection list.
    [Tags]  Car
    Go To Web Page
    Verify Page Contains
    Go To Car List

User Can Get To Choose A Car Make In Car List
    [Documentation]  Once accessing the website; getting to choose what brand of cars
    [Tags]  Car
    Go To Web Page
    Verify Page Contains
    Go To Car List
    Selecting Car Brand In List


User Can Log In And Rent A Car
    [Documentation]  Once accessing the website; rent a car and confirm booking
    [Tags]  VG_test
    Given User Is Logged In
    When User Books Car
    And User Pays With Creditcard
    Then Car Has Been Booked


