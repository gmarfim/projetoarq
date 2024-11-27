package src;

import src.controllers.UsuariosCadastrados;
import src.controllers.CorretorController;
import src.models.Imovel;
import src.models.Casa;
import src.models.Apartamento;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Instância da classe UsuariosCadastrados para o login
        UsuariosCadastrados usuariosCadastrados = new UsuariosCadastrados();
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("Bem-vindo ao sistema de login!");
        System.out.println("====================================");

        // Solicitar e-mail para o login
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        // Solicitar senha para o login
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Verificar se o e-mail e senha informados são válidos
        if (usuariosCadastrados.autenticar(email, senha)) {
            System.out.println("Login bem-sucedido!");

            // Instancia a classe CorretorController para controlar as operações de imóveis
            CorretorController corretorController = new CorretorController();

            // Menu de operações
            int opcao = -1;
            while (opcao != 0) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Listar Imóveis");
                System.out.println("2. Adicionar Imóvel");
                System.out.println("0. Sair");
                System.out.print("Digite a opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        // Listar os imóveis cadastrados
                        corretorController.listarImoveis();
                        break;

                    case 2:
                        // Adicionar um novo imóvel
                        System.out.println("Escolha o tipo de imóvel a ser adicionado:");
                        System.out.println("1. Casa");
                        System.out.println("2. Apartamento");
                        int tipoImovel = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha

                        System.out.print("Descrição do imóvel: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Endereço do imóvel: ");
                        String endereco = scanner.nextLine();
                        System.out.print("Preço do imóvel: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a nova linha

                        // Adiciona o imóvel dependendo do tipo selecionado
                        if (tipoImovel == 1) {
                            System.out.print("O imóvel tem piscina? (true/false): ");
                            boolean temPiscina = scanner.nextBoolean();
                            Casa casa = new Casa(descricao, endereco, preco, temPiscina);
                            corretorController.adicionarImovel(casa);
                        } else if (tipoImovel == 2) {
                            System.out.print("Número de quartos: ");
                            int numeroQuartos = scanner.nextInt();
                            Apartamento apartamento = new Apartamento(descricao, endereco, preco, numeroQuartos);
                            corretorController.adicionarImovel(apartamento);
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

        } else {
            // Caso a autenticação falhe, mostrar erro
            System.out.println("E-mail ou senha incorretos. Tente novamente.");
        }

        // Fechar o scanner após o uso
        scanner.close();
    }
}
