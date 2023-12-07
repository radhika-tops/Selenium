package Assessment2Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.DriverConnection;

public class Q3 {
	public static void main(String[] args) throws InterruptedException {

		String url = "https://demoqa.com/webtables";
		WebDriver driver= new DriverConnection().getConnection("https://demoqa.com/webtables");
		WebElement ele = driver.findElement(By.id("edit-record-1"));
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
		Thread.sleep(2000);
		

		WebElement ele1 =driver.findElement(By.id("edit-record-2"));
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("edit-record-3")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("delete-record-1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("delete-record-2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("delete-record-3")).click();
}
}
