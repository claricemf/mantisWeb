package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static config.GeneralConfigManager.configuration;

public class Web {

    public static WebDriver createChrome(){
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(configuration().timeout()));
        navegador.get(configuration().url());
        return navegador;
    }
}
