import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckBoxes {
	String URL = "https://the-internet.herokuapp.com/checkboxes";
	String checkBox1Xpath = "//form[@id='checkboxes']/input[1]";
	String checkBox2Xpath = "//form[@id='checkboxes']/input[2]";
	@Test
	public void CheckBoxTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement checkBox1 = driver.findElement(By.xpath(checkBox1Xpath));
		WebElement checkBox2 = driver.findElement(By.xpath(checkBox2Xpath));
		System.out.println(checkBox1.isSelected());
		System.out.println(checkBox2.isSelected());
		checkBox2.click();
		System.out.println(checkBox2.isSelected());
		checkBox1.click();
		System.out.println(checkBox1.isSelected());
		driver.quit();
		
		
	}

}
