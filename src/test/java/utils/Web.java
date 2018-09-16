package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver criarChrome(String url)
    {
        // Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get(url);

        return navegador;
    }
}
