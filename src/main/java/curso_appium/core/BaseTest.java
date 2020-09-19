package curso_appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	public ITestNGMethod  testNome;

	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}

	@AfterTest
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().resetApp();
	}

	public void gerarScreenShot() {
		try {
			File image = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File("target/screenshots/"+testNome.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
