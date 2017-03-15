import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CasoTeste {

	private WebDriver driver;

	Login login = new Login(driver);

	@Before // executado antes de cada caso de teste
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://52.2.166.124:8085/");
		Thread.sleep(1000);

	}

	// logar com sucesso e validar usuário exibido
	@Test
	public void logarComSucesso() throws InterruptedException {
		login.logar("avaliacao_qa_samba@sambatech.com.br", "123456789");
		Thread.sleep(1000);
		WebElement nome = driver.findElement(By.xpath(".//*[@id='wrap']/div/div[2]/form/ul[2]/li/a/span"));
		assertTrue(nome.getText().equals("Avaliacao QA user"));
	}

	// tentar logar com usuário inválido e comparar a mensagem exibida
	@Test
	public void logarComErro() throws InterruptedException {
		login.logar("invalido@sambatech.com.br", "123456789");
		Thread.sleep(1000);
		WebElement nome = driver.findElement(By.id("password_incorrect"));
		assertEquals(nome.getText(), "Email ou senha incorretos. [Saiba Mais]");
	}

	@After
	public void fechar() {
		driver.quit();
	}

}
