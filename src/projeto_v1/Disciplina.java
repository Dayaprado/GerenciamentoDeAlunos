/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_v1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dayprado
 */
public class Disciplina {

    private String codigo;
    private int creditos;
    private List<Matricula> matriculas;

    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.matriculas = new ArrayList<Matricula>();
    }

    public void addMatricula(Matricula m) {
        matriculas.add(m);
    }

    public List<Estudante> getEstudantesMatriculados() {
        return new ArrayList<Estudante>();
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
