package curso_appium.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public static AndroidDriver<MobileElement> driver;
	
	private static AndroidDriver<MobileElement> createDriver() {

		try {
			File diretorioAplicacao = new File("apps");
			File arquivoAplicacao = new File(diretorioAplicacao, "app-release.apk");
			DesiredCapabilities capacidade = new DesiredCapabilities();
			capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			capacidade.setCapability("appPackage", "br.com.liveloincentivo");
			capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

		}catch (MalformedURLException e){
			System.out.println( e.getMessage() );
		}
		return driver;
	}
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
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
