package tutorialsninja.tests.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonUtils;

import java.time.Duration;

public class TC_RF_005 {
    @Test
    public void verifyRegisteringAccountBySubscribingToNewsletter() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("duy");
        driver.findElement(By.id("input-lastname")).sendKeys("truong");
        driver.findElement(By.id("input-email")).sendKeys(CommonUtils.generateBrandNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());

        driver.quit();

    }
}