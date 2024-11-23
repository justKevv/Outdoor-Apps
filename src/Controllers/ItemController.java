package Controllers;

import Models.Item;
import Views.ItemView;

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
        this.refreshTable();
    }

    private void refreshTable() {
        List<Object> items = this.itemModel.getAll();
        this.itemView.displayItems(items);
    }
}
