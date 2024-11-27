package src.models;

public class Casa extends Imovel {
    private boolean temPiscina;

    public Casa(String descricao, String endereco, double preco, boolean temPiscina) {
        super(descricao, endereco, preco);
        this.temPiscina = temPiscina;
    }

    public boolean temPiscina() {
        return temPiscina;
    }

    @Override
    public String toString() {
        return "Casa{descricao='" + getDescricao() + "', endereco='" + getEndereco() + "', preco=" + getPreco() + ", temPiscina=" + temPiscina + "}";
    }
}
