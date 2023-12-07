package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddPedidoController;
import ifpr.pgua.eic.tads.contatos.controllers.IndexController;
import ifpr.pgua.eic.tads.contatos.controllers.ListBebidasController;
import ifpr.pgua.eic.tads.contatos.controllers.ListPedidosController;
import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCBebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.JDBCPedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.ImpBebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.ImpPedidoRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
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
        BebidaRepository bebidaRepository = new ImpBebidaRepository(bebidaDAO);

        PedidoDAO pedidoDAO = new JDBCPedidoDAO(FabricaConexoes.getInstance());
        PedidoRepository pedidoRepository = new ImpPedidoRepository(pedidoDAO, bebidaDAO);

        IndexController indexController = new IndexController();
        AddPedidoController addPedidoController = new AddPedidoController(pedidoRepository);
        ListPedidosController listPedidosController = new ListPedidosController(pedidoRepository);

        ListBebidasController listBebidasController = new ListBebidasController(bebidaRepository);

        app.get("/", indexController.get);
        app.get("/add", addPedidoController.get);
        app.post("/add", addPedidoController.post);
        app.get("/list", listPedidosController.get);

        app.get("/addBebida", addBebidaController.get);
        app.post("/addBebida", addBebidaController);
        app.get("/listBebidas", listBebidasController.get);

        
        
    }
}