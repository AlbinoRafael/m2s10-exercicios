package br.senai.cadastrocursosjsfdemo.mbean;

import br.senai.cadastrocursosjsfdemo.models.Curso;
import br.senai.cadastrocursosjsfdemo.repository.CursoRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "listaCursoWebBean")
@SessionScoped
public class ListaCursoWebBean implements Serializable {

    @Inject
    CursoRepository cursoRepository;

    @Inject
    CursoWebBean cursoWebBean;

    private List<Curso> cursos = new ArrayList<>();

    public void onload() {   // vem do  f:event type="preRenderView"
        List<Curso> cursosBD = cursoRepository.obterCursos();
        cursos = cursosBD;
    }

    public String editarCurso(Curso cursoSelecionado) {
        cursoWebBean.setCurso(cursoSelecionado);
        return "cadastrocurso";
    }
    
    public String removerCurso(Curso curso) {
        cursoRepository.excluir(curso.getCodigo());
        this.cursos = cursoRepository.obterCursos();
        return null;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
