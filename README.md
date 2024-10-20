# Automated Testing Project for Webshop

This project contains a suite of automated tests designed for practising automated testing on a webshop application. The
tests have been written in **Java** and utilize **Maven** as the build tool, **Selenium** for browser automation, and *
*JUnit 5** for running the tests.

## Project Overview

The System Under Test (SUT) is a fictional webshop that has been created to allow testers to hone their skills in
writing automated tests. The tests cover various features of the webshop, such as:

- User login and registration
- Browsing and searching for products
- Adding items to the shopping cart
- Checkout process

These tests simulate real-world user interactions to verify that the webshop behaves as expected.

SUT url: https://www.saucedemo.com/

## Tools Used

- **Java**: The programming language used to write the tests.
- **Maven**: A build automation tool that manages dependencies and simplifies the test execution process.
- **Selenium**: A framework for automating browser interactions.
- **JUnit 5**: The testing framework used to run the tests and report results.

## Prerequisites

Before running the tests, please ensure that you have the following installed:

1. **Java Development Kit (JDK)** (version 8 or later)
2. **Maven** (version 3.6.0 or later)
3. **Google Chrome** or **Firefox** (or modify the tests to suit your browser of choice)

### Optional:

- **IDE** (such as IntelliJ IDEA or Eclipse) for viewing and modifying the test code (not required to run the tests).

## How to Run the Tests

To make running the tests as simple as possible, follow these steps:

1. **Clone the repository**:
   Open a terminal or command prompt and run the following command:
   ```
    https://github.com/Tavirutyutyu/Swag-Labs-Automated-Tests.git
   ```

2. **Navigate to the project directory**:
   ```
   cd Swag-Labs-Automated-Tests
   ```

3. **Run the tests using Maven**:
   Maven will automatically handle the dependencies and run the tests for you. In the terminal, execute the following command:
   ```
   mvn clean test
   ```
   Maven will download any required dependencies and execute the tests. The results will be displayed in the terminal, showing which tests passed and which failed.

### Running Specific Tests

If you wish to run specific tests, you can specify the test class by using this command:
```
mvn -Dtest=TestClassName test
```
For example, to run the login tests:
```
mvn -Dtest=LoginTests test
```

## Test Results

After the tests have been executed, Maven will generate a test report that can be found in the following directory:
```
/target/surefire-reports/
```
You can open these reports to view detailed results of each test run, including which tests passed, failed, or were skipped.

## Troubleshooting

- If Maven fails to download dependencies or run the tests, ensure that you have a stable internet connection.
- Ensure that the correct version of the browser (Chrome or Firefox) is installed.
- If a test fails due to browser updates, you may need to update your WebDriver (ChromeDriver or GeckoDriver) by downloading the latest version.

## Conclusion

This project serves as a simple, yet practical exercise in automated testing. Feel free to explore the test code, modify it, or extend it with additional test cases to further your skills.
