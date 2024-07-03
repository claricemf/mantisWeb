package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPasswordPage {
    private WebDriver navegador;

    public LoginPasswordPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPasswordPage informarASenha(String senha){
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public MinhaVisaoPage submeterFormularioDeSenhaLogin(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
        return new MinhaVisaoPage(navegador);
    }

    public LoginPage submeterFormularioSemInformarSenhaLogin(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
        return new LoginPage(navegador);
    }

}
