package kartestingprojects.seleniumjavamain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kartestingprojects.abstarctComponent.abstractComp;

public class cardDetails extends abstractComp {
	WebDriver driver;
	public cardDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="input[placeholder='Select Country']")
	WebElement selCountry;
	@FindBy(css=".list-group button:nth-child(3)")
	WebElement clkcountry;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	
	By countryFiltered=By.cssSelector(".list-group");
	
	public void chooseCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(selCountry, countryName).build().perform();
		elementToAppear(countryFiltered);	
		clkcountry.click();
	}
	public confirmationPage submitbtn() throws InterruptedException {
		submit.click();
		return new confirmationPage(driver);
	}
}
