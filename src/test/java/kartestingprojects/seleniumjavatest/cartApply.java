package kartestingprojects.seleniumjavatest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import kartestingprojects.basetest.Retry;
import kartestingprojects.basetest.baseDataGeneral;
import kartestingprojects.seleniumjavamain.OrderPage;
import kartestingprojects.seleniumjavamain.cardDetails;
import kartestingprojects.seleniumjavamain.checkOutPage;
import kartestingprojects.seleniumjavamain.confirmationPage;
import kartestingprojects.seleniumjavamain.landingPage;
import kartestingprojects.seleniumjavamain.productCatalogue;

public class cartApply extends baseDataGeneral{
	String selProduct="QWERTY";
	@Test(dataProvider = "getData",groups= {"Purchase"})

	public void submitProductTest(HashMap<String, String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String Country="India";
		productCatalogue prodCat=land.loginPage(input.get("eMail"), input.get("passWord"));
		checkOutPage checkoutpg=prodCat.addToCart(input.get("product"));
		Boolean chk=checkoutpg.productCompare(input.get("product"));
		Assert.assertTrue(chk);
		cardDetails cd=checkoutpg.checkOut();
		cd.chooseCountry(Country);
		confirmationPage cp=cd.submitbtn();
		String name= cp.confirmation() ;
	    Assert.assertTrue(name.equalsIgnoreCase("Thankyou for the order."));
	}
	
	@Test(dependsOnMethods = {"submitProductTest"},retryAnalyzer = Retry.class)
	public void OrderCheckTest() {
		productCatalogue prodCat=land.loginPage("Karthikai@gmail.com", "Dec2024@379");
		OrderPage orders= prodCat.gotoOrderspage();
		Boolean chkProdInOrder=orders.chkProductInOrders(selProduct);
		Assert.assertTrue(chkProdInOrder);
	}
	//Using HaspMap
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\kartestingprojects\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	/*Using HashMap
	HashMap<String, String> map=new HashMap<String,String>();
	map.put("eMail", "Karthikai@gmail.com");
	map.put("passWord", "Dec2024@379");
	map.put("product", "ADIDAS ORIGINAL");
	HashMap<String, String> map1=new HashMap<String,String>();
	map1.put("eMail", "karthikaidurgaprasad@gmail.com");
	map1.put("passWord", "Karthikai@123");
	map1.put("product", "IPHONE 13 PRO");
	using Data provider
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"Karthikai@gmail.com", "Dec2024@379","ADIDAS ORIGINAL"},{"karthikaidurgaprasad@gmail.com", "Karthikai@123","IPHONE 13 PRO"}};
	}*/

}
