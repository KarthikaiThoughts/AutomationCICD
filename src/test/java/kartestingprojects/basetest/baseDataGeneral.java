package kartestingprojects.basetest;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import kartestingprojects.seleniumjavamain.landingPage;

public class baseDataGeneral {
	public WebDriver driver;
	public landingPage land;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//kartestingprojects//globaldata//BaseData.properties");
		prop.load(fis);
		String browserName= System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
		//String browserName= prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new org.openqa.selenium.Dimension(1440, 900));//full screen
		}
		else if(browserName.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	}
	@BeforeMethod(alwaysRun=true)
		public landingPage launchingPage() throws IOException {
		driver=initializeDriver();
		land=new landingPage(driver);
		land.gotopage();
		return land;
	}
	@AfterMethod(alwaysRun=true)
	public void exitPage() {
		driver.quit();
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Reports//"+testCaseName+".png");
		FileUtils.copyFile(source, dest); 
		return System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		//Jackson DataBind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data= mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;	
	}
}
