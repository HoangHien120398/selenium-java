# Selenium Java Basic

## Setup
- Java jdk 23
- Maven
- Install Chrome/Firefox

## How to run
```shell
mvn clean test
```

## How to create test plan
[Sample Test Plan](Sample-plan.xml)

## How to write new test cases with page object model
Example:
- Define Test Class [DropDownTest](./src/test/java/internet/DropdownTest.java)
  - Test Class naming with suffix Test
- Define Page Class [DropDownPage](./src/test/java/internet/pages/DropDownPage.java)
  - Page Class naming with suffix Page

## Supports
- Selenium Owner methods