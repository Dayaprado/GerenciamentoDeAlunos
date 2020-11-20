/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_v1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author dayprado
 */
public class Principal {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //caminho dos arquivos que estao dentro do pacote java.
        String arqDisciplinas = "./src/arquivos/arqDisciplinas.txt";
        String arqEstudantes = "./src/arquivos/arqEstudantes.txt";
        String arqMatriculas = "./src/arquivos/arqMatriculas.txt";

        
        // instanciando as classes
        nome = "Centro_Universitario SENAC";
        centro_universitario = new Centro_Universitario(nome); // new é instância
        
        // Embaixo rola a magica: Carregamos os dados do TXT dentro de ArrayLists
        centro_universitario.carregarDadosArquivo(arqDisciplinas, arqEstudantes, arqMatriculas);    

        GestaoAcademicaApp2 gestao = new GestaoAcademicaApp2(centro_universitario);
        gestao.executar();
    }
    
    private static Centro_Universitario centro_universitario;
    private static String nome;
}
