package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GeradorData;
import utils.Screenshot;

public class PaginaInicial extends PaginaBase {
    public PaginaInicial(WebDriver navegador) {
        super(navegador);
    }
    public String VerificaUsuarioLogado()
    {
        By idUsuarioLogado = By.xpath("//a[@class='dropdown-toggle']/span"); // elemento que exibe o nome do usuario logado

        WebDriverWait aguardarElemento = new WebDriverWait(navegador,30);
        WebElement usuarioLogado = aguardarElemento.until(ExpectedConditions.presenceOfElementLocated (idUsuarioLogado));

        String screenshotArquivo = "C:\\Users\\test-report\\"+ GeradorData.dataHoraParaArquivo() + "_VerificaUsuarioLogado.png";
        Screenshot.printTela(navegador, screenshotArquivo);

        return usuarioLogado.getText();
    }
}
