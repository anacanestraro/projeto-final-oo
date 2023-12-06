package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public interface PedidoRepository {

   Resultado<Pedido> criarPedido(String observacao, String bebida);
    Resultado<List<Pedido>> listarPedidos();
}
