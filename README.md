# The Luhn Algorithm

## The Brief

You are required to produce a solution to perform credit card validation according to the Luhn algorithm below.  This will be used for web-based validations and therefore should be tolerant of edge conditions and invalid data scenarios which can be exhibited on a website.  In addition, it is required to support the entry of credit card numbers both with spaces and without spaces and to validate each of these appropriately.

You should prove its operation through test cases.

## The Luhn Algorithm
The formula verifies a number against its included check-digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:

1. Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
2. Sum the digits of the products together with the un-doubled digits from the original number.
3. If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is valid
according to the Luhn formula; else it is not valid.

### Example
As an illustration, if the account number is 49927398716, it will be validated as follows:

1. Double every second digit, from the rightmost digit:  
    `(1*2) = 2, (8*2) = 16, (3*2) = 6, (2*2) = 4, (9*2) = 18`
2. Sum all digits (digits in parentheses are the products from Step 1):  
    `6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70`
3. Take the sum modulo 10: 70 mod 10 = 0; the account number is valid.

For the sake of stating the obvious, __please do not use your own credit cards in any of the tests__.

## Approach
This repository contains a skeletal solution including an interface, exception and empty test class which you may use if you wish.  If you prefer not to use Java, that's fine: any programming / scripting language is acceptable.  If you are not familiar with any programming / scripting language then please use pseudo-code.

## How to submit
To submit your solution, please:
1. create a fork this repository
1. make changes as you see fit then commit and push those changes to your fork
1. grant read access for your fork to the `***REMOVED*** Code Reviewers` group
1. email the URL of your fork along with any preamble you desire to `***REMOVED***`

## Things that we value
The code that you produce will be reviewed by a number of senior (seasoned) engineers.  Things we value include:
 - simple, elegant code that reads like a narrative
 - thinking about the code more than the writing of the code (we spend a lot of time thinking/debating about what we are writing)
 - transparency and feedback to support continuous learning
 - excellent testing that acts as documentation
 - challenging boundaries and norms where necessary ... do not accept the status quo

## Importing into your IDE
We are assuming that you will not have Gradle installed so this repository uses gradle wrapper scripts.  If you wish to
please feel free to install Gradle locally.

1. Clone this repo from github to your local machine
1. From the command line type `gradlew.bat` or `./gradlew` to download dependencies and check the build is OK
1. From IntelliJ "open" the project using the `build.gradle` file
1. Select to use the gradle wrapper and auto create folder, etc.
1. Once opened, start with a test

### Setting up Artifactory credentials
1. go to your `$GRADLE_USER_HOME` and create a file called `gradle.properties`
1. generate an API Key from [Artifactory](***REMOVED***)
    - click on your name (top right) and verify yourself
    - click on generate icon next to the API key section
1. add two entries to `gradle.properties`:
    - `artifactoryUsername=<your db email address>`
    - `artifactoryPassword=<API key from Artifactory>`
