package kartestingprojects.seleniumjavatest;

import java.io.IOException;
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
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import kartestingprojects.basetest.baseDataGeneral;
import kartestingprojects.seleniumjavamain.cardDetails;
import kartestingprojects.seleniumjavamain.checkOutPage;
import kartestingprojects.seleniumjavamain.confirmationPage;
import kartestingprojects.seleniumjavamain.landingPage;
import kartestingprojects.seleniumjavamain.productCatalogue;

public class errorValidations extends baseDataGeneral{
	@Test(groups = {"ErrorHanding"},retryAnalyzer=kartestingprojects.basetest.Retry.class)

	public void loginPageValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		land.loginPage("karthikaidurgaprasad@gmail.com", "Karthikai@@123");
		Assert.assertEquals("Incorrect email or password.", land.errordet());
	}
	
	@Test
	 
	public void productCatalougueValidation() throws InterruptedException {
	String selProduct="IPHONE 13 PRO";
	productCatalogue prodCat=land.loginPage("karthikaidurgaprasad@gmail.com", "Karthikai@123");
	checkOutPage checkoutpg=prodCat.addToCart(selProduct);
	Boolean chk=checkoutpg.productCompare("PRO");
	Assert.assertFalse(chk);
	}
}
