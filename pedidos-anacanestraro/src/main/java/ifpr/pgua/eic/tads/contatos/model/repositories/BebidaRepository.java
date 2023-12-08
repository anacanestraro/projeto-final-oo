package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public interface BebidaRepository {
    Resultado<Bebida> addBebida(String nome, double valor);
    Resultado<List<Bebida>> listarBebidas();
    Resultado<Bebida> buscarID(int id);

} 
