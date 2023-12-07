package Assessment2Selenium;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// URL : http://www.demo.guru99.com/V4/

//Task 1 : verify that test pass or fail
//Task 2 : Parameterised your script using testing and take input from excel sheet
//Task 3 : Take screenshot for Failed test cases

public class Q4DataDriven {

	static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new DriverConnection().getConnection("https://demo.guru99.com/v4/index.php");
	}

	public static void getSreenShot(WebDriver driver, String path) throws InterruptedException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			FileUtils.copyFile(source, dest);
			System.out.println("ss taken");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(dataProvider = "dp")
	public void logintest(String UserId, String Password) throws InterruptedException {

		System.out.println(UserId + " " + Password);
		WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys(UserId);
		WebElement Pass = driver.findElement(By.name("password"));
		Pass.clear();
		Pass.sendKeys(Password);
		WebElement lgn_But = driver.findElement(By.name("btnLogin"));
		Thread.sleep(2000);
		lgn_But.click();
		Thread.sleep(2000);
		getSreenShot(driver, "C:\\Users\\baps\\Desktop\\SSTASKING\\myssdm.png");
		System.out.println("ss taking");
		lgn_But.click();
		Thread.sleep(2000);
		System.out.println("SS ");

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {

		driver.close();
	}

	@DataProvider(name = "dp")
	public static Object[][] data() {
		Q4ExcelReader ex = new Q4ExcelReader("C:\\Users\\baps\\Desktop\\SSTASKING\\SS Guru99.xlsx", "Login");
		int row = ex.rowCount();
		System.out.println("row : " + row);
		int col = ex.colCount();
		System.out.println("col : " + col);
		Object obj[][] = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				String data = ex.getData(i, j);
				obj[i - 1][j] = data;
			}
		}
		return obj;

	}
}
