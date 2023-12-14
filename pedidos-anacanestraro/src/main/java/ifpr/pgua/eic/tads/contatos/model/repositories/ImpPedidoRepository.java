package ifpr.pgua.eic.tads.contatos.model.repositories;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tads.contatos.model.daos.BebidaDAO;
import ifpr.pgua.eic.tads.contatos.model.daos.PedidoDAO;
import ifpr.pgua.eic.tads.contatos.model.entities.Bebida;
import ifpr.pgua.eic.tads.contatos.model.entities.Pedido;

public class ImpPedidoRepository implements PedidoRepository{

    private PedidoDAO dao;
    private BebidaDAO bebidaDAO;

    public ImpPedidoRepository(PedidoDAO dao, BebidaDAO bebidaDAO){
        this.dao = dao;
        this.bebidaDAO = bebidaDAO;
    }

    @Override
    public Resultado<Pedido> criarPedido(String observacao, Bebida bebida) {

        Pedido pedido = new Pedido(observacao, bebida);

        return dao.criarPedido(pedido);
        
    }
    @Override
    public Resultado<List<Pedido>> listarPedidos() {
        Resultado<List<Pedido>> resultado = dao.listarPedidos();

        if(resultado.foiSucesso()){
            List<Pedido> pedidos = resultado.comoSucesso().getObj();

            for(Pedido p: pedidos){
                Resultado<Bebida> resul = bebidaDAO.buscarBebida(p);
                
                if(resul.foiErro()){
                    return resul.comoErro();
                }else{
                    p.setBebida(resul.comoSucesso().getObj());
                }
            }
        }
        return resultado;
    }
    
}