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
public class EstudanteGrad extends Estudante {
    
    private Integer horasAtividades;
    
    public EstudanteGrad(long id, String nome, String email, Integer horasAtividades) {
        super(id, nome, email);
        
        this.horasAtividades = horasAtividades;
    }
    
    public Integer getHoras(){
        return horasAtividades;
    }
    
    @Override
    public int getTotalCreditos() {
        int creditos = super.getTotalCreditos();
        return creditos + this.getHoras();
    }
    
    @Override
    public String getInfoComplementar(){
        return this.getHoras().toString();
    }
}
