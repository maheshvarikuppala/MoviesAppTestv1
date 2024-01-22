package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    By getLogoImg = By.className("ebank-logo");
    By getHeadingElement = By.className("heading");
    By getDigitalCard = By.className("digital-card-image");
    By getLogoutButton = By.className("logout-button");


    WebDriver driver;

    public HomePage(WebDriver driver){this.driver = driver;}
    public WebElement findLogoImg(){return driver.findElement(getLogoImg);}
    public String findHeadingLocator() {return  driver.findElement(getHeadingElement).getText();}
    public WebElement findDigitalCard() {return driver.findElement(getDigitalCard);}
    public void findLogoutButton() {driver.findElement(getLogoutButton).getText();}


}
