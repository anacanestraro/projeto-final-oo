package ifpr.pgua.eic.tads.contatos.controllers;

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
        Double valor = Double.parseDouble("valor");

        Resultado<Bebida> resutado = repositorio.
    };

}
