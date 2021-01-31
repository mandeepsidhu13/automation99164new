import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://sandbox.mabl.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#root > div.page-content > div > div > div > div:nth-child(2) > div > a:nth-child(1) > span.MuiButton-label")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#root > div.page-content > div > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-4 > button > span.MuiButton-label")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().sendKeys("ok");
//		driver.switchTo().alert().dismiss();
//	String abc=	driver.switchTo().alert().getText();
		
		
	
		
		
		
		
		Thread.sleep(2000);
		
		
		driver.close();
	}

}
