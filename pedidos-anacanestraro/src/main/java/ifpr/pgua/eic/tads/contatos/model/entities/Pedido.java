
package ifpr.pgua.eic.tads.contatos.model.entities;

public class Pedido {
    private int id;
    private String observacao;
    private String bebida;
    
    
    public Pedido(String observacao, String bebida) {
        this.observacao = observacao;
        this.bebida = bebida;
   
    }

    public Pedido(int id, String observacao, String bebida) {
        this.id = id;
        this.observacao = observacao;
        this.bebida = bebida;
  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }


    public String toString(){
        return "Número do pedido:"+id+" Bebida: "+bebida+" Observação: "+observacao;
    }
    
}
