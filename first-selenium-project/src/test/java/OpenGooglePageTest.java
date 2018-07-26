import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGooglePageTest {
    FirefoxDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();


    }
   @Test
    public void testOpeningGooglePage(){
       //driver.get("https://www.google.com/");  // команда для открытия страницы
driver.navigate().to("https://www.google.com/");  // команда для открытия страницы
driver.findElement(By.name("q")).sendKeys("Webdriver");
   }

   @Test
public void testOpeningTrello(){
        driver.navigate().to("https://trello.com/");
        driver.findElementByXPath("//*[@href='/login']").click();
   
    }


   @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);   // пишем только цифры, без milles
        driver.quit();
   }
}
