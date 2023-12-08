package Assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelFileReader.DriverConnection;

public class Q3HybridDriven {
	static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new DriverConnection().getConnection("https://app.bugbug.io/sign-up");

	}

	@Test(dataProvider = "dp")
	public void logintest(String EmailId, String pass) throws InterruptedException {

		WebElement Signin_But = driver.findElement(By.linkText("Sign in"));
		Signin_But.click();
		System.out.println("clicked on signin");
		Thread.sleep(3000);
			
		String emailid = String.valueOf(EmailId);
		String pas = String.valueOf(pass);
		System.out.println(emailid + " " + pass);
		WebElement emailid1 = driver.findElement(By.name("email"));
		emailid1.clear();
		emailid1.sendKeys(EmailId);
			
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(pas);
		System.out.println("Pass no entered");
		Thread.sleep(2000);
			
			
		WebElement SignIn_But = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/form/button"));
		 SignIn_But.click();
		System.out.println("clicked on Sign in button");
		Thread.sleep(7000);
			
		WebElement Continue_But = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/button/div/div[3]"));
		 Continue_But.click();
		System.out.println("clicked on Continue button");
		Thread.sleep(4000);

		WebElement Signout_Menue = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/nav/ul/li[3]/div/button/div/svg"));
		Signout_Menue.click();
		System.out.println("Signout menue clicked");

		WebElement Signout_But = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/div/button[6]"));
		Signout_But.click();
		System.out.println("Signout Button clicked");
	}

	@DataProvider(name = "dp")
	public Object[][] data() {
		Q1ExcelFileReader ex = new Q1ExcelFileReader("C:\\Users\\baps\\Desktop\\SSTASKING\\Q2.xlsx", "Keyword");
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
