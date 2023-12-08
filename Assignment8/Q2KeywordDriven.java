package Assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelFileReader.DriverConnection;

public class Q2KeywordDriven {
	static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		driver = new DriverConnection().getConnection("https://www.browserstack.com/users/sign_in");

	}

	@Test(dataProvider = "dp")
	public void logintest(String EmailId, String pass) throws InterruptedException {
		String emailid = String.valueOf(EmailId);
		String pas = String.valueOf(pass);
		System.out.println(emailid + " " + pass);
		WebElement emailid1 = driver.findElement(By.xpath("//input[@id='user_email_login']"));
		emailid1.clear();
		emailid1.sendKeys(EmailId);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
		password.clear();
		password.sendKeys(pas);
		System.out.println("Pass no entered");
		Thread.sleep(2000);
//		WebElement SignIn_But = driver.findElement(By.id("user_submit"));
//		SignIn_But.click();
//		System.out.println("Signin clicked");
//		Thread.sleep(2000);
		
		WebElement LoginIn_But = driver.findElement(By.xpath("(//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/fieldset/div[9]/a)"));
		LoginIn_But.click();
		System.out.println("Login clicked");
		Thread.sleep(2000);
		
		WebElement MailId_But = driver.findElement(By.name("identifier"));
		MailId_But.sendKeys("pradhika438@gmail.com");
		System.out.println("Mailid entered");
		
		
		WebElement Next_But = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		Next_But.click();
		System.out.println("Next Button clicked");
		

		WebElement Signout_Menue = driver.findElement(By.id("account-menu-toggle"));
		Signout_Menue.click();
		System.out.println("Signout menue clicked");

		WebElement Signout_But = driver.findElement(By.id("sign_out_link"));
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
