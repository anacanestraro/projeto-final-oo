package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public class ImpBebidaRepository implements BebidaRepository{

    private BebidaDAO dao;
    private List<Bebida> listaBebidas;
    
    public ImpBebidaRepository(BebidaDAO dao){
        this.dao = dao;
        this.listaBebidas = new ArrayList<>();
    }

    @Override
    public Resultado<List<Bebida>> listarBebidas() {
       return dao.listarBebidas();
    }

    @Override
    public Resultado<Bebida> addBebida(String nome, Double valor) {
        if(nome.isBlank()||nome.isEmpty()){
            return Resultado.erro("Nome inválido");
        }
        
        if(valor.isNaN() || valor<=0){
            return Resultado.erro("Valor inválido");
        }

        Bebida bebida = new Bebida(nome, valor);
        return dao.addBebida(bebida);
    }

    @Override
    public Resultado<Bebida> buscarID(int id) {
        if(listaBebidas.size() != 0){
            Bebida ret = listaBebidas.stream().filter(cat -> cat.getId() == id).findFirst().get();
            return Resultado.sucesso("Bebida encontrada", ret);
        }

        return Resultado.erro("Problema ao encotrar bebida");
    }
}
