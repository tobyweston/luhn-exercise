# The Luhn Algorithm

## The Brief

You are required to produce a solution to perform credit card validation according to the Luhn algorithm below.  This will be used for web-based validations and therefore should be tolerant of edge conditions and invalid data scenarios which can be exhibited on a website.  In addition, it is required to support the entry of credit card numbers both with spaces and without spaces and to validate each of these appropriately.

A couple of additional descriptions are avilable at [Wikipedia](https://en.wikipedia.org/wiki/Luhn_algorithm) and [Geeks for Geeks](https://www.geeksforgeeks.org/luhn-algorithm/).

## The Luhn Algorithm

The formula verifies a number against its included check-digit, which is usually appended to a partial account number to generate the full account number. This account number must pass the following test:

1. Counting from the check digit, which is the rightmost, and moving left, double the value of every second digit.
2. Sum the _individual_ digits of the products together with the un-doubled digits from the original number.
3. If the total ends in 0 (put another way, if the total modulo 10 is congruent to 0), then the number is valid
according to the Luhn formula; else it is not valid.

### Example

As an illustration, if the account number is 49927398716, it will be validated as follows:

1. Double every second digit, from the rightmost digit:      
    
    ```
    account number   :   4  9  9  2  7  3  9  8  7  1  6 
    double every 2nd :     18     4     6    16     2      
    ```
    
2. Sum all products from Step 1 (treating any double figure products as individual digits):  

    ```
    account number   :   4  9  9  2  7  3  9  8  7  1  6 
    products         :     18     4     6    16     2      
    add >10s         :      9                 7     2      
    digits to sum    :   4  9  9  4  7  6  9  7  7  2
    ```

   _NB. This step can be combined with the next._

3. Add to the sum of the remaining digits (inc check digit):

    ```
    digits to sum    :   4  9  9  4  7  6  9  7  7  2  6      
    ```
    `6 + (2) + 7 + (1 + 6) + 9 + (6) + 7 + (4) + 9 + (1 + 8) + 4 = 70`
    
4. Take the sum modulo 10: `70 mod 10 = 0`; the account number is **valid**.


## Things that we value

The code that you produce will be reviewed by a number of senior (seasoned) engineers.  Things we value include:
 - simple, elegant code that reads like a narrative
 - thinking about the code more than the writing of the code (we spend a lot of time thinking/debating about what we are writing)
 - transparency and feedback to support continuous learning
 - excellent testing that acts as documentation
 - challenging boundaries and norms where necessary ... do not accept the status quo

## Approach

This repository contains a skeletal solution including an interface, exception and empty test class which you may use if you wish.  If you prefer not to use Java, that's fine: any programming / scripting language is acceptable.  If you are not familiar with any programming / scripting language then please use pseudo-code.


## Importing into your IDE

We are assuming that you will not have Gradle installed so this repository uses gradle wrapper scripts.  If you wish to please feel free to install Gradle locally.

1. Clone this repo from github to your local machine
1. From the command line type `gradlew.bat` or `./gradlew` to download dependencies and check the build is OKk
1. From IntelliJ "open" the project using the `build.gradle` file
1. Select to use the gradle wrapper and auto create folder, etc.
1. Once opened, start with a test
