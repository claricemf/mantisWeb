package modulo.tarefa;

import driver.Web;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import paginas.LoginPage;
import static config.GeneralConfigManager.configuration;
import static data.TarefaDataFactory.*;

@DisplayName("Testes Web do Módulo de Tarefa")
public class TarefaTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        navegador = Web.createChrome();
    }
    @Test
    @DisplayName("PermiteCriarTarefaDadosValidosSucesso")
    public void testCriarTarefaComDadosValidosSucesso(){
        String mensagemSucessoApresentada = new LoginPage(navegador)
                .informarOUsuario(configuration().user())
                .submeterFormularioDeUsuarioLogin()
                .informarASenha(configuration().password())
                .submeterFormularioDeSenhaLogin()
                .acessarFormularioCriarTarefa()
                .informarCategoriaTarefa(returnRandomCategoria())
                .informarFrequenciaTarefa(returnRandomFrequencia())
                .informarGravidadeTarefa(returnRandomGravidade())
                .informarPrioridadeTarefa(returnRandomPrioridade())
                .informarResumoTarefa(returnRandomResumo())
                .informarDescricaoTarefa(returnRandomDescricao())
                .submeterFormularioCriarTarefa()
                .capturarMensagemSucessoApresentada();
        Assertions.assertEquals("Operação realizada com sucesso.", mensagemSucessoApresentada);
    }

    @Test
    @DisplayName("Não é permitido criar tarefa sem informar Categoria")
    public void testNaoEPermitidoCriarTarefaSemInformarCategoriaError(){
        String mensagemSucessoApresentada = new LoginPage(navegador)
                .informarOUsuario(configuration().user())
                .submeterFormularioDeUsuarioLogin()
                .informarASenha(configuration().password())
                .submeterFormularioDeSenhaLogin()
                .acessarFormularioCriarTarefa()
                .informarResumoTarefa(returnRandomResumo())
                .informarDescricaoTarefa(returnRandomDescricao())
                .submeterFormularioCriarTarefaSemInformarCategoria()
                .capturarMensagemDeErroDaAplicacao();
        Assertions.assertEquals("APPLICATION ERROR #11\n" +
                "Um campo necessário 'category' estava vazio. Por favor, verifique novamente suas entradas.\n" +
                "Por favor, utilize o botão \"Voltar\" de seu navegador web para voltar à pagina anterior. Lá você pode corrigir quaisquer problemas identificados neste erro ou escolher uma outra ação. Você também pode clicar em uma opção da barra de menus para ir diretamente para outra seção.", mensagemSucessoApresentada);
    }

    @Test
    @DisplayName("Não é permitido criar tarefa com token de segurança inválido")
    public void testNaoEPermitidoCriarTarefaComTokeDeSegurancaInvalidoError(){
        String mensagemSucessoApresentada = new LoginPage(navegador)
                .informarOUsuario(configuration().user())
                .submeterFormularioDeUsuarioLogin()
                .informarASenha(configuration().password())
                .submeterFormularioDeSenhaLogin()
                .acessarFormularioCriarTarefa()
                .informarCategoriaTarefa(returnRandomCategoria())
                .informarResumoTarefa(returnRandomResumo())
                .informarDescricaoTarefa(returnRandomDescricao())
                .submeterFormularioCriarTarefaComTokenSegurancaInvalido()
                .capturarMensagemDeErroDaAplicacao();
        Assertions.assertEquals("APPLICATION ERROR #2800\n" +
                "Token de segurança do formulário inválido. Isso pode ter sido provocado por esgotamento do tempo da seção, ou acidentamente, por enviar o formulário duas vezes.\n" +
                "Por favor, utilize o botão \"Voltar\" de seu navegador web para voltar à pagina anterior. Lá você pode corrigir quaisquer problemas identificados neste erro ou escolher uma outra ação. Você também pode clicar em uma opção da barra de menus para ir diretamente para outra seção.", mensagemSucessoApresentada);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}
