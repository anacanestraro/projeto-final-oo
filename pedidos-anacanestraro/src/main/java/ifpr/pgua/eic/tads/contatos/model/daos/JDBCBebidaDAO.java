package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.FabricaConexoes;

public class JDBCBebidaDAO implements BebidaDAO {

    FabricaConexoes fabricaConexao;

    public JDBCBebidaDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Resultado<Bebida> addBebida(Bebida bebida) {
        try {
            Connection con = fabricaConexao.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO oo_bebida (nome,valor) VALUES (?,?)");

            pstm.setString(1, bebida.getNome());
            pstm.setDouble(2, bebida.getValor());

            pstm.executeUpdate();
            con.close();
            return Resultado.sucesso("Bebida cadastrada!", bebida);
        } catch (Exception e) {
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado<List<Bebida>> listarBebidas() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        try {
            Connection con = fabricaConexao.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM oo_bebida");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");

                Bebida bebida = new Bebida(id, nome, valor);

                bebidas.add(bebida);
            }
            con.close();
            return Resultado.sucesso("Bebidas carregadas", bebidas);
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }

}
