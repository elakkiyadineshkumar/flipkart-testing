package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Util2 extends Utils{	
//	Util2 u2 = new Util2();
public void iwait(int a) {
	driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
}
public void mouseOver(WebElement w) {
	Actions ac = new Actions(driver);
	ac.moveToElement(w).perform();
	
	//ac.moveToElement(u2.ewait(w, 10)).perform();
}
public WebElement ewait(WebElement e, int a) {
	WebDriverWait wait = new WebDriverWait(driver, a);
	return wait.until(ExpectedConditions.visibilityOf(e));
}

public void getScreenshot() {
	Date currentdate = new Date();
	String screenshotname=currentdate.toString().replace(" ", "-").replace(":", "-");
	File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshotfile, new File(screenshotname+".jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
