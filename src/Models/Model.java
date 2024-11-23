package Models;

import java.sql.Connection;
import java.util.List;

public class Model {
    private Connection dbConnection;

    // Getters
    public Connection getDbConnection() {
        return this.dbConnection;
    }

    // Setters
    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Methods for DB
    public List<Object> getAll() {
        return null;
    }

    public Object getById(String id) {
        return null;
    }

    public boolean create(String[] data) {
        return false;
    }

    public boolean update(String[] data) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }
}
