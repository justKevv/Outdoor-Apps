package Helpers;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private String actionType;
    private int row;

    public TableButtonEditor(JTable table, String actionType, ActionListener actionListener) {
        this.actionType = actionType;

        button = new JButton(actionType);
        button.setOpaque(true);
        button.addActionListener((e) -> {
            actionListener.actionPerformed(new ActionEvent(table, ActionEvent.ACTION_PERFORMED, actionType + '-' + row));
            // fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
