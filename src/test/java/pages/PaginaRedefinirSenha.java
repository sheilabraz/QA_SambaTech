package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaRedefinirSenha extends PaginaBase {
    public PaginaRedefinirSenha(WebDriver navegador) {
        super(navegador);
    }

    public PaginaRedefinirSenha InformarEmail(String email)
    {
        By idCampoEmail = By.name("email");

        WebDriverWait aguardarElemento = new WebDriverWait(navegador,10);
        WebElement campoEmail = aguardarElemento.until(ExpectedConditions.presenceOfElementLocated (idCampoEmail));
        campoEmail.sendKeys(email);

        return this;
    }
    public PaginaRedefinirSenha ClicarProsseguir()
    {
        navegador.findElement(By.xpath("//button[contains(text(),'Prosseguir')]")).click();

        return this;
    }

    public String RetornaMensagem()
    {
        return navegador.findElement(By.xpath("//div[@class = 'alert alert-error']/span")).getText();
    }
    public String RetornaMensagemEmailValido()
    {
        return navegador.findElement(By.xpath("//div[@class = 'alert alert-info']")).getText();
    }


}
