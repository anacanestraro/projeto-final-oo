package ifpr.pgua.eic.tads.contatos.model.daos;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;
import ifpr.pgua.eic.tads.contatos.model.FabricaConexoes;

import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;

public class JDBCBebidaDAO implements BebidaDAO{

    private FabricaConexoes fabricaConexao;

    public JDBCBebidaDAO(FabricaConexoes fabricaConexao) {
        this.fabricaConexao = fabricaConexao;
    }

    @Override
    public Resultado<List<Bebida>> listarBebidas() {
      ArrayList<Bebida> bebidas = new ArrayList<>();
      try(Connection con = fabricaConexao.getConnection();){
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM oo_tarefas");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String valor = rs.getString("valor");

                Bebida bebida = new Bebida(id, nome, valor);

                bebidas.add(bebida);
            }
            con.close();
            return Resultado.sucesso("Bebidas carregadas", bebidas);
        } catch (SQLException e) {
            return Resultado.erro("Problema ao fazer seleção!! " + e.getMessage());
        }
      }
    }
    

