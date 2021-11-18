import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    String ZIP_URL = "https://www.sharelane.com/cgi-bin/register.py";
    String REGISTER_URL = "https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345";
    WebDriver driver;


    @BeforeTest
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterTest
    public void finish() {
        driver.quit();
    }
}
