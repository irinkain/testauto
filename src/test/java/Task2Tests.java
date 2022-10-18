import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task2Tests {

    WebDriver driver;
    WebDriverWait wait;

    public Task2Tests() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void progressBar(){
        driver.navigate().to("https://demoqa.com/progress-bar");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedText="100%";
        WebElement startBtn = driver.findElement(By.id("startStopButton"));
        WebElement progressBar = driver.findElement(By.xpath("//*[@id=\"progressBar\"]/div"));
        startBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElement(progressBar, expectedText));
        if (progressBar.getText().equalsIgnoreCase(expectedText)){
            System.out.println(expectedText);
        }else {
            System.out.println("Something went wrong..");
        }
    }

    @Test
    public void radiosAndCheckboxes(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        Select language = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        language.selectByValue("JAVA");
        List<WebElement> checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement webElement : checkbox) {
            if (!webElement.isSelected()) {
                webElement.click();
            } else {
                System.out.println("Selected");
            }
        }
        List<WebElement> radioButton = driver.findElements(By.cssSelector("input[type='radio'][name='color']"));
        for(WebElement radio : radioButton) {
            if (radio.getAttribute("value").equals("purple")) {
                radio.click();
                break;
            }else{
                System.out.println("Something went wrong..");
            }
        }
        WebElement disabled = driver.findElement(By.cssSelector("option[value='orange']"));
        if (!disabled.isEnabled()) {
            System.out.println("Disabled");
        } else {
            System.out.println("Enabled");
        }
    }

    @AfterMethod
    public  void close(){
        driver.quit();
    }
}
