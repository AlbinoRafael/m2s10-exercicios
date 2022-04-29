package br.senai.cadastrocursosjsfdemo.repository;

import br.senai.cadastrocursosjsfdemo.models.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CursoRepository {

    private List<Curso> cursos = new ArrayList<>();

    public CursoRepository(){
        cursos.add(new Curso("C01", "Curso de Java", LocalDate.of(2023, Month.JANUARY,1), LocalDate.of(2023, Month.FEBRUARY,1)));
        cursos.add(new Curso("C02", "Curso de JSF", LocalDate.of(2023, Month.FEBRUARY,1), LocalDate.of(2023, Month.MARCH,1)));
        cursos.add(new Curso("C03", "Curso de Primefaces", LocalDate.of(2023, Month.MARCH,1), LocalDate.of(2023, Month.APRIL,1)));
    }
    public List<Curso> obterCursos() {
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
    public boolean existe(String codigo) {
        return cursos.stream().anyMatch(l -> l.getCodigo().equals(codigo));
    }
}
