package br.senai.cadastrocursosjsfdemo.mbean;

import br.senai.cadastrocursosjsfdemo.models.Curso;
import br.senai.cadastrocursosjsfdemo.repository.CursoRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "cursoWebBean")
@SessionScoped
public class CursoWebBean implements Serializable {

    @Inject
    CursoRepository cursoRepository;

    Curso curso = new Curso();


    public String salvar() {
        boolean isCursoNovo = cursoRepository.obterCursos().stream()
                .noneMatch(c -> c.getCodigo().equals(curso.getCodigo()));
        if (isCursoNovo) {
            cursoRepository.inserir(curso);
        } else {
            cursoRepository.alterar(curso);
        }
        curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public void validarCodigoDuplicado(FacesContext facesContext, UIComponent component, Object o) throws ValidatorException {
        if (o == null)
            return;
        String codigo = (String) o;
        boolean jaCadastrado = cursoRepository.existe(codigo);
        if (jaCadastrado) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Validação", "Curso já cadastrado com codigo informado");
            throw new ValidatorException(msg);
        }
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
