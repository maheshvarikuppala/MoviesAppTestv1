package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By getLoginImgElement = By.className("login-ebank-image");
    By getHeadingText = By.className("login-heading");
    By getLabelTextAt = By.className("input-label");
    By getUserId = By.id("userIdInput");
    By getUserPin = By.id("pinInput");
    By getErrorMessage = By.className("login-button");
    By getLoginButton = By.className("error-message-text");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findLoginImgLocator(){return driver.findElement(getLoginImgElement);}
    public String findHeadingText(){return driver.findElement(getHeadingText).getText();}
    public String findLableTextAt(int index){return driver.findElements(getLabelTextAt).get(index).getText();}
    public void findUserId(String userId){driver.findElement(getUserId).sendKeys(userId);}
    public void findUserPin(String pin){driver.findElement(getUserPin).sendKeys(pin);}
    public void findLoginButton(){driver.findElement(getLoginButton);}

    public void loginToApplication(String userId, String pin){
        findUserId(userId);
        findUserPin(pin);
        findLoginButton();
    }

    public String findErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getErrorMessage)).getText();

    }


}