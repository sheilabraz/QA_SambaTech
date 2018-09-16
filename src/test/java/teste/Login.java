package teste;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.PaginaInicial;
import pages.PaginaLogin;
import utils.Web;
import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginDados.csv")

public class Login
{
    private WebDriver navegador;

    @Before
    public void SetUp() {navegador = Web.criarChrome("http://web1.qa.sambatech.com:10000");}

    @Test
    public void testLoginSucesso()
    {
        String usuarioLogado;
        usuarioLogado = new PaginaLogin(navegador)
                .LogarSucesso("avaliacao_qa_samba@sambatech.com.br","123456789")
                .VerificaUsuarioLogado();

        assertEquals("Automação Samba - Teste QA",usuarioLogado);

    }

    @Test
    public void testLoginComSenhaNaoInformada()
    {
        String mensagem;
        mensagem = new PaginaLogin(navegador).LogarFalha("avaliacao_qa_samba@sambatech.com.br","");

        assertEquals("Email ou senha incorretos. Saiba Mais",mensagem);
    }
    @Test
    public void testLoginComSenhaInvalida()
    {
        String mensagem;
        mensagem = new PaginaLogin(navegador).LogarFalha("avaliacao_qa_samba@sambatech.com.br","987654321");

        assertEquals("Email ou senha incorretos. Saiba Mais",mensagem);
    }

    @Test
    public void testLoginSemCredenciais()
    {
        String mensagem;
        mensagem = new PaginaLogin(navegador).LogarFalha("","");

        assertEquals("Email ou senha incorretos. Saiba Mais",mensagem);
    }

    @Test
    public void testLoginComEmailInvalido()
    {
        String mensagem;
        mensagem = new PaginaLogin(navegador).LogarFalha("avaliacao_qa_samba.sambatech.com.br","123456789");

        assertEquals("Email ou senha incorretos. Saiba Mais",mensagem);
    }
// o teste abaixo substitui os testes 'testLoginComEmailInvalido','testLoginSemCredenciais', 'testLoginComSenhaInvalida','testLoginComSenhaNaoInformada'
    @Test
    public void testLoginFalha(@Param(name="email")String email,@Param(name="senha")String senha,@Param(name="mensagem")String mensagem)
    {
        String mensagemExibida;
        mensagemExibida = new PaginaLogin(navegador).LogarFalha(email,senha);

        assertEquals(mensagem,mensagemExibida);
    }

    @After
    public void TearDown()
    {
       navegador.quit();
    }
}
