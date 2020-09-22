package curso_appium.page;
import static curso_appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import curso_appium.core.DSL;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
	
	
	public void clicarSeekBar(double position) {
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		int x = (int) (seek.getLocation().x + (seek.getSize().width * position));
		
		tap(x, y);
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x, y);	
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width /2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction(getDriver())
		.press(x, start_y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(x, end_y)
		.release()
		.perform();
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height /2;
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction(getDriver())
		.press(start_x, y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(end_x, y)
		.release()
		.perform();
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height /2);
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		new TouchAction(getDriver())
		.press(start_x, y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(end_x, y)
		.release()
		.perform();
	}

}
