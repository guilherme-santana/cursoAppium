package curso_appium.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import curso_appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTest {
	
	private AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	private void inicializarAppium() {
		driver = DriverFactory.getDriver();
	}
	
	
	@Test
	public void teste() {
		
	}

}
