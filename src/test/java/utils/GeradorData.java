package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// classe para gerar datas que serão utilizadas nos prints realizados.
public class GeradorData {
    public static String dataHoraParaArquivo()
    {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
