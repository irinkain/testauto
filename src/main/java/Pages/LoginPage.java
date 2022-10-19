package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver = new ChromeDriver();
    public WebElement userName = driver.findElement(By.id("userName")),
            password = driver.findElement(By.id("password")),
            loginButton = driver.findElement(By.id("login")),
            logout = driver.findElement(By.id("submit")),
            gotoButton = driver.findElement(By.id("gotoStore")),
            rows = driver.findElement(By.className("rt-tbody")),
            pocketGuide = driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")),
            title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/label")),
            addButton = driver.findElement(By.id("addNewRecordButton"));
}
