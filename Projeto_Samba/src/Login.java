import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	WebDriver driver;

	/** Construtor padrão
	 * @param driver
	 */
	public Login(WebDriver driver) {
		this.driver = driver;
	}

	/** Método para logar no site
	 * @param email a ser preenchido no campo referente ao email.
	 * @param senha a ser preenchida no campo referente a senha
	 */
	public void logar(String email, String senha) {
		WebElement emailElement = driver.findElement(By.id("inputEmail"));
		WebElement senhaElement = driver.findElement(By.id("inputPassword"));
		WebElement botao = driver.findElement(By.id("login"));
		emailElement.clear();
		emailElement.sendKeys(email);
		senhaElement.clear();
		senhaElement.sendKeys(senha);
		botao.click();
	}

}
