package Views;

import Controllers.CategoryController;
import Helpers.TableButtonEditor;
import Helpers.TableButtonRenderer;
import Models.Category;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CategoryView extends View {
    // Controller Attribute
    private CategoryController categoryController;
    // GUI Attributes
    private JLabel categoryFormTitle;
    private JLabel categoryNameLabel;
    private JTextField categoryNameField;
    private JTextField categoryIdField;
    private JButton submitCategoryButton;
    private JScrollPane categoriesTableSP;
    private JTable categoriesTable;

    public CategoryView(JLabel categoryFormTitle, JLabel categoryNameLabel, JTextField categoryNameField, JTextField categoryIdField, JButton submitCategoryButton, JScrollPane categoriesTableSP, JTable categoriesTable) {
        this.categoryFormTitle = categoryFormTitle;
        this.categoryNameLabel = categoryNameLabel;
        this.categoryNameField = categoryNameField;
        this.categoryIdField = categoryIdField;
        this.submitCategoryButton = submitCategoryButton;
        this.categoriesTableSP = categoriesTableSP;
        this.categoriesTable = categoriesTable;

        this.submitCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = {
                        categoryIdField.getText(),
                        categoryNameField.getText()
                };

                if (submitCategoryButton.getText().equals("Update")) {
                    categoryController.update(data[0], data);
                    submitCategoryButton.setText("Create");
                } else {
                    categoryController.create(data);
                }

                categoryNameField.setText("");
                categoryIdField.setText("");
            }
        });
    }

    // Getters
    public JButton getSubmitCategoryButton() {
        return this.submitCategoryButton;
    }

    public JTable getCategoriesTable() {
        return this.categoriesTable;
    }

    // Setters
    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    // Methods for setup table
    public void setupTable() {
        String[] categoriesTableColumnHeaders = {"No", "ID", "Name", "Delete", "Edit"};
        DefaultTableModel categoriesTableModel = new DefaultTableModel(categoriesTableColumnHeaders, 0);
        this.categoriesTable.setModel(categoriesTableModel);
        this.setupAdditionalActionButtons();
    }

    public void displayCategories(List<Object> categories) {
        DefaultTableModel categoriesTableModel = (DefaultTableModel) categoriesTable.getModel();
        categoriesTableModel.setRowCount(0);

        int no = 1;
        for (Object obj : categories) {
            if (obj instanceof Category) {
                Category category = (Category) obj;
                categoriesTableModel.addRow(new Object[]{
                        no++,
                        category.getId(),
                        category.getName(),
                        "Delete",
                        "Edit"
                });
            }
        }
    }

    @Override
    protected void setupAdditionalActionButtons() {
        System.out.println("Setup Categories table action buttons");
        // Setup Delete button
        categoriesTable.getColumnModel().getColumn(3).setCellRenderer(new TableButtonRenderer("Delete"));
        categoriesTable.getColumnModel().getColumn(3).setCellEditor(new TableButtonEditor(categoriesTable, "Delete", e -> {
            int row = categoriesTable.getSelectedRow();

            if (row >= 0) {
                Object idValue = categoriesTable.getModel().getValueAt(row, 1);
                String id = idValue.toString();

                categoryController.delete(id);
            } else {
                JOptionPane.showMessageDialog(categoriesTable, "No row selected!");
            }
        }));

        // Setup Edit button
        categoriesTable.getColumnModel().getColumn(4).setCellRenderer(new TableButtonRenderer("Edit"));
        categoriesTable.getColumnModel().getColumn(4).setCellEditor(new TableButtonEditor(categoriesTable, "Edit", e -> {
            int row = categoriesTable.getSelectedRow();

            if (row >= 0) {
                Object idValue = categoriesTable.getModel().getValueAt(row, 1);
                String id = idValue.toString();

                Category category = (Category) categoryController.show(id);
                if (category != null) {
                    this.categoryIdField.setText(category.getId());
                    this.categoryNameField.setText(category.getName());
                    this.submitCategoryButton.setText("Update");
                } else {
                    JOptionPane.showMessageDialog(categoriesTable, "Category not found!");
                }
            } else {
                JOptionPane.showMessageDialog(categoriesTable, "No row selected!");
            }
        }));
    }
}
