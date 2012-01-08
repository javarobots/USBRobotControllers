/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.characterize;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.java.games.input.Component;

/**
 *
 * @author Parham
 */
public class CharacterizeTableModel extends AbstractTableModel {
    
    private String[] columnNames = {"Component", "Value"};
    private List<List<Object>> values;
    
    public CharacterizeTableModel(){
        List<Object> componentList = new ArrayList<Object>();
        List<Object> valueList = new ArrayList<Object>();
        values = new ArrayList<List<Object>>();
        values.add(componentList);
        values.add(valueList);
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return values.get(0).size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return values.get(columnIndex).get(rowIndex);
    }
    
    public void addControllerComponent(Component c){
        values.get(0).add(c.getName());
        values.get(1).add(new Float(0.00));
        fireTableDataChanged();
    }
    
}
