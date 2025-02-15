package kartestingprojects.seleniumjavamain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kartestingprojects.abstarctComponent.abstractComp;

public class landingPage extends abstractComp{
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement eMail;
	@FindBy(id="userPassword")
	WebElement passWord;
	@FindBy(id="login")
	WebElement loginclk;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	//<div class="ng-tns-c4-8 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error" 
	//toast-component="" style="opacity: 1;"><!----><!----><!----><div role="alert" class="ng-tns-c4-8 toast-message ng-star-inserted" 
	//aria-label="Incorrect email or password." style=""> Incorrect email or password. </div><!----><!----></div>
	
	public productCatalogue loginPage(String email,String Pass) {
		eMail.sendKeys(email);
		passWord.sendKeys(Pass);
		loginclk.click();
		productCatalogue prodCat=new productCatalogue(driver);
		return prodCat;
	}
	public void gotopage() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String errordet() {
		webelementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
