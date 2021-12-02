import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selfTest {
	@Test
	public void incorrectUsername() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith1");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		driver.findElement(By.className("radius")).click();

		WebElement failureMessage = driver.findElement(By.id("flash"));
		String expectedMessage = "Your username is invalid!";
		String actualMessage = failureMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		driver.close();
	}
}
