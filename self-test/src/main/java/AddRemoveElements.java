import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddRemoveElements {
	
	
	String URL = "https://the-internet.herokuapp.com/add_remove_elements/";
	String addElementCSS = "div#content > div > button";
	String deleteElementCSS = "//div[@id='elements']/button[4]";
	String deleteElementCSS2 = "//div[@id='elements']/button[3]";
	String deleteElementCSS3 = "//div[@id='elements']/button[2]";
	String deleteElementCSS4 = "//div[@id='elements']/button[1]";
	
	@Test
	public void addElement(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		
		WebElement addButton = driver.findElement(By.cssSelector(addElementCSS));
		for (int i=0; i<4; i++) {
			addButton.click();
		}
		sleep(300);
		WebElement removeButton = driver.findElement(By.xpath(deleteElementCSS));
		removeButton.click();
		sleep(300);
		WebElement removeButton2 = driver.findElement(By.xpath(deleteElementCSS2));
		removeButton2.click();
		sleep(300);
		WebElement removeButton3 = driver.findElement(By.xpath(deleteElementCSS3));
		removeButton3.click();
		sleep(300);
		WebElement removeButton4 = driver.findElement(By.xpath(deleteElementCSS4));
		removeButton4.click();
		
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
