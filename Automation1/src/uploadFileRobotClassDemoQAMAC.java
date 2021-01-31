

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class uploadFileRobotClassDemoQAMAC {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");
Robot robot = new Robot();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		waitm(2);

		// This will click on Browse button
		Actions mkbaction = new Actions(driver);
		mkbaction.moveToElement(driver.findElement(By.id("uploadFile"))).click().build().perform();
		waitm(2);

		robot.setAutoDelay(1000);

		// File Name
		File file = new File("/Users/mandeepkaur/Desktop/upload file/a.docx");

		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		// Cmd + Tab is needed since it launches a Java app and the browser looses focus

//		robot.keyPress(KeyEvent.VK_META);
//				 
//		robot.keyPress(KeyEvent.VK_TAB);
//		
//				 
//		robot.keyPress(KeyEvent.VK_META);	
//				 
//		
//		robot.keyRelease(KeyEvent.VK_TAB);

		robot.delay(500);

		// Open Goto window

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_SHIFT);

		robot.keyPress(KeyEvent.VK_G);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.keyRelease(KeyEvent.VK_G);

		// Paste the clipboard value

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_V);

		// Press Enter key to close the Goto window and Upload window

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		waitm(2);
		// for windows
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("file is uploaded successfully");

		// download same file

		mkbaction.moveToElement(driver.findElement(By.id("downloadButton"))).click().build().perform();
		waitm(2);

		System.out.println("file is download successfully");

		System.out.println("success");
		// driver.close();
	}

	public static void waitm(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println("interruptiopn occurr");
		}
	}

}