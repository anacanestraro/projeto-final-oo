package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCBebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = JavalinUtils.makeApp(8080);

        BebidaDAO bebidaDAO = new JDBCBebidaDAO(FabricaConexoes.getInstance());
        
        
    }
}
