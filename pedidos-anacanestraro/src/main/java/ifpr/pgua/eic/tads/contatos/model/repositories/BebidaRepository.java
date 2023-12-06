package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public interface BebidaRepository {

    Resultado<List<Bebida>> listarBebidas();

} 
