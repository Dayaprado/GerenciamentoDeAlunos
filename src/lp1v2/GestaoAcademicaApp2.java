/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import projeto_v1.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dayprado
 */
public class GestaoAcademicaApp2 {

    private String delimitador = "  :   ";
    private Centro_Universitario centro;

    public GestaoAcademicaApp2(Centro_Universitario centroUnitario) {
        this.centro = centroUnitario;
    }

    public List<String> getTodosEstudante() {
        List<String> nomes = new ArrayList<>();

        List<Estudante> estudantes = centro.getEstudantes();
        for (Estudante estudante : estudantes) {
            nomes.add(estudante.getId() + ": "
                    + estudante.getNome() + ": "
                    + estudante.getTotalCreditos() + ": "
                    + estudante.getInfoComplementar()
            );
        }

        return nomes;
    }

    public List<String> getTodasDisiciplinas() {
        List<String> codigos = new ArrayList<>();

        List<Disciplina> disciplinas = centro.getDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            codigos.add(disciplina.getCodigo());
        }

        return codigos;
    }

    public List<String> getAlunosMatriculados(String codDisci) {
        List<String> alunos = new ArrayList<>();

        List<Matricula> matriculas = centro.getMatriculas();
        for (Matricula matricula : matriculas) {
            String disciplina = matricula.getDisciplina().getCodigo();
            if (codDisci.equals(disciplina)) {
                Estudante aluno = matricula.getEstudante();
                alunos.add(
                    aluno.getId() + delimitador + 
                    aluno.getNome() + delimitador +
                    aluno.getEmail() + delimitador +
                    aluno.getTotalCreditos() + delimitador +
                    aluno.getInfoComplementar()
                );

            }
        }

        return alunos;
    }

    public List<String> getDisciplinasAluno(String codAluno) {
        List<String> disciplinas = new ArrayList<>();

        List<Matricula> matriculas = centro.getMatriculas();
        for (Matricula matricula : matriculas) {
            long id = matricula.getEstudante().getId();
            if (Long.parseLong(codAluno) == id) {
                Disciplina disciplina = matricula.getDisciplina();
                disciplinas.add(
                    disciplina.getCodigo() + delimitador +
                    disciplina.getCreditos()
                );
            }
        }

        return disciplinas;
    }

    public int getCreditosAluno(String codAluno) {
        int creditos = 0;

        List<Matricula> matriculas = centro.getMatriculas();
        for (Matricula matricula : matriculas) {
            long id = matricula.getEstudante().getId();
            if (Long.parseLong(codAluno) == id) {
                creditos += matricula.getEstudante().getTotalCreditos();
            }
        }

        return creditos;
    }

    public void executar() {
        System.out.println("Bem vindo ao Centro Acadêmico");
        menu();
    }

    private int menu() {
        System.out.println("");
        System.out.println("Por favor, escolha a opção abaixo:");
        System.out.println("1 - Listar Estudantes");
        System.out.println("2 - Listar Disciplinas");
        System.out.println("3 - Listar Alunos por Disciplina");
        System.out.println("4 - Detalhes do Aluno");
        System.out.println("");
        System.out.println("");

        Scanner leitor = new Scanner(System.in);
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                listaTodosEstudante();
                break;
            case 2:
                listaTodasDisiciplinas();
                break;
            case 3:
                System.out.print("Por favor, preencha o código da disciplina: ");
                String codD = leitor.next();
                listaAlunosMatriculados(codD);
                break;
            case 4:
                System.out.print("Por favor, preencha o matrícula do aluno: ");
                String codA = leitor.next();
                listaDisciplinasDoAluno(codA);
                break;
            case -1:
                return -1;
            default:
                System.out.println("Opção inválida, tente novamente");
                menu();
        }

        if (opcao > -1) {
            menu();
        }

        return -1;
    }

    private void listaTodosEstudante() {
        List<String> estudantes = getTodosEstudante();

        System.out.println(":: Lista de Alunos ::");
        for (String item : estudantes) {
            System.out.println(item);
        }
    }

    private void listaTodasDisiciplinas() {
        List<String> disciplinas = getTodasDisiciplinas();

        System.out.println(":: Lista de Disciplinas ::");
        for (String item : disciplinas) {
            System.out.println(item);
        }
    }

    private void listaAlunosMatriculados(String codigoDisciplina) {
        List<String> alunos = getAlunosMatriculados(codigoDisciplina);

        System.out.println(":: Disciplina (" + codigoDisciplina + ") ::");
        System.out.println("> Alunos Matriculados");
        for (String item : alunos) {
            System.out.println(item);
        }
        System.out.print("Total de Alunos: " + alunos.size());
        System.out.println("");
    }

    private void listaDisciplinasDoAluno(String codigoAluno) {
        List<String> disciplinas = getDisciplinasAluno(codigoAluno);
        int total = getCreditosAluno(codigoAluno);

        System.out.println(":: Aluno (" + codigoAluno + ") ::");
        System.out.println("> Disciplinas Matriculadas");
        for (String item : disciplinas) {
            System.out.println(item);
        }
        System.out.print("Total de Créditos: " + total);
        System.out.println("");
    }
}
