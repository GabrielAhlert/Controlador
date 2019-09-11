/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import controlador.pipeline.*;

/**
 *
 * @author Windows
 */
public class Processador {
    // Inicializa As Classes Necessárias
    //
    Memoria Mem = new Memoria(); 
    Registrador Reg = new Registrador();
    SReg sreg = new SReg();
    RegistradoresEspeciais RegE = new RegistradoresEspeciais();

    
    //Construtores
    public Processador(String in) {
        Mem.setIntrucao(in);
    }
    public Processador(){
        
    }
    

    // Função Simula o clock do Processador.
    public void rodar(){
        while(pulse());
    }
    
    // Função principal
    public boolean pulse(){
        boolean run = BuscaInstrucao.novaInstrucao(Mem,RegE); // atualiza a intrução no RI e
        if(run){
            String[] dec = DecodificaInstrucao.dec(RegE);
            ArrayList bus = BuscaOperando.buscar(dec, Mem, Reg);
            boolean ex = ExecutaInstrucao.exe(bus,RegE,sreg);
            return ex;
        }
        return false;
        
    } 
    
    // --------------------
    // Geters das Classes
    
    public Memoria getMem() {
        return Mem;
    }

    public SReg getSreg() {
        return sreg;
    }
    

    public Registrador getReg() {
        return Reg;
    }

    public RegistradoresEspeciais getRegE() {
        return RegE;
    }
    
    // -----------------------
    
    
}
