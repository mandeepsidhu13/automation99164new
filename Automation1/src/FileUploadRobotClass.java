

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FileUploadRobotClass {
	public static void main(String[] args) throws AWTException, InterruptedException {
		
	

		System.setProperty("webdriver.driver.chromedriver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://sandbox.mabl.com/file-upload");
		driver.get("https://demoqa.com/upload-download");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Robot rb_object=new Robot();
		
		WebElement button_upboadfile=driver.findElement(By.id("uploadFile"));
		Actions action=new Actions(driver);
		action.moveToElement(button_upboadfile).click().build().perform();
		
		//driver.findElement(By.cssSelector("span[class='MuiButtonBase-root MuiButton-root MuiButton-outlined'] >span:nth-child(1)")).click();//click on upload button
		
	    rb_object.setAutoDelay(1000);
		StringSelection selection_obj=new StringSelection("C:\\Users\\Manpreet\\Desktop\\Seleniumhistory.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection_obj, null);
		
		rb_object.keyPress(KeyEvent.VK_CONTROL);
		rb_object.keyPress(KeyEvent.VK_V);
		
		rb_object.keyRelease(KeyEvent.VK_CONTROL);
		rb_object.keyRelease(KeyEvent.VK_V);
		
		rb_object.keyPress(KeyEvent.VK_ENTER);
		rb_object.keyRelease(KeyEvent.VK_ENTER);
				
		driver.findElement(By.id("downloadButton")).click();//click on download button
        Thread.sleep(1000);
		driver.close();
	}
}
