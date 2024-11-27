package src.controllers;

import java.util.ArrayList;
import java.util.List;

public class UsuariosCadastrados {

    // Lista de usuários cadastrados
    private List<Usuario> usuarios;

    public UsuariosCadastrados() {
        usuarios = new ArrayList<>();

        // Adiciona alguns usuários de exemplo
        usuarios.add(new Usuario("marfim@email.com", "senha123", "Marfim"));
        usuarios.add(new Usuario("teste@teste.com", "teste", "Teste"));
    }

    // Método para autenticar usuário
    public boolean autenticar(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true;  // Autenticação bem-sucedida
            }
        }
        return false;  // Se não encontrar o usuário ou senha, retorna falso
    }

    // Classe interna para representar um usuário
    private class Usuario {
        private String email;
        private String senha;
        private String nome;

        public Usuario(String email, String senha, String nome) {
            this.email = email;
            this.senha = senha;
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public String getSenha() {
            return senha;
        }

        public String getNome() {
            return nome;
        }
    }
}
