# Cura_HealthCare_CucumberProject

#Health Care Appointment Automation Project

#Introduction

This project is an automated testing suite for a Health Care Appointment demo application. Using Selenium with the Cucumber framework, Java, Maven, and JUnit, it automates various functionalities of the application, including the login process and appointment scheduling. The project is designed to generate detailed reports, log files, and screenshots, providing a comprehensive testing framework for web applications.

#Features

Automated Login Process: Supports both data-driven and non-data-driven login tests.

Appointment Test Cases: Automates various appointment scheduling scenarios.

Report Generation: Automatically generates Cucumber and Extent reports after test execution.

Log Files: Creates log files in the log folder to track test execution details.

Screenshot Capture: Captures screenshots on test failures for better debugging.

#Software and Tools

Java

Maven

Selenium

Cucumber Framework

JUnit

#Project Structure

src/test/java: Contains the test Java files.

src/test/resources: Contains test resource files

log: Directory where log files are generated.

reports: Directory where test reports are generated.

screenshots: Directory where screenshots are saved in case of test failures.

#How to Run the Project

There are multiple ways to execute the tests in this project:

#Using POM.XML File:

Navigate to the project directory and run mvn test.

#Using TestRunner Class:

xecute the TestRunner class directly from your IDE.

#Parallel or Cross-Browser Execution (Locally):

Uncomment the configuration tag in the POM.XML file.

Run the tests using Maven or POM.XML.

#Remotely Using Selenium Grid:

Set execution_env=remote in the info.properties file.

Ensure your Selenium Grid hub and nodes are set up and running.

Execute the tests as described above.

#Using Jenkins:

Pull the code from the repository.

Set up a Jenkins job to run the tests using the Maven build tool.

#Using the Provided BAT File:

Ensure Maven is installed on your machine.

Run the .bat file provided in the project directory.

#Requirements

Java (JDK 8 or higher)

Maven

Selenium

Cucumber

JUnit

A web browser (e.g., Chrome, Firefox)

#Configuration

info.properties: Contains configuration settings for the project, including the environment (local or remote).
POM.XML: Maven configuration file with dependencies and plugins.

#Reporting and Logs

Cucumber Report: Automatically generated after test execution, providing detailed insights into the test scenarios.

Extent Report: A comprehensive report with graphical representation of the test results.

Log Files: Located in the log folder, capturing detailed execution logs.

Screenshots: Saved in the screenshots folder for failed test cases.

#Conclusion
This project provides a robust framework for automating Health Care Appointment scenarios. With detailed reporting, logging, and various execution options, it is a valuable tool for ensuring the quality and reliability of web applications.

Thank you, and happy testing!
