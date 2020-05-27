package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Technical_Ex_Part1 {
	WebDriver driver;

	@BeforeClass
	// Chạy trước mỗi testcase bên dưới
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	// Topic 04/05 Xpath Exercise - Write Testcase 1-4
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		//Mở ra trang Home
		driver.get("http://live.demoguru99.com/index.php");
		// Click vào link My account để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		// Để trống Username/ Password
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		
		// Click Login button
		driver.findElement(By.id("send2")).click();
		
		// Verify error message tại 2 field: This is a required field
		// So sánh Actual message (hàm thực thi) và Expected message: theo tài liệu yêu cầu
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		
	}
}
	
	

	