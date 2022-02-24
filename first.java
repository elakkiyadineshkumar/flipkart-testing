package util;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Utils {

	public static WebDriver driver;
	

@BeforeTest(groups={"testwithlogin", "testwithoutlogin"})
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		Util2 u2 = new Util2();
		u2.iwait(5);
		pageactions pa =new pageactions();
		pa.discardclick();
//		List<WebElement>li = driver.findElements(By.xpath("//a"));
//		for (WebElement webElement : li) {
//			System.out.println(webElement.getAttribute("href"));
//			System.out.println(webElement.getText());
//		}
		
	}

@Test(groups="testwithlogin",dataProvider="DP", retryAnalyzer = RetryListen.class)
	public void logintoaccount(String username, String password) throws InterruptedException {
		
		Util2 u2 = new Util2(); u2.iwait(5);
		pageactions pa =new pageactions();
		pa.login();	
		Reporter.log("Test to login to account");
System.out.println("Loging to account");
		pa.logintoaccount(username, password);
		
		PageLogin pl = new PageLogin();
//		System.out.println(pl.passworderror.getText());
//		String string="Your username or password is incorrect";
//		if(string.equals(pl.passworderror.getText())) {
//			Assert.assertTrue(false);
//		}
//		CheckUsername cu = new CheckUsername();
//		System.out.println("Validating username");
//		cu.usercheckafterlogin();
		u2.iwait(5);
		Actions ac = new Actions(driver);
		ac.moveToElement(pl.mouseover);
		pl.logout.click();
		//pa.errorcheck();
		//pa.fashiongo();
	}
@Test(groups="testwithoutlogin")
public void logintopage() throws InterruptedException {
	
	//Util2 u2 = new Util2(); u2.iwait(5);
	pageactions pa =new pageactions();

	pa.fashiongo();
}

@DataProvider(name="DP")
public Object [][] dataset() {

	Object [][] dataset = new Object[2][2];
 dataset [0][0]="dineshaix7612@gmail.com";
 dataset [0][1]="Rithik@7612";
 dataset [1][0]="dineshaix7612@gmail.com";
 dataset [1][1]="Rithik@7612";
 return dataset;
	
}

@AfterTest(groups={"testwithlogin", "testwithoutlogin"})
	public void closeBrowser() {

		driver.close();
	}

	public void openurl() {

	}
@BeforeMethod(groups={"testwithlogin", "testwithoutlogin"})
	public void bfmethod() {
		System.out.println("==========================");
	}
@AfterMethod(groups={"testwithlogin", "testwithoutlogin"})
	public void afmethod() {
		System.out.println("====================");
	}

}