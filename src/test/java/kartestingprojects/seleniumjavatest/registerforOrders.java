package kartestingprojects.seleniumjavatest;

import java.awt.Window;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerforOrders {
	public static List<String> registerUser(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String eMail="karthikaidurgaprasad@gmail.com";
		String passWord="Karthikai@123";
		
		/*driver.get("https://rahulshettyacademy.com/client");
		//Registering User
		driver.findElement(By.cssSelector(".text-reset")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Karthikai");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Attili");
		driver.findElement(By.id("userEmail")).sendKeys(eMail);
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("9876543102");
		WebElement forSelect=driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
		Select sel=new Select(forSelect);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[formcontrolname='occupation']")));
		sel.selectByVisibleText("Student");
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		driver.findElement(By.id("userPassword")).sendKeys(passWord);
		driver.findElement(By.id("confirmPassword")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector(".btn.btn-block.login-btn")).click();*/
		List<String> getLoginInfo=Arrays.asList(eMail,passWord);
		return getLoginInfo;
	}

}
