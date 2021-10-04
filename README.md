<!-- Title -->
# CurrencyCalculator-Test

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#purpose">Purpose</a></li>
        <li><a href="#setup-and-execute">Setup and Execute</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This mini-project was designed with the sole intent of practicing Selenium by accessing a public website and providing and retrieving data.

### Built With

- Java,

- [Selenium](https://github.com/SeleniumHQ/selenium),

- [Selenium WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

### Purpose

This project intializes Chrome WebDriver with Ublock Origin and attempts to access [Calculator.com](https://calculator.com). From there, it begins by navigating to the currency conversion calculator webpage and identifying the currency USD textbox element. Afterwards, it provides a random value which in turn is converted to various currencies. The data is then retrieved from the page and printed to console.

### Setup and Execute

- Install and setup [JDK](https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows).
- Install and setup [Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac#installing-maven-on-windows).
- Download the repository to your computer and store it in a folder.
- Unzip the file.
- Navigate to the `CurrencyCalculator-Test-main` folder via the command prompt.
- Enter: `mvn package` into the command prompt (The project should successfully build).
- To execute the program enter: `java -jar target\SeleniumCurrencyCalculator-execute.jar`

## Contact

Zacharia Gilbert

[![LinkedIn][linkedin-shield]][linkedin-url]

Project Link: [https://github.com/zach-gilbert/CurrencyCalculator-Test](https://github.com/zach-gilbert/CurrencyCalculator-Test)




<!-- MARKDOWN LINKS & IMAGES -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/gilbertzacharia
