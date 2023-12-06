package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.HashMap;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;
import ifpr.pgua.eic.tads.contatos.model.repositories.PedidoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddPedidoController {
    private PedidoRepository repositorio;

    public AddPedidoController(PedidoRepository repositorio){
        this.repositorio = repositorio;

    }

    public Handler get = (Context ctx)->{
        ctx.render("templates/add.peb");
    };

    public Handler post = (Context ctx)->{
        String observacao = ctx.formParam("observacao");
        String bebida = ctx.formParam("bebida");
        
        Resultado<Pedido> resultado = repositorio.criarPedido(observacao, bebida);

        Map<String, Object> model = new HashMap<>();
        model.put("resultado", resultado);
        if(resultado.foiErro()){
            model.put("observacao", observacao);
            model.put("bebida", bebida);
        }

        ctx.render("templates/add.peb", model);

    };
}
