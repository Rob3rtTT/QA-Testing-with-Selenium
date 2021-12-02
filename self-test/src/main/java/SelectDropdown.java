import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropdown {
	String URL = "https://the-internet.herokuapp.com/dropdown";
	String dropDown = "/html//select[@id='dropdown']";
	String dropDownText1 = "Please select an option";
	@Test
	public void DropDownTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement dropDownMenu = driver.findElement(By.xpath(dropDown));
		Select select = new Select(dropDownMenu);
		sleep(300);
		select.selectByValue("1");
		sleep(300);
		select.selectByVisibleText("Option 2");
		sleep(300);
		driver.quit();
	}
	private void sleep(long m) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
