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
public class Registrador {
    private ArrayList<String> reg = new ArrayList<>();

    public Registrador() {
        for (int i = 0; i < 8; i++) {
            reg.add("");
        }
    }

    public ArrayList<String> getReg() {
        return reg;
    }

    public void setReg(ArrayList<String> reg) {
        this.reg = reg;
    }
    
    
    

}
