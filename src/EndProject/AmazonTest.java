package EndProject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement searchText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchText.sendKeys("samsung mobile");

		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();

		
		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));

		List<WebElement> productPrice = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));

		List<WebElement> currency = driver
				.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));

		for (int i = 0; i < productName.size(); i++) {
			System.out.println("Product Name: " + productName.get(i).getText());

			System.out.println("Product price: " + productPrice.get(i).getText()+ " " + currency.get(i).getText() );
		}
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);

		File screenshotObj = new File("image.png");

		FileUtils.copyFile(fileObj, screenshotObj);
		
		driver.close();
	}
}