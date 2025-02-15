package kartestingprojects.seleniumjavatest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standardtesting extends registerforOrders {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		List<String> loginInfo=registerUser(driver);
		//login user
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Login')]")));
		//driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys(loginInfo.get(0));
		driver.findElement(By.id("userPassword")).sendKeys(loginInfo.get(1));
		driver.findElement(By.id("login")).click();
		String[] originalList= {"ADIDAS ORIGINAL", "IPHONE 13 PRO", "ZARA COAT 3"};
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> itemNamesAsWebElement=driver.findElements(By.xpath("//div/h5"));
		List<String> originalList1=Arrays.asList(originalList);
		for(WebElement itemNameAsWebElement :itemNamesAsWebElement ) {
			System.out.println(itemNameAsWebElement.getText());
			if (originalList1.contains(itemNameAsWebElement.getText())){
				Thread.sleep(2000);
				itemNameAsWebElement.findElement(By.xpath("following-sibling::button[2]")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				//w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[aria-label='Product Added To Cart']"))));//for better performance we are using Web element instead of locator
			}
		}
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Unit");
		List<WebElement> countries=driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		for(WebElement country:countries) {
			String countryName=country.getText();
			System.out.println(countryName);
			if (countryName==" United States") {
				country.click();
				
			}
		}
		
		driver.quit();
			
	}
}


/*
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/client");
//Registering User
driver.findElement(By.cssSelector(".text-reset")).click();
driver.findElement(By.cssSelector("#firstName")).sendKeys("Karthikai");
driver.findElement(By.cssSelector("#lastName")).sendKeys("Attili");
driver.findElement(By.id("userEmail")).sendKeys("karthikaiattili@gmail.com");
driver.findElement(By.cssSelector("input[type='text']")).sendKeys("9876543201");
WebElement forSelect=driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
Select sel=new Select(forSelect);
w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[formcontrolname='occupation']")));
sel.selectByVisibleText("Student");
driver.findElement(By.xpath("//input[@value='Female']")).click();
driver.findElement(By.id("userPassword")).sendKeys("Karthikai@123");
driver.findElement(By.id("confirmPassword")).sendKeys("Karthikai@123");
driver.findElement(By.xpath("//input[@type='checkbox']")).click();
driver.findElement(By.cssSelector(".btn.btn-block.login-btn")).click();*/