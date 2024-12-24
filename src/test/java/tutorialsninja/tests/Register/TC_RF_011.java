package tutorialsninja.tests.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.time.Duration;

public class TC_RF_011 {
    WebDriver driver;


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void verifyRegisterAccountByProvidingInvalidTelephoneNumber() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Duy");
        driver.findElement(By.id("input-lastname")).sendKeys("Truong");
        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("abcde");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessage = "Telephone number does not appear to be valid";
        //Testcase bị failed do web chấp nhận sđt không tồn tại, dòng Assert chỉ tượng trưng thôi
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedWarningMessage);

    }
}
