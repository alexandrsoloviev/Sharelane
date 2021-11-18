import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends TestBase {


    @Test
    @Tag(name = "Zip Code")
    public void zipCodeShouldAccept5Digits() {
        driver.get(ZIP_URL);
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.cssSelector("[value=Register]")).isDisplayed());


    }

    @Test
    @Tag(name = "Zip Code")
    public void zipCodeShouldAccept6Digits() {
        driver.get(ZIP_URL);
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. ZIP code should have 5 digits')]")).isDisplayed());


    }

    @Test
    @Tag(name = "Zip Code")
    public void zipCodeShouldAccept4Digits() {
        driver.get(ZIP_URL);
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. ZIP code should have 5 digits')]")).isDisplayed());

    }

    @Test
    @Tag(name = "Register")
    public void inputValidData() {
        driver.get(REGISTER_URL);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("name");
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("last_name");
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("myname@gmail.com");
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Account is created!')]")).isDisplayed());

    }

    @Test
    @Tag(name = "Register")
    public void emptyFields() {
        driver.get(REGISTER_URL);
        driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. Some of your fields have inva')]")).isDisplayed());

    }

    @Test
    @Tag(name = "Register")
    public void inputIncorrectPassConfirm() {
        driver.get(REGISTER_URL);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("name");
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("last_name");
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("myname@gmail.com");
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("12345");
        driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. Some of your fields have inva')]")).isDisplayed());


    }

    @Test
    @Tag(name = "Register")
    public void inputWrongEmail() {
        driver.get(REGISTER_URL);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("name");
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("last_name");
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("myname.gmail.com");
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("12345");
        driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. Some of your fields have inva')]")).isDisplayed());
    }

    @Test
    @Tag(name = "Register")
    public void inputSpecCharInNameField() {
        driver.get(REGISTER_URL);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("@#$%");
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("last_name");
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("myname@gmail.com");
        driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("123456789");
        driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Oops, error on page. Some of your fields have inva')]")).isDisplayed());
    }


}
