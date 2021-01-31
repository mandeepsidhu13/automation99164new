import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	// write the automation script for login page
	// https://www.saucedemo.com/
	public static void main(String[] args) throws InterruptedException {
		// setting the path for Chrome driver
System.setProperty("webdriver.chrome.driver",
				"/Users/mandeepkaur/Library/Mobile Documents/com~apple~TextEdit/Documents/chromedriver");

		// it is opening the Chrome browser
		WebDriver driver = new ChromeDriver();
		System.out.println("broswer is opened");
		driver.manage().window().maximize();

		// going to this specified url in chrome browser
		String baseUrl = "https://www.saucedemo.com/";
		driver.get(baseUrl);
		System.out.println("broswer go to the url");
		// driver.get("https://www.saucedemo.com/");

		// browser is sleep for given time
		Thread.sleep(2000);

		// find username element
		WebElement username = driver.findElement(By.cssSelector("input#user-name"));
		// driver.findElement(By.id("user-name"));
		// send values in username element
		username.sendKeys("standard_user");
		System.out.println("username is filled");

		// browser is sleep for given time
		Thread.sleep(2000);

		// find password element and send values to that element
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		System.out.println("password is filled");
		// browser is sleep for given time
		Thread.sleep(2000);

		// find login btn and click that button
//		WebElement loginBtn=driver.findElement(By.id("login-button"));
//		loginBtn.click();

		driver.findElement(By.id("login-button")).click();
		System.out.println("login button is clicked");
		// browser is sleep for given time
		Thread.sleep(3000);

		// close the browser
		driver.close();
		System.out.println("test is passed");

	}

}
