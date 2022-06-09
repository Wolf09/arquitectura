/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.awt.Component;
import java.awt.Font;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author root
 */
public class MyEditor extends AbstractCellEditor implements TableCellEditor { 
 
    JTextArea comp;
 
    public MyEditor () {
        comp = new JTextArea();
    }
 
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
            String v= value.toString();
            comp.setFont (new Font("Lucida Grande", Font.PLAIN, 11)); 
            comp.setLineWrap(true);
            comp.setWrapStyleWord(true);
            comp.setEditable(false);
            comp.setText(v);
 
        return comp;
    }
 
    public Object getCellEditorValue() {
        return ((JTextArea)comp).getText();
    }
} 
    
