package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaBase {
    protected WebDriver navegador;

    public PaginaBase (WebDriver navegador)
    {
        this.navegador = navegador;
    }


}
