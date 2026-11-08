package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }  

@Test
public void testCase01() throws InterruptedException {
driver.navigate().to("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
Wrappers.implicitwait(driver, 10);
Thread.sleep(500);
Wrappers.printInconsole("Action 1 completed - Launched the Browser");
Wrappers.sendKeys(driver,By.xpath("//div[@role='listitem'][.//span[contains(text(),'Name')]]//input"),"Crio Learner");
Thread.sleep(500);
Wrappers.printInconsole("Action 2 completed - Filled 1st text");
String epochTime = Wrappers.epochTime();
Wrappers.sendKeys(driver,By.xpath("//textarea[@aria-label='Your answer']"),"I want to be the best QA Engineer! " + epochTime);
Thread.sleep(500);
Wrappers.printInconsole("Action 3 completed - Filled 2nd text");
Wrappers.radioButtons(driver, "3 - 5");
Thread.sleep(500);
Wrappers.printInconsole("Action 4 completed - Selected the Radio Button");
Wrappers.checkButtons(driver, "Java");
Wrappers.checkButtons(driver, "Selenium");
Wrappers.checkButtons(driver, "TestNG");
Thread.sleep(500);
Wrappers.printInconsole("Action 5 completed - Selected the CheckBox Button");
Wrappers.scrolldown(driver, 500);
WebElement dropdownButton = driver.findElement(By.xpath("//div[contains(@class,'KKjvXb ')]"));
Thread.sleep(500);
Wrappers.clickElement(driver,dropdownButton);
List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'OA0qNb ncFHed QXL7Te')]//span"));
Wrappers.dropdowndata(list, "Ms");
Thread.sleep(1000);
Wrappers.printInconsole("Action 6 completed - Filled the addressed");
Wrappers.date(driver, 7);
Thread.sleep(1000);
Wrappers.printInconsole("Action 7 completed - Filled the Date");
Wrappers.scrolldown(driver, 500);
Wrappers.sendKeys(driver, By.xpath("//input[@aria-label='Hour']"), "07" );
Wrappers.sendKeys(driver, By.xpath("//input[@aria-label='Minute']"), "30");
Thread.sleep(500);
Wrappers.printInconsole("Action 8 completed - Filled the Time");
WebElement submitButton = driver.findElement(By.xpath("//span[@class='NPEfkd RveJvd snByac' and contains(text(),'Submit')]"));
Wrappers.clickElement(driver,submitButton);
Thread.sleep(500);
Wrappers.successmessage(driver);
Wrappers.printInconsole("Action 9 completed - submitted and Printed the successmessage");
}

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}
