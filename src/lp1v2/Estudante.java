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
public abstract class Estudante {

    protected long id;
    protected String nome;
    protected String email;
    protected List<Matricula> matriculas;

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matriculas = new ArrayList<Matricula>();
    }

    public void addMatricula(Matricula m) {
        this.matriculas.add(m);
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return new ArrayList<Disciplina>();
    }
    
    public int getTotalCreditos() {
        return 0;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
