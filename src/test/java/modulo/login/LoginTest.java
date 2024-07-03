package modulo.login;

import driver.Web;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import paginas.LoginPage;

import static config.GeneralConfigManager.configuration;

@DisplayName("Testes Web do Módulo de Login")
public class LoginTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        navegador = Web.createChrome();
    }

    @Test
    @DisplayName("Não é permitido entrar com Nome de usuário vazio")
    public void testNaoEPermitidoEntrarComNomeDeUsuarioVazioError(){
        String mensagemApresentada = new LoginPage(navegador)
                .submeterFormularioSemInformarNomeDeUsuarioLogin()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.", mensagemApresentada);
    }

    @Test
    @DisplayName("Não é permitido entrar com Senha vazia")
    public void testNaoEPermitidoEntrarComSenhaVaziaError(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario(configuration().user())
                .submeterFormularioDeUsuarioLogin()
                .submeterFormularioSemInformarSenhaLogin()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.", mensagemApresentada);
    }

    @Test
    @DisplayName("Não é permitido acessar a página de senha (login_password_page.php) sem informar Nome de usuario")
    public void testNaoEPermitidoAcessarPaginaDeSenhaSemInformarNomeDeUsuarioError(){
        String mensagemApresentada = new LoginPage(navegador)
                .acessarDiretamentePaginaDeSenha()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.", mensagemApresentada);
    }

    @Test
    @DisplayName("Permite entrar com Nome de usuário e Senha Válidos")
    public void testPermiteEntrarComNomeDeUsuarioSenhaValidosSucesso(){
        String nomeDoUsuarioLogadoApresentado = new LoginPage(navegador)
                .informarOUsuario(configuration().user())
                .submeterFormularioDeUsuarioLogin()
                .informarASenha(configuration().password())
                .submeterFormularioDeSenhaLogin()
                .capturarNomeUsuarioLogado();
        Assertions.assertEquals(configuration().user(), nomeDoUsuarioLogadoApresentado);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}
