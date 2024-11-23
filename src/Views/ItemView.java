package Views;

import Controllers.CategoryController;
import Controllers.ItemController;
import Models.Category;
import Models.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ItemView extends View {
    // Controller & Model Attribute
    private ItemController itemController;
    private Category categoryModel;
    // GUI Attributes
    private JTextField itemNameField;
    private JComboBox itemCategoryField;
    private JTextField itemSizeField;
    private JTextField itemPriceField;
    private JTextField itemStockField;
    private JButton submitItemButton;
    private JTable itemsTable;

    public ItemView(JTextField itemNameField, JComboBox itemCategoryField, JTextField itemSizeField, JTextField itemPriceField, JTextField itemStockField, JButton submitItemButton, JTable itemsTable, Category categoryModel) {
        this.itemNameField = itemNameField;
        this.itemCategoryField = itemCategoryField;
        this.itemSizeField = itemSizeField;
        this.itemPriceField = itemPriceField;
        this.itemStockField = itemStockField;
        this.submitItemButton = submitItemButton;
        this.itemsTable = itemsTable;
        this.categoryModel = categoryModel;

        this.submitItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) itemCategoryField.getSelectedItem();
                String categoryId = selectedCategory.substring(0, selectedCategory.indexOf(" - "));
                String[] data = {
                        categoryId,
                        itemNameField.getText(),
                        itemSizeField.getText(),
                        itemPriceField.getText(),
                        itemStockField.getText()
                };

                itemController.create(data);

                itemCategoryField.setSelectedItem("");
                itemNameField.setText("");
                itemSizeField.setText("");
                itemPriceField.setText("");
                itemStockField.setText("");
            }
        });
    }

    // Setters
    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    // Getters
    public JButton getSubmitItemButton() {
        return this.submitItemButton;
    }

    // Methods for setup table
    public void setupTable() {
        String[] tableColumnHeaders = {"No", "ID", "Name", "Category", "Size", "Price", "Stock", "Delete", "Edit"};
        DefaultTableModel tableModel = new DefaultTableModel(tableColumnHeaders, 0);
        this.itemsTable.setModel(tableModel);
    }

    public void setupInputField() {
        List<Object> categories = this.categoryModel.getAll();
        for (Object obj: categories) {
            if (obj instanceof Category) {
                Category category = (Category) obj;
                this.itemCategoryField.addItem(category.getId() + " - " + category.getName());
            }
        }
    }

    public void displayItems(List<Object> items) {
        DefaultTableModel categoriesTableModel = (DefaultTableModel) itemsTable.getModel();
        categoriesTableModel.setRowCount(0);

        int no = 1;
        for (Object obj : items) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                categoriesTableModel.addRow(new Object[] {
                        no++,
                        item.getId(),
                        item.getNama(),
                        item.getKategori(),
                        item.getUkuran(),
                        "IDR " + item.getHarga(),
                        item.getStok(),
                        "Delete",
                        "Edit"
                });
            }
        }
    }
}
