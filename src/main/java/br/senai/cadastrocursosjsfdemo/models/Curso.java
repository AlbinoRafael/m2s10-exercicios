package br.senai.cadastrocursosjsfdemo.models;

import java.time.LocalDate;
import java.util.Objects;

public class Curso {

    private String codigo;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    public Curso() {
    }

    public Curso(String codigo, LocalDate dataInicio, LocalDate dataTermino) {
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codigo.equals(curso.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                '}';
    }
}
