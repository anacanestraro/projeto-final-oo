package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public class ImpBebidaRepository implements BebidaRepository{

    private BebidaDAO dao;
    
    public ImpBebidaRepository(BebidaDAO dao){
        this.dao = dao;

    }

    @Override
    public Resultado<List<Bebida>> listarBebidas() {
       return dao.listarBebidas();
    }

    @Override
    public Resultado<Bebida> addBebida(String nome, double valor) {
        if(nome.isBlank()||nome.isEmpty()){
            return Resultado.erro("Nome inválido");
        }
        
        Bebida bebida = new Bebida(nome, valor);
        return dao.addBebida(bebida);
    }
}
