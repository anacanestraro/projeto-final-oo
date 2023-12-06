package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public interface BebidaDAO {
    Resultado<List<Bebida>> listarBebidas();
}
