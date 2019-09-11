/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pipeline;

import controlador.RegistradoresEspeciais;
import controlador.SReg;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class ExecutaInstrucao {
    public static boolean exe(ArrayList inst,RegistradoresEspeciais RegE,SReg sreg){
        ArrayList<String> lista = (ArrayList) inst.get(1);
        int pos = (Integer)inst.get(2);
        
        switch((Integer)inst.get(0)){
            case 1:
                lista.set(pos, String.valueOf(Integer.valueOf(lista.get(pos))+(int)inst.get(3)));
                break;
            case 2:
                lista.set(pos, String.valueOf(Integer.valueOf(lista.get(pos))-(int)inst.get(3)));
                break;
            case 3:
                lista.set(pos, String.valueOf((int)inst.get(3)));
                break;
            case 4:
                RegE.setCi(pos);
                break;
            case 5:
                if(Integer.valueOf(lista.get(pos))>=(int)inst.get(3)){
                    RegE.cipp();
                }
                break;
            case 6:
                if(Integer.valueOf(lista.get(pos))<=(int)inst.get(3)){
                    RegE.cipp();
                }
                break;
            default:
                return false;
        }
        
        try{
            if(Integer.valueOf(lista.get(pos))<0)
                sreg.setSreg(0,1);
            else
                sreg.setSreg(0,0);
            
            
            if(Integer.valueOf(lista.get(pos))==0)
                sreg.setSreg(1,1);
            else
                sreg.setSreg(1, 0);
        }catch(Exception ex){
            //System.out.println(ex);
        }
        return true;
    }
}
