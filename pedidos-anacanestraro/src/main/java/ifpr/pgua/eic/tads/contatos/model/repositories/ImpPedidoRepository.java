package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImpPedidoRepository implements PedidoRepository{

    private PedidoDAO dao;

    public ImpPedidoRepository(PedidoDAO dao, BebidaDAO bebidaDAO){
        this.dao = dao;
    }
    @Override
    public Resultado<Pedido> criarPedido(String observacao, Bebida bebida) {
        if(observacao.isBlank() || observacao.isEmpty()){
            return Resultado.erro("Observacao inválida");
        }

        Pedido pedido = new Pedido(observacao, bebida);

        return dao.criarPedido(pedido);
        
    }
    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        return dao.listarPedidos();
    }
    
}