package src.models;

public class Apartamento extends Imovel {
    private int numeroQuartos;

    public Apartamento(String descricao, String endereco, double preco, int numeroQuartos) {
        super(descricao, endereco, preco);
        this.numeroQuartos = numeroQuartos;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    @Override
    public String toString() {
        return "Apartamento{descricao='" + getDescricao() + "', endereco='" + getEndereco() + "', preco=" + getPreco() + ", numeroQuartos=" + numeroQuartos + "}";
    }
}
