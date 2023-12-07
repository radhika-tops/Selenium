package Assessment2Selenium;



import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.selenium.DriverConnection;
// Task 1 : Write script to fill this form using selenium webdriver.
// Task 2 : Write script to take screenshot of filled form
// Note : Use Xpath , keyboard event and mouse event

public class Q1 {
	public static void getScreenshot(WebDriver driver, String path) {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);;
			System.out.println("ss taken");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException  {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\baps\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://demoqa.com/automation-practice-form");
		
		String url = "https://demoqa.com/automation-practice-form";
		WebDriver driver = new DriverConnection().getConnection(url);
		
		driver.findElement(By.id("firstName")).sendKeys("Tanvi");
		driver.findElement(By.id("lastName")).sendKeys("chauhan");
		driver.findElement(By.id("userEmail")).sendKeys("asdfj57@gmail.com");
		
		

		//keyboard event
		WebElement button = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
		
		Actions action = new Actions(driver);
		
		
		
		action.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
			.sendKeys(Keys.ARROW_RIGHT)
			.sendKeys(Keys.TAB)
			.build()
			.perform();
		
		driver.findElement(By.id("userNumber")).sendKeys("9734964400");
		
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
	//mouse event	
     WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
		
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(dob).click().build().perform();
		Thread.sleep(2000);
		

	//date selection from calendar
		WebElement months = driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		Select month = new Select(months);
		month.selectByValue("8");
		
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]")).click();
		
       driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]")).sendKeys("English");
		
		Actions action11 = new Actions(driver);
		action11.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.sendKeys(Keys.TAB)
		.build()
		.perform();
		
		
		List<WebElement> hobbies = driver.findElements(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]"));
		for(WebElement h:hobbies) {
			String name = h.getText();
			System.out.println(name);

		}
		hobbies.get(0).click();
		
		WebElement button1 = driver.findElement(By.id("uploadPicture"));
		button1.sendKeys("C:\\Users\\baps\\Downloads\\White simple student cv resume.pdf");
		
		
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Hello Selenium");
		
		
//		WebElement elee = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]"));
//		elee.click();
		

		
		Actions action111 = new Actions(driver);
		
		
		
		action111.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
			.sendKeys(Keys.ENTER)
			.build()
			.perform();
		
		Thread.sleep(2000);
		System.out.println("method called");
		getScreenshot(driver, "C:\\Users\\baps\\Downloads\\Scrreenshot\\pfssc.png");
		System.out.println("done");
		
	}
			
	}

