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
public class    MemModel extends AbstractTableModel {

    ArrayList<String> linhas = new ArrayList<>();
    String[] Colunas={"Endereço","Valor"};
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return Colunas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1){
            case 0:
                return "&"+String.valueOf(i);
            case 1:
                return linhas.get(i);
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return this.Colunas[i];
    }

    public void setLinhas(ArrayList<String> linhas) {
        this.linhas = linhas;
    }
    
    
    
    
}
