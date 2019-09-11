/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pipeline;

import java.util.ArrayList;
import controlador.*;

/**
 *
 * @author Windows
 */
public class BuscaOperando {
    private static int getValor(String in,Memoria Mem, Registrador Reg){
        if (in.contains("R")){
            return Integer.valueOf(Reg.getReg().get(Integer.valueOf(in.replace("R", ""))));
        }
        if (in.contains("&")){
            return Integer.valueOf(Mem.getDado().get(Integer.valueOf(in.replace("&", ""))));
        }
        if (in.contains("#")){
            return Integer.valueOf(in.replace("#", ""));
        }
        return 0;        
    }
    
    public static ArrayList buscar(String[] temp, Memoria Mem, Registrador Reg){
        ArrayList a = new ArrayList();
        
        a.add(Integer.valueOf(temp[0]));
        
        // verifica se tem a 2ª String
            
        if (temp.length >= 2){ 
                if(temp[1].contains("R")){ // se tem R
                    a.add(Reg.getReg()); // lista = registradores
                    a.add( Integer.valueOf(temp[1].replace("R", "")));
                }
                if(temp[1].contains("&")){ // se tem &
                    a.add(Mem.getDado()); // lista = Memoria de dados
                    a.add(Integer.valueOf(temp[1].replace("&", "")));
                }
                if(temp[1].contains("#")){
                    a.add(Mem.getDado());
                    a.add(Integer.valueOf(temp[1].replace("#", "")));
                }
            }
            
            // Se tem a 3ª String pega o valor das memorias.
            if (temp.length >=3){
                    a.add(getValor(temp[2],Mem,Reg));
            }
        
        
        
        return a;
    }
}
