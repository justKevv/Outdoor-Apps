package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category extends Model {
    private int id;
    private String name;

    public Category() {

    }

    public Category(Connection dbConnection) {
        super.setDbConnection(dbConnection);
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return String.valueOf(this.id);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public List<Object> getAll() {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return new ArrayList<>();
        }

        List<Object> categories = new ArrayList<>();
        String query = "SELECT * FROM kategori";
        try (Statement statement = super.getDbConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nama");
                categories.add(new Category(id, name));
            }
        } catch (SQLException error) {
            System.out.println("Error occurred when getting kategori data: " + error.getMessage());
        }

        return categories;
    }

    @Override
    public Object getById(String id) {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from model.");
            return null;
        }

        Category category = null;
        String query = "SELECT * FROM kategori WHERE id = ?";

        try (PreparedStatement preparedStatement = super.getDbConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int categoryId = resultSet.getInt("id");
                    String name = resultSet.getString("nama");
                    category = new Category(categoryId, name);
                }
            }
        } catch (SQLException error) {
            System.out.println("Error occurred when getting kategori data: " + error.getMessage());
        }

        return category;
    }

    @Override
    public boolean create(String[] data) {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return false;
        }

        String query = "INSERT INTO kategori(nama) VALUES(?)";
        try (PreparedStatement preparedStatement = super.getDbConnection().prepareStatement(query)) {
            preparedStatement.setString(1, data[1]);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException error) {
            System.out.println("Error occurred when inserting kategori data: " + error.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(String[] data) {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return false;
        }

        if (data == null || data.length < 2) {
            System.out.println("Invalid arguments. Expected at least 2 elements: [name, id]");
            return false;
        }

        String query = "UPDATE kategori SET nama = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = super.getDbConnection().prepareStatement(query)) {
            preparedStatement.setString(1, data[1]);
            preparedStatement.setString(2, data[0]);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true jika ada baris yang terpengaruh
        } catch (SQLException error) {
            System.out.println("Error occurred when updating kategori data: " + error.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return false;
        }

        if (id == null || id.trim().isEmpty()) {
            System.out.println("Invalid ID provided for deletion.");
            return false;
        }

        String query = "DELETE FROM kategori WHERE id = ?";
        try (PreparedStatement preparedStatement = super.getDbConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException error) {
            System.out.println("Error occurred when deleting kategori data: " + error.getMessage());
        }

        return false;
    }
}
