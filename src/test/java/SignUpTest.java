import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest {


    @Test
    public void zipCodeShouldAccept5Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.cssSelector("[value=Register]")).isDisplayed());
        driver.quit();

    }

    @Test
    public void zipCodeShouldAccept6Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. ZIP code should have 5 digits')]")).isDisplayed());
        driver.quit();

    }

    @Test
    public void zipCodeShouldAccept4Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. ZIP code should have 5 digits')]")).isDisplayed());
        driver.quit();

    }

}
