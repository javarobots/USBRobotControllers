/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.characterize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import net.java.games.input.Component;

/**
 * The table mode for the JTable shown in the characterize dialog
 * @author Parham
 */
public class CharacterizeTableModel extends AbstractTableModel {
    
    private String[] mColumnNames = {"Component", "Value"};
    private List<List<Object>> mValues;
    private Map<String,Integer> mComponentLookup;
    
    public CharacterizeTableModel(){
        List<Object> componentList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        mValues = new ArrayList<>();
        mValues.add(componentList);
        mValues.add(valueList);
        mComponentLookup = new HashMap<>();
    }
    
    @Override
    public String getColumnName(int column){
        return mColumnNames[column];
    }

    @Override
    public int getRowCount() {
        return mValues.get(0).size();
    }

    @Override
    public int getColumnCount() {
        return mColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return mValues.get(columnIndex).get(rowIndex);
    }
    
    @Override
    public void setValueAt(Object componentValue, int rowIndex, int columnIndex){
        mValues.get(columnIndex).set(rowIndex, componentValue);
        fireTableDataChanged();
    }
    
    /**
     * Adds a controller component to the model
     * @param c - the component
     */
    public void addControllerComponent(Component c){
        mValues.get(0).add(c.getName());
        mValues.get(1).add(new Float(0.00));
        mComponentLookup.put(c.getName(), mValues.get(0).size() - 1);
        fireTableDataChanged();
    }
    
    /**
     * Get the row component data is contained in
     * @param componentName - the name of the component
     * @return the row number
     */
    public int getComponentRow(String componentName){
        return mComponentLookup.get(componentName);
    }
    
}
