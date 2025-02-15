package kartestingprojects.seleniumjavamain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kartestingprojects.abstarctComponent.abstractComp;

public class confirmationPage extends abstractComp{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="td h1")
	WebElement confirmmsg;
	
	public String confirmation() throws InterruptedException {
		Thread.sleep(2000);
		String name=confirmmsg.getText();
		return name;
		
	}
	
}
