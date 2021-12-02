import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuth {
	String URL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
	String Success = "/html//div[@id='content']";
	String SuccessText = "Congratulations! You must have the proper credentials.";
	@Test
	public void auth() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement successMessage = driver.findElement(By.xpath(Success));
		successMessage.getText();
		
		Assert.assertTrue(successMessage.equals(successMessage));
		driver.quit();
	}
}
