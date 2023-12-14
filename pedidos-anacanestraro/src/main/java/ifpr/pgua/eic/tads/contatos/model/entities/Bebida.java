package ifpr.pgua.eic.tads.contatos.model.entities;

public class Bebida {
    private int id;
    private String nome;
    private Double valor;

    
    public Bebida(int id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    public Bebida(String nome, Double valor2) {
        this.nome = nome;
        this.valor = valor2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String toString(){
        return "Nome:"+nome+"Valor:"+valor;
    }
}
