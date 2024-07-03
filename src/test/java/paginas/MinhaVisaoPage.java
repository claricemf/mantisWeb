package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.GeneralConfigManager.configuration;

public class MinhaVisaoPage {
    private WebDriver navegador;

    public MinhaVisaoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioCriarTarefaPage acessarFormularioCriarTarefa(){
        navegador.findElement(By.linkText("Criar Tarefa")).click();
        return new FormularioCriarTarefaPage(navegador);
    }

    public String capturarNomeUsuarioLogado(){
        return navegador.findElement(By.cssSelector(".user-info")).getText();
    }
}
