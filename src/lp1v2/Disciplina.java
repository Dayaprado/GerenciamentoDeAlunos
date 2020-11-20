/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import projeto_v1.*;
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
        List<Estudante> d = new ArrayList<>();
        for(Matricula m: this.matriculas){
            d.add(m.getEstudante());
        }
        
        return d;
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
