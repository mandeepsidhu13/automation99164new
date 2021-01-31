

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class switchToFrameScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		TakesScreenshot scr = (TakesScreenshot) driver;
		
		
		driver.manage().window().maximize();
		driver.get("https://sandbox.mabl.com/iframes");
		waitm(3);

		driver.switchTo().frame("frame1");
		System.out.println("inside of frame 1");

		// example menu in iframe1
		WebElement example1 = driver.findElement(By.cssSelector("div.jss7 > button >span[class='MuiButton-label']"));
		System.out.println("example text is  here  " + example1.getText());

		example1.click();
		System.out.println("example is clicked");
		waitm(3);

		
		
		// screenshot
		// taking screenshot
		File scr1 = scr.getScreenshotAs(OutputType.FILE);
		// providing destination folder with file name
		File destFile1 = new File("//Users//mandeepkaur//Desktop//screenshot//a1.png");
		// copy the source file in to the destination
		Files.copy(scr1, destFile1);

		// iframe in example menu in iframe1
		WebElement examplemenuiframe = driver.findElement(
				By.cssSelector("div[id='examples-menu'] ul[class='MuiList-root MuiList-padding'] > a:nth-child(6)"));
		examplemenuiframe.click();
		waitm(3);

		driver.switchTo().frame("frame1");
		// screenshot
		File scr2 = scr.getScreenshotAs(OutputType.FILE);
		File destFile2 = new File("/Users/mandeepkaur/Desktop/screenshot/a2.png");
		Files.copy(scr2, destFile2);

		System.out.println("inside of frame1 of inside frame1");
		// example.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		System.out.println("escape key is clicked");
		
		

		waitm(5);
		// screenshot
		File scr3 = scr.getScreenshotAs(OutputType.FILE);
		File destFile3 = new File("/Users/mandeepkaur/Desktop/screenshot/a3.png");
		Files.copy(scr3, destFile3);

		waitm(3);
		
		// example menu in iframe1
		WebElement example2 = driver.findElement(By.cssSelector("div.jss7 > button >span[class='MuiButton-label']"));
		System.out.println("example text is  here  " + example2.getText());
		example2.getText();
		example2.click();
		System.out.println("example is clicked");
		waitm(3);
		// screenshot
		File scr4 = scr.getScreenshotAs(OutputType.FILE);
		File destFile4 = new File("/Users/mandeepkaur/Desktop/screenshot/a4.png");
		Files.copy(scr4, destFile4);
		
		//go back to main document
		driver.switchTo().defaultContent();

		WebElement textonmainpage = driver.findElement(By.cssSelector("div.page-content h3"));
		System.out.println("test from the main page is :" + textonmainpage.getText());
		// screenshot
		File scr5 = scr.getScreenshotAs(OutputType.FILE);
		File destFile5 = new File("/Users/mandeepkaur/Desktop/screenshot/a5.png");
		Files.copy(scr5, destFile5);

		System.out.println("success");

		driver.close();
	}

	public static void waitm(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println("interruptiopn occur");
		}
	}

}
