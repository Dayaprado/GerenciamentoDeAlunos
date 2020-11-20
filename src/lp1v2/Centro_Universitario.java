/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dayprado
 */
public class Centro_Universitario {

    private String nome;
    private List<Estudante> estudantes;
    private List<Disciplina> disciplinas;
    private List<Matricula> matriculas;

    public Centro_Universitario(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<Estudante>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.matriculas = new ArrayList<Matricula>();
    }

    public void carregarDadosDisciplina(String arqDisciplinas) {
        carregarDisciplinas(arqDisciplinas);
    }
    
    public void carregarDadosArquivo(String arqDisciplinas, String arqEstudantes, String arqMatriculas) {
        carregarEstudantes(arqEstudantes);
        carregarDisciplinas(arqDisciplinas);
        carregarMatriculas(arqMatriculas);
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    private void carregarMatriculas(String arqMatriculas) {
        BufferedReader reader = null;
        try {
            String linha;
            reader = new BufferedReader(new FileReader(arqMatriculas));
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(":");
                int ie = findEstudanteById(Integer.parseInt(campos[0]));
                int id = findDisciplinaByCodigo(campos[1]);

                Matricula matricula = new Matricula(estudantes.get(ie), disciplinas.get(id));
                matriculas.add(matricula);

            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }

    private void carregarDisciplinas(String arqDisciplinas) {
        BufferedReader reader = null;
        try {
            String linha;
            reader = new BufferedReader(new FileReader(arqDisciplinas));
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(":");
                Disciplina disciplina = new Disciplina(
                        campos[0],
                        Integer.parseInt(campos[1])
                );

                disciplinas.add(disciplina);
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }

    private void carregarEstudantes(String arqEstudantes) {
        BufferedReader reader = null;
        // Vc usa o try para gerenciar exceções no Java
        // Exceções são códigos que vc não tem certeza que vão dar certo
        // Como por exemplo, acessar um arquivo externo, não a garantia que o arquivo estara disponivel
        
        // É diferente de por exemplo int a = 1+1; <--- vc tem certeza que isso funciona, certo?
        try {
            String linha;
            // Aqui vc usa objeto java que le arquivo e carrega na memoria 
            // (objeto pq vc deu um 'new')
            reader = new BufferedReader(new FileReader(arqEstudantes));
            while ((linha = reader.readLine()) != null) {
                // Split é pq vc precisou quebrar a informacao (ela ta separada por ':')
                Estudante estudante = null;
                String[] campos = linha.split(":");
                
                if(campos[3].equals("GRAD")){
                    estudante = carregarGradEstudantes(campos);
                }else{
                    estudante = carregarPosEstudantes(campos);                
                }
                
                // adiciona os resultados emuma propriedade da classe, para ser usada depois
                // tipo uma tabela de banco de dados, só que dentro do java, sacou?
                estudantes.add(estudante);
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
    }
    
    
    private Estudante carregarPosEstudantes(String[] campos) {
        Estudante estudante = new EstudantePos(
            Long.parseLong(campos[0]),
            campos[1],
            campos[2],
            campos[4],
            campos[5]
        );
        
        return estudante;
    }
    
    private Estudante carregarGradEstudantes(String[] campos) {
        Estudante estudante = new EstudanteGrad(
            Long.parseLong(campos[0]),
            campos[1],
            campos[2],
            Integer.parseInt(campos[4]) 
        );
        
        return estudante;
    }    

    private int findEstudanteById(int id) {
        for (int i = 0; i < estudantes.size(); i++) {
            if (id == estudantes.get(i).getId()) {
                return i; //estudante encontrado
            }
        }
        return -1;
    }

    private int findDisciplinaByCodigo(String codigo) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (codigo.equals(disciplinas.get(i).getCodigo())) {
                return i;
            }
        }
        return -1;
    }
}
