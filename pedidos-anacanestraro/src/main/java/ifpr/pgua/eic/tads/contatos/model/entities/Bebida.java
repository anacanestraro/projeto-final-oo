package ifpr.pgua.eic.tads.contatos.model.entities;

public class Bebida {
    private int id;
    private String nome;
    private double valor;

    public Bebida(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString(){
        return "Nome:"+nome+"Valor:"+valor;
    }
}
