package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImpPedidoRepository implements PedidoRepository{

    BebidaDAO bebidaDAO;

    @Override
    public Resultado<Pedido> criarPedido(String observacao, String bebida) {

        
    }
    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPedidos'");
    }
    
}
