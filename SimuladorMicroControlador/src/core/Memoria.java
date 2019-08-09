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
public class Memoria {
    private ArrayList<String> dado;
    private ArrayList<String> intrucao;

    public Memoria() {
        this.dado = new ArrayList<>();
        this.intrucao = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            dado.add("");
        }
        for (int i = 0; i < 64; i++) {
            intrucao.add("");
        }
    }

    public ArrayList<String> getDado() {
        return dado;
    }

    public void setDado(ArrayList<String> dado) {
        this.dado = dado;
    }

    public ArrayList<String> getIntrucao() {
        return intrucao;
    }

    public void setIntrucao(String in) {
        String[] a = in.split("\n");
        for (int i = 0; i < a.length; i++) {
            intrucao.set(i, a[i]);
        }
    }
    
    public String getInstruacao(int i){
        return this.intrucao.get(i);
    }
    
    
    
}
