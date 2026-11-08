package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;


public class Wrappers {

    public static void implicitwait(WebDriver driver, int duration) {
        try {
            driver.manage().timeouts()
                  .implicitlyWait(Duration.ofSeconds(duration));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrolldown(WebDriver driver, int pixels) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, " + pixels + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeys(WebDriver driver, By locator, String text) {
        try {
            WebElement data = driver.findElement(locator);
            data.clear();
            data.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public static String epochTime() {
    try {
        long epochTime = System.currentTimeMillis() / 1000;
        return String.valueOf(epochTime);
    } catch (Exception e) {
        e.printStackTrace();
        return "";
    }
}

public static void radioButtons (ChromeDriver driver, String radioButtondata) {
try{
    WebElement element = driver.findElement(By.xpath("//span[@dir='auto' and contains(normalize-space(.), '" + radioButtondata + "')]"));
    element.click();
}
catch (Exception e) {
        e.printStackTrace();
}
}

public static void checkButtons (ChromeDriver driver, String checkButtondata) {
try{
    WebElement element = driver.findElement(By.xpath("//span[@dir='auto' and contains(normalize-space(.), '" + checkButtondata + "')]"));
    element.click();
}
catch (Exception e) {
        e.printStackTrace();
}
}


public static void dropdowndata (List<WebElement> elements, String Text){
    try{
        for(WebElement element: elements){
if (element.getText().equals(Text)){
    element.click();
break;
}
 }   
}
catch (Exception e) {
        e.printStackTrace();
}
}


 public static void clickElement (ChromeDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


public static void date(ChromeDriver driver, int noOfDaysBefore){
    try{
        LocalDate mydate = LocalDate.now().minusDays(noOfDaysBefore);
           String criodateformat = mydate.format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
           sendKeys(driver, By.xpath("//input[@type='date']"), criodateformat );
    }
     catch (Exception e) {
            e.printStackTrace();
        }
}

public static void successmessage (WebDriver driver ){
    try{
        WebElement message1 = driver.findElement(By.xpath("//div[@class='vHW8K']"));
String actualMessage = message1.getText();

if (actualMessage.equalsIgnoreCase("Thanks for your response, Automation Wizard!")){
    System.out.println(actualMessage);
}else {
    System.out.println("Failed, Message is not matching with screen message");
}

WebElement message2 = driver.findElement(By.xpath("//a[contains(text(),'Submit another response')]"));
String actualText = message2.getText();

if (actualText.equalsIgnoreCase("Submit another response")){
    System.out.println(actualText);
}else {
    System.out.println("Failed, Message is not matching with screen message ");
}
    }
    catch (Exception e) {
            e.printStackTrace();
        }
}

public static void printInconsole(String Text){
try{
    System.out.println(Text);
} catch (Exception e) {
            e.printStackTrace();
        }
}

}
