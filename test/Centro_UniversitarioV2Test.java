

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import lp1v2.*;

/**
 *
 * @author anacris
 */
public class Centro_UniversitarioV2Test {

    private String delimitador = "  :   ";
    private final GestaoAcademicaApp2 gestao;
    private final Centro_Universitario centro;
    private final String nomeCentro;

    public Centro_UniversitarioV2Test() {
        String nomeArquivoDisciplinas = "./src/arquivos/arqDisciplinas.txt";
        String nomeArquivoEstudantes = "./src/arquivos/arqEstudantesV2.txt";
        String nomeArquivoMatriculas = "./src/arquivos/arqMatriculasV2.txt";


        nomeCentro = "Centro_Universitario SENAC V2";
        centro = new Centro_Universitario(nomeCentro);
        centro.carregarDadosArquivo(nomeArquivoDisciplinas, 
                nomeArquivoEstudantes,
                nomeArquivoMatriculas);
        
        gestao = new GestaoAcademicaApp2(centro);
    }
    
    @Test
    public void testNomeCentro_Universitario() {
        String nomeObtido = centro.getNome();
        assertEquals(nomeCentro, nomeObtido);
    }
    
    @Test
    public void testContarTodosEstudantes(){
        List<Estudante> estudantes = centro.getEstudantes();
        List<String> buscados = gestao.getTodosEstudante();
        
        assertEquals(estudantes.size(), buscados.size());
    }
    
    @Test
    public void testBuscarTodosEstudantes(){
        List<Estudante> estudantes = centro.getEstudantes();
        List<String> buscados = gestao.getTodosEstudante();
        
        for (Estudante estudante : estudantes) {
            String esperado = 
                    estudante.getId() + ": "
                    + estudante.getNome() + ": "
                    + estudante.getTotalCreditos() + ": "
                    + estudante.getInfoComplementar();
            
            assertTrue(buscados.contains(esperado));
        }
    }

    @Test
    public void testContarTodosDisciplinas(){
        List<Disciplina> disciplinas = centro.getDisciplinas();
        List<String> buscados = gestao.getTodasDisiciplinas();
        
        assertEquals(disciplinas.size(), buscados.size());
    }
    
    @Test
    public void testBuscarTodosDisciplinas(){
        List<Disciplina> disciplinas = centro.getDisciplinas();
        List<String> buscados = gestao.getTodasDisiciplinas();
        
        for (Disciplina disciplina : disciplinas) {
            String esperado = disciplina.getCodigo();
            
            assertTrue(buscados.contains(esperado));
        }
    }
    
    @Test
    public void testBuscarDisciplinasPorAluno(){
        Estudante estudante = centro.getEstudantes().get(0);
        List<Disciplina> disciplinas = estudante.getDisciplinasMatriculadas();
        List<String> ocorrido = gestao.getDisciplinasAluno(Long.toString(estudante.getId()));
        
        for (Disciplina disciplina : disciplinas) {
            String esperado = disciplina.getCodigo() + delimitador + disciplina.getCreditos();
            assertTrue(ocorrido.contains(esperado));
        }        
    }
    
    @Test
    public void testBuscarAlunosPorDisciplina(){
        Disciplina disciplina = centro.getDisciplinas().get(0);
        List<Estudante> estudantes = disciplina.getEstudantesMatriculados();
        List<String> ocorrido = gestao.getAlunosMatriculados(disciplina.getCodigo());
        
        for (Estudante estudante : estudantes) {
            String esperado = 
                estudante.getId() + delimitador + 
                estudante.getNome() + delimitador +
                estudante.getEmail() + delimitador +
                estudante.getTotalCreditos() + delimitador +
                estudante.getInfoComplementar();            
            assertTrue(ocorrido.contains(esperado));
        }        
    }
}
