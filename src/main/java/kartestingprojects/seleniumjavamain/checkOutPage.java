package kartestingprojects.seleniumjavamain;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kartestingprojects.abstarctComponent.abstractComp;

public class checkOutPage extends abstractComp {
	
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> chkProds;
	@FindBy(css=".subtotal button")
	WebElement chkoutbtn;
	
	
	public boolean productCompare(String prodName) {
		Boolean chkProdName=chkProds.stream().anyMatch(chkProd->chkProd.getText().equalsIgnoreCase(prodName));
		return chkProdName;
	}
	public cardDetails checkOut() {
		chkoutbtn.click();
		cardDetails cd=new cardDetails(driver);
		return cd;
	}

}
