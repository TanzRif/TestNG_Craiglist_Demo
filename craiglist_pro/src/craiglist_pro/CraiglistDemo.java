package craiglist_pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CraiglistDemo {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://washingtondc.craigslist.org/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void apt() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='hhh']//span[@class='txt'][contains(text(),'housing')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='dropdown dropdown-icons dropdown-arrows dropdown-view']//li[@class='dropdown-item mode sel']//span[@class='toggle-arrow']"))
				.click();
		driver.findElement(By.xpath("//button[@id='mapview']")).click();
		Thread.sleep(3000);

	}

	@Test
	public void number() {
		String text = driver.findElement(By.className("displaycountShow")).getText();
		System.out.println("serach Result : " + text);
	}

	@AfterTest
	public void doneTest() {
		driver.navigate().back();
		System.out.println("page Title: " + driver.getTitle());
		driver.close();
	}

}
