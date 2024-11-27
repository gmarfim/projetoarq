package src.models;

public abstract class Imovel {
    private String descricao;
    private String endereco;
    private double preco;

    public Imovel(String descricao, String endereco, double preco) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public abstract String toString();
}
