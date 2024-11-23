/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 *
 * @author LENOVO
 */
public class Connect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        String host, port, databaseName, userName, password;
        host = "outdoor-quiz-pbo.e.aivencloud.com";
        port = "10813";
        databaseName = "defaultdb";
        userName = "avnadmin";
        password = "AVNS_nwGISMSemuzhPlsnkUf";
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i].toLowerCase(Locale.ROOT)) {
                case "-host":
                    host = args[++i];
                    break;
                case "-username":
                    userName = args[++i];
                    break;
                case "-password":
                    password = args[++i];
                    break;
                case "-database":
                    databaseName = args[++i];
                    break;
                case "-port":
                    port = args[++i];
                    break;
            }
        }
        // JDBC allows to have nullable username and password
        if (host == null || port == null || databaseName == null) {
            System.out.println("Host, port, database information is required");
            return;
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (final Connection connection
                = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?sslmode=require", userName, password); final Statement statement = connection.createStatement(); final ResultSet resultSet = statement.executeQuery("SELECT version() AS version")) {

            while (resultSet.next()) {
                System.out.println("Connection Succesful");
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }


    }

}
