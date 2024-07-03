# mantisWEB
**Automação Web com Selenium WebDriver e JUnit**

Este projeto tem como objetivo a automatização dos cenários de testes para a aplicação WEB Mantis. 

___

**Estrutura do Projeto:**

Eu estou utilizando a seguinte estrutura para este projeto:

```
mantisWeb/
  main/java
      config/
          GeneralConfig.java
          GeneralConfigManager.java
      data/
          TarefaDataFactory.java
      driver/
          Web.java
      resources/
          general.properties
  test/java
      modulo/
          login/
              LoginTest.java
          tarefa/
              TarefaTest.java
      paginas/
          FormularioCriarTarefaPage.java
          FormularioVerDetalhesTarefaPage.java
          LoginPage.java
          LoginPasswordPage.java
          MinhaVisaoPage.java

```
___
**Casos de Testes:**

LoginTest
    Não é permitido acessar a página de senha (login_password_page.php) sem informar Nome de usuario
    Permite entrar com Nome de usuário e Senha Válidos
    Não é permitido entrar com Nome de usuário vazio
    Não é permitido entrar com Senha vazia

TarefasTest
  PermiteCriarTarefaDadosValidosSucesso
  Não é permitido criar tarefa com token de segurança inválido
  Não é permitido criar tarefa sem informar Categoria
