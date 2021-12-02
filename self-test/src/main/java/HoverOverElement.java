import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoverOverElement {
	String URL = "https://the-internet.herokuapp.com/hovers";
	String photo1Xpath = "/html//div[@id='content']/div/div[1]/img[@alt='User Avatar']";
	String photo2Xpath = "/html//div[@id='content']/div/div[2]/img[@alt='User Avatar']";
	String photo3Xpath = "/html//div[@id='content']/div/div[3]/img[@alt='User Avatar']";
	String subMenu1CSS = "div:nth-of-type(1) > .figcaption > a";
	String subMenu2CSS = "div:nth-of-type(2) > .figcaption > a";
	String subMenu3CSS = "div:nth-of-type(3) > .figcaption > a";
	
	@Test
	public void HoverTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		
		WebElement avatar1 = driver.findElement(By.xpath(photo1Xpath));
		WebElement avatar2 = driver.findElement(By.xpath(photo2Xpath));
		WebElement avatar3 = driver.findElement(By.xpath(photo3Xpath));
		
		
		action.moveToElement(avatar1);
		action.moveToElement(avatar2);
		action.moveToElement(avatar3);
		
		
		Boolean isPresent1 = driver.findElements(By.cssSelector(subMenu1CSS)).size() !=0;
		if(isPresent1){
			System.out.println("Element is present");
		}
		Boolean isPresent2 = driver.findElements(By.cssSelector(subMenu2CSS)).size() !=0;
		if(isPresent2){
			System.out.println("Element is present");
		}
		Boolean isPresent3 = driver.findElements(By.cssSelector(subMenu3CSS)).size() !=0;
		if(isPresent3){
			System.out.println("Element is present");
		}
		
		driver.quit();
		
	}

}
