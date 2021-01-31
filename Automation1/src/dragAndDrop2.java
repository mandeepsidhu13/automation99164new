import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
		
		Thread.sleep(6000);

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=\"demo-frame lazyloaded\"]")));
		
		
		
		Thread.sleep(6000);
		
		WebElement source= driver.findElement(By.cssSelector("#gallery > li:nth-child(1) > img"));
		
		Thread.sleep(1000);
		
		WebElement destination= driver.findElement(By.id("trash"));
		
		Thread.sleep(1000);
		
		
		Actions mkb= new Actions(driver);
		
		//ist way using direct function
		mkb.dragAndDrop(source, destination).build().perform();
		
		Thread.sleep(2000);
		
//		// 2nd Way 
//		
//		mkb.moveToElement(source).build().perform();
//		
//		mkb.clickAndHold().build().perform();
//		
//		mkb.moveToElement(destination).build().perform();
//		
//		mkb.release().build().perform();
//		
//		Thread.sleep(2000);
		
		//driver.close();

	}
}
