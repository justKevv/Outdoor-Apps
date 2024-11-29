package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String URL = "jdbc:mysql://outdoor-quiz-pbo.e.aivencloud.com:10813/outdoor";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_nwGISMSemuzhPlsnkUf";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC tidak ditemukan!", e);
        }
    }
    
//    public static void main(String[] args) {
//        try (Connection connection = getConnection()) {
//            System.out.println("Koneksi berhasil!");
//        } catch (SQLException e) {
//            System.out.println("Koneksi gagal: " + e.getMessage());
//        }
//    }
}
