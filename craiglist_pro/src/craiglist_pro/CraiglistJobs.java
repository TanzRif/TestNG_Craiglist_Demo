package craiglist_pro;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CraiglistJobs {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://washingtondc.craigslist.org/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void jobs() {
		driver.findElement(By.xpath("//a[@class='jjj']")).click();
		driver.findElement(By.id("query")).sendKeys("Qa Tester");
		driver.findElement(By.xpath("//button[@class='searchbtn changed_input clickme']")).click();
	}

	public void urlCheck() {
		String url = driver.getCurrentUrl();
		System.out.println("CurrentUrl: " + url);
		if (url.contains("https://washingtondc.craigslist.org/search/jjj?query=Qa+tester")) {
			System.out.println("pass");
		}
	}

	@AfterTest
	public void done() {
		driver.navigate().back();
		driver.navigate().back();
		driver.close();

	}

}
