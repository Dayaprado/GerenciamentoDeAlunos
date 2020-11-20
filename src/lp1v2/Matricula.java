/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

/**
 *
 * @author dayprado
 */
public class Matricula {

    private Estudante estudante;
    private Disciplina disciplina;

    public Matricula(Estudante estudante, Disciplina disciplina) {
        estudante.addMatricula(this);
        disciplina.addMatricula(this);

        this.estudante = estudante;
        this.disciplina = disciplina;

    }

    public Estudante getEstudante() {
        return estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
