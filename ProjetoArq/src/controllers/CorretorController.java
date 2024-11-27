package src.controllers;

import src.models.Imovel;
import src.models.Casa;
import src.models.Apartamento;
import src.persistent.PersistenciaArquivo;

import java.util.List;

public class CorretorController {

    private PersistenciaArquivo persistenciaArquivo;

    public CorretorController() {
        this.persistenciaArquivo = new PersistenciaArquivo();
    }

    // Listar todos os imóveis
    public void listarImoveis() {
        List<Imovel> imoveis = persistenciaArquivo.carregarImoveis();
        if (imoveis.isEmpty()) {
            System.out.println("Não há imóveis cadastrados.");
        } else {
            System.out.println("Listagem dos Imóveis:");
            for (Imovel imovel : imoveis) {
                System.out.println(imovel);
            }
        }
    }

    // Adicionar imóvel
    public void adicionarImovel(Imovel imovel) {
        persistenciaArquivo.salvarImovel(imovel);
        System.out.println("Imóvel adicionado com sucesso!");
    }
}
