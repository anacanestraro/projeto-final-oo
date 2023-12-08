package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.HashMap;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddBebidaCrontroller {
    private BebidaRepository repositorio;

    public AddBebidaCrontroller(BebidaRepository repositorio){
        this.repositorio = repositorio;

    }
    public Handler get = (Context ctx )->{
        ctx.render("/templates/addBebida.peb");
    };

    public Handler post = (Context ctx) ->{
        String nome = ctx.formParam("nome");
        Double valor = Double.parseDouble(ctx.formParam("valor"));

        Resultado<Bebida> resultado = repositorio.addBebida(nome, valor);

        Map<String, Object> model = new HashMap<>();
        model.put("resultado", resultado);
        if (resultado.foiErro()) {
            model.put("nome", nome);
            model.put("valor", valor);

        }

        ctx.render("templates/addBebida.peb", model);
        
    };

}
