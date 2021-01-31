import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorksWithTabs {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rbcroyalbank.com/personal.html");

		Thread.sleep(500);

		WebElement signIn = driver.findElement(By.id("header-sign-in-btn"));

		signIn.click();

		String mainWindowHandle = driver.getWindowHandle();
		// it save the id of main tab

		Thread.sleep(500);

		WebElement branchLocater = driver
				.findElement(By.cssSelector("a[title=\"Branch & ATM locator (Opens new tab)\"]"));

		branchLocater.click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		// first value => main tab
		// second value -> second tab

		String secondWindowHandle = null;
		for (String handles : allWindowHandles) {
			if (!handles.equalsIgnoreCase(mainWindowHandle)) {
				secondWindowHandle = handles;
			}
		}

		Thread.sleep(500);

		driver.switchTo().window(secondWindowHandle);

		Thread.sleep(500);

		// operations on second tab
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Rockland");
		
		Thread.sleep(5000);
		

		// done with operations on second tab
		Thread.sleep(500);
		driver.switchTo().window(mainWindowHandle);
		
		WebElement cardNumber=driver.findElement(By.id("K1"));
		cardNumber.sendKeys("7898889878");
		Thread.sleep(500);
		//driver.close();
	}

}
