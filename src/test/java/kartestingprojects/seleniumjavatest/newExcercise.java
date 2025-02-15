package kartestingprojects.seleniumjavatest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newExcercise extends registerforOrders{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		List<String> loginInfo=registerUser(driver);
		String selProduct="ADIDAS ORIGINAL";
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys(loginInfo.get(0));
		driver.findElement(By.id("userPassword")).sendKeys(loginInfo.get(1));
		driver.findElement(By.id("login")).click();
		List<WebElement> products= driver.findElements(By.cssSelector(".card-body"));
		WebElement retprod= products.stream().filter(product->
		product.findElement(By.cssSelector("div h5 b")).getText().equals(selProduct)).findFirst().orElse(null);
		retprod.findElement(By.cssSelector("button:last-of-type")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		List<WebElement> chkProds= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean chkProdName=chkProds.stream().anyMatch(chkProd->chkProd.getText().equalsIgnoreCase(selProduct));
		Assert.assertTrue(chkProdName);
		driver.findElement(By.cssSelector(".subtotal button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
		driver.findElement(By.cssSelector(".list-group button:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String name= driver.findElement(By.cssSelector("td h1")).getText();
	    Assert.assertTrue(name.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
	}

}
