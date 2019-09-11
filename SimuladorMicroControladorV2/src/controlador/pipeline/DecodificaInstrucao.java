/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pipeline;
import controlador.*;

/**
 *
 * @author Windows
 */
public class DecodificaInstrucao {
    private static String[] dividir(String in){
        in = in.replace(",", "");
        return in.split(" ");
    }
    public static String[] dec(RegistradoresEspeciais RegE){
        String[] temp = dividir(RegE.getRi());
                
        switch (temp[0]){
            case "MOV":
                temp[0]="3";
                break;
            case "ADD":
                temp[0]="1";
                break;
            case "SUB":
                temp[0]="2";
                break;
            case "GOTO":
                temp[0]="4";
                break;
            case "JBE":
                temp[0]="5";
                break;
            case "JLE":
                temp[0]="6";
                break;
            }
        return temp;
    }
}
