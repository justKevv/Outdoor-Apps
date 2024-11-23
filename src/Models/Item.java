package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Item extends Model {
    private int id;
    private String kategori;
    private String nama;
    private String ukuran;
    private String harga;
    private String stok;

    public Item(Connection dbConnection) {
        super.setDbConnection(dbConnection);
    }

    public Item(int id, String kategori, String nama, String ukuran, String harga, String stok) {
        this.id = id;
        this.kategori = kategori;
        this.nama = nama;
        this.ukuran = ukuran;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() {
        return this.id;
    }

    public String getKategori() {
        return this.kategori;
    }

    public String getNama() {
        return this.nama;
    }

    public String getUkuran() {
        return this.ukuran;
    }

    public String getHarga() {
        return this.harga;
    }

    public String getStok() {
        return this.stok;
    }

    @Override
    public List<Object> getAll() {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return new ArrayList<>();
        }

        List<Object> items = new ArrayList<>();
        String query = "SELECT barang.id, barang.nama, kategori.nama AS kategori, barang.ukuran, barang.harga, barang.stok FROM barang INNER JOIN kategori ON kategori.id = barang.id_kategori";
        try (Statement statement = super.getDbConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String kategori = resultSet.getString("kategori");
                String nama = resultSet.getString("nama");
                String ukuran = resultSet.getString("ukuran");
                String harga = resultSet.getString("harga");
                String stok = resultSet.getString("stok");
                items.add(new Item(id, kategori, nama, ukuran, harga, stok));
            }
        } catch (SQLException error) {
            System.out.println("Error occurred when getting barang data: " + error.getMessage());
        }

        return items;
    }

    @Override
    public boolean create(String[] data) {
        if (super.getDbConnection() == null) {
            System.out.println("Database connection is null from Model.");
            return false;
        }

        String query = "INSERT INTO barang(id_kategori, nama, ukuran, harga, stok) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = super.getDbConnection().prepareStatement(query)) {
            preparedStatement.setString(1, data[0]);
            preparedStatement.setString(2, data[1]);
            preparedStatement.setString(3, data[2]);
            preparedStatement.setString(4, data[3]);
            preparedStatement.setString(5, data[4]);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException error) {
            System.out.println("Error occurred when inserting barang data: " + error.getMessage());
        }

        return false;
    }
}
