package Controllers;

import Models.Item;
import Views.ItemView;

import javax.swing.*;
import java.util.List;

public class ItemController extends Controller {
    private ItemView itemView;
    private Item itemModel;

    public ItemController(ItemView itemView, Item itemModel) {
        this.itemView = itemView;
        this.itemModel = itemModel;
        this.index();
    }

    @Override
    public void index() {
        this.itemView.setupTable();
        this.itemView.setupInputField();
        this.refreshTable();
    }

    @Override
    public void create(String[] data) {
        if (this.itemModel.create(data)) {
            JOptionPane.showMessageDialog(this.itemView.getSubmitItemButton(), "Item successfully created!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this.itemView.getSubmitItemButton(), "Item failed to create!");
        }
    }

    private void refreshTable() {
        List<Object> items = this.itemModel.getAll();
        this.itemView.displayItems(items);
    }
}
