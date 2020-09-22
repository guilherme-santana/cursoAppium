package curso_appium.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public static AndroidDriver<MobileElement> driver;

	private static void createDriver() {
		File diretorioAplicacao = new File("apps");
		File arquivoAplicacao = new File(diretorioAplicacao, "app-release.apk");
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capacidade.setCapability("appPackage", "br.com.liveloincentivo");
		capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

		}catch (MalformedURLException e){
			System.out.println( e.getMessage() );
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private static void createTestObjectDriver() {
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capacidade.setCapability("testobject_apikey", "91E7CR91E7CR91E7CR91E7CR91E7CR");
		capacidade.setCapability("automationName", "uiautomator2");
		capacidade.setCapability("appiumVersion", "1.7.2");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), capacidade);

		}catch (MalformedURLException e){
			System.out.println( e.getMessage() );
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			//createDriver();
			createTestObjectDriver();
		}
		return driver;
	}

	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
