package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddPedidoController {
    private PedidoRepository repositorioPedido;
    private BebidaRepository repositorioBebida;

    public AddPedidoController(PedidoRepository repositorioPedido, BebidaRepository repositorioBebida){
        this.repositorioPedido = repositorioPedido;
        this.repositorioBebida = repositorioBebida;

    }

    public Handler get = (Context ctx)->{
        Map<String, Object> model = new HashMap<>();

        Resultado<List<Bebida>> resultadoBebida = repositorioBebida.listarBebidas();

        model.put("bebidas", resultadoBebida.comoSucesso().getObj());       

        ctx.render("templates/add.peb", model);
    };

    public Handler post = (Context ctx)->{
        String observacao = ctx.formParam("observacao");
        String bebidaID = ctx.formParam("bebida");

        Resultado<Bebida> resultadoBebida = repositorioBebida.buscarID(Integer.valueOf(bebidaID));

        Bebida bebida = resultadoBebida.comoSucesso().getObj();

        Resultado<Pedido> resultado = repositorioPedido.criarPedido(observacao, bebida);
        
        Map<String, Object> model = new HashMap<>();

        model.put("resultado", resultado);

        if(resultado.foiErro()){
            model.put("bebidaID", Integer.valueOf(bebidaID));
            Resultado<List<Bebida>> ret = repositorioBebida.listarBebidas();
            model.put("bebidas", ret.comoSucesso().getObj());
        }

        ctx.render("templates/add.peb", model);

    };
}
