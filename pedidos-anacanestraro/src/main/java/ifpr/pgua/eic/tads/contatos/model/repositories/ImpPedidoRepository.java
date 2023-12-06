package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImpPedidoRepository implements PedidoRepository{

    private PedidoDAO dao;

    @Override
    public Resultado<Pedido> criarPedido(String observacao, String bebida) {
        if(observacao.isBlank() || observacao.isEmpty()){
            return Resultado.erro("Observacao inválida");
        }

        if(bebida.isBlank()||bebida.isEmpty()){
            return Resultado.erro("Bebida inválida");
        }

        Pedido pedido = new Pedido(observacao, bebida);

        return dao.criarPedido(pedido);
        
    }
    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        return dao.listarPedidos();
    }
    
}