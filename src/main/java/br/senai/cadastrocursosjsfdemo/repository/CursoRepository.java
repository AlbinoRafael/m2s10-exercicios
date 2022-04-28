package br.senai.cadastrocursosjsfdemo.repository;

import br.senai.cadastrocursosjsfdemo.models.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CursoRepository {

    private List<Curso> cursos = new ArrayList<>();

    public List<Curso> obter() {
        return cursos;
    }

    public void inserir(Curso curso) {
        cursos.add(curso);
    }

    public void excluir(String codigo) {
        cursos.removeIf(curso -> curso.getCodigo().equals(codigo));
    }

    public void alterar(Curso cursoAtualizado) {
        if (cursoAtualizado != null) {
            for (Curso curso : cursos) {
                if (curso.getCodigo().equals(cursoAtualizado.getCodigo())) {
                    curso.setDataInicio(cursoAtualizado.getDataInicio());
                    curso.setDataTermino(cursoAtualizado.getDataTermino());
                    curso.setNome(cursoAtualizado.getNome());
                }
            }
        }
    }
}
