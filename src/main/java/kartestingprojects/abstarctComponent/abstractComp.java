package kartestingprojects.abstarctComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kartestingprojects.seleniumjavamain.OrderPage;
import kartestingprojects.seleniumjavamain.checkOutPage;

public class abstractComp {
	
	WebDriver driver;
	
	
	public abstractComp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="button[routerlink*='cart']")
	WebElement Cart;
	@FindBy(css="button[routerlink*='myorders']")
	WebElement Orders;
	
	public void gotoCardpage() {
		Cart.click();
	}
	public OrderPage gotoOrderspage() {
		Orders.click();
		return new OrderPage(driver);
	}

	public void elementToAppear(By findBy) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void webelementToAppear(WebElement ele) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void elementToDisappear(By findBy) throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	

}
