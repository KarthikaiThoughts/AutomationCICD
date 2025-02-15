package kartestingprojects.seleniumjavamain;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kartestingprojects.abstarctComponent.abstractComp;

public class OrderPage extends abstractComp {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> chkOrders;
	
	public boolean chkProductInOrders(String prodName) {
		Boolean chkProdNameInOrder=chkOrders.stream().anyMatch(chkOrder->chkOrder.getText().equalsIgnoreCase(prodName));
		return chkProdNameInOrder;
	}

}
