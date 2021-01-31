

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class copyPasteDataExample {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/text-box");

		// code to copy any string 
//		String un = "abc";
//		StringSelection stringSelection = new StringSelection(un);
		StringSelection stringSelection = new StringSelection("abcd");
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		
		Actions mkb = new Actions(driver);
		WebElement username = driver.findElement(By.id("userName"));
		
		mkb.moveToElement(username);//.click().build().perform();

		// mac users --> command + v
		mkb.keyDown(username,Keys.META);
		mkb.sendKeys("v");
		mkb.keyUp(Keys.META);
		mkb.click().build().perform();
		

		//username.sendKeys(Keys.chord(Keys.META, "v"));
		// element.sendKeys("abc");

		// for windows
		// mkb.keyDown(username,Keys.META).sendKeys("v").build().perform();

		System.out.println("data copied to text box");
		System.out.println("success");
		//driver.close();
	}

}