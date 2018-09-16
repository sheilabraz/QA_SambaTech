package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Screenshot {
    public static void printTela (WebDriver navegador, String arquivo)
    {
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);

        try
        {
            FileUtils.copyFile(screenshot,new File(arquivo));
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um erro ao copiar o arquivo de print para a pasta" + e.getLocalizedMessage());
        }
    }
}
