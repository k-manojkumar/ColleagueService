package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo {


	static AppiumDriver driver;
	static DesiredCapabilities capabilities = new DesiredCapabilities();

	
	public static void init() throws MalformedURLException {
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "e73fb47d6af24628c2b60e8727ee6dcc6cb1107f");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "12.4");
		capabilities.setCapability("xcodeOrgId", "P258R4GL6F");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer"); 
		capabilities.setCapability("bundleId", "com.lbg.safari.launcher");
		capabilities.setCapability("browser", "safari");
		capabilities.setCapability("useNewWDA", true);
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void appTest() throws MalformedURLException, InterruptedException {
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Air (3rd generation)");
		capabilities.setCapability("startIWDP", true);
		capabilities.setCapability(MobileCapabilityType.UDID, "auto");
		capabilities.setCapability("bundleId", "co.uk.lbg.colleague.bankofscotland");
		
		AppiumDriver<MobileElement> appium = new IOSDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
		appium.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		appium.launchApp();

		MobileElement contButton = appium.findElementByName("Continue");
		contButton.click();
		
		MobileElement findextButton = appium.findElementByName("Customer search");
		findextButton.click();
		
		
		MobileElement button1 = appium.findElement(By.xpath("//XCUIElementTypeButton[@name=\"1\"]"));
		button1.click();
		button1.click();
		
		MobileElement button2 = appium.findElement(By.xpath("//XCUIElementTypeButton[@name=\"2\"]"));
		button2.click();
		button2.click();
		
		MobileElement button3 = appium.findElement(By.xpath("//XCUIElementTypeButton[@name=\"3\"]"));
		button3.click();
		button3.click();
		
		MobileElement surName = appium.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Find Customer\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeTextField[1]"));
		surName.click();
		surName.sendKeys("TestSurName");
		
		MobileElement firstName = appium.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Find Customer\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeTextField[2]"));
		firstName.click();
		firstName.sendKeys("TestFirstName");
		
		appium.hideKeyboard();
		
		MobileElement postcode1 = appium.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Find Customer\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[1]"));
		postcode1.click();
		postcode1.sendKeys("M1");
		
		MobileElement postcode2 = appium.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Find Customer\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[2]"));
		postcode2.click();
		postcode2.sendKeys("3HU");
		
		
		Thread.sleep(2000);
		
		appium.closeApp();
		
		appium.quit();
		
	}

}
