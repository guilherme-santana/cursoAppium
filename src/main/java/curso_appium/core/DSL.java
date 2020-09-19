package curso_appium.core;

import static curso_appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {


	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}

	public void selecionarCombo(By by, String valor) {
		clicar(by);
		clicarPorTexto(valor);
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

}
