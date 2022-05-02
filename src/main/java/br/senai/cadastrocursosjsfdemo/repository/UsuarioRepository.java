package br.senai.cadastrocursosjsfdemo.repository;

import br.senai.cadastrocursosjsfdemo.models.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository() {
        this.usuarios.add(new Usuario("testeson@teste.com", "Testeson Tester", "1234teste", "USER"));
        this.usuarios.add(new Usuario("testerina@teste.com", "Testerina Tester", "1234admin", "ADMIN"));
    }


    public List<Usuario> obterUsuarios() {
        Collections.sort(usuarios, Comparator.comparing((Usuario::getNome)));
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> obterPor(String email, String senha) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equals(email))
                .filter(u -> u.getSenha().equals(senha))
                .findFirst();
    }
}
