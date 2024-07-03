package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioVerDetalhesTarefaPage {
    private WebDriver navegador;

    public FormularioVerDetalhesTarefaPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarMensagemSucessoApresentada(){
        return navegador.findElement(By.cssSelector(".bold")).getText();
    }
}
