package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormularioCriarTarefaPage {
    private WebDriver navegador;

    public FormularioCriarTarefaPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioCriarTarefaPage informarCategoriaTarefa(String categoria){
        selecionarElementoById(navegador, "category_id", categoria);
        return this;
    }

    public FormularioCriarTarefaPage informarFrequenciaTarefa(String frequencia){
        selecionarElementoById(navegador, "reproducibility", frequencia);
        return this;
    }

    public FormularioCriarTarefaPage informarGravidadeTarefa(String gravidade){
        selecionarElementoById(navegador, "severity", gravidade);
        return this;
    }

    public FormularioCriarTarefaPage informarPrioridadeTarefa(String prioridade){
        selecionarElementoById(navegador, "priority", prioridade);
        return this;
    }

    public FormularioCriarTarefaPage informarResumoTarefa(String resumo){
        navegador.findElement(By.id("summary")).sendKeys(resumo);
        return this;
    }

    public FormularioCriarTarefaPage informarDescricaoTarefa(String descricao){
        navegador.findElement(By.id("description")).sendKeys(descricao);
        return this;
    }

    public void selecionarElementoById(WebDriver navegador, String id, String valor){
        WebElement selectElement = navegador.findElement(By.id(id));
        Select select = new Select(selectElement);
        select.selectByVisibleText(valor);
    }

    public void clicarNoBotaoCriarNovaTarefa(){
        navegador.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public FormularioVerDetalhesTarefaPage submeterFormularioCriarTarefa(){
        clicarNoBotaoCriarNovaTarefa();
        return new FormularioVerDetalhesTarefaPage(navegador);
    }

    public FormularioCriarTarefaPage submeterFormularioCriarTarefaSemInformarCategoria(){
        clicarNoBotaoCriarNovaTarefa();
        return this;
    }

    public FormularioCriarTarefaPage submeterFormularioCriarTarefaComTokenSegurancaInvalido(){
        navegador.manage().deleteCookieNamed("PHPSESSID");
        clicarNoBotaoCriarNovaTarefa();
        return this;
    }

    public String capturarMensagemDeErroDaAplicacao(){
        return navegador.findElement(By.cssSelector(".alert.alert-danger")).getText();
    }
}
