package src.persistent;

import src.models.Imovel;
import src.models.Casa;
import src.models.Apartamento;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaArquivo {

    private static final String ARQUIVO_IMOVEIS = "imoveis.txt";

    // Carregar imóveis do arquivo
    public List<Imovel> carregarImoveis() {
        List<Imovel> imoveis = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_IMOVEIS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length > 0) {
                    Imovel imovel = null;
                    if (partes[0].equals("Casa")) {
                        boolean temPiscina = Boolean.parseBoolean(partes[4]);
                        imovel = new Casa(partes[1], partes[2], Double.parseDouble(partes[3]), temPiscina);
                    } else if (partes[0].equals("Apartamento")) {
                        int numeroQuartos = Integer.parseInt(partes[4]);
                        imovel = new Apartamento(partes[1], partes[2], Double.parseDouble(partes[3]), numeroQuartos);
                    }
                    if (imovel != null) {
                        imoveis.add(imovel);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de imóveis.");
        }
        return imoveis;
    }

    // Salvar um novo imóvel no arquivo
    public void salvarImovel(Imovel imovel) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_IMOVEIS, true))) {
            String linha = imovelToString(imovel);
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o imóvel no arquivo.");
        }
    }

    // Converter o objeto Imóvel para o formato de string para salvar no arquivo
    private String imovelToString(Imovel imovel) {
        if (imovel instanceof Casa) {
            Casa casa = (Casa) imovel;
            return "Casa|" + casa.getDescricao() + "|" + casa.getEndereco() + "|" + casa.getPreco() + "|" + casa.temPiscina();
        } else if (imovel instanceof Apartamento) {
            Apartamento apartamento = (Apartamento) imovel;
            return "Apartamento|" + apartamento.getDescricao() + "|" + apartamento.getEndereco() + "|" + apartamento.getPreco() + "|" + apartamento.getNumeroQuartos();
        }
        return "";
    }
}
