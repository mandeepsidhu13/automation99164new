import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class scrollWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.litmos.com/trial");
		driver.manage().window().maximize();

		WebElement firstname = driver.findElement(By.id("input_4_1"));
		firstname.sendKeys("Xyz");

		WebElement lastname = driver.findElement(By.id("input_4_3"));
		lastname.sendKeys("PQR");

		Thread.sleep(1000);

		Select industry = new Select(driver.findElement(By.id("input_4_28_1")));
	
		industry.selectByValue("Z17");
		
		Thread.sleep(4000);
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelectorAll('input[id=\"gform_submit_button_4\"]')[0].scrollIntoView()");
		Thread.sleep(1000);

		WebElement submitbtn = driver.findElement(By.cssSelector("input[id=\"gform_submit_button_4\"]"));
		Thread.sleep(1000);
		submitbtn.click();
		Thread.sleep(1000);

		driver.close();

	}

}
