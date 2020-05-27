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
		
		// Verify error message tại 2 field: This is a required field.
		// So sánh Actual message (hàm thực thi) và Expected message: theo tài liệu yêu cầu
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		
	}
	@Test
	public void TC_02_LoginWithInvalidEmail() {
		//Mở ra trang Home
		driver.get("http://live.demoguru99.com/index.php");
		// Click vào link My account để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		// Nhập invalid email, any password
		driver.findElement(By.id("email")).sendKeys("vandinh@123");
		driver.findElement(By.id("pass")).sendKeys("van123");
		
		// Click Login button
		driver.findElement(By.id("send2")).click();
		
		// Verify error message tại field email: Please enter a valid email address. For example johndoe@domain.com.
		// So sánh Actual message (hàm thực thi) và Expected message: theo tài liệu yêu cầu
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
		@Test
		public void TC_03_LoginWithLess6CharactersPassword() {
			//Mở ra trang Home
			driver.get("http://live.demoguru99.com/index.php");
			// Click vào link My account để tới trang đăng nhập
			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
			
			// Nhập valid email, <6 characters password
			driver.findElement(By.id("email")).sendKeys("vandinh@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("va123");
			
			// Click Login button
			driver.findElement(By.id("send2")).click();
			
			// Verify error message tại field password: Please enter 6 or more characters without leading or trailing spaces.
			// So sánh Actual message (hàm thực thi) và Expected message: theo tài liệu yêu cầu
			Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
			
	}
		@Test
		public void TC_04_LoginWithIncorrectPassword() {
			//Mở ra trang Home
			driver.get("http://live.demoguru99.com/index.php");
			// Click vào link My account để tới trang đăng nhập
			driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
			
			// Nhập valid email, invalid password
			driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("va123123");
			
			// Click Login button
			driver.findElement(By.id("send2")).click();
			
			// Verify error message: Invalid login or password.
			// So sánh Actual message (hàm thực thi) và Expected message: theo tài liệu yêu cầu
			Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
			
	}
}
	
	

	