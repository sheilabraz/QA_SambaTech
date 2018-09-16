package teste;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.PaginaLogin;
import pages.PaginaRedefinirSenha;
import utils.GeradorData;
import utils.Screenshot;
import utils.Web;
import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "RedefinirSenhaDados.csv")

public class RedefinirSenha
{
    private WebDriver navegador;

    @Rule
    public TestName nomeTeste = new TestName(); // para obter o nome do teste que foi executado

    @Before
    public void SetUp() {navegador = Web.criarChrome("http://web1.qa.sambatech.com:10000");}

    @Test
    public void testRedefinirSenha(@Param(name="email")String email,@Param(name="mensagem")String mensagem)
    {
        String mensagemAtual = new PaginaLogin(navegador)
                .ClicarEsqueciMinhaSenha()
                .InformarEmail(email)
                .ClicarProsseguir()
                .RetornaMensagem();

        mensagemAtual= mensagemAtual.replace(",","");

        String screenshotArquivo = "C:\\Users\\test-report\\"+ GeradorData.dataHoraParaArquivo() +"_"+ nomeTeste.getMethodName() +".png";
        Screenshot.printTela(navegador, screenshotArquivo);

        assertEquals(mensagem, mensagemAtual);


    }
    @Test
    public void testRedefinirSenhaEmailValido()
    {
        String mensagemAtual = new PaginaLogin(navegador)
                .ClicarEsqueciMinhaSenha()
                .InformarEmail("avaliacao_qa_samba@sambatech.com.br")
                .ClicarProsseguir()
                .RetornaMensagemEmailValido();

        String screenshotArquivo = "C:\\Users\\test-report\\"+ GeradorData.dataHoraParaArquivo() +"_"+ nomeTeste.getMethodName() +".png";
        Screenshot.printTela(navegador, screenshotArquivo);

        assertEquals("Falta pouco! Enviamos um email com instruções para redefinição da sua senha.",mensagemAtual);
    }
    @After
    public void TearDown()
    {
        navegador.quit();
    }
}