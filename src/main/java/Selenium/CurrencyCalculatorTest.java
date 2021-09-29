package Selenium;

import java.io.File;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CurrencyCalculatorTest {

	public static void main(String[] args) {
		/* Run test for Calculator.com */
		testCurrencyCalculate();
	}

	private static void testCurrencyCalculate() {

		/*
		 * This test is designed to reach calculator.com, access the currency
		 * calculator, and collect the conversions of a variety of currencies of a given
		 * amount of USD. One currency will be randomly selected from the drop down menu
		 * and stored in the randomCurrency variable. The remaining provided currencies
		 * have their own variables that will store their respective amounts.
		 */

		/* Variables */
		double amountDollar = 2277.99; // Amount of USD that will be converted (input any value >= 0)
		double amountPound = 0; // UK currency
		double amountYen = 0; // Japanese currency
		double amountEuro = 0; // European Union currency
		double amountYuan = 0; // Chinese currency
		double amountRandomCurrency = 0; // Randomly selected currency

		WebDriver driver = setupDriver(); // Initialize Chrome WebDriver

		/* Access Calculator.com */
		driver.get("https://calculator.com");
		System.out.println("Webpage Title: " + driver.getTitle());

		/* Validate if landed on Calculator.com */
		System.out.println("Current URL: " + driver.getCurrentUrl());

		/* Access currency calculator page */
		driver.findElement(By.linkText("Currency calculator")).click();

		/* Input USD to conversion textbox */
		driver.findElement(By.name("amountUS")).clear(); // empty the text box
		driver.findElement(By.name("amountUS")).sendKeys(String.valueOf(amountDollar)); // Sends the USD amount to the textbox
		int randomNum = genNumber(); // Generate random number

		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys(String.valueOf(randomNum));

		/* Selects a random currency from the drop down list */
		Select select = new Select(driver.findElement(By.name("to")));
		randomNum = ThreadLocalRandom.current().nextInt(5, 38 + 1); // Randomly chooses an index from 5 to 38, inclusively
		select.selectByIndex(randomNum); // selects a random index
		WebElement element = select.getFirstSelectedOption(); // Stores index choice in web element
		String randCurrencyName = element.getText(); // Retrieves data from the web element
		driver.findElement(By.className("text-center")).click(); // Clicks the calculate button

		/* Retrieve and store data from textboxes */
		amountPound = Double.parseDouble(driver.findElement(By.name("UKP")).getAttribute("value"));
		amountYen = Double.parseDouble(driver.findElement(By.name("JY")).getAttribute("value"));
		amountEuro = Double.parseDouble(driver.findElement(By.name("EU")).getAttribute("value"));
		amountYuan = Double.parseDouble(driver.findElement(By.name("CN")).getAttribute("value"));
		amountRandomCurrency = Double.parseDouble(driver.findElement(By.name("amountout")).getAttribute("value"));

		/* Format currency */
		String outputDollar = formatCurrency(amountDollar);
		String outputPound = formatCurrency(amountPound);
		String outputYen = formatCurrency(amountYen);
		String outputEuro = formatCurrency(amountEuro);
		String outputYuan = formatCurrency(amountYuan);
		String outputtRandomCurrency = formatCurrency(amountRandomCurrency);

		/* Print data */
		System.out.println("\nCurrency Conversions: ");
		System.out.println("USD: \t\t\t" + outputDollar + 
				"\nPound: \t\t\t" + outputPound + 
				"\nYen: \t\t\t" + outputYen + 
				"\nEuro: \t\t\t" + outputEuro + 
				"\nYuan: \t\t\t" + outputYuan + 
				"\n" + randCurrencyName + ": \t\t" + outputtRandomCurrency);

		tearDown(driver);
	}

	private static WebDriver setupDriver() {
		/* Initialize ChromeDriver */
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		
		File ublockFile = new File("src\\main\\resources\\ublock_1_37_2_0.crx");
		String ublockAbsolutePath = ublockFile.getAbsolutePath();
		if (ublockFile.exists()) {
			options.addExtensions(new File(ublockAbsolutePath)); // Adds Ublock Origin extension
		} else {
			System.out.println("Ublock Origin plugin is missing.");
			System.exit(0); // Terminates program if Ublock is not found
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		return driver;
	}

	private static void tearDown(WebDriver driver) {
		driver.quit();
	}

	private static String formatCurrency(double currency) {
		String result = new DecimalFormat("#,###.00").format(currency);

		return result;
	}
	
	private static int genNumber() {
		int randomNum = 0;
		
		/* Generate a random number for USD amount for the second conversion */
		int max = 10000;
		int min = 100;
		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return randomNum;
	}
}
