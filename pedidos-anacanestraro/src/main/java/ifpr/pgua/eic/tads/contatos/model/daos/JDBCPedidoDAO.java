package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class JDBCPedidoDAO implements PedidoDAO{

    private FabricaConexoes fabricaConexao;

    public JDBCPedidoDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Resultado<Pedido> criarPedido(Pedido pedido) {
      try (Connection con = fabricaConexao.getConnection();) {

            PreparedStatement pstm = con.prepareStatement("INSERT INTO oo_pedidos(observacao,bebida) VALUES (?,?)");

            pstm.setString(1, pedido.getObservacao());
            pstm.setObject(2, pedido.getBebida());

            pstm.executeUpdate();

            return Resultado.sucesso("Pedido cadastrado!", pedido);
        } catch (SQLException e) {
            return Resultado.erro("Problema ao conectar " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try (Connection con = fabricaConexao.getConnection();) {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM oo_pedidos");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                String bebida = rs.getString("bebida");

                Pedido pedido = new Pedido(id, observacao, bebida);

                pedidos.add(pedido);
            }
            con.close();
            return Resultado.sucesso("Pedidos carregadas", pedidos);
        } catch (SQLException e) {
            return Resultado.erro("Problema ao fazer seleção!! " + e.getMessage());
        }
    }
    
}
