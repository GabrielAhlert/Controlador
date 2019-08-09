/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class Ula {
    Memoria Mem = new Memoria();
    Registrador Reg = new Registrador();
    RegistradoresEspeciais RegE = new RegistradoresEspeciais();
    ArrayList<String> lista = null;
    int valor2;
    int posicao;
    

    public Ula(String in) {
        Mem.setIntrucao(in);
    }
    public Ula(){
        
    }
    
    private boolean novaInstrucao(){
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
    
    private int getValor(String in){
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
    
    
    
    public void rodar(){
        while(pulse());
    }
    
    public boolean pulse(){
        boolean run = novaInstrucao();
        if (run){
            String[] temp = dividir(RegE.getRi());
            if (temp.length >= 2){
                if(temp[1].contains("R")){
                    this.lista = Reg.getReg();
                    this.posicao = Integer.valueOf(temp[1].replace("R", ""));
                }
                if(temp[1].contains("&")){
                    this.lista = Mem.getDado();
                    this.posicao = Integer.valueOf(temp[1].replace("&", ""));
                }       
            }
            
            if (temp.length >=3){
                    valor2 = getValor(temp[2]);
            }
            
            switch (temp[0]){
                case "MOV":
                    lista.set(posicao, String.valueOf(valor2));
                    break;
                case "ADD":
                    lista.set(posicao,String.valueOf(
                        Integer.valueOf(lista.get(posicao))+valor2));
                    break;
                case "SUB":
                    lista.set(posicao,String.valueOf(
                        Integer.valueOf(lista.get(posicao))-valor2));
                    break;
                case "GOTO":
                    RegE.setCi(Integer.valueOf(temp[1]));
                    break;
                case "JBE":
                    if(Integer.valueOf(lista.get(posicao))>= valor2)
                        RegE.cipp();
                    break;
                case "JLE":
                    if(Integer.valueOf(lista.get(posicao))>= valor2)
                        RegE.cipp();
                    break;
                   
            }
            return true;
        }
            return false;
    }
    
    private String[] dividir(String in){
        in = in.replace(",", "");
        return in.split(" ");
    } 
    
    
    

    public Memoria getMem() {
        return Mem;
    }

    public Registrador getReg() {
        return Reg;
    }

    public RegistradoresEspeciais getRegE() {
        return RegE;
    }
    
    
    
    
}
