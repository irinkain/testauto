package Steps;

import Data.Constants;
import Pages.LoginPage;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Quiz1Steps {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = new ChromeDriver();

    @Step
    public Quiz1Steps login() {
        driver.get("https://demoqa.com/login");
        loginPage.userName.sendKeys(Constants.userName);
        loginPage.password.sendKeys(Constants.password);
        loginPage.loginButton.click();
        return this;
    }

    @Step
    public Quiz1Steps checkLogoutButton() {
        loginPage.logout.isDisplayed();
        return this;
    }

    @Step
    public Quiz1Steps gotoBookStore() {
        loginPage.gotoButton.click();
        return this;
    }

    @Step
    public Quiz1Steps checkRowCount() {
        List<WebElement> rows = (List<WebElement>) loginPage.rows;
        Assert.assertEquals(rows.size(),8);
        return this;
    }

    @Step
    public Quiz1Steps pocketGuide() {
        loginPage.pocketGuide.click();
        return this;
    }

    @Step
    public Quiz1Steps validateTitle(){
        Assert.assertEquals(loginPage.title.getText(),Constants.title);
        return this;
    }
    @Step
    public Quiz1Steps clickOnAdd() {
        loginPage.addButton.click();
        return this;
    }
    @Step
    public Quiz1Steps checkAlert(){
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertMessage,Constants.alertText);
        return this;
    }
    @Step
    public Quiz1Steps logout(){
        loginPage.logout.click();
        return this;
    }

}
