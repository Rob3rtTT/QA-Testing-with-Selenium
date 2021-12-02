import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContent {
	@Test
	public void test() {
		// Set browser property
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		// initialize browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// navigate to page
		driver.get("https://the-internet.herokuapp.com/dynamic_content");

		// make sure you're on the right page
		String expectedUrl = "https://the-internet.herokuapp.com/dynamic_content";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		System.out.println("Url verification worked");
		// verification
		WebElement firstMessage = driver.findElement(
				By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[1]/div[2]"));
		String firstCheck = firstMessage.getText();
		// images & texts before change
		WebElement image1Url = driver.findElement(By.cssSelector("div:nth-of-type(1) > .columns.large-2 > img"));
		WebElement image2Url = driver.findElement(By.cssSelector("div:nth-of-type(2) > .columns.large-2 > img"));
		WebElement image3Url = driver.findElement(By.cssSelector("div:nth-of-type(3) > .columns.large-2 > img"));
		WebElement text1Content = driver.findElement(
				By.cssSelector(".example .row:nth-child(7) .row:nth-of-type(1) [class='large-10 columns']"));
		String text1Content1 = text1Content.getText();
		WebElement text2Content = driver.findElement(
				By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[2]/div[2]"));
		String text2Content2 = text2Content.getText();
		WebElement text3Content = driver.findElement(By.cssSelector("div:nth-of-type(3) > .columns.large-10"));
		String text3Content3 = text3Content.getText();

		// text refresh button
		String xpath1 = "/html//div[@id='content']//a[@href='/dynamic_content?with_content=static']";
		WebElement clickHere = driver.findElement(By.xpath(xpath1));
		clickHere.click();
		System.out.println("Text checked && clicked");

		// make sure URL changes as well
		String expectedUrl2 = "https://the-internet.herokuapp.com/dynamic_content?with_content=static";
		String actualUrl2 = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl2, expectedUrl2, "Actual page url is not the same as expected");

		// text && image after change
		WebElement image1Urlchange = driver.findElement(By.cssSelector("div:nth-of-type(1) > .columns.large-2 > img"));
		WebElement image2Urlchange = driver.findElement(By.cssSelector("div:nth-of-type(2) > .columns.large-2 > img"));
		WebElement image3Urlchange = driver.findElement(By.cssSelector("div:nth-of-type(3) > .columns.large-2 > img"));
		WebElement text1Contentchange = driver.findElement(
				By.cssSelector(".example .row:nth-child(7) .row:nth-of-type(1) [class='large-10 columns']"));
		String text1Content1change = text1Contentchange.getText();
		WebElement text2Contentchange = driver.findElement(
				By.xpath("/html//div[@id='content']/div/div[@class='row']/div[@id='content']/div[2]/div[2]"));
		String text2Content2change = text2Contentchange.getText();
		WebElement text3Contentchange = driver.findElement(By.cssSelector("div:nth-of-type(3) > .columns.large-10"));
		String text3Content3change = text3Contentchange.getText();
		// verification2
		Boolean image1Change = (image1Url != image1Urlchange);
		Boolean image2Change = (image2Url != image2Urlchange);
		Boolean image3Change = (image3Url != image3Urlchange);
		Boolean text1Change = (text1Content != text1Contentchange);
		Boolean text2Change = (text2Content != text2Contentchange);
		Boolean text3Change = (text3Content != text3Contentchange);

		Assert.assertTrue(image1Change || image2Change || image3Change || text1Change || text2Change || text3Change);

		driver.quit();
	}

}
