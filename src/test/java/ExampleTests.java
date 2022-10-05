import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTests {

    @Test
    public void firstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//ul/li/a"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        Assert.assertEquals(text.getText(),"No Test");

        driver.navigate().back();
        WebElement dropdown= driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a"));
        dropdown.click();
        WebElement selectOne = driver.findElement(By.id("dropdown"));
        Select select = new Select(selectOne);
        select.selectByIndex(0);
        driver.close();
    }
}
