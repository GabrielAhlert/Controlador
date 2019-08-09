/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Windows
 */
public class RegModel extends AbstractTableModel{
    
    String[] colunas = {"Endereço","Valor"};
    ArrayList<String> linhas = new ArrayList();
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1){
            case 0:
                return "R"+String.valueOf(i);
            case 1:
                return linhas.get(i);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int i) {
        return this.colunas[i];
    }

    public void setLinhas(ArrayList<String> linhas) {
        this.linhas = linhas;
    }
    

    
    
}
