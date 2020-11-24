/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import java.util.ArrayList;
import java.util.List;
import projeto_v1.Matricula;

/**
 *
 * @author dayprado
 */
public class EstudantePos extends Estudante {
    
    private final String tema; 
    private final String orientador;
    
    public EstudantePos(long id, String nome, String email, String tema, String orientador)
    {
        super(id, nome, email);
        this.tema = tema;
        this.orientador = orientador;
    }
    
    public String getTema(){
        return tema;
    }
    
    public String getOrientador(){
        return orientador;
    }
    
    @Override
    public int getTotalCreditos() {
        return super.getTotalCreditos();
    }
    
    @Override
    public String getInfoComplementar(){
        return this.getTema() + ": " + this.getOrientador();
    }
}
