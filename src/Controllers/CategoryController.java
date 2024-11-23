package Controllers;

import Models.Category;
import Views.CategoryView;

import javax.swing.*;
import java.util.List;

public class CategoryController extends Controller {
    private CategoryView categoryView;
    private Category categoryModel;

    public CategoryController(CategoryView categoryView, Category categoryModel) {
        this.categoryView = categoryView;
        this.categoryModel = categoryModel;
        this.index();
    }

    @Override
    public void index() {
        this.categoryView.setupTable();
        this.refreshCategoriesTable();
    }

    @Override
    public Category show(String id) {
        return (Category) this.categoryModel.getById(id);
    }

    @Override
    public void create(String[] data) {
        if (this.categoryModel.create(data)) {
            JOptionPane.showMessageDialog(this.categoryView.getSubmitCategoryButton(), "Category successfully created!");
            refreshCategoriesTable();
        } else {
            JOptionPane.showMessageDialog(this.categoryView.getSubmitCategoryButton(), "Category failed to create!");
        }
    }

    @Override
    public void update(String id, String[] data) {
        if (this.categoryModel.update(data)) {
            JOptionPane.showMessageDialog(this.categoryView.getSubmitCategoryButton(), "Category successfully updated!");
            refreshCategoriesTable();
        } else {
            JOptionPane.showMessageDialog(this.categoryView.getSubmitCategoryButton(), "Category failed to update!");
        }
    }

    @Override
    public void delete(String id) {
        if (this.categoryModel.delete(id)) {
            JOptionPane.showMessageDialog(this.categoryView.getCategoriesTable(), "Category successfully deleted!");
            refreshCategoriesTable();
        } else {
            JOptionPane.showMessageDialog(this.categoryView.getCategoriesTable(), "Category failed to delete!");
        }
    }

    private void refreshCategoriesTable() {
        List<Object> categories = this.categoryModel.getAll();
        this.categoryView.displayCategories(categories);
    }
}
