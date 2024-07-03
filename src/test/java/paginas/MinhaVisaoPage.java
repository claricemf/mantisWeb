package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
