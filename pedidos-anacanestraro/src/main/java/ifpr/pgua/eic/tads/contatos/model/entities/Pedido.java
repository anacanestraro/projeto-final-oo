
package ifpr.pgua.eic.tads.contatos.model.entities;

public class Pedido {
    private int id;
    private String observacao;
    private Bebida bebida;
    
    
    public Pedido(String observacao, Bebida bebida) {
        this.observacao = observacao;
        this.bebida = bebida;
   
    }

    public Pedido(int id, String observacao, Bebida bebida) {
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

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }


    public String toString(){
        return "Número do pedido:"+id+" Bebida: "+bebida+" Observação: "+observacao;
    }
    
}
