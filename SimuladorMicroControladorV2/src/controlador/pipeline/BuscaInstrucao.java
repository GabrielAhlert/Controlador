/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pipeline;

import controlador.Memoria;
import controlador.RegistradoresEspeciais;

/**
 *
 * @author Windows
 */
public class BuscaInstrucao {
    

// Função para atualizar os registradores especiais.
    // também verifica se a proxima instrução está em branco ou contem "HALT".
    
    public static boolean novaInstrucao(Memoria Mem, RegistradoresEspeciais RegE){
        if(Mem.getInstruacao(RegE.getCi()).equals("") ||
           Mem.getInstruacao(RegE.getCi()).contains(("HALT")) ||
           Mem.getInstruacao(RegE.getCi()).isEmpty()
           ){
            RegE.setRi("HALT");
            return false;
        }else{
            RegE.setRi(Mem.getInstruacao(RegE.getCiAi()));
            return true;
        }        
    }
}
