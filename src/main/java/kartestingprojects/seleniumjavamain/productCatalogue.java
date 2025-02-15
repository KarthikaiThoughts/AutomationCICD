package kartestingprojects.seleniumjavamain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import kartestingprojects.abstarctComponent.abstractComp;

public class productCatalogue extends abstractComp{
	WebDriver driver;
	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".card-body")
	List<WebElement> products;
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement Cart;
	
	By productBy=By.cssSelector(".card-body");
	By prodSel=By.cssSelector("div h5 b");
	By addtoCartLoc=By.cssSelector("button:last-of-type");
	By spinner=By.cssSelector("#toast-container");
	By addedsuccess=By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getProductList() {
		elementToAppear(productBy);
		return products;
	}
	public WebElement getProductMatched(String prodName) {
		WebElement retprod= getProductList().stream().filter(product->
		product.findElement(prodSel).getText().equals(prodName)).findFirst().orElse(null);
		return retprod;
	}
	public checkOutPage addToCart(String prodName) throws InterruptedException {
		WebElement prod=getProductMatched(prodName);
		prod.findElement(addtoCartLoc).click();
		elementToAppear(spinner);
		elementToDisappear(addedsuccess);
		gotoCardpage();
		checkOutPage checkoutpg=new checkOutPage(driver);
		return checkoutpg;
	}
}
