package pages;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Screenshot;
import utils.GeradorData;

public class PaginaLogin extends PaginaBase {


    public PaginaLogin(WebDriver navegador) {
        super(navegador);
    }


    public PaginaLogin DigitarEmail(String email)
    {
        navegador.findElement(By.id("inputEmail")).sendKeys(email);
        return this;
    }

    public PaginaLogin DigitarSenha(String senha)
    {
        navegador.findElement(By.id("inputPassword")).sendKeys(senha);
        return this;
    }

    public PaginaLogin ClicarEntrar()
    {
        navegador.findElement(By.id("login")).click();
        return this;
    }

    public PaginaInicial LogarSucesso(String email, String senha)
    {
        DigitarEmail(email);
        DigitarSenha(senha);

        String screenshotArquivo = "C:\\Users\\test-report\\"+GeradorData.dataHoraParaArquivo() + "_LogarSucesso_Credenciais.png";
        Screenshot.printTela(navegador, screenshotArquivo);

        ClicarEntrar();

        return new PaginaInicial(navegador);
    }

    public String LogarFalha(String email, String senha)
    {
        DigitarEmail(email);
        DigitarSenha(senha);

        String screenshotArquivo = "C:\\Users\\test-report\\"+GeradorData.dataHoraParaArquivo() + "_LogarFalha_Credenciais.png";
        Screenshot.printTela(navegador, screenshotArquivo);

        ClicarEntrar();

        WebDriverWait aguardarElemento = new WebDriverWait(navegador,5);
        WebElement mensagemErroLogin = aguardarElemento.until(ExpectedConditions.presenceOfElementLocated (By.id("password_incorrect")));

        screenshotArquivo = "C:\\Users\\test-report\\"+GeradorData.dataHoraParaArquivo() + "_LogarFalha.png";
        Screenshot.printTela(navegador, screenshotArquivo);

        return mensagemErroLogin.getText();
    }
    public PaginaRedefinirSenha ClicarEsqueciMinhaSenha()
    {
        By idLinkEsqueciSenha = By.id("forgot-pwd-link");
        WebDriverWait aguardarElemento = new WebDriverWait(navegador,5);
        aguardarElemento.until(ExpectedConditions.elementToBeClickable(idLinkEsqueciSenha)).click();

        return new PaginaRedefinirSenha(navegador);
    }
}
