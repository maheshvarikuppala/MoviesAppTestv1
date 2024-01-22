import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest {
    public WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MYPC\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("142420", "231225");
        String expectedUrl = "https://qaebank.ccbp.tech/";
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomePageHeading(){
        Assert.assertTrue(homePage.findLogoImg().isDisplayed(), "App logo is not displayed");
        String actualHeadingText = homePage.findHeadingLocator();
        String expectedHeadingText = "Your Flexibility, Our Excellence";
        Assert.assertEquals(actualHeadingText, expectedHeadingText, "Heading text does not match");
        Assert.assertTrue(homePage.findDigitalCard().isDisplayed(),"Digital card image is not displayed");

    }

    @Test(priority = 2)
    public void testLogoutButton(){
        homePage.findLogoutButton();
        String expectedUrl = "https://qaebank.ccbp.tech/ebank/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");
    }

}
