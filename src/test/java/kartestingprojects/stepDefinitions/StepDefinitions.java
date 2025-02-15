package kartestingprojects.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kartestingprojects.basetest.baseDataGeneral;
import kartestingprojects.seleniumjavamain.cardDetails;
import kartestingprojects.seleniumjavamain.checkOutPage;
import kartestingprojects.seleniumjavamain.confirmationPage;
import kartestingprojects.seleniumjavamain.landingPage;
import kartestingprojects.seleniumjavamain.productCatalogue;

public class StepDefinitions extends baseDataGeneral {
	
	public landingPage land;
	public productCatalogue prodCat;
	public checkOutPage checkoutpg;
	public cardDetails cd;
	public confirmationPage cp;
	String Country="India";
	//Given I Landed on Eccommerce page
	@Given ("I Landed on Eccommerce page")
	public void I_Landed_on_Eccommerce_page() throws IOException {
		land=launchingPage();
	}
	//Given Login with username <name> and password  
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username,String Password) {
	 prodCat=land.loginPage(username,Password);
	}
	//When Add product <product> to cart
	@When("^Add product (.+) to cart$")
	public void Add_product_to_cart(String product) throws InterruptedException {
	 checkoutpg=prodCat.addToCart(product);
	}
	//And Checkout <product> and submit the order
	@When ("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String product) throws InterruptedException {
		Boolean chk=checkoutpg.productCompare(product);
		Assert.assertTrue(chk);
	    cd=checkoutpg.checkOut();
		cd.chooseCountry(Country);
		cp=cd.submitbtn();
	}
	//Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	@Then ("{string} message is displayed on ConfirmationPage")
	public void Thanks_message_displayed_on_ConfirmationPage(String string) throws InterruptedException {
		String name= cp.confirmation() ;
	    Assert.assertTrue(name.equalsIgnoreCase(string));
	    driver.close();
	}
	
	//Then "Incorrect email or password." message is displayed
	@Then ("{string} message is displayed")
	public void error_message_display(String string) {
		Assert.assertEquals(string, land.errordet());
		driver.close();
	}
}
