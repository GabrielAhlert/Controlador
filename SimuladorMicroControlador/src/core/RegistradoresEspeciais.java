/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Windows
 */
public class RegistradoresEspeciais {
    private int ci=0;
    private String ri = "";

    public RegistradoresEspeciais() {
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }
    
    public int getCiAi() {
        ci++;
        return ci-1;
    }
    
    public void cipp(){
        ci++;
    }

    
    
    
}
