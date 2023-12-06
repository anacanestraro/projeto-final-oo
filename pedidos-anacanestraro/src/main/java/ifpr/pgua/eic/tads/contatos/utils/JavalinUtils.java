package ifpr.pgua.eic.tads.contatos.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;

public class JavalinUtils {
    
    public static Javalin makeApp(int port){
        
        JavalinRenderer.register((filePath, model, ctx) -> {
            try{
                               
                PebbleEngine engine = new PebbleEngine.Builder().build();
                PebbleTemplate template = engine.getTemplate(filePath);
                StringWriter writer = new StringWriter();
            
                template.evaluate(writer, (Map<String,Object>)model);
                return writer.toString();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }, ".html",".peb");

        
        Javalin app = Javalin.create(config->{
            config.requestLogger.http((ctx, ms) -> {
                System.out.println(ctx.fullUrl());
            });
            config.staticFiles.add("/public",Location.CLASSPATH);
        }).start(port);
        return app;
    }


}
