package ifpr.pgua.eic.tads.contatos.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class JDBCPedidoDAO implements PedidoDAO {

    private FabricaConexoes fabricaConexao;

    public JDBCPedidoDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Resultado<Pedido> criarPedido(Pedido pedido) {
        try (Connection con = fabricaConexao.getConnection();) {

            PreparedStatement pstm = con.prepareStatement("INSERT INTO oo_pedidos(observacao,bebida) VALUES (?,?)");

            pstm.setInt(1, pedido.getBebida().getId());
            pstm.setString(2, pedido.getObservacao());
            pstm.setObject(3, pedido.getBebida());

            pstm.executeUpdate();

            return Resultado.sucesso("Pedido cadastrado!", pedido);
        } catch (SQLException e) {
            return Resultado.erro("Problema ao conectar " + e.getMessage());
        }
    }

    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            Connection con = fabricaConexao.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM oo_pedidos inner join oo_bebida on oo_pedidos.id_bebida = oo_bebida.id_bebida \r\n" + "ORDER BY ´oo_pedidos´ . ´id_pedido´ ASC");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_pedido");
                Bebida bebida = new Bebida(rs.getInt("id_bebida"), rs.getString("nome"), rs.getDouble("valor"));
                String observacao = rs.getString("observacao");

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
