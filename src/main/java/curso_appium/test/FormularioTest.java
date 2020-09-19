package curso_appium.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import curso_appium.page.MenuPage;

public class FormularioTest {

	private MenuPage menu = new MenuPage();

	@BeforeTest
	public void inicializarAppium() {
		menu.acessarFormulario();
	}

	@Test
	public void teste() {

	}

}
