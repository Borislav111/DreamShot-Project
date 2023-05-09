# DreamShot-Project

This project uses Selenium WebDriver with Java to complete a task provided by Dreamshot.
The project is related to the website 'https://mind-wend-913065.framer.app/' and uses the page object model and page factory.
Each page that appears in the test cases is separated into a separate class in the 'pages' folder.
There are eight automated test cases for validating the website, which are located in the 'tests' folder:

1. Does display product's currency symbol as '$' in the 'Pricing' page -- testCaseOne
2. Does contain 4 questions in the FAQ section from 'Pricing' page -- testCaseTwo
3. Does display 'Visit' button on each card in the 'Many types of components to customize' section -- testCaseThree
4. Does display 'Sign Up' button's color as 'rgb(255,82,79) -- testCaseFour
5. Does blur the background after clicking 'Get the app' button -- testCaseFive
6. Does display the 'Updates' page after clicking the 'Update' button -- testCaseSix
7. Does display the 'get the app' and 'watch video' one above the other in mobile -- testCaseSeven
8. Does display the 3d animation after clicking on 'click to view in 3d' button -- testCaseEight

In addition to these test cases, the project contains an additional six, which are located in the 'tests/PersonalTestCases' folder.
These are the implementation of the test cases I have written in the text file 'testCases.txt', with all of them automated except for the first one.

Note: Due to the lack of product specifications, the expected results of the test cases defined by me are based on common sense.

The project also contains a text file - 'bugs.txt', which contains logged bugs.

The test cases I have defined identify bugs based on my understanding of the product's expected behavior:

invalidSignUp - checks if the input fields have the correct validation for an invalid login - there is no bug

openLoginFromComponentPage - checks if we can open the login form from the 'get the app' button located on the 'Components' page - there is a bug here,
described as 'DS-06'

signUpButtonAfterLogin - checks if the 'Sign Up' button disappears from the header after successful login - there is a bug here, described as 'DS-05'

subscribeToNewsLetter - this test checks if the subscription for the newsletter is successful,
expecting the button to change its text - there is a bug present here, described as 'DS-03'

verifyLearnMorePage - this test checks if we can click the 'Learn more' button from the home page and expect it to take us to the respective page
- there is another bug here, described as 'DS-04'

watchVideoTestCase - checks if we can click the 'Watch video' button from the home page and expect the URL to change 
- there is a bug present here as well, described as 'DS-02'

Bug with id - 'DS-01' is described in detail in the 'bugs.txt' file, where the other bugs are also located.
