import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAlert2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();
		

driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		
		Thread.sleep(5000);
		
		
	driver.findElement(By.cssSelector("div[id='content'] > p:nth-child(5) > button")).click();
		System.out.println("alert btn found");
		//Thread.sleep(500);
		//alertbtn1.click();
		System.out.println("alert btn clicked");
		//Thread.sleep(500);
		
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		
		
		WebElement alertbtn2=driver.findElement(By.cssSelector("button[onclick=\"pushConfirm()\"]"));
		alertbtn2.click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		
		
		
		
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript(
//				"document.querySelectorAll(' ')[0].scrollIntoView()");
		driver.close();
		
	}
}


		
		