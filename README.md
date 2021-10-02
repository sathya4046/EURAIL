# EURAIL
**User Guide EURAIL SELENIUM ASSIGNMENT**

Automated the simple usecase of checking out one Adult intercountry mobile pass in interrail.eu website

Tech stack: Java Selenium Log4j Maven

**Steps to Execcute:**

1. Clone the repo and switch to the master branch
2. build the maven project
3. Run the EurailTest.java class

Note: As per the requirement, Made the script very simple and no externaal APIs or frameworks or unit test tools used.

**Details of the Project:**

**com.eurail** package has following classes:
1. **ActionUtilities.java** - Contains user action methods like Click, enter text, wait for page load, select drop down
2. **BaseDriver.java** - Singleton class to get webdriver instance
3. **EurailTest.java** - Business flow test case - run this for execution
4. **Locators.java** - locator Constants are placed here 

**src/test/resources** has following:
1. **Drivers/** - it has chromedriver.exe
2. **loginCred.properties** -  File that hold login details

**Log4j** loggin is implemeted and configuration is in **log4j2.xml** in classpath.
