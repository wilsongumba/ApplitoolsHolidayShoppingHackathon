# ApplitoolsCrossBrowserTestingHackathon

## Pre-requisites:

1. Ensure you have Java JDK 11.
2. Ensure you have IntelliJ IDEA installed.
3. Ensure you have the following browsers installed is on your machine.
  * Chrome

## Steps to run this project

##option 1(With IntelliJ IDEA)
1. Git clone this repo
    * `` 
2. Open the project in IntelliJ IDEA.
3. Navigate to `TestSuites` folder, select any test suite you want to run, right click and select run(run Part1Suite first to create baseline, then run Part2Suite to view the bugs, finaly run Part3Suite to check if bugs have been fixed).
    * /Part1Suite.xml
    * /Part2Suite.xml
    * /Part3Suite.xml
            
3. Check test results for the modern tests in the applitools account dashboard.

##option 2(On the Terminal)
1. Ensure you have maven and home set.
2. Open terminal at the project root and run `mvn clean test`
3. Check test results for the modern tests in the applitools account dashboard.
