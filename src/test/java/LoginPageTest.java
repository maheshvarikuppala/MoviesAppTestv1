import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import pages.LoginPage;

public class LoginPageTest {

   public WebDriver driver;
   LoginPage loginPage;

   @BeforeMethod
   public void setUp(){
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://qaebank.ccbp.tech/ebank/login");
      loginPage = new LoginPage(driver);
   }

   @AfterMethod
   public void tearDown(){ driver.quit();}

   @Test
   public void testLoginPageUI(){
      Assert.assertTrue(loginPage.findLoginImgLocator().isDisplayed(),"Login image is not displayed");
      Assert.assertEquals(loginPage.findLableTextAt(0),"User ID","User id label text does not match");
      Assert.assertEquals(loginPage.findLableTextAt(1),"PIN","Pin label text does not match");
      String actualHeadingText = loginPage.findHeadingText();
      Assert.assertEquals(actualHeadingText, "Welcome Back!", "Heading text does not match");

   }

   @Test(priority = 1)
   public void testLoginWithInvalidInputs(){
      loginPage.loginToApplication("142420", "123456");
      String ActualErrorMessage = loginPage.findErrorMessage();
      Assert.assertEquals(ActualErrorMessage, "User ID and PIN didn't match", "Error text with invalid PIN do not match");
   }

   @Test(priority = 2)
   public void testLoginWithValidInputs(){
      loginPage.loginToApplication("142420", "231225");
      String expectedUrl = "https://qaebank.ccbp.tech/";
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      String actualUrl = driver.getCurrentUrl();
      Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
   }



}