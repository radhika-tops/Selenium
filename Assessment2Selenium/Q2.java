package Assessment2Selenium;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.DriverConnection;

public class Q2 {
	public static void main(String[] args) throws ParseException {
	String url = "https://www.techlistic.com/p/demo-selenium-practice.html";
	WebDriver driver = new DriverConnection().getConnection(url);
	
	//scroll
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,850)");

	System.out.println("Q1. Verify that there are only 4 structure values present in the table with Selenium");
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
	//to print row size
	System.out.println("row size:"+rows.size());
	
	System.out.println();
	List<WebElement> col = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));
	System.out.println("col size:"+col.size());
	
	
	
	for(int i=0;i<=rows.size();i++) {    
	// driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td"));
	 
	 
	
	//to print data from table
		//1. Verify that there are only 4 structure values present in the table with Selenium
	for(int j=1;j<=col.size();j++)	{
		List<WebElement> data = driver.findElements(By.xpath("(//tbody)[2]/tr["+i+"]/th["+j+"]"));
		List<WebElement> data1 = driver.findElements(By.xpath("(//tbody)[2]/tr["+i+"]/td["+j+"]"));
		for(WebElement d: data) {
			System.out.print(d.getText()+"|| ");
		}
		for(WebElement d: data1) {
			System.out.print(d.getText()+"|| ");
		}

	}
	System.out.println();
   
	}
	//Verify that the 6th row of the table (Last Row) has only two columns with Selenium
			//*[@id="post-body-1325137018292710854"]/div[1]/div[1]/div[5]/table/tfoot
	System.out.println();
	System.out.println("Q2. Verify that the 6th row of the table (Last Row) has only two columns with Selenium");
	System.out.println();
	List<WebElement> last_row = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/th"));
	List<WebElement> last_row1 = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/td"));
	System.out.println("last_row has: " +last_row.size() + "col");
	System.out.println("last_row1 has: " +last_row1.size() + "col");
	System.out.println(last_row.size() + last_row1.size());
	for(int i=0;i<=rows.size();i++) {
 
		List<WebElement> data3 = driver.findElements(By.xpath("//*[@id=\"post-body-1325137018292710854\"]/div[1]/div[1]/div[5]/table/tfoot/tr["+i+"]"));

		for(WebElement d: data3) {
			System.out.print(d.getText()+"|| ");
		}
		System.out.println();
	}
	
	//Find the tallest structure in the table with Selenium
	System.out.println();
	System.out.println("Q3. Find the tallest structure in the table with Selenium");
	System.out.println();

	
	
	String row = "//table[@class='tsc_table_s13']/tbody/tr";
	int rowData = driver.findElements(By.xpath(row)).size();
	
	WebElement currentPrice = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[\"+i+\"]/td[3]"));
	
	String firstPart ="//table[@class='tsc_table_s13']/tbody/tr[";
	String secondPart = "]/td[3]";
	ArrayList<Integer> array = new ArrayList<Integer>();
	
	for(int i=1; i<=rowData; i++) {
		String finalPart = firstPart+i+secondPart;
		String height = driver.findElement(By.xpath(finalPart)).getText();

		
		String tallestStructure = " ";

		tallestStructure = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th[1]")).getText();

		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		Number num = numberFormat.parse(height);
		System.out.println("tallest structure in the table is " + tallestStructure + " :" +height);
		Double m = Double.parseDouble(height);
		int intheight =m.intValue();
		array.add(intheight);
	}

	}
}
	
