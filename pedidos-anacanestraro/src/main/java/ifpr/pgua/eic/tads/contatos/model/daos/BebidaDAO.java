package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public interface BebidaDAO {

    Resultado<Bebida> addBebida(Bebida bebida);
    Resultado<List<Bebida>> listarBebidas();
    Resultado<Bebida> buscarBebida(Pedido pedido);
}
