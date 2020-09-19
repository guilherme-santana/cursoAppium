package curso_appium.page;
import curso_appium.core.DSL;
public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}
