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
    // Inicializa As Classes Necessárias
    //
    Memoria Mem = new Memoria(); 
    Registrador Reg = new Registrador();
    SReg sreg = new SReg();
    RegistradoresEspeciais RegE = new RegistradoresEspeciais();
    ArrayList<String> lista = null;
    int valor2;
    int posicao;
    
    //Construtores
    public Ula(String in) {
        Mem.setIntrucao(in);
    }
    public Ula(){
        
    }
    
    // Função para atualizar os registradores especiais.
    // também verifica se a proxima instrução está em branco ou contem "HALT".
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
    
    //Função que retorna O valor que está na memória. no registrador.
    //Ou o valor com # antes.
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
    
    // Divide a Instrução em um array de Strings
    // 1ª Intrução - ex MOV
    // 2ª Posição na memoria - ex R1
    // 3ª Valor ou posição - ex #4
    private String[] dividir(String in){
        in = in.replace(",", "");
        return in.split(" ");
    }
    
    
    // Função Simula o clock do Processador.
    public void rodar(){
        while(pulse());
    }
    
    // Função principal
    public boolean pulse(){
        boolean run = novaInstrucao(); // atualiza a intrução no RI e
        if (run){ // verifica se não é "HALT"
            String[] temp = dividir(RegE.getRi()); 
            
            // verifica se tem a 2ª String
            if (temp.length >= 2){ 
                if(temp[1].contains("R")){ // se tem R
                    this.lista = Reg.getReg(); // lista = registradores
                    this.posicao = Integer.valueOf(temp[1].replace("R", ""));
                }
                if(temp[1].contains("&")){ // se tem &
                    this.lista = Mem.getDado(); // lista = Memoria de dados
                    this.posicao = Integer.valueOf(temp[1].replace("&", ""));
                }       
            }
            
            // Se tem a 3ª String pega o valor das memorias.
            if (temp.length >=3){
                    valor2 = getValor(temp[2]);
            }
       
            // --- Decodificador
            // decodifica o 1ª String
            // sempre converte para inteiro para fazer o calculo
            // e sempre para Strig para devolver a memoria ou registradores.
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
            if(Integer.valueOf(lista.get(posicao))<0)
                sreg.setSreg(0,1);
            else
                sreg.setSreg(0,0);
            
            
            if(Integer.valueOf(lista.get(posicao))==0)
                sreg.setSreg(1,1);
            else
                sreg.setSreg(1, 0);
            return true;    // ainda se a intrução não for nula 
        }                   // retorna verdadeiro
            return false;   // senão falso
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
