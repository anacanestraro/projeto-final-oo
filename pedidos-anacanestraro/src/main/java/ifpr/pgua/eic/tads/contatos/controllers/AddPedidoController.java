package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.HashMap;

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

    public AddPedidoController(PedidoRepository repositorioPedido){
        this.repositorioPedido = repositorioPedido;

    }

    public Handler get = (Context ctx)->{
        ctx.render("templates/add.peb");
    };

    public Handler post = (Context ctx)->{
        String observacao = ctx.formParam("observacao");
        Bebida bebida = ctx.formParam("bebida");

        Resultado<Pedido> resultado = repositorioPedido.criarPedido(observacao, bebida);
        
        Map<String, Object> model = new HashMap<>();
        model.put("resultado", resultado);
        if(resultado.foiErro()){
            model.put("observacao", observacao);
            model.put("bebida", bebida);
        }

        ctx.render("templates/add.peb", model);

    };
}
