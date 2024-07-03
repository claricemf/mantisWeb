package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static config.GeneralConfigManager.configuration;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.id("username")).sendKeys(usuario);
        return this;
    }
    public LoginPasswordPage submeterFormularioDeUsuarioLogin(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
        return new LoginPasswordPage(navegador);
    }

    public LoginPage submeterFormularioSemInformarNomeDeUsuarioLogin(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
        return this;
    }

    public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".alert.alert-danger")).getText();
    }

    public LoginPage acessarDiretamentePaginaDeSenha(){
        navegador.get(configuration().url()+"login_password_page.php");
        return this;
    }
}
