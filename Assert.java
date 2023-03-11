package launchGoogle;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assert {
	
	public WebDriver driver;
	
	SoftAssert softassert = new SoftAssert(); 
	
	@BeforeTest
	public void setBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void closeBrowser()throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test(priority = 1)
	public void title()
	{
		String title = driver.getTitle();
		System.out.println("Title : " + title);
		softassert.assertEquals(false, true);
		
		
		String url = driver.getCurrentUrl();
		System.out.println("CurrentURL : " + url);
		softassert.assertEquals(true, false);
		
		driver.findElement(By.xpath("//*[@id='nav-main']/div[2]/div/div/a[1]")).sendKeys(Keys.ENTER);
		softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void url()
	{
		String url = driver.getCurrentUrl();
		System.out.println("CurrentURL : " + url);
		assertEquals(true, true);
		softassert.assertAll();
	}
	
	@Test(priority = 3, expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
	public void click()
	{
		driver.findElement(By.xpath("//*[@id='nav-main']/div[2]/div/a[1]")).click();
	}

	@Test(priority = 5, expectedExceptions = ArithmeticException.class)
	public void exception()
	{
		int s = 1/0;
		System.out.println(s);
	}
	
	

}
