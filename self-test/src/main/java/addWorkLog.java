import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addWorkLog {
	String url = "https://mycc-staging.n13.ro/login";
	String emailField = "form#kt_login_signin_form input[name='email']";
	String passwordField = "form#kt_login_signin_form input[name='password']";
	String email = "cctestuser2@yopmail.com";
	String password = "CCTest@2021";
	String logInButton = ".btn.btn-primary.font-size-h6.font-weight-bolder.px-15.py-3";
	String newUrl = "https://mycc-staging.n13.ro/dashboard";
	String logTimeButton = "div:nth-of-type(2) > .card.card-custom.card-stretch.gutter-b.work-logs-widget .btn.btn-success.d-block.font-weight-bolder.m-auto.py-3.w-50";
	String logTimeModalBox = "logWorkModal___BV_modal_content_";
	String commentBox = "/html//textarea[@id='comments-minutes-input']";
	String comment = "testing how to test!";
	String saveLog = "/html//footer[@id='logWorkModal___BV_modal_footer_']//button[@type='button']";
	@Test
	public void logIn() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		WebElement emailBox = driver.findElement(By.cssSelector(emailField));
		emailBox.sendKeys(email);
		WebElement passwordBox = driver.findElement(By.cssSelector(passwordField));
		passwordBox.sendKeys(password);
		WebElement signInBox = driver.findElement(By.cssSelector(logInButton));
		signInBox.click();
		
		sleep(3000);
		String newLink = driver.getCurrentUrl();
			System.out.println(newLink);
		Assert.assertTrue(newLink.equals(newUrl));
		
		sleep(10000);
		WebElement workLogButton = driver.findElement(By.cssSelector(logTimeButton));
			workLogButton.click();
			sleep(200);
		driver.switchTo().activeElement();
			Select projectDrop = new Select(driver.findElement(By.name("project")));
				projectDrop.selectByVisibleText(" My CC Test Project ");
				sleep(200);
			Select taskDrop = new Select(driver.findElement(By.name("task")));
				taskDrop.selectByVisibleText(" Development Back End Test ");
				sleep(200);
//			Select hourDrop = new Select(driver.findElement(By.className("vue__time-picker time-picker")));
//				hourDrop.selectByVisibleText("10");
			WebElement timePicker = driver.findElement(By.xpath("//div/span/input"));
			sleep(20);
			timePicker.click();
			sleep(200);
			WebElement hour = driver.findElement(By.xpath("//ul[1]/li[@data-key='16']"));
			sleep(300);
			hour.click();
			WebElement minute = driver.findElement(By.xpath("//ul[2]//li[@data-key='00']"));
			minute.click();
			WebElement commBox = driver.findElement(By.xpath(commentBox));
			commBox.sendKeys(comment);
			WebElement saveLogButton = driver.findElement(By.xpath(saveLog));
			saveLogButton.click();
			
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
