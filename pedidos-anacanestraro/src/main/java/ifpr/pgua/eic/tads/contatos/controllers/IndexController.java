package ifpr.pgua.eic.tads.contatos.controllers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class IndexController{
    public Handler get = (Context ctx)->{
        ctx.render("templates/index.peb");
    };
}
