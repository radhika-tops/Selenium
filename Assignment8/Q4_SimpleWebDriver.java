package Assignment8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q4_SimpleWebDriver {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\baps\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome opened");
		
		
		
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\baps\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	      WebDriver driver1 = new EdgeDriver();
	      driver1.manage().window().maximize();
	      System.out.println("Edge opened");
	
	      
	      System.setProperty("webdriver.gecko.driver", "C:\\Users\\baps\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	      WebDriver driver2 = new FirefoxDriver();
	      driver.manage().window().maximize();
	      System.out.println("Firefox opened");
	  


}
}