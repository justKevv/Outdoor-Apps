package Views;

import Controllers.CategoryController;
import Controllers.ItemController;
import Models.Category;
import Models.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ItemView extends View {
    // Controller Attribute
    private ItemController itemController;
    // GUI Attributes
    private JTextField itemNameField;
    private JComboBox itemCategoryField;
    private JTextField itemSizeField;
    private JTextField itemPriceField;
    private JTextField itemStockField;
    private JButton submitItemButton;
    private JTable itemsTable;

    public ItemView(JTextField itemNameField, JComboBox itemCategoryField, JTextField itemSizeField, JTextField itemPriceField, JTextField itemStockField, JButton submitItemButton, JTable itemsTable) {
        this.itemNameField = itemNameField;
        this.itemCategoryField = itemCategoryField;
        this.itemSizeField = itemSizeField;
        this.itemPriceField = itemPriceField;
        this.itemStockField = itemStockField;
        this.submitItemButton = submitItemButton;
        this.itemsTable = itemsTable;
    }

    // Setters
    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    // Methods for setup table
    public void setupTable() {
        String[] tableColumnHeaders = {"No", "ID", "Name", "Category", "Size", "Price", "Stock", "Delete", "Edit"};
        DefaultTableModel tableModel = new DefaultTableModel(tableColumnHeaders, 0);
        this.itemsTable.setModel(tableModel);
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
